package org.eclipse.jetty.client.util;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p013io.javalin.http.ContentType;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/PathContentProvider.class */
public class PathContentProvider extends AbstractTypedContentProvider {
    private static final Logger LOG = Log.getLogger(PathContentProvider.class);
    private final Path filePath;
    private final long fileSize;
    private final int bufferSize;
    private ByteBufferPool bufferPool;

    public PathContentProvider(Path filePath) throws IOException {
        this(filePath, 4096);
    }

    public PathContentProvider(Path filePath, int bufferSize) throws IOException {
        this(ContentType.OCTET_STREAM, filePath, bufferSize);
    }

    public PathContentProvider(String contentType, Path filePath) throws IOException {
        this(contentType, filePath, 4096);
    }

    public PathContentProvider(String contentType, Path filePath, int bufferSize) throws IOException {
        super(contentType);
        if (!Files.isRegularFile(filePath, new LinkOption[0])) {
            throw new NoSuchFileException(filePath.toString());
        } else if (!Files.isReadable(filePath)) {
            throw new AccessDeniedException(filePath.toString());
        } else {
            this.filePath = filePath;
            this.fileSize = Files.size(filePath);
            this.bufferSize = bufferSize;
        }
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider
    public long getLength() {
        return this.fileSize;
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider
    public boolean isReproducible() {
        return true;
    }

    public ByteBufferPool getByteBufferPool() {
        return this.bufferPool;
    }

    public void setByteBufferPool(ByteBufferPool byteBufferPool) {
        this.bufferPool = byteBufferPool;
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return new PathIterator();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/PathContentProvider$PathIterator.class */
    private class PathIterator implements Iterator<ByteBuffer>, Closeable {
        private ByteBuffer buffer;
        private SeekableByteChannel channel;
        private long position;

        private PathIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < PathContentProvider.this.getLength();
        }

        @Override // java.util.Iterator
        public ByteBuffer next() {
            try {
                if (this.channel == null) {
                    this.buffer = PathContentProvider.this.bufferPool == null ? ByteBuffer.allocateDirect(PathContentProvider.this.bufferSize) : PathContentProvider.this.bufferPool.acquire(PathContentProvider.this.bufferSize, true);
                    this.channel = Files.newByteChannel(PathContentProvider.this.filePath, StandardOpenOption.READ);
                    if (PathContentProvider.LOG.isDebugEnabled()) {
                        PathContentProvider.LOG.debug("Opened file {}", PathContentProvider.this.filePath);
                    }
                }
                this.buffer.clear();
                int read = this.channel.read(this.buffer);
                if (read < 0) {
                    throw new NoSuchElementException();
                }
                if (PathContentProvider.LOG.isDebugEnabled()) {
                    PathContentProvider.LOG.debug("Read {} bytes from {}", Integer.valueOf(read), PathContentProvider.this.filePath);
                }
                this.position += (long) read;
                this.buffer.flip();
                return this.buffer;
            } catch (NoSuchElementException x) {
                close();
                throw x;
            } catch (Throwable x2) {
                close();
                throw ((NoSuchElementException) new NoSuchElementException().initCause(x2));
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                if (!(PathContentProvider.this.bufferPool == null || this.buffer == null)) {
                    PathContentProvider.this.bufferPool.release(this.buffer);
                }
                if (this.channel != null) {
                    this.channel.close();
                }
            } catch (Throwable x) {
                PathContentProvider.LOG.ignore(x);
            }
        }
    }
}
