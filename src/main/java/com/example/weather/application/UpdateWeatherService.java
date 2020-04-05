package com.example.weather.application;

import com.example.weather.domain.*;

import java.util.UUID;

final class UpdateWeatherService {
    private final WeatherCollection weathers;
    private final Sensor sensor;

    public UpdateWeatherService(WeatherCollection weathers, Sensor sensor) {
        this.weathers = weathers;
        this.sensor = sensor;
    }

    void updateById(UUID id) throws WeatherNotFound, CannotUpdateWeather {
        Weather weather = this.weathers.ofId(new WeatherId(id));
        weather.update(this.sensor);
    }
}
