package com.ultipro.weather.app.transformer;

import com.ultipro.weather.app.domain.CityWeather;
import com.ultipro.weather.app.entities.OpenWeatherResponseEntity;
import com.ultipro.weather.app.entities.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherTransformer {
    public CityWeather transformToDomain(OpenWeatherResponseEntity weather) {

        return CityWeather.builder()
                .weather(weather.getWeather()[0].getMain())
                .details(weather.getWeather()[0].getDescription())

                .tempMin(weather.getMain().getTempMin())
                .tempMax(weather.getMain().getTempMax())
                .feelsLike(weather.getMain().getFeelsLike())
                .humidity(weather.getMain().getHumidity())
                .pressure(weather.getMain().getPressure())
                .humidity(weather.getMain().getHumidity())

                .build();

    }

    public WeatherResponse transformToEntity(CityWeather cityWeather) {
        return WeatherResponse.builder()
                .weather(cityWeather.getWeather())
                .details(cityWeather.getDetails())

                .tempMin(cityWeather.getTempMin())
                .tempMax(cityWeather.getTempMax())
                .feelsLike(cityWeather.getFeelsLike())
                .pressure(cityWeather.getPressure())
                .humidity(cityWeather.getHumidity())
                .build();
    }
}
