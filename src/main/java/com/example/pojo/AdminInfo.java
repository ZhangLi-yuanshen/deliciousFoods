package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin_info")
public class AdminInfo {

  private long id;
  private String name;
  private String password;
  private String nickName;
  private String sex;
  private long age;
  private String birthday;
  private String phone;
  private String address;
  private String code;
  private String email;
  private String cardId;
  private long level;
  private String account;




}
