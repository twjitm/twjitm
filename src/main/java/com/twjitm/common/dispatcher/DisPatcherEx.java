package com.twjitm.common.dispatcher;


import com.twjitm.common.service.ILocalService;

public class DisPatcherEx extends Dispatcher implements ILocalService {

    private void reload() {
        loadPackage("com.twjitm.common.logic.chat.Impl", ".class");
    }

    public String getId() {
        return null;
    }

    public void startup() throws Exception {
        reload();
    }

    public void shutdown() throws Exception {

    }
}
