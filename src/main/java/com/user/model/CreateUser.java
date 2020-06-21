package com.user.model;

import com.user.entity.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CreateUser {
    private String firstName;
    private String lastName;
    private Address address;
    private String email;
    private String mobile;
    private Date dob;
    private Integer roleId;

}