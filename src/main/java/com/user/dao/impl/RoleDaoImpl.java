package com.user.dao.impl;

import com.user.dao.RoleDao;
import com.user.entity.Role;
import com.user.model.CreateRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String createRole(CreateRole role) {
        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Role roleToCreate = new Role();
        roleToCreate.setRoleName(role.getRoleName());
        roleToCreate.setRoleDescription(role.getRoleDescription());
        session.save(roleToCreate);
        transaction.commit();
        return "Role created successfully !!";
    }
}
