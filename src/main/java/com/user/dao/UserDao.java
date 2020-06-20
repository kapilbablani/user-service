package com.user.dao;

import com.user.entity.User;
import com.user.model.CreateUser;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(Integer userId);

    String createUser(CreateUser user);
}
