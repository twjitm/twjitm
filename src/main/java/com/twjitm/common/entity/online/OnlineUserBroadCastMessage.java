package com.twjitm.common.entity.online;

import com.alibaba.fastjson.JSON;
import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;
import com.twjitm.user.entity.User;
import io.netty.handler.codec.CodecException;

/**
 * 玩家广播上线／下现消息
 */
public class OnlineUserBroadCastMessage extends AbstractNettyNetProtoBufMessage {
    private User user;//上线／下限用户
    private int outOrInType;//类型
    private long messageTime;//时间

    public OnlineUserBroadCastMessage() {
        super(null);
    }

    public void release() throws CodecException {

    }

    public void encodeNetProtoBufMessageBody() throws CodecException, Exception {

    }

    public void decoderNetProtoBufMessageBody() throws CodecException, Exception {

    }

    public OnlineUserBroadCastMessage(String json) {

        super(json);
        OnlineUserBroadCastMessage broadCastMessage = (OnlineUserBroadCastMessage) JSON.parse(json);
        this.messageTime = broadCastMessage.getMessageTime();
        this.user = broadCastMessage.getUser();
        this.outOrInType = broadCastMessage.getOutOrInType();
    }

    public void decoderNetJsonMessageBody(String json) {

    }

    public void encodeNetJsonMessageBody(String json) {

    }

    public void decodeBody(Object in) {

    }

    public void encodeBody(Object out) {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOutOrInType() {
        return outOrInType;
    }

    public void setOutOrInType(int outOrInType) {
        this.outOrInType = outOrInType;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
