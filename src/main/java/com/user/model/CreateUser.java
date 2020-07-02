package com.user.model;

import com.user.entity.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@ToString
// @Validated
public class CreateUser {
    @Pattern(regexp ="^[a-zA-Z\\\\s]+", message="First Name field error")
    private String firstName;
    @NotNull(message = "Last Name cannot be null")
    private String lastName;
    private Address address;
    private String email;
    private String mobile;
    private Date dob;
    private Integer roleId;

}