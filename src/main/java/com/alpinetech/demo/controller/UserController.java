package com.alpinetech.demo.controller;

import com.alpinetech.demo.entity.User;
import com.alpinetech.demo.service.impl.UserServiceImpl;
import com.alpinetech.demo.util.ResultCode;
import com.alpinetech.demo.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xmr
 * @date 2020/10/20 22:47
 * @description
 */
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @GetMapping("/getUser")
    public Object getUser() {
        try {
            List<User> list = new ArrayList<>();
            list.addAll(userService.selectAll());
            if (!list.isEmpty() && list.size() > 0) {
                return new ResultVO<>(list);
            }
        } catch (Exception e) {
            return new ResultVO<>(ResultCode.ERROR, e.toString());
        }
        return new ResultVO<>("查询结果：${list.size()}件");
    }
}
