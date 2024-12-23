package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectInfo {

  private long id;
  private String name;
  private String time;
  private long foodsId;
  private long notesId;
  private long userId;
  private long level;
}



