package p013io.netty.channel.socket;

import java.net.InetAddress;
import java.net.NetworkInterface;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;

/* renamed from: io.netty.channel.socket.DatagramChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/DatagramChannelConfig.class */
public interface DatagramChannelConfig extends ChannelConfig {
    int getSendBufferSize();

    DatagramChannelConfig setSendBufferSize(int i);

    int getReceiveBufferSize();

    DatagramChannelConfig setReceiveBufferSize(int i);

    int getTrafficClass();

    DatagramChannelConfig setTrafficClass(int i);

    boolean isReuseAddress();

    DatagramChannelConfig setReuseAddress(boolean z);

    boolean isBroadcast();

    DatagramChannelConfig setBroadcast(boolean z);

    boolean isLoopbackModeDisabled();

    DatagramChannelConfig setLoopbackModeDisabled(boolean z);

    int getTimeToLive();

    DatagramChannelConfig setTimeToLive(int i);

    InetAddress getInterface();

    DatagramChannelConfig setInterface(InetAddress inetAddress);

    NetworkInterface getNetworkInterface();

    DatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface);

    @Override // p013io.netty.channel.ChannelConfig
    @Deprecated
    DatagramChannelConfig setMaxMessagesPerRead(int i);

    @Override // p013io.netty.channel.ChannelConfig
    DatagramChannelConfig setWriteSpinCount(int i);

    @Override // p013io.netty.channel.ChannelConfig
    DatagramChannelConfig setConnectTimeoutMillis(int i);

    @Override // p013io.netty.channel.ChannelConfig
    DatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // p013io.netty.channel.ChannelConfig
    DatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // p013io.netty.channel.ChannelConfig
    DatagramChannelConfig setAutoRead(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    DatagramChannelConfig setAutoClose(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    DatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // p013io.netty.channel.ChannelConfig
    DatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);
}
