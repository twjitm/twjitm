package com.twjitm.utils;

public class RedisKeyUtils {

    public static String getPlayWithChatKey(long userId,long destUserId){
        return RedisKey.USER_CHAT__LIST+"#"+userId+"#"+destUserId;

    }
}
