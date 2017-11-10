package com.twjitm.common.utils;

import com.twjitm.common.dispatcher.DisPatcherEx;
import com.twjitm.common.dispatcher.Dispatcher;
import com.twjitm.common.dispatcher.IDispatcher;
import com.twjitm.common.manager.LocalManager;

/**
 * 各种全局的业务管理器、公共服务实例的持有者，负责各种管理器的初始化和实例的获取

 */
public class Globals {

    public static void init() throws Exception {
        LocalManager.getInstance().create(Dispatcher.class, IDispatcher.class);
        LocalManager.getInstance().create(DisPatcherEx.class, IDispatcher.class);
    }
    public static void startUp(){
        LocalManager.getInstance().get(DisPatcherEx.class).startUp();
    }

    public  static  void  stop(){

    }

}
