package com.collector.logcollector.dto;


import lombok.Data;

@Data
public class ProcessResultDTO {
    String message;
    boolean state;
    String defId;
}
