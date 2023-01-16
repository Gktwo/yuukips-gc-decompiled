package p013io.netty.channel.unix;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.CompositeByteBuf;

/* renamed from: io.netty.channel.unix.PreferredDirectByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/channel/unix/PreferredDirectByteBufAllocator.class */
public final class PreferredDirectByteBufAllocator implements ByteBufAllocator {
    private ByteBufAllocator allocator;

    public void updateAllocator(ByteBufAllocator allocator) {
        this.allocator = allocator;
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer() {
        return this.allocator.directBuffer();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int initialCapacity) {
        return this.allocator.directBuffer(initialCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int initialCapacity, int maxCapacity) {
        return this.allocator.directBuffer(initialCapacity, maxCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer() {
        return this.allocator.directBuffer();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int initialCapacity) {
        return this.allocator.directBuffer(initialCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int initialCapacity, int maxCapacity) {
        return this.allocator.directBuffer(initialCapacity, maxCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer() {
        return this.allocator.heapBuffer();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int initialCapacity) {
        return this.allocator.heapBuffer(initialCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int initialCapacity, int maxCapacity) {
        return this.allocator.heapBuffer(initialCapacity, maxCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer() {
        return this.allocator.directBuffer();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int initialCapacity) {
        return this.allocator.directBuffer(initialCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int initialCapacity, int maxCapacity) {
        return this.allocator.directBuffer(initialCapacity, maxCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer() {
        return this.allocator.compositeDirectBuffer();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int maxNumComponents) {
        return this.allocator.compositeDirectBuffer(maxNumComponents);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer() {
        return this.allocator.compositeHeapBuffer();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int maxNumComponents) {
        return this.allocator.compositeHeapBuffer(maxNumComponents);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer() {
        return this.allocator.compositeDirectBuffer();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int maxNumComponents) {
        return this.allocator.compositeDirectBuffer(maxNumComponents);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.allocator.isDirectBufferPooled();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int minNewCapacity, int maxCapacity) {
        return this.allocator.calculateNewCapacity(minNewCapacity, maxCapacity);
    }
}
