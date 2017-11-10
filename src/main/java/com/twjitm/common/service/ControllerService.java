package com.twjitm.common.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 文江 on 2017/10/24.
 * 获得短连接服务
 */
public class ControllerService {
    public static void init() {
        initUserService();

    }


    private static void initUserService() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.getBean("");
    }

}
