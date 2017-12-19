package com.twjitm.common.netstack.entity.process;

import com.twjitm.common.logic.net.NettyNetMessageProcessLogic;
import com.twjitm.common.manager.LocalManager;
import com.twjitm.common.netstack.entity.AbstractNettyNetMessage;
import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;
import com.twjitm.common.netstack.entity.tcp.session.NettySession;

import java.util.Queue;

/**
 * Created by 文江 on 2017/12/19.
 */
public class NettyMessageProcess implements INettyMessageProcess {
    protected long staticMessageCount = 0;
    private NettySession nettySession;
    /**
     * 消息队列
     */
    private Queue<AbstractNettyNetProtoBufMessage> nettyNetProtoBufMessageQueue;

    /**
     * 中断消息处理
     */
    protected boolean suspendedProcess;

    public void processMessage() {
        int i = 0;
        AbstractNettyNetMessage message = null;
        while (!isSuspendedProcess() && ((message = nettyNetProtoBufMessageQueue.poll()) != null)) {
            NettyNetMessageProcessLogic messageProcessLogic = LocalManager.getInstance().getSpringBeanManager().getNettyNetMessageProcessLogic();
            messageProcessLogic.processMessage(message, nettySession);
        }
    }

    public void addMessage(AbstractNettyNetMessage message) {
        nettyNetProtoBufMessageQueue.add((AbstractNettyNetProtoBufMessage) message);
    }

    public void close() {
        this.nettyNetProtoBufMessageQueue.clear();
        setSuspendedProcess(true);
    }


    public boolean isSuspendedProcess() {
        return suspendedProcess;
    }

    public void setSuspendedProcess(boolean suspendedProcess) {
        this.suspendedProcess = suspendedProcess;
    }
}
