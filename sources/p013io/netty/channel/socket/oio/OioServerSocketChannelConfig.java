package p013io.netty.channel.socket.oio;

import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.socket.ServerSocketChannelConfig;

@Deprecated
/* renamed from: io.netty.channel.socket.oio.OioServerSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/oio/OioServerSocketChannelConfig.class */
public interface OioServerSocketChannelConfig extends ServerSocketChannelConfig {
    OioServerSocketChannelConfig setSoTimeout(int i);

    int getSoTimeout();

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    OioServerSocketChannelConfig setBacklog(int i);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    OioServerSocketChannelConfig setReuseAddress(boolean z);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    OioServerSocketChannelConfig setReceiveBufferSize(int i);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    OioServerSocketChannelConfig setPerformancePreferences(int i, int i2, int i3);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig, p013io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setConnectTimeoutMillis(int i);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    OioServerSocketChannelConfig setMaxMessagesPerRead(int i);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig, p013io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setWriteSpinCount(int i);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig, p013io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig, p013io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig, p013io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setAutoRead(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setAutoClose(boolean z);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig, p013io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setWriteBufferHighWaterMark(int i);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig, p013io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setWriteBufferLowWaterMark(int i);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig, p013io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig, p013io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);
}
