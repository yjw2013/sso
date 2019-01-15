package com.sso.domain.db;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;

/**
 * 用户实体类
 */
public class User {

    private Long id;

    @Length(min = 6, max = 20, message = "用户名的长度在6~20之间.")
    private String userName;

    @Length(min = 6, max = 20, message = "密码的长度在6~20之间.")
    private String pwd;

    @Length(min = 11, max = 11, message = "手机号的长度必须是11位.")
    private String phone;

    @Email(message = "邮箱地址的格式不正确.")
    private String email;

    private Timestamp gmtCreate;

    private Timestamp gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }
}
