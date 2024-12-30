package com.example.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import java.util.List;


@Setter
@Getter
@Table(name = "advertiser_info")
public class AdvertiserInfo {

  private long id;
  private String name;
  private String content;
  private String time;
}
