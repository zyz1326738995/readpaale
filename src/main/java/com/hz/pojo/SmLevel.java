package com.hz.pojo;


import java.io.Serializable;

/**
 * 会员等级
 */
public class SmLevel implements Serializable {

  private long level_id;
  private String level_name;
  private long level_jifen;

  public long getLevel_jifen() {
    return level_jifen;
  }

  public void setLevel_jifen(long level_jifen) {
    this.level_jifen = level_jifen;
  }

  public long getLevel_id() {
    return level_id;
  }

  public void setLevel_id(long level_id) {
    this.level_id = level_id;
  }

  public String getLevel_name() {
    return level_name;
  }

  public void setLevel_name(String level_name) {
    this.level_name = level_name;
  }

  @Override
  public String toString() {
    return "SmLevel{" +
            "level_id=" + level_id +
            ", level_name='" + level_name + '\'' +
            ", level_jifen=" + level_jifen +
            '}';
  }
}
