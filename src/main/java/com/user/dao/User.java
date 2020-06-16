package com.user.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
public class User {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date dob;

}
