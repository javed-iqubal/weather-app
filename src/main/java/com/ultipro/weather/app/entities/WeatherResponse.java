package com.ultipro.weather.app.entities;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {

    private String weather;
    private String details;

    private String tempMin;
    private String tempMax;
    private String feelsLike;
    private String pressure;
    private String humidity;

}
