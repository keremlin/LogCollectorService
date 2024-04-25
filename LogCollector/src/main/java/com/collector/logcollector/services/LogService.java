package com.collector.logcollector.services;

import com.collector.logcollector.dto.FullTextSearchResponseDTO;
import com.collector.logcollector.dto.LogRequestDTO;

public interface LogService {

    public abstract String saveLog(LogRequestDTO logRequestDTO);
    public abstract FullTextSearchResponseDTO fullTextSearch(String keyword);
}
