package p013io.netty.channel.unix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.channel.unix.IovArray */
/* loaded from: grasscutter.jar:io/netty/channel/unix/IovArray.class */
public final class IovArray implements ChannelOutboundBuffer.MessageProcessor {
    private static final int ADDRESS_SIZE;
    public static final int IOV_SIZE;
    private static final int MAX_CAPACITY;
    private final long memoryAddress;
    private final ByteBuf memory;
    private int count;
    private long size;
    private long maxBytes;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !IovArray.class.desiredAssertionStatus();
        ADDRESS_SIZE = Buffer.addressSize();
        IOV_SIZE = 2 * ADDRESS_SIZE;
        MAX_CAPACITY = Limits.IOV_MAX * IOV_SIZE;
    }

    public IovArray() {
        this(Unpooled.wrappedBuffer(Buffer.allocateDirectWithNativeOrder(MAX_CAPACITY)).setIndex(0, 0));
    }

    public IovArray(ByteBuf memory) {
        ByteBuf byteBuf;
        this.maxBytes = Limits.SSIZE_MAX;
        if (!$assertionsDisabled && memory.writerIndex() != 0) {
            throw new AssertionError();
        } else if ($assertionsDisabled || memory.readerIndex() == 0) {
            if (PlatformDependent.hasUnsafe()) {
                byteBuf = memory;
            } else {
                byteBuf = memory.order(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            }
            this.memory = byteBuf;
            if (memory.hasMemoryAddress()) {
                this.memoryAddress = memory.memoryAddress();
            } else {
                this.memoryAddress = Buffer.memoryAddress(memory.internalNioBuffer(0, memory.capacity()));
            }
        } else {
            throw new AssertionError();
        }
    }

    public void clear() {
        this.count = 0;
        this.size = 0;
    }

    @Deprecated
    public boolean add(ByteBuf buf) {
        return add(buf, buf.readerIndex(), buf.readableBytes());
    }

    public boolean add(ByteBuf buf, int offset, int len) {
        if (this.count == Limits.IOV_MAX) {
            return false;
        }
        if (buf.nioBufferCount() != 1) {
            ByteBuffer[] buffers = buf.nioBuffers(offset, len);
            for (ByteBuffer nioBuffer : buffers) {
                int remaining = nioBuffer.remaining();
                if (remaining != 0 && (!add(this.memoryAddress, Buffer.memoryAddress(nioBuffer) + ((long) nioBuffer.position()), remaining) || this.count == Limits.IOV_MAX)) {
                    return false;
                }
            }
            return true;
        } else if (len == 0) {
            return true;
        } else {
            if (buf.hasMemoryAddress()) {
                return add(this.memoryAddress, buf.memoryAddress() + ((long) offset), len);
            }
            ByteBuffer nioBuffer2 = buf.internalNioBuffer(offset, len);
            return add(this.memoryAddress, Buffer.memoryAddress(nioBuffer2) + ((long) nioBuffer2.position()), len);
        }
    }

    private boolean add(long memoryAddress, long addr, int len) {
        if (!$assertionsDisabled && addr == 0) {
            throw new AssertionError();
        } else if ((this.maxBytes - ((long) len) < this.size && this.count > 0) || this.memory.capacity() < (this.count + 1) * IOV_SIZE) {
            return false;
        } else {
            int baseOffset = idx(this.count);
            int lengthOffset = baseOffset + ADDRESS_SIZE;
            this.size += (long) len;
            this.count++;
            if (ADDRESS_SIZE == 8) {
                if (PlatformDependent.hasUnsafe()) {
                    PlatformDependent.putLong(((long) baseOffset) + memoryAddress, addr);
                    PlatformDependent.putLong(((long) lengthOffset) + memoryAddress, (long) len);
                    return true;
                }
                this.memory.setLong(baseOffset, addr);
                this.memory.setLong(lengthOffset, (long) len);
                return true;
            } else if (!$assertionsDisabled && ADDRESS_SIZE != 4) {
                throw new AssertionError();
            } else if (PlatformDependent.hasUnsafe()) {
                PlatformDependent.putInt(((long) baseOffset) + memoryAddress, (int) addr);
                PlatformDependent.putInt(((long) lengthOffset) + memoryAddress, len);
                return true;
            } else {
                this.memory.setInt(baseOffset, (int) addr);
                this.memory.setInt(lengthOffset, len);
                return true;
            }
        }
    }

    public int count() {
        return this.count;
    }

    public long size() {
        return this.size;
    }

    public void maxBytes(long maxBytes) {
        this.maxBytes = Math.min(Limits.SSIZE_MAX, ObjectUtil.checkPositive(maxBytes, "maxBytes"));
    }

    public long maxBytes() {
        return this.maxBytes;
    }

    public long memoryAddress(int offset) {
        return this.memoryAddress + ((long) idx(offset));
    }

    public void release() {
        this.memory.release();
    }

    @Override // p013io.netty.channel.ChannelOutboundBuffer.MessageProcessor
    public boolean processMessage(Object msg) throws Exception {
        if (!(msg instanceof ByteBuf)) {
            return false;
        }
        ByteBuf buffer = (ByteBuf) msg;
        return add(buffer, buffer.readerIndex(), buffer.readableBytes());
    }

    private static int idx(int index) {
        return IOV_SIZE * index;
    }
}
