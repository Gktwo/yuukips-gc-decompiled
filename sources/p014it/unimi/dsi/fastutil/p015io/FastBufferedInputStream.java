package p014it.unimi.dsi.fastutil.p015io;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.FileChannel;
import java.util.EnumSet;
import p014it.unimi.dsi.fastutil.bytes.ByteArrays;

/* renamed from: it.unimi.dsi.fastutil.io.FastBufferedInputStream */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/FastBufferedInputStream.class */
public class FastBufferedInputStream extends MeasurableInputStream implements RepositionableStream {
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final EnumSet<LineTerminator> ALL_TERMINATORS = EnumSet.allOf(LineTerminator.class);

    /* renamed from: is */
    protected InputStream f2206is;
    protected byte[] buffer;
    protected int pos;
    protected long readBytes;
    protected int avail;
    private FileChannel fileChannel;
    private RepositionableStream repositionableStream;
    private MeasurableStream measurableStream;

    /* renamed from: it.unimi.dsi.fastutil.io.FastBufferedInputStream$LineTerminator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/FastBufferedInputStream$LineTerminator.class */
    public enum LineTerminator {
        CR,
        LF,
        CR_LF
    }

    private static int ensureBufferSize(int bufferSize) {
        if (bufferSize > 0) {
            return bufferSize;
        }
        throw new IllegalArgumentException("Illegal buffer size: " + bufferSize);
    }

    public FastBufferedInputStream(InputStream is, byte[] buffer) {
        this.f2206is = is;
        ensureBufferSize(buffer.length);
        this.buffer = buffer;
        if (is instanceof RepositionableStream) {
            this.repositionableStream = (RepositionableStream) is;
        }
        if (is instanceof MeasurableStream) {
            this.measurableStream = (MeasurableStream) is;
        }
        if (this.repositionableStream == null) {
            try {
                this.fileChannel = (FileChannel) is.getClass().getMethod("getChannel", new Class[0]).invoke(is, new Object[0]);
            } catch (ClassCastException e) {
            } catch (IllegalAccessException e2) {
            } catch (IllegalArgumentException e3) {
            } catch (NoSuchMethodException e4) {
            } catch (InvocationTargetException e5) {
            }
        }
    }

    public FastBufferedInputStream(InputStream is, int bufferSize) {
        this(is, new byte[ensureBufferSize(bufferSize)]);
    }

    public FastBufferedInputStream(InputStream is) {
        this(is, 8192);
    }

    protected boolean noMoreCharacters() throws IOException {
        if (this.avail != 0) {
            return false;
        }
        this.avail = this.f2206is.read(this.buffer);
        if (this.avail <= 0) {
            this.avail = 0;
            return true;
        }
        this.pos = 0;
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (noMoreCharacters()) {
            return -1;
        }
        this.avail--;
        this.readBytes++;
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int offset, int length) throws IOException {
        if (length <= this.avail) {
            System.arraycopy(this.buffer, this.pos, b, offset, length);
            this.pos += length;
            this.avail -= length;
            this.readBytes += (long) length;
            return length;
        }
        int head = this.avail;
        System.arraycopy(this.buffer, this.pos, b, offset, head);
        this.avail = 0;
        this.pos = 0;
        this.readBytes += (long) head;
        if (length > this.buffer.length) {
            int result = this.f2206is.read(b, offset + head, length - head);
            if (result > 0) {
                this.readBytes += (long) result;
            }
            if (result >= 0) {
                return result + head;
            }
            if (head == 0) {
                return -1;
            }
            return head;
        } else if (!noMoreCharacters()) {
            int toRead = Math.min(length - head, this.avail);
            this.readBytes += (long) toRead;
            System.arraycopy(this.buffer, 0, b, offset + head, toRead);
            this.pos = toRead;
            this.avail -= toRead;
            return toRead + head;
        } else if (head == 0) {
            return -1;
        } else {
            return head;
        }
    }

