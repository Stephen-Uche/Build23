package org.example;

public class RedisBackedCache {



    public RedisBackedCache(String localhost, int port) {

    }

    public void put(String key, String value) {
        //Add code to connect to database and add key value
    }

    public String get(String key) {
        //Add code to connect to database and read value for key
        return null;
    }

    public static void main(String[] args) {

        var cache = new RedisBackedCache("localhost", 6239);
        cache.put("key","value");

    }
}
