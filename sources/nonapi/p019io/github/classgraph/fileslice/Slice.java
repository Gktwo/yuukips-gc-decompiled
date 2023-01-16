package nonapi.p019io.github.classgraph.fileslice;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;
import nonapi.p019io.github.classgraph.fileslice.reader.ClassfileReader;
import nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader;

/* renamed from: nonapi.io.github.classgraph.fileslice.Slice */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fileslice/Slice.class */
public abstract class Slice implements Closeable {
    protected final NestedJarHandler nestedJarHandler;
    protected final Slice parentSlice;
    public final long sliceStartPos;
    public long sliceLength;
    public final boolean isDeflatedZipEntry;
    public final long inflatedLengthHint;
    private int hashCode;

    public abstract Slice slice(long j, long j2, boolean z, long j3);

    public abstract RandomAccessReader randomAccessReader();

    public abstract byte[] load() throws IOException;

    /* access modifiers changed from: protected */
    public Slice(Slice parentSlice, long offset, long length, boolean isDeflatedZipEntry, long inflatedLengthHint, NestedJarHandler nestedJarHandler) {
        this.parentSlice = parentSlice;
        long parentSliceStartPos = parentSlice == null ? 0 : parentSlice.sliceStartPos;
        this.sliceStartPos = parentSliceStartPos + offset;
        this.sliceLength = length;
        this.isDeflatedZipEntry = isDeflatedZipEntry;
        this.inflatedLengthHint = inflatedLengthHint;
        this.nestedJarHandler = nestedJarHandler;
        if (this.sliceStartPos < 0) {
            throw new IllegalArgumentException("Invalid startPos");
        } else if (length < 0) {
            throw new IllegalArgumentException("Invalid length");
        } else if (parentSlice == null) {
        } else {
            if (this.sliceStartPos < parentSliceStartPos || this.sliceStartPos + length > parentSliceStartPos + parentSlice.sliceLength) {
                throw new IllegalArgumentException("Child slice is not completely contained within parent slice");
            }
        }
    }

    /* access modifiers changed from: protected */
    public Slice(long length, boolean isDeflatedZipEntry, long inflatedLengthHint, NestedJarHandler nestedJarHandler) {
        this(null, 0, length, isDeflatedZipEntry, inflatedLengthHint, nestedJarHandler);
    }

    public InputStream open() throws IOException {
        InputStream rawInputStream = new InputStream() { // from class: nonapi.io.github.classgraph.fileslice.Slice.1
            RandomAccessReader randomAccessReader;
            private long currOff;
            private long markOff;
            private final byte[] byteBuf = new byte[1];
            private final AtomicBoolean closed = new AtomicBoolean();

            {
                this.randomAccessReader = Slice.this.randomAccessReader();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (!this.closed.get()) {
                    return read(this.byteBuf, 0, 1);
                }
                throw new IOException("Already closed");
            }

            @Override // java.io.InputStream
            public int read(byte[] buf, int off, int len) throws IOException {
                if (this.closed.get()) {
                    throw new IOException("Already closed");
                } else if (len == 0) {
                    return 0;
                } else {
                    int numBytesToRead = Math.min(len, available());
                    if (numBytesToRead < 1) {
                        return -1;
                    }
                    int numBytesRead = this.randomAccessReader.read(this.currOff, buf, off, numBytesToRead);
                    if (numBytesRead > 0) {
                        this.currOff += (long) numBytesRead;
                    }
                    return numBytesRead;
                }
            }

            @Override // java.io.InputStream
            public long skip(long n) throws IOException {
                if (this.closed.get()) {
                    throw new IOException("Already closed");
                }
                long newOff = Math.min(this.currOff + n, Slice.this.sliceLength);
                long skipped = newOff - this.currOff;
                this.currOff = newOff;
                return skipped;
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Math.max(Slice.this.sliceLength - this.currOff, 0L), 2147483639L);
            }

            @Override // java.io.InputStream
            public synchronized void mark(int readlimit) {
                this.markOff = this.currOff;
            }

            @Override // java.io.InputStream
            public synchronized void reset() {
                this.currOff = this.markOff;
            }

            @Override // java.io.InputStream
            public boolean markSupported() {
                return true;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.closed.getAndSet(true);
            }
        };
        return this.isDeflatedZipEntry ? this.nestedJarHandler.openInflaterInputStream(rawInputStream) : rawInputStream;
    }

    public ClassfileReader openClassfileReader() throws IOException {
        if (this.sliceLength <= 2147483639) {
            return new ClassfileReader(this);
        }
        throw new IllegalArgumentException("Cannot open slices larger than 2GB for sequential buffered reading");
    }

    public String loadAsString() throws IOException {
        return new String(load(), StandardCharsets.UTF_8);
    }

    public ByteBuffer read() throws IOException {
        return ByteBuffer.wrap(load());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((this.parentSlice == null ? 1 : this.parentSlice.hashCode()) ^ (((int) this.sliceStartPos) * 7)) ^ (((int) this.sliceLength) * 15);
            if (this.hashCode == 0) {
                this.hashCode = 1;
            }
        }
        return this.hashCode;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Slice)) {
            return false;
        }
        Slice other = (Slice) o;
        return this.parentSlice == other.parentSlice && this.sliceStartPos == other.sliceStartPos && this.sliceLength == other.sliceLength;
    }
}
