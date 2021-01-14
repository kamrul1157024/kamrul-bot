package com.emergingit.bot.cache;

import com.emergingit.bot.exception.NotFoundOnCacheException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void TestLRUCache() throws NotFoundOnCacheException {
        Cache<String,String> cache=new LRUCache<>(3);
        cache.put("A","B");
        cache.put("X","Y");
        cache.put("M","N");
        String y=cache.get("X");
        assertEquals(y,"Y");
    }

}