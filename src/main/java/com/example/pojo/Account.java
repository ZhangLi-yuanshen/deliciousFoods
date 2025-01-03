package com.example.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "level")
    private Integer level;
    @Column(name = "sex")
    private String sex;
    @Transient
    private String newPassword;
    private String address;
    @Column(name = "nickName")
    private String nickName;
    private String phone;
    @Transient
    private Double account;

}
