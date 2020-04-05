package com.example.weather.domain.event;

import com.example.blocks.domain.Event;
import com.example.weather.domain.Measurement;
import com.example.weather.domain.WeatherId;

import java.util.UUID;

public final class WeatherUpdated implements Event {
    private final UUID id;
    private final WeatherId weatherId;
    private final Measurement measurement;

    public WeatherUpdated(WeatherId weatherId, Measurement measurement) {
        this.id = UUID.randomUUID();
        this.weatherId = weatherId;
        this.measurement = measurement;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    public WeatherId weatherId() {
        return this.weatherId;
    }

    public Measurement measurement() {
        return this.measurement;
    }
}
