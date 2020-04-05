package com.example.weather.infrastructure.persistence.memory;

import com.example.weather.domain.Weather;
import com.example.weather.domain.WeatherCollection;
import com.example.weather.domain.WeatherId;
import com.example.weather.domain.WeatherNotFound;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class InMemoryWeatherCollection implements WeatherCollection {

    final Map<WeatherId, Weather> weathers = new HashMap<>();

    @Override
    public Weather ofId(WeatherId id) throws WeatherNotFound {
        Optional<Weather> weather = weathers
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
