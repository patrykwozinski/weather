package com.example.weather.unit.domain

import com.example.weather.domain.Sensor
import com.example.weather.domain.Weather
import com.example.weather.domain.WeatherId
import com.example.weather.domain.event.WeatherUpdated
import com.example.weather.domain.event.WeatherRecorded
import spock.lang.Specification

import static com.example.weather.domain.CityFixture.anyCity
import static com.example.weather.domain.SensorFixture.workingSensor
import static com.example.weather.domain.WeatherFixture.anyWeather

final class WeatherSpec extends Specification {

    def 'recorded weather for given city'() {
        given:
            WeatherId weatherId = WeatherId.create()
            def city = anyCity()
        when:
            Weather weather = Weather.record(weatherId, city)
        then:
            WeatherRecorded event = weather.pullEvents().first() as WeatherRecorded
            event.weatherId() == weatherId
    }

    def 'successfully updated weather when sensor is working'() {
        given:
            Weather weather = anyWeather()
            Sensor sensor = workingSensor()

        when:
            weather.update(sensor)

        then:
            weather.pullEvents().first() instanceof WeatherUpdated
    }
}
