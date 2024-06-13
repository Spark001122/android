package com.example.jz.bean;
public class SzBean {
    private String num;
    private String date;
    private String type;
    private String price;
    private String yt;
    private String sm;


    public SzBean(String num, String date, String type, String price,String yt,String sm) {
        this.num = num;
        this.date = date;
        this.type = type;
        this.price = price;
        this.sm = sm;
        this.yt = yt;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    public SzBean() {
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }
}
