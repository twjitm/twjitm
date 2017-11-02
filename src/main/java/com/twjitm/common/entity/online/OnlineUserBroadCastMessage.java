package com.twjitm.common.entity.online;

import com.twjitm.common.entity.BaseMessage;
import com.twjitm.user.entity.User;

import java.net.UnknownServiceException;
import java.util.Date;

/**
 * 玩家广播上线／下现消息
 */
public class OnlineUserBroadCastMessage  extends BaseMessage{
private User user;//上线／下限用户
private int messageType;//类型
private long messageTime;//时间

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
