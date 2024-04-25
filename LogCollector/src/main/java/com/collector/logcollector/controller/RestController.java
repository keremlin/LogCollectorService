package com.collector.logcollector.controller;

import com.collector.logcollector.dto.FullTextSearchResponseDTO;
import com.collector.logcollector.dto.LogRequestDTO;
import com.collector.logcollector.dto.LogResponseDTO;
import com.collector.logcollector.services.LogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/log")
public class RestController {
    private LogService logService;

    @Autowired
    public void setLogService(LogService logService){
        this.logService=logService;
    }

    @PostMapping("/addLog")
    public ResponseEntity<LogResponseDTO> addLog(@Valid @RequestBody LogRequestDTO log) {
        LogResponseDTO logResponseDTO = new LogResponseDTO();
        String refID=logService.saveLog(log);
        logResponseDTO.setRefID(refID);
        return ResponseEntity.ok().body(logResponseDTO);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<FullTextSearchResponseDTO> fullTextSearch(@PathVariable String keyword){
        return ResponseEntity.ok().body(
               logService.fullTextSearch(keyword)
        );
    }

}
