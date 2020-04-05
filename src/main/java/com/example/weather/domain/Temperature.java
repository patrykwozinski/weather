package com.example.weather.domain;

public final class Temperature {
    private final Unit unit;
    private final int degrees;

    private Temperature(Unit unit, int degrees) {
        this.unit = unit;
        this.degrees = degrees;
    }

    public static Temperature forCelsius(int degrees) {
        return new Temperature(Unit.celsius, degrees);
    }

    public static Temperature forFahrenheit(int degrees) {
        return new Temperature(Unit.fahrenheit, degrees);
    }

    public static Temperature unmeasured() {
        return new Temperature(Unit.none, 0);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "unit=" + unit +
                ", degrees=" + degrees +
                '}';
    }

    private enum Unit {
        none,
        celsius,
        fahrenheit,
    }
}
