package com.collector.logcollector.services;

import com.collector.logcollector.dto.FullTextSearchResponseDTO;
import com.collector.logcollector.dto.LogDocument;
import com.collector.logcollector.dto.LogRequestDTO;
import com.collector.logcollector.entities.Log;
import com.collector.logcollector.exception.KeywordIsNullException;
import com.collector.logcollector.exception.KeywordNotFoundException;
import com.collector.logcollector.repositories.LogRepo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LogServiceImpl implements LogService {

    private LogRepo logRepo;

    @Autowired
    public void setLogRepo(LogRepo logRepo) {
        this.logRepo = logRepo;
    }

    @Override
    @Transactional
    public String saveLog(LogRequestDTO logRequestDTO) {
        Log logItem = convertToLog(logRequestDTO);
        logRepo.save(logItem);
        log.info("Log request is being created with id : {}", logItem.getID());
        return logItem.getID();
    }

    @Override
    public FullTextSearchResponseDTO fullTextSearch(String keyword) {
        checkIfKeywordIsNull(keyword);
        log.info("Search for started : {}", keyword);
        List<LogDocument> list = new ArrayList();
        for (Log log :
                logRepo.findLogsByKeyword(keyword)) {
            list.add(convertLog(log));
        }
        log.info("Search for '{}' has {} records", keyword, list.size());
        checkIfKeywordNotFound(list);
        return new FullTextSearchResponseDTO(list);
    }
    private static void checkIfKeywordIsNull(String keyword){
        if( keyword==null || keyword=="") throw new KeywordIsNullException();
    }

    private static void checkIfKeywordNotFound(List list) {
        if (list.size() == 0) throw new KeywordNotFoundException("keyword not found in logs");
    }

    private static LogDocument convertLog(Log log) {
        LogDocument logDocument = new LogDocument();
        logDocument.setBody(log.getBody());
        logDocument.setType(log.getType());
        logDocument.setServiceName(log.getServiceName());
        return logDocument;
    }

    private static Log convertToLog(LogRequestDTO logRequestDTO) {
        Log logItem = new Log();
        logItem.setBody(logRequestDTO.getBody());
        logItem.setType(logRequestDTO.getType());
        logItem.setProcessed(false);
        logItem.setServiceName(logRequestDTO.getServiceName());
        logItem.setCreatedAt(LocalDateTime.now());
        return logItem;
    }
}
