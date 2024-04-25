package com.collector.logcollector.feign;

import com.collector.logcollector.dto.ProcessRequestDTO;
import com.collector.logcollector.dto.ProcessResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "processor", url = "localhost:9090/api/log/")
public interface ProcessLog {
    @RequestMapping(method = RequestMethod.POST, value = "/process", consumes = "application/json")
    ProcessResultDTO sendProcess(ProcessRequestDTO processRequestDTO);
}
