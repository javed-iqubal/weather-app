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
public class GeocodingCoordinateEntity {

    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("lon")
    private String longitude;

}
