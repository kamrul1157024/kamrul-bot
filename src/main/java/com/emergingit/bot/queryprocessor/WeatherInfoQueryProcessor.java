package com.emergingit.bot.queryprocessor;


import com.emergingit.bot.Configuration;
import com.emergingit.bot.apiquery.WeatherAPIParser;
import com.emergingit.bot.stringmatcher.StringMatcher;
import com.emergingit.bot.stringprocessor.StringProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class WeatherInfoQueryProcessor implements QueryProcessor {


    StringProcessor stringProcessor;
    StringMatcher stringMatcher;



    WeatherAPIParser weatherAPIParser;

    @Autowired
    public void setStringProcessor(StringProcessor stringProcessor) {
        this.stringProcessor = stringProcessor;
    }
    @Autowired
    public void setStringMatcher(StringMatcher stringMatcher) {
        this.stringMatcher = stringMatcher;
    }
    @Autowired
    public void setWeatherAPIParser(WeatherAPIParser weatherAPIParser) {
        this.weatherAPIParser = weatherAPIParser;
    }

    private String matchInformation(String[] words_for_matching,String question) throws Exception
    {
        String[] words=question.split(" ");

        for(String word_in_matcher: words_for_matching)
        {
            for(String word:words)
            {
                if(stringMatcher.matchString(word,word_in_matcher, Configuration.TOLERANCE_FOR_WORD_MATCHING))
                {
                    return word_in_matcher;
                }
            }
        }
        throw  new Exception("NoMatchFound");
    }


    private String getCityName(String question) throws Exception
    {
        String[] words=question.split(" ");
        for(int i=words.length-1;i>=0;i--)
        {
            if(words[i].length()>=3) return words[i];
        }

        throw new Exception("NoCityFound");
    }

    private String getQuestionType(String question) throws Exception
    {
        String[] quetion_type={"what","is"};
        String first_word=question.split(" ")[0];

        for(String curr_question_type:quetion_type)
        {
            if(stringMatcher.matchString(curr_question_type,first_word,2))
            {
                return curr_question_type;
            }
        }

        throw new Exception("NotQuestion");
    }


    private HashMap<String,String> extractInformation(String question)
    {
        String[] time_word={"today"};
        String[] information_about= {"temperature","humidity","pressure","windspeed","wind"};
        String[] information_outside={"rain","clouds","clear"};

        HashMap<String,String> informations=new HashMap<>();

        try {
            informations.put("time",matchInformation(time_word,question));
        } catch (Exception e) {
            informations.put("time","today");
        }

        try {
            informations.put("information_about",matchInformation(information_about,question));
        } catch (Exception e) {
            informations.put("information_about","temperature");
        }

        try {
            informations.put("information_outside",matchInformation(information_outside,question));
        } catch (Exception e) {
            informations.put("information_outside","clear");
        }

        try {
            informations.put("city",getCityName(question));
        } catch (Exception e) {
            informations.put("city","dhaka");
        }
        try {
            informations.put("question_type",getQuestionType(question));
        } catch (Exception e) {
            informations.put("question_type","what");
        }

        return  informations;
    }


    private String getInformations(HashMap<String,String> informations)
    {
        weatherAPIParser.setCityName(informations.get("city"));

        if(informations.get("question_type").equals("what"))
        {
            if(informations.get("information_about").equals("temperature"))
            {
                double temperature=weatherAPIParser.getTemp();
                return Double.toString(Math.round(temperature-273.0))+" C";
            }
            else if(informations.get("information_about").equals("humidity"))
            {
                Integer humidity=weatherAPIParser.getHumidity();
                return Integer.toString(humidity);
            }
            else if(informations.get("information_about").equals("pressure"))
            {
                Integer pressure=weatherAPIParser.getPressure();
                return Integer.toString(pressure)+"Pa";
            }
            else if(informations.get("information_about").equals("windspeed") || informations.get("information_about").equals("wind"))
            {
                Double windspeed=weatherAPIParser.getWindspeed();
                return Double.toString(Math.round(windspeed))+" m/s";
            }
            else
                return "did not found any information regaring this!!!";
        }
        else if(informations.get("question_type").equals("is"))
        {
            if(weatherAPIParser.getClouds()>=50)
            {
                return "YES";
            }
            else
            {
                return "No";
            }
        }
        return "Sorry! i do not understand your question";
    }



    @Override
    public String getAns(String question) {

        String asked_question = stringProcessor
                .applyOn(question)
                .makeLowerCase()
                .onlyAlphaNumeric()
                .removeGreetings()
                .getString();

        HashMap<String,String> informations=extractInformation(asked_question);
        String output=getInformations(informations);
        return output;
    }
}
