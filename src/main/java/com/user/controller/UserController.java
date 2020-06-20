package com.user.controller;

import com.user.exception.UserNotFoundException;
import com.user.model.CreateUser;
import com.user.entity.User;
import com.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value="{userId}")
    @ApiOperation("Get specific user by id")
    public User getUserById(@PathVariable("userId") Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("user")
    @ApiOperation("Create a user into the system")
    public String createUser(@RequestBody(required = true) CreateUser user) {
        return userService.createUser(user);
    }
}
