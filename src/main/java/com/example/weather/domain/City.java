package com.example.weather.domain;

final class City {
    private String name;

    private City(String name) {
        this.name = name;
    }

    public static City forName(String name) {
        return new City(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
