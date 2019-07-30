package com.altho.redisdemo.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altho.redisdemo.model.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;


import com.altho.redisdemo.service.*;


@RestController
public class UserController {

    // @RequestMapping("/getUser")
    // @Cacheable(value="user-key")
    // public User getUser() {
    //     User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
    //     System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
    //     return user;
    // }


    // @RequestMapping("/uid")
    // String uid(HttpSession session) {
    //     UUID uid = (UUID) session.getAttribute("uid");
    //     if (uid == null) {
    //         uid = UUID.randomUUID();
    //     }
    //     session.setAttribute("uid", uid);
    //     return session.getId();
    // }
    @Autowired
    RedisService redisService;
    //查找redis中数据
    @GetMapping("/api/Redis/findRedisUser")
    public User finduser() {
        return redisService.findUser("lisi");
    }
    //增加及修改redis数据
    @GetMapping("/api/Redis/addRedisUser")
    public User adduser() {
        User redisUser = new User();
        redisUser.setUserName("lisi1");
        //redisUser.setAge("100");
        redisUser.setPassword("1234");
        return redisService.saveUser(redisUser);
    }
    //删除redis数据
    @GetMapping("/api/Redis/deleteRedisUser")
    public void removeUser() {
        redisService.removeUser("lisi1");
    }

}