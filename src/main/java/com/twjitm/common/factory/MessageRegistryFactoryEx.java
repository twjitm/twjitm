package com.twjitm.common.factory;

import com.twjitm.common.service.ILocalService;

/**
 * Created by 文江 on 2017/11/11.
 */
public class MessageRegistryFactoryEx extends MessageRegistryFactory implements ILocalService {
    public String getId() {
        return null;
    }

    public void startup() throws Exception {
        loadPackage("com.twjitm.common.entity.chat", ".class");
    }

    public void shutdown() throws Exception {

    }
}
