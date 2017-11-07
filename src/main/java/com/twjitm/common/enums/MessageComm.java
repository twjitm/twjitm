package com.twjitm.common.enums;

/**
 * Created by 文江 on 2017/11/5.
 */
public enum MessageComm {
    CHAT_MESSAGE(0),
    PUBLIC_CHART_MESSAGE(1),
    PRIVATE_CHAT_MESSAGE(2),
    PLAYER_LOGIN_MESSAGE(3),
    PLAYER_LOGOUT_MESSAGE(4),
    HEART_MESSAGE(5);
    private int vaule;

    MessageComm(int value) {
        this.vaule = value;
    }

    public static int getVaule(MessageComm messageComm) {
        return messageComm.vaule;
    }

}
