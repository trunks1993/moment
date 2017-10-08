package com.ijnkj.dao.domain;

import com.ijnkj.dao.BaseEntity;

import java.util.Date;

public class Like extends BaseEntity<Like>{


    public static final String Like_FLAG_NORMAL = "0";
    public static final String Like_FLAG_DELETE = "1";
    private static final long serialVersionUID = 6061888582042314429L;

    private Moment moment;
    private User FromUser;
    private String likeFlag; 	// 点赞标记（0：取消点赞；1：点赞；）



    public Like() {
        this.likeFlag = Like_FLAG_NORMAL;
    }

    public Moment getMoment() {
        return moment;
    }

    public void setMoment(Moment moment) {
        this.moment = moment;
    }

    public User getFromUser() {
        return FromUser;
    }

    public void setFromUser(User fromUser) {
        FromUser = fromUser;
    }

    public String getLikeFlag() {
        return likeFlag;
    }

    public void setLikeFlag(String likeFlag) {
        this.likeFlag = likeFlag;
    }
}

