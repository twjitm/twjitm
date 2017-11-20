package com.twjitm.test.netty.client;

import com.twjitm.common.netstack.coder.decode.NettyNetProtoBufMessageTCPDecoder;
import com.twjitm.common.netstack.coder.encode.NettyNetProtoBufMessageTCPEncoder;
import com.twjitm.common.netstack.coder.encode.RepeatNettyMessageEccoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * Created by 文江 on 2017/11/13.
 */
public class TestChannelInitializer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
        //ch.pipeline().addLast(new ProtobufEncoder());
       // ch.pipeline().addLast(new RepeatNettyMessageEccoder());
        int maxLength=Integer.MAX_VALUE;
        ch.pipeline().addLast("frame", new LengthFieldBasedFrameDecoder(maxLength, 2, 4, 0, 0));
        ch.pipeline().addLast(new NettyNetProtoBufMessageTCPEncoder());
        ch.pipeline().addLast(new NettyNetProtoBufMessageTCPDecoder());
        ch.pipeline().addLast(new TestClientHandler());
    }


}
