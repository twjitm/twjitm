package com.twjitm.common.entity;

import java.io.Serializable;

/**
 * Created by 文江 on 2017/10/27.
 */
public class BaseMessage implements Serializable {
    private long MessageId;
    private long commId;
    private String sendIp;

    public long getMessageId() {
        return MessageId;
    }

    public void setMessageId(long messageId) {
        MessageId = messageId;
    }

    public long getCommId() {
        return commId;
    }

    public void setCommId(long commId) {
        this.commId = commId;
    }

    public String getSendIp() {
        return sendIp;
    }

    public void setSendIp(String sendIp) {
        this.sendIp = sendIp;
    }
}
