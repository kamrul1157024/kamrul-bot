package com.emergingit.bot.exception;

import com.emergingit.bot.apiquery.APIParser;

import java.io.IOException;

public class APICallFailedException extends Exception {
    public APICallFailedException()
    {
        super("API called Failed");
    }
    public APICallFailedException(APIParser apiParser)
    {
        super("Failed to call "+ apiParser.getClass().toString());
    }
}
