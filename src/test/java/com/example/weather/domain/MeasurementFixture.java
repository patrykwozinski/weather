package com.example.weather.domain;

public final class MeasurementFixture {
    public static final String FAILED_REASON = "Because I can";
    public static final int TEMPERATURE = 23;

    public static Measurement anySuccessfulMeasurement() {
        return Measurement.successful(anyTemperature());
    }

    public static Measurement anyFailedMeasurement() {
        return Measurement.failed(FAILED_REASON);
    }

    private static Temperature anyTemperature() {
        return Temperature.forCelsius(TEMPERATURE);
    }
}
