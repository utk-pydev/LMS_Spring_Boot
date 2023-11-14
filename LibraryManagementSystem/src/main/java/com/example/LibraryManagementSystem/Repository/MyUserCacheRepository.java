package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class MyUserCacheRepository {

    @Autowired
    RedisTemplate<String, Object>redisTemplate;

    public void set(MyUser myUser){
        String key = getKey(myUser.getUsername());
        redisTemplate.opsForValue().set(key, myUser, 24, TimeUnit.HOURS);
    }

    public MyUser get(String username){
        String key = getKey(username);
        return (MyUser) redisTemplate.opsForValue().get(username);
    }

    private String getKey(String username){
        String USER_KEY_PREFIX = "usr::";
        return USER_KEY_PREFIX +username;
    }
}
