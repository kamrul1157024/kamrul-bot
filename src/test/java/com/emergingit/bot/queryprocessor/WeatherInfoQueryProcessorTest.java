package com.emergingit.bot.queryprocessor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherInfoQueryProcessorTest extends WeatherInfoQueryProcessor {

    @Test
    void testSetStringProcessor() {

        String question="Is there      any possibility of rain in dhaka?";
        System.out.println(getAns(question));

    }
}