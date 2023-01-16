package org.eclipse.jetty.p023io;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeoutException;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Invocable;

/* renamed from: org.eclipse.jetty.io.AbstractConnection */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/AbstractConnection.class */
public abstract class AbstractConnection implements Connection {
    private static final Logger LOG = Log.getLogger(AbstractConnection.class);
    private final EndPoint _endPoint;
    private final Executor _executor;
    private final Callback _readCallback;
    private final List<Connection.Listener> _listeners = new CopyOnWriteArrayList();
    private final long _created = System.currentTimeMillis();
    private int _inputBufferSize = 2048;

    public abstract void onFillable();

    /* access modifiers changed from: protected */
    public AbstractConnection(EndPoint endp, Executor executor) {
        if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null!");
        }
        this._endPoint = endp;
        this._executor = executor;
        this._readCallback = new ReadCallback();
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public void addListener(Connection.Listener listener) {
        this._listeners.add(listener);
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public void removeListener(Connection.Listener listener) {
        this._listeners.remove(listener);
    }

    public int getInputBufferSize() {
        return this._inputBufferSize;
    }

    public void setInputBufferSize(int inputBufferSize) {
        this._inputBufferSize = inputBufferSize;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public Executor getExecutor() {
        return this._executor;
    }

    protected void failedCallback(Callback callback, Throwable x) {
        Runnable failCallback = () -> {
            try {
                callback.failed(x);
            } catch (Exception e) {
                LOG.warn(e);
            }
        };
        switch (Invocable.getInvocationType(callback)) {
            case BLOCKING:
                try {
                    getExecutor().execute(failCallback);
                    return;
                } catch (RejectedExecutionException e) {
                    LOG.debug(e);
                    callback.failed(x);
                    return;
                }
            case NON_BLOCKING:
                failCallback.run();
                return;
            case EITHER:
                Invocable.invokeNonBlocking(failCallback);
                return;
            default:
                return;
        }
    }

    public void fillInterested() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("fillInterested {}", this);
        }
        getEndPoint().fillInterested(this._readCallback);
    }

    public void tryFillInterested() {
        tryFillInterested(this._readCallback);
    }

    public void tryFillInterested(Callback callback) {
        getEndPoint().tryFillInterested(callback);
    }

    public boolean isFillInterested() {
        return getEndPoint().isFillInterested();
    }

    /* access modifiers changed from: protected */
    public void onFillInterestedFailed(Throwable cause) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} onFillInterestedFailed {}", this, cause);
        }
        if (this._endPoint.isOpen()) {
            boolean close = true;
            if (cause instanceof TimeoutException) {
                close = onReadTimeout(cause);
            }
            if (!close) {
                return;
            }
            if (this._endPoint.isOutputShutdown()) {
                this._endPoint.close();
                return;
            }
            this._endPoint.shutdownOutput();
            fillInterested();
        }
    }

    protected boolean onReadTimeout(Throwable timeout) {
        return true;
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public void onOpen() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onOpen {}", this);
        }
        for (Connection.Listener listener : this._listeners) {
            onOpened(listener);
        }
    }

    private void onOpened(Connection.Listener listener) {
        try {
            listener.onOpened(this);
        } catch (Throwable x) {
            LOG.info("Failure while notifying listener " + listener, x);
        }
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public void onClose() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onClose {}", this);
        }
        for (Connection.Listener listener : this._listeners) {
            onClosed(listener);
        }
    }

    private void onClosed(Connection.Listener listener) {
        try {
            listener.onClosed(this);
        } catch (Throwable x) {
            LOG.info("Failure while notifying listener " + listener, x);
        }
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public EndPoint getEndPoint() {
        return this._endPoint;
    }

    @Override // org.eclipse.jetty.p023io.Connection, java.io.Closeable, java.lang.AutoCloseable, org.eclipse.jetty.client.api.Connection
    public void close() {
        getEndPoint().close();
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public boolean onIdleExpired() {
        return true;
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public long getMessagesIn() {
        return -1;
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public long getMessagesOut() {
        return -1;
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public long getBytesIn() {
        return -1;
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public long getBytesOut() {
        return -1;
    }

    @Override // org.eclipse.jetty.p023io.Connection
    public long getCreatedTimeStamp() {
        return this._created;
    }

    @Override // java.lang.Object
    public final String toString() {
        return String.format("%s@%h::%s", getClass().getSimpleName(), this, getEndPoint());
    }

    public String toConnectionString() {
        return String.format("%s@%h", getClass().getSimpleName(), this);
    }

    /* renamed from: org.eclipse.jetty.io.AbstractConnection$ReadCallback */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/AbstractConnection$ReadCallback.class */
    private class ReadCallback implements Callback {
        private ReadCallback() {
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            AbstractConnection.this.onFillable();
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            AbstractConnection.this.onFillInterestedFailed(x);
        }

        public String toString() {
            return String.format("AC.ReadCB@%h{%s}", AbstractConnection.this, AbstractConnection.this);
        }
    }
}
