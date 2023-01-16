package p013io.netty.channel;

import java.util.AbstractMap;
import java.util.Map;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.util.UncheckedBooleanSupplier;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.DefaultMaxBytesRecvByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultMaxBytesRecvByteBufAllocator.class */
public class DefaultMaxBytesRecvByteBufAllocator implements MaxBytesRecvByteBufAllocator {
    private volatile int maxBytesPerRead;
    private volatile int maxBytesPerIndividualRead;

    /* renamed from: io.netty.channel.DefaultMaxBytesRecvByteBufAllocator$HandleImpl */
    /* loaded from: grasscutter.jar:io/netty/channel/DefaultMaxBytesRecvByteBufAllocator$HandleImpl.class */
    private final class HandleImpl implements RecvByteBufAllocator.ExtendedHandle {
        private int individualReadMax;
        private int bytesToRead;
        private int lastBytesRead;
        private int attemptBytesRead;
        private final UncheckedBooleanSupplier defaultMaybeMoreSupplier;

        private HandleImpl() {
            this.defaultMaybeMoreSupplier = new UncheckedBooleanSupplier() { // from class: io.netty.channel.DefaultMaxBytesRecvByteBufAllocator.HandleImpl.1
                @Override // p013io.netty.util.UncheckedBooleanSupplier, p013io.netty.util.BooleanSupplier
                public boolean get() {
                    return HandleImpl.this.attemptBytesRead == HandleImpl.this.lastBytesRead;
                }
            };
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public ByteBuf allocate(ByteBufAllocator alloc) {
            return alloc.ioBuffer(guess());
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return Math.min(this.individualReadMax, this.bytesToRead);
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void reset(ChannelConfig config) {
            this.bytesToRead = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerRead();
            this.individualReadMax = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerIndividualRead();
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void incMessagesRead(int amt) {
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int bytes) {
            this.lastBytesRead = bytes;
            this.bytesToRead -= bytes;
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public int lastBytesRead() {
            return this.lastBytesRead;
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public boolean continueReading() {
            return continueReading(this.defaultMaybeMoreSupplier);
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.ExtendedHandle
        public boolean continueReading(UncheckedBooleanSupplier maybeMoreDataSupplier) {
            return this.bytesToRead > 0 && maybeMoreDataSupplier.get();
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void attemptedBytesRead(int bytes) {
            this.attemptBytesRead = bytes;
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public int attemptedBytesRead() {
            return this.attemptBytesRead;
        }
    }

    public DefaultMaxBytesRecvByteBufAllocator() {
        this(65536, 65536);
    }

    public DefaultMaxBytesRecvByteBufAllocator(int maxBytesPerRead, int maxBytesPerIndividualRead) {
        checkMaxBytesPerReadPair(maxBytesPerRead, maxBytesPerIndividualRead);
        this.maxBytesPerRead = maxBytesPerRead;
        this.maxBytesPerIndividualRead = maxBytesPerIndividualRead;
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl();
    }

    @Override // p013io.netty.channel.MaxBytesRecvByteBufAllocator
    public int maxBytesPerRead() {
        return this.maxBytesPerRead;
    }

    @Override // p013io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerRead(int maxBytesPerRead) {
        ObjectUtil.checkPositive(maxBytesPerRead, "maxBytesPerRead");
        synchronized (this) {
            int maxBytesPerIndividualRead = maxBytesPerIndividualRead();
            if (maxBytesPerRead < maxBytesPerIndividualRead) {
                throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + maxBytesPerIndividualRead + "): " + maxBytesPerRead);
            }
            this.maxBytesPerRead = maxBytesPerRead;
        }
        return this;
    }

    @Override // p013io.netty.channel.MaxBytesRecvByteBufAllocator
    public int maxBytesPerIndividualRead() {
        return this.maxBytesPerIndividualRead;
    }

    @Override // p013io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int maxBytesPerIndividualRead) {
        ObjectUtil.checkPositive(maxBytesPerIndividualRead, "maxBytesPerIndividualRead");
        synchronized (this) {
            int maxBytesPerRead = maxBytesPerRead();
            if (maxBytesPerIndividualRead > maxBytesPerRead) {
                throw new IllegalArgumentException("maxBytesPerIndividualRead cannot be greater than maxBytesPerRead (" + maxBytesPerRead + "): " + maxBytesPerIndividualRead);
            }
            this.maxBytesPerIndividualRead = maxBytesPerIndividualRead;
        }
        return this;
    }

    @Override // p013io.netty.channel.MaxBytesRecvByteBufAllocator
    public synchronized Map.Entry<Integer, Integer> maxBytesPerReadPair() {
        return new AbstractMap.SimpleEntry(Integer.valueOf(this.maxBytesPerRead), Integer.valueOf(this.maxBytesPerIndividualRead));
    }

    private static void checkMaxBytesPerReadPair(int maxBytesPerRead, int maxBytesPerIndividualRead) {
        ObjectUtil.checkPositive(maxBytesPerRead, "maxBytesPerRead");
        ObjectUtil.checkPositive(maxBytesPerIndividualRead, "maxBytesPerIndividualRead");
        if (maxBytesPerRead < maxBytesPerIndividualRead) {
            throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + maxBytesPerIndividualRead + "): " + maxBytesPerRead);
        }
    }

    @Override // p013io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerReadPair(int maxBytesPerRead, int maxBytesPerIndividualRead) {
        checkMaxBytesPerReadPair(maxBytesPerRead, maxBytesPerIndividualRead);
        synchronized (this) {
            this.maxBytesPerRead = maxBytesPerRead;
            this.maxBytesPerIndividualRead = maxBytesPerIndividualRead;
        }
        return this;
    }
}
