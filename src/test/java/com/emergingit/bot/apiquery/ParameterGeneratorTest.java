package com.emergingit.bot.apiquery;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParameterGeneratorTest {

    @Test
    void testParameterGenerator()
    {
        String url="api.openweathermap.org/data/2.5/weather";
        ParameterGenerator parameterGenerator=new ParameterGenerator();
        url=parameterGenerator
                .toTheUrl(url)
                .setParameter("q","dhaka")
                .setParameter("appid","6d849a6807f1a20970f0051beaac2099")
                .getUrl();

        System.out.println(url);
    }

}