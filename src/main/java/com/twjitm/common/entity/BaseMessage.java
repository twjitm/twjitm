package com.twjitm.common.entity;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.InvalidProtocolBufferException;
import com.twjitm.common.enums.MessageComm;
import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;
import com.twjitm.common.proto.BaseMessageProto;
import io.netty.buffer.ByteBuf;

import java.io.Serializable;

/**
 * Created by 文江 on 2017/10/27.
 */
public abstract class BaseMessage extends AbstractNettyNetProtoBufMessage implements IMessage, Serializable {
    //辅助字段
    public static final short MESSAGE_COMMID_INDEX = 0;

    //session
    private long sessionId;
    //协议id
    private int commId;
    //总长度
    private int length;
    //用户id
    private long uId;
    //时间
    private long timeStamp;


    public int getCommId() {
        return commId;
    }

    public void setCommId(int commId) {
        this.commId = commId;
    }


    public BaseMessage() {
    }

    public BaseMessage(MessageComm comm) {
        commId = comm.commId;
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

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
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


    public final void decodeMessage(Object in) throws Exception {
       // decodeBody(in);
        decodeHeader(in);
    }


    public final void encodeMessage(ByteBuf out) {
        encodeHeader(out);
        encodeBody(out);
    }

    public final void decodeHeader(Object in) throws InvalidProtocolBufferException {
        BaseMessageProto.BaseMessageProBuf baseMessageProBuf = (BaseMessageProto.BaseMessageProBuf) in;
        this.sessionId = baseMessageProBuf.getSessionId();
        this.commId = baseMessageProBuf.getCommid();
        this.length = baseMessageProBuf.getLength();
        this.uId = baseMessageProBuf.getUId();
        this.timeStamp = System.currentTimeMillis();
    }

    public final void encodeHeader(Object out) {
        BaseMessageProto.BaseMessageProBuf baseMessageProBuf = (BaseMessageProto.BaseMessageProBuf) out;

    }


    public abstract void decodeBody(Object in) throws InvalidProtocolBufferException;

    public abstract void encodeBody(Object out);


}
