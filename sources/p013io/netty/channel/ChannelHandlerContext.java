package p013io.netty.channel;

import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.util.Attribute;
import p013io.netty.util.AttributeKey;
import p013io.netty.util.AttributeMap;
import p013io.netty.util.concurrent.EventExecutor;

/* renamed from: io.netty.channel.ChannelHandlerContext */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelHandlerContext.class */
public interface ChannelHandlerContext extends AttributeMap, ChannelInboundInvoker, ChannelOutboundInvoker {
    Channel channel();

    EventExecutor executor();

    String name();

    ChannelHandler handler();

    boolean isRemoved();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelHandlerContext fireChannelRegistered();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelHandlerContext fireChannelUnregistered();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelHandlerContext fireChannelActive();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelHandlerContext fireChannelInactive();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelHandlerContext fireExceptionCaught(Throwable th);

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelHandlerContext fireUserEventTriggered(Object obj);

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelHandlerContext fireChannelRead(Object obj);

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelHandlerContext fireChannelReadComplete();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelHandlerContext fireChannelWritabilityChanged();

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    ChannelHandlerContext read();

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    ChannelHandlerContext flush();

    ChannelPipeline pipeline();

    ByteBufAllocator alloc();

    @Override // p013io.netty.util.AttributeMap
    @Deprecated
    <T> Attribute<T> attr(AttributeKey<T> attributeKey);

    @Override // p013io.netty.util.AttributeMap
    @Deprecated
    <T> boolean hasAttr(AttributeKey<T> attributeKey);
}
