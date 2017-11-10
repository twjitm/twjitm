package com.twjitm.common.logic.chat.Impl;

import com.twjitm.common.entity.BaseMessage;
import com.twjitm.common.entity.chat.ChatMessage;
import com.twjitm.common.logic.chat.ChatHandler;

public class ChatHandlerImpl extends ChatHandler {
    //业务逻辑代码了
    public BaseMessage chatMessageImpl(ChatMessage chatMessage) {
        // chatMessage.getSendUid();
        System.out.println("注解分离消息机制----------");

        return null;
    }

}
