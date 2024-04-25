package com.collector.logcollector.feign;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        FeignException exception = feign.FeignException.errorStatus(methodKey, response);
        if(response.status()==400 ||response.status()==403 ||response.status()==500) {
            return new RetryableException(response.status(),"exception on feign",
                    response.request().httpMethod(), (Throwable) exception, (Long) null,response.request());
        }
        return new Exception("error on calling processor application");
    }
}