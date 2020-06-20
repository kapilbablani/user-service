package com.user.service.impl;

import com.user.dao.UserDao;
import com.user.entity.User;
import com.user.model.CreateUser;
import com.user.service.UserService;
import com.user.util.ValidationUtil;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        logger.info("Entering getAllUser()");
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Integer userId) {
        logger.info("Entering getUserById()");
        ValidationUtil.validateInput(userId, null);
        return userDao.getUserById(userId);
    }

    @Override
    public String createUser(CreateUser user) {
        logger.info("Entering createUser()");
        return userDao.createUser(user);
    }

}
