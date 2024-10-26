package com.ultipro.weather.app.transformer;

import com.ultipro.weather.app.domain.CityCoordinate;
import com.ultipro.weather.app.entities.GeocodingCoordinateEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GeocodingCoordinatesTransformerTest {

    private GeocodingCoordinatesTransformer transformer;

    @BeforeEach
    public void setUp(){
        transformer = new GeocodingCoordinatesTransformer();
    }

    @Test
    public void test_the_transformation_of_geocoding_coordinate_to_city_coordinate(){

        GeocodingCoordinateEntity entiy = GeocodingCoordinateEntity.builder()
                .latitude("10.02")
                .longitude("8.12")
                .build();

        CityCoordinate cityCoordinate = transformer.transformToDomain(entiy);

        assertAll (" Test should return domain city coordinate ",
                () -> assertEquals(entiy.getLatitude(), cityCoordinate.getLatitude()),
                () -> assertEquals(entiy.getLongitude(),cityCoordinate.getLongitude())
        );
    }

}