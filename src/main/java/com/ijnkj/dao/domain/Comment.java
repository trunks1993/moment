package com.ijnkj.dao.domain;

import com.ijnkj.dao.BaseEntity;

public class Comment extends BaseEntity<Comment>{

    private static final long serialVersionUID = 1L;

    private Moment moment; //评论的朋友圈id
    private User FromUser; //评论人
    private User ToUser; //给回复的人
    private String commentContent; //评论的内容

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

    public User getToUser() {
        return ToUser;
    }

    public void setToUser(User toUser) {
        ToUser = toUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
