### kamrul-bot



## Make Rest API request:
I tried to make as much as softmatching possible :
#Greetings: 
```bash
https://kamrul-bot.herokuapp.com/greetings?q=how are you
```
```bash
https://kamrul-bot.herokuapp.com/greetings?q=what is your name
```





File Structure :
```bash
├───main
│   ├───java
│   │   └───com
│   │       └───emergingit
│   │           └───bot
│   │               │   BotApplication.java
│   │               │   BotController.java
│   │               │
│   │               ├───apiquery
│   │               │       APIParser.java
│   │               │       ParameterGenerator.java
│   │               │       WeatherAPIParser.java
│   │               │
│   │               ├───JSON
│   │               │       JSONCreator.java
│   │               │
│   │               ├───queryprocessor
│   │               │       BasicWorldAffairQueryProcessor.java
│   │               │       ErrorQueryProcessor.java
│   │               │       GreetingsQueryProcessor.java
│   │               │       QueryAnswerInJSON.java
│   │               │       QueryProcessor.java
│   │               │       WeatherInfoQueryProcessor.java
│   │               │
│   │               ├───stringmatcher
│   │               │       EditDistanceStringMatcher.java
│   │               │       StringMatcher.java
│   │               │
│   │               └───stringprocessor
│   │                       StringProcessor.java
│   │
│   └───resources
│       │   application.properties
│       │
│       ├───static
│       └───templates
└───test
    └───java
        └───com
            └───emergingit
                └───bot
                    │   BotApplicationTests.java
                    │
                    ├───apiquery
                    │       APIParserTest.java
                    │       ParameterGeneratorTest.java
                    │       WeatherAPIParserTest.java
                    │
                    ├───queryprocessor
                    │       GreetingsQueryProcessorTest.java
                    │       WeatherInfoQueryProcessorTest.java
                    │
                    └───stringmatcher
                            EditDistanceStringMatcherTest.java
                           
```

