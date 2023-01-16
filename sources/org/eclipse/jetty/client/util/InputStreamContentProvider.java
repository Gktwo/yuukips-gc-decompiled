package org.eclipse.jetty.client.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/InputStreamContentProvider.class */
public class InputStreamContentProvider implements ContentProvider, Callback, Closeable {
    private static final Logger LOG = Log.getLogger(InputStreamContentProvider.class);
    private final InputStreamContentProviderIterator iterator;
    private final InputStream stream;
    private final int bufferSize;
    private final boolean autoClose;

    public InputStreamContentProvider(InputStream stream) {
        this(stream, 4096);
    }

    public InputStreamContentProvider(InputStream stream, int bufferSize) {
        this(stream, bufferSize, true);
    }

    public InputStreamContentProvider(InputStream stream, int bufferSize, boolean autoClose) {
        this.iterator = new InputStreamContentProviderIterator();
        this.stream = stream;
        this.bufferSize = bufferSize;
        this.autoClose = autoClose;
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider
    public long getLength() {
        return -1;
    }

    protected ByteBuffer onRead(byte[] buffer, int offset, int length) {
        if (length <= 0) {
            return BufferUtil.EMPTY_BUFFER;
        }
        return ByteBuffer.wrap(buffer, offset, length);
    }

    protected void onReadFailure(Throwable failure) {
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return this.iterator;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.autoClose) {
            try {
                this.stream.close();
            } catch (IOException x) {
                LOG.ignore(x);
            }
        }
    }

    @Override // org.eclipse.jetty.util.Callback
    public void failed(Throwable failure) {
        close();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/InputStreamContentProvider$InputStreamContentProviderIterator.class */
    private class InputStreamContentProviderIterator implements Iterator<ByteBuffer>, Closeable {
        private Throwable failure;
        private ByteBuffer buffer;
        private Boolean hasNext;

        private InputStreamContentProviderIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            try {
                if (this.hasNext != null) {
                    return this.hasNext.booleanValue();
                }
                byte[] bytes = new byte[InputStreamContentProvider.this.bufferSize];
                int read = InputStreamContentProvider.this.stream.read(bytes);
                if (InputStreamContentProvider.LOG.isDebugEnabled()) {
                    InputStreamContentProvider.LOG.debug("Read {} bytes from {}", Integer.valueOf(read), InputStreamContentProvider.this.stream);
                }
                if (read > 0) {
                    this.hasNext = Boolean.TRUE;
                    this.buffer = InputStreamContentProvider.this.onRead(bytes, 0, read);
                    return true;
                } else if (read < 0) {
                    this.hasNext = Boolean.FALSE;
                    this.buffer = null;
                    close();
                    return false;
                } else {
                    this.hasNext = Boolean.TRUE;
                    this.buffer = BufferUtil.EMPTY_BUFFER;
                    return true;
                }
            } catch (Throwable x) {
                if (InputStreamContentProvider.LOG.isDebugEnabled()) {
                    InputStreamContentProvider.LOG.debug(x);
                }
                if (this.failure == null) {
                    this.failure = x;
                    InputStreamContentProvider.this.onReadFailure(x);
                    this.hasNext = Boolean.TRUE;
                    this.buffer = null;
                    close();
                    return true;
                }
                throw new IllegalStateException();
            }
        }

        @Override // java.util.Iterator
        public ByteBuffer next() {
            if (this.failure != null) {
                this.hasNext = Boolean.FALSE;
                this.buffer = null;
                throw ((NoSuchElementException) new NoSuchElementException().initCause(this.failure));
            } else if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                ByteBuffer result = this.buffer;
                if (result == null) {
                    this.hasNext = Boolean.FALSE;
                    this.buffer = null;
                    throw new NoSuchElementException();
                }
                this.hasNext = null;
                this.buffer = null;
                return result;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            InputStreamContentProvider.this.close();
        }
    }
}
