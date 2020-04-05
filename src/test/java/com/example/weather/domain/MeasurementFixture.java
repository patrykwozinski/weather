package com.example.weather.domain;

public final class MeasurementFixture {
    public static Measurement anySuccessfulMeasurement() {
        return Measurement.successful(anyTemperature());
    }

    private static Temperature anyTemperature() {
        return Temperature.forCelsius(23);
    }
}