    public int readLine(byte[] array) throws IOException {
        return readLine(array, 0, array.length, ALL_TERMINATORS);
    }

    public int readLine(byte[] array, EnumSet<LineTerminator> terminators) throws IOException {
        return readLine(array, 0, array.length, terminators);
    }

    public int readLine(byte[] array, int off, int len) throws IOException {
        return readLine(array, off, len, ALL_TERMINATORS);
    }

    public int readLine(byte[] array, int off, int len, EnumSet<LineTerminator> terminators) throws IOException {
        ByteArrays.ensureOffsetLength(array, off, len);
        if (len == 0) {
            return 0;
        }
        if (noMoreCharacters()) {
            return -1;
        }
        int k = 0;
        int remaining = len;
        int read = 0;
        while (true) {
            int i = 0;
            while (i < this.avail && i < remaining) {
                byte b = this.buffer[this.pos + i];
                k = b;
                if (b == 10 || k == 13) {
                    break;
                }
                i++;
            }
            System.arraycopy(this.buffer, this.pos, array, off + read, i);
            this.pos += i;
            this.avail -= i;
            read += i;
            remaining -= i;
            if (remaining == 0) {
                this.readBytes += (long) read;
                return read;
            } else if (this.avail > 0) {
                if (k == 10) {
                    this.pos++;
                    this.avail--;
                    if (terminators.contains(LineTerminator.LF)) {
                        this.readBytes += (long) (read + 1);
                        return read;
                    }
                    read++;
                    array[off + read] = 10;
                    remaining--;
                } else if (k == 13) {
                    this.pos++;
                    this.avail--;
                    if (terminators.contains(LineTerminator.CR_LF)) {
                        if (this.avail > 0) {
                            if (this.buffer[this.pos] == 10) {
                                this.pos++;
                                this.avail--;
                                this.readBytes += (long) (read + 2);
                                return read;
                            }
                        } else if (noMoreCharacters()) {
                            if (!terminators.contains(LineTerminator.CR)) {
                                read++;
                                array[off + read] = 13;
                                int remaining2 = remaining - 1;
                                this.readBytes += (long) read;
                            } else {
                                this.readBytes += (long) (read + 1);
                            }
                            return read;
                        } else if (this.buffer[0] == 10) {
                            this.pos++;
                            this.avail--;
                            this.readBytes += (long) (read + 2);
                            return read;
                        }
                    }
                    if (terminators.contains(LineTerminator.CR)) {
                        this.readBytes += (long) (read + 1);
                        return read;
                    }
                    read++;
                    array[off + read] = 13;
                    remaining--;
                } else {
                    continue;
                }
            } else if (noMoreCharacters()) {
                this.readBytes += (long) read;
                return read;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public void position(long newPosition) throws IOException {
        long position = this.readBytes;
        if (newPosition > position + ((long) this.avail) || newPosition < position - ((long) this.pos)) {
            if (this.repositionableStream != null) {
                this.repositionableStream.position(newPosition);
            } else if (this.fileChannel != null) {
                this.fileChannel.position(newPosition);
            } else {
                throw new UnsupportedOperationException("position() can only be called if the underlying byte stream implements the RepositionableStream interface or if the getChannel() method of the underlying byte stream exists and returns a FileChannel");
            }
            this.readBytes = newPosition;
            this.pos = 0;
            this.avail = 0;
            return;
        }
        this.pos = (int) (((long) this.pos) + (newPosition - position));
        this.avail = (int) (((long) this.avail) - (newPosition - position));
        this.readBytes = newPosition;
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream, p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public long position() throws IOException {
        return this.readBytes;
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream
    public long length() throws IOException {
        if (this.measurableStream != null) {
            return this.measurableStream.length();
        }
        if (this.fileChannel != null) {
            return this.fileChannel.size();
        }
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long skipByReading(long r9) throws java.io.IOException {
        /*
            r8 = this;
            r0 = r9
            r11 = r0
        L_0x0002:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x002f
            r0 = r8
            java.io.InputStream r0 = r0.f2206is
            r1 = r8
            byte[] r1 = r1.buffer
            r2 = 0
            r3 = r8
            byte[] r3 = r3.buffer
            int r3 = r3.length
            long r3 = (long) r3
            r4 = r11
            long r3 = java.lang.Math.min(r3, r4)
            int r3 = (int) r3
            int r0 = r0.read(r1, r2, r3)
            r13 = r0
            r0 = r13
            if (r0 <= 0) goto L_0x002f
            r0 = r11
            r1 = r13
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x0002
        L_0x002f:
            r0 = r9
            r1 = r11
            long r0 = r0 - r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.p015io.FastBufferedInputStream.skipByReading(long):long");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x003d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0089 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x003d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [it.unimi.dsi.fastutil.io.FastBufferedInputStream] */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r10v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // java.io.InputStream
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long skip(long r8) throws java.io.IOException {
        /*
            r7 = this;
            r0 = r8
            r1 = r7
            int r1 = r1.avail
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x002d
            r0 = r8
            int r0 = (int) r0
            r10 = r0
            r0 = r7
            r1 = r0
            int r1 = r1.pos
            r2 = r10
            int r1 = r1 + r2
            r0.pos = r1
            r0 = r7
            r1 = r0
            int r1 = r1.avail
            r2 = r10
            int r1 = r1 - r2
            r0.avail = r1
            r0 = r7
            r1 = r0
            long r1 = r1.readBytes
            r2 = r8
            long r1 = r1 + r2
            r0.readBytes = r1
            r0 = r8
            return r0
        L_0x002d:
            r0 = r8
            r1 = r7
            int r1 = r1.avail
            long r1 = (long) r1
            long r0 = r0 - r1
            r10 = r0
            r0 = 0
            r12 = r0
            r0 = r7
            r1 = 0
            r0.avail = r1
        L_0x003d:
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0089
            r0 = r7
            java.io.InputStream r0 = r0.f2206is
            java.io.InputStream r1 = java.lang.System.in
            if (r0 != r1) goto L_0x0055
            r0 = r7
            r1 = r10
            long r0 = r0.skipByReading(r1)
            goto L_0x005d
        L_0x0055:
            r0 = r7
            java.io.InputStream r0 = r0.f2206is
            r1 = r10
            long r0 = r0.skip(r1)
        L_0x005d:
            r1 = r0; r0 = r0; 
            r12 = r1
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0089
            r0 = r12
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0081
            r0 = r7
            java.io.InputStream r0 = r0.f2206is
            int r0 = r0.read()
            r1 = -1
            if (r0 != r1) goto L_0x007a
            goto L_0x0089
        L_0x007a:
            r0 = r10
            r1 = 1
            long r0 = r0 - r1
            r10 = r0
            goto L_0x003d
        L_0x0081:
            r0 = r10
            r1 = r12
            long r0 = r0 - r1
            r10 = r0
            goto L_0x003d
        L_0x0089:
            r0 = r8
            r1 = r10
            r2 = r12
            long r1 = r1 - r2
            long r0 = r0 - r1
            r14 = r0
            r0 = r7
            r1 = r0
            long r1 = r1.readBytes
            r2 = r14
            long r1 = r1 + r2
            r0.readBytes = r1
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.p015io.FastBufferedInputStream.skip(long):long");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return (int) Math.min(((long) this.f2206is.available()) + ((long) this.avail), 2147483647L);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f2206is != null) {
            if (this.f2206is != System.in) {
                this.f2206is.close();
            }
            this.f2206is = null;
            this.buffer = null;
        }
    }

    public void flush() {
        if (this.f2206is != null) {
            this.readBytes += (long) this.avail;
            this.pos = 0;
            this.avail = 0;
        }
    }

    @Override // java.io.InputStream
    @Deprecated
    public void reset() {
        flush();
    }
}
