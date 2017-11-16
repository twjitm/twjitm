package com.twjitm.common.logic.chat.Impl;

import com.twjitm.common.entity.chat.ChatMessage;
import com.twjitm.common.logic.chat.ChatHandler;
import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;

public class ChatHandlerImpl extends ChatHandler {
    //业务逻辑代码了
    public AbstractNettyNetProtoBufMessage chatMessageImpl(ChatMessage chatMessage) {
        // chatMessage.getSendUid();
        System.out.println("注解分离消息机制----------");

        return null;
    }

}
