package com.ijnkj.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T>{

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T get(@Param("id") String id);

    /**
     * 查询数据列表
     * @return
     */
    public List<T> findList();

    /**
     * 插入数据
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * 更新数据
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * 删除数据（逻辑删除，更新del_flag字段为1,在表包含字段del_flag时，可以调用此方法，将数据隐藏）
     * @param id
     * @see public int delete(T entity)
     * @return
     */
    public int deleteById(@Param("id") String id);
}
