package com.alpinetech.demo.service;

import com.alpinetech.demo.entity.User;

import java.util.List;

/**
 * @author xmr
 * @date 2021/02/13 22:53
 * @description
 */
public interface UserService {
    List<User> selectAll();

}
