package nonapi.p019io.github.classgraph.fileslice;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicBoolean;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;
import nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessByteBufferReader;
import nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessFileChannelReader;
import nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: nonapi.io.github.classgraph.fileslice.FileSlice */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fileslice/FileSlice.class */
public class FileSlice extends Slice {
    public final File file;
    public RandomAccessFile raf;
    private final long fileLength;
    private FileChannel fileChannel;
    private ByteBuffer backingByteBuffer;
    private final boolean isTopLevelFileSlice;
    private final AtomicBoolean isClosed;

    private FileSlice(FileSlice parentSlice, long offset, long length, boolean isDeflatedZipEntry, long inflatedLengthHint, NestedJarHandler nestedJarHandler) {
        super(parentSlice, offset, length, isDeflatedZipEntry, inflatedLengthHint, nestedJarHandler);
        this.isClosed = new AtomicBoolean();
        this.file = parentSlice.file;
        this.raf = parentSlice.raf;
        this.fileChannel = parentSlice.fileChannel;
        this.fileLength = parentSlice.fileLength;
        this.isTopLevelFileSlice = false;
        if (parentSlice.backingByteBuffer != null) {
            this.backingByteBuffer = parentSlice.backingByteBuffer.duplicate();
            this.backingByteBuffer.position((int) this.sliceStartPos);
            this.backingByteBuffer.limit((int) (this.sliceStartPos + this.sliceLength));
        }
    }

    public FileSlice(File file, boolean isDeflatedZipEntry, long inflatedLengthHint, NestedJarHandler nestedJarHandler, LogNode log) throws IOException {
        super(file.length(), isDeflatedZipEntry, inflatedLengthHint, nestedJarHandler);
        this.isClosed = new AtomicBoolean();
        FileUtils.checkCanReadAndIsFile(file);
        this.file = file;
        this.raf = new RandomAccessFile(file, "r");
        this.fileChannel = this.raf.getChannel();
        this.fileLength = file.length();
        this.isTopLevelFileSlice = true;
        if (nestedJarHandler.scanSpec.enableMemoryMapping) {
            try {
                this.backingByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, this.fileLength);
            } catch (IOException | OutOfMemoryError e) {
                System.gc();
                System.runFinalization();
                try {
                    this.backingByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, this.fileLength);
                } catch (IOException | OutOfMemoryError e2) {
                    if (log != null) {
                        log.log("File " + file + " cannot be memory mapped: " + e2 + " (using RandomAccessFile API instead)");
                    }
                }
            }
        }
        nestedJarHandler.markSliceAsOpen(this);
    }

    public FileSlice(File file, NestedJarHandler nestedJarHandler, LogNode log) throws IOException {
        this(file, false, 0, nestedJarHandler, log);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice
    public Slice slice(long offset, long length, boolean isDeflatedZipEntry, long inflatedLengthHint) {
        if (!this.isDeflatedZipEntry) {
            return new FileSlice(this, offset, length, isDeflatedZipEntry, inflatedLengthHint, this.nestedJarHandler);
        }
        throw new IllegalArgumentException("Cannot slice a deflated zip entry");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice
    public RandomAccessReader randomAccessReader() {
        if (this.backingByteBuffer == null) {
            return new RandomAccessFileChannelReader(this.fileChannel, this.sliceStartPos, this.sliceLength);
        }
        return new RandomAccessByteBufferReader(this.backingByteBuffer, this.sliceStartPos, this.sliceLength);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice
    public byte[] load() throws IOException {
        if (this.isDeflatedZipEntry) {
            if (this.inflatedLengthHint > 2147483639) {
                throw new IOException("Uncompressed size is larger than 2GB");
            }
            InputStream inputStream = open();
            Throwable th = null;
            try {
                byte[] readAllBytesAsArray = NestedJarHandler.readAllBytesAsArray(inputStream, this.inflatedLengthHint);
                if (inputStream != null) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        inputStream.close();
                    }
                }
                return readAllBytesAsArray;
            } catch (Throwable th3) {
                if (inputStream != null) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        inputStream.close();
                    }
                }
                throw th3;
            }
        } else if (this.sliceLength > 2147483639) {
            throw new IOException("File is larger than 2GB");
        } else {
            RandomAccessReader reader = randomAccessReader();
            byte[] content = new byte[(int) this.sliceLength];
            if (reader.read(0, content, 0, content.length) >= content.length) {
                return content;
            }
            throw new IOException("File is truncated");
        }
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice
    public ByteBuffer read() throws IOException {
        if (this.isDeflatedZipEntry) {
            if (this.inflatedLengthHint <= 2147483639) {
                return ByteBuffer.wrap(load());
            }
            throw new IOException("Uncompressed size is larger than 2GB");
        } else if (this.backingByteBuffer != null) {
            return this.backingByteBuffer.duplicate();
        } else {
            if (this.sliceLength <= 2147483639) {
                return ByteBuffer.wrap(load());
            }
            throw new IOException("File is larger than 2GB");
        }
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice, java.lang.Object
    public boolean equals(Object o) {
        return equals(o);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice, java.lang.Object
    public int hashCode() {
        return hashCode();
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.isClosed.getAndSet(true)) {
            if (this.isTopLevelFileSlice && this.backingByteBuffer != null) {
                FileUtils.closeDirectByteBuffer(this.backingByteBuffer, null);
            }
            this.backingByteBuffer = null;
            this.fileChannel = null;
            try {
                this.raf.close();
            } catch (IOException e) {
            }
            this.raf = null;
            this.nestedJarHandler.markSliceAsClosed(this);
        }
    }
}
