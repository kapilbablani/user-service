package com.user.service.impl;

import com.user.dao.User;
import com.user.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> users() {

        Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User(1, "Kapil", "Bablani","bablanikapil@gmail.com", "8817370908", new Date());
        session.save(user);
        transaction.commit();
        return new ArrayList<>();
    }
}
