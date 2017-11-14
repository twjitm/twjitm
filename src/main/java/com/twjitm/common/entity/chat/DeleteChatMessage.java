package com.twjitm.common.entity.chat;

import com.twjitm.common.annotation.MessageCommandAnntation;
import com.twjitm.common.entity.BaseMessage;
import com.twjitm.common.enums.MessageComm;

/**
 * 删除聊天消息
 */
@MessageCommandAnntation(messagecmd = MessageComm.DELETE_CHAT_MESSAGE)
public class DeleteChatMessage extends BaseMessage {


    public DeleteChatMessage() {
        super(MessageComm.DELETE_CHAT_MESSAGE);
    }

    public void decodeBody(Object in) {

    }

    public void encodeBody(Object out) {

    }


}
