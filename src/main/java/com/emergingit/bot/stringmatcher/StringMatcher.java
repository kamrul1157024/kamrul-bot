package com.emergingit.bot.stringmatcher;


import org.springframework.stereotype.Component;

@Component
public interface StringMatcher {

    boolean matchString(String str1,String str2,int tolerance);

}
