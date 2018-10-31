package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void addUser(User user){
        userDao.addUser(user);
    }

    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }
}
