package com.example.weather.domain;

public final class WeatherNotFound extends Exception {

    public WeatherNotFound(String message) {
        super(message);
    }

    public static WeatherNotFound withId(WeatherId weatherId) {
        return new WeatherNotFound(
                String.format("%s not found by ID", weatherId)
        );
    }
}
