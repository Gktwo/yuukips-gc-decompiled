package p013io.netty.channel;

import java.net.SocketAddress;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.util.AttributeMap;

/* renamed from: io.netty.channel.Channel */
/* loaded from: grasscutter.jar:io/netty/channel/Channel.class */
public interface Channel extends AttributeMap, ChannelOutboundInvoker, Comparable<Channel> {

    /* renamed from: io.netty.channel.Channel$Unsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/Channel$Unsafe.class */
    public interface Unsafe {
        RecvByteBufAllocator.Handle recvBufAllocHandle();

        SocketAddress localAddress();

        SocketAddress remoteAddress();

        void register(EventLoop eventLoop, ChannelPromise channelPromise);

        void bind(SocketAddress socketAddress, ChannelPromise channelPromise);

        void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise);

        void disconnect(ChannelPromise channelPromise);

        void close(ChannelPromise channelPromise);

        void closeForcibly();

        void deregister(ChannelPromise channelPromise);

        void beginRead();

        void write(Object obj, ChannelPromise channelPromise);

        void flush();

        ChannelPromise voidPromise();

        ChannelOutboundBuffer outboundBuffer();
    }

    /* renamed from: id */
    ChannelId mo1183id();

    EventLoop eventLoop();

    Channel parent();

    ChannelConfig config();

    boolean isOpen();

    boolean isRegistered();

    boolean isActive();

    ChannelMetadata metadata();

    SocketAddress localAddress();

    SocketAddress remoteAddress();

    ChannelFuture closeFuture();

    boolean isWritable();

    long bytesBeforeUnwritable();

    long bytesBeforeWritable();

    Unsafe unsafe();

    ChannelPipeline pipeline();

    ByteBufAllocator alloc();

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    Channel read();

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    Channel flush();
}
