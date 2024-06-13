package com.example.jz.bean;

public class UserBean {
    private String username;
    private String password;
    private String phone;
    private String sex;
    private String address;

    public UserBean(String username, String password, String phone, String sex, String address) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.address = address;
    }

    public UserBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
