package com.collector.logcollector.services;

import com.collector.logcollector.dto.ProcessRequestDTO;
import com.collector.logcollector.entities.Log;
import com.collector.logcollector.repositories.LogRepo;
import com.collector.logcollector.feign.ProcessLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Slf4j
public class ProcessServiceImpl implements ProcessService{
    private LogRepo logRepo;

    @Autowired
    public void setLogRepo(LogRepo logRepo) {
        this.logRepo = logRepo;
    }

    ProcessLog processLog;

    @Autowired
    public void setProcessLog(ProcessLog processLog){
        this.processLog=processLog;
    }
    @Override
    public void sendToProcess() {
        List<Log> logs=logRepo.findTop1ByProcessed(false);
        if(logs.size()!=0){
            for (Log item:logs) {
                processLog.sendProcess(convert(item));
                log.info("The log {} was sent to processor",item.getID());
                item.setProcessed(true);
                logRepo.save(item);
                log.info("The log {} status was changed to true", item.getID());
            }
        }
    }
    private static ProcessRequestDTO convert(Log logItem){
        ProcessRequestDTO processRequestDTO = new ProcessRequestDTO();
        processRequestDTO.setBody(logItem.getBody());
        processRequestDTO.setServiceName(logItem.getServiceName());
        processRequestDTO.setDefId(logItem.getID());
        processRequestDTO.setType(logItem.getType());
        return processRequestDTO;
    }
}
