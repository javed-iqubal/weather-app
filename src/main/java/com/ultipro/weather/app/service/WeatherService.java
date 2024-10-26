package com.ultipro.weather.app.service;

import com.ultipro.weather.app.domain.CityCoordinate;
import com.ultipro.weather.app.domain.CityWeather;
import com.ultipro.weather.app.domain.WeatherRequestDetails;
import com.ultipro.weather.app.entities.WeatherResponse;
import com.ultipro.weather.app.provider.GeocodingProvider;
import com.ultipro.weather.app.provider.WeatherProvider;
import com.ultipro.weather.app.transformer.GeocodingCoordinatesTransformer;
import com.ultipro.weather.app.transformer.OpenWeatherTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private GeocodingProvider geocodingProvider;
    private GeocodingCoordinatesTransformer geocodingCoordinatesTransformer;
    private WeatherProvider weatherProvider;
    private OpenWeatherTransformer openWeatherTransformer;

    private final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    @Autowired
    public WeatherService(final GeocodingProvider geocodingProvider,
                          final GeocodingCoordinatesTransformer geocodingCoordinatesTransformer,
                          final WeatherProvider weatherProvider,
                          final OpenWeatherTransformer openWeatherTransformer){
        this.geocodingProvider = geocodingProvider;
        this.geocodingCoordinatesTransformer = geocodingCoordinatesTransformer;
        this.weatherProvider = weatherProvider;
        this.openWeatherTransformer = openWeatherTransformer;
    }
    public WeatherResponse getWeather(final WeatherRequestDetails weatherRequestDetails) throws Exception {

        logger.info("WeatherRequestDetails: {}",  weatherRequestDetails.getCity());
        // get longitude and latitude
        final CityCoordinate cityCoordinate = geocodingCoordinatesTransformer.transformToDomain(
                geocodingProvider.getCoordinates(weatherRequestDetails));

        final CityWeather cityWeather = openWeatherTransformer
                .transformToDomain(weatherProvider.getWeather(cityCoordinate));

        return openWeatherTransformer.transformToEntity(cityWeather);
    }
}
