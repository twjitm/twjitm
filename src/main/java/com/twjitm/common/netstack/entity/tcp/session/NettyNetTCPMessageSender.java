package com.twjitm.common.netstack.entity.tcp.session;

import com.twjitm.common.exception.NetMessageException;
import com.twjitm.common.netstack.entity.AbstractNettyNetMessage;
import io.netty.channel.Channel;

/**
 * Created by 文江 on 2017/12/19.
 * 消息发送器
 */
public class NettyNetTCPMessageSender implements INettyNetMessageSender {
     private NettySession nettySession;

    public NettyNetTCPMessageSender(NettySession nettySession) {
        this.nettySession = nettySession;
    }


    public boolean sendMessage(AbstractNettyNetMessage abstractNetMessage) throws NetMessageException {
        try {
            nettySession.write(abstractNetMessage);
        } catch (Exception e) {
            System.out.println(this.getClass().getName()+"sendMessage():发送信息失败！-----------");
            throw new NetMessageException("write tcp netmessage exception", e);
        }
        return true;
    }

    public void close() {
        Channel channel = nettySession.getChannel();
        if(channel!=null){
            if(channel.isActive()){
                channel.close();
            }else {
                channel.close();
            }
        }

    }
}
