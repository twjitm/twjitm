package com.twjitm.common.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by 文江 on 2017/10/27.
 */
public class ChatMessage extends BaseMessage {
    private String sendUid;
    private String sendSession;
    private int messageType;
    private int chatType;
    private String context;
    private String receiveUid;
    private String receiveSession;
    private boolean read;


    public String getSendUid() {
        return sendUid;
    }

    public void setSendUid(String sendUid) {
        this.sendUid = sendUid;
    }

    public String getSendSession() {
        return sendSession;
    }

    public void setSendSession(String sendSession) {
        this.sendSession = sendSession;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getChatType() {
        return chatType;
    }

    public void setChatType(int chatType) {
        this.chatType = chatType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getReceiveUid() {
        return receiveUid;
    }

    public void setReceiveUid(String receiveUid) {
        this.receiveUid = receiveUid;
    }

    public String getReceiveSession() {
        return receiveSession;
    }

    public void setReceiveSession(String receiveSession) {
        this.receiveSession = receiveSession;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public ChatMessage serializable(String json) {
        ChatMessage obj = (ChatMessage) JSON.parse(json);
        return obj;
    }
}
