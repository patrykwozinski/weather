package com.example.weather.infrastructure;

import com.example.weather.domain.City;
import com.example.weather.domain.Measurement;
import com.example.weather.domain.Sensor;
import com.example.weather.domain.Temperature;

public final class AlwaysHotSensor implements Sensor {
    private static final int TEMPERATURE = 30;

    @Override
    public Measurement measureFor(City city) {
        return Measurement.successful(Temperature.forCelsius(TEMPERATURE));
    }
}
