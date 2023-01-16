package p013io.netty.channel.socket.oio;

import java.net.InetAddress;
import java.net.NetworkInterface;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.socket.DatagramChannelConfig;

@Deprecated
/* renamed from: io.netty.channel.socket.oio.OioDatagramChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/oio/OioDatagramChannelConfig.class */
public interface OioDatagramChannelConfig extends DatagramChannelConfig {
    OioDatagramChannelConfig setSoTimeout(int i);

    int getSoTimeout();

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setSendBufferSize(int i);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setReceiveBufferSize(int i);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setTrafficClass(int i);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setReuseAddress(boolean z);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setBroadcast(boolean z);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setLoopbackModeDisabled(boolean z);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setTimeToLive(int i);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setInterface(InetAddress inetAddress);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig, p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setMaxMessagesPerRead(int i);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig, p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setWriteSpinCount(int i);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig, p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setConnectTimeoutMillis(int i);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig, p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig, p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig, p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setAutoRead(boolean z);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig, p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setAutoClose(boolean z);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig, p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // p013io.netty.channel.socket.DatagramChannelConfig, p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setWriteBufferHighWaterMark(int i);

    @Override // p013io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setWriteBufferLowWaterMark(int i);
}
