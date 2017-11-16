package com.twjitm.common.entity.chat;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.InvalidProtocolBufferException;
import com.twjitm.common.annotation.MessageCommandAnntation;
import com.twjitm.common.entity.BaseMessage;
import com.twjitm.common.enums.MessageComm;
import com.twjitm.common.proto.BaseMessageProto;
import io.netty.handler.codec.CodecException;

/**
 * Created by 文江 on 2017/10/27.
 * 聊天消息类型
 */
@MessageCommandAnntation(messagecmd = MessageComm.PRIVATE_CHAT_MESSAGE)
public class ChatMessage extends BaseMessage {
    private int chatType;//文件，语言，文字，等
    private String context;//消息内容
    private long receiveUId;//接收者id
    private String receiveSession;//接收者session
    private String receiveNickName;//接收者昵称
    private String receiveHaldUrl;//接收者头像
    private boolean read;//接收者是否阅读


    public ChatMessage() {
        super(MessageComm.PRIVATE_CHAT_MESSAGE);
    }

    public void encodeNetProtoBufMessageBody() throws CodecException, Exception {

    }

    public ChatMessage(String json) {
        ChatMessage chatMessage = JSON.parseObject(json, ChatMessage.class);
        this.chatType = chatMessage.getChatType();
        this.context = chatMessage.getContext();
        this.read = chatMessage.isRead();
    }

    public void decodeBody(Object in) throws InvalidProtocolBufferException {

        BaseMessageProto.ChatMessageProBuf chatMessageProBuf = (BaseMessageProto.ChatMessageProBuf) in;

        this.chatType = chatMessageProBuf.getChatType();
        this.context = chatMessageProBuf.getContext();
        this.receiveUId = chatMessageProBuf.getReceiveUId();
        this.receiveSession = chatMessageProBuf.getReceiveSession();
        this.receiveNickName = chatMessageProBuf.getReceiveNickName();
        this.receiveHaldUrl = chatMessageProBuf.getReceiveHaldUrl();
        this.read = false;
    }

    public void encodeBody(Object out) {

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


    public String getReceiveNickName() {
        return receiveNickName;
    }

    public void setReceiveNickName(String receiveNickName) {
        this.receiveNickName = receiveNickName;
    }

    public String getReceiveHaldUrl() {
        return receiveHaldUrl;
    }

    public void setReceiveHaldUrl(String receiveHaldUrl) {
        this.receiveHaldUrl = receiveHaldUrl;
    }

    public long getReceiveUId() {
        return receiveUId;
    }

    public void setReceiveUId(long receiveUId) {
        this.receiveUId = receiveUId;
    }
}
