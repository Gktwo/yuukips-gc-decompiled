package p013io.netty.channel.unix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.channel.unix.Buffer */
/* loaded from: grasscutter.jar:io/netty/channel/unix/Buffer.class */
public final class Buffer {
    static final /* synthetic */ boolean $assertionsDisabled;

    private static native int addressSize0();

    private static native long memoryAddress0(ByteBuffer byteBuffer);

    static {
        $assertionsDisabled = !Buffer.class.desiredAssertionStatus();
    }

    private Buffer() {
    }

    public static void free(ByteBuffer buffer) {
        PlatformDependent.freeDirectBuffer(buffer);
    }

    public static ByteBuffer allocateDirectWithNativeOrder(int capacity) {
        return ByteBuffer.allocateDirect(capacity).order(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
    }

    public static long memoryAddress(ByteBuffer buffer) {
        if (!$assertionsDisabled && !buffer.isDirect()) {
            throw new AssertionError();
        } else if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.directBufferAddress(buffer);
        } else {
            return memoryAddress0(buffer);
        }
    }

    public static int addressSize() {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.addressSize();
        }
        return addressSize0();
    }
}
