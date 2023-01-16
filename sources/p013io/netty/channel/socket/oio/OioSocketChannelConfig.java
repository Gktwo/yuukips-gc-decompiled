package p013io.netty.channel.socket.oio;

import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.socket.SocketChannelConfig;

@Deprecated
/* renamed from: io.netty.channel.socket.oio.OioSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/oio/OioSocketChannelConfig.class */
public interface OioSocketChannelConfig extends SocketChannelConfig {
    OioSocketChannelConfig setSoTimeout(int i);

    int getSoTimeout();

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setTcpNoDelay(boolean z);

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setSoLinger(int i);

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setSendBufferSize(int i);

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setReceiveBufferSize(int i);

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setKeepAlive(boolean z);

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setTrafficClass(int i);

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setReuseAddress(boolean z);

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setPerformancePreferences(int i, int i2, int i3);

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig
    OioSocketChannelConfig setAllowHalfClosure(boolean z);

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.ChannelConfig
    OioSocketChannelConfig setConnectTimeoutMillis(int i);

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    OioSocketChannelConfig setMaxMessagesPerRead(int i);

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteSpinCount(int i);

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    OioSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    OioSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    OioSocketChannelConfig setAutoRead(boolean z);

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    OioSocketChannelConfig setAutoClose(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteBufferHighWaterMark(int i);

    @Override // p013io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteBufferLowWaterMark(int i);

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    OioSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);
}
