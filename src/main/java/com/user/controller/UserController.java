package com.user.controller;

import com.user.entity.User;
import com.user.model.CreateUser;
import com.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@Api(value = "Perform User related Operations", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
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
    public String createUser(@Valid @RequestBody(required = true) CreateUser user) {
        return userService.createUser(user);
    }
}
