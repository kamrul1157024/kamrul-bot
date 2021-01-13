package com.emergingit.bot.queryprocessor;

import org.springframework.stereotype.Component;

@Component
public class ErrorQueryProcessor implements QueryProcessor{
    @Override
    public String getAns(String question) {
        return "Your majesty! Jon Snow knows nothing! So do I!\n";
    }
}
