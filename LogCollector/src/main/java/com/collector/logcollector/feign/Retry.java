package com.collector.logcollector.feign;

import feign.RetryableException;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Retry implements Retryer {
    @Override
    public void continueOrPropagate(RetryableException e) {
        log.info("Retry the feign");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw e;
        }
    }

    @Override
    public Retryer clone() {
        return new Retry();
    }
}