package com.twjitm.common.entity.chat;

import com.twjitm.common.annotation.MessageCommandAnntation;
import com.twjitm.common.entity.BaseMessage;
import com.twjitm.common.enums.MessageComm;
import io.netty.buffer.ByteBuf;

import java.util.List;

@MessageCommandAnntation(messagecmd = MessageComm.PUBLIC_CHART_MESSAGE)
public class BoradCastAllChatMessage extends BaseMessage {
    private List<ChatMessage> messages;

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public void decodeBody(ByteBuf in) {
    }

    public void encodeBody(ByteBuf out) {

    }
}
