package p013io.netty.channel;

import java.util.List;
import java.util.Map;
import p013io.netty.util.concurrent.EventExecutorGroup;

/* renamed from: io.netty.channel.ChannelPipeline */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelPipeline.class */
public interface ChannelPipeline extends ChannelInboundInvoker, ChannelOutboundInvoker, Iterable<Map.Entry<String, ChannelHandler>> {
    ChannelPipeline addFirst(String str, ChannelHandler channelHandler);

    ChannelPipeline addFirst(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler);

    ChannelPipeline addLast(String str, ChannelHandler channelHandler);

    ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler);

    ChannelPipeline addBefore(String str, String str2, ChannelHandler channelHandler);

    ChannelPipeline addBefore(EventExecutorGroup eventExecutorGroup, String str, String str2, ChannelHandler channelHandler);

    ChannelPipeline addAfter(String str, String str2, ChannelHandler channelHandler);

    ChannelPipeline addAfter(EventExecutorGroup eventExecutorGroup, String str, String str2, ChannelHandler channelHandler);

    ChannelPipeline addFirst(ChannelHandler... channelHandlerArr);

    ChannelPipeline addFirst(EventExecutorGroup eventExecutorGroup, ChannelHandler... channelHandlerArr);

    ChannelPipeline addLast(ChannelHandler... channelHandlerArr);

    ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup, ChannelHandler... channelHandlerArr);

    ChannelPipeline remove(ChannelHandler channelHandler);

    ChannelHandler remove(String str);

    <T extends ChannelHandler> T remove(Class<T> cls);

    ChannelHandler removeFirst();

    ChannelHandler removeLast();

    ChannelPipeline replace(ChannelHandler channelHandler, String str, ChannelHandler channelHandler2);

    ChannelHandler replace(String str, String str2, ChannelHandler channelHandler);

    <T extends ChannelHandler> T replace(Class<T> cls, String str, ChannelHandler channelHandler);

    ChannelHandler first();

    ChannelHandlerContext firstContext();

    ChannelHandler last();

    ChannelHandlerContext lastContext();

    ChannelHandler get(String str);

    <T extends ChannelHandler> T get(Class<T> cls);

    ChannelHandlerContext context(ChannelHandler channelHandler);

    ChannelHandlerContext context(String str);

    ChannelHandlerContext context(Class<? extends ChannelHandler> cls);

    Channel channel();

    List<String> names();

    Map<String, ChannelHandler> toMap();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelPipeline fireChannelRegistered();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelPipeline fireChannelUnregistered();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelPipeline fireChannelActive();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelPipeline fireChannelInactive();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelPipeline fireExceptionCaught(Throwable th);

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelPipeline fireUserEventTriggered(Object obj);

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelPipeline fireChannelRead(Object obj);

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelPipeline fireChannelReadComplete();

    @Override // p013io.netty.channel.ChannelInboundInvoker
    ChannelPipeline fireChannelWritabilityChanged();

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    ChannelPipeline flush();
}
