package com.emergingit.bot.queryprocessor;

import com.emergingit.bot.Configuration;
import com.emergingit.bot.stringmatcher.StringMatcher;
import com.emergingit.bot.stringprocessor.StringProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class GreetingsQueryProcessor implements QueryProcessor {
    HashMap<String,String> possibleQuestions;
    StringMatcher stringMatcher;
    StringProcessor stringProcessor;

    public GreetingsQueryProcessor()
    {
        possibleQuestions=new HashMap<>();
        addPossibleQuestion();
    }

    @Autowired
    public void setStringMatcher(StringMatcher stringMatcher) {
        this.stringMatcher = stringMatcher;
    }

    @Autowired
    public void setStringProcessor(StringProcessor stringProcessor) {
        this.stringProcessor = stringProcessor;
    }


    private void addPossibleQuestion()
    {
        possibleQuestions.put("howareyou","Hello, Corona! I am Fine");
        possibleQuestions.put("whatisyourname","Hello, Corona! I am  a bot");
        possibleQuestions.put("iamcoronaitsapleasuretomeetyou","Hello, Corona! I am also Pleased to meet you");
    }

    private String replyTheQuestion(String question)
    {
        String answer="";
        String default_answer="Hello,Corona!, I  am a bot what can i do for you?";
        try {
            for (String question_bot_know : possibleQuestions.keySet()) {
                if (stringMatcher.matchString(question_bot_know, question, Configuration.TOLERANCE_FOR_SENTENCE_MATCHING)) {
                    answer= possibleQuestions.get(question_bot_know);
                    break;
                }
            }
        }
        catch (Exception e)
        {
            answer=default_answer;
        }
        finally {
            if (answer.equals(""))
                answer=default_answer;

        }
        return answer;
    }



    @Override
    public String getAns(String question) {

        String asked_question = stringProcessor
                .applyOn(question)
                .makeLowerCase()
                .onlyAlphaNumeric()
                .removeGreetings()
                .removeSpaces()
                .getString();

        String answer=replyTheQuestion(asked_question);
        return answer;
    }
}
