package com.example.weather.infrastructure;

import com.example.weather.domain.City;
import com.example.weather.domain.Measurement;
import com.example.weather.domain.Sensor;
import com.example.weather.domain.Temperature;
import org.springframework.stereotype.Service;

@Service
public final class FixedTemperatureSensor implements Sensor {
    private static final int FIXED_TEMPERATURE = 30;

    @Override
    public Measurement measureFor(City city) {
        return Measurement.successful(Temperature.forCelsius(FIXED_TEMPERATURE));
    }
}
