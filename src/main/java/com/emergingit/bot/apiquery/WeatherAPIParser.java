package com.emergingit.bot.apiquery;

import com.emergingit.bot.Configuration;
import com.emergingit.bot.cache.Cache;
import com.emergingit.bot.cache.LRUCache;
import com.emergingit.bot.exception.APICallFailedException;
import com.emergingit.bot.exception.CityNameNotFoundException;
import com.emergingit.bot.exception.NotFoundOnCacheException;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WeatherAPIParser extends APIParser {

    private String city_name;
    private final String apiKey="caf34d5a408c9986a4e4ab0a0548b637";
    private String weather_api_url ="https://api.openweathermap.org/data/2.5/weather";
    private Map<String,Object> response;
    Cache<String,Map<String,Object>> cache;


    public WeatherAPIParser()
    {
        cache=new LRUCache<>(Configuration.Weather.CACHE_SIZE,Configuration.Weather.CACHE_REFRESH_TIME_IN_SECONDS);
    }


    public void setCityName(String city_name) throws CityNameNotFoundException
    {
        this.city_name=city_name;

        try {
            this.response=cache.get(city_name);
        } catch (NotFoundOnCacheException cacheException) {


            try {
                String response=makeApiCall();
                this.response = convert(response);
                cache.put(city_name,this.response);
            } catch (APICallFailedException apiCallFailedException) {
                throw new CityNameNotFoundException();
            }


        }


    }

    private String makeApiCall() throws APICallFailedException
    {
        ParameterGenerator parameterGenerator=new ParameterGenerator();
        String current_weather_api_url =parameterGenerator
                .toTheUrl(weather_api_url)
                .setParameter("q",city_name)
                .setParameter("appid",apiKey)
                .getUrl();
        try {
            return sendRequest(current_weather_api_url);
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
