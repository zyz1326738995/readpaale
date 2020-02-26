package com.hz.pojo;


import java.io.Serializable;

public class SmAcount implements Serializable {

  private long account_id;
  private long account_member_id;
  private double account_money;
  private double account_summoney;
  private String account_addtime;

  public long getAccount_id() {
    return account_id;
  }

  public void setAccount_id(long account_id) {
    this.account_id = account_id;
  }

  public long getAccount_member_id() {
    return account_member_id;
  }

  public void setAccount_member_id(long account_member_id) {
    this.account_member_id = account_member_id;
  }

  public double getAccount_money() {
    return account_money;
  }

  public void setAccount_money(double account_money) {
    this.account_money = account_money;
  }

  public double getAccount_summoney() {
    return account_summoney;
  }

  public void setAccount_summoney(double account_summoney) {
    this.account_summoney = account_summoney;
  }

  public String getAccount_addtime() {
    return account_addtime;
  }

  public void setAccount_addtime(String account_addtime) {
    this.account_addtime = account_addtime;
  }

  @Override
  public String toString() {
    return "SmAcount{" +
            "account_id=" + account_id +
            ", account_member_id=" + account_member_id +
            ", account_money=" + account_money +
            ", account_summoney=" + account_summoney +
            ", account_addtime='" + account_addtime + '\'' +
            '}';
  }
}
