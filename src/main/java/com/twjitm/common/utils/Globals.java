package com.twjitm.common.utils;

import com.twjitm.common.dispatcher.DisPatcherEx;
import com.twjitm.common.dispatcher.Dispatcher;
import com.twjitm.common.dispatcher.IDispatcher;
import com.twjitm.common.factory.MessageRegistryFactory;
import com.twjitm.common.factory.MessageRegistryFactoryEx;
import com.twjitm.common.manager.LocalManager;
import com.twjitm.common.netstack.coder.decode.INettyNetProtoBuffHttpToMessageDecoerFactory;
import com.twjitm.common.netstack.coder.decode.INettyNetProtoBuffTCPToMessageDecoerFactory;
import com.twjitm.common.netstack.coder.decode.INettyNetProtoBuffUDPToMessageDecoerFactory;
import com.twjitm.common.netstack.coder.decode.NettyNetProtoBuffTCPToMessageDecoerFactory;

/**
 * 各种全局的业务管理器、公共服务实例的持有者，负责各种管理器的初始化和实例的获取
 */
public class Globals {

    public static void init() throws Exception {
        LocalManager.getInstance().create(Dispatcher.class, IDispatcher.class);
        LocalManager.getInstance().create(DisPatcherEx.class, DisPatcherEx.class);
        LocalManager.getInstance().create(MessageRegistryFactory.class, MessageRegistryFactory.class);
        LocalManager.getInstance().create(MessageRegistryFactoryEx.class, MessageRegistryFactoryEx.class);
         //------------编解码注入
        LocalManager.getInstance().create(NettyNetProtoBuffTCPToMessageDecoerFactory.class,INettyNetProtoBuffTCPToMessageDecoerFactory.class);
       // LocalManager.getInstance().create(NettyNetProtoBuffUDPToMessageDecoerFactory.class,INettyNetProtoBuffUDPToMessageDecoerFactory.class);
       // LocalManager.getInstance().create(NettyNetProtoBuffHttpToMessageDecoerFactory.class,INettyNetProtoBuffHttpToMessageDecoerFactory.class);
    }

    public static void startUp() throws Exception {
        LocalManager.getInstance().get(DisPatcherEx.class).startup();
        LocalManager.getInstance().get(MessageRegistryFactoryEx.class).startup();
        ;
    }

    public static void stop() {

    }

}
