package org.eclipse.jetty.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import kotlin.time.DurationKt;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.Http2Connection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.resource.Resource;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/BufferUtil.class */
public class BufferUtil {
    static final int TEMP_BUFFER_SIZE = 4096;
    static final byte SPACE = 32;
    static final byte MINUS = 45;
    static final byte[] DIGIT = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    public static final ByteBuffer EMPTY_BUFFER = ByteBuffer.wrap(new byte[0]);
    private static final int[] decDivisors = {Http2Connection.DEGRADED_PONG_TIMEOUT_NS, 100000000, 10000000, DurationKt.NANOS_IN_MILLIS, 100000, 10000, 1000, 100, 10, 1};
    private static final int[] hexDivisors = {268435456, 16777216, 1048576, 65536, 4096, 256, 16, 1};
    private static final long[] decDivisorsL = {1000000000000000000L, 100000000000000000L, 10000000000000000L, 1000000000000000L, 100000000000000L, 10000000000000L, 1000000000000L, 100000000000L, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 1000000000, 100000000, 10000000, 1000000, 100000, AbstractComponentTracker.LINGERING_TIMEOUT, 1000, 100, 10, 1};

    public static ByteBuffer allocate(int capacity) {
        ByteBuffer buf = ByteBuffer.allocate(capacity);
        buf.limit(0);
        return buf;
    }

    public static ByteBuffer allocateDirect(int capacity) {
        ByteBuffer buf = ByteBuffer.allocateDirect(capacity);
        buf.limit(0);
        return buf;
    }

    public static ByteBuffer copy(ByteBuffer buffer) {
        if (buffer == null) {
            return null;
        }
        int p = buffer.position();
        ByteBuffer clone = buffer.isDirect() ? ByteBuffer.allocateDirect(buffer.remaining()) : ByteBuffer.allocate(buffer.remaining());
        clone.put(buffer);
        clone.flip();
        buffer.position(p);
        return clone;
    }

    public static void reset(ByteBuffer buffer) {
        if (buffer != null) {
            buffer.order(ByteOrder.BIG_ENDIAN);
            buffer.position(0);
            buffer.limit(0);
        }
    }

    public static void clear(ByteBuffer buffer) {
        if (buffer != null) {
            buffer.position(0);
            buffer.limit(0);
        }
    }

    public static void clearToFill(ByteBuffer buffer) {
        if (buffer != null) {
            buffer.position(0);
            buffer.limit(buffer.capacity());
        }
    }

    public static int flipToFill(ByteBuffer buffer) {
        int position = buffer.position();
        int limit = buffer.limit();
        if (position == limit) {
            buffer.position(0);
            buffer.limit(buffer.capacity());
            return 0;
        }
        int capacity = buffer.capacity();
        if (limit == capacity) {
            buffer.compact();
            return 0;
        }
        buffer.position(limit);
        buffer.limit(capacity);
        return position;
    }

    public static void flipToFlush(ByteBuffer buffer, int position) {
        buffer.limit(buffer.position());
        buffer.position(position);
    }

    public static void putIntLittleEndian(ByteBuffer buffer, int value) {
        int p = flipToFill(buffer);
        buffer.put((byte) (value & 255));
        buffer.put((byte) ((value >>> 8) & 255));
        buffer.put((byte) ((value >>> 16) & 255));
        buffer.put((byte) ((value >>> 24) & 255));
        flipToFlush(buffer, p);
    }

    public static byte[] toArray(ByteBuffer buffer) {
        if (buffer.hasArray()) {
            byte[] array = buffer.array();
            int from = buffer.arrayOffset() + buffer.position();
            return Arrays.copyOfRange(array, from, from + buffer.remaining());
        }
        byte[] to = new byte[buffer.remaining()];
        buffer.slice().get(to);
        return to;
    }

    public static boolean isTheEmptyBuffer(ByteBuffer buf) {
        return buf == EMPTY_BUFFER;
    }

    public static boolean isEmpty(ByteBuffer buf) {
        return buf == null || buf.remaining() == 0;
    }

