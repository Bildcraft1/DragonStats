package com.whixad.dragonstatistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.UUID;

@Document(collection = "player_statistics")
public class TimeStamp {
    @Id
    @Indexed
    UUID id;
    @Field
    Instant time;
    @Field
    Integer player;

    public TimeStamp(UUID id, Instant time, Integer player) {
        this.id = id;
        this.time = time;
        this.player = player;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public Integer getPlayer() {
        return player;
    }

    public void setPlayer(Integer player) {
        this.player = player;
    }

    public TimeStamp() {

    }
}