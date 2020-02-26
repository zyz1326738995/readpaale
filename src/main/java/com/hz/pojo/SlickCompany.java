package com.hz.pojo;


import java.util.List;

public class SlickCompany {


  private String company_name;
  private String company_title;
  private String company_hot_message;
  private String company_hot_message2;
  private String copy_gufen;
  private long company_id;
  private String company_image;
  private List<SlickApp> slickAppList;
  private List<SlickIndustry> slickIndustryList;
  private List<SlickAbout> slickAboutList;

  public SlickCompany() {
  }

  public SlickCompany(String company_name, String company_title, String company_hot_message, String company_hot_message2, String copy_gufen, long company_id) {
    this.company_name = company_name;
    this.company_title = company_title;
    this.company_hot_message = company_hot_message;
    this.company_hot_message2 = company_hot_message2;
    this.copy_gufen = copy_gufen;
    this.company_id = company_id;
  }

  public List<SlickApp> getSlickAppList() {
    return slickAppList;
  }

  public void setSlickAppList(List<SlickApp> slickAppList) {
    this.slickAppList = slickAppList;
  }

  public List<SlickIndustry> getSlickIndustryList() {
    return slickIndustryList;
  }

  public void setSlickIndustryList(List<SlickIndustry> slickIndustryList) {
    this.slickIndustryList = slickIndustryList;
  }

  public List<SlickAbout> getSlickAboutList() {
    return slickAboutList;
  }

  public void setSlickAboutList(List<SlickAbout> slickAboutList) {
    this.slickAboutList = slickAboutList;
  }

  public String getCompany_image() {
    return company_image;
  }

  public void setCompany_image(String company_image) {
    this.company_image = company_image;
  }

  public long getCompany_id() {
    return company_id;
  }

  public void setCompany_id(long company_id) {
    this.company_id = company_id;
  }

  public String getCompany_name() {
    return company_name;
  }

  public void setCompany_name(String company_name) {
    this.company_name = company_name;
  }

  public String getCompany_title() {
    return company_title;
  }

  public void setCompany_title(String company_title) {
    this.company_title = company_title;
  }

  public String getCompany_hot_message() {
    return company_hot_message;
  }

  public void setCompany_hot_message(String company_hot_message) {
    this.company_hot_message = company_hot_message;
  }

  public String getCompany_hot_message2() {
    return company_hot_message2;
  }

  public void setCompany_hot_message2(String company_hot_message2) {
    this.company_hot_message2 = company_hot_message2;
  }

  public String getCopy_gufen() {
    return copy_gufen;
  }

  public void setCopy_gufen(String copy_gufen) {
    this.copy_gufen = copy_gufen;
  }

  @Override
  public String toString() {
    return "SlickCompany{" +
            "company_id=" + company_id +
            ", company_name='" + company_name + '\'' +
            ", company_title='" + company_title + '\'' +
            ", company_hot_message='" + company_hot_message + '\'' +
            ", company_hot_message2='" + company_hot_message2 + '\'' +
            ", copy_gufen='" + copy_gufen + '\'' +
            '}';
  }
}
