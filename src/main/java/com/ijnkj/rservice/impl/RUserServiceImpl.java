package com.ijnkj.rservice.impl;

import com.ijnkj.dao.domain.User;
import com.ijnkj.rdao.RedisDao;
import com.ijnkj.rservice.RUserService;
import com.ijnkj.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class RUserServiceImpl implements RUserService {



   @Autowired
   private RedisDao redisDao;

    @Override
    public void put(String key, User user, long expire) {

        Map<String,String> map = new HashMap();

        map.put("openId",user.getOpenId());
        map.put("avatarUrl",user.getAvatarUrl());
        map.put("nickName",user.getNickName());
        map.put("city",user.getCity());
        map.put("country",user.getCountry());
        map.put("gender",user.getGender());
        map.put("phoneNumber",user.getPhoneNumber());
        map.put("province",user.getProvince());
        map.put("topImg",user.getTopImg());

        if (expire == 1) {

            map.put("id",user.getId());
            map.put("createTime",String.valueOf(new Date().getTime()));
            redisDao.hSet("openId",user.getOpenId(),user.getId());
            redisDao.hMSet("User:userId:"+user.getId(),map);

        }else {
            map.put("updateTime",String.valueOf(new Date().getTime()));
            redisDao.hMSet("User:userId:"+user.getId(),map);
        }

    }

    @Override
    public String hGet(String key,String HK) {

        return redisDao.hGet(key,HK);
    }

    @Override
    public Map<String, String> entries(String key) {
        return redisDao.entries(key);
    }


}
