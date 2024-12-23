package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PraiseInfo {

  private long id;
  private String name;
  private String time;
  private long notesId;
  private long foodsId;
  private long userId;
  private long level;

//
//  public long getId() {
//    return id;
//  }
//
//  public void setId(long id) {
//    this.id = id;
//  }
//
//
//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//
//  public String getTime() {
//    return time;
//  }
//
//  public void setTime(String time) {
//    this.time = time;
//  }
//
//
//  public long getNotesId() {
//    return notesId;
//  }
//
//  public void setNotesId(long notesId) {
//    this.notesId = notesId;
//  }
//
//
//  public long getFoodsId() {
//    return foodsId;
//  }
//
//  public void setFoodsId(long foodsId) {
//    this.foodsId = foodsId;
//  }
//
//
//  public long getUserId() {
//    return userId;
//  }
//
//  public void setUserId(long userId) {
//    this.userId = userId;
//  }
//
//
//  public long getLevel() {
//    return level;
//  }
//
//  public void setLevel(long level) {
//    this.level = level;
//  }

}
