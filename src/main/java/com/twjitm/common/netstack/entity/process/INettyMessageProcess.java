package com.twjitm.common.netstack.entity.process;

import com.twjitm.common.netstack.entity.AbstractNettyNetMessage;

/**
 * Created by 文江 on 2017/12/19.
 */
public interface INettyMessageProcess  {
    void processMessage();
    void addMessage(AbstractNettyNetMessage message);
    void  close();
}
