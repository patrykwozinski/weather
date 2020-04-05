package com.example.weather.domain;

import static com.example.weather.domain.CityFixture.anyCity;

public final class WeatherFixture {

    private static final WeatherId weatherId = WeatherId.create();

    public static Weather anyWeather() {
        var weather = Weather.record(weatherId, anyCity());
        weather.pullEvents();

        return weather;
    }

}
