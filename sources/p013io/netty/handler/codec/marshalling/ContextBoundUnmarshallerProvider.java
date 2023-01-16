package p013io.netty.handler.codec.marshalling;

import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.Attribute;
import p013io.netty.util.AttributeKey;

/* renamed from: io.netty.handler.codec.marshalling.ContextBoundUnmarshallerProvider */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/ContextBoundUnmarshallerProvider.class */
public class ContextBoundUnmarshallerProvider extends DefaultUnmarshallerProvider {
    private static final AttributeKey<Unmarshaller> UNMARSHALLER = AttributeKey.valueOf(ContextBoundUnmarshallerProvider.class, "UNMARSHALLER");

    public ContextBoundUnmarshallerProvider(MarshallerFactory factory, MarshallingConfiguration config) {
        super(factory, config);
    }

    @Override // p013io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider, p013io.netty.handler.codec.marshalling.UnmarshallerProvider
    public Unmarshaller getUnmarshaller(ChannelHandlerContext ctx) throws Exception {
        Attribute<Unmarshaller> attr = ctx.channel().attr(UNMARSHALLER);
        Unmarshaller unmarshaller = attr.get();
        if (unmarshaller == null) {
            unmarshaller = getUnmarshaller(ctx);
            attr.set(unmarshaller);
        }
        return unmarshaller;
    }
}
