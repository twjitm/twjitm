package com.twjitm.common.logic.chat;

import com.twjitm.common.annotation.MessageCommandAnntation;
import com.twjitm.common.entity.BaseMessage;
import com.twjitm.common.entity.chat.ChatMessage;
import com.twjitm.common.enums.MessageComm;
import com.twjitm.common.logic.handler.AbstractBaseHandler;

public abstract class ChatHandler extends AbstractBaseHandler {

    @MessageCommandAnntation(messagecmd = MessageComm.PRIVATE_CHAT_MESSAGE)
    public BaseMessage chatMessage(ChatMessage chatMessage) {

        return chatMessageImp(chatMessage);
    }

    public abstract BaseMessage chatMessageImp(ChatMessage chatMessage);

}
