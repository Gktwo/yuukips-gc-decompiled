package p013io.netty.channel;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.util.UncheckedBooleanSupplier;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultMaxMessagesRecvByteBufAllocator.class */
public abstract class DefaultMaxMessagesRecvByteBufAllocator implements MaxMessagesRecvByteBufAllocator {
    private final boolean ignoreBytesRead;
    private volatile int maxMessagesPerRead;
    private volatile boolean respectMaybeMoreData;

    public DefaultMaxMessagesRecvByteBufAllocator() {
        this(1);
    }

    public DefaultMaxMessagesRecvByteBufAllocator(int maxMessagesPerRead) {
        this(maxMessagesPerRead, false);
    }

    /* access modifiers changed from: package-private */
    public DefaultMaxMessagesRecvByteBufAllocator(int maxMessagesPerRead, boolean ignoreBytesRead) {
        this.respectMaybeMoreData = true;
        this.ignoreBytesRead = ignoreBytesRead;
        maxMessagesPerRead(maxMessagesPerRead);
    }

    @Override // p013io.netty.channel.MaxMessagesRecvByteBufAllocator
    public int maxMessagesPerRead() {
        return this.maxMessagesPerRead;
    }

    @Override // p013io.netty.channel.MaxMessagesRecvByteBufAllocator
    public MaxMessagesRecvByteBufAllocator maxMessagesPerRead(int maxMessagesPerRead) {
        ObjectUtil.checkPositive(maxMessagesPerRead, "maxMessagesPerRead");
        this.maxMessagesPerRead = maxMessagesPerRead;
        return this;
    }

    public DefaultMaxMessagesRecvByteBufAllocator respectMaybeMoreData(boolean respectMaybeMoreData) {
        this.respectMaybeMoreData = respectMaybeMoreData;
        return this;
    }

    public final boolean respectMaybeMoreData() {
        return this.respectMaybeMoreData;
    }

    /* renamed from: io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator$MaxMessageHandle */
    /* loaded from: grasscutter.jar:io/netty/channel/DefaultMaxMessagesRecvByteBufAllocator$MaxMessageHandle.class */
    public abstract class MaxMessageHandle implements RecvByteBufAllocator.ExtendedHandle {
        private ChannelConfig config;
        private int maxMessagePerRead;
        private int totalMessages;
        private int totalBytesRead;
        private int attemptedBytesRead;
        private int lastBytesRead;
        private final boolean respectMaybeMoreData;
        private final UncheckedBooleanSupplier defaultMaybeMoreSupplier = new UncheckedBooleanSupplier() { // from class: io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle.1
            @Override // p013io.netty.util.UncheckedBooleanSupplier, p013io.netty.util.BooleanSupplier
            public boolean get() {
                return MaxMessageHandle.this.attemptedBytesRead == MaxMessageHandle.this.lastBytesRead;
            }
        };

        public MaxMessageHandle() {
            this.respectMaybeMoreData = DefaultMaxMessagesRecvByteBufAllocator.this.respectMaybeMoreData;
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void reset(ChannelConfig config) {
            this.config = config;
            this.maxMessagePerRead = DefaultMaxMessagesRecvByteBufAllocator.this.maxMessagesPerRead();
            this.totalBytesRead = 0;
            this.totalMessages = 0;
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public ByteBuf allocate(ByteBufAllocator alloc) {
            return alloc.ioBuffer(guess());
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public final void incMessagesRead(int amt) {
            this.totalMessages += amt;
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int bytes) {
            this.lastBytesRead = bytes;
            if (bytes > 0) {
                this.totalBytesRead += bytes;
            }
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public final int lastBytesRead() {
            return this.lastBytesRead;
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public boolean continueReading() {
            return continueReading(this.defaultMaybeMoreSupplier);
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.ExtendedHandle
        public boolean continueReading(UncheckedBooleanSupplier maybeMoreDataSupplier) {
            return this.config.isAutoRead() && (!this.respectMaybeMoreData || maybeMoreDataSupplier.get()) && this.totalMessages < this.maxMessagePerRead && (DefaultMaxMessagesRecvByteBufAllocator.this.ignoreBytesRead || this.totalBytesRead > 0);
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public int attemptedBytesRead() {
            return this.attemptedBytesRead;
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void attemptedBytesRead(int bytes) {
            this.attemptedBytesRead = bytes;
        }

        protected final int totalBytesRead() {
            if (this.totalBytesRead < 0) {
                return Integer.MAX_VALUE;
            }
            return this.totalBytesRead;
        }
    }
}
