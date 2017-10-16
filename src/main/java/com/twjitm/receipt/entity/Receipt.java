package com.twjitm.receipt.entity;

import java.util.Date;

/**
 * Created by 文江 on 2017/9/6.
 * 日常消费报表
 */
public class Receipt {
    private int uid;
    private double money;

    private Date inTime;

    private int Id;

    private String remarke;

    private int state;
    //用户名：前台用
    private String userNameVS;

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public int getUid() {
        return uid;
    }


    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRemarke() {
        return remarke;
    }

    public void setRemarke(String remarke) {
        this.remarke = remarke;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUserNameVS() {
        return userNameVS;
    }

    public void setUserNameVS(String userNameVS) {
        this.userNameVS = userNameVS;
    }
}
