package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

  private long id;
  private String name;
  private String password;
  private String nickName;
  private String sex;
  private long age;
  private String birthday;
  private String phone;
  private String address;
  private String email;
  private String cardId;
  private long level;
}
