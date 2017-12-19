package com.twjitm.common.netstack.entity.tcp.session;

import com.twjitm.common.netstack.entity.AbstractNettyNetMessage;
import io.netty.channel.Channel;

/**
 * Created by 文江 on 2017/12/19.
 */
public abstract class NettySession implements ISession {
    protected volatile Channel channel;
    private long playerId;

    public NettySession(Channel channel) {
        this.channel = channel;
    }

    public boolean isConnected() {
        if (channel != null) {
            return channel.isActive();
        }
        return false;
    }

    public void write(AbstractNettyNetMessage msg) throws Exception {
        if (msg != null) {
            if (channel != null) {
                channel.writeAndFlush(msg);
            }
        }
    }

    public void write(byte[] msg) {
        if (channel != null) {
            if (msg != null) {
                channel.writeAndFlush(msg);
            }
        }
    }

    public void close(boolean immediately) {
        if (channel != null) {
            channel.close();
        }
    }

    public boolean closeOnException() {
        return true;
    }
//----------------------------GETER AND SETTER--------------------
    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}

