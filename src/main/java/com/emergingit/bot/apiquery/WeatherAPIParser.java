package com.emergingit.bot.apiquery;

import com.emergingit.bot.Configuration;
import com.emergingit.bot.cache.Cache;
import com.emergingit.bot.cache.LRUCache;
import com.emergingit.bot.exception.APICallFailedException;
import com.emergingit.bot.exception.NotFoundOnCacheException;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WeatherAPIParser extends APIParser {

    private String city_name;
    private final String apiKey="6d849a6807f1a20970f0051beaac2099";
    private String weather_api_url ="https://api.openweathermap.org/data/2.5/weather";
    private Map<String,Object> response;
    Cache<String,Map<String,Object>> cache;


    public WeatherAPIParser()
    {
        cache=new LRUCache<>(Configuration.WEATHER_CACHE_SIZE);
    }


    public void setCityName(String city_name)
    {
        this.city_name=city_name;

        try {
            cache.get(city_name);
        } catch (NotFoundOnCacheException cacheException) {


            try {
                String response=makeApiCall();
                this.response = convert(response);
            } catch (APICallFailedException apiCallFailedException) {
                apiCallFailedException.printStackTrace();
            }

            cache.put(city_name,this.response);

        }


    }

    private String makeApiCall() throws APICallFailedException
    {
        ParameterGenerator parameterGenerator=new ParameterGenerator();
        weather_api_url =parameterGenerator
                .toTheUrl(weather_api_url)
                .setParameter("q",city_name)
                .setParameter("appid",apiKey)
                .getUrl();
        try {
            return sendRequest(weather_api_url);
        } catch (APICallFailedException e) {
            e.printStackTrace();
        }

        throw new APICallFailedException(this);
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
