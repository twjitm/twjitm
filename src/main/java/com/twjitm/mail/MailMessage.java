package com.twjitm.mail;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/9.
 */
public class MailMessage {
    private String context;
    private Date date;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
