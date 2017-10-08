package com.ijnkj.dao.domain;

import com.ijnkj.dao.BaseEntity;

public class User extends BaseEntity<User>{


//     private static final long serialVersionUID = -4118612086664681008L;
     private String openId;
     private String unionId;
     private String NickName; // 昵称
     private String gender;     //性别 0：未知、1：男、2：女
     private String country; //国家
     private String province; //省份
     private String city;     //城市
     private String avatarUrl; //头像
     private String topImg; //顶部图片
     private String phoneNumber; //电话

     public String getOpenId() {
          return openId;
     }

     public String getUnionId() {
          return unionId;
     }

     public void setUnionId(String unionId) {
          this.unionId = unionId;
     }

     public void setOpenId(String openId) {
          this.openId = openId;
     }

     public String getNickName() {
          return NickName;
     }

     public void setNickName(String nickName) {
          NickName = nickName;
     }

     public String getGender() {
          return gender;
     }

     public void setGender(String gender) {
          this.gender = gender;
     }

     public String getCountry() {
          return country;
     }

     public void setCountry(String country) {
          this.country = country;
     }

     public String getProvince() {
          return province;
     }

     public void setProvince(String province) {
          this.province = province;
     }

     public String getCity() {
          return city;
     }

     public void setCity(String city) {
          this.city = city;
     }

     public String getAvatarUrl() {
          return avatarUrl;
     }

     public void setAvatarUrl(String avatarUrl) {
          this.avatarUrl = avatarUrl;
     }

     public String getTopImg() {
          return topImg;
     }

     public void setTopImg(String topImg) {
          this.topImg = topImg;
     }

     public String getPhoneNumber() {
          return phoneNumber;
     }

     public void setPhoneNumber(String phoneNumber) {
          this.phoneNumber = phoneNumber;
     }

}
