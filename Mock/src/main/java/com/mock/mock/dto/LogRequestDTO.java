package com.mock.mock.dto;


import lombok.Data;

@Data
public class LogRequestDTO {

    String body;
    String serviceName;
    String type;
    String defId;
}
