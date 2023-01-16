package p013io.netty.channel.kqueue;

import java.nio.ByteBuffer;
import p013io.netty.channel.unix.Buffer;
import p013io.netty.util.internal.PlatformDependent;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.kqueue.KQueueEventArray */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueEventArray.class */
public final class KQueueEventArray {
    private static final int KQUEUE_EVENT_SIZE = Native.sizeofKEvent();
    private static final int KQUEUE_IDENT_OFFSET = Native.offsetofKEventIdent();
    private static final int KQUEUE_FILTER_OFFSET = Native.offsetofKEventFilter();
    private static final int KQUEUE_FFLAGS_OFFSET = Native.offsetofKEventFFlags();
    private static final int KQUEUE_FLAGS_OFFSET = Native.offsetofKEventFlags();
    private static final int KQUEUE_DATA_OFFSET = Native.offsetofKeventData();
    private ByteBuffer memory;
    private long memoryAddress;
    private int size;
    private int capacity;

    private static native void evSet(long j, int i, short s, short s2, int i2);

    /* access modifiers changed from: package-private */
    public KQueueEventArray(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity must be >= 1 but was " + capacity);
        }
        this.memory = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(capacity));
        this.memoryAddress = Buffer.memoryAddress(this.memory);
        this.capacity = capacity;
    }

    /* access modifiers changed from: package-private */
    public long memoryAddress() {
        return this.memoryAddress;
    }

    /* access modifiers changed from: package-private */
    public int capacity() {
        return this.capacity;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.size = 0;
    }

    /* access modifiers changed from: package-private */
    public void evSet(AbstractKQueueChannel ch, short filter, short flags, int fflags) {
        reallocIfNeeded();
        int i = this.size;
        this.size = i + 1;
        evSet(((long) getKEventOffset(i)) + this.memoryAddress, ch.socket.intValue(), filter, flags, fflags);
    }

    private void reallocIfNeeded() {
        if (this.size == this.capacity) {
            realloc(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void realloc(boolean throwIfFail) {
        int newLength = this.capacity <= 65536 ? this.capacity << 1 : (this.capacity + this.capacity) >> 1;
        try {
            ByteBuffer buffer = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(newLength));
            this.memory.position(0).limit(this.size);
            buffer.put(this.memory);
            buffer.position(0);
            Buffer.free(this.memory);
            this.memory = buffer;
            this.memoryAddress = Buffer.memoryAddress(buffer);
        } catch (OutOfMemoryError e) {
            if (throwIfFail) {
                OutOfMemoryError error = new OutOfMemoryError("unable to allocate " + newLength + " new bytes! Existing capacity is: " + this.capacity);
                error.initCause(e);
                throw error;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void free() {
        Buffer.free(this.memory);
        this.capacity = 0;
        this.size = 0;
        this.memoryAddress = (long) 0;
    }

    private static int getKEventOffset(int index) {
        return index * KQUEUE_EVENT_SIZE;
    }

    private long getKEventOffsetAddress(int index) {
        return ((long) getKEventOffset(index)) + this.memoryAddress;
    }

    private short getShort(int index, int offset) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getShort(getKEventOffsetAddress(index) + ((long) offset));
        }
        return this.memory.getShort(getKEventOffset(index) + offset);
    }

    /* access modifiers changed from: package-private */
    public short flags(int index) {
        return getShort(index, KQUEUE_FLAGS_OFFSET);
    }

    /* access modifiers changed from: package-private */
    public short filter(int index) {
        return getShort(index, KQUEUE_FILTER_OFFSET);
    }

    /* access modifiers changed from: package-private */
    public short fflags(int index) {
        return getShort(index, KQUEUE_FFLAGS_OFFSET);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: fd */
    public int m1180fd(int index) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getInt(getKEventOffsetAddress(index) + ((long) KQUEUE_IDENT_OFFSET));
        }
        return this.memory.getInt(getKEventOffset(index) + KQUEUE_IDENT_OFFSET);
    }

    /* access modifiers changed from: package-private */
    public long data(int index) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getLong(getKEventOffsetAddress(index) + ((long) KQUEUE_DATA_OFFSET));
        }
        return this.memory.getLong(getKEventOffset(index) + KQUEUE_DATA_OFFSET);
    }

    private static int calculateBufferCapacity(int capacity) {
        return capacity * KQUEUE_EVENT_SIZE;
    }
}
