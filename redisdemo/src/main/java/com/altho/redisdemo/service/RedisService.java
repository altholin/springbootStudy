package com.altho.redisdemo.service;

import java.io.StringReader;
import java.security.PublicKey;
import java.util.Date;
import java.util.concurrent.TimeUnit;
 
 
import com.altho.redisdemo.model.*;
// import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
 

 
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import com.altho.redisdemo.service.*;
 
@Service
public class RedisService {
 
    @Autowired
    private RedisTemplate redisTemplate;
 
    //查询缓存数据
    @Cacheable(value = "users",key = "#name")
    public User findUser(String name) {
 
        User redisUser = new User();
 
        return redisUser;
    }
    //删除缓存数据
    @CacheEvict(value = "users", key = "#name")
    public int removeUser(String name) {
        return 0;
    }
    //更新或者是增加数据
    @CachePut(value = "users",key="#redisUser.getName()" )
    public User saveUser(User redisUser) {
 
        return redisUser;
    }
 
}
