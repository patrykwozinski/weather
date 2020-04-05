package com.example.weather.domain;

public final class SensorFixture {

    public static Sensor workingSensor() {
        return new WorkingSensor();
    }

    private static class WorkingSensor implements Sensor {
        @Override
        public Measurement measureFor(City city) {
            return MeasurementFixture.anySuccessfulMeasurement();
        }
    }
}
