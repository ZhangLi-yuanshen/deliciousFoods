package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Setter
@Getter
@Table(name = "news_info")
public class NewsInfo {

  private long id;
  private String name;
  private String content;


}
