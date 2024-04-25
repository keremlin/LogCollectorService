package com.collector.logcollector.controller;

import com.collector.logcollector.services.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
@Slf4j
public class JobController {
    ProcessService processService;

    @Autowired
    public void setProcessService(ProcessService processService) {
        this.processService = processService;
    }

    @Async
    @Scheduled(fixedDelay = 10000)
    public void sendToProcessor() {
        log.info("Job processor is triggered ");
        processService.sendToProcess();
    }
}
