package com.example.weather.domain;

public interface WeatherCollection {
    void add(Weather weather);

    Weather ofId(WeatherId id) throws WeatherNotFound;
}
