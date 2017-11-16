package com.twjitm.common.initalizer;

import com.twjitm.common.netstack.coder.decode.NettyNetProtoBufMessageTCPDecoder;
import com.twjitm.common.netstack.coder.decode.RepeatNettyMessageDecoder;
import com.twjitm.common.netstack.coder.encode.NettyNetProtoBufMessageTCPEncoder;
import com.twjitm.common.netstack.coder.encode.RepeatNettyMessageEccoder;
import com.twjitm.common.proto.BaseMessageProto;
import com.twjitm.test.netty.server.TestServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

/**
 * Created by 文江 on 2017/9/25.
 */
public class WebsocketChatServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) throws Exception {//2
        ChannelPipeline pipeline = ch.pipeline();

         //pipeline.addLast(new HttpServerCodec());
        // pipeline.addLast(new HttpObjectAggregator(64 * 1024));
        //  pipeline.addLast(new ChunkedWriteHandler());
        //请求handler
        // pipeline.addLast(new HttpRequestHandler("/ws"));
        // pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        //pipeline.addLast(new NettyCommonSessionWebSocketHandler());
       pipeline.addLast(new ProtobufVarint32FrameDecoder());
       // pipeline.addLast(new RepeatNettyMessageDecoder());
        pipeline.addLast(new NettyNetProtoBufMessageTCPDecoder());
        pipeline.addLast(new NettyNetProtoBufMessageTCPEncoder());
        pipeline.addLast(new TestServerHandler());
    }
}
