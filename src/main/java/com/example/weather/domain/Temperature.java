package com.example.weather.domain;

final class Temperature {
    private Unit unit;
    private int degrees;

    Temperature(Unit unit, int degrees) {
        this.unit = unit;
        this.degrees = degrees;
    }

    public static Temperature forCelsius(int degrees) {
        return new Temperature(Unit.celsius, degrees);
    }

    public static Temperature forFahrenheit(int degrees) {
        return new Temperature(Unit.fahrenheit, degrees);
    }

    private enum Unit {
        celsius,
        fahrenheit,
    }
}
