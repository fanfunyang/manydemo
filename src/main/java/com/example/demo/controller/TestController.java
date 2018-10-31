package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private Environment evn;
    @RequestMapping("/")
    public String test(){
        return evn.getProperty("spring.application.name");
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        System.out.println(user.toString());
        userService.addUser(user);
        return "hhhhhh";
    }
//
//    @RequestMapping(value = "/getuserbyid",method = RequestMethod.GET)
//    public User getUserById(HttpServletRequest r){
//        int id=Integer.valueOf(r.getParameter("id"));
//        return userService.getUserById(id);
//    }

    @RequestMapping(value = "/getuserbyid/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
