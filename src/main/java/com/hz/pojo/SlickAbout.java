package com.hz.pojo;


public class SlickAbout {

  private long about_id;
  private String about_title;
  private String about_icon;
  private String about_message;
  private long company_id;
  private SlickCompany slickCompany;

  public SlickCompany getSlickCompany() {
    return slickCompany;
  }

  public void setSlickCompany(SlickCompany slickCompany) {
    this.slickCompany = slickCompany;
  }

  public SlickAbout() {
  }

  public SlickAbout(long about_id, String about_title, String about_message) {
    super();
    this.about_id = about_id;
    this.about_title = about_title;
    this.about_message = about_message;
  }

  public long getCompany_id() {
    return company_id;
  }

  public void setCompany_id(long company_id) {
    this.company_id = company_id;
  }

  public long getAbout_id() {
    return about_id;
  }

  public void setAbout_id(long about_id) {
    this.about_id = about_id;
  }

  public String getAbout_title() {
    return about_title;
  }

  public void setAbout_title(String about_title) {
    this.about_title = about_title;
  }

  public String getAbout_icon() {
    return about_icon;
  }

  public void setAbout_icon(String about_icon) {
    this.about_icon = about_icon;
  }

  public String getAbout_message() {
    return about_message;
  }

  public void setAbout_message(String about_message) {
    this.about_message = about_message;
  }

  @Override
  public String toString() {
    return "SlickAbout{" +
            "about_id=" + about_id +
            ", about_title='" + about_title + '\'' +
            ", about_icon='" + about_icon + '\'' +
            ", about_message='" + about_message + '\'' +
            '}';
  }
}
