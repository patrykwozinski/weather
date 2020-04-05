package com.example.weather.application;

import com.example.weather.domain.*;

import java.util.UUID;

final class CreateWeatherService {
    private final WeatherCollection weathers;

    public CreateWeatherService(WeatherCollection weathers) {
        this.weathers = weathers;
    }

    void create(UUID weatherId, String city) {
        Weather weather = Weather.record(new WeatherId(weatherId), City.forName(city));

        this.weathers.add(weather);
    }
}
