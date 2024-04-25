package com.collector.logcollector.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvise {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(KeywordNotFoundException.class)
    public String handleKeywordNotFound(KeywordNotFoundException ex) {
        log.error(ex.getMessage());
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(KeywordIsNullException.class)
    public String handleKeywordIsNullException(KeywordIsNullException ex) {
        log.error(ex.getMessage());
        return ex.getMessage();
    }
}