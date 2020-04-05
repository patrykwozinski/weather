package com.example.weather.domain;

public interface Sensor {
    Measurement measureFor(City city);
}
