package com.emergingit.bot.cache;

import com.emergingit.bot.exception.NotFoundOnCacheException;

import java.time.LocalTime;
import java.util.*;

public class LRUCache<X,Y> implements Cache<X,Y> ,RefreshableCache{

    private Map<X,Y> map;
    private Queue<X> queue;
    private Queue<Integer> timestamp;
    private int size_of_cache;
    private boolean is_refreshable=false;
    private int refresh_time_in_seconds;

    public LRUCache(int size_of_cache)
    {
        init_cache(size_of_cache);
    }

    public LRUCache(int size_of_cache,int refresh_time_in_seconds)
    {
        init_cache(size_of_cache);
        is_refreshable=true;
        this.refresh_time_in_seconds=refresh_time_in_seconds;

    }

    private void init_cache(int size_of_cache)
    {
        map= new HashMap<>();
        queue=new LinkedList<>();
        timestamp=new LinkedList<>();
        this.size_of_cache=size_of_cache;
    }

    private int getCurrentTimeInSeconds()
    {
        LocalTime localTime=LocalTime.now();
        int current_time=localTime.getHour()*3600+localTime.getMinute()*60+localTime.getSecond();
        return current_time;
    }




    @Override
    public void refreshCache() {
        int current_time=getCurrentTimeInSeconds();
        while (!timestamp.isEmpty() &&timestamp.peek()+refresh_time_in_seconds< current_time)
        {
            map.remove(queue.poll());
            timestamp.poll();
        }
    }

    @Override
    public String toString()
    {
        if(is_refreshable) refreshCache();
        return map.toString();
    }

    @Override
    public void put(X key, Y value) {
        queue.add(key);
        timestamp.add(getCurrentTimeInSeconds());
        if(queue.size()>this.size_of_cache)
        {
            map.remove(queue.poll());
            timestamp.poll();
        }
        map.put(key,value);
    }

    @Override
    public Y get(X key) throws NotFoundOnCacheException {

        if(is_refreshable) refreshCache();

        Y value = map.get(key);
        queue.add(queue.poll());

        timestamp.poll();
        timestamp.add(getCurrentTimeInSeconds());

        if(value != null) return value;
        throw new NotFoundOnCacheException();
    }
}
