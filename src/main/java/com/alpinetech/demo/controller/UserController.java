package com.alpinetech.demo.controller;

import com.alpinetech.demo.entity.User;
import com.alpinetech.demo.service.impl.UserServiceImpl;
import com.alpinetech.common.util.ResultCode;
import com.alpinetech.common.util.ResultVO;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alpinetech.common.exception.GlobalExceptionHandler;

import javax.servlet.http.HttpServletRequest;
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
        List<User> list = new ArrayList<>();
        list.addAll(userService.selectAll());
        Integer.parseInt("abc123");
        return new ResultVO<>(list);


    }
}
