package p013io.netty.channel;

import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;

/* renamed from: io.netty.channel.ChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelConfig.class */
public interface ChannelConfig {
    Map<ChannelOption<?>, Object> getOptions();

    boolean setOptions(Map<ChannelOption<?>, ?> map);

    <T> T getOption(ChannelOption<T> channelOption);

    <T> boolean setOption(ChannelOption<T> channelOption, T t);

    int getConnectTimeoutMillis();

    ChannelConfig setConnectTimeoutMillis(int i);

    @Deprecated
    int getMaxMessagesPerRead();

    @Deprecated
    ChannelConfig setMaxMessagesPerRead(int i);

    int getWriteSpinCount();

    ChannelConfig setWriteSpinCount(int i);

    ByteBufAllocator getAllocator();

    ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    <T extends RecvByteBufAllocator> T getRecvByteBufAllocator();

    ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    boolean isAutoRead();

    ChannelConfig setAutoRead(boolean z);

    boolean isAutoClose();

    ChannelConfig setAutoClose(boolean z);

    int getWriteBufferHighWaterMark();

    ChannelConfig setWriteBufferHighWaterMark(int i);

    int getWriteBufferLowWaterMark();

    ChannelConfig setWriteBufferLowWaterMark(int i);

    MessageSizeEstimator getMessageSizeEstimator();

    ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    WriteBufferWaterMark getWriteBufferWaterMark();

    ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);
}
