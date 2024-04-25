package com.collector.logcollector.repositories;

import com.collector.logcollector.entities.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LogRepo extends CrudRepository<Log, String> {
    List<Log> findAll();
    List<Log> findTop1ByProcessed(boolean processed);

    @Query("SELECT a FROM Log a WHERE " +
            "LOWER(a.body) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.serviceName) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.type) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.requestId) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Log> findLogsByKeyword(@Param("searchText") String searchText);
}
