package com.twjitm.common.dispatcher;

import com.twjitm.common.entity.BaseMessage;
import com.twjitm.common.logic.handler.BaseHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
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


    public void loadPackage(String namespace) {
        // getBaseHandler(clzz)
        Class clzz = null;
        URL url = ClassLoader.getSystemClassLoader().getResource("");
        String classPath = url.getFile();
        // classPath.replace(".")
        String s = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(s);
        System.out.println(classPath);

        //  BaseHandler handler = getBaseHandler(clzz);
      /*  Method[] methods = clzz.getClass().getMethods();
        for (Method method : methods) {
            MessageCommandAnntation messageCommandAnntation = (MessageCommandAnntation) method.getAnnotation(MessageCommandAnntation.class);
            if (messageCommandAnntation != null) {
                BaseHandler handler = null;
                addHandler(messageCommandAnntation.messagecmd().commId, handler);
            }
        }*/


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

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.loadPackage("");
    }
}
