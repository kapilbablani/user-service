package com.user.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateUser {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date dob;

}
