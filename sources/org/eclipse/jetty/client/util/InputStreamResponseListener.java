package org.eclipse.jetty.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.DeferredContentProvider;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.C5747IO;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/InputStreamResponseListener.class */
public class InputStreamResponseListener extends Response.Listener.Adapter {
    private static final Logger LOG = Log.getLogger(InputStreamResponseListener.class);
    private static final DeferredContentProvider.Chunk EOF = new DeferredContentProvider.Chunk(BufferUtil.EMPTY_BUFFER, Callback.NOOP);
    private final Object lock = this;
    private final CountDownLatch responseLatch = new CountDownLatch(1);
    private final CountDownLatch resultLatch = new CountDownLatch(1);
    private final AtomicReference<InputStream> stream = new AtomicReference<>();
    private final Queue<DeferredContentProvider.Chunk> chunks = new ArrayDeque();
    private Response response;
    private Result result;
    private Throwable failure;
    private boolean closed;

    @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.HeadersListener
    public void onHeaders(Response response) {
        synchronized (this.lock) {
            this.response = response;
            this.responseLatch.countDown();
        }
    }

    @Override // org.eclipse.jetty.client.api.Response.ContentListener, org.eclipse.jetty.client.api.Response.AsyncContentListener
    public void onContent(Response response, ByteBuffer content, Callback callback) {
        boolean closed;
        if (content.remaining() == 0) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Skipped empty content {}", content);
            }
            callback.succeeded();
            return;
        }
        synchronized (this.lock) {
            closed = this.closed;
            if (!closed) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Queueing content {}", content);
                }
                this.chunks.add(new DeferredContentProvider.Chunk(content, callback));
                this.lock.notifyAll();
            }
        }
        if (closed) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("InputStream closed, ignored content {}", content);
            }
            callback.failed(new AsynchronousCloseException());
        }
    }

    @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.SuccessListener
    public void onSuccess(Response response) {
        synchronized (this.lock) {
            if (!this.closed) {
                this.chunks.add(EOF);
            }
            this.lock.notifyAll();
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("End of content", new Object[0]);
        }
    }

    @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.FailureListener
    public void onFailure(Response response, Throwable failure) {
        synchronized (this.lock) {
            if (this.failure == null) {
                this.failure = failure;
                List<Callback> callbacks = drain();
                this.lock.notifyAll();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Content failure", failure);
                }
                callbacks.forEach(callback -> {
                    callback.failed(failure);
                });
            }
        }
    }

    @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.CompleteListener
    public void onComplete(Result result) {
        Throwable failure = result.getFailure();
        List<Callback> callbacks = Collections.emptyList();
        synchronized (this.lock) {
            this.result = result;
            if (result.isFailed() && this.failure == null) {
                this.failure = failure;
                callbacks = drain();
            }
            this.responseLatch.countDown();
            this.resultLatch.countDown();
            this.lock.notifyAll();
        }
        if (LOG.isDebugEnabled()) {
            if (failure == null) {
                LOG.debug("Result success", new Object[0]);
            } else {
                LOG.debug("Result failure", failure);
            }
        }
        callbacks.forEach(callback -> {
            callback.failed(failure);
        });
    }

    public Response get(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException, ExecutionException {
        Response response;
        if (!this.responseLatch.await(timeout, unit)) {
            throw new TimeoutException();
        }
        synchronized (this.lock) {
            if (this.response == null) {
                throw new ExecutionException(this.failure);
            }
            response = this.response;
        }
        return response;
    }

    public Result await(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
        Result result;
        if (!this.resultLatch.await(timeout, unit)) {
            throw new TimeoutException();
        }
        synchronized (this.lock) {
            result = this.result;
        }
        return result;
    }

    public InputStream getInputStream() {
        InputStream result = new Input();
        if (this.stream.compareAndSet(null, result)) {
            return result;
        }
        return C5747IO.getClosedStream();
    }

    /* access modifiers changed from: private */
    public List<Callback> drain() {
        List<Callback> callbacks = new ArrayList<>();
        synchronized (this.lock) {
            while (true) {
                DeferredContentProvider.Chunk chunk = this.chunks.peek();
                if (chunk == null || chunk == EOF) {
                    break;
                }
                callbacks.add(chunk.callback);
                this.chunks.poll();
            }
        }
        return callbacks;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/InputStreamResponseListener$Input.class */
    private class Input extends InputStream {
        private Input() {
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            byte[] tmp = new byte[1];
            int read = read(tmp);
            if (read < 0) {
                return read;
            }
            return tmp[0] & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] b, int offset, int length) throws IOException {
            try {
                Callback callback = null;
                synchronized (InputStreamResponseListener.this.lock) {
                    while (true) {
                        DeferredContentProvider.Chunk chunk = (DeferredContentProvider.Chunk) InputStreamResponseListener.this.chunks.peek();
                        if (chunk == InputStreamResponseListener.EOF) {
                            return -1;
                        }
                        if (chunk != null) {
                            ByteBuffer buffer = chunk.buffer;
                            int result = Math.min(buffer.remaining(), length);
                            buffer.get(b, offset, result);
                            if (!buffer.hasRemaining()) {
                                callback = chunk.callback;
                                InputStreamResponseListener.this.chunks.poll();
                            }
                            if (callback != null) {
                                callback.succeeded();
                            }
                            return result;
                        } else if (InputStreamResponseListener.this.failure != null) {
                            throw toIOException(InputStreamResponseListener.this.failure);
                        } else if (InputStreamResponseListener.this.closed) {
                            throw new AsynchronousCloseException();
                        } else {
                            InputStreamResponseListener.this.lock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new InterruptedIOException();
            }
        }

        private IOException toIOException(Throwable failure) {
            if (failure instanceof IOException) {
                return (IOException) failure;
            }
            return new IOException(failure);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (InputStreamResponseListener.this.lock) {
                if (!InputStreamResponseListener.this.closed) {
                    InputStreamResponseListener.this.closed = true;
                    List<Callback> callbacks = InputStreamResponseListener.this.drain();
                    InputStreamResponseListener.this.lock.notifyAll();
                    if (InputStreamResponseListener.LOG.isDebugEnabled()) {
                        InputStreamResponseListener.LOG.debug("InputStream close", new Object[0]);
                    }
                    Throwable failure = new AsynchronousCloseException();
                    callbacks.forEach(callback -> {
                        callback.failed(failure);
                    });
                    close();
                }
            }
        }
    }
}
