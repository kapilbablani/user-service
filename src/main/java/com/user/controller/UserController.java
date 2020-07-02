package com.user.controller;

import com.user.entity.User;
import com.user.model.CreateUser;
import com.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@Api(value = "Perform Users operations", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    @ApiOperation("Get the list of all the available users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value="{user-id}")
    @ApiOperation("Get specific user by id")
    public User getUserById(@PathVariable("user-id") Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("user")
    @ApiOperation("Create a user into the system")
    public String createUser(@RequestBody(required = true) CreateUser user) {
        return userService.createUser(user);
    }
}
