package com.ijnkj.service.impl;

import com.ijnkj.dao.domain.User;
import com.ijnkj.dao.mapper.UserMapper;
import com.ijnkj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User get(String id) {
        return userMapper.get(id);
    }

    @Override
    public List<User> findList() {
        return userMapper.findList();
    }

    @Override
    public int insert(User entity) {
        return userMapper.insert(entity);
    }

    @Override
    public int update(User entity) {
        return userMapper.update(entity);
    }

    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public User findByOpenId(String openId) {
        return userMapper.findByOpenId(openId);
    }

    @Override
    public int updataByOpenId(User user) {
        return userMapper.updateByOpenId(user);
    }
}
