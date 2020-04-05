package com.example.weather.domain.error;

import com.example.weather.domain.Measurement;
import com.example.weather.domain.WeatherId;

public final class CannotUpdateWeather extends Exception {

    public CannotUpdateWeather(String message) {
        super(message);
    }

    public static CannotUpdateWeather forMeasurement(WeatherId weatherId, Measurement measurement) {
        return new CannotUpdateWeather(
                String.format("Cannot update %s when measurement failed because of: %s", weatherId, measurement.reason())
        );
    }
}
