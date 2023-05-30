package com.example.loginsvl.dao;

import com.example.loginsvl.entity.User;

public interface UserDao {
    User findByUserName(String username);
    User login(String username, String password);
    User register(User user);
}
