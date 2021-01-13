package com.emergingit.bot;

import com.emergingit.bot.JSON.JSONCreator;
import com.emergingit.bot.queryprocessor.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BotController {

    GreetingsQueryProcessor greetingsQueryProcessor;
    WeatherInfoQueryProcessor weatherInfoQueryProcessor;
    BasicWorldAffairQueryProcessor basicWorldAffairQueryProcessor;




    QueryAnswerInJSON queryAnswerInJSON;


    @Autowired
    public void setQueryAnswerInJSON(QueryAnswerInJSON queryAnswerInJSON) {
        this.queryAnswerInJSON = queryAnswerInJSON;
    }
    @Autowired
    public void setGreetingsQueryProcessor(GreetingsQueryProcessor greetingsQueryProcessor) {
        this.greetingsQueryProcessor = greetingsQueryProcessor;
    }
    @Autowired
    public void setWeatherInfoQueryProcessor(WeatherInfoQueryProcessor weatherInfoQueryProcessor) {
        this.weatherInfoQueryProcessor = weatherInfoQueryProcessor;
    }
    @Autowired
    public void setBasicWorldAffairQueryProcessor(BasicWorldAffairQueryProcessor basicWorldAffairQueryProcessor) {
        this.basicWorldAffairQueryProcessor = basicWorldAffairQueryProcessor;
    }



    @RequestMapping("/")
    @ResponseBody
    public String home()
    {
        return "You Can send me greetings";
    }

    @RequestMapping("greetings")
    @ResponseBody
    public String greetingsQuery(@RequestParam String q)
    {

        return queryAnswerInJSON.getAnsInJSON(greetingsQueryProcessor,q);
    }

    @RequestMapping("/weather")
    @ResponseBody
    public String weatherQuery(@RequestParam String q)
    {
        return queryAnswerInJSON.getAnsInJSON(weatherInfoQueryProcessor,q);
    }

    @RequestMapping("/qa")
    @ResponseBody
    public String basicWorldAffairQuery(@RequestParam String q)
    {

        return queryAnswerInJSON.getAnsInJSON(basicWorldAffairQueryProcessor,q);
    }





}
