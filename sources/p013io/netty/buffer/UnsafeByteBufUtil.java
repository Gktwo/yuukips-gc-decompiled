package p013io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import p013io.netty.util.internal.MathUtil;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.UnsafeByteBufUtil */
/* loaded from: grasscutter.jar:io/netty/buffer/UnsafeByteBufUtil.class */
public final class UnsafeByteBufUtil {
    private static final boolean UNALIGNED;
    private static final byte ZERO = 0;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !UnsafeByteBufUtil.class.desiredAssertionStatus();
        UNALIGNED = PlatformDependent.isUnaligned();
    }

    /* access modifiers changed from: package-private */
    public static byte getByte(long address) {
        return PlatformDependent.getByte(address);
    }

    /* access modifiers changed from: package-private */
    public static short getShort(long address) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(address) << 8) | (PlatformDependent.getByte(address + 1) & 255));
        }
        short v = PlatformDependent.getShort(address);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v : Short.reverseBytes(v);
    }

    /* access modifiers changed from: package-private */
    public static short getShortLE(long address) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(address) & 255) | (PlatformDependent.getByte(address + 1) << 8));
        }
        short v = PlatformDependent.getShort(address);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(v) : v;
    }

    /* access modifiers changed from: package-private */
    public static int getUnsignedMedium(long address) {
        short s;
        if (!UNALIGNED) {
            return ((PlatformDependent.getByte(address) & 255) << 16) | ((PlatformDependent.getByte(address + 1) & 255) << 8) | (PlatformDependent.getByte(address + 2) & 255);
        }
        int i = (PlatformDependent.getByte(address) & 255) << 16;
        if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            s = PlatformDependent.getShort(address + 1);
        } else {
            s = Short.reverseBytes(PlatformDependent.getShort(address + 1));
        }
        return i | (s & 65535);
    }

    /* access modifiers changed from: package-private */
    public static int getUnsignedMediumLE(long address) {
        short s;
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(address) & 255) | ((PlatformDependent.getByte(address + 1) & 255) << 8) | ((PlatformDependent.getByte(address + 2) & 255) << 16);
        }
        int i = PlatformDependent.getByte(address) & 255;
        if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            s = Short.reverseBytes(PlatformDependent.getShort(address + 1));
        } else {
            s = PlatformDependent.getShort(address + 1);
        }
        return i | ((s & 65535) << 8);
    }

    /* access modifiers changed from: package-private */
    public static int getInt(long address) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(address) << 24) | ((PlatformDependent.getByte(address + 1) & 255) << 16) | ((PlatformDependent.getByte(address + 2) & 255) << 8) | (PlatformDependent.getByte(address + 3) & 255);
        }
        int v = PlatformDependent.getInt(address);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v : Integer.reverseBytes(v);
    }

    /* access modifiers changed from: package-private */
    public static int getIntLE(long address) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(address) & 255) | ((PlatformDependent.getByte(address + 1) & 255) << 8) | ((PlatformDependent.getByte(address + 2) & 255) << 16) | (PlatformDependent.getByte(address + 3) << 24);
        }
        int v = PlatformDependent.getInt(address);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(v) : v;
    }

    /* access modifiers changed from: package-private */
    public static long getLong(long address) {
        if (!UNALIGNED) {
            return (((long) PlatformDependent.getByte(address)) << 56) | ((((long) PlatformDependent.getByte(address + 1)) & 255) << 48) | ((((long) PlatformDependent.getByte(address + 2)) & 255) << 40) | ((((long) PlatformDependent.getByte(address + 3)) & 255) << 32) | ((((long) PlatformDependent.getByte(address + 4)) & 255) << 24) | ((((long) PlatformDependent.getByte(address + 5)) & 255) << 16) | ((((long) PlatformDependent.getByte(address + 6)) & 255) << 8) | (((long) PlatformDependent.getByte(address + 7)) & 255);
        }
        long v = PlatformDependent.getLong(address);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v : Long.reverseBytes(v);
    }

    /* access modifiers changed from: package-private */
    public static long getLongLE(long address) {
        if (!UNALIGNED) {
            return (((long) PlatformDependent.getByte(address)) & 255) | ((((long) PlatformDependent.getByte(address + 1)) & 255) << 8) | ((((long) PlatformDependent.getByte(address + 2)) & 255) << 16) | ((((long) PlatformDependent.getByte(address + 3)) & 255) << 24) | ((((long) PlatformDependent.getByte(address + 4)) & 255) << 32) | ((((long) PlatformDependent.getByte(address + 5)) & 255) << 40) | ((((long) PlatformDependent.getByte(address + 6)) & 255) << 48) | (((long) PlatformDependent.getByte(address + 7)) << 56);
        }
        long v = PlatformDependent.getLong(address);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(v) : v;
    }

    /* access modifiers changed from: package-private */
    public static void setByte(long address, int value) {
        PlatformDependent.putByte(address, (byte) value);
    }

    /* access modifiers changed from: package-private */
    public static void setShort(long address, int value) {
        if (UNALIGNED) {
            PlatformDependent.putShort(address, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? (short) value : Short.reverseBytes((short) value));
            return;
        }
        PlatformDependent.putByte(address, (byte) (value >>> 8));
        PlatformDependent.putByte(address + 1, (byte) value);
    }

    /* access modifiers changed from: package-private */
    public static void setShortLE(long address, int value) {
        if (UNALIGNED) {
            PlatformDependent.putShort(address, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) value) : (short) value);
            return;
        }
        PlatformDependent.putByte(address, (byte) value);
        PlatformDependent.putByte(address + 1, (byte) (value >>> 8));
    }

    /* access modifiers changed from: package-private */
    public static void setMedium(long address, int value) {
        PlatformDependent.putByte(address, (byte) (value >>> 16));
        if (UNALIGNED) {
            PlatformDependent.putShort(address + 1, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? (short) value : Short.reverseBytes((short) value));
            return;
        }
        PlatformDependent.putByte(address + 1, (byte) (value >>> 8));
        PlatformDependent.putByte(address + 2, (byte) value);
    }

    /* access modifiers changed from: package-private */
    public static void setMediumLE(long address, int value) {
        PlatformDependent.putByte(address, (byte) value);
        if (UNALIGNED) {
            PlatformDependent.putShort(address + 1, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) (value >>> 8)) : (short) (value >>> 8));
            return;
        }
        PlatformDependent.putByte(address + 1, (byte) (value >>> 8));
        PlatformDependent.putByte(address + 2, (byte) (value >>> 16));
    }

    /* access modifiers changed from: package-private */
    public static void setInt(long address, int value) {
        if (UNALIGNED) {
            PlatformDependent.putInt(address, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? value : Integer.reverseBytes(value));
            return;
        }
        PlatformDependent.putByte(address, (byte) (value >>> 24));
        PlatformDependent.putByte(address + 1, (byte) (value >>> 16));
        PlatformDependent.putByte(address + 2, (byte) (value >>> 8));
        PlatformDependent.putByte(address + 3, (byte) value);
    }

    /* access modifiers changed from: package-private */
    public static void setIntLE(long address, int value) {
        if (UNALIGNED) {
            PlatformDependent.putInt(address, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(value) : value);
            return;
        }
        PlatformDependent.putByte(address, (byte) value);
        PlatformDependent.putByte(address + 1, (byte) (value >>> 8));
        PlatformDependent.putByte(address + 2, (byte) (value >>> 16));
        PlatformDependent.putByte(address + 3, (byte) (value >>> 24));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* access modifiers changed from: package-private */
    public static void setLong(long address, long j) {
        if (UNALIGNED) {
            PlatformDependent.putLong(address, (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j : Long.reverseBytes(j)) == true ? 1 : 0);
            return;
        }
        PlatformDependent.putByte(address, (byte) ((int) (j >>> 56)));
        PlatformDependent.putByte(address + 1, (byte) ((int) (j >>> 48)));
        PlatformDependent.putByte(address + 2, (byte) ((int) (j >>> 40)));
        PlatformDependent.putByte(address + 3, (byte) ((int) (j >>> 32)));
        PlatformDependent.putByte(address + 4, (byte) ((int) (j >>> 24)));
        PlatformDependent.putByte(address + 5, (byte) ((int) (j >>> 16)));
        PlatformDependent.putByte(address + 6, (byte) ((int) (j >>> 8)));
        PlatformDependent.putByte(address + 7, (byte) ((int) j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* access modifiers changed from: package-private */
    public static void setLongLE(long address, long j) {
        if (UNALIGNED) {
            PlatformDependent.putLong(address, (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j) : j) == true ? 1 : 0);
            return;
        }
        PlatformDependent.putByte(address, (byte) ((int) j));
        PlatformDependent.putByte(address + 1, (byte) ((int) (j >>> 8)));
        PlatformDependent.putByte(address + 2, (byte) ((int) (j >>> 16)));
        PlatformDependent.putByte(address + 3, (byte) ((int) (j >>> 24)));
        PlatformDependent.putByte(address + 4, (byte) ((int) (j >>> 32)));
        PlatformDependent.putByte(address + 5, (byte) ((int) (j >>> 40)));
        PlatformDependent.putByte(address + 6, (byte) ((int) (j >>> 48)));
        PlatformDependent.putByte(address + 7, (byte) ((int) (j >>> 56)));
    }

    /* access modifiers changed from: package-private */
    public static byte getByte(byte[] array, int index) {
        return PlatformDependent.getByte(array, index);
    }

    /* access modifiers changed from: package-private */
    public static short getShort(byte[] array, int index) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(array, index) << 8) | (PlatformDependent.getByte(array, index + 1) & 255));
        }
        short v = PlatformDependent.getShort(array, index);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v : Short.reverseBytes(v);
    }

    /* access modifiers changed from: package-private */
    public static short getShortLE(byte[] array, int index) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(array, index) & 255) | (PlatformDependent.getByte(array, index + 1) << 8));
        }
        short v = PlatformDependent.getShort(array, index);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(v) : v;
    }

    /* access modifiers changed from: package-private */
    public static int getUnsignedMedium(byte[] array, int index) {
        short s;
        if (!UNALIGNED) {
            return ((PlatformDependent.getByte(array, index) & 255) << 16) | ((PlatformDependent.getByte(array, index + 1) & 255) << 8) | (PlatformDependent.getByte(array, index + 2) & 255);
        }
        int i = (PlatformDependent.getByte(array, index) & 255) << 16;
        if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            s = PlatformDependent.getShort(array, index + 1);
        } else {
            s = Short.reverseBytes(PlatformDependent.getShort(array, index + 1));
        }
        return i | (s & 65535);
    }

    /* access modifiers changed from: package-private */
    public static int getUnsignedMediumLE(byte[] array, int index) {
        short s;
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(array, index) & 255) | ((PlatformDependent.getByte(array, index + 1) & 255) << 8) | ((PlatformDependent.getByte(array, index + 2) & 255) << 16);
        }
        int i = PlatformDependent.getByte(array, index) & 255;
        if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            s = Short.reverseBytes(PlatformDependent.getShort(array, index + 1));
        } else {
            s = PlatformDependent.getShort(array, index + 1);
        }
        return i | ((s & 65535) << 8);
    }

    /* access modifiers changed from: package-private */
    public static int getInt(byte[] array, int index) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(array, index) << 24) | ((PlatformDependent.getByte(array, index + 1) & 255) << 16) | ((PlatformDependent.getByte(array, index + 2) & 255) << 8) | (PlatformDependent.getByte(array, index + 3) & 255);
        }
        int v = PlatformDependent.getInt(array, index);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v : Integer.reverseBytes(v);
    }

    /* access modifiers changed from: package-private */
    public static int getIntLE(byte[] array, int index) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(array, index) & 255) | ((PlatformDependent.getByte(array, index + 1) & 255) << 8) | ((PlatformDependent.getByte(array, index + 2) & 255) << 16) | (PlatformDependent.getByte(array, index + 3) << 24);
        }
        int v = PlatformDependent.getInt(array, index);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(v) : v;
    }

    /* access modifiers changed from: package-private */
    public static long getLong(byte[] array, int index) {
        if (!UNALIGNED) {
            return (((long) PlatformDependent.getByte(array, index)) << 56) | ((((long) PlatformDependent.getByte(array, index + 1)) & 255) << 48) | ((((long) PlatformDependent.getByte(array, index + 2)) & 255) << 40) | ((((long) PlatformDependent.getByte(array, index + 3)) & 255) << 32) | ((((long) PlatformDependent.getByte(array, index + 4)) & 255) << 24) | ((((long) PlatformDependent.getByte(array, index + 5)) & 255) << 16) | ((((long) PlatformDependent.getByte(array, index + 6)) & 255) << 8) | (((long) PlatformDependent.getByte(array, index + 7)) & 255);
        }
        long v = PlatformDependent.getLong(array, index);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? v : Long.reverseBytes(v);
    }

    /* access modifiers changed from: package-private */
    public static long getLongLE(byte[] array, int index) {
        if (!UNALIGNED) {
            return (((long) PlatformDependent.getByte(array, index)) & 255) | ((((long) PlatformDependent.getByte(array, index + 1)) & 255) << 8) | ((((long) PlatformDependent.getByte(array, index + 2)) & 255) << 16) | ((((long) PlatformDependent.getByte(array, index + 3)) & 255) << 24) | ((((long) PlatformDependent.getByte(array, index + 4)) & 255) << 32) | ((((long) PlatformDependent.getByte(array, index + 5)) & 255) << 40) | ((((long) PlatformDependent.getByte(array, index + 6)) & 255) << 48) | (((long) PlatformDependent.getByte(array, index + 7)) << 56);
        }
        long v = PlatformDependent.getLong(array, index);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(v) : v;
    }

    /* access modifiers changed from: package-private */
    public static void setByte(byte[] array, int index, int value) {
        PlatformDependent.putByte(array, index, (byte) value);
    }

    /* access modifiers changed from: package-private */
    public static void setShort(byte[] array, int index, int value) {
        if (UNALIGNED) {
            PlatformDependent.putShort(array, index, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? (short) value : Short.reverseBytes((short) value));
            return;
        }
        PlatformDependent.putByte(array, index, (byte) (value >>> 8));
        PlatformDependent.putByte(array, index + 1, (byte) value);
    }

    /* access modifiers changed from: package-private */
    public static void setShortLE(byte[] array, int index, int value) {
        if (UNALIGNED) {
            PlatformDependent.putShort(array, index, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) value) : (short) value);
            return;
        }
        PlatformDependent.putByte(array, index, (byte) value);
        PlatformDependent.putByte(array, index + 1, (byte) (value >>> 8));
    }

    /* access modifiers changed from: package-private */
    public static void setMedium(byte[] array, int index, int value) {
        PlatformDependent.putByte(array, index, (byte) (value >>> 16));
        if (UNALIGNED) {
            PlatformDependent.putShort(array, index + 1, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? (short) value : Short.reverseBytes((short) value));
            return;
        }
        PlatformDependent.putByte(array, index + 1, (byte) (value >>> 8));
        PlatformDependent.putByte(array, index + 2, (byte) value);
    }

    /* access modifiers changed from: package-private */
    public static void setMediumLE(byte[] array, int index, int value) {
        PlatformDependent.putByte(array, index, (byte) value);
        if (UNALIGNED) {
            PlatformDependent.putShort(array, index + 1, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes((short) (value >>> 8)) : (short) (value >>> 8));
            return;
        }
        PlatformDependent.putByte(array, index + 1, (byte) (value >>> 8));
        PlatformDependent.putByte(array, index + 2, (byte) (value >>> 16));
    }

    /* access modifiers changed from: package-private */
    public static void setInt(byte[] array, int index, int value) {
        if (UNALIGNED) {
            PlatformDependent.putInt(array, index, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? value : Integer.reverseBytes(value));
            return;
        }
        PlatformDependent.putByte(array, index, (byte) (value >>> 24));
        PlatformDependent.putByte(array, index + 1, (byte) (value >>> 16));
        PlatformDependent.putByte(array, index + 2, (byte) (value >>> 8));
        PlatformDependent.putByte(array, index + 3, (byte) value);
    }

    /* access modifiers changed from: package-private */
    public static void setIntLE(byte[] array, int index, int value) {
        if (UNALIGNED) {
            PlatformDependent.putInt(array, index, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(value) : value);
            return;
        }
        PlatformDependent.putByte(array, index, (byte) value);
        PlatformDependent.putByte(array, index + 1, (byte) (value >>> 8));
        PlatformDependent.putByte(array, index + 2, (byte) (value >>> 16));
        PlatformDependent.putByte(array, index + 3, (byte) (value >>> 24));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* access modifiers changed from: package-private */
    public static void setLong(byte[] array, int index, long j) {
        if (UNALIGNED) {
            PlatformDependent.putLong(array, index, (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j : Long.reverseBytes(j)) == true ? 1 : 0);
            return;
        }
        PlatformDependent.putByte(array, index, (byte) ((int) (j >>> 56)));
        PlatformDependent.putByte(array, index + 1, (byte) ((int) (j >>> 48)));
        PlatformDependent.putByte(array, index + 2, (byte) ((int) (j >>> 40)));
        PlatformDependent.putByte(array, index + 3, (byte) ((int) (j >>> 32)));
        PlatformDependent.putByte(array, index + 4, (byte) ((int) (j >>> 24)));
        PlatformDependent.putByte(array, index + 5, (byte) ((int) (j >>> 16)));
        PlatformDependent.putByte(array, index + 6, (byte) ((int) (j >>> 8)));
        PlatformDependent.putByte(array, index + 7, (byte) ((int) j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* access modifiers changed from: package-private */
    public static void setLongLE(byte[] array, int index, long j) {
        if (UNALIGNED) {
            PlatformDependent.putLong(array, index, (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j) : j) == true ? 1 : 0);
            return;
        }
        PlatformDependent.putByte(array, index, (byte) ((int) j));
        PlatformDependent.putByte(array, index + 1, (byte) ((int) (j >>> 8)));
        PlatformDependent.putByte(array, index + 2, (byte) ((int) (j >>> 16)));
        PlatformDependent.putByte(array, index + 3, (byte) ((int) (j >>> 24)));
        PlatformDependent.putByte(array, index + 4, (byte) ((int) (j >>> 32)));
        PlatformDependent.putByte(array, index + 5, (byte) ((int) (j >>> 40)));
        PlatformDependent.putByte(array, index + 6, (byte) ((int) (j >>> 48)));
        PlatformDependent.putByte(array, index + 7, (byte) ((int) (j >>> 56)));
    }

    /* access modifiers changed from: package-private */
    public static void setZero(byte[] array, int index, int length) {
        if (length != 0) {
            PlatformDependent.setMemory(array, index, (long) length, (byte) 0);
        }
    }

    /* access modifiers changed from: package-private */
    public static ByteBuf copy(AbstractByteBuf buf, long addr, int index, int length) {
        buf.checkIndex(index, length);
        ByteBuf copy = buf.alloc().directBuffer(length, buf.maxCapacity());
        if (length != 0) {
            if (copy.hasMemoryAddress()) {
                PlatformDependent.copyMemory(addr, copy.memoryAddress(), (long) length);
                copy.setIndex(0, length);
            } else {
                copy.writeBytes(buf, index, length);
            }
        }
        return copy;
    }

    /* access modifiers changed from: package-private */
    public static int setBytes(AbstractByteBuf buf, long addr, int index, InputStream in, int length) throws IOException {
        buf.checkIndex(index, length);
        ByteBuf tmpBuf = buf.alloc().heapBuffer(length);
        try {
            byte[] tmp = tmpBuf.array();
            int offset = tmpBuf.arrayOffset();
            int readBytes = in.read(tmp, offset, length);
            if (readBytes > 0) {
                PlatformDependent.copyMemory(tmp, offset, addr, (long) readBytes);
            }
            return readBytes;
        } finally {
            tmpBuf.release();
        }
    }

    /* access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf buf, long addr, int index, ByteBuf dst, int dstIndex, int length) {
        buf.checkIndex(index, length);
        ObjectUtil.checkNotNull(dst, "dst");
        if (MathUtil.isOutOfBounds(dstIndex, length, dst.capacity())) {
            throw new IndexOutOfBoundsException("dstIndex: " + dstIndex);
        } else if (dst.hasMemoryAddress()) {
            PlatformDependent.copyMemory(addr, dst.memoryAddress() + ((long) dstIndex), (long) length);
        } else if (dst.hasArray()) {
            PlatformDependent.copyMemory(addr, dst.array(), dst.arrayOffset() + dstIndex, (long) length);
        } else {
            dst.setBytes(dstIndex, buf, index, length);
        }
    }

    /* access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf buf, long addr, int index, byte[] dst, int dstIndex, int length) {
        buf.checkIndex(index, length);
        ObjectUtil.checkNotNull(dst, "dst");
        if (MathUtil.isOutOfBounds(dstIndex, length, dst.length)) {
            throw new IndexOutOfBoundsException("dstIndex: " + dstIndex);
        } else if (length != 0) {
            PlatformDependent.copyMemory(addr, dst, dstIndex, (long) length);
        }
    }

    /* access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf buf, long addr, int index, ByteBuffer dst) {
        buf.checkIndex(index, dst.remaining());
        if (dst.remaining() != 0) {
            if (dst.isDirect()) {
                if (dst.isReadOnly()) {
                    throw new ReadOnlyBufferException();
                }
                PlatformDependent.copyMemory(addr, PlatformDependent.directBufferAddress(dst) + ((long) dst.position()), (long) dst.remaining());
                dst.position(dst.position() + dst.remaining());
            } else if (dst.hasArray()) {
                PlatformDependent.copyMemory(addr, dst.array(), dst.arrayOffset() + dst.position(), (long) dst.remaining());
                dst.position(dst.position() + dst.remaining());
            } else {
                dst.put(buf.nioBuffer());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf buf, long addr, int index, ByteBuf src, int srcIndex, int length) {
        buf.checkIndex(index, length);
        ObjectUtil.checkNotNull(src, "src");
        if (MathUtil.isOutOfBounds(srcIndex, length, src.capacity())) {
            throw new IndexOutOfBoundsException("srcIndex: " + srcIndex);
        } else if (length == 0) {
        } else {
            if (src.hasMemoryAddress()) {
                PlatformDependent.copyMemory(src.memoryAddress() + ((long) srcIndex), addr, (long) length);
            } else if (src.hasArray()) {
                PlatformDependent.copyMemory(src.array(), src.arrayOffset() + srcIndex, addr, (long) length);
            } else {
                src.getBytes(srcIndex, buf, index, length);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf buf, long addr, int index, byte[] src, int srcIndex, int length) {
        buf.checkIndex(index, length);
        ObjectUtil.checkNotNull(src, "src");
        if (MathUtil.isOutOfBounds(srcIndex, length, src.length)) {
            throw new IndexOutOfBoundsException("srcIndex: " + srcIndex);
        } else if (length != 0) {
            PlatformDependent.copyMemory(src, srcIndex, addr, (long) length);
        }
    }

    /* access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf buf, long addr, int index, ByteBuffer src) {
        int length = src.remaining();
        if (length != 0) {
            if (src.isDirect()) {
                buf.checkIndex(index, length);
                PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(src) + ((long) src.position()), addr, (long) length);
                src.position(src.position() + length);
            } else if (src.hasArray()) {
                buf.checkIndex(index, length);
                PlatformDependent.copyMemory(src.array(), src.arrayOffset() + src.position(), addr, (long) length);
                src.position(src.position() + length);
            } else if (length < 8) {
                setSingleBytes(buf, addr, index, src, length);
            } else if ($assertionsDisabled || buf.nioBufferCount() == 1) {
                buf.internalNioBuffer(index, length).put(src);
            } else {
                throw new AssertionError();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    private static void setSingleBytes(AbstractByteBuf buf, long addr, int index, ByteBuffer src, int length) {
        buf.checkIndex(index, length);
        int srcPosition = src.position();
        int srcLimit = src.limit();
        char c = addr;
        for (int srcIndex = srcPosition; srcIndex < srcLimit; srcIndex++) {
            PlatformDependent.putByte(c, src.get(srcIndex));
            c++;
        }
        src.position(srcLimit);
    }

    /* access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf buf, long addr, int index, OutputStream out, int length) throws IOException {
        buf.checkIndex(index, length);
        if (length != 0) {
            int len = Math.min(length, 8192);
            if (len <= 1024 || !buf.alloc().isDirectBufferPooled()) {
                getBytes(addr, ByteBufUtil.threadLocalTempArray(len), 0, len, out, length);
                return;
            }
            ByteBuf tmpBuf = buf.alloc().heapBuffer(len);
            try {
                getBytes(addr, tmpBuf.array(), tmpBuf.arrayOffset(), len, out, length);
                tmpBuf.release();
            } catch (Throwable th) {
                tmpBuf.release();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:0:?, code lost:
        r7 = r7;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void getBytes(long r7, byte[] r9, int r10, int r11, java.io.OutputStream r12, int r13) throws java.io.IOException {
        /*
        L_0x0000:
            r0 = r11
            r1 = r13
            int r0 = java.lang.Math.min(r0, r1)
            r14 = r0
            r0 = r7
            r1 = r9
            r2 = r10
            r3 = r14
            long r3 = (long) r3
            p013io.netty.util.internal.PlatformDependent.copyMemory(r0, r1, r2, r3)
            r0 = r12
            r1 = r9
            r2 = r10
            r3 = r14
            r0.write(r1, r2, r3)
            r0 = r13
            r1 = r14
            int r0 = r0 - r1
            r13 = r0
            r0 = r7
            r1 = r14
            long r1 = (long) r1
            long r0 = r0 + r1
            r7 = r0
            r0 = r13
            if (r0 > 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.buffer.UnsafeByteBufUtil.getBytes(long, byte[], int, int, java.io.OutputStream, int):void");
    }

    /* access modifiers changed from: package-private */
    public static void setZero(long addr, int length) {
        if (length != 0) {
            PlatformDependent.setMemory(addr, (long) length, (byte) 0);
        }
    }

    /* access modifiers changed from: package-private */
    public static UnpooledUnsafeDirectByteBuf newUnsafeDirectByteBuf(ByteBufAllocator alloc, int initialCapacity, int maxCapacity) {
        if (PlatformDependent.useDirectBufferNoCleaner()) {
            return new UnpooledUnsafeNoCleanerDirectByteBuf(alloc, initialCapacity, maxCapacity);
        }
        return new UnpooledUnsafeDirectByteBuf(alloc, initialCapacity, maxCapacity);
    }

    private UnsafeByteBufUtil() {
    }
}
