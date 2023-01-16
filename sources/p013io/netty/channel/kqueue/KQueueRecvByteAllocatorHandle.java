package p013io.netty.channel.kqueue;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.unix.PreferredDirectByteBufAllocator;
import p013io.netty.util.UncheckedBooleanSupplier;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueRecvByteAllocatorHandle.class */
public final class KQueueRecvByteAllocatorHandle extends RecvByteBufAllocator.DelegatingHandle implements RecvByteBufAllocator.ExtendedHandle {
    private final PreferredDirectByteBufAllocator preferredDirectByteBufAllocator = new PreferredDirectByteBufAllocator();
    private final UncheckedBooleanSupplier defaultMaybeMoreDataSupplier = new UncheckedBooleanSupplier() { // from class: io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle.1
        @Override // p013io.netty.util.UncheckedBooleanSupplier, p013io.netty.util.BooleanSupplier
        public boolean get() {
            return KQueueRecvByteAllocatorHandle.this.maybeMoreDataToRead();
        }
    };
    private boolean overrideGuess;
    private boolean readEOF;
    private long numberBytesPending;

    /* access modifiers changed from: package-private */
    public KQueueRecvByteAllocatorHandle(RecvByteBufAllocator.ExtendedHandle handle) {
        super(handle);
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator.DelegatingHandle, p013io.netty.channel.RecvByteBufAllocator.Handle
    public int guess() {
        return this.overrideGuess ? guess0() : delegate().guess();
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator.DelegatingHandle, p013io.netty.channel.RecvByteBufAllocator.Handle
    public void reset(ChannelConfig config) {
        this.overrideGuess = ((KQueueChannelConfig) config).getRcvAllocTransportProvidesGuess();
        delegate().reset(config);
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator.DelegatingHandle, p013io.netty.channel.RecvByteBufAllocator.Handle
    public ByteBuf allocate(ByteBufAllocator alloc) {
        this.preferredDirectByteBufAllocator.updateAllocator(alloc);
        return this.overrideGuess ? this.preferredDirectByteBufAllocator.ioBuffer(guess0()) : delegate().allocate(this.preferredDirectByteBufAllocator);
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator.DelegatingHandle, p013io.netty.channel.RecvByteBufAllocator.Handle
    public void lastBytesRead(int bytes) {
        this.numberBytesPending = bytes < 0 ? 0 : Math.max(0L, this.numberBytesPending - ((long) bytes));
        delegate().lastBytesRead(bytes);
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator.ExtendedHandle
    public boolean continueReading(UncheckedBooleanSupplier maybeMoreDataSupplier) {
        return ((RecvByteBufAllocator.ExtendedHandle) delegate()).continueReading(maybeMoreDataSupplier);
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator.DelegatingHandle, p013io.netty.channel.RecvByteBufAllocator.Handle
    public boolean continueReading() {
        return continueReading(this.defaultMaybeMoreDataSupplier);
    }

    /* access modifiers changed from: package-private */
    public void readEOF() {
        this.readEOF = true;
    }

    /* access modifiers changed from: package-private */
    public boolean isReadEOF() {
        return this.readEOF;
    }

    /* access modifiers changed from: package-private */
    public void numberBytesPending(long numberBytesPending) {
        this.numberBytesPending = numberBytesPending;
    }

    /* access modifiers changed from: package-private */
    public boolean maybeMoreDataToRead() {
        return this.numberBytesPending != 0;
    }

    private int guess0() {
        return (int) Math.min(this.numberBytesPending, 2147483647L);
    }
}
