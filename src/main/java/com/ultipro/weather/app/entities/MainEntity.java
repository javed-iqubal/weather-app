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
public class MainEntity {

    @JsonProperty("temp")
    private String temp;
    @JsonProperty("feels_like")
    private String feelsLike;
    @JsonProperty("temp_min")
    private String tempMin;
    @JsonProperty("temp_max")
    private String tempMax;
    @JsonProperty("pressure")
    private String pressure;
    @JsonProperty("humidity")
    private String humidity;
    @JsonProperty("sea_level")
    private String seaLevel;
    @JsonProperty("grnd_level")
    private String grndLevel;

}

