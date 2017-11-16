package com.twjitm.common.netstack.entity.tcp;

import com.twjitm.common.netstack.entity.AbstractNetProtoBufMessage;
import com.twjitm.common.netstack.entity.NettyNetMessageHead;
import com.twjitm.common.netstack.entity.NettyNetProtoBufMessageBody;

/**
 * Created by 文江 on 2017/11/15.
 */
public abstract class AbstractNettyNetProtoBufTcpMessage extends AbstractNetProtoBufMessage {
    public AbstractNettyNetProtoBufTcpMessage() {
        super();
        setNettyNetMessageHead(new NettyNetMessageHead());
        setNettyNetMessageBody(new NettyNetProtoBufMessageBody());
        initHeadCommId();
    }
}