    public static boolean isEmpty(ByteBuffer[] buf) {
        if (buf == null || buf.length == 0) {
            return true;
        }
        for (ByteBuffer b : buf) {
            if (b != null && b.hasRemaining()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    public static long remaining(ByteBuffer... buf) {
        char c = 0;
        if (buf != null) {
            for (ByteBuffer b : buf) {
                if (b != null) {
                    c += (long) b.remaining();
                }
            }
        }
        return c;
    }

    public static boolean hasContent(ByteBuffer buf) {
        return buf != null && buf.remaining() > 0;
    }

    public static boolean isFull(ByteBuffer buf) {
        return buf != null && buf.limit() == buf.capacity();
    }

    public static int length(ByteBuffer buffer) {
        if (buffer == null) {
            return 0;
        }
        return buffer.remaining();
    }

    public static int space(ByteBuffer buffer) {
        if (buffer == null) {
            return 0;
        }
        return buffer.capacity() - buffer.limit();
    }

    public static boolean compact(ByteBuffer buffer) {
        if (buffer.position() == 0) {
            return false;
        }
        boolean full = buffer.limit() == buffer.capacity();
        buffer.compact().flip();
        return full && buffer.limit() < buffer.capacity();
    }

    public static int put(ByteBuffer from, ByteBuffer to) {
        int put;
        int remaining = from.remaining();
        if (remaining <= 0) {
            put = 0;
        } else if (remaining <= to.remaining()) {
            to.put(from);
            put = remaining;
            from.position(from.limit());
        } else if (from.hasArray()) {
            put = to.remaining();
            to.put(from.array(), from.arrayOffset() + from.position(), put);
            from.position(from.position() + put);
        } else {
            put = to.remaining();
            ByteBuffer slice = from.slice();
            slice.limit(put);
            to.put(slice);
            from.position(from.position() + put);
        }
        return put;
    }

    public static int flipPutFlip(ByteBuffer from, ByteBuffer to) {
        return append(to, from);
    }

    public static void append(ByteBuffer to, byte[] b, int off, int len) throws BufferOverflowException {
        int pos = flipToFill(to);
        try {
            to.put(b, off, len);
            flipToFlush(to, pos);
        } catch (Throwable th) {
            flipToFlush(to, pos);
            throw th;
        }
    }

    public static void append(ByteBuffer to, byte b) {
        int pos = flipToFill(to);
        try {
            to.put(b);
        } finally {
            flipToFlush(to, pos);
        }
    }

    public static int append(ByteBuffer to, ByteBuffer b) {
        int pos = flipToFill(to);
        try {
            int put = put(b, to);
            flipToFlush(to, pos);
            return put;
        } catch (Throwable th) {
            flipToFlush(to, pos);
            throw th;
        }
    }

    public static int fill(ByteBuffer to, byte[] b, int off, int len) {
        int pos = flipToFill(to);
        try {
            int remaining = to.remaining();
            int take = remaining < len ? remaining : len;
            to.put(b, off, take);
            flipToFlush(to, pos);
            return take;
        } catch (Throwable th) {
            flipToFlush(to, pos);
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    public static void readFrom(File file, ByteBuffer buffer) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        try {
            FileChannel channel = raf.getChannel();
            char length = raf.length();
            while (length > 0) {
                if (!buffer.hasRemaining()) {
                    break;
                }
                length -= (long) channel.read(buffer);
            }
            raf.close();
        } catch (Throwable th) {
            try {
                raf.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void readFrom(InputStream is, int needed, ByteBuffer buffer) throws IOException {
        int l;
        ByteBuffer tmp = allocate(8192);
        while (needed > 0 && buffer.hasRemaining() && (l = is.read(tmp.array(), 0, 8192)) >= 0) {
            tmp.position(0);
            tmp.limit(l);
            buffer.put(tmp);
        }
    }

    public static void writeTo(ByteBuffer buffer, OutputStream out) throws IOException {
        if (buffer.hasArray()) {
            out.write(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
            buffer.position(buffer.position() + buffer.remaining());
            return;
        }
        byte[] bytes = new byte[Math.min(buffer.remaining(), 4096)];
        while (buffer.hasRemaining()) {
            int byteCountToWrite = Math.min(buffer.remaining(), 4096);
            buffer.get(bytes, 0, byteCountToWrite);
            out.write(bytes, 0, byteCountToWrite);
        }
    }

    public static String toString(ByteBuffer buffer) {
        return toString(buffer, StandardCharsets.ISO_8859_1);
    }

    public static String toUTF8String(ByteBuffer buffer) {
        return toString(buffer, StandardCharsets.UTF_8);
    }

    public static String toString(ByteBuffer buffer, Charset charset) {
        if (buffer == null) {
            return null;
        }
        byte[] array = buffer.hasArray() ? buffer.array() : null;
        if (array != null) {
            return new String(array, buffer.arrayOffset() + buffer.position(), buffer.remaining(), charset);
        }
        byte[] to = new byte[buffer.remaining()];
        buffer.slice().get(to);
        return new String(to, 0, to.length, charset);
    }

    public static String toString(ByteBuffer buffer, int position, int length, Charset charset) {
        if (buffer == null) {
            return null;
        }
        byte[] array = buffer.hasArray() ? buffer.array() : null;
        if (array != null) {
            return new String(array, buffer.arrayOffset() + position, length, charset);
        }
        ByteBuffer ro = buffer.asReadOnlyBuffer();
        ro.position(position);
        ro.limit(position + length);
        byte[] to = new byte[length];
        ro.get(to);
        return new String(to, 0, to.length, charset);
    }

    public static int toInt(ByteBuffer buffer) {
        return toInt(buffer, buffer.position(), buffer.remaining());
    }

    public static int toInt(ByteBuffer buffer, int position, int length) {
        int val = 0;
        boolean started = false;
        boolean minus = false;
        int limit = position + length;
        if (length <= 0) {
            throw new NumberFormatException(toString(buffer, position, length, StandardCharsets.UTF_8));
        }
        for (int i = position; i < limit; i++) {
            byte b = buffer.get(i);
            if (b > 32) {
                if (b < 48 || b > 57) {
                    if (b != 45 || started) {
                        break;
                    }
                    minus = true;
                } else {
                    val = (val * 10) + (b - 48);
                    started = true;
                }
            } else if (started) {
                break;
            }
        }
        if (started) {
            return minus ? -val : val;
        }
        throw new NumberFormatException(toString(buffer));
    }

    public static int takeInt(ByteBuffer buffer) {
        int val = 0;
        boolean started = false;
        boolean minus = false;
        int i = buffer.position();
        while (i < buffer.limit()) {
            byte b = buffer.get(i);
            if (b > 32) {
                if (b < 48 || b > 57) {
                    if (b != 45 || started) {
                        break;
                    }
                    minus = true;
                } else {
                    val = (val * 10) + (b - 48);
                    started = true;
                }
                i++;
            } else if (started) {
                break;
            } else {
                i++;
            }
        }
        if (started) {
            buffer.position(i);
            return minus ? -val : val;
        }
        throw new NumberFormatException(toString(buffer));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x005a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5 */
    public static long toLong(ByteBuffer buffer) {
        long val = 0;
        boolean started = false;
        boolean minus = false;
        int i = buffer.position();
        while (i < buffer.limit()) {
            byte b = buffer.get(i);
            if (b > 32) {
                if (b < 48 || b > 57) {
                    if (b != 45 || started) {
                        break;
                    }
                    minus = true;
                } else {
                    val = ((val == true ? 1 : 0) * 10) + ((long) (b - 48));
                    started = true;
                }
                i++;
                val = val;
                started = started;
                minus = minus;
            } else if (started) {
                break;
            } else {
                i++;
                val = val;
                started = started;
                minus = minus;
            }
        }
        if (started) {
            return minus ? -val : val;
        }
        throw new NumberFormatException(toString(buffer));
    }

    public static void putHexInt(ByteBuffer buffer, int n) {
        if (n < 0) {
            buffer.put((byte) 45);
            if (n == Integer.MIN_VALUE) {
                buffer.put((byte) 56);
                buffer.put((byte) 48);
                buffer.put((byte) 48);
                buffer.put((byte) 48);
                buffer.put((byte) 48);
                buffer.put((byte) 48);
                buffer.put((byte) 48);
                buffer.put((byte) 48);
                return;
            }
            n = -n;
        }
        if (n < 16) {
            buffer.put(DIGIT[n]);
            return;
        }
        boolean started = false;
        int[] iArr = hexDivisors;
        for (int hexDivisor : iArr) {
            if (n >= hexDivisor) {
                started = true;
                int d = n / hexDivisor;
                buffer.put(DIGIT[d]);
                n -= d * hexDivisor;
            } else if (started) {
                buffer.put((byte) 48);
            }
        }
    }

    public static void putDecInt(ByteBuffer buffer, int n) {
        if (n < 0) {
            buffer.put((byte) 45);
            if (n == Integer.MIN_VALUE) {
                buffer.put((byte) 50);
                n = 147483648;
            } else {
                n = -n;
            }
        }
        if (n < 10) {
            buffer.put(DIGIT[n]);
            return;
        }
        boolean started = false;
        int[] iArr = decDivisors;
        for (int decDivisor : iArr) {
            if (n >= decDivisor) {
                started = true;
                int d = n / decDivisor;
                buffer.put(DIGIT[d]);
                n -= d * decDivisor;
            } else if (started) {
                buffer.put((byte) 48);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x008a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    /* JADX WARN: Type inference failed for: r0v31, types: [long] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void putDecLong(java.nio.ByteBuffer r7, long r8) {
        /*
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0026
            r0 = r7
            r1 = 45
            java.nio.ByteBuffer r0 = r0.put(r1)
            r0 = r8
            r1 = -9223372036854775808
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0023
            r0 = r7
            r1 = 57
            java.nio.ByteBuffer r0 = r0.put(r1)
            r0 = 223372036854775808(0x31993af1d7c0000, double:1.0011795953072083E-293)
            r8 = r0
            goto L_0x0026
        L_0x0023:
            r0 = r8
            long r0 = -r0
            r8 = r0
        L_0x0026:
            r0 = r8
            r1 = 10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x003c
            r0 = r7
            byte[] r1 = org.eclipse.jetty.util.BufferUtil.DIGIT
            r2 = r8
            int r2 = (int) r2
            r1 = r1[r2]
            java.nio.ByteBuffer r0 = r0.put(r1)
            goto L_0x0090
        L_0x003c:
            r0 = 0
            r10 = r0
            long[] r0 = org.eclipse.jetty.util.BufferUtil.decDivisorsL
            r11 = r0
            r0 = r11
            int r0 = r0.length
            r12 = r0
            r0 = 0
            r13 = r0
        L_0x004b:
            r0 = r13
            r1 = r12
            if (r0 >= r1) goto L_0x0090
            r0 = r11
            r1 = r13
            r0 = r0[r1]
            r14 = r0
            r0 = r8
            r1 = r14
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x006e
            r0 = r10
            if (r0 == 0) goto L_0x008a
            r0 = r7
            r1 = 48
            java.nio.ByteBuffer r0 = r0.put(r1)
            goto L_0x008a
        L_0x006e:
            r0 = 1
            r10 = r0
            r0 = r8
            r1 = r14
            long r0 = r0 / r1
            r16 = r0
            r0 = r7
            byte[] r1 = org.eclipse.jetty.util.BufferUtil.DIGIT
            r2 = r16
            int r2 = (int) r2
            r1 = r1[r2]
            java.nio.ByteBuffer r0 = r0.put(r1)
            r0 = r8
            r1 = r16
            r2 = r14
            long r1 = r1 * r2
            long r0 = r0 - r1
            r8 = r0
        L_0x008a:
            int r13 = r13 + 1
            goto L_0x004b
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.BufferUtil.putDecLong(java.nio.ByteBuffer, long):void");
    }

    public static ByteBuffer toBuffer(int value) {
        ByteBuffer buf = ByteBuffer.allocate(32);
        putDecInt(buf, value);
        return buf;
    }

    public static ByteBuffer toBuffer(long value) {
        ByteBuffer buf = ByteBuffer.allocate(32);
        putDecLong(buf, value);
        return buf;
    }

    public static ByteBuffer toBuffer(String s) {
        return toBuffer(s, StandardCharsets.ISO_8859_1);
    }

    public static ByteBuffer toBuffer(String s, Charset charset) {
        if (s == null) {
            return EMPTY_BUFFER;
        }
        return toBuffer(s.getBytes(charset));
    }

    public static ByteBuffer toBuffer(byte[] array) {
        if (array == null) {
            return EMPTY_BUFFER;
        }
        return toBuffer(array, 0, array.length);
    }

    public static ByteBuffer toBuffer(byte[] array, int offset, int length) {
        if (array == null) {
            return EMPTY_BUFFER;
        }
        return ByteBuffer.wrap(array, offset, length);
    }

    public static ByteBuffer toDirectBuffer(String s) {
        return toDirectBuffer(s, StandardCharsets.ISO_8859_1);
    }

    public static ByteBuffer toDirectBuffer(String s, Charset charset) {
        if (s == null) {
            return EMPTY_BUFFER;
        }
        byte[] bytes = s.getBytes(charset);
        ByteBuffer buf = ByteBuffer.allocateDirect(bytes.length);
        buf.put(bytes);
        buf.flip();
        return buf;
    }

    public static ByteBuffer toMappedBuffer(File file) throws IOException {
        return toMappedBuffer(file.toPath(), 0, file.length());
    }

    public static ByteBuffer toMappedBuffer(Path filePath, long pos, long len) throws IOException {
        FileChannel channel = FileChannel.open(filePath, StandardOpenOption.READ);
        try {
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, pos, len);
            if (channel != null) {
                channel.close();
            }
            return map;
        } catch (Throwable th) {
            if (channel != null) {
                try {
                    channel.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Deprecated
    public static boolean isMappedBuffer(ByteBuffer buffer) {
        return false;
    }

    public static ByteBuffer toBuffer(Resource resource, boolean direct) throws IOException {
        long len = resource.length();
        if (len < 0) {
            throw new IllegalArgumentException("invalid resource: " + resource + " len=" + len);
        } else if (len > 2147483647L) {
            return null;
        } else {
            int ilen = (int) len;
            ByteBuffer buffer = direct ? allocateDirect(ilen) : allocate(ilen);
            int pos = flipToFill(buffer);
            if (resource.getFile() != null) {
                readFrom(resource.getFile(), buffer);
            } else {
                InputStream is = resource.getInputStream();
                try {
                    readFrom(is, ilen, buffer);
                    if (is != null) {
                        is.close();
                    }
                } catch (Throwable th) {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            flipToFlush(buffer, pos);
            return buffer;
        }
    }

    public static String toSummaryString(ByteBuffer buffer) {
        if (buffer == null) {
            return "null";
        }
        return "[p=" + buffer.position() + ",l=" + buffer.limit() + ",c=" + buffer.capacity() + ",r=" + buffer.remaining() + "]";
    }

    public static String toDetailString(ByteBuffer[] buffer) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < buffer.length; i++) {
            if (i > 0) {
                builder.append(',');
            }
            builder.append(toDetailString(buffer[i]));
        }
        builder.append(']');
        return builder.toString();
    }

    private static void idString(ByteBuffer buffer, StringBuilder out) {
        out.append(buffer.getClass().getSimpleName());
        out.append("@");
        if (!buffer.hasArray() || buffer.arrayOffset() != 4) {
            out.append(Integer.toHexString(System.identityHashCode(buffer)));
            return;
        }
        out.append('T');
        byte[] array = buffer.array();
        TypeUtil.toHex(array[0], (Appendable) out);
        TypeUtil.toHex(array[1], (Appendable) out);
        TypeUtil.toHex(array[2], (Appendable) out);
        TypeUtil.toHex(array[3], (Appendable) out);
    }

    public static String toIDString(ByteBuffer buffer) {
        StringBuilder buf = new StringBuilder();
        idString(buffer, buf);
        return buf.toString();
    }

    public static String toDetailString(ByteBuffer buffer) {
        if (buffer == null) {
            return "null";
        }
        StringBuilder buf = new StringBuilder();
        idString(buffer, buf);
        buf.append("[p=");
        buf.append(buffer.position());
        buf.append(",l=");
        buf.append(buffer.limit());
        buf.append(",c=");
        buf.append(buffer.capacity());
        buf.append(",r=");
        buf.append(buffer.remaining());
        buf.append("]={");
        appendDebugString(buf, buffer);
        buf.append("}");
        return buf.toString();
    }

    private static void appendDebugString(StringBuilder buf, ByteBuffer buffer) {
        ByteBuffer buffer2 = buffer.asReadOnlyBuffer();
        int i = 0;
        while (i < buffer2.position()) {
            try {
                appendContentChar(buf, buffer2.get(i));
                if (i == 8 && buffer2.position() > 16) {
                    buf.append("...");
                    i = buffer2.position() - 8;
                }
                i++;
            } catch (Throwable x) {
                Log.getRootLogger().ignore(x);
                buf.append("!!concurrent mod!!");
                return;
            }
        }
        buf.append("<<<");
        int i2 = buffer2.position();
        while (i2 < buffer2.limit()) {
            appendContentChar(buf, buffer2.get(i2));
            if (i2 == buffer2.position() + 24 && buffer2.limit() > buffer2.position() + 48) {
                buf.append("...");
                i2 = buffer2.limit() - 24;
            }
            i2++;
        }
        buf.append(">>>");
        int limit = buffer2.limit();
        buffer2.limit(buffer2.capacity());
        int i3 = limit;
        while (i3 < buffer2.capacity()) {
            appendContentChar(buf, buffer2.get(i3));
            if (i3 == limit + 8 && buffer2.capacity() > limit + 16) {
                buf.append("...");
                i3 = buffer2.capacity() - 8;
            }
            i3++;
        }
        buffer2.limit(limit);
    }

    private static void appendContentChar(StringBuilder buf, byte b) {
        if (b == 92) {
            buf.append("\\\\");
        } else if (b >= 32 && b <= 126) {
            buf.append((char) b);
        } else if (b == 13) {
            buf.append("\\r");
        } else if (b == 10) {
            buf.append("\\n");
        } else if (b == 9) {
            buf.append("\\t");
        } else {
            buf.append("\\x").append(TypeUtil.toHexString(b));
        }
    }

    public static String toHexSummary(ByteBuffer buffer) {
        if (buffer == null) {
            return "null";
        }
        StringBuilder buf = new StringBuilder();
        buf.append("b[").append(buffer.remaining()).append("]=");
        int i = buffer.position();
        while (i < buffer.limit()) {
            TypeUtil.toHex(buffer.get(i), (Appendable) buf);
            if (i == buffer.position() + 24 && buffer.limit() > buffer.position() + 32) {
                buf.append("...");
                i = buffer.limit() - 8;
            }
            i++;
        }
        return buf.toString();
    }

    public static String toHexString(ByteBuffer buffer) {
        if (buffer == null) {
            return "null";
        }
        return TypeUtil.toHexString(toArray(buffer));
    }

    public static void putCRLF(ByteBuffer buffer) {
        buffer.put((byte) 13);
        buffer.put((byte) 10);
    }

    public static boolean isPrefix(ByteBuffer prefix, ByteBuffer buffer) {
        if (prefix.remaining() > buffer.remaining()) {
            return false;
        }
        int bi = buffer.position();
        for (int i = prefix.position(); i < prefix.limit(); i++) {
            bi++;
            if (prefix.get(i) != buffer.get(bi)) {
                return false;
            }
        }
        return true;
    }

    public static ByteBuffer ensureCapacity(ByteBuffer buffer, int capacity) {
        if (buffer == null) {
            return allocate(capacity);
        }
        if (buffer.capacity() >= capacity) {
            return buffer;
        }
        if (buffer.hasArray()) {
            return ByteBuffer.wrap(Arrays.copyOfRange(buffer.array(), buffer.arrayOffset(), buffer.arrayOffset() + capacity), buffer.position(), buffer.remaining());
        }
        throw new UnsupportedOperationException();
    }
}
