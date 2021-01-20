package com.emergingit.bot;

import com.emergingit.bot.queryprocessor.*;
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

        return QueryAnswerInJSON.getAnsInJSON(greetingsQueryProcessor,q);
    }

    @RequestMapping("/weather")
    @ResponseBody
    public String weatherQuery(@RequestParam String q)
    {
        return QueryAnswerInJSON.getAnsInJSON(weatherInfoQueryProcessor,q);
    }

    @RequestMapping("/qa")
    @ResponseBody
    public String basicWorldAffairQuery(@RequestParam String q)
    {

        return QueryAnswerInJSON.getAnsInJSON(basicWorldAffairQueryProcessor,q);
    }


    @RequestMapping("/error")
    @ResponseBody
    public String onError()
    {
        return "error";
    }





}
