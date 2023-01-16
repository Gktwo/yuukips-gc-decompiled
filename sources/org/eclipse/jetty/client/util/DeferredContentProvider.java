package org.eclipse.jetty.client.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.client.AsyncContentProvider;
import org.eclipse.jetty.client.Synchronizable;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/DeferredContentProvider.class */
public class DeferredContentProvider implements AsyncContentProvider, Callback, Closeable {
    private static final Chunk CLOSE = new Chunk(BufferUtil.EMPTY_BUFFER, Callback.NOOP);
    private final Object lock = this;
    private final Deque<Chunk> chunks = new ArrayDeque();
    private final AtomicReference<AsyncContentProvider.Listener> listener = new AtomicReference<>();
    private final DeferredContentProviderIterator iterator = new DeferredContentProviderIterator();
    private final AtomicBoolean closed = new AtomicBoolean();
    private long length = -1;
    private int size;
    private Throwable failure;

    static /* synthetic */ int access$406(DeferredContentProvider x0) {
        int i = x0.size - 1;
        x0.size = i;
        return i;
    }

    public DeferredContentProvider(ByteBuffer... buffers) {
        for (ByteBuffer buffer : buffers) {
            offer(buffer);
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    @Override // org.eclipse.jetty.client.AsyncContentProvider
    public void setListener(AsyncContentProvider.Listener listener) {
        if (!this.listener.compareAndSet(null, listener)) {
            throw new IllegalStateException(String.format("The same %s instance cannot be used in multiple requests", AsyncContentProvider.class.getName()));
        } else if (isClosed()) {
            synchronized (this.lock) {
                char c = 0;
                for (Chunk chunk : this.chunks) {
                    c += (long) chunk.buffer.remaining();
                }
                this.length = c;
            }
        }
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider
    public long getLength() {
        return this.length;
    }

    public boolean offer(ByteBuffer buffer) {
        return offer(buffer, Callback.NOOP);
    }

    public boolean offer(ByteBuffer buffer, Callback callback) {
        return offer(new Chunk(buffer, callback));
    }

    private boolean offer(Chunk chunk) {
        Throwable failure;
        boolean result = false;
        synchronized (this.lock) {
            failure = this.failure;
            if (failure == null) {
                result = this.chunks.offer(chunk);
                if (result && chunk != CLOSE) {
                    this.size++;
                }
            }
        }
        if (failure != null) {
            chunk.callback.failed(failure);
        } else if (result) {
            notifyListener();
        }
        return result;
    }

    /* access modifiers changed from: private */
    public void clear() {
        synchronized (this.lock) {
            this.chunks.clear();
        }
    }

    public void flush() throws IOException {
        synchronized (this.lock) {
            while (this.failure == null) {
                try {
                    if (this.size != 0) {
                        this.lock.wait();
                    }
                } catch (InterruptedException e) {
                    throw new InterruptedIOException();
                }
            }
            throw new IOException(this.failure);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed.compareAndSet(false, true)) {
            offer(CLOSE);
        }
    }

    public boolean isClosed() {
        return this.closed.get();
    }

    @Override // org.eclipse.jetty.util.Callback
    public void failed(Throwable failure) {
        this.iterator.failed(failure);
    }

    private void notifyListener() {
        AsyncContentProvider.Listener listener = this.listener.get();
        if (listener != null) {
            listener.onContent();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return this.iterator;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/DeferredContentProvider$DeferredContentProviderIterator.class */
    private class DeferredContentProviderIterator implements Iterator<ByteBuffer>, Callback, Synchronizable {
        private Chunk current;

        private DeferredContentProviderIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z;
            synchronized (DeferredContentProvider.this.lock) {
                z = DeferredContentProvider.this.chunks.peek() != DeferredContentProvider.CLOSE;
            }
            return z;
        }

        @Override // java.util.Iterator
        public ByteBuffer next() {
            ByteBuffer byteBuffer;
            synchronized (DeferredContentProvider.this.lock) {
                Chunk chunk = (Chunk) DeferredContentProvider.this.chunks.poll();
                this.current = chunk;
                if (chunk == DeferredContentProvider.CLOSE) {
                    DeferredContentProvider.this.chunks.offerFirst(DeferredContentProvider.CLOSE);
                    throw new NoSuchElementException();
                }
                byteBuffer = chunk == null ? null : chunk.buffer;
            }
            return byteBuffer;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            Chunk chunk;
            synchronized (DeferredContentProvider.this.lock) {
                chunk = this.current;
                if (chunk != null) {
                    DeferredContentProvider.access$406(DeferredContentProvider.this);
                    DeferredContentProvider.this.lock.notify();
                }
            }
            if (chunk != null) {
                chunk.callback.succeeded();
            }
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            List<Chunk> chunks = new ArrayList<>();
            synchronized (DeferredContentProvider.this.lock) {
                DeferredContentProvider.this.failure = x;
                Chunk chunk = this.current;
                this.current = null;
                if (chunk != null) {
                    chunks.add(chunk);
                }
                chunks.addAll(DeferredContentProvider.this.chunks);
                DeferredContentProvider.this.clear();
                DeferredContentProvider.this.lock.notify();
            }
            for (Chunk chunk2 : chunks) {
                chunk2.callback.failed(x);
            }
        }

        @Override // org.eclipse.jetty.client.Synchronizable
        public Object getLock() {
            return DeferredContentProvider.this.lock;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/DeferredContentProvider$Chunk.class */
    public static class Chunk {
        public final ByteBuffer buffer;
        public final Callback callback;

        public Chunk(ByteBuffer buffer, Callback callback) {
            this.buffer = (ByteBuffer) Objects.requireNonNull(buffer);
            this.callback = (Callback) Objects.requireNonNull(callback);
        }

        public String toString() {
            return String.format("%s@%x", getClass().getSimpleName(), Integer.valueOf(hashCode()));
        }
    }
}
