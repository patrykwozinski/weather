package com.example.weather.domain;

public final class CityFixture {
    private static final String name = "Warsaw";

    public static City any() {
        return City.forName(name);
    }

}
