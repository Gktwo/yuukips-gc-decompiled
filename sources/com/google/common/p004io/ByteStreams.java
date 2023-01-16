package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

@GwtIncompatible
/* renamed from: com.google.common.io.ByteStreams */
/* loaded from: grasscutter.jar:com/google/common/io/ByteStreams.class */
public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() { // from class: com.google.common.io.ByteStreams.1
        @Override // java.io.OutputStream
        public void write(int b) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] b) {
            Preconditions.checkNotNull(b);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b, int off, int len) {
            Preconditions.checkNotNull(b);
        }

        @Override // java.lang.Object
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }
    };

    /* access modifiers changed from: package-private */
    public static byte[] createBuffer() {
        return new byte[8192];
    }

    private ByteStreams() {
    }

    @CanIgnoreReturnValue
    public static long copy(InputStream from, OutputStream to) throws IOException {
        Preconditions.checkNotNull(from);
        Preconditions.checkNotNull(to);
        byte[] buf = createBuffer();
        long total = 0;
        while (true) {
            int r = from.read(buf);
            if (r == -1) {
                return total;
            }
            to.write(buf, 0, r);
            total += (long) r;
        }
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r0v28, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long copy(java.nio.channels.ReadableByteChannel r7, java.nio.channels.WritableByteChannel r8) throws java.io.IOException {
        /*
            r0 = r7
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r8
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r7
            boolean r0 = r0 instanceof java.nio.channels.FileChannel
            if (r0 == 0) goto L_0x004e
            r0 = r7
            java.nio.channels.FileChannel r0 = (java.nio.channels.FileChannel) r0
            r9 = r0
            r0 = r9
            long r0 = r0.position()
            r10 = r0
            r0 = r10
            r12 = r0
        L_0x001e:
            r0 = r9
            r1 = r12
            r2 = 524288(0x80000, double:2.590327E-318)
            r3 = r8
            long r0 = r0.transferTo(r1, r2, r3)
            r14 = r0
            r0 = r12
            r1 = r14
            long r0 = r0 + r1
            r12 = r0
            r0 = r9
            r1 = r12
            java.nio.channels.FileChannel r0 = r0.position(r1)
            r0 = r14
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x001e
            r0 = r12
            r1 = r9
            long r1 = r1.size()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x001e
            r0 = r12
            r1 = r10
            long r0 = r0 - r1
            return r0
        L_0x004e:
            byte[] r0 = createBuffer()
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)
            r9 = r0
            r0 = 0
            r10 = r0
        L_0x0057:
            r0 = r7
            r1 = r9
            int r0 = r0.read(r1)
            r1 = -1
            if (r0 == r1) goto L_0x0084
            r0 = r9
            java.nio.Buffer r0 = r0.flip()
        L_0x0067:
            r0 = r9
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x007c
            r0 = r10
            r1 = r8
            r2 = r9
            int r1 = r1.write(r2)
            long r1 = (long) r1
            long r0 = r0 + r1
            r10 = r0
            goto L_0x0067
        L_0x007c:
            r0 = r9
            java.nio.Buffer r0 = r0.clear()
            goto L_0x0057
        L_0x0084:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.p004io.ByteStreams.copy(java.nio.channels.ReadableByteChannel, java.nio.channels.WritableByteChannel):long");
    }

    private static byte[] toByteArrayInternal(InputStream in, Deque<byte[]> bufs, int totalLen) throws IOException {
        int bufSize = 8192;
        while (totalLen < 2147483639) {
            byte[] buf = new byte[Math.min(bufSize, 2147483639 - totalLen)];
            bufs.add(buf);
            int off = 0;
            while (off < buf.length) {
                int r = in.read(buf, off, buf.length - off);
                if (r == -1) {
                    return combineBuffers(bufs, totalLen);
                }
                off += r;
                totalLen += r;
            }
            bufSize = IntMath.saturatedMultiply(bufSize, 2);
        }
        if (in.read() == -1) {
            return combineBuffers(bufs, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] combineBuffers(Deque<byte[]> bufs, int totalLen) {
        byte[] result = new byte[totalLen];
        int remaining = totalLen;
        while (remaining > 0) {
            byte[] buf = bufs.removeFirst();
            int bytesToCopy = Math.min(remaining, buf.length);
            System.arraycopy(buf, 0, result, totalLen - remaining, bytesToCopy);
            remaining -= bytesToCopy;
        }
        return result;
    }

    public static byte[] toByteArray(InputStream in) throws IOException {
        Preconditions.checkNotNull(in);
        return toByteArrayInternal(in, new ArrayDeque(20), 0);
    }

    /* access modifiers changed from: package-private */
    public static byte[] toByteArray(InputStream in, long expectedSize) throws IOException {
        Preconditions.checkArgument(expectedSize >= 0, "expectedSize (%s) must be non-negative", expectedSize);
        if (expectedSize > 2147483639) {
            throw new OutOfMemoryError(expectedSize + " bytes is too large to fit in a byte array");
        }
        byte[] bytes = new byte[(int) expectedSize];
        int remaining = (int) expectedSize;
        while (remaining > 0) {
            int off = ((int) expectedSize) - remaining;
            int read = in.read(bytes, off, remaining);
            if (read == -1) {
                return Arrays.copyOf(bytes, off);
            }
            remaining -= read;
        }
        int b = in.read();
        if (b == -1) {
            return bytes;
        }
        Deque<byte[]> bufs = new ArrayDeque<>(22);
        bufs.add(bytes);
        bufs.add(new byte[]{(byte) b});
        return toByteArrayInternal(in, bufs, bytes.length + 1);
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(InputStream in) throws IOException {
        char c = 0;
        byte[] buf = createBuffer();
        while (true) {
            long read = (long) in.read(buf);
            if (read == -1) {
                return c;
            }
            c += read;
        }
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bytes) {
        return newDataInput(new ByteArrayInputStream(bytes));
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bytes, int start) {
        Preconditions.checkPositionIndex(start, bytes.length);
        return newDataInput(new ByteArrayInputStream(bytes, start, bytes.length - start));
    }

    @Beta
    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(byteArrayInputStream));
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.common.io.ByteStreams$ByteArrayDataInputStream */
    /* loaded from: grasscutter.jar:com/google/common/io/ByteStreams$ByteArrayDataInputStream.class */
    public static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput input;

        ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.input = new DataInputStream(byteArrayInputStream);
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] b) {
            try {
                this.input.readFully(b);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] b, int off, int len) {
            try {
                this.input.readFully(b, off, len);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public int skipBytes(int n) {
            try {
                return this.input.skipBytes(n);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public byte readByte() {
            try {
                return this.input.readByte();
            } catch (EOFException e) {
                throw new IllegalStateException(e);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public short readShort() {
            try {
                return this.input.readShort();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public char readChar() {
            try {
                return this.input.readChar();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public int readInt() {
            try {
                return this.input.readInt();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public long readLong() {
            try {
                return this.input.readLong();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public float readFloat() {
            try {
                return this.input.readFloat();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public double readDouble() {
            try {
                return this.input.readDouble();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public String readLine() {
            try {
                return this.input.readLine();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataInput, java.io.DataInput
        public String readUTF() {
            try {
                return this.input.readUTF();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(int size) {
        if (size >= 0) {
            return newDataOutput(new ByteArrayOutputStream(size));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", Integer.valueOf(size)));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputSteam) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(byteArrayOutputSteam));
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.common.io.ByteStreams$ByteArrayDataOutputStream */
    /* loaded from: grasscutter.jar:com/google/common/io/ByteStreams$ByteArrayDataOutputStream.class */
    public static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final DataOutput output;
        final ByteArrayOutputStream byteArrayOutputSteam;

        ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputSteam) {
            this.byteArrayOutputSteam = byteArrayOutputSteam;
            this.output = new DataOutputStream(byteArrayOutputSteam);
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void write(int b) {
            try {
                this.output.write(b);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] b) {
            try {
                this.output.write(b);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] b, int off, int len) {
            try {
                this.output.write(b, off, len);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBoolean(boolean v) {
            try {
                this.output.writeBoolean(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeByte(int v) {
            try {
                this.output.writeByte(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBytes(String s) {
            try {
                this.output.writeBytes(s);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChar(int v) {
            try {
                this.output.writeChar(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChars(String s) {
            try {
                this.output.writeChars(s);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeDouble(double v) {
            try {
                this.output.writeDouble(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeFloat(float v) {
            try {
                this.output.writeFloat(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeInt(int v) {
            try {
                this.output.writeInt(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeLong(long v) {
            try {
                this.output.writeLong(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeShort(int v) {
            try {
                this.output.writeShort(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput, java.io.DataOutput
        public void writeUTF(String s) {
            try {
                this.output.writeUTF(s);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Override // com.google.common.p004io.ByteArrayDataOutput
        public byte[] toByteArray() {
            return this.byteArrayOutputSteam.toByteArray();
        }
    }

    @Beta
    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    @Beta
    public static InputStream limit(InputStream in, long limit) {
        return new LimitedInputStream(in, limit);
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.common.io.ByteStreams$LimitedInputStream */
    /* loaded from: grasscutter.jar:com/google/common/io/ByteStreams$LimitedInputStream.class */
    public static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark = -1;

        LimitedInputStream(InputStream in, long limit) {
            super(in);
            Preconditions.checkNotNull(in);
            Preconditions.checkArgument(limit >= 0, "limit must be non-negative");
            this.left = limit;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min((long) this.in.available(), this.left);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int readLimit) {
            this.in.mark(readLimit);
            this.mark = this.left;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.left == 0) {
                return -1;
            }
            int result = this.in.read();
            if (result != -1) {
                this.left--;
            }
            return result;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] b, int off, int len) throws IOException {
            if (this.left == 0) {
                return -1;
            }
            int result = this.in.read(b, off, (int) Math.min((long) len, this.left));
            if (result != -1) {
                this.left -= (long) result;
            }
            return result;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.mark == -1) {
                throw new IOException("Mark not set");
            } else {
                this.in.reset();
                this.left = this.mark;
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long n) throws IOException {
            long skipped = this.in.skip(Math.min(n, this.left));
            this.left -= skipped;
            return skipped;
        }
    }

    @Beta
    public static void readFully(InputStream in, byte[] b) throws IOException {
        readFully(in, b, 0, b.length);
    }

    @Beta
    public static void readFully(InputStream in, byte[] b, int off, int len) throws IOException {
        int read = read(in, b, off, len);
        if (read != len) {
            throw new EOFException("reached end of stream after reading " + read + " bytes; " + len + " bytes expected");
        }
    }

    @Beta
    public static void skipFully(InputStream in, long n) throws IOException {
        long skipped = skipUpTo(in, n);
        if (skipped < n) {
            throw new EOFException("reached end of stream after skipping " + skipped + " bytes; " + n + " bytes expected");
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r0v18, types: [long] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long skipUpTo(java.io.InputStream r5, long r6) throws java.io.IOException {
        /*
            r0 = 0
            r8 = r0
            byte[] r0 = createBuffer()
            r10 = r0
        L_0x0007:
            r0 = r8
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x004c
            r0 = r6
            r1 = r8
            long r0 = r0 - r1
            r11 = r0
            r0 = r5
            r1 = r11
            long r0 = skipSafely(r0, r1)
            r13 = r0
            r0 = r13
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0044
            r0 = r11
            r1 = r10
            int r1 = r1.length
            long r1 = (long) r1
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r15 = r0
            r0 = r5
            r1 = r10
            r2 = 0
            r3 = r15
            int r0 = r0.read(r1, r2, r3)
            long r0 = (long) r0
            r1 = r0; r2 = r3; 
            r13 = r1
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0044
            goto L_0x004c
        L_0x0044:
            r0 = r8
            r1 = r13
            long r0 = r0 + r1
            r8 = r0
            goto L_0x0007
        L_0x004c:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.p004io.ByteStreams.skipUpTo(java.io.InputStream, long):long");
    }

    private static long skipSafely(InputStream in, long n) throws IOException {
        int available = in.available();
        if (available == 0) {
            return 0;
        }
        return in.skip(Math.min((long) available, n));
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readBytes(InputStream input, ByteProcessor<T> processor) throws IOException {
        int read;
        Preconditions.checkNotNull(input);
        Preconditions.checkNotNull(processor);
        byte[] buf = createBuffer();
        do {
            read = input.read(buf);
            if (read == -1) {
                break;
            }
        } while (processor.processBytes(buf, 0, read));
        return processor.getResult();
    }

    @CanIgnoreReturnValue
    @Beta
    public static int read(InputStream in, byte[] b, int off, int len) throws IOException {
        int result;
        Preconditions.checkNotNull(in);
        Preconditions.checkNotNull(b);
        if (len < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int total = 0;
        while (total < len && (result = in.read(b, off + total, len - total)) != -1) {
            total += result;
        }
        return total;
    }
}
