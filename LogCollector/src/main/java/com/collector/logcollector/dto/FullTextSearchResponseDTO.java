package com.collector.logcollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FullTextSearchResponseDTO {

    List<LogDocument> logs;
}
