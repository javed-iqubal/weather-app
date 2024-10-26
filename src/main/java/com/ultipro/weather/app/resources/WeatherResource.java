package com.ultipro.weather.app.resources;

import com.ultipro.weather.app.domain.WeatherRequestDetails;
import com.ultipro.weather.app.entities.WeatherResponse;
import com.ultipro.weather.app.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WeatherResource {

    private WeatherService weatherService;

    private final Logger logger = LoggerFactory.getLogger(WeatherResource.class);

    @Autowired
    public WeatherResource(final WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @ResponseBody
    @GetMapping("/weather/{city}")
    public WeatherResponse weather(@PathVariable("city") String city) throws Exception {

        logger.info("City : {}",city);
        final WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
                .city(city)
                .build();

        return weatherService.getWeather(weatherRequestDetails);
    }
}
