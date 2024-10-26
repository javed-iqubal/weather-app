package com.ultipro.weather.app.provider;

import com.ultipro.weather.app.domain.WeatherRequestDetails;
import com.ultipro.weather.app.entities.GeocodingCoordinateEntity;
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
public class GeocodingProvider {
    @Value("${api.key}")
    private String apiKey;
    @Value("${geocoding.url}")
    private String geocodingUrl;
    private final Logger logger = LoggerFactory.getLogger(GeocodingProvider.class);

    public GeocodingCoordinateEntity getCoordinates(WeatherRequestDetails weatherRequestDetails) throws Exception {
        // geocoding api call
        logger.info("API Key : {}, Geocoding URI :{}", apiKey, geocodingUrl);
        RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<GeocodingCoordinateEntity[]> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null, null);

        UriComponents uriComponent = UriComponentsBuilder.fromHttpUrl(geocodingUrl)
                .queryParam("q", weatherRequestDetails.getCity())
                .queryParam("limit", 1)
                .queryParam("appid", apiKey)
                .build();

        try {
            logger.info("URL: {}", uriComponent.toUriString());
            responseEntity = restTemplate.exchange(
                    uriComponent.toUriString(),
                    HttpMethod.GET,
                    requestEntity,
                    GeocodingCoordinateEntity[].class
            );
        } catch (HttpStatusCodeException e) {

            throw new Exception(e.getMessage());
        }

        return responseEntity.getBody()[0];
    }
}
