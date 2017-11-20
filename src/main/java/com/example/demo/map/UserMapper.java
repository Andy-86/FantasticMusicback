package com.example.demo.map;

import com.example.demo.model.User;

/**
 * Created by andy on 2017/11/20.
 */
public interface UserMapper {
    int add(User user);
    User findOne(User user);
}