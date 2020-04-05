package com.example.weather.domain;

import com.example.blocks.domain.AggregateRoot;

import java.util.UUID;

public final class Weather extends AggregateRoot {
    private UUID id;
    private City city;

    private Weather(UUID id, City city) {
        this.id = id;
        this.city = city;
    }

    public static Weather record(UUID id, City city) {
        var weather = new Weather(id, city);

        weather.recordThat(new WeatherRecorded(id));

        return weather;
    }
}
