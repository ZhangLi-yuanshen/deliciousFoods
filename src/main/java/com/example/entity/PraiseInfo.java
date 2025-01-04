package com.example.entity;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PraiseInfo {

  //
  private long id;
  private String name;
  private String time;
  private long notesId;
  private long foodsId;
  private long userId;
  private long level;


}
