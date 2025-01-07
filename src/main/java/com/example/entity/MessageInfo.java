package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Table(name = "message_info")
public class MessageInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "content")
  private String content;
  @Column(name = "time")
  private String time;

}
