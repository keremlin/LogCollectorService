package com.collector.logcollector.feign;

import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    @Bean
    public ErrorDecoder getDecoder(){return  new LogErrorDecoder();}
    @Bean
    public Retryer getRetry(){return new Retry();}
}
