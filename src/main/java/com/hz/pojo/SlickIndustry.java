package com.hz.pojo;


public class SlickIndustry {

  private long industry_id;
  private String industry_name;
  private long industry_app_id;
  private String industry_introduce;
  private String industry_icon;
  private long company_id;
  private SlickCompany slickCompany;

  public SlickIndustry() {
  }

  public SlickIndustry(long industry_id, String industry_name, String industry_introduce) {
    super();
    this.industry_id = industry_id;
    this.industry_name = industry_name;
    this.industry_introduce = industry_introduce;
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

  public void setCompany_id(long company_id) {
    this.company_id = company_id;
  }
  public String getIndustry_icon() {
    return industry_icon;
  }

  public void setIndustry_icon(String industry_icon) {
    this.industry_icon = industry_icon;
  }

  public long getIndustry_id() {
    return industry_id;
  }

  public void setIndustry_id(long industry_id) {
    this.industry_id = industry_id;
  }

  public String getIndustry_name() {
    return industry_name;
  }

  public void setIndustry_name(String industry_name) {
    this.industry_name = industry_name;
  }

  public long getIndustry_app_id() {
    return industry_app_id;
  }

  public void setIndustry_app_id(long industry_app_id) {
    this.industry_app_id = industry_app_id;
  }

  public String getIndustry_introduce() {
    return industry_introduce;
  }

  public void setIndustry_introduce(String industry_introduce) {
    this.industry_introduce = industry_introduce;
  }
}
