package com.hz.pojo;


public class SlickUser {

  private long user_id;
  private String user_name;
  private long user_industry_id;
  private String user_message;
  private String user_addtime;
  private double user_budget;
  private String use_phone;
  private long company_id;
  private SlickIndustry slickIndustry;
  private SlickApp slickApp;

  public SlickApp getSlickApp() {
    return slickApp;
  }

  public void setSlickApp(SlickApp slickApp) {
    this.slickApp = slickApp;
  }

  public SlickIndustry getSlickIndustry() {
    return slickIndustry;
  }

  public void setSlickIndustry(SlickIndustry slickIndustry) {
    this.slickIndustry = slickIndustry;
  }

  public long getCompany_id() {
    return company_id;
  }

  public void setCompany_id(long company_id) {
    this.company_id = company_id;
  }

  public SlickUser() {
  }

  public SlickUser(String user_name, long user_industry_id, String user_message, double user_budget, String use_phone,long company_id) {
    this.user_name = user_name;
    this.user_industry_id = user_industry_id;
    this.user_message = user_message;
    this.user_budget = user_budget;
    this.use_phone = use_phone;
    this.company_id = company_id;
  }

  public long getUser_id() {
    return user_id;
  }

  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public long getUser_industry_id() {
    return user_industry_id;
  }

  public void setUser_industry_id(long user_industry_id) {
    this.user_industry_id = user_industry_id;
  }

  public String getUser_message() {
    return user_message;
  }

  public void setUser_message(String user_message) {
    this.user_message = user_message;
  }

  public String getUser_addtime() {
    return user_addtime;
  }

  public void setUser_addtime(String user_addtime) {
    this.user_addtime = user_addtime;
  }

  public double getUser_budget() {
    return user_budget;
  }

  public void setUser_budget(double user_budget) {
    this.user_budget = user_budget;
  }

  public String getUse_phone() {
    return use_phone;
  }

  public void setUse_phone(String use_phone) {
    this.use_phone = use_phone;
  }

  @Override
  public String toString() {
    return "SlickUser{" +
            "user_name='" + user_name + '\'' +
            ", user_industry_id=" + user_industry_id +
            ", user_message='" + user_message + '\'' +
            ", user_budget=" + user_budget +
            ", use_phone='" + use_phone + '\'' +
            '}';
  }
}
