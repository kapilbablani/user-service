package com.user.service;

import com.user.dao.User;

import java.util.List;

public interface UserService {
    List<User> users();

    User userById(Integer userId);
}
