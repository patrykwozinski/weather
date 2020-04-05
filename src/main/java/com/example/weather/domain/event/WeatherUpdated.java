package com.example.weather.domain.event;

import com.example.blocks.domain.Event;
import com.example.weather.domain.Temperature;
import com.example.weather.domain.WeatherId;

import java.util.UUID;

public final class WeatherUpdated implements Event {
    private final UUID id;
    private final WeatherId weatherId;
    private final Temperature temperature;

    public WeatherUpdated(WeatherId weatherId, Temperature temperature) {
        this.id = UUID.randomUUID();
        this.weatherId = weatherId;
        this.temperature = temperature;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    public WeatherId weatherId() {
        return this.weatherId;
    }

    public Temperature temperature() {
        return this.temperature;
    }
}
