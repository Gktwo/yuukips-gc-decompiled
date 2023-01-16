package p013io.netty.handler.codec.marshalling;

import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import p013io.netty.channel.ChannelHandlerContext;

/* renamed from: io.netty.handler.codec.marshalling.DefaultMarshallerProvider */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/DefaultMarshallerProvider.class */
public class DefaultMarshallerProvider implements MarshallerProvider {
    private final MarshallerFactory factory;
    private final MarshallingConfiguration config;

    public DefaultMarshallerProvider(MarshallerFactory factory, MarshallingConfiguration config) {
        this.factory = factory;
        this.config = config;
    }

    @Override // p013io.netty.handler.codec.marshalling.MarshallerProvider
    public Marshaller getMarshaller(ChannelHandlerContext ctx) throws Exception {
        return this.factory.createMarshaller(this.config);
    }
}
