package com.twjitm.common.manager;

/**
 * Created by 文江 on 2017/11/9.
 */

import com.twjitm.common.dispatcher.IDispatcher;
import com.twjitm.common.entity.online.OnlineUserPo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 本地管理
 */
public class LocalManager implements ILocalManager {
    private static LocalManager localManager;
    private Map<Class,Object> service;
    public IDispatcher dispatcher;

    public LocalManager() {
        service = new LinkedHashMap<Class,Object>(40,0.5f);
    }



    public static LocalManager getInstance() {
        if (localManager == null) {
            localManager = new LocalManager();
        }
        return localManager;
    }


    public <X,Y extends X> void create(Class<Y> clazz,Class<X> inter) throws Exception{

        Object newObject = clazz.newInstance();

        add(newObject,inter);
    }

    public  void add(Object services,Class clzz){
       if(services.getClass()!=clzz){
           throw new ClassCastException();
       }
        service.put(clzz,services);

    }

    public <T> T get(Class<T> clzz){
        return localManager.get(clzz);
}

    public OnlineUserPo getOnLineUser(int uId) {
        return null;
    }

}
