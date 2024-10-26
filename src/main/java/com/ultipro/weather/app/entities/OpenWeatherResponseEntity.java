package com.ultipro.weather.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponseEntity {

    @JsonProperty("weather")
    private WeatherEntity[] weather;
    @JsonProperty("main")
    private MainEntity main;
}
