package com.example.weather.domain;

public interface WeatherCollection {
    Weather ofId(WeatherId id) throws WeatherNotFound;
}
