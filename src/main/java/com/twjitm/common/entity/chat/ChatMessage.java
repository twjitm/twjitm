package com.twjitm.common.entity.chat;

import com.alibaba.fastjson.JSON;
import com.twjitm.common.entity.BaseMessage;

/**
 * Created by 文江 on 2017/10/27.
 * 聊天消息类型
 */
public class ChatMessage extends BaseMessage {
    private String sendUid;
    private String sendSession;
    private int chatType;
    private String context;
    private String receiveUid;
    private String receiveSession;
    private boolean read;
    private int chatContextType;
    private long messageTime;

    public ChatMessage() {

    }

    public ChatMessage(String json) {
        super(json);
        ChatMessage chatMessage = JSON.parseObject(json, ChatMessage.class);
        this.sendUid = chatMessage.getSendUid();
        this.sendSession = chatMessage.getSendSession();
        this.chatType = chatMessage.getChatType();
        this.context = chatMessage.getContext();
        this.receiveUid = chatMessage.getReceiveUid();
        this.receiveSession = chatMessage.getSendSession();
        this.read = chatMessage.isRead();
        this.chatContextType = chatMessage.getChatContextType();
        this.messageTime = chatMessage.getMessageTime();
    }

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

    public int getChatContextType() {
        return chatContextType;
    }

    public void setChatContextType(int chatContextType) {
        this.chatContextType = chatContextType;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
