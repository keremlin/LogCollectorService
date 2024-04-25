package com.mock.mock;

import com.mock.mock.dto.LogRequestDTO;
import com.mock.mock.dto.ProcessResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/log")
public class RestMockController {
    @PostMapping("/process")
    public ResponseEntity<ProcessResultDTO> process(@RequestBody LogRequestDTO logItem){

        ProcessResultDTO processResultDTO=new ProcessResultDTO();
        processResultDTO.setDefId(logItem.getDefId());
        processResultDTO.setState(true);
        processResultDTO.setMessage("OK");
        log.info("the log is processed with id : {}",processResultDTO.getDefId());
        return ResponseEntity.ok().body(processResultDTO);
        //return ResponseEntity.badRequest().body(processResultDTO);
    }
}
