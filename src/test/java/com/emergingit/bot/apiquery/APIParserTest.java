package com.emergingit.bot.apiquery;

import org.junit.jupiter.api.Test;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import java.io.IOException;
import java.util.Map;

class APIParserTest extends APIParser {

    @Test
    void testSendRequest() throws IOException {
        String url="https://api.openweathermap.org/data/2.5/weather?q=dhaka&appid=6d849a6807f1a20970f0051beaac2099";
        String out=sendRequest(url);
        //JSONParser Test
        JsonParser jsonParser= JsonParserFactory.getJsonParser();
        Map<String,Object> jsonout=jsonParser.parseMap(out);
        Map<String , Double> main_inside_json=(Map<String,Double>)jsonout.get("main");
        System.out.println(main_inside_json.get("temp"));
        System.out.println(jsonout);
    }
}