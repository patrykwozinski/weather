package com.example.weather.domain;

import com.example.blocks.domain.Event;

import java.util.UUID;

public final class WeatherRecorded implements Event {
    private final UUID id;
    private final WeatherId weatherId;

    public WeatherRecorded(WeatherId weatherId) {
        this.id = UUID.randomUUID();
        this.weatherId = weatherId;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    public WeatherId weatherId() {
        return this.weatherId;
    }
}
