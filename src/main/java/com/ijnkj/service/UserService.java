package com.ijnkj.service;

import com.ijnkj.dao.domain.Moment;
import com.ijnkj.dao.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserService extends BaseService<User> {

    User findByOpenId(@Param("openId") String openId);

    int updataByOpenId(User user);

}
