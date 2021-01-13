# kamrul-bot



## Make Rest API request:
I tried to make as much as softmatching possible :
### Greetings: 
```bash
https://kamrul-bot.herokuapp.com/greetings?q=how are you
```
```bash
https://kamrul-bot.herokuapp.com/greetings?q=what is your name
```
```bash
https://kamrul-bot.herokuapp.com/greetings?q=good    morning !
```

### Weather Info
```bash
https://kamrul-bot.herokuapp.com/weather?q=what is the weather of Dhaka?
```
```bash
https://kamrul-bot.herokuapp.com/weather?q=Is there any possibility of rain in dhaka?
```
```bash
https://kamrul-bot.herokuapp.com/weather?q=what is the windspeed of Dhaka?
```
```bash
https://kamrul-bot.herokuapp.com/weather?q=what is the humidity of lahore?
```

### Basic World Affairs
Currently Working on that
```bash
https://kamrul-bot.herokuapp.com/qa?q=Who is the president of Bangladesh?
```




## File Structure :
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

