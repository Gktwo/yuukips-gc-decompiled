package p014it.unimi.dsi.fastutil.p015io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import p014it.unimi.dsi.fastutil.bytes.ByteArrays;

/* renamed from: it.unimi.dsi.fastutil.io.InspectableFileCachedInputStream */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/InspectableFileCachedInputStream.class */
public class InspectableFileCachedInputStream extends MeasurableInputStream implements RepositionableStream, WritableByteChannel {
    public static final boolean DEBUG = false;
    public static final int DEFAULT_BUFFER_SIZE = 65536;
    public final byte[] buffer;
    public int inspectable;
    private final File overflowFile;
    private final RandomAccessFile randomAccessFile;
    private final FileChannel fileChannel;
    private long position;
    private long mark;
    private long writePosition;

    public InspectableFileCachedInputStream(int bufferSize, File overflowFile) throws IOException {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("Illegal buffer size " + bufferSize);
        }
        if (overflowFile != null) {
            this.overflowFile = overflowFile;
        } else {
            File createTempFile = File.createTempFile(getClass().getSimpleName(), "overflow");
            this.overflowFile = createTempFile;
            createTempFile.deleteOnExit();
        }
        this.buffer = new byte[bufferSize];
        this.randomAccessFile = new RandomAccessFile(this.overflowFile, "rw");
        this.fileChannel = this.randomAccessFile.getChannel();
        this.mark = -1;
    }

    public InspectableFileCachedInputStream(int bufferSize) throws IOException {
        this(bufferSize, null);
    }

    public InspectableFileCachedInputStream() throws IOException {
        this(65536);
    }

    private void ensureOpen() throws IOException {
        if (this.position == -1) {
            throw new IOException("This " + getClass().getSimpleName() + " is closed");
        }
    }

    public void clear() throws IOException {
        if (!this.fileChannel.isOpen()) {
            throw new IOException("This " + getClass().getSimpleName() + " is closed");
        }
        this.inspectable = 0;
        long j = (long) 0;
        this.position = j;
        this.writePosition = j;
        this.mark = -1;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        ensureOpen();
        int remaining = byteBuffer.remaining();
        if (this.inspectable < this.buffer.length) {
            int toBuffer = Math.min(this.buffer.length - this.inspectable, remaining);
            byteBuffer.get(this.buffer, this.inspectable, toBuffer);
            this.inspectable += toBuffer;
        }
        if (byteBuffer.hasRemaining()) {
            this.fileChannel.position(this.writePosition);
            this.writePosition += (long) this.fileChannel.write(byteBuffer);
        }
        return remaining;
    }

    public void truncate(long size) throws FileNotFoundException, IOException {
        this.fileChannel.truncate(Math.max(size, this.writePosition));
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.position = -1;
    }

    public void reopen() throws IOException {
        if (!this.fileChannel.isOpen()) {
            throw new IOException("This " + getClass().getSimpleName() + " is closed");
        }
        this.position = 0;
    }

    public void dispose() throws IOException {
        this.position = -1;
        this.randomAccessFile.close();
        this.overflowFile.delete();
    }

    @Override // java.lang.Object
    protected void finalize() throws Throwable {
        try {
            dispose();
        } finally {
            finalize();
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        ensureOpen();
        return (int) Math.min(2147483647L, length() - this.position);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int offset, int length) throws IOException {
        ensureOpen();
        if (length == 0) {
            return 0;
        }
        if (this.position == length()) {
            return -1;
        }
        ByteArrays.ensureOffsetLength(b, offset, length);
        int read = 0;
        if (this.position < ((long) this.inspectable)) {
            int toCopy = Math.min(this.inspectable - ((int) this.position), length);
            System.arraycopy(this.buffer, (int) this.position, b, offset, toCopy);
            length -= toCopy;
            offset += toCopy;
            this.position += (long) toCopy;
            read = toCopy;
        }
        if (length > 0) {
            if (this.position != length()) {
                this.fileChannel.position(this.position - ((long) this.inspectable));
                int t = this.randomAccessFile.read(b, offset, (int) Math.min(length() - this.position, (long) length));
                this.position += (long) t;
                read += t;
            } else if (read != 0) {
                return read;
            } else {
                return -1;
            }
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        ensureOpen();
        long toSkip = Math.min(n, length() - this.position);
        this.position += toSkip;
        return toSkip;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        ensureOpen();
        if (this.position == length()) {
            return -1;
        }
        if (this.position < ((long) this.inspectable)) {
            byte[] bArr = this.buffer;
            long j = this.position;
            this.position = j + 1;
            return bArr[(int) j] & 255;
        }
        this.fileChannel.position(this.position - ((long) this.inspectable));
        this.position++;
        return this.randomAccessFile.read();
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream
    public long length() throws IOException {
        ensureOpen();
        return ((long) this.inspectable) + this.writePosition;
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream, p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public long position() throws IOException {
        ensureOpen();
        return this.position;
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public void position(long position) throws IOException {
        this.position = Math.min(position, length());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.position != -1;
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
        this.mark = this.position;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        ensureOpen();
        if (this.mark == -1) {
            throw new IOException("Mark has not been set");
        }
        position(this.mark);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }
}
