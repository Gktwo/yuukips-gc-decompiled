package p013io.netty.channel;

/* renamed from: io.netty.channel.ChannelInboundInvoker */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelInboundInvoker.class */
public interface ChannelInboundInvoker {
    ChannelInboundInvoker fireChannelRegistered();

    ChannelInboundInvoker fireChannelUnregistered();

    ChannelInboundInvoker fireChannelActive();

    ChannelInboundInvoker fireChannelInactive();

    ChannelInboundInvoker fireExceptionCaught(Throwable th);

    ChannelInboundInvoker fireUserEventTriggered(Object obj);

    ChannelInboundInvoker fireChannelRead(Object obj);

    ChannelInboundInvoker fireChannelReadComplete();

    ChannelInboundInvoker fireChannelWritabilityChanged();
}
