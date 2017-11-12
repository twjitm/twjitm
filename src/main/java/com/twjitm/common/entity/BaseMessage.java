package com.twjitm.common.entity;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;

import java.io.Serializable;

/**
 * Created by 文江 on 2017/10/27.
 */
public abstract class BaseMessage implements IMessage, Serializable {
    //辅助字段
    public static final short MESSAGE_COMMID_INDEX = 0;


    private long sessionId;
    private int commId;
    private String sendIp;
    private int messageType;


    public int getCommId() {
        return commId;
    }

    public void setCommId(int commId) {
        this.commId = commId;
    }

    public String getSendIp() {
        return sendIp;
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
        this.messageType = baseMessage.getMessageType();
        this.sendIp = baseMessage.getSendIp();
        this.sessionId = baseMessage.getSessionId();
    }

    public String desSerializable() {
        String jsonString = JSON.toJSONString(this);
        return jsonString;
    }

    public long getSessionId() {
        return sessionId;
    }

    public int getCommandId() {
        return commId;
    }

    public int getSerial() {
        return 0;
    }


    public void release() {

    }

    public long getUserId() {
        return 0;
    }

    public String toAllInfoString() {
        return null;
    }


    public final void decode(ByteBuf in) {
        decodeHeader(in);
        decodeBody(in);
    }


    public final void encode(ByteBuf out) {
        encodeHeader(out);
        encodeBody(out);
    }

    public final void decodeHeader(ByteBuf in) {

    }

    public final void encodeHeader(ByteBuf out) {

    }


    public abstract void decodeBody(ByteBuf in);

    public abstract void encodeBody(ByteBuf out);


}
