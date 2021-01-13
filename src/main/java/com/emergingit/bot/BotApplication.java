package com.emergingit.bot;

import com.emergingit.bot.apiquery.WeatherAPIParser;
import com.emergingit.bot.queryprocessor.GreetingsQueryProcessor;
import com.emergingit.bot.queryprocessor.QueryProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BotApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext=SpringApplication.run(BotApplication.class,args);
    }

}
