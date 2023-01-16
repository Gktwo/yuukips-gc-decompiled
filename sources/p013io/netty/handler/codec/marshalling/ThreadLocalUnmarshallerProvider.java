package p013io.netty.handler.codec.marshalling;

import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.concurrent.FastThreadLocal;

/* renamed from: io.netty.handler.codec.marshalling.ThreadLocalUnmarshallerProvider */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/ThreadLocalUnmarshallerProvider.class */
public class ThreadLocalUnmarshallerProvider implements UnmarshallerProvider {
    private final FastThreadLocal<Unmarshaller> unmarshallers = new FastThreadLocal<>();
    private final MarshallerFactory factory;
    private final MarshallingConfiguration config;

    public ThreadLocalUnmarshallerProvider(MarshallerFactory factory, MarshallingConfiguration config) {
        this.factory = factory;
        this.config = config;
    }

    @Override // p013io.netty.handler.codec.marshalling.UnmarshallerProvider
    public Unmarshaller getUnmarshaller(ChannelHandlerContext ctx) throws Exception {
        Unmarshaller unmarshaller = this.unmarshallers.get();
        if (unmarshaller == null) {
            unmarshaller = this.factory.createUnmarshaller(this.config);
            this.unmarshallers.set(unmarshaller);
        }
        return unmarshaller;
    }
}
