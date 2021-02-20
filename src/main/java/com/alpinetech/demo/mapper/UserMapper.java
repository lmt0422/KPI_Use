package com.alpinetech.demo.mapper;

import com.alpinetech.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xmr
 * @date 2021/02/13 22:54
 * @description
 */
@Repository
public interface UserMapper {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectAll();

}
