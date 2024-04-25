package com.collector.logcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LogCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogCollectorApplication.class, args);
    }

}
