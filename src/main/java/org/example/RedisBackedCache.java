package org.example;

import redis.clients.jedis.JedisPooled;

public class RedisBackedCache {
    //https://github.com/redis/jedis
    JedisPooled pool;

    public RedisBackedCache(String localhost, int port) {
        pool = new JedisPooled(localhost, port);
    }

    public void put(String key, String value) {
        pool.set(key, value);
    }

    public String get(String key) {
        return pool.get(key);
    }

    public void close() {
        pool.close();
    }

    public static void main(String[] args) {
        var cache = new RedisBackedCache("localhost", 6379);
        cache.put("name","Steven");
        cache.put("name","Steven2");

    }

}