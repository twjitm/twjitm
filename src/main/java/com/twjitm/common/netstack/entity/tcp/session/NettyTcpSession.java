package com.twjitm.common.netstack.entity.tcp.session;

import io.netty.channel.Channel;

/**
 * Created by 文江 on 2017/12/19.
 */
public class NettyTcpSession extends NettySession{

    public NettyTcpSession(Channel channel) {
        super(channel);
    }


}
