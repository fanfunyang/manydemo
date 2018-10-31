package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public void addUser(User user);

    public User getUserById(int id);

    public List<User> getAllUser();
}
