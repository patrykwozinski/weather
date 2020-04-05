package com.example.weather.domain;

import com.example.blocks.domain.AggregateRoot;

public final class Weather extends AggregateRoot {
    private WeatherId id;
    private City city;

    private Weather(WeatherId id, City city) {
        this.id = id;
        this.city = city;
    }

    public static Weather record(WeatherId id, City city) {
        var weather = new Weather(id, city);

        weather.recordThat(new WeatherRecorded(id));

        return weather;
    }
}
