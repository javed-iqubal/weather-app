package com.ultipro.weather.app.provider;

import com.ultipro.weather.app.domain.CityCoordinate;
import com.ultipro.weather.app.entities.OpenWeatherResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherProvider {

    @Value("${api.key}")
    private String apiKey;
    @Value("${weather.url}")
    private String weatherUrl;

    private  final Logger logger = LoggerFactory.getLogger(WeatherProvider.class);

    public OpenWeatherResponseEntity getWeather(CityCoordinate cityCoordinate) throws Exception {

        logger.info("API Key : {}, Weather URI :{}",apiKey,weatherUrl);
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<OpenWeatherResponseEntity> responseEntity;
        HttpEntity<String> requestHttpEntity = new HttpEntity<>(null,null);

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(weatherUrl)
                .queryParam("lat",cityCoordinate.getLatitude())
                .queryParam("lon",cityCoordinate.getLongitude())
                .queryParam("appid",apiKey)
                .build();
        try {
            logger.info("URL: {}",uriComponents.toUriString());
            responseEntity = restTemplate.exchange(
                    uriComponents.toUriString(),
                    HttpMethod.GET,
                    requestHttpEntity,
                    OpenWeatherResponseEntity.class
            );
        }catch (HttpStatusCodeException e){
            throw new Exception(e.getMessage());
        }
        return responseEntity.getBody();

    }
}
