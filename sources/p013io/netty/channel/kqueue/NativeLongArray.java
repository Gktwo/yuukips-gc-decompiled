package p013io.netty.channel.kqueue;

import java.nio.ByteBuffer;
import p013io.netty.channel.unix.Buffer;
import p013io.netty.channel.unix.Limits;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.channel.kqueue.NativeLongArray */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/NativeLongArray.class */
final class NativeLongArray {
    private ByteBuffer memory;
    private long memoryAddress;
    private int capacity;
    private int size;

    NativeLongArray(int capacity) {
        this.capacity = ObjectUtil.checkPositive(capacity, "capacity");
        this.memory = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(capacity));
        this.memoryAddress = Buffer.memoryAddress(this.memory);
    }

    private static int idx(int index) {
        return index * Limits.SIZEOF_JLONG;
    }

    private static int calculateBufferCapacity(int capacity) {
        return capacity * Limits.SIZEOF_JLONG;
    }

    void add(long value) {
        reallocIfNeeded();
        if (PlatformDependent.hasUnsafe()) {
            PlatformDependent.putLong(memoryOffset(this.size), value);
        } else {
            this.memory.putLong(idx(this.size), value);
        }
        this.size++;
    }

    void clear() {
        this.size = 0;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    int size() {
        return this.size;
    }

    void free() {
        Buffer.free(this.memory);
        this.memoryAddress = 0;
    }

    long memoryAddress() {
        return this.memoryAddress;
    }

    long memoryAddressEnd() {
        return memoryOffset(this.size);
    }

    private long memoryOffset(int index) {
        return this.memoryAddress + ((long) idx(index));
    }

    private void reallocIfNeeded() {
        if (this.size == this.capacity) {
            int newLength = this.capacity <= 65536 ? this.capacity << 1 : (this.capacity + this.capacity) >> 1;
            ByteBuffer buffer = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(newLength));
            this.memory.position(0).limit(this.size);
            buffer.put(this.memory);
            buffer.position(0);
            Buffer.free(this.memory);
            this.memory = buffer;
            this.memoryAddress = Buffer.memoryAddress(buffer);
            this.capacity = newLength;
        }
    }

    public String toString() {
        return "memoryAddress: " + this.memoryAddress + " capacity: " + this.capacity + " size: " + this.size;
    }
}
