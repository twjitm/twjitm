package com.twjitm.common.netstack.coder.decode;

import com.alibaba.dubbo.registry.RegistryFactory;
import com.twjitm.common.entity.BaseMessage;
import com.twjitm.common.factory.MessageRegistryFactory;
import com.twjitm.common.manager.LocalManager;
import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;
import com.twjitm.common.netstack.entity.NettyNetMessageHead;
import com.twjitm.common.netstack.entity.udp.NettyUDPMessageHead;
import io.netty.buffer.ByteBuf;

/**
 * Created by 文江 on 2017/11/16.
 * tcp解码器
 */
public class NettyNetProtoBuffTCPToMessageDecoerFactory implements INettyNetProtoBuffTCPToMessageDecoerFactory {

    public AbstractNettyNetProtoBufMessage praseMessage(ByteBuf byteBuf) {
        NettyNetMessageHead netMessageHead=new NettyUDPMessageHead();
        byteBuf.skipBytes(2);
        netMessageHead.setLength(byteBuf.readInt());
        netMessageHead.setVersion(byteBuf.readByte());
        //read message context
        //读取内容
        short cmd = byteBuf.readShort();
        netMessageHead.setCmd(cmd);
        netMessageHead.setSerial(byteBuf.readInt());
        MessageRegistryFactory registryFactory = LocalManager.getInstance().getRegistryFactory();
        BaseMessage nettyMessage = registryFactory.get(cmd);
        return null;
    }


}
