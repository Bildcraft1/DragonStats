package com.whixard.dragonstatistics;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final StatisticsRepository statisticsRepository;

    public PlayerController(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @PostMapping
    public void players(@RequestParam(value = "players", defaultValue = "0") int players) {
        statisticsRepository.save(new TimeStamp(UUID.randomUUID(), Instant.now(), players));
    }

    @GetMapping("/average")
    public List<TimeStamp> averagePlayers() {
        return statisticsRepository.findByTimeBetween(Instant.now().minusSeconds(10800), Instant.now());
    }

    @GetMapping("/day")
    public List<TimeStamp> dayPlayers() {
        return statisticsRepository.findByTimeBetween(Instant.now().minusSeconds(86400), Instant.now());
    }

    @GetMapping("/all")
    public List<TimeStamp> allPlayers() {
        return statisticsRepository.findAll();
    }
}