package com.example.weather.infrastructure;

import com.example.weather.domain.City;
import com.example.weather.domain.Measurement;
import com.example.weather.domain.Sensor;
import com.example.weather.domain.Temperature;

public final class FixedTemperatureSensor implements Sensor {
    private final int fixedTemperature;

    public FixedTemperatureSensor(int fixedTemperature) {

        this.fixedTemperature = fixedTemperature;
    }

    @Override
    public Measurement measureFor(City city) {
        return Measurement.successful(Temperature.forCelsius(this.fixedTemperature));
    }
}
