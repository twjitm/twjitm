package com.twjitm.test.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created by 文江 on 2017/11/13.
 */
public class Client {
    public static void main(String[] args) {
        startup("127.0.0.1",8080);
    }

    public static void  startup(String ip,int port){
        EventLoopGroup eventExecutors= new NioEventLoopGroup();
        Bootstrap bootstrap=new Bootstrap();
        bootstrap.bind(ip,port);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.TCP_NODELAY,true);
        bootstrap.handler(new TestChannelInitializer());
// 发起异步连接操作
        try {
            ChannelFuture future =bootstrap.connect(
                    new InetSocketAddress(ip, port),
                    new InetSocketAddress(ip,
                            port)).sync();
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
