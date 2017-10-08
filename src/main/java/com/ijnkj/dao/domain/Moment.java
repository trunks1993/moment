package com.ijnkj.dao.domain;

import com.ijnkj.dao.BaseEntity;

public class Moment extends BaseEntity<Moment>{

    private String momentContent; //朋友圈内容
    private String momentImg;//内容附加的图片

    private String userId;


    public String getMomentContent() {
        return momentContent;
    }

    public void setMomentContent(String momentContent) {
        this.momentContent = momentContent;
    }

    public String getMomentImg() {
        return momentImg;
    }

    public void setMomentImg(String momentImg) {
        this.momentImg = momentImg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
