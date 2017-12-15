package com.twjitm.common.logic.common;

import com.twjitm.common.annotation.MessageCommandAnntation;
import com.twjitm.common.entity.common.HeartbeatMessage;
import com.twjitm.common.enums.MessageComm;
import com.twjitm.common.logic.handler.AbstractBaseHandler;
import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;

/**
 * Created by 文江 on 2017/12/15.
 */
public abstract class CommonsHandler extends AbstractBaseHandler {

    public abstract AbstractNettyNetProtoBufMessage handlerHeatMesssegeImpl(HeartbeatMessage heartbeatMessage);

    @MessageCommandAnntation(messagecmd = MessageComm.HEART_MESSAGE)
    public void handlerHeatMesssege(HeartbeatMessage heartbeatMessage) {
        handlerHeatMesssegeImpl(heartbeatMessage);
    }

}
