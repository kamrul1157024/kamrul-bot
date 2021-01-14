package com.emergingit.bot.queryprocessor;

import com.emergingit.bot.json.JSONCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public class QueryAnswerInJSON {


    public static String getAnsInJSON(QueryProcessor queryProcessor, String q)
    {
        JSONCreator jsonCreator=new JSONCreator();
        String json_output="Check! is Everything ok?";
        try {
            json_output=jsonCreator
                    .addProperty("answer",queryProcessor.getAns(q))
                    .toJSON();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json_output;
    }


}
