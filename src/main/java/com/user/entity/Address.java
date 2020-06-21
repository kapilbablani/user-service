package com.user.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@Embeddable
public class Address {
    @Column(name = "flat_number")
    private String flatNumber;
    private String street;
    private String city;
    private String state;
    private String country;
}
