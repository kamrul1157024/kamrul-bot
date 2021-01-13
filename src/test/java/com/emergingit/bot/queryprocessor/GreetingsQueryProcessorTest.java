package com.emergingit.bot.queryprocessor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GreetingsQueryProcessorTest extends GreetingsQueryProcessor{


    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetAns() {
        String question="Hi! i'm Corona";
        System.out.println(getAns(question));
        question="good morning!?";
        System.out.println(getAns(question));
    }

}