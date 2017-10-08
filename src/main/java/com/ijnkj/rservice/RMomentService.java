package com.ijnkj.rservice;

import com.alibaba.fastjson.JSON;
import com.ijnkj.dao.domain.Moment;
import com.ijnkj.dao.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface RMomentService extends BaseRedisService<Moment> {

    List<Map<String,String>> getMoment(int flag,long timeFlag);

    long deleteMoment(String momentId);

}

