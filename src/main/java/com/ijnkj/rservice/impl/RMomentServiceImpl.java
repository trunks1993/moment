package com.ijnkj.rservice.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ijnkj.dao.domain.Moment;
import com.ijnkj.rdao.RedisDao;
import com.ijnkj.rservice.RMomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RMomentServiceImpl  implements RMomentService {

    @Autowired
    private RedisDao redisDao;


    @Override
    public void put(String key, Moment moment, long expire) {

        Map map = new HashMap();

        long createTime = new Date().getTime();

        map.put("momentId",moment.getId());
        map.put("userId",moment.getUserId());
        map.put("momentContent",moment.getMomentContent());
        map.put("momentImg",moment.getMomentImg());
        map.put("createTime",createTime);

        redisDao.hMSet("Moment:momentId:"+moment.getId(),map);

        redisDao.zadd("momentList",moment.getId(),createTime);
    }

    @Override
    public String hGet(String key, String HK) {

        return null;
    }

    @Override
    public Map<String, String> entries(String key) {
        return null;
    }

    @Override
    public List<Map<String,String>> getMoment(int flag,long timeLine) {
        Set<String> set =new HashSet<>();
       if (flag == 0) {
           set = redisDao.reverseRangeByScore("momentList", 0, new Date().getTime(), 0, 20);
       }else if (flag == 1){
           set = redisDao.rangeByScore("momentList", timeLine, new Date().getTime(), 0, 20);
       }else {
           set = redisDao.reverseRangeByScore("momentList", 0, timeLine, 0, 20);
       }
        List<Map<String,String>> list = new ArrayList<>();

       for (String momentId : set){
          Map<String,String> map = redisDao.entries("Moment:momentId:"+momentId);

          String userId = map.get("userId");

          map.put("nickName",redisDao.hGet("User:userId:"+userId,"nickName"));
          map.put("avatarUrl",redisDao.hGet("User:userId:"+userId,"avatarUrl"));


           list.add(map);


       }
//        redisDao.set("lastGet:userId"+user_Id,String.valueOf(list.get(0).get("createTime")));
        return list;
    }

    @Override
    public long deleteMoment(String momentId) {
       return redisDao.zRem("momentList",momentId);
    }
}
