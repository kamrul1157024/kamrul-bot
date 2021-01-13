package com.emergingit.bot.queryprocessor;

import org.springframework.stereotype.Service;

@Service
public class BasicWorldAffairQueryProcessor implements QueryProcessor {
    @Override
    public String getAns(String question) {
        return "Your Majesty! jon snow knows nothing! So do I!";
    }
}
