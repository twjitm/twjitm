package com.twjitm.common;

import com.twjitm.common.initalizer.WebsocketChatServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by 文江 on 2017/9/25.
 */

public class RealcomServer {
    private static RealcomServer realcomServer;
    private Logger logger = LogManager.getLogManager().getLogger(RealcomServer.class.getName());

    public static RealcomServer getInItStance() {
        if (realcomServer == null) {
            return realcomServer = new RealcomServer();
        }
        return realcomServer;
    }

    public void startServer() {
      /*  Properties properties=new Properties();
        properties.load();*/
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new WebsocketChatServerInitializer())  //(4)
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
            logger.info("WebsocketChatServer 启动了");

            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind("127.0.0.1", 8088).sync(); // (7)
            // 等待服务器  socket 关闭 。
            // 在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            logger.info("WebsocketChatServer 关闭了");
        }
    }

    public void stopServer() {

    }

    public static void main(String[] args) {
        RealcomServer.getInItStance().startServer();
    }

}
