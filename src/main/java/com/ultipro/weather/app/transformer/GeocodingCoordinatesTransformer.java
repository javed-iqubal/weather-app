package com.ultipro.weather.app.transformer;

import com.ultipro.weather.app.domain.CityCoordinate;
import com.ultipro.weather.app.entities.GeocodingCoordinateEntity;
import org.springframework.stereotype.Service;

@Service
public class GeocodingCoordinatesTransformer {

    public CityCoordinate transformToDomain(GeocodingCoordinateEntity entity) {
        return CityCoordinate.builder()
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }
}
