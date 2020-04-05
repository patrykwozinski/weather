package com.example.weather.application;

import com.example.weather.domain.CannotUpdateWeather;
import com.example.weather.domain.WeatherNotFound;

import java.util.UUID;

public final class WeatherFacade {

    private final CreateWeatherService createWeatherService;
    private final UpdateWeatherService updateWeatherService;

    WeatherFacade(CreateWeatherService createWeatherService, UpdateWeatherService updateWeatherService) {
        this.createWeatherService = createWeatherService;
        this.updateWeatherService = updateWeatherService;
    }

    public void createWeatherRegistry(UUID id, String city) {
        this.createWeatherService.create(id, city);
    }

    public void updateWeather(UUID id) {
        try {
            this.updateWeatherService.updateById(id);
        } catch (WeatherNotFound | CannotUpdateWeather error) {
            error.printStackTrace(); // That's temporary!
        }
    }
}
