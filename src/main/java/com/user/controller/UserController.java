package com.user.controller;

import com.user.dao.User;
import com.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@Api(value = "Perform User related Operations", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    @ApiOperation("Get the list of all the available users")
    public List<User> users() {
        return userService.users();
    }

    @GetMapping(value="{userId}")
    @ApiOperation("Get specific user by id")
    public User userById(@PathVariable("userId") Integer userId) {
        return userService.userById(userId);
    }
}
