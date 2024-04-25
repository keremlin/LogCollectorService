package com.collector.logcollector.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String ID;

    @NotBlank(message = "nin is mandatory")
    @Size(min = 10,max = 1000)
    String body;

    LocalDateTime createdAt;

    String serviceName;

    String requestId;
    @Enumerated(EnumType.STRING)
    LogType type;

    boolean processed;

}
