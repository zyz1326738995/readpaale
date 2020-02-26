package com.hz.pojo;


import java.io.Serializable;

/**
 * 会员消费记录
 */
public class SmConsumption implements Serializable {

  private long consumption_id;
  private long consumption_member_id;
  private double consumption_money;
  private String consumption_time;

  public long getConsumption_id() {
    return consumption_id;
  }

  public void setConsumption_id(long consumption_id) {
    this.consumption_id = consumption_id;
  }

  public long getConsumption_member_id() {
    return consumption_member_id;
  }

  public void setConsumption_member_id(long consumption_member_id) {
    this.consumption_member_id = consumption_member_id;
  }

  public double getConsumption_money() {
    return consumption_money;
  }

  public void setConsumption_money(double consumption_money) {
    this.consumption_money = consumption_money;
  }

  public String getConsumption_time() {
    return consumption_time;
  }

  public void setConsumption_time(String consumption_time) {
    this.consumption_time = consumption_time;
  }

  @Override
  public String toString() {
    return "SmConsumption{" +
            "consumption_id=" + consumption_id +
            ", consumption_member_id=" + consumption_member_id +
            ", consumption_money=" + consumption_money +
            ", consumption_time='" + consumption_time + '\'' +
            '}';
  }
}
