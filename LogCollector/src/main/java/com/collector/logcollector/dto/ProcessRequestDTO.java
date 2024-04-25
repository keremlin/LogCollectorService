package com.collector.logcollector.dto;

import com.collector.logcollector.entities.LogType;
import lombok.Data;

@Data
public class ProcessRequestDTO {
    String body;
    String serviceName;
    LogType type;
    String defId;
}
