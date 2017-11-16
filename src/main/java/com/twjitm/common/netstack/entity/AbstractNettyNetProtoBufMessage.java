package com.twjitm.common.netstack.entity;

import com.twjitm.common.annotation.MessageCommandAnntation;
import io.netty.handler.codec.CodecException;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by 文江 on 2017/11/15.
 * 基础protobuf协议消息
 */
public abstract class AbstractNettyNetProtoBufMessage extends AbstractNettyNetMessage {
    public AbstractNettyNetProtoBufMessage() {
        setNettyNetMessageHead(new NettyNetMessageHead());
        setNettyNetMessageBody(new NettyNetMessageBody());
    }

    public NettyNetMessageHead getNetMessageHead() {
        return null;
    }

    public NettyNetMessageBody getNetMessageBody() {
        return null;
    }

    protected void initHeadCommId() {
        MessageCommandAnntation messageCommandAnntation = this.getClass().getAnnotation(MessageCommandAnntation.class);
         if(messageCommandAnntation!=null){
             getNetMessageHead().setCmd((short) messageCommandAnntation.messagecmd().commId);
         }
    }
    /*释放message的body*/
    public  void releaseMessageBody() throws CodecException, Exception{
        getNetMessageBody().setBytes(null);
    }

    public abstract void release() throws CodecException;

    public abstract  void encodeNetProtoBufMessageBody() throws CodecException, Exception;

    public void setSerial(int serial){
        getNetMessageHead().setSerial(serial);
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + ": commandId=" + getNetMessageHead().getCmd();
    }

    public String toAllInfoString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE).replaceAll("\n", "");
    }

}
