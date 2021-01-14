package com.emergingit.bot.cache;

import com.emergingit.bot.exception.NotFoundOnCacheException;

import java.util.*;

public class LRUCache<X,Y> implements Cache<X,Y>{

    private Map<X,Y> map;
    private Queue<X> queue;
    private int size_of_cache;

    public LRUCache(int size_of_cache)
    {
        map= new HashMap<>();
        queue=new LinkedList<>();
        this.size_of_cache=size_of_cache;
    }

    @Override
    public void put(X key, Y value) {
        queue.add(key);
        if(queue.size()>this.size_of_cache)
        {
            map.remove(queue.poll());
        }
        map.put(key,value);
    }

    @Override
    public Y get(X key) throws NotFoundOnCacheException {
        Y value = map.get(key);
        queue.add(queue.poll());
        if(value != null) return value;
        throw new NotFoundOnCacheException();
    }
}
