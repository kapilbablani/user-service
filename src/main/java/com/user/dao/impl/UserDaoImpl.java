package com.user.dao.impl;

import com.user.dao.UserDao;
import com.user.entity.Role;
import com.user.entity.User;
import com.user.model.CreateUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    @Override
    public User getUserById(Integer userId) {
        Session session =  sessionFactory.openSession();
        return session.get(User.class, userId);
    }

    @Override
    public String createUser(CreateUser user) {
        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(createUserToUser(user));
        transaction.commit();
        return "User created successfully !!";
    }

    private User createUserToUser(CreateUser createUser) {
        User user = new User();
        user.setFirstName(createUser.getFirstName());
        user.setLastName(createUser.getLastName());
        user.setEmail(createUser.getEmail());
        user.setDob(createUser.getDob());
        user.setMobile(createUser.getMobile());
        Role role = new Role();
        role.setRoleId(createUser.getRoleId());
        user.setRole(role);
        user.setAddress(createUser.getAddress());
        return user;
    }
}
