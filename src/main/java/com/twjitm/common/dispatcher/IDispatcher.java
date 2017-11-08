package com.twjitm.common.dispatcher;

import com.twjitm.common.entity.BaseMessage;

public interface IDispatcher {
    public BaseMessage dispatcher(BaseMessage message);
}
