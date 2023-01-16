package p013io.netty.handler.codec.marshalling;

import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;
import p013io.netty.channel.ChannelHandlerContext;

/* renamed from: io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/DefaultUnmarshallerProvider.class */
public class DefaultUnmarshallerProvider implements UnmarshallerProvider {
    private final MarshallerFactory factory;
    private final MarshallingConfiguration config;

    public DefaultUnmarshallerProvider(MarshallerFactory factory, MarshallingConfiguration config) {
        this.factory = factory;
        this.config = config;
    }

    @Override // p013io.netty.handler.codec.marshalling.UnmarshallerProvider
    public Unmarshaller getUnmarshaller(ChannelHandlerContext ctx) throws Exception {
        return this.factory.createUnmarshaller(this.config);
    }
}
