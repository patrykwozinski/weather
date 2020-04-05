package com.example.weather.domain;

public final class MeasurementFixture {
    public static Measurement anySuccessfulMeasurement() {
        return Measurement.successful(anyTemperature());
    }

    public static Measurement anyFailedMeasurement() {
        return Measurement.failed();
    }

    private static Temperature anyTemperature() {
        return Temperature.forCelsius(23);
    }
}
