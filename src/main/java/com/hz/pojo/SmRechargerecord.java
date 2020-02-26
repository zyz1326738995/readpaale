package com.hz.pojo;


import java.io.Serializable;

public class SmRechargerecord implements Serializable {

  private long rechargerecord_id;
  private long rechargerecord_member_id;
  private double rechargerecord_summoney;
  private String rechargerecord_time;
  private long rechargerecord_type;

  private SmLevel smLevel;//会员等级
  private SmMember smMember;

  public SmLevel getSmLevel() {
    return smLevel;
  }

  public void setSmLevel(SmLevel smLevel) {
    this.smLevel = smLevel;
  }

  public SmMember getSmMember() {
    return smMember;
  }

  public void setSmMember(SmMember smMember) {
    this.smMember = smMember;
  }

  public long getRechargerecord_id() {
    return rechargerecord_id;
  }

  public void setRechargerecord_id(long rechargerecord_id) {
    this.rechargerecord_id = rechargerecord_id;
  }

  public long getRechargerecord_member_id() {
    return rechargerecord_member_id;
  }

  public void setRechargerecord_member_id(long rechargerecord_member_id) {
    this.rechargerecord_member_id = rechargerecord_member_id;
  }

  public double getRechargerecord_summoney() {
    return rechargerecord_summoney;
  }

  public void setRechargerecord_summoney(double rechargerecord_summoney) {
    this.rechargerecord_summoney = rechargerecord_summoney;
  }

  public String getRechargerecord_time() {
    return rechargerecord_time;
  }

  public void setRechargerecord_time(String rechargerecord_time) {
    this.rechargerecord_time = rechargerecord_time;
  }

  public long getRechargerecord_type() {
    return rechargerecord_type;
  }

  public void setRechargerecord_type(long rechargerecord_type) {
    this.rechargerecord_type = rechargerecord_type;
  }

  @Override
  public String toString() {
    return "SmRechargerecord{" +
            "rechargerecord_id=" + rechargerecord_id +
            ", rechargerecord_member_id=" + rechargerecord_member_id +
            ", rechargerecord_summoney=" + rechargerecord_summoney +
            ", rechargerecord_time='" + rechargerecord_time + '\'' +
            ", rechargerecord_type=" + rechargerecord_type +
            '}';
  }
}
