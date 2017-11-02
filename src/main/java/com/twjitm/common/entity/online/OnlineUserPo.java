package com.twjitm.common.entity.online;

import com.twjitm.user.entity.User;
import io.netty.channel.Channel;

/**
 * Created by 文江 on 2017/10/28.
 */
public class OnlineUserPo extends User {
    private Channel channel;
    private String sessionId;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
