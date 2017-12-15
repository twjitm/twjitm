package com.twjitm.common.entity.common;

import com.twjitm.common.annotation.MessageCommandAnntation;
import com.twjitm.common.enums.MessageComm;
import com.twjitm.common.netstack.entity.AbstractNettyNetMessage;
import com.twjitm.common.netstack.entity.AbstractNettyNetProtoBufMessage;
import io.netty.handler.codec.CodecException;

/**
 * Created by 文江 on 2017/12/15.
 */
@MessageCommandAnntation(messagecmd = MessageComm.HEART_MESSAGE)
public class HeartbeatMessage extends AbstractNettyNetProtoBufMessage {
    public void release() throws CodecException {

    }

    public void encodeNetProtoBufMessageBody() throws CodecException, Exception {

    }

    public void decoderNetProtoBufMessageBody() throws CodecException, Exception {

    }

    public void decoderNetJsonMessageBody(String json) {

    }

    public void encodeNetJsonMessageBody(String json) {

    }
}
