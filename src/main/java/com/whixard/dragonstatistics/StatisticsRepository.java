package com.whixard.dragonstatistics;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface StatisticsRepository extends MongoRepository<TimeStamp, UUID> {
    List<TimeStamp> findByTimeBetween(Instant start, Instant end);
    @Aggregation(pipeline = {
            "{ '$limit' : 1 }"
    })
    List<TimeStamp> findAll();
}
