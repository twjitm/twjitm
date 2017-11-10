package com.twjitm.common.listener;

import com.twjitm.common.RealcomServer;
import com.twjitm.common.factory.thread.TwjThreadFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by 文江 on 2017/9/25.
 * 长连接监听器
 */
public class StartupServerListener implements ApplicationListener<ContextRefreshedEvent> {

    public void start() {
        RealcomServer.getInItStance().startServer();
    }

    public void onApplicationEvent(ContextRefreshedEvent evt) {
        if (evt.getApplicationContext().getParent() == null) {
            TwjThreadFactory factory = new TwjThreadFactory();
            factory.newThread(new Runnable() {
                public void run() {
                    start();
                }
            }).start();
        }
    }
}
