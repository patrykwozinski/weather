package com.example.weather.ui.rest;

import com.example.weather.application.WeatherConfiguration;
import com.example.weather.application.WeatherFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class CreateWeatherController {
    private WeatherFacade weatherFacade = new WeatherConfiguration().weatherFacade();

    @PostMapping(value = "/weather")
    public String create() {
        return "Hello World";
    }
}
