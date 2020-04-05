package com.example.weather.domain;

public final class SensorFixture {

    public static Sensor workingSensor() {
        return new WorkingSensor();
    }

    public static Sensor notWorkingSensor() {
        return new NotWorkingSensor();
    }

    private static class WorkingSensor implements Sensor {
        @Override
        public Measurement measureFor(City city) {
            return MeasurementFixture.anySuccessfulMeasurement();
        }
    }

    private static class NotWorkingSensor implements Sensor {
        @Override
        public Measurement measureFor(City city) {
            return MeasurementFixture.anyFailedMeasurement();
        }
    }
}
