package com.ijnkj.dao;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class BaseEntity<T> implements Serializable{
//    private static final long serialVersionUID = 4325323324444165109L;


    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";

    protected String id;     //唯一标识
    protected String createTime;	// 创建日期
    private String updateTime; // 更新时间
    protected String delFlag; 	// 删除标记（0：正常；1：删除；）

    public BaseEntity() {
        this.delFlag = DEL_FLAG_NORMAL;
        this.id = UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }


}
