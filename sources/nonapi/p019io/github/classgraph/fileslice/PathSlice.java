package nonapi.p019io.github.classgraph.fileslice;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.atomic.AtomicBoolean;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;
import nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessFileChannelReader;
import nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: nonapi.io.github.classgraph.fileslice.PathSlice */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fileslice/PathSlice.class */
public class PathSlice extends Slice implements Closeable {
    public final Path path;
    private final long fileLength;
    private FileChannel fileChannel;
    private final boolean isTopLevelFileSlice;
    private final AtomicBoolean isClosed;

    private PathSlice(PathSlice parentSlice, long offset, long length, boolean isDeflatedZipEntry, long inflatedLengthHint, NestedJarHandler nestedJarHandler) {
        super(parentSlice, offset, length, isDeflatedZipEntry, inflatedLengthHint, nestedJarHandler);
        this.isClosed = new AtomicBoolean();
        this.path = parentSlice.path;
        this.fileChannel = parentSlice.fileChannel;
        this.fileLength = parentSlice.fileLength;
        this.isTopLevelFileSlice = false;
    }

    public PathSlice(Path path, boolean isDeflatedZipEntry, long inflatedLengthHint, NestedJarHandler nestedJarHandler, LogNode log) throws IOException {
        super(0, isDeflatedZipEntry, inflatedLengthHint, nestedJarHandler);
        this.isClosed = new AtomicBoolean();
        FileUtils.checkCanReadAndIsFile(path);
        this.path = path;
        this.fileChannel = FileChannel.open(path, StandardOpenOption.READ);
        this.fileLength = this.fileChannel.size();
        this.isTopLevelFileSlice = true;
        this.sliceLength = this.fileLength;
        nestedJarHandler.markSliceAsOpen(this);
    }

    public PathSlice(Path path, NestedJarHandler nestedJarHandler, LogNode log) throws IOException {
        this(path, false, 0, nestedJarHandler, log);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice
    public Slice slice(long offset, long length, boolean isDeflatedZipEntry, long inflatedLengthHint) {
        if (!this.isDeflatedZipEntry) {
            return new PathSlice(this, offset, length, isDeflatedZipEntry, inflatedLengthHint, this.nestedJarHandler);
        }
        throw new IllegalArgumentException("Cannot slice a deflated zip entry");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice
    public RandomAccessReader randomAccessReader() {
        return new RandomAccessFileChannelReader(this.fileChannel, this.sliceStartPos, this.sliceLength);
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
        } else if (this.sliceLength <= 2147483639) {
            return ByteBuffer.wrap(load());
        } else {
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
            if (this.isTopLevelFileSlice && this.fileChannel != null) {
                try {
                    this.fileChannel.close();
                } catch (IOException e) {
                }
                this.fileChannel = null;
            }
            this.fileChannel = null;
            this.nestedJarHandler.markSliceAsClosed(this);
        }
    }
}
