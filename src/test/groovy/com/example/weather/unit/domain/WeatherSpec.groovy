package com.example.weather.unit.domain


import com.example.weather.domain.CityFixture
import com.example.weather.domain.Weather
import com.example.weather.domain.WeatherRecorded
import spock.lang.Specification

import static java.util.UUID.randomUUID

final class WeatherSpec extends Specification {

    def 'recorded weather for given city'() {
        given:
            UUID weatherId = randomUUID()
            def city = CityFixture.any()
        when:
            WeatherRecorded event = Weather.record(weatherId, city).pullEvents().first() as WeatherRecorded
        then:
            event.weatherId() == weatherId
    }

}
