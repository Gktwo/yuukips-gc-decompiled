package p013io.netty.channel;

import p013io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.FixedRecvByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/channel/FixedRecvByteBufAllocator.class */
public class FixedRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {
    private final int bufferSize;

    /* renamed from: io.netty.channel.FixedRecvByteBufAllocator$HandleImpl */
    /* loaded from: grasscutter.jar:io/netty/channel/FixedRecvByteBufAllocator$HandleImpl.class */
    private final class HandleImpl extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle {
        private final int bufferSize;

        HandleImpl(int bufferSize) {
            super();
            this.bufferSize = bufferSize;
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return this.bufferSize;
        }
    }

    public FixedRecvByteBufAllocator(int bufferSize) {
        ObjectUtil.checkPositive(bufferSize, "bufferSize");
        this.bufferSize = bufferSize;
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl(this.bufferSize);
    }

    @Override // p013io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator
    public FixedRecvByteBufAllocator respectMaybeMoreData(boolean respectMaybeMoreData) {
        respectMaybeMoreData(respectMaybeMoreData);
        return this;
    }
}
