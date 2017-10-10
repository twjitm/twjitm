package com.twjitm.common.message;

/**
 * Created by 文江 on 2017/10/10.
 */
public class Message {
    private int cmdId;
    private int methId;
    private String session;
    private Object context;

    public int getCmdId() {
        return cmdId;
    }

    public void setCmdId(int cmdId) {
        this.cmdId = cmdId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }

    public int getMethId() {
        return methId;
    }

    public void setMethId(int methId) {
        this.methId = methId;
    }
}
