package com.emergingit.bot.exception;

public class NotFoundOnCacheException extends Exception{

    public NotFoundOnCacheException()
    {
        super("No value regarding this key");
    }

}
