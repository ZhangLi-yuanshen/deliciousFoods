package com.example.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Setter
@Getter
@Table(name = "advertiser_info")
public class AdvertiserInfo {

    private long id;
    private String name;
    private String content;
    private String time;
}
