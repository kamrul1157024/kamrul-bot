package com.emergingit.bot.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JSONCreator {

    Map<String,Object> json_data;

    public JSONCreator()
    {
        json_data=new HashMap<>();
    }
    public JSONCreator addProperty(String name,Object value)
    {
        json_data.put(name,value);
        return this;
    }

    public String toJSON() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String json_output = objectMapper.writeValueAsString(json_data);
        return json_output;
    }


}
