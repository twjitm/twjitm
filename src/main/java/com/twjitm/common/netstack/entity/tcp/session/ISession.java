package com.twjitm.common.netstack.entity.tcp.session;

import com.twjitm.common.netstack.entity.AbstractNettyNetMessage;

/**
 * Created by 文江 on 2017/12/19.
 */
public interface ISession {
    /**
     * 判断当前会话是否处于连接状态
     *
     * @return
     */
    public boolean isConnected();

    /**
     * @param msg
     */
    public void write(AbstractNettyNetMessage msg) throws Exception;

    /**
     *
     */
    public void close(boolean immediately);

    /**
     * 出现异常时是否关闭连接
     *
     * @return
     */
    public boolean closeOnException();

    public void write(byte[] msg);
}
