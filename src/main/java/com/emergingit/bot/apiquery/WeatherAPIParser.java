package com.emergingit.bot.apiquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class WeatherAPIParser {

    private String city_name;
    private final String apiKey="6d849a6807f1a20970f0051beaac2099";



    APIParser apiParser;
    private Map<String,Object> response;

    public void setCityName(String city_name)
    {
        this.city_name=city_name;
        try {
            String response=makeApiCall();
            this.response = convert(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public WeatherAPIParser(@Autowired APIParser apiParser)
    {

        this.apiParser = apiParser;
    }



    private String makeApiCall() throws Exception
    {
        String url="https://api.openweathermap.org/data/2.5/weather";
        ParameterGenerator parameterGenerator=new ParameterGenerator();
        url=parameterGenerator
                .toTheUrl(url)
                .setParameter("q",city_name)
                .setParameter("appid",apiKey)
                .getUrl();
        try {
            return apiParser.sendRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new Exception("WeatherAPICallFailed");
    }

    Map<String,Object> convert(String response)
    {
        JsonParser jsonParser= JsonParserFactory.getJsonParser();
        return jsonParser.parseMap(response);
    }



    public double getTemp()
    {
        Map<String,Double> main= (Map<String, Double>) response.get("main");
        return main.get("temp");
    }

    public Integer getHumidity()
    {
        Map<String,Integer> main= (Map<String, Integer>) response.get("main");
        return main.get("humidity");
    }

    public double getWindspeed()
    {
        Map<String,Double> main= (Map<String, Double>) response.get("wind");
        return main.get("speed");
    }

    public Integer getPressure()
    {
        Map<String,Integer> main= (Map<String, Integer>) response.get("main");
        return main.get("pressure");
    }

    public Integer getClouds()
    {
        Map<String,Integer> main= (Map<String, Integer>) response.get("clouds");
        return main.get("all");
    }

}
