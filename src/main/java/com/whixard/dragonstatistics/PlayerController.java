package com.whixard.dragonstatistics;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @GetMapping("/hourly")
    public List<PlayerCount> dayPlayersSamples(@RequestParam long time) {
        return statisticsRepository.findByTimeBetween(Instant.now().minusSeconds(time), Instant.now()).stream()
                .collect(Collectors.groupingBy(t -> t.getTime().truncatedTo(ChronoUnit.HOURS)))
                .entrySet()
                .stream()
                .map(e -> new PlayerCount(e.getKey(), e.getValue().stream().mapToDouble(TimeStamp::getPlayer).average().orElse(0D)))
                .sorted(Comparator.comparingLong(p -> p.time().getEpochSecond()))
                .toList();
    }

    @GetMapping("/last")
    public int allPlayers() {
        return statisticsRepository.findAll().stream().findAny().map(TimeStamp::getPlayer).orElse(0);
    }
}