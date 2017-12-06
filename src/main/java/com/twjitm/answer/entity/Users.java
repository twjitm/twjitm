package com.twjitm.answer.entity;

public class Users {
    private Integer id;

    private String uName;

    private String uAccount;

    private String uPsd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount == null ? null : uAccount.trim();
    }

    public String getuPsd() {
        return uPsd;
    }

    public void setuPsd(String uPsd) {
        this.uPsd = uPsd == null ? null : uPsd.trim();
    }
}