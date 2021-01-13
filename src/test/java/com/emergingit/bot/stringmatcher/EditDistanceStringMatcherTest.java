package com.emergingit.bot.stringmatcher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceStringMatcherTest {

    StringMatcher stringMatcher;
    @Test
    void matchString() {

        String str1="hi!";
        String str2="hi";
        StringMatcher edit_distance_string_mathcer=new EditDistanceStringMatcher();
        boolean is_same=edit_distance_string_mathcer.matchString(str1,str2,1);
        System.out.println("Distance of the String:"+is_same);
        assertEquals(is_same,true);

    }
}