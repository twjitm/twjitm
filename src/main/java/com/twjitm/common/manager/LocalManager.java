package com.twjitm.common.manager;

/**
 * Created by 文江 on 2017/11/9.
 */

import com.twjitm.common.entity.online.OnlineUserPo;

/**
 * 本地管理
 */
public class LocalManager {
    private static LocalManager localManager;

    public static LocalManager getInstance() {
        if (localManager == null) {
            localManager = new LocalManager();
        }
        return localManager;
    }

    public OnlineUserPo getOnLineUser(int uId) {
        return null;
    }

}
