package com.user.dao.impl;

import com.user.dao.UserDao;
import com.user.entity.User;
import com.user.model.CreateUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAllUsers() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session =  sessionFactory.openSession();
        return new ArrayList<>();
    }

    @Override
    public User getUserById(Integer userId) {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session =  sessionFactory.openSession();
        return session.get(User.class, userId);
    }

    @Override
    public String createUser(CreateUser user) {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User userToCreate = new User();
        BeanUtils.copyProperties(userToCreate, user);
        session.save(userToCreate);
        transaction.commit();
        return "User created successfully !!";
    }
}
