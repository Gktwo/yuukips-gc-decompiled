package p013io.netty.channel.socket;

import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;

/* renamed from: io.netty.channel.socket.ServerSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/ServerSocketChannelConfig.class */
public interface ServerSocketChannelConfig extends ChannelConfig {
    int getBacklog();

    ServerSocketChannelConfig setBacklog(int i);

    boolean isReuseAddress();

    ServerSocketChannelConfig setReuseAddress(boolean z);

    int getReceiveBufferSize();

    ServerSocketChannelConfig setReceiveBufferSize(int i);

    ServerSocketChannelConfig setPerformancePreferences(int i, int i2, int i3);

    @Override // p013io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setConnectTimeoutMillis(int i);

    @Override // p013io.netty.channel.ChannelConfig
    @Deprecated
    ServerSocketChannelConfig setMaxMessagesPerRead(int i);

    @Override // p013io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setWriteSpinCount(int i);

    @Override // p013io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // p013io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // p013io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setAutoRead(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // p013io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setWriteBufferHighWaterMark(int i);

    @Override // p013io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setWriteBufferLowWaterMark(int i);

    @Override // p013io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);
}
