package com.chuwei.service;

import com.chuwei.common.utils.RandomUtils;
import com.chuwei.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by win on 2019/8/17.
 */
@Service
public class UserService {

    public User createRandomUser(){
       User user = new User();
       Date date = new Date();
       user.setUserid(UUID.randomUUID().toString().replaceAll("-", ""));
       user.setUsername(RandomUtils.getRandomString(10));
       user.setEmail(RandomUtils.getRandomString(8).toLowerCase()+"@"+ RandomUtils.getRandomString(6).toLowerCase()+".com");
       user.setMobile(RandomUtils.getRandomMobile(0));
       user.setPassword(RandomUtils.getRandomString(12));
       user.setCreatetime(date);
       user.setStatus(1);
       user.setUpdatetime(date);
       user.setNickname(RandomUtils.getRandomName(0));
       return  user;
    }

    public User getUserByUserid(String userid){
        return new User();
    }
}
