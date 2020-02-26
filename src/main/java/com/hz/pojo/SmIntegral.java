package com.hz.pojo;


import java.io.Serializable;

/**
 * 会员积分记录表
 */
public class SmIntegral implements Serializable {

  private long integral_id;
  private long integral_member_id;
  private long integral_integralnumbers;
  private String integral_time;
  private long integral_times;

  public long getIntegral_times() {
    return integral_times;
  }

  public void setIntegral_times(long integral_times) {
    this.integral_times = integral_times;
  }

  public long getIntegral_id() {
    return integral_id;
  }

  public void setIntegral_id(long integral_id) {
    this.integral_id = integral_id;
  }

  public long getIntegral_member_id() {
    return integral_member_id;
  }

  public void setIntegral_member_id(long integral_member_id) {
    this.integral_member_id = integral_member_id;
  }

  public long getIntegral_integralnumbers() {
    return integral_integralnumbers;
  }

  public void setIntegral_integralnumbers(long integral_integralnumbers) {
    this.integral_integralnumbers = integral_integralnumbers;
  }

  public String getIntegral_time() {
    return integral_time;
  }

  public void setIntegral_time(String integral_time) {
    this.integral_time = integral_time;
  }

  @Override
  public String toString() {
    return "SmIntegral{" +
            "integral_id=" + integral_id +
            ", integral_member_id=" + integral_member_id +
            ", integral_integralnumbers=" + integral_integralnumbers +
            ", integral_time='" + integral_time + '\'' +
            '}';
  }
}
