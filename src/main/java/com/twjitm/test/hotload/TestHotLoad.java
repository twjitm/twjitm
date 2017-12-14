package com.twjitm.test.hotload;

import java.lang.management.ManagementFactory;

/**
 * Created by 文江 on 2017/12/14.
 * 热更新测试
 */
public class TestHotLoad {
    static {
        //classesPath = JavaAgent.class.getClassLoader().getResource("").getPath();
        ManagementFactory.getRuntimeMXBean().getName();

    }


}
