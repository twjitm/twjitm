package com.twjitm.common.entity;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;

import java.io.Serializable;

/**
 * Created by 文江 on 2017/10/27.
 */
public abstract class BaseMessage implements IMessage,Serializable {
    private long MessageId;
    private int commId;
    private long uid;
    private String sendIp;
    private int messageType;

    public long getMessageId() {
        return MessageId;
    }

    public void setMessageId(long messageId) {
        MessageId = messageId;
    }

    public int getCommId() {
        return commId;
    }

    public void setCommId(int commId) {
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

    public long getSessionId() {
        return MessageId;
    }

    public int getCommandId() {
        return commId;
    }

    public int getSerial() {
        return 0;
    }

    public long getUserId() {
        return uid;
    }

    public void release() {

    }

    public String toAllInfoString() {
        return null;
    }



    public final  void decode(ByteBuf in){
        decodeHeader(in);
        decodeBody(in);
    }


    public  final void encode(ByteBuf out){
        encodeHeader(out);
        encodeBody(out);
    }
    public final  void decodeHeader(ByteBuf in){

    }
    public final  void encodeHeader(ByteBuf out){

    }



    public abstract void decodeBody(ByteBuf in);
    public abstract void encodeBody(ByteBuf out);


}
