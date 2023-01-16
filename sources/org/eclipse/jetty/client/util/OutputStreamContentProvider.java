package org.eclipse.jetty.client.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.eclipse.jetty.client.AsyncContentProvider;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.thread.Invocable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/OutputStreamContentProvider.class */
public class OutputStreamContentProvider implements AsyncContentProvider, Callback, Closeable {
    private final DeferredContentProvider deferred = new DeferredContentProvider(new ByteBuffer[0]);
    private final OutputStream output = new DeferredOutputStream();

    @Override // org.eclipse.jetty.util.thread.Invocable
    public Invocable.InvocationType getInvocationType() {
        return this.deferred.getInvocationType();
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider
    public long getLength() {
        return this.deferred.getLength();
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return this.deferred.iterator();
    }

    @Override // org.eclipse.jetty.client.AsyncContentProvider
    public void setListener(AsyncContentProvider.Listener listener) {
        this.deferred.setListener(listener);
    }

    public OutputStream getOutputStream() {
        return this.output;
    }

    protected void write(ByteBuffer buffer) {
        this.deferred.offer(buffer);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.deferred.close();
    }

    @Override // org.eclipse.jetty.util.Callback
    public void succeeded() {
        this.deferred.succeeded();
    }

    @Override // org.eclipse.jetty.util.Callback
    public void failed(Throwable failure) {
        this.deferred.failed(failure);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/OutputStreamContentProvider$DeferredOutputStream.class */
    private class DeferredOutputStream extends OutputStream {
        private DeferredOutputStream() {
        }

        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            write(new byte[]{(byte) b}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b, int off, int len) throws IOException {
            OutputStreamContentProvider.this.write(ByteBuffer.wrap(b, off, len));
            flush();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            OutputStreamContentProvider.this.deferred.flush();
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            OutputStreamContentProvider.this.close();
        }
    }
}
