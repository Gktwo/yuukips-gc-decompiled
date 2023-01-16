package p013io.netty.channel.epoll;

import java.nio.ByteBuffer;
import p013io.netty.channel.unix.Buffer;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.channel.epoll.EpollEventArray */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollEventArray.class */
public final class EpollEventArray {
    private static final int EPOLL_EVENT_SIZE = Native.sizeofEpollEvent();
    private static final int EPOLL_DATA_OFFSET = Native.offsetofEpollData();
    private ByteBuffer memory;
    private long memoryAddress;
    private int length;

    /* access modifiers changed from: package-private */
    public EpollEventArray(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length must be >= 1 but was " + length);
        }
        this.length = length;
        this.memory = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(length));
        this.memoryAddress = Buffer.memoryAddress(this.memory);
    }

    /* access modifiers changed from: package-private */
    public long memoryAddress() {
        return this.memoryAddress;
    }

    /* access modifiers changed from: package-private */
    public int length() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public void increase() {
        this.length <<= 1;
        ByteBuffer buffer = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(this.length));
        Buffer.free(this.memory);
        this.memory = buffer;
        this.memoryAddress = Buffer.memoryAddress(buffer);
    }

    /* access modifiers changed from: package-private */
    public void free() {
        Buffer.free(this.memory);
        this.memoryAddress = 0;
    }

    /* access modifiers changed from: package-private */
    public int events(int index) {
        return getInt(index, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: fd */
    public int m1182fd(int index) {
        return getInt(index, EPOLL_DATA_OFFSET);
    }

    private int getInt(int index, int offset) {
        if (!PlatformDependent.hasUnsafe()) {
            return this.memory.getInt((index * EPOLL_EVENT_SIZE) + offset);
        }
        return PlatformDependent.getInt(this.memoryAddress + (((long) index) * ((long) EPOLL_EVENT_SIZE)) + ((long) offset));
    }

    private static int calculateBufferCapacity(int capacity) {
        return capacity * EPOLL_EVENT_SIZE;
    }
}
