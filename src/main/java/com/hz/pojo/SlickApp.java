package com.hz.pojo;


public class SlickApp {

  private long app_id;
  private String app_name;
  private double app_price;
  private String app_message;
  private long company_id;

  private String app_image_address;
  private SlickCompany slickCompany;
  private SlickIndustry slickIndustry;

  public SlickApp() {
  }

  public SlickApp(long app_id, String app_name, double app_price, String app_message) {
    this.app_id = app_id;
    this.app_name = app_name;
    this.app_price = app_price;
    this.app_message = app_message;
  }

  public SlickCompany getSlickCompany() {
    return slickCompany;
  }

  public void setSlickCompany(SlickCompany slickCompany) {
    this.slickCompany = slickCompany;
  }
  public long getCompany_id() {
    return company_id;
  }
  public SlickIndustry getSlickIndustry() {
    return slickIndustry;
  }

  public void setSlickIndustry(SlickIndustry slickIndustry) {
    this.slickIndustry = slickIndustry;
  }

  public String getApp_image_address() {
    return app_image_address;
  }

  public void setApp_image_address(String app_image_address) {
    this.app_image_address = app_image_address;
  }

  public void setCompany_id(long company_id) {
    this.company_id = company_id;
  }

  public long getApp_id() {
    return app_id;
  }

  public void setApp_id(long app_id) {
    this.app_id = app_id;
  }

  public String getApp_name() {
    return app_name;
  }

  public void setApp_name(String app_name) {
    this.app_name = app_name;
  }

  public double getApp_price() {
    return app_price;
  }

  public void setApp_price(double app_price) {
    this.app_price = app_price;
  }

  public String getApp_message() {
    return app_message;
  }

  public void setApp_message(String app_message) {
    this.app_message = app_message;
  }
}
