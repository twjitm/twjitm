package com.twjitm.common.dispatcher;

import com.twjitm.common.entity.BaseMessage;
import com.twjitm.common.logic.handler.BaseHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 基于注解的分发器
 */
public class Dispatcher implements IDispatcher {

    public Map<Integer, BaseHandler> handlerMap;
    //public ClassScanner messageScanner = new ClassScanner();

    public BaseMessage dispatcher(BaseMessage message) {
        long commId = message.getCommId();
        BaseHandler baseHandler = handlerMap.get(commId);
        Method method = baseHandler.getMethod(commId);
        method.setAccessible(true);
        try {
            Object object = method.invoke(baseHandler,
                    message);

            BaseMessage baseMessage = null;
            if (object != null) {
                baseMessage = (BaseMessage) object;
            }
            return baseMessage;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void addHandler(int commId, BaseHandler handler) {
        handlerMap.put(commId, handler);

    }


    public void loadPackage() {

        // getBaseHandler(clzz)
        Class clzz = null;
        clzz = this.getClass().getClassLoader().getClass();
        BaseHandler handler = getBaseHandler(clzz);


    }

    public BaseHandler getBaseHandler(Class<?> classes) {
        try {
            if (classes == null) {
                return null;
            }

            BaseHandler messageHandler = (BaseHandler) classes
                    .newInstance();
            return messageHandler;
        } catch (Exception e) {
            System.err.println("getMessageHandler - classes=" + classes.getName() + "," + e);
        }
        return null;

    }
}
