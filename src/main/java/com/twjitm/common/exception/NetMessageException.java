package com.twjitm.common.exception;

/**
 * Created by 文江 on 2017/12/19.
 */
public class NetMessageException extends Exception {
    public NetMessageException(String message,Exception e) {
        super(message);
    }
}
