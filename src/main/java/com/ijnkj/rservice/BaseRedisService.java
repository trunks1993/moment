package com.ijnkj.rservice;



import java.util.List;
import java.util.Map;


public interface BaseRedisService<T> {


    /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(String key, T doamin, long expire);



    /**
     * 获取
     *
     * @param HK 查询的key
     * @param HK 查询的key
     * @return
     */
    public String hGet(String key,String HK);

    /**
     * 获取
     *
     * @param key 查询的key
     * @return
     */
    public Map<String,String> entries(String key);


}




