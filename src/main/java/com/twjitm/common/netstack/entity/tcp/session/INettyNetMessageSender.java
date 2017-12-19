package com.twjitm.common.netstack.entity.tcp.session;

import com.twjitm.common.exception.NetMessageException;
import com.twjitm.common.netstack.entity.AbstractNettyNetMessage;

/**
 * 消息处理器
 */
public interface INettyNetMessageSender {
    /**
     * 发送消息
     * @param abstractNetMessage
     * @return
     */
    public boolean sendMessage(AbstractNettyNetMessage abstractNetMessage) throws NetMessageException;

    /**
     * 关闭
     */
    public void close()throws NetMessageException;
}
