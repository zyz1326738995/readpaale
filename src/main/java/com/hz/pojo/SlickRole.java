package com.hz.pojo;


public class SlickRole {

  private long role_id;
  private String role_name;
  private String role_remarks;
  private long role_number;
  private long company_id;
  public long getCompany_id() {
    return company_id;
  }

  public void setCompany_id(long company_id) {
    this.company_id = company_id;
  }

  public long getRole_id() {
    return role_id;
  }

  public void setRole_id(long role_id) {
    this.role_id = role_id;
  }

  public String getRole_name() {
    return role_name;
  }

  public void setRole_name(String role_name) {
    this.role_name = role_name;
  }

  public String getRole_remarks() {
    return role_remarks;
  }

  public void setRole_remarks(String role_remarks) {
    this.role_remarks = role_remarks;
  }

  public long getRole_number() {
    return role_number;
  }

  public void setRole_number(long role_number) {
    this.role_number = role_number;
  }
}
