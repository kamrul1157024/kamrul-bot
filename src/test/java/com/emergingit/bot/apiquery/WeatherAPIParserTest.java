package com.emergingit.bot.apiquery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherAPIParserTest extends WeatherAPIParser {


    @BeforeEach
    void setUp()
    {
        setCityName("dhaka");
    }

    @Test
    void testgetTemp() {
        System.out.println("Temperature : "+getTemp());
    }

    @Test
    void testhumidity() {
        System.out.println("Humidity : "+getHumidity());
    }

    @Test
    void testwindspeed() {
        System.out.println("Wind speed : "+getWindspeed());
    }

    @Test
    void testpressure() {
        System.out.println("Pressure : "+getPressure());
    }

    @Test
    void testgetClouds() {
        System.out.println("Clouds : "+getClouds());
    }
}