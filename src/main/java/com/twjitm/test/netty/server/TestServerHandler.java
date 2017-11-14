package com.twjitm.test.netty.server;

import com.alibaba.fastjson.JSON;
import com.twjitm.common.dispatcher.Dispatcher;
import com.twjitm.common.entity.BaseMessage;
import com.twjitm.common.entity.online.OnlineUserBroadCastMessage;
import com.twjitm.common.entity.online.OnlineUserPo;
import com.twjitm.common.enums.MessageComm;
import com.twjitm.common.handler.NettyCommonSessionWebSocketHandler;
import com.twjitm.common.manager.LocalManager;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 文江 on 2017/11/14.
 */
public class TestServerHandler extends SimpleChannelInboundHandler {


    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private static Logger logger = LogManager.getLogger(NettyCommonSessionWebSocketHandler.class.getName());
    public volatile static Map<Long, OnlineUserPo> onlineUserMap = new ConcurrentHashMap<Long, OnlineUserPo>();

    /**
     * 消息到来
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        //  BaseMessageProto.BaseMessageProBuf baseMessageProBuf = (BaseMessageProto.BaseMessageProBuf) msg;
        Channel incoming = ctx.channel();
        String json = msg.toString();
        //新分发器
        Dispatcher dispatcher = LocalManager.getInstance().getDispatcher();
        dispatcher.dispatchAction(incoming, msg);

        //老的分发器（即将废弃）
        //  dispatcherNetty(incoming, msg.text());
    }

    /**
     * 最简单的分发器
     * 缺点：臃肿，难用
     * 有点：代码简单
     *
     * @param
     * @param message
     */
//    private void dispatcherNetty(Channel incoming, String message) {
//        BaseMessage baseMessage = null;
//        if (message != null) {
//            // baseMessage = new BaseMessage(message);
//        }
//        switch (baseMessage.getMessageType()) {
//            case MessageType.CHAT_MESSAGE:
//                break;
//            case MessageType.PUBLIC_CHART_MESSAGE://单聊：聊天
//                ChatMessage chatMessage = new ChatMessage(message);
//                for (Channel channel : channels) {
//                    if (channel != incoming) {
//                        sendMessagetoClient(channel, chatMessage);
//                    } else {
//                        // channel.writeAndFlush(new TextWebSocketFrame("[you]" + msg.text()));
//                    }
//                }
//                break;
//            case MessageType.PRIVATE_CHAT_MESSAGE://群聊
//                GroupChatMessage groupChatMessage = new GroupChatMessage(message);
//                //一步发送消息通知:
//                /**
//                 * step1; 获取群中的所有用户；
//                 * step2; 获取用户对否在线，在线即推送消息，若不在线，发送心跳广播协议
//                 * step3：将消息存储在消息队列中；
//                 */
//
//                break;
//            case MessageType.PLAYER_LOGIN_MESSAGE://用户登录
//                OnlineUserBroadCastMessage broadCastMessage = new OnlineUserBroadCastMessage(message);
//                OnlineUserPo po = new OnlineUserPo();
//                broadCastMessage.setMessageTime(new Date().getTime());
//                broadCastMessage.setOutOrInType(0);
//                //broadCastMessage.setCommId();
//                po.setChannel(incoming);
//                onlineUserMap.put(broadCastMessage.getUser().getId(), po);
//                break;
//
//            default:
//                System.out.println("----------------消息协议号出错了--------------");
//                break;
//        }
//
//    }
    private void sendMessagetoClient(Channel channel, BaseMessage message) {
        String json = JSON.toJSONString(message);
        channel.writeAndFlush(new TextWebSocketFrame(json));
    }

    /**
     * 覆盖了 handlerAdded() 事件处理方法。每当从服务端收到新的客户端连接时，客户端的 Channel
     * 存入 ChannelGroup 列表中，并通知列表中的其他客户端 Channel
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        OnlineUserBroadCastMessage broadCastMessagePo = new OnlineUserBroadCastMessage();
        broadCastMessagePo.setCommId(MessageComm.getVaule(MessageComm.PLAYER_LOGIN_MESSAGE));
        broadCastMessagePo.setOutOrInType(0);
        broadCastMessagePo.setMessageTime(new Date().getTime());
        // broadCastMessagePo.setMessageType(MessageType.PLAYER_LOGIN_MESSAGE);
        // dispatcherNetty(incoming, JSON.toJSONString(broadCastMessagePo));
        for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame("[SERVER] - " + incoming.remoteAddress() + " 加入"));
        }
        // if (onlineUserMap.containsKey())
        channels.add(ctx.channel());
        logger.info("Client:" + incoming.remoteAddress() + "加入");
    }

    /**
     * 覆盖了 handlerRemoved() 事件处理方法。每当从服务端收到客户端断开时，
     * 客户端的 Channel 移除 ChannelGroup 列表中，并通知列表中的其他客户端 Channel
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {  // (3)
        Channel incoming = ctx.channel();
        for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame("[SERVER] - " + incoming.remoteAddress() + " 离开"));
        }
        logger.info("Client:" + incoming.remoteAddress() + "离开");
        channels.remove(ctx.channel());
    }

    /**
     * 覆盖了 channelRead0() 事件处理方法。每当从服务端读到客户端写入信息时，将信息转发给其他客户端的 Channel。
     * 其中如果你使用的是 Netty 5.x 版本时，需要把 channelRead0() 重命名为messageReceived()
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
        Channel incoming = ctx.channel();
        logger.info("Client:" + incoming.remoteAddress() + "在线");
    }

    /**
     * .覆盖了 channelActive() 事件处理方法。服务端监听到客户端活动
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
        Channel incoming = ctx.channel();
        logger.info("Client:" + incoming.remoteAddress() + "掉线");
    }

    /**
     * exceptionCaught() 事件处理方法是当出现 Throwable 对象才会被调用，即当 Netty
     * 由于 IO 错误或者处理器在处理事件时抛出的异常时。在大部分情况下，
     * 捕获的异常应该被记录下来并且把关联的 channel 给关闭掉。
     * 然而这个方法的处理方式会在遇到不同异常的情况下有不同的实现
     * ，比如你可能想在关闭连接之前发送一个错误码的响应消息。
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        Channel incoming = ctx.channel();
        logger.info("Client:" + incoming.remoteAddress() + "异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
