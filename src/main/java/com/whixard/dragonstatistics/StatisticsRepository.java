package com.whixad.dragonstatistics;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface StatisticsRepository extends MongoRepository<TimeStamp, UUID> {
    List<TimeStamp> findByTimeBetween(Instant start, Instant end);
}
