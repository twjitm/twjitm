package com.twjitm.common.entity.chat;

import com.twjitm.common.entity.BaseMessage;

import java.util.List;

public class BoradCastAllChatMessage extends BaseMessage {
    private List<ChatMessage> messages;

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}
