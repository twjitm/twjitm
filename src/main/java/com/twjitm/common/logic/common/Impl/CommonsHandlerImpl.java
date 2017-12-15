package com.twjitm.common.logic.common.Impl;

import com.twjitm.common.entity.common.HeartbeatMessage;
import com.twjitm.common.logic.common.CommonsHandler;
import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;
import com.twjitm.common.netstack.entity.NettyNetMessageBody;

/**
 * Created by 文江 on 2017/12/15.
 */
public class CommonsHandlerImpl extends CommonsHandler {
    public AbstractNettyNetProtoBufMessage handlerHeatMesssegeImpl(HeartbeatMessage heartbeatMessage) {
        NettyNetMessageBody body = heartbeatMessage.getNetMessageBody();
        //body.getBytes();
        System.out.println("---------------------发送心跳协议啦！-------------");
        return null;
    }
}
