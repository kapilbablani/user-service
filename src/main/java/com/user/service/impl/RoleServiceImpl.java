package com.user.service.impl;

import com.user.dao.RoleDao;
import com.user.model.CreateRole;
import com.user.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public String createRole(CreateRole role) {
        return roleDao.createRole(role);
    }
}
