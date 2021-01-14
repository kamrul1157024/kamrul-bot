package com.emergingit.bot.cache;

import com.emergingit.bot.exception.NotFoundOnCacheException;

public interface Cache<X,Y> {

    public void refreshCache();
    public void put(X key,Y value);
    public Y get(X key) throws NotFoundOnCacheException;
    public String toString();
}
