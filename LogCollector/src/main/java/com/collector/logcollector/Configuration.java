package com.collector.logcollector;

import com.collector.logcollector.services.LogService;
import com.collector.logcollector.services.LogServiceImpl;
import com.collector.logcollector.services.ProcessService;
import com.collector.logcollector.services.ProcessServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@org.springframework.context.annotation.Configuration
@EnableScheduling
public class Configuration {
    @Bean
    public LogService getLogServiceBean(){
        return new LogServiceImpl();
    }
    @Bean
    public ProcessService getProcessService(){
        return new ProcessServiceImpl();
    }
}
