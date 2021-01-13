package com.emergingit.bot.apiquery;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;


public class ParameterGenerator {

    String url;
    HashMap<String,String> all_parameters;
    public ParameterGenerator()
    {
        all_parameters=new HashMap<>();
    }

    public ParameterGenerator toTheUrl(String url)
    {
        this.url=url;
        return this;
    }

    public ParameterGenerator setParameter(String parameter,String value)
    {

        all_parameters.put(parameter,value);
        return this;
    }

    public String getUrl()
    {
        AtomicBoolean is_first_parameter= new AtomicBoolean(true);
        all_parameters.forEach((parameter,value)->{

            if(is_first_parameter.get())  url += "?";
            else url += "&";

            url+=parameter+"="+value;


            is_first_parameter.set(false);
        });

        return url;
    }





}
