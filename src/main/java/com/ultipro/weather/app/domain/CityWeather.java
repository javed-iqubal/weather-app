package com.ultipro.weather.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CityWeather {

    private String weather;
    private String details;

    private String tempMin;
    private String tempMax;
    private String feelsLike;
    private String pressure;
    private String humidity;

}
