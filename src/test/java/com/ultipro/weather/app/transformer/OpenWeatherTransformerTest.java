package com.ultipro.weather.app.transformer;

import com.ultipro.weather.app.domain.CityWeather;
import com.ultipro.weather.app.entities.MainEntity;
import com.ultipro.weather.app.entities.OpenWeatherResponseEntity;
import com.ultipro.weather.app.entities.WeatherEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenWeatherTransformerTest {

    private OpenWeatherTransformer transformer;

    @BeforeEach
    public void setUp(){
        transformer = new OpenWeatherTransformer();
    }

    @Test
    void Test_should_transform_open_weather_response_entity_into_Domain() {

        final WeatherEntity weather = WeatherEntity.builder()
                .main("Rain")
                .description("its rainy day")
                .build();

        final WeatherEntity[] weatherEntity = {weather};

        final MainEntity mainEntity = MainEntity.builder()
                .feelsLike("40")
                .tempMax("38")
                .tempMin("27")
                .humidity("80")
                .pressure("150")
                .build();
        final OpenWeatherResponseEntity entity = OpenWeatherResponseEntity.builder()
                .weather(weatherEntity)
                .main(mainEntity)
                .build();

        final CityWeather cityWeather = transformer.transformToDomain(entity);

        assertAll("Test should return city weather",
                () -> assertEquals(entity.getWeather()[0].getMain(),cityWeather.getWeather()),
                () -> assertEquals(entity.getWeather()[0].getDescription(),cityWeather.getDetails()),

                () -> assertEquals(entity.getMain().getHumidity(),cityWeather.getHumidity()),
                () -> assertEquals(entity.getMain().getPressure(),cityWeather.getPressure()),
                () -> assertEquals(entity.getMain().getTempMin(),cityWeather.getTempMin()),
                () -> assertEquals(entity.getMain().getTempMax(),cityWeather.getTempMax()),
                () -> assertEquals(entity.getMain().getFeelsLike(),cityWeather.getFeelsLike())
                );

    }

    @Test
    void test_should_transformToEntity() {
    }
}