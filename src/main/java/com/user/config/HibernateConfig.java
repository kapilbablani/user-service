package com.user.config;

import com.user.entity.Role;
import com.user.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

    @Bean
    public org.hibernate.cfg.Configuration config() {
        return new org.hibernate.cfg.Configuration()
                .configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return config().buildSessionFactory();
    }
}
