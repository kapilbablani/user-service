package com.user.controller;

import com.user.model.CreateRole;
import com.user.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {

    @Resource
    private RoleService roleService;

    @PostMapping("role")
    @ApiOperation("Create a role into the system.")
    public String createRole(@RequestBody(required = true) CreateRole role) {
        return roleService.createRole(role);
    }
}
