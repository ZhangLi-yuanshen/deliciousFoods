package com.example.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Table(name = "admin_info")
public class AdminInfo extends Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;
  @Column(name = "password")
  private String password;
  @Column(name = "nickName")
  private String nickName;
  @Column(name = "sex")
  private String sex;
  @Column(name = "age")
  private Integer age;
  @Column(name = "birthday")
  private String birthday;
  @Column(name = "phone")
  private String phone;
  @Column(name = "address")
  private String address;
  @Column(name = "code")
  private String code;
  @Column(name = "email")
  private String email;
  @Column(name = "cardId")
  private String cardId;
  @Column(name = "level")
  private Integer level;
  @Column(name = "account")
  private Double account;


}
