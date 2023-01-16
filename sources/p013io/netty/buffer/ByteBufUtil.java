package p013io.netty.buffer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;
import java.util.Locale;
import p013io.netty.util.AsciiString;
import p013io.netty.util.ByteProcessor;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.IllegalReferenceCountException;
import p013io.netty.util.concurrent.FastThreadLocal;
import p013io.netty.util.internal.MathUtil;
import p013io.netty.util.internal.ObjectPool;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.buffer.ByteBufUtil */
/* loaded from: grasscutter.jar:io/netty/buffer/ByteBufUtil.class */
public final class ByteBufUtil {
    private static final InternalLogger logger;
    private static final FastThreadLocal<byte[]> BYTE_ARRAYS;
    private static final byte WRITE_UTF_UNKNOWN = 63;
    private static final int MAX_CHAR_BUFFER_SIZE;
    private static final int THREAD_LOCAL_BUFFER_SIZE;
    private static final int MAX_BYTES_PER_CHAR_UTF8;
    static final int WRITE_CHUNK_SIZE = 8192;
    static final ByteBufAllocator DEFAULT_ALLOCATOR;
    static final int MAX_TL_ARRAY_LEN = 1024;
    private static final ByteProcessor FIND_NON_ASCII;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        ByteBufAllocator alloc;
        $assertionsDisabled = !ByteBufUtil.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(ByteBufUtil.class);
        BYTE_ARRAYS = new FastThreadLocal<byte[]>() { // from class: io.netty.buffer.ByteBufUtil.1
            /* access modifiers changed from: protected */
            @Override // p013io.netty.util.concurrent.FastThreadLocal
            public byte[] initialValue() throws Exception {
                return PlatformDependent.allocateUninitializedArray(1024);
            }
        };
        MAX_BYTES_PER_CHAR_UTF8 = (int) CharsetUtil.encoder(CharsetUtil.UTF_8).maxBytesPerChar();
        String allocType = SystemPropertyUtil.get("io.netty.allocator.type", PlatformDependent.isAndroid() ? "unpooled" : "pooled").toLowerCase(Locale.US).trim();
        if ("unpooled".equals(allocType)) {
            alloc = UnpooledByteBufAllocator.DEFAULT;
            logger.debug("-Dio.netty.allocator.type: {}", allocType);
        } else if ("pooled".equals(allocType)) {
            alloc = PooledByteBufAllocator.DEFAULT;
            logger.debug("-Dio.netty.allocator.type: {}", allocType);
        } else {
            alloc = PooledByteBufAllocator.DEFAULT;
            logger.debug("-Dio.netty.allocator.type: pooled (unknown: {})", allocType);
        }
        DEFAULT_ALLOCATOR = alloc;
        THREAD_LOCAL_BUFFER_SIZE = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 0);
        logger.debug("-Dio.netty.threadLocalDirectBufferSize: {}", Integer.valueOf(THREAD_LOCAL_BUFFER_SIZE));
        MAX_CHAR_BUFFER_SIZE = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 16384);
        logger.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", Integer.valueOf(MAX_CHAR_BUFFER_SIZE));
        FIND_NON_ASCII = new ByteProcessor() { // from class: io.netty.buffer.ByteBufUtil.2
            @Override // p013io.netty.util.ByteProcessor
            public boolean process(byte value) {
                return value >= 0;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static byte[] threadLocalTempArray(int minLength) {
        return minLength <= 1024 ? BYTE_ARRAYS.get() : PlatformDependent.allocateUninitializedArray(minLength);
    }

    public static boolean isAccessible(ByteBuf buffer) {
        return buffer.isAccessible();
    }

    public static ByteBuf ensureAccessible(ByteBuf buffer) {
        if (buffer.isAccessible()) {
            return buffer;
        }
        throw new IllegalReferenceCountException(buffer.refCnt());
    }

    public static String hexDump(ByteBuf buffer) {
        return hexDump(buffer, buffer.readerIndex(), buffer.readableBytes());
    }

    public static String hexDump(ByteBuf buffer, int fromIndex, int length) {
        return HexUtil.hexDump(buffer, fromIndex, length);
    }

    public static String hexDump(byte[] array) {
        return hexDump(array, 0, array.length);
    }

    public static String hexDump(byte[] array, int fromIndex, int length) {
        return HexUtil.hexDump(array, fromIndex, length);
    }

    public static byte decodeHexByte(CharSequence s, int pos) {
        return StringUtil.decodeHexByte(s, pos);
    }

    public static byte[] decodeHexDump(CharSequence hexDump) {
        return StringUtil.decodeHexDump(hexDump, 0, hexDump.length());
    }

    public static byte[] decodeHexDump(CharSequence hexDump, int fromIndex, int length) {
        return StringUtil.decodeHexDump(hexDump, fromIndex, length);
    }

    public static boolean ensureWritableSuccess(int ensureWritableResult) {
        return ensureWritableResult == 0 || ensureWritableResult == 2;
    }

    public static int hashCode(ByteBuf buffer) {
        int aLen = buffer.readableBytes();
        int intCount = aLen >>> 2;
        int byteCount = aLen & 3;
        int hashCode = 1;
        int arrayIndex = buffer.readerIndex();
        if (buffer.order() == ByteOrder.BIG_ENDIAN) {
            for (int i = intCount; i > 0; i--) {
                hashCode = (31 * hashCode) + buffer.getInt(arrayIndex);
                arrayIndex += 4;
            }
        } else {
            for (int i2 = intCount; i2 > 0; i2--) {
                hashCode = (31 * hashCode) + swapInt(buffer.getInt(arrayIndex));
                arrayIndex += 4;
            }
        }
        for (int i3 = byteCount; i3 > 0; i3--) {
            arrayIndex++;
            hashCode = (31 * hashCode) + buffer.getByte(arrayIndex);
        }
        if (hashCode == 0) {
            hashCode = 1;
        }
        return hashCode;
    }

    public static int indexOf(ByteBuf needle, ByteBuf haystack) {
        if (haystack == null || needle == null || needle.readableBytes() > haystack.readableBytes()) {
            return -1;
        }
        int n = haystack.readableBytes();
        int m = needle.readableBytes();
        if (m == 0) {
            return 0;
        }
        if (m == 1) {
            return haystack.indexOf(haystack.readerIndex(), haystack.writerIndex(), needle.getByte(needle.readerIndex()));
        }
        int j = 0;
        int aStartIndex = needle.readerIndex();
        int bStartIndex = haystack.readerIndex();
        long suffixes = maxSuf(needle, m, aStartIndex, true);
        long prefixes = maxSuf(needle, m, aStartIndex, false);
        int ell = Math.max((int) (suffixes >> 32), (int) (prefixes >> 32));
        int per = Math.max((int) suffixes, (int) prefixes);
        if (equals(needle, aStartIndex, needle, aStartIndex + per, Math.min(m - per, ell + 1))) {
            int memory = -1;
            while (j <= n - m) {
                int i = Math.max(ell, memory) + 1;
                while (i < m && needle.getByte(i + aStartIndex) == haystack.getByte(i + j + bStartIndex)) {
                    i++;
                }
                if (i > n) {
                    return -1;
                }
                if (i >= m) {
                    int i2 = ell;
                    while (i2 > memory && needle.getByte(i2 + aStartIndex) == haystack.getByte(i2 + j + bStartIndex)) {
                        i2--;
                    }
                    if (i2 <= memory) {
                        return j + bStartIndex;
                    }
                    j += per;
                    memory = (m - per) - 1;
                } else {
                    j += i - ell;
                    memory = -1;
                }
            }
            return -1;
        }
        int per2 = Math.max(ell + 1, (m - ell) - 1) + 1;
        while (j <= n - m) {
            int i3 = ell + 1;
            while (i3 < m && needle.getByte(i3 + aStartIndex) == haystack.getByte(i3 + j + bStartIndex)) {
                i3++;
            }
            if (i3 > n) {
                return -1;
            }
            if (i3 >= m) {
                int i4 = ell;
                while (i4 >= 0 && needle.getByte(i4 + aStartIndex) == haystack.getByte(i4 + j + bStartIndex)) {
                    i4--;
                }
                if (i4 < 0) {
                    return j + bStartIndex;
                }
                j += per2;
            } else {
                j += i3 - ell;
            }
        }
        return -1;
    }

    private static long maxSuf(ByteBuf x, int m, int start, boolean isSuffix) {
        int p = 1;
        int ms = -1;
        int j = start;
        int k = 1;
        while (j + k < m) {
            byte a = x.getByte(j + k);
            byte b = x.getByte(ms + k);
            if (isSuffix ? a < b : a > b) {
                j += k;
                k = 1;
                p = j - ms;
            } else if (a != b) {
                ms = j;
                j = ms + 1;
                p = 1;
                k = 1;
            } else if (k != p) {
                k++;
            } else {
                j += p;
                k = 1;
            }
        }
        return (((long) ms) << 32) + ((long) p);
    }

    public static boolean equals(ByteBuf a, int aStartIndex, ByteBuf b, int bStartIndex, int length) {
        ObjectUtil.checkNotNull(a, "a");
        ObjectUtil.checkNotNull(b, "b");
        ObjectUtil.checkPositiveOrZero(aStartIndex, "aStartIndex");
        ObjectUtil.checkPositiveOrZero(bStartIndex, "bStartIndex");
        ObjectUtil.checkPositiveOrZero(length, "length");
        if (a.writerIndex() - length < aStartIndex || b.writerIndex() - length < bStartIndex) {
            return false;
        }
        int longCount = length >>> 3;
        int byteCount = length & 7;
        if (a.order() == b.order()) {
            for (int i = longCount; i > 0; i--) {
                if (a.getLong(aStartIndex) != b.getLong(bStartIndex)) {
                    return false;
                }
                aStartIndex += 8;
                bStartIndex += 8;
            }
        } else {
            for (int i2 = longCount; i2 > 0; i2--) {
                if (a.getLong(aStartIndex) != swapLong(b.getLong(bStartIndex))) {
                    return false;
                }
                aStartIndex += 8;
                bStartIndex += 8;
            }
        }
        for (int i3 = byteCount; i3 > 0; i3--) {
            if (a.getByte(aStartIndex) != b.getByte(bStartIndex)) {
                return false;
            }
            aStartIndex++;
            bStartIndex++;
        }
        return true;
    }

    public static boolean equals(ByteBuf bufferA, ByteBuf bufferB) {
        if (bufferA == bufferB) {
            return true;
        }
        int aLen = bufferA.readableBytes();
        if (aLen != bufferB.readableBytes()) {
            return false;
        }
        return equals(bufferA, bufferA.readerIndex(), bufferB, bufferB.readerIndex(), aLen);
    }

    public static int compare(ByteBuf bufferA, ByteBuf bufferB) {
        long res;
        if (bufferA == bufferB) {
            return 0;
        }
        int aLen = bufferA.readableBytes();
        int bLen = bufferB.readableBytes();
        int minLength = Math.min(aLen, bLen);
        int uintCount = minLength >>> 2;
        int byteCount = minLength & 3;
        int aIndex = bufferA.readerIndex();
        int bIndex = bufferB.readerIndex();
        if (uintCount > 0) {
            boolean bufferAIsBigEndian = bufferA.order() == ByteOrder.BIG_ENDIAN;
            int uintCountIncrement = uintCount << 2;
            if (bufferA.order() == bufferB.order()) {
                res = bufferAIsBigEndian ? compareUintBigEndian(bufferA, bufferB, aIndex, bIndex, uintCountIncrement) : compareUintLittleEndian(bufferA, bufferB, aIndex, bIndex, uintCountIncrement);
            } else {
                res = bufferAIsBigEndian ? compareUintBigEndianA(bufferA, bufferB, aIndex, bIndex, uintCountIncrement) : compareUintBigEndianB(bufferA, bufferB, aIndex, bIndex, uintCountIncrement);
            }
            if (res != 0) {
                return (int) Math.min(2147483647L, Math.max(-2147483648L, res));
            }
            aIndex += uintCountIncrement;
            bIndex += uintCountIncrement;
        }
        int aEnd = aIndex + byteCount;
        while (aIndex < aEnd) {
            int comp = bufferA.getUnsignedByte(aIndex) - bufferB.getUnsignedByte(bIndex);
            if (comp != 0) {
                return comp;
            }
            aIndex++;
            bIndex++;
        }
        return aLen - bLen;
    }

    private static long compareUintBigEndian(ByteBuf bufferA, ByteBuf bufferB, int aIndex, int bIndex, int uintCountIncrement) {
        int aEnd = aIndex + uintCountIncrement;
        while (aIndex < aEnd) {
            long comp = bufferA.getUnsignedInt(aIndex) - bufferB.getUnsignedInt(bIndex);
            if (comp != 0) {
                return comp;
            }
            aIndex += 4;
            bIndex += 4;
        }
        return 0;
    }

    private static long compareUintLittleEndian(ByteBuf bufferA, ByteBuf bufferB, int aIndex, int bIndex, int uintCountIncrement) {
        int aEnd = aIndex + uintCountIncrement;
        while (aIndex < aEnd) {
            long comp = uintFromLE(bufferA.getUnsignedIntLE(aIndex)) - uintFromLE(bufferB.getUnsignedIntLE(bIndex));
            if (comp != 0) {
                return comp;
            }
            aIndex += 4;
            bIndex += 4;
        }
        return 0;
    }

    private static long compareUintBigEndianA(ByteBuf bufferA, ByteBuf bufferB, int aIndex, int bIndex, int uintCountIncrement) {
        int aEnd = aIndex + uintCountIncrement;
        while (aIndex < aEnd) {
            long comp = bufferA.getUnsignedInt(aIndex) - uintFromLE(bufferB.getUnsignedIntLE(bIndex));
            if (comp != 0) {
                return comp;
            }
            aIndex += 4;
            bIndex += 4;
        }
        return 0;
    }

    private static long compareUintBigEndianB(ByteBuf bufferA, ByteBuf bufferB, int aIndex, int bIndex, int uintCountIncrement) {
        int aEnd = aIndex + uintCountIncrement;
        while (aIndex < aEnd) {
            long comp = uintFromLE(bufferA.getUnsignedIntLE(aIndex)) - bufferB.getUnsignedInt(bIndex);
            if (comp != 0) {
                return comp;
            }
            aIndex += 4;
            bIndex += 4;
        }
        return 0;
    }

    private static long uintFromLE(long value) {
        return Long.reverseBytes(value) >>> 32;
    }

    /* renamed from: io.netty.buffer.ByteBufUtil$SWARByteSearch */
    /* loaded from: grasscutter.jar:io/netty/buffer/ByteBufUtil$SWARByteSearch.class */
    private static final class SWARByteSearch {
        private SWARByteSearch() {
        }

        /* access modifiers changed from: private */
        public static long compilePattern(byte byteToFind) {
            return (((long) byteToFind) & 255) * 72340172838076673L;
        }

        /* access modifiers changed from: private */
        public static int firstAnyPattern(long word, long pattern, boolean leading) {
            long input = word ^ pattern;
            long tmp = ((((input & 9187201950435737471L) + 9187201950435737471L) | input) | 9187201950435737471L) ^ -1;
            return (leading ? Long.numberOfLeadingZeros(tmp) : Long.numberOfTrailingZeros(tmp)) >>> 3;
        }
    }

    private static int unrolledFirstIndexOf(AbstractByteBuf buffer, int fromIndex, int byteCount, byte value) {
        if (!$assertionsDisabled && (byteCount <= 0 || byteCount >= 8)) {
            throw new AssertionError();
        } else if (buffer._getByte(fromIndex) == value) {
            return fromIndex;
        } else {
            if (byteCount == 1) {
                return -1;
            }
            if (buffer._getByte(fromIndex + 1) == value) {
                return fromIndex + 1;
            }
            if (byteCount == 2) {
                return -1;
            }
            if (buffer._getByte(fromIndex + 2) == value) {
                return fromIndex + 2;
            }
            if (byteCount == 3) {
                return -1;
            }
            if (buffer._getByte(fromIndex + 3) == value) {
                return fromIndex + 3;
            }
            if (byteCount == 4) {
                return -1;
            }
            if (buffer._getByte(fromIndex + 4) == value) {
                return fromIndex + 4;
            }
            if (byteCount == 5) {
                return -1;
            }
            if (buffer._getByte(fromIndex + 5) == value) {
                return fromIndex + 5;
            }
            if (byteCount != 6 && buffer._getByte(fromIndex + 6) == value) {
                return fromIndex + 6;
            }
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public static int firstIndexOf(AbstractByteBuf buffer, int fromIndex, int toIndex, byte value) {
        int fromIndex2 = Math.max(fromIndex, 0);
        if (fromIndex2 >= toIndex || buffer.capacity() == 0) {
            return -1;
        }
        int length = toIndex - fromIndex2;
        buffer.checkIndex(fromIndex2, length);
        if (!PlatformDependent.isUnaligned()) {
            return linearFirstIndexOf(buffer, fromIndex2, toIndex, value);
        }
        if ($assertionsDisabled || PlatformDependent.isUnaligned()) {
            int offset = fromIndex2;
            int byteCount = length & 7;
            if (byteCount > 0) {
                int index = unrolledFirstIndexOf(buffer, fromIndex2, byteCount, value);
                if (index != -1) {
                    return index;
                }
                offset += byteCount;
                if (offset == toIndex) {
                    return -1;
                }
            }
            int longCount = length >>> 3;
            ByteOrder nativeOrder = ByteOrder.nativeOrder();
            boolean isNative = nativeOrder == buffer.order();
            boolean useLE = nativeOrder == ByteOrder.LITTLE_ENDIAN;
            long pattern = SWARByteSearch.compilePattern(value);
            for (int i = 0; i < longCount; i++) {
                int index2 = SWARByteSearch.firstAnyPattern(useLE ? buffer._getLongLE(offset) : buffer._getLong(offset), pattern, isNative);
                if (index2 < 8) {
                    return offset + index2;
                }
                offset += 8;
            }
            return -1;
        }
        throw new AssertionError();
    }

    private static int linearFirstIndexOf(AbstractByteBuf buffer, int fromIndex, int toIndex, byte value) {
        for (int i = fromIndex; i < toIndex; i++) {
            if (buffer._getByte(i) == value) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(ByteBuf buffer, int fromIndex, int toIndex, byte value) {
        return buffer.indexOf(fromIndex, toIndex, value);
    }

    public static short swapShort(short value) {
        return Short.reverseBytes(value);
    }

    public static int swapMedium(int value) {
        int swapped = ((value << 16) & 16711680) | (value & 65280) | ((value >>> 16) & 255);
        if ((swapped & 8388608) != 0) {
            swapped |= -16777216;
        }
        return swapped;
    }

    public static int swapInt(int value) {
        return Integer.reverseBytes(value);
    }

    public static long swapLong(long value) {
        return Long.reverseBytes(value);
    }

    public static ByteBuf writeShortBE(ByteBuf buf, int shortValue) {
        return buf.order() == ByteOrder.BIG_ENDIAN ? buf.writeShort(shortValue) : buf.writeShort(swapShort((short) shortValue));
    }

    public static ByteBuf setShortBE(ByteBuf buf, int index, int shortValue) {
        return buf.order() == ByteOrder.BIG_ENDIAN ? buf.setShort(index, shortValue) : buf.setShort(index, swapShort((short) shortValue));
    }

    public static ByteBuf writeMediumBE(ByteBuf buf, int mediumValue) {
        return buf.order() == ByteOrder.BIG_ENDIAN ? buf.writeMedium(mediumValue) : buf.writeMedium(swapMedium(mediumValue));
    }

    public static ByteBuf readBytes(ByteBufAllocator alloc, ByteBuf buffer, int length) {
        boolean release = true;
        ByteBuf dst = alloc.buffer(length);
        try {
            buffer.readBytes(dst);
            release = false;
            if (0 != 0) {
                dst.release();
            }
            return dst;
        } catch (Throwable th) {
            if (release) {
                dst.release();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static int lastIndexOf(AbstractByteBuf buffer, int fromIndex, int toIndex, byte value) {
        if ($assertionsDisabled || fromIndex > toIndex) {
            int capacity = buffer.capacity();
            int fromIndex2 = Math.min(fromIndex, capacity);
            if (fromIndex2 < 0 || capacity == 0) {
                return -1;
            }
            buffer.checkIndex(toIndex, fromIndex2 - toIndex);
            for (int i = fromIndex2 - 1; i >= toIndex; i--) {
                if (buffer._getByte(i) == value) {
                    return i;
                }
            }
            return -1;
        }
        throw new AssertionError();
    }

    private static CharSequence checkCharSequenceBounds(CharSequence seq, int start, int end) {
        if (!MathUtil.isOutOfBounds(start, end - start, seq.length())) {
            return seq;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= end (" + end + ") <= seq.length(" + seq.length() + ')');
    }

    public static ByteBuf writeUtf8(ByteBufAllocator alloc, CharSequence seq) {
        ByteBuf buf = alloc.buffer(utf8MaxBytes(seq));
        writeUtf8(buf, seq);
        return buf;
    }

    public static int writeUtf8(ByteBuf buf, CharSequence seq) {
        int seqLength = seq.length();
        return reserveAndWriteUtf8Seq(buf, seq, 0, seqLength, utf8MaxBytes(seqLength));
    }

    public static int writeUtf8(ByteBuf buf, CharSequence seq, int start, int end) {
        checkCharSequenceBounds(seq, start, end);
        return reserveAndWriteUtf8Seq(buf, seq, start, end, utf8MaxBytes(end - start));
    }

    public static int reserveAndWriteUtf8(ByteBuf buf, CharSequence seq, int reserveBytes) {
        return reserveAndWriteUtf8Seq(buf, seq, 0, seq.length(), reserveBytes);
    }

    public static int reserveAndWriteUtf8(ByteBuf buf, CharSequence seq, int start, int end, int reserveBytes) {
        return reserveAndWriteUtf8Seq(buf, checkCharSequenceBounds(seq, start, end), start, end, reserveBytes);
    }

    private static int reserveAndWriteUtf8Seq(ByteBuf buf, CharSequence seq, int start, int end, int reserveBytes) {
        while (true) {
            if (buf instanceof WrappedCompositeByteBuf) {
                buf = buf.unwrap();
            } else if (buf instanceof AbstractByteBuf) {
                AbstractByteBuf byteBuf = (AbstractByteBuf) buf;
                byteBuf.ensureWritable0(reserveBytes);
                int written = writeUtf8(byteBuf, byteBuf.writerIndex, reserveBytes, seq, start, end);
                byteBuf.writerIndex += written;
                return written;
            } else if (buf instanceof WrappedByteBuf) {
                buf = buf.unwrap();
            } else {
                byte[] bytes = seq.subSequence(start, end).toString().getBytes(CharsetUtil.UTF_8);
                buf.writeBytes(bytes);
                return bytes.length;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static int writeUtf8(AbstractByteBuf buffer, int writerIndex, int reservedBytes, CharSequence seq, int len) {
        return writeUtf8(buffer, writerIndex, reservedBytes, seq, 0, len);
    }

    static int writeUtf8(AbstractByteBuf buffer, int writerIndex, int reservedBytes, CharSequence seq, int start, int end) {
        if (seq instanceof AsciiString) {
            writeAsciiString(buffer, writerIndex, (AsciiString) seq, start, end);
            return end - start;
        }
        if (PlatformDependent.hasUnsafe()) {
            if (buffer.hasArray()) {
                return unsafeWriteUtf8(buffer.array(), PlatformDependent.byteArrayBaseOffset(), buffer.arrayOffset() + writerIndex, seq, start, end);
            }
            if (buffer.hasMemoryAddress()) {
                return unsafeWriteUtf8(null, buffer.memoryAddress(), writerIndex, seq, start, end);
            }
        } else if (buffer.hasArray()) {
            return safeArrayWriteUtf8(buffer.array(), buffer.arrayOffset() + writerIndex, seq, start, end);
        } else {
            if (buffer.isDirect()) {
                if ($assertionsDisabled || buffer.nioBufferCount() == 1) {
                    ByteBuffer internalDirectBuffer = buffer.internalNioBuffer(writerIndex, reservedBytes);
                    return safeDirectWriteUtf8(internalDirectBuffer, internalDirectBuffer.position(), seq, start, end);
                }
                throw new AssertionError();
            }
        }
        return safeWriteUtf8(buffer, writerIndex, seq, start, end);
    }

    static void writeAsciiString(AbstractByteBuf buffer, int writerIndex, AsciiString seq, int start, int end) {
        int begin = seq.arrayOffset() + start;
        int length = end - start;
        if (PlatformDependent.hasUnsafe()) {
            if (buffer.hasArray()) {
                PlatformDependent.copyMemory(seq.array(), begin, buffer.array(), buffer.arrayOffset() + writerIndex, (long) length);
                return;
            } else if (buffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(seq.array(), begin, buffer.memoryAddress() + ((long) writerIndex), (long) length);
                return;
            }
        }
        if (buffer.hasArray()) {
            System.arraycopy(seq.array(), begin, buffer.array(), buffer.arrayOffset() + writerIndex, length);
        } else {
            buffer.setBytes(writerIndex, seq.array(), begin, length);
        }
    }

    private static int safeDirectWriteUtf8(ByteBuffer buffer, int writerIndex, CharSequence seq, int start, int end) {
        if ($assertionsDisabled || !(seq instanceof AsciiString)) {
            int i = start;
            while (true) {
                if (i >= end) {
                    break;
                }
                char c = seq.charAt(i);
                if (c < 128) {
                    writerIndex++;
                    buffer.put(writerIndex, (byte) c);
                } else if (c < 2048) {
                    int writerIndex2 = writerIndex + 1;
                    buffer.put(writerIndex, (byte) (192 | (c >> 6)));
                    writerIndex = writerIndex2 + 1;
                    buffer.put(writerIndex2, (byte) (128 | (c & '?')));
                } else if (!StringUtil.isSurrogate(c)) {
                    int writerIndex3 = writerIndex + 1;
                    buffer.put(writerIndex, (byte) (224 | (c >> '\f')));
                    int writerIndex4 = writerIndex3 + 1;
                    buffer.put(writerIndex3, (byte) (128 | ((c >> 6) & 63)));
                    writerIndex = writerIndex4 + 1;
                    buffer.put(writerIndex4, (byte) (128 | (c & '?')));
                } else if (!Character.isHighSurrogate(c)) {
                    writerIndex++;
                    buffer.put(writerIndex, (byte) 63);
                } else {
                    i++;
                    if (i == end) {
                        writerIndex++;
                        buffer.put(writerIndex, (byte) 63);
                        break;
                    }
                    char c2 = seq.charAt(i);
                    if (!Character.isLowSurrogate(c2)) {
                        int writerIndex5 = writerIndex + 1;
                        buffer.put(writerIndex, (byte) 63);
                        writerIndex = writerIndex5 + 1;
                        buffer.put(writerIndex5, Character.isHighSurrogate(c2) ? 63 : (byte) c2);
                    } else {
                        int codePoint = Character.toCodePoint(c, c2);
                        int writerIndex6 = writerIndex + 1;
                        buffer.put(writerIndex, (byte) (240 | (codePoint >> 18)));
                        int writerIndex7 = writerIndex6 + 1;
                        buffer.put(writerIndex6, (byte) (128 | ((codePoint >> 12) & 63)));
                        int writerIndex8 = writerIndex7 + 1;
                        buffer.put(writerIndex7, (byte) (128 | ((codePoint >> 6) & 63)));
                        writerIndex = writerIndex8 + 1;
                        buffer.put(writerIndex8, (byte) (128 | (codePoint & 63)));
                    }
                }
                i++;
            }
            return writerIndex - writerIndex;
        }
        throw new AssertionError();
    }

    private static int safeWriteUtf8(AbstractByteBuf buffer, int writerIndex, CharSequence seq, int start, int end) {
        if ($assertionsDisabled || !(seq instanceof AsciiString)) {
            int i = start;
            while (true) {
                if (i >= end) {
                    break;
                }
                char c = seq.charAt(i);
                if (c < 128) {
                    writerIndex++;
                    buffer._setByte(writerIndex, (byte) c);
                } else if (c < 2048) {
                    int writerIndex2 = writerIndex + 1;
                    buffer._setByte(writerIndex, (byte) (192 | (c >> 6)));
                    writerIndex = writerIndex2 + 1;
                    buffer._setByte(writerIndex2, (byte) (128 | (c & '?')));
                } else if (!StringUtil.isSurrogate(c)) {
                    int writerIndex3 = writerIndex + 1;
                    buffer._setByte(writerIndex, (byte) (224 | (c >> '\f')));
                    int writerIndex4 = writerIndex3 + 1;
                    buffer._setByte(writerIndex3, (byte) (128 | ((c >> 6) & 63)));
                    writerIndex = writerIndex4 + 1;
                    buffer._setByte(writerIndex4, (byte) (128 | (c & '?')));
                } else if (!Character.isHighSurrogate(c)) {
                    writerIndex++;
                    buffer._setByte(writerIndex, 63);
                } else {
                    i++;
                    if (i == end) {
                        writerIndex++;
                        buffer._setByte(writerIndex, 63);
                        break;
                    }
                    char c2 = seq.charAt(i);
                    if (!Character.isLowSurrogate(c2)) {
                        int writerIndex5 = writerIndex + 1;
                        buffer._setByte(writerIndex, 63);
                        writerIndex = writerIndex5 + 1;
                        buffer._setByte(writerIndex5, Character.isHighSurrogate(c2) ? '?' : c2);
                    } else {
                        int codePoint = Character.toCodePoint(c, c2);
                        int writerIndex6 = writerIndex + 1;
                        buffer._setByte(writerIndex, (byte) (240 | (codePoint >> 18)));
                        int writerIndex7 = writerIndex6 + 1;
                        buffer._setByte(writerIndex6, (byte) (128 | ((codePoint >> 12) & 63)));
                        int writerIndex8 = writerIndex7 + 1;
                        buffer._setByte(writerIndex7, (byte) (128 | ((codePoint >> 6) & 63)));
                        writerIndex = writerIndex8 + 1;
                        buffer._setByte(writerIndex8, (byte) (128 | (codePoint & 63)));
                    }
                }
                i++;
            }
            return writerIndex - writerIndex;
        }
        throw new AssertionError();
    }

    private static int safeArrayWriteUtf8(byte[] buffer, int writerIndex, CharSequence seq, int start, int end) {
        int i = start;
        while (true) {
            if (i >= end) {
                break;
            }
            char c = seq.charAt(i);
            if (c < 128) {
                writerIndex++;
                buffer[writerIndex] = (byte) c;
            } else if (c < 2048) {
                int writerIndex2 = writerIndex + 1;
                buffer[writerIndex] = (byte) (192 | (c >> 6));
                writerIndex = writerIndex2 + 1;
                buffer[writerIndex2] = (byte) (128 | (c & '?'));
            } else if (!StringUtil.isSurrogate(c)) {
                int writerIndex3 = writerIndex + 1;
                buffer[writerIndex] = (byte) (224 | (c >> '\f'));
                int writerIndex4 = writerIndex3 + 1;
                buffer[writerIndex3] = (byte) (128 | ((c >> 6) & 63));
                writerIndex = writerIndex4 + 1;
                buffer[writerIndex4] = (byte) (128 | (c & '?'));
            } else if (!Character.isHighSurrogate(c)) {
                writerIndex++;
                buffer[writerIndex] = 63;
            } else {
                i++;
                if (i == end) {
                    writerIndex++;
                    buffer[writerIndex] = 63;
                    break;
                }
                char c2 = seq.charAt(i);
                if (!Character.isLowSurrogate(c2)) {
                    int writerIndex5 = writerIndex + 1;
                    buffer[writerIndex] = 63;
                    writerIndex = writerIndex5 + 1;
                    buffer[writerIndex5] = (byte) (Character.isHighSurrogate(c2) ? '?' : c2);
                } else {
                    int codePoint = Character.toCodePoint(c, c2);
                    int writerIndex6 = writerIndex + 1;
                    buffer[writerIndex] = (byte) (240 | (codePoint >> 18));
                    int writerIndex7 = writerIndex6 + 1;
                    buffer[writerIndex6] = (byte) (128 | ((codePoint >> 12) & 63));
                    int writerIndex8 = writerIndex7 + 1;
                    buffer[writerIndex7] = (byte) (128 | ((codePoint >> 6) & 63));
                    writerIndex = writerIndex8 + 1;
                    buffer[writerIndex8] = (byte) (128 | (codePoint & 63));
                }
            }
            i++;
        }
        return writerIndex - writerIndex;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x01a4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x01aa */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: byte[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Object, long] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, long] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, long] */
    /* JADX WARN: Type inference failed for: r15v7, types: [long] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.Object, long] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object, long] */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.Object, long] */
    /* JADX WARN: Type inference failed for: r2v39, types: [java.lang.Object, long] */
    /* JADX WARN: Type inference failed for: r2v53, types: [java.lang.Object, long] */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int unsafeWriteUtf8(byte[] r8, long r9, int r11, java.lang.CharSequence r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 433
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.buffer.ByteBufUtil.unsafeWriteUtf8(byte[], long, int, java.lang.CharSequence, int, int):int");
    }

    public static int utf8MaxBytes(int seqLength) {
        return seqLength * MAX_BYTES_PER_CHAR_UTF8;
    }

    public static int utf8MaxBytes(CharSequence seq) {
        return utf8MaxBytes(seq.length());
    }

    public static int utf8Bytes(CharSequence seq) {
        return utf8ByteCount(seq, 0, seq.length());
    }

    public static int utf8Bytes(CharSequence seq, int start, int end) {
        return utf8ByteCount(checkCharSequenceBounds(seq, start, end), start, end);
    }

    private static int utf8ByteCount(CharSequence seq, int start, int end) {
        if (seq instanceof AsciiString) {
            return end - start;
        }
        int i = start;
        while (i < end && seq.charAt(i) < 128) {
            i++;
        }
        return i < end ? (i - start) + utf8BytesNonAscii(seq, i, end) : i - start;
    }

    private static int utf8BytesNonAscii(CharSequence seq, int start, int end) {
        int encodedLength = 0;
        int i = start;
        while (true) {
            if (i >= end) {
                break;
            }
            char c = seq.charAt(i);
            if (c < 2048) {
                encodedLength += ((127 - c) >>> 31) + 1;
            } else if (!StringUtil.isSurrogate(c)) {
                encodedLength += 3;
            } else if (!Character.isHighSurrogate(c)) {
                encodedLength++;
            } else {
                i++;
                if (i == end) {
                    encodedLength++;
                    break;
                } else if (!Character.isLowSurrogate(seq.charAt(i))) {
                    encodedLength += 2;
                } else {
                    encodedLength += 4;
                }
            }
            i++;
        }
        return encodedLength;
    }

    public static ByteBuf writeAscii(ByteBufAllocator alloc, CharSequence seq) {
        ByteBuf buf = alloc.buffer(seq.length());
        writeAscii(buf, seq);
        return buf;
    }

    public static int writeAscii(ByteBuf buf, CharSequence seq) {
        while (true) {
            if (buf instanceof WrappedCompositeByteBuf) {
                buf = buf.unwrap();
            } else if (buf instanceof AbstractByteBuf) {
                int len = seq.length();
                AbstractByteBuf byteBuf = (AbstractByteBuf) buf;
                byteBuf.ensureWritable0(len);
                if (seq instanceof AsciiString) {
                    writeAsciiString(byteBuf, byteBuf.writerIndex, (AsciiString) seq, 0, len);
                } else {
                    int written = writeAscii(byteBuf, byteBuf.writerIndex, seq, len);
                    if (!$assertionsDisabled && written != len) {
                        throw new AssertionError();
                    }
                }
                byteBuf.writerIndex += len;
                return len;
            } else if (buf instanceof WrappedByteBuf) {
                buf = buf.unwrap();
            } else {
                byte[] bytes = seq.toString().getBytes(CharsetUtil.US_ASCII);
                buf.writeBytes(bytes);
                return bytes.length;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static int writeAscii(AbstractByteBuf buffer, int writerIndex, CharSequence seq, int len) {
        for (int i = 0; i < len; i++) {
            writerIndex++;
            buffer._setByte(writerIndex, AsciiString.c2b(seq.charAt(i)));
        }
        return len;
    }

    public static ByteBuf encodeString(ByteBufAllocator alloc, CharBuffer src, Charset charset) {
        return encodeString0(alloc, false, src, charset, 0);
    }

    public static ByteBuf encodeString(ByteBufAllocator alloc, CharBuffer src, Charset charset, int extraCapacity) {
        return encodeString0(alloc, false, src, charset, extraCapacity);
    }

    /* access modifiers changed from: package-private */
    public static ByteBuf encodeString0(ByteBufAllocator alloc, boolean enforceHeap, CharBuffer src, Charset charset, int extraCapacity) {
        ByteBuf dst;
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        int length = ((int) (((double) src.remaining()) * ((double) encoder.maxBytesPerChar()))) + extraCapacity;
        boolean release = true;
        if (enforceHeap) {
            dst = alloc.heapBuffer(length);
        } else {
            dst = alloc.buffer(length);
        }
        try {
            try {
                ByteBuffer dstBuf = dst.internalNioBuffer(dst.readerIndex(), length);
                int pos = dstBuf.position();
                CoderResult cr = encoder.encode(src, dstBuf, true);
                if (!cr.isUnderflow()) {
                    cr.throwException();
                }
                CoderResult cr2 = encoder.flush(dstBuf);
                if (!cr2.isUnderflow()) {
                    cr2.throwException();
                }
                dst.writerIndex((dst.writerIndex() + dstBuf.position()) - pos);
                release = false;
                if (0 != 0) {
                    dst.release();
                }
                return dst;
            } catch (CharacterCodingException x) {
                throw new IllegalStateException(x);
            }
        } catch (Throwable th) {
            if (release) {
                dst.release();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static String decodeString(ByteBuf src, int readerIndex, int len, Charset charset) {
        int offset;
        byte[] array;
        if (len == 0) {
            return "";
        }
        if (src.hasArray()) {
            array = src.array();
            offset = src.arrayOffset() + readerIndex;
        } else {
            array = threadLocalTempArray(len);
            offset = 0;
            src.getBytes(readerIndex, array, 0, len);
        }
        if (CharsetUtil.US_ASCII.equals(charset)) {
            return new String(array, 0, offset, len);
        }
        return new String(array, offset, len, charset);
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        if (PlatformDependent.hasUnsafe()) {
            return ThreadLocalUnsafeDirectByteBuf.newInstance();
        }
        return ThreadLocalDirectByteBuf.newInstance();
    }

    public static byte[] getBytes(ByteBuf buf) {
        return getBytes(buf, buf.readerIndex(), buf.readableBytes());
    }

    public static byte[] getBytes(ByteBuf buf, int start, int length) {
        return getBytes(buf, start, length, true);
    }

    public static byte[] getBytes(ByteBuf buf, int start, int length, boolean copy) {
        int capacity = buf.capacity();
        if (MathUtil.isOutOfBounds(start, length, capacity)) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= start + length(" + length + ") <= buf.capacity(" + capacity + ')');
        } else if (buf.hasArray()) {
            int baseOffset = buf.arrayOffset() + start;
            byte[] bytes = buf.array();
            if (!copy && baseOffset == 0 && length == bytes.length) {
                return bytes;
            }
            return Arrays.copyOfRange(bytes, baseOffset, baseOffset + length);
        } else {
            byte[] bytes2 = PlatformDependent.allocateUninitializedArray(length);
            buf.getBytes(start, bytes2);
            return bytes2;
        }
    }

    public static void copy(AsciiString src, ByteBuf dst) {
        copy(src, 0, dst, src.length());
    }

    public static void copy(AsciiString src, int srcIdx, ByteBuf dst, int dstIdx, int length) {
        if (MathUtil.isOutOfBounds(srcIdx, length, src.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + srcIdx + ") <= srcIdx + length(" + length + ") <= srcLen(" + src.length() + ')');
        }
        ((ByteBuf) ObjectUtil.checkNotNull(dst, "dst")).setBytes(dstIdx, src.array(), srcIdx + src.arrayOffset(), length);
    }

    public static void copy(AsciiString src, int srcIdx, ByteBuf dst, int length) {
        if (MathUtil.isOutOfBounds(srcIdx, length, src.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + srcIdx + ") <= srcIdx + length(" + length + ") <= srcLen(" + src.length() + ')');
        }
        ((ByteBuf) ObjectUtil.checkNotNull(dst, "dst")).writeBytes(src.array(), srcIdx + src.arrayOffset(), length);
    }

    public static String prettyHexDump(ByteBuf buffer) {
        return prettyHexDump(buffer, buffer.readerIndex(), buffer.readableBytes());
    }

    public static String prettyHexDump(ByteBuf buffer, int offset, int length) {
        return HexUtil.prettyHexDump(buffer, offset, length);
    }

    public static void appendPrettyHexDump(StringBuilder dump, ByteBuf buf) {
        appendPrettyHexDump(dump, buf, buf.readerIndex(), buf.readableBytes());
    }

    public static void appendPrettyHexDump(StringBuilder dump, ByteBuf buf, int offset, int length) {
        HexUtil.appendPrettyHexDump(dump, buf, offset, length);
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.buffer.ByteBufUtil$HexUtil */
    /* loaded from: grasscutter.jar:io/netty/buffer/ByteBufUtil$HexUtil.class */
    public static final class HexUtil {
        private static final char[] BYTE2CHAR = new char[256];
        private static final char[] HEXDUMP_TABLE = new char[1024];
        private static final String[] HEXPADDING = new String[16];
        private static final String[] HEXDUMP_ROWPREFIXES = new String[4096];
        private static final String[] BYTE2HEX = new String[256];
        private static final String[] BYTEPADDING = new String[16];

        private HexUtil() {
        }

        static {
            char[] DIGITS = "0123456789abcdef".toCharArray();
            for (int i = 0; i < 256; i++) {
                HEXDUMP_TABLE[i << 1] = DIGITS[(i >>> 4) & 15];
                HEXDUMP_TABLE[(i << 1) + 1] = DIGITS[i & 15];
            }
            for (int i2 = 0; i2 < HEXPADDING.length; i2++) {
                int padding = HEXPADDING.length - i2;
                StringBuilder buf = new StringBuilder(padding * 3);
                for (int j = 0; j < padding; j++) {
                    buf.append("   ");
                }
                HEXPADDING[i2] = buf.toString();
            }
            for (int i3 = 0; i3 < HEXDUMP_ROWPREFIXES.length; i3++) {
                StringBuilder buf2 = new StringBuilder(12);
                buf2.append(StringUtil.NEWLINE);
                buf2.append(Long.toHexString((((long) (i3 << 4)) & 4294967295L) | 4294967296L));
                buf2.setCharAt(buf2.length() - 9, '|');
                buf2.append('|');
                HEXDUMP_ROWPREFIXES[i3] = buf2.toString();
            }
            for (int i4 = 0; i4 < BYTE2HEX.length; i4++) {
                BYTE2HEX[i4] = ' ' + StringUtil.byteToHexStringPadded(i4);
            }
            for (int i5 = 0; i5 < BYTEPADDING.length; i5++) {
                int padding2 = BYTEPADDING.length - i5;
                StringBuilder buf3 = new StringBuilder(padding2);
                for (int j2 = 0; j2 < padding2; j2++) {
                    buf3.append(' ');
                }
                BYTEPADDING[i5] = buf3.toString();
            }
            for (int i6 = 0; i6 < BYTE2CHAR.length; i6++) {
                if (i6 <= 31 || i6 >= 127) {
                    BYTE2CHAR[i6] = '.';
                } else {
                    BYTE2CHAR[i6] = (char) i6;
                }
            }
        }

        /* access modifiers changed from: private */
        public static String hexDump(ByteBuf buffer, int fromIndex, int length) {
            ObjectUtil.checkPositiveOrZero(length, "length");
            if (length == 0) {
                return "";
            }
            int endIndex = fromIndex + length;
            char[] buf = new char[length << 1];
            int srcIdx = fromIndex;
            int dstIdx = 0;
            while (srcIdx < endIndex) {
                System.arraycopy(HEXDUMP_TABLE, buffer.getUnsignedByte(srcIdx) << 1, buf, dstIdx, 2);
                srcIdx++;
                dstIdx += 2;
            }
            return new String(buf);
        }

        /* access modifiers changed from: private */
        public static String hexDump(byte[] array, int fromIndex, int length) {
            ObjectUtil.checkPositiveOrZero(length, "length");
            if (length == 0) {
                return "";
            }
            int endIndex = fromIndex + length;
            char[] buf = new char[length << 1];
            int srcIdx = fromIndex;
            int dstIdx = 0;
            while (srcIdx < endIndex) {
                System.arraycopy(HEXDUMP_TABLE, (array[srcIdx] & 255) << 1, buf, dstIdx, 2);
                srcIdx++;
                dstIdx += 2;
            }
            return new String(buf);
        }

        /* access modifiers changed from: private */
        public static String prettyHexDump(ByteBuf buffer, int offset, int length) {
            if (length == 0) {
                return "";
            }
            StringBuilder buf = new StringBuilder(((length / 16) + ((length & 15) == 0 ? 0 : 1) + 4) * 80);
            appendPrettyHexDump(buf, buffer, offset, length);
            return buf.toString();
        }

        /* access modifiers changed from: private */
        public static void appendPrettyHexDump(StringBuilder dump, ByteBuf buf, int offset, int length) {
            if (MathUtil.isOutOfBounds(offset, length, buf.capacity())) {
                throw new IndexOutOfBoundsException("expected: 0 <= offset(" + offset + ") <= offset + length(" + length + ") <= buf.capacity(" + buf.capacity() + ')');
            } else if (length != 0) {
                dump.append("         +-------------------------------------------------+" + StringUtil.NEWLINE + "         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |" + StringUtil.NEWLINE + "+--------+-------------------------------------------------+----------------+");
                int fullRows = length >>> 4;
                int remainder = length & 15;
                for (int row = 0; row < fullRows; row++) {
                    int rowStartIndex = (row << 4) + offset;
                    appendHexDumpRowPrefix(dump, row, rowStartIndex);
                    int rowEndIndex = rowStartIndex + 16;
                    for (int j = rowStartIndex; j < rowEndIndex; j++) {
                        dump.append(BYTE2HEX[buf.getUnsignedByte(j)]);
                    }
                    dump.append(" |");
                    for (int j2 = rowStartIndex; j2 < rowEndIndex; j2++) {
                        dump.append(BYTE2CHAR[buf.getUnsignedByte(j2)]);
                    }
                    dump.append('|');
                }
                if (remainder != 0) {
                    int rowStartIndex2 = (fullRows << 4) + offset;
                    appendHexDumpRowPrefix(dump, fullRows, rowStartIndex2);
                    int rowEndIndex2 = rowStartIndex2 + remainder;
                    for (int j3 = rowStartIndex2; j3 < rowEndIndex2; j3++) {
                        dump.append(BYTE2HEX[buf.getUnsignedByte(j3)]);
                    }
                    dump.append(HEXPADDING[remainder]);
                    dump.append(" |");
                    for (int j4 = rowStartIndex2; j4 < rowEndIndex2; j4++) {
                        dump.append(BYTE2CHAR[buf.getUnsignedByte(j4)]);
                    }
                    dump.append(BYTEPADDING[remainder]);
                    dump.append('|');
                }
                dump.append(StringUtil.NEWLINE + "+--------+-------------------------------------------------+----------------+");
            }
        }

        private static void appendHexDumpRowPrefix(StringBuilder dump, int row, int rowStartIndex) {
            if (row < HEXDUMP_ROWPREFIXES.length) {
                dump.append(HEXDUMP_ROWPREFIXES[row]);
                return;
            }
            dump.append(StringUtil.NEWLINE);
            dump.append(Long.toHexString((((long) rowStartIndex) & 4294967295L) | 4294967296L));
            dump.setCharAt(dump.length() - 9, '|');
            dump.append('|');
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.ByteBufUtil$ThreadLocalUnsafeDirectByteBuf */
    /* loaded from: grasscutter.jar:io/netty/buffer/ByteBufUtil$ThreadLocalUnsafeDirectByteBuf.class */
    public static final class ThreadLocalUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        private static final ObjectPool<ThreadLocalUnsafeDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalUnsafeDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalUnsafeDirectByteBuf.1
            @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
            public ThreadLocalUnsafeDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
                return new ThreadLocalUnsafeDirectByteBuf(handle);
            }
        });
        private final ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle;

        static ThreadLocalUnsafeDirectByteBuf newInstance() {
            ThreadLocalUnsafeDirectByteBuf buf = RECYCLER.get();
            buf.resetRefCnt();
            return buf;
        }

        private ThreadLocalUnsafeDirectByteBuf(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle;
        }

        @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf
        protected void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                deallocate();
                return;
            }
            clear();
            this.handle.recycle(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.ByteBufUtil$ThreadLocalDirectByteBuf */
    /* loaded from: grasscutter.jar:io/netty/buffer/ByteBufUtil$ThreadLocalDirectByteBuf.class */
    public static final class ThreadLocalDirectByteBuf extends UnpooledDirectByteBuf {
        private static final ObjectPool<ThreadLocalDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalDirectByteBuf.1
            @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
            public ThreadLocalDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
                return new ThreadLocalDirectByteBuf(handle);
            }
        });
        private final ObjectPool.Handle<ThreadLocalDirectByteBuf> handle;

        static ThreadLocalDirectByteBuf newInstance() {
            ThreadLocalDirectByteBuf buf = RECYCLER.get();
            buf.resetRefCnt();
            return buf;
        }

        private ThreadLocalDirectByteBuf(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle;
        }

        @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf
        protected void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                deallocate();
                return;
            }
            clear();
            this.handle.recycle(this);
        }
    }

    public static boolean isText(ByteBuf buf, Charset charset) {
        return isText(buf, buf.readerIndex(), buf.readableBytes(), charset);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:25:0x00c1
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static boolean isText(p013io.netty.buffer.ByteBuf r5, int r6, int r7, java.nio.charset.Charset r8) {
        /*
        // Method dump skipped, instructions count: 210
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.buffer.ByteBufUtil.isText(io.netty.buffer.ByteBuf, int, int, java.nio.charset.Charset):boolean");
    }

    private static boolean isAscii(ByteBuf buf, int index, int length) {
        return buf.forEachByte(index, length, FIND_NON_ASCII) == -1;
    }

    private static boolean isUtf8(ByteBuf buf, int index, int length) {
        int endIndex = index + length;
        while (index < endIndex) {
            index++;
            byte b1 = buf.getByte(index);
            if ((b1 & 128) != 0) {
                if ((b1 & 224) == 192) {
                    if (index >= endIndex) {
                        return false;
                    }
                    index++;
                    if ((buf.getByte(index) & 192) != 128 || (b1 & 255) < 194) {
                        return false;
                    }
                } else if ((b1 & 240) == 224) {
                    if (index > endIndex - 2) {
                        return false;
                    }
                    int index2 = index + 1;
                    byte b2 = buf.getByte(index);
                    index = index2 + 1;
                    byte b3 = buf.getByte(index2);
                    if ((b2 & 192) != 128 || (b3 & 192) != 128) {
                        return false;
                    }
                    if ((b1 & 15) == 0 && (b2 & 255) < 160) {
                        return false;
                    }
                    if ((b1 & 15) == 13 && (b2 & 255) > 159) {
                        return false;
                    }
                } else if ((b1 & 248) != 240 || index > endIndex - 3) {
                    return false;
                } else {
                    int index3 = index + 1;
                    byte b22 = buf.getByte(index);
                    int index4 = index3 + 1;
                    byte b32 = buf.getByte(index3);
                    index = index4 + 1;
                    byte b4 = buf.getByte(index4);
                    if ((b22 & 192) != 128 || (b32 & 192) != 128 || (b4 & 192) != 128 || (b1 & 255) > 244) {
                        return false;
                    }
                    if ((b1 & 255) == 240 && (b22 & 255) < 144) {
                        return false;
                    }
                    if ((b1 & 255) == 244 && (b22 & 255) > 143) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public static void readBytes(ByteBufAllocator allocator, ByteBuffer buffer, int position, int length, OutputStream out) throws IOException {
        if (buffer.hasArray()) {
            out.write(buffer.array(), position + buffer.arrayOffset(), length);
            return;
        }
        int chunkLen = Math.min(length, 8192);
        buffer.clear().position(position);
        if (length <= 1024 || !allocator.isDirectBufferPooled()) {
            getBytes(buffer, threadLocalTempArray(chunkLen), 0, chunkLen, out, length);
            return;
        }
        ByteBuf tmpBuf = allocator.heapBuffer(chunkLen);
        try {
            getBytes(buffer, tmpBuf.array(), tmpBuf.arrayOffset(), chunkLen, out, length);
            tmpBuf.release();
        } catch (Throwable th) {
            tmpBuf.release();
            throw th;
        }
    }

    private static void getBytes(ByteBuffer inBuffer, byte[] in, int inOffset, int inLen, OutputStream out, int outLen) throws IOException {
        do {
            int len = Math.min(inLen, outLen);
            inBuffer.get(in, inOffset, len);
            out.write(in, inOffset, len);
            outLen -= len;
        } while (outLen > 0);
    }

    private ByteBufUtil() {
    }
}
