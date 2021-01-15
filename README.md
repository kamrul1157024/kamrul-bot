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
https://kamrul-bot.herokuapp.com/greetings?q=good morning !
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

python code test consistency of API sending multiple request a time [response_test.py](https://gist.github.com/kamrul1157024/414254eb4896b20aebe551ade25579fe)
```
python response_test.py <number_of_request> http://localhost:9090/weather?q=what%20is%20Humidiy%20in%20Dhaka?
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
│   │               │   Configuration.java
│   │               │   
│   │               ├───apiquery
│   │               │       APIParser.java
│   │               │       ParameterGenerator.java
│   │               │       WeatherAPIParser.java
│   │               │       
│   │               ├───cache
│   │               │       Cache.java
│   │               │       LRUCache.java
│   │               │       RefreshableCache.java
│   │               │       
│   │               ├───exception
│   │               │       APICallFailedException.java
│   │               │       CityNameNotFoundException.java
│   │               │       NotFoundOnCacheException.java
│   │               │       
│   │               ├───json
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
                    ├───cache
                    │       LRUCacheTest.java
                    │       
                    ├───queryprocessor
                    │       GreetingsQueryProcessorTest.java
                    │       WeatherInfoQueryProcessorTest.java
                    │       
                    └───stringmatcher
                            EditDistanceStringMatcherTest.java
                            
```
