package com.twjitm.common.logic.chat;

import com.twjitm.common.annotation.MessageCommandAnntation;
import com.twjitm.common.entity.chat.ChatMessage;
import com.twjitm.common.enums.MessageComm;
import com.twjitm.common.logic.handler.AbstractBaseHandler;
import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;

public abstract class ChatHandler extends AbstractBaseHandler {

    @MessageCommandAnntation(messagecmd = MessageComm.PRIVATE_CHAT_MESSAGE)
    public AbstractNettyNetProtoBufMessage chatMessage(ChatMessage chatMessage) {
        System.out.println("实现代理注解方法了");
        return chatMessageImpl(chatMessage);
    }

    public abstract AbstractNettyNetProtoBufMessage chatMessageImpl(ChatMessage chatMessage);

}
