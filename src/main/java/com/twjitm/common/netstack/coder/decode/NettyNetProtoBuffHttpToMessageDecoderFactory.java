package com.twjitm.common.netstack.coder.decode;

import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;
import io.netty.buffer.ByteBuf;

/**
 * Created by 文江 on 2017/11/16.
 */
public class NettyNetProtoBuffHttpToMessageDecoderFactory implements INettyNetProtoBuffHttpToMessageDecoderFactory{
    public AbstractNettyNetProtoBufMessage praseMessage(ByteBuf byteBuf) {
        return null;
    }
}
