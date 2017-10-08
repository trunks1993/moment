package com.ijnkj.dao.mapper;

import com.ijnkj.dao.BaseMapper;
import com.ijnkj.dao.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User>{

    User findByOpenId(@Param("openId") String openId);

    int updateByOpenId(User user);

}
