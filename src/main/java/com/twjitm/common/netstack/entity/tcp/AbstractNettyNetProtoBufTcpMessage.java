package com.twjitm.common.netstack.entity.tcp;

import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;
import com.twjitm.common.netstack.entity.NettyNetMessageHead;
import com.twjitm.common.netstack.entity.NettyNetProtoBufMessageBody;

/**
 * Created by 文江 on 2017/11/15.
 */
public abstract class AbstractNettyNetProtoBufTcpMessage extends AbstractNettyNetProtoBufMessage {
    public AbstractNettyNetProtoBufTcpMessage(String json) {
        super(json);
        setNettyNetMessageHead(new NettyNetMessageHead());
        setNettyNetMessageBody(new NettyNetProtoBufMessageBody());
        initHeadCommId();
    }
}
