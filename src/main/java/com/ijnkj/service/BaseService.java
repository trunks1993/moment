package com.ijnkj.service;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseService<T> {

    public T get(@Param("id") String id);


    public List<T> findList();


    public int insert(T entity);


    public int update(T entity);


    public int deleteById(String id);
}
