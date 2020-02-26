package com.hz.pojo;


public class SlickAdmin {

  private Long admin_id;
  private String admin_name;
  private String admin_pwd;
  private Long admin_role_id;
  private String admin_addtime;
  private String admin_login_endtime;
  private long admin_login_number;
  private Long admin_state;
  private long company_id;
  private SlickRole slickRole;

  public SlickRole getSlickRole() {
    return slickRole;
  }

  public void setSlickRole(SlickRole slickRole) {
    this.slickRole = slickRole;
  }

  public SlickAdmin() {
  }

  public Long getAdmin_id() {
    return admin_id;
  }

  public void setAdmin_id(Long admin_id) {
    this.admin_id = admin_id;
  }

  public String getAdmin_name() {
    return admin_name;
  }

  public void setAdmin_name(String admin_name) {
    this.admin_name = admin_name;
  }

  public String getAdmin_pwd() {
    return admin_pwd;
  }

  public void setAdmin_pwd(String admin_pwd) {
    this.admin_pwd = admin_pwd;
  }

  public Long getAdmin_role_id() {
    return admin_role_id;
  }

  public void setAdmin_role_id(Long admin_role_id) {
    this.admin_role_id = admin_role_id;
  }

  public String getAdmin_addtime() {
    return admin_addtime;
  }

  public void setAdmin_addtime(String admin_addtime) {
    this.admin_addtime = admin_addtime;
  }

  public String getAdmin_login_endtime() {
    return admin_login_endtime;
  }

  public void setAdmin_login_endtime(String admin_login_endtime) {
    this.admin_login_endtime = admin_login_endtime;
  }

  public long getAdmin_login_number() {
    return admin_login_number;
  }

  public void setAdmin_login_number(long admin_login_number) {
    this.admin_login_number = admin_login_number;
  }

  public Long getAdmin_state() {
    return admin_state;
  }

  public void setAdmin_state(Long admin_state) {
    this.admin_state = admin_state;
  }

  public long getCompany_id() {
    return company_id;
  }

  public void setCompany_id(long company_id) {
    this.company_id = company_id;
  }
}
