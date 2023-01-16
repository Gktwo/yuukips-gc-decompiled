package p013io.netty.handler.codec.marshalling;

import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.concurrent.FastThreadLocal;

/* renamed from: io.netty.handler.codec.marshalling.ThreadLocalMarshallerProvider */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/ThreadLocalMarshallerProvider.class */
public class ThreadLocalMarshallerProvider implements MarshallerProvider {
    private final FastThreadLocal<Marshaller> marshallers = new FastThreadLocal<>();
    private final MarshallerFactory factory;
    private final MarshallingConfiguration config;

    public ThreadLocalMarshallerProvider(MarshallerFactory factory, MarshallingConfiguration config) {
        this.factory = factory;
        this.config = config;
    }

    @Override // p013io.netty.handler.codec.marshalling.MarshallerProvider
    public Marshaller getMarshaller(ChannelHandlerContext ctx) throws Exception {
        Marshaller marshaller = this.marshallers.get();
        if (marshaller == null) {
            marshaller = this.factory.createMarshaller(this.config);
            this.marshallers.set(marshaller);
        }
        return marshaller;
    }
}
