package com.ultipro.weather.app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class WeatherRequestDetails {
    private String city;
}