# kamrul-bot

File Structure :
F:.
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
