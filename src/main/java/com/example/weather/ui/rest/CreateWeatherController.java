package com.example.weather.ui.rest;

import com.example.weather.application.WeatherFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class CreateWeatherController {
    @Autowired
    private WeatherFacade weatherFacade;

    @PostMapping(value = "/weather")
    public String create() {
        return "Hello World";
    }
}
