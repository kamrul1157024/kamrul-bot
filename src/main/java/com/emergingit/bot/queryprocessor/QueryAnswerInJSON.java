package com.emergingit.bot.queryprocessor;

import com.emergingit.bot.JSON.JSONCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryAnswerInJSON {


    public String getAnsInJSON(QueryProcessor queryProcessor, String q)
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
