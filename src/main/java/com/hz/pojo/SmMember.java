package com.hz.pojo;


import java.io.Serializable;
import java.util.List;

/**
 * 会员基本信息
 */
public class SmMember implements Serializable {

  private long member_id;
  private String member_number;
  private String member_name;
  private String member_birthday;
  private String member_addtime;
  private int member_sex;
  private long member_state;
  private long member_level_id;

  private List<SmConsumption> smConsumptionList;//消费记录
  private SmLevel smLevel;//会员等级
  private SmIntegral smIntegral;//会员积分记录表
  private List<SmRechargerecord> smRechargerecordList;//会员充值记录表
  private SmAcount smAcount;//会员账户

  public SmAcount getSmAcount() {
    return smAcount;
  }

  public void setSmAcount(SmAcount smAcount) {
    this.smAcount = smAcount;
  }

  public long getMember_id() {
    return member_id;
  }

  public void setMember_id(long member_id) {
    this.member_id = member_id;
  }

  public String getMember_number() {
    return member_number;
  }

  public void setMember_number(String member_number) {
    this.member_number = member_number;
  }

  public String getMember_name() {
    return member_name;
  }

  public void setMember_name(String member_name) {
    this.member_name = member_name;
  }

  public String getMember_birthday() {
    return member_birthday;
  }

  public void setMember_birthday(String member_birthday) {
    this.member_birthday = member_birthday;
  }

  public String getMember_addtime() {
    return member_addtime;
  }

  public void setMember_addtime(String member_addtime) {
    this.member_addtime = member_addtime;
  }

  public int getMember_sex() {
    return member_sex;
  }

  public void setMember_sex(int member_sex) {
    this.member_sex = member_sex;
  }

  public long getMember_state() {
    return member_state;
  }

  public void setMember_state(long member_state) {
    this.member_state = member_state;
  }

  public long getMember_level_id() {
    return member_level_id;
  }

  public void setMember_level_id(long member_level_id) {
    this.member_level_id = member_level_id;
  }

  public List<SmConsumption> getSmConsumptionList() {
    return smConsumptionList;
  }

  public void setSmConsumptionList(List<SmConsumption> smConsumptionList) {
    this.smConsumptionList = smConsumptionList;
  }

  public SmLevel getSmLevel() {
    return smLevel;
  }

  public void setSmLevel(SmLevel smLevel) {
    this.smLevel = smLevel;
  }

  public SmIntegral getSmIntegral() {
    return smIntegral;
  }

  public void setSmIntegral(SmIntegral smIntegral) {
    this.smIntegral = smIntegral;
  }

  public List<SmRechargerecord> getSmRechargerecordList() {
    return smRechargerecordList;
  }

  public void setSmRechargerecordList(List<SmRechargerecord> smRechargerecordList) {
    this.smRechargerecordList = smRechargerecordList;
  }

  @Override
  public String toString() {
    return "SmMember{" +
            "member_id=" + member_id +
            ", member_number='" + member_number + '\'' +
            ", member_name='" + member_name + '\'' +
            ", member_birthday='" + member_birthday + '\'' +
            ", member_addtime='" + member_addtime + '\'' +
            ", member_sex=" + member_sex +
            ", member_state=" + member_state +
            ", member_level_id=" + member_level_id +
            ", smConsumptionList=" + smConsumptionList +
            ", smLevel=" + smLevel +
            ", smIntegral=" + smIntegral +
            ", smRechargerecordList=" + smRechargerecordList +
            '}';
  }
}
