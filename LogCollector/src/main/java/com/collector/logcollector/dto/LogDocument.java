package com.collector.logcollector.dto;

import com.collector.logcollector.entities.LogType;
import lombok.Data;

@Data
public class LogDocument {
    String body;
    LogType type;
    String serviceName;
}
