package com.emergingit.bot.stringprocessor;

import com.emergingit.bot.stringmatcher.StringMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringProcessor {

    StringMatcher stringMatcher;
    String question;


    @Autowired
    public StringProcessor(StringMatcher stringMatcher)
    {
        this.stringMatcher=stringMatcher;
    }

    public StringProcessor applyOn(String str)
    {
        this.question =str;
        return this;
    }

    public StringProcessor onlyAlphaNumeric()
    {
        StringBuilder processedString=new StringBuilder();

        for(int i=0;i<question.length();i++)
        {
            char c=question.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c) || Character.isSpaceChar(c))
            {
                processedString.append(c);
            }
        }
        question =processedString.toString();
        return this;
    }

    public StringProcessor makeLowerCase()
    {
        question=question.toLowerCase();
        return this;
    }

    public StringProcessor removeSpaces()
    {
        question=question.replace(" ","");
        return this;
    }

    public StringProcessor removeGreetings()
    {
        String question_with_greeting=question;

        String[] greetings={"hi","hello","good","morning","evening","night"};

        String[] words=question_with_greeting.split(" ");

        StringBuilder question_without_greetings=new StringBuilder();

        for(String word:words)
        {
            boolean is_matched_string_found=false;
            for(String greet:greetings)
            {
                is_matched_string_found |= stringMatcher.matchString(word,greet,1);
            }
            if(!is_matched_string_found)
            {
                question_without_greetings.append(word+' ');
            }
        }

        question = question_without_greetings.toString();
        return this;
    }

    public String getString()
    {
        return this.question;
    }





}
