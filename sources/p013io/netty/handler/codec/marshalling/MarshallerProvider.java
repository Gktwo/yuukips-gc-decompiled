package p013io.netty.handler.codec.marshalling;

import org.jboss.marshalling.Marshaller;
import p013io.netty.channel.ChannelHandlerContext;

/* renamed from: io.netty.handler.codec.marshalling.MarshallerProvider */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/MarshallerProvider.class */
public interface MarshallerProvider {
    Marshaller getMarshaller(ChannelHandlerContext channelHandlerContext) throws Exception;
}
