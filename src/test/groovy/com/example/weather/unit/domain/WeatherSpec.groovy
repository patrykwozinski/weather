package com.example.weather.unit.domain

import com.example.weather.domain.CityFixture
import com.example.weather.domain.Weather
import com.example.weather.domain.WeatherId
import com.example.weather.domain.WeatherRecorded
import spock.lang.Specification

final class WeatherSpec extends Specification {

    def 'recorded weather for given city'() {
        given:
            WeatherId weatherId = WeatherId.create()
            def city = CityFixture.any()
        when:
            Weather weather = Weather.record(weatherId, city)
            WeatherRecorded event = weather.pullEvents().first() as WeatherRecorded
        then:
            event.weatherId() == weatherId
    }

}
