package com.ijnkj.service.impl;
import com.ijnkj.dao.domain.Moment;
import com.ijnkj.dao.mapper.MomentMapper;
import com.ijnkj.service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class MomentServiceImpl implements MomentService {


    @Autowired
    private MomentMapper momentMapper;

    @Override
    public Moment get(String id) {
        return momentMapper.get(id);
    }

    @Override
    public List<Moment> findList() {
        return null;
    }

    public Moment insertCache(Moment entity) {
        if(momentMapper.insert(entity) == 1) {

            return entity;
        }
        return null;
    }

    @Override
    public int update(Moment entity) {
        return momentMapper.update(entity);
    }

    @Override
    public int deleteById(String id) {
        return momentMapper.deleteById(id);
    }


    public  String compareDate(Date d1, Date d2) {
        // TODO Auto-generated method stub
        long dif = d1.getTime() - d2.getTime();

        if(dif <= 60000){
            return  "1分钟前";
        }else if(dif > 60000 && dif < 3600000){

            double min = Math.floor(dif/60000);
            Integer i = (int)min;
            return i.toString()+"分钟前";

        }else if(dif >= 3600000 && dif < 86400000){
            double hour = Math.floor(dif/3600000);
            Integer i = (int)hour;
            return i.toString()+"小时前";

        }else{
            double day = Math.floor(dif/86400000);
            Integer i = (int)day;
            return i.toString()+"天前";
        }


    }


    @Override
    public int insert(Moment entity) {
        return 0;
    }

}
