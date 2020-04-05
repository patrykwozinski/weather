package com.example.weather.domain;

import com.example.blocks.domain.Event;

import java.util.UUID;

public final class WeatherRecorded implements Event {
    private final UUID id;
    private final UUID weatherId;

    public WeatherRecorded(UUID weatherId) {
        this.id = UUID.randomUUID();
        this.weatherId = weatherId;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    public UUID weatherId() {
        return this.weatherId;
    }
}
