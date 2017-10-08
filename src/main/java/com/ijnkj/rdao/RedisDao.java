package com.ijnkj.rdao;


import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.*;

@Component
public class RedisDao {

    @Resource
    protected HashOperations<String, String, String> hashOperations;

    @Resource
    private ListOperations<String,String> listOperations;

    @Resource
    private RedisTemplate<String,String>  redisTemplate;
    @Resource
    private ZSetOperations<String,String> zSetOperations;

    @Resource
    private ValueOperations<String,String> valueOperations;

    //--------------------------String--------------------------
    /**
     * String
     * 添加
     *
     * @param key  键
     * @param V   🈯️值
     */
    public void set(String key,String V){
        valueOperations.set(key,V);
    }


    //--------------------------hash--------------------------
    /**
     * hash
     * 添加
     *
     * @param key  hash空间
     * @param HK   键
     * @param HV   🈯️值
     */
    public void hSet(String key, String HK , String HV){
        hashOperations.put(key,HK,HV);
    }

    /**
     * hash
     * 添加多个
     *
     * @param key  hash空间
     * @param map
     */
    public void hMSet(String key,Map map){

        hashOperations.putAll(key,map);
    }

    /**
     * hash
     * 获取值
     *
     * @param key  hash空间
     * @param HK   键
     */
    public String hGet(String key, String HK ){
       return hashOperations.get(key,HK);
    }

    /**
     * hash
     * 获取值
     *
     * @param key  hash空间
     */
    public Map<String,String> entries(String key){
       return  hashOperations.entries(key);
    }

    /**
     * hash
     * 获取值
     *
     * @param key  hash空间
     * @param HK   键
     */
    public boolean hExists(String key, String HK ){
       return hashOperations.hasKey(key,HK);
    }

    /**
     * hash
     * 删除
     * key hash空间
     * HK 键
     */
    public long hDel(String key,String HK){
       return hashOperations.delete(key,HK);
    }
    //--------------------------list--------------------------

    /**
     * list
     * 获取值
     *
     * @param key  list集合空间
     * @param value   值
     */
    public long lpush(String key,String value){
       return listOperations.leftPush(key,value);
    }


    //--------------------------zset--------------------------

    /**
     * zset
     * 获取值
     *
     * @param key     键
     * @param value   值
     */
    public void zadd(String key,String value,long score){
        zSetOperations.add(key,value,score);
    }

    /**
     * zset
     * 获取值
     *
     * @param key     键
     * @param min   分数开始值
     * @param max   分数开始值
     * @param offset   分数开始值
     * @param count   分数开始值
     */
    public Set<String> rangeByScore(String key,long min,long max,long offset,long count){
       return zSetOperations.rangeByScore(key,min,max,offset,count);
    }

    /**
     * zset
     * 获取值
     *
     * @param key     键
     * @param min   分数开始值
     * @param max   分数开始值
     * @param offset   分数开始值
     * @param count   分数开始值
     */
    public Set<String> reverseRangeByScore(String key,long min,long max,long offset,long count){
        return zSetOperations.reverseRangeByScore(key,min,max,offset,count);
    }
    /**
     * zset
     * 删除
     *
     * @param key  键
     * @param SV   值
     */
    public long zRem(String key,String SV){
        return zSetOperations.remove(key,SV);
    }
}
