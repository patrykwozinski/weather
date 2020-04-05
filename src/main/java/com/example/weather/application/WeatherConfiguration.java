package com.example.weather.application;

import com.example.weather.domain.Sensor;
import com.example.weather.domain.WeatherCollection;
import com.example.weather.infrastructure.AlwaysHotSensor;
import com.example.weather.infrastructure.InMemoryWeatherCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public final class WeatherConfiguration {

    public WeatherFacade weatherFacade() {
        WeatherCollection weatherCollection = new InMemoryWeatherCollection();
        Sensor sensor = new AlwaysHotSensor();

        return weatherFacade(
                createWeatherService(weatherCollection),
                updateWeatherService(weatherCollection, sensor)
        );
    }

    @Bean
    WeatherFacade weatherFacade(CreateWeatherService createWeatherService, UpdateWeatherService updateWeatherService) {
        return new WeatherFacade(createWeatherService, updateWeatherService);
    }

    @Bean
    CreateWeatherService createWeatherService(WeatherCollection weatherCollection) {
        return new CreateWeatherService(weatherCollection);
    }

    @Bean
    UpdateWeatherService updateWeatherService(WeatherCollection weatherCollection, Sensor sensor) {
        return new UpdateWeatherService(weatherCollection, sensor);
    }
}
