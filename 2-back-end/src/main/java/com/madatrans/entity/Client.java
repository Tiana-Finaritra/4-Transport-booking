package com.madatrans.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public  class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}