package p013io.netty.handler.codec.marshalling;

import org.jboss.marshalling.Unmarshaller;
import p013io.netty.channel.ChannelHandlerContext;

/* renamed from: io.netty.handler.codec.marshalling.UnmarshallerProvider */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/UnmarshallerProvider.class */
public interface UnmarshallerProvider {
    Unmarshaller getUnmarshaller(ChannelHandlerContext channelHandlerContext) throws Exception;
}
