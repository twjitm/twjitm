package com.twjitm.common.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by 文江 on 2017/10/27.
 */
public class BaseMessage implements Serializable {
    private long MessageId;
    private long commId;
    private String sendIp;
    private int messageType;

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

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public BaseMessage() {
    }

    public BaseMessage(String json) {
        BaseMessage baseMessage = JSON.parseObject(json, BaseMessage.class);
        this.commId = baseMessage.getCommId();
        this.MessageId = baseMessage.getMessageId();
        this.messageType = baseMessage.getMessageType();
        this.sendIp = baseMessage.getSendIp();
    }

    public String desSerializable() {
        String jsonString = JSON.toJSONString(this);
        return jsonString;
    }
}
