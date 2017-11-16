package com.twjitm.common.dispatcher;


import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;

public interface IDispatcher {
    public AbstractNettyNetProtoBufMessage dispatcher(AbstractNettyNetProtoBufMessage message);
}
