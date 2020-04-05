package com.example.weather.infrastructure.persistence.memory;

import com.example.weather.domain.Weather;
import com.example.weather.domain.WeatherCollection;
import com.example.weather.domain.WeatherId;
import com.example.weather.domain.WeatherNotFound;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class InMemoryWeatherCollection implements WeatherCollection {

    private final Map<WeatherId, Weather> weathers;

    public InMemoryWeatherCollection() {
        this.weathers = new HashMap<>();
    }

    public void add(Weather weather) {
        this.weathers.put(weather.id(), weather);
    }

    @Override
    public Weather ofId(WeatherId id) throws WeatherNotFound {
        Optional<Weather> weather = this.weathers
                .values()
                .stream()
                .filter(w -> w.id().equals(id))
                .findAny();

        if (weather.isPresent()) {
            return weather.get();
        }

        throw WeatherNotFound.withId(id);
    }
}
