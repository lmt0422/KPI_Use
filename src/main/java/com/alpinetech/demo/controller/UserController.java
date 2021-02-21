package com.alpinetech.demo.controller;

import com.alpinetech.demo.entity.User;
import com.alpinetech.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<User> getUser(){
    return userService.selectAll();
}
}
