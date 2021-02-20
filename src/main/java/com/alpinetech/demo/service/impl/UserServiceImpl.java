package com.alpinetech.demo.service.impl;

import com.alpinetech.demo.entity.User;
import com.alpinetech.demo.mapper.UserMapper;
import com.alpinetech.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xmr
 * @date 2021/02/19 22:26
 * @description
 */
@Service("impl1")
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
