package p013io.netty.channel;

import java.util.Map;

/* renamed from: io.netty.channel.MaxBytesRecvByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/channel/MaxBytesRecvByteBufAllocator.class */
public interface MaxBytesRecvByteBufAllocator extends RecvByteBufAllocator {
    int maxBytesPerRead();

    MaxBytesRecvByteBufAllocator maxBytesPerRead(int i);

    int maxBytesPerIndividualRead();

    MaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int i);

    Map.Entry<Integer, Integer> maxBytesPerReadPair();

    MaxBytesRecvByteBufAllocator maxBytesPerReadPair(int i, int i2);
}
