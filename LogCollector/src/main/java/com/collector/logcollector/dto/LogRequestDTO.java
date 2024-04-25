package com.collector.logcollector.dto;

import com.collector.logcollector.entities.LogType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LogRequestDTO {

    @NotBlank(message = "Log Body is mandatory")
    @Size(min = 10,max = 1000)
    String body;

    @NotBlank(message = "serviceName is mandatory")
    @Size(min = 5,max = 30)
    String serviceName;

    LogType type;
}
