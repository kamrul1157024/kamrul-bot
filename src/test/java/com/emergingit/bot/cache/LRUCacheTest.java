package com.emergingit.bot.cache;

import com.emergingit.bot.exception.NotFoundOnCacheException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void testLRUCache() throws NotFoundOnCacheException {
        Cache<String,String> cache=new LRUCache<>(3);
        cache.put("A","B");
        cache.put("X","Y");
        cache.put("M","N");
        String y=cache.get("X");
        assertEquals(y,"Y");
    }
    @Test
    void testRefreshableCache() throws InterruptedException, NotFoundOnCacheException {
        Cache<String,String> cache=new LRUCache<>(3,2);
       cache.put("dhaka","30");
       cache.put("london","2");
       cache.put("jakarta","5");
        System.out.println(cache.get("dhaka"));
        System.out.println(cache.get("london"));
       System.out.println(cache);
    }


}