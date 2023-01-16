package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* renamed from: org.eclipse.jetty.io.AbstractEndPoint */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/AbstractEndPoint.class */
public abstract class AbstractEndPoint extends IdleTimeout implements EndPoint {
    private static final Logger LOG = Log.getLogger(AbstractEndPoint.class);
    private volatile Connection _connection;
    private final AtomicReference<State> _state = new AtomicReference<>(State.OPEN);
    private final long _created = System.currentTimeMillis();
    private final FillInterest _fillInterest = new FillInterest() { // from class: org.eclipse.jetty.io.AbstractEndPoint.1
        @Override // org.eclipse.jetty.p023io.FillInterest
        protected void needsFillInterest() throws IOException {
            AbstractEndPoint.this.needsFillInterest();
        }
    };
    private final WriteFlusher _writeFlusher = new WriteFlusher(this) { // from class: org.eclipse.jetty.io.AbstractEndPoint.2
        @Override // org.eclipse.jetty.p023io.WriteFlusher
        protected void onIncompleteFlush() {
            AbstractEndPoint.this.onIncompleteFlush();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.AbstractEndPoint$State */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/AbstractEndPoint$State.class */
    public enum State {
        OPEN,
        ISHUTTING,
        ISHUT,
        OSHUTTING,
        OSHUT,
        CLOSED
    }

    protected abstract void onIncompleteFlush();

    protected abstract void needsFillInterest() throws IOException;

    /* access modifiers changed from: protected */
    public AbstractEndPoint(Scheduler scheduler) {
        super(scheduler);
    }

    protected final void shutdownInput() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("shutdownInput {}", this);
        }
        while (true) {
            State s = this._state.get();
            switch (s) {
                case OPEN:
                    if (!this._state.compareAndSet(s, State.ISHUTTING)) {
                        break;
                    } else {
                        try {
                            doShutdownInput();
                            if (this._state.compareAndSet(State.ISHUTTING, State.ISHUT)) {
                                return;
                            }
                            if (this._state.get() == State.CLOSED) {
                                doOnClose(null);
                                return;
                            }
                            throw new IllegalStateException();
                        } catch (Throwable th) {
                            if (!this._state.compareAndSet(State.ISHUTTING, State.ISHUT)) {
                                if (this._state.get() == State.CLOSED) {
                                    doOnClose(null);
                                } else {
                                    throw new IllegalStateException();
                                }
                            }
                            throw th;
                        }
                    }
                case ISHUTTING:
                case ISHUT:
                    return;
                case OSHUTTING:
                    if (!this._state.compareAndSet(s, State.CLOSED)) {
                        break;
                    } else {
                        return;
                    }
                case OSHUT:
                    if (!this._state.compareAndSet(s, State.CLOSED)) {
                        break;
                    } else {
                        doOnClose(null);
                        return;
                    }
                case CLOSED:
                    return;
            }
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public final void shutdownOutput() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("shutdownOutput {}", this);
        }
        while (true) {
            State s = this._state.get();
            switch (s) {
                case OPEN:
                    if (!this._state.compareAndSet(s, State.OSHUTTING)) {
                        break;
                    } else {
                        try {
                            doShutdownOutput();
                            if (this._state.compareAndSet(State.OSHUTTING, State.OSHUT)) {
                                return;
                            }
                            if (this._state.get() == State.CLOSED) {
                                doOnClose(null);
                                return;
                            }
                            throw new IllegalStateException();
                        } catch (Throwable th) {
                            if (!this._state.compareAndSet(State.OSHUTTING, State.OSHUT)) {
                                if (this._state.get() == State.CLOSED) {
                                    doOnClose(null);
                                } else {
                                    throw new IllegalStateException();
                                }
                            }
                            throw th;
                        }
                    }
                case ISHUTTING:
                    if (!this._state.compareAndSet(s, State.CLOSED)) {
                        break;
                    } else {
                        return;
                    }
                case ISHUT:
                    if (!this._state.compareAndSet(s, State.CLOSED)) {
                        break;
                    } else {
                        doOnClose(null);
                        return;
                    }
                case OSHUTTING:
                case OSHUT:
                    return;
                case CLOSED:
                    return;
            }
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("close {}", this);
        }
        close(null);
    }

    protected final void close(Throwable failure) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("close({}) {}", failure, this);
        }
        while (true) {
            State s = this._state.get();
            switch (s) {
                case OPEN:
                case ISHUT:
                case OSHUT:
                    if (!this._state.compareAndSet(s, State.CLOSED)) {
                        break;
                    } else {
                        doOnClose(failure);
                        return;
                    }
                case ISHUTTING:
                case OSHUTTING:
                    if (!this._state.compareAndSet(s, State.CLOSED)) {
                        break;
                    } else {
                        return;
                    }
                case CLOSED:
                    return;
            }
        }
    }

    protected void doShutdownInput() {
    }

    /* access modifiers changed from: protected */
    public void doShutdownOutput() {
    }

    private void doOnClose(Throwable failure) {
        try {
            doClose();
            if (failure == null) {
                onClose();
            } else {
                onClose(failure);
            }
        } catch (Throwable th) {
            if (failure == null) {
                onClose();
            } else {
                onClose(failure);
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void doClose() {
    }

    protected void onClose(Throwable failure) {
        onClose();
        this._writeFlusher.onFail(failure);
        this._fillInterest.onFail(failure);
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public boolean isOutputShutdown() {
        switch (this._state.get()) {
            case OSHUTTING:
            case OSHUT:
            case CLOSED:
                return true;
            default:
                return false;
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public boolean isInputShutdown() {
        switch (this._state.get()) {
            case ISHUTTING:
            case ISHUT:
            case CLOSED:
                return true;
            case OSHUTTING:
            case OSHUT:
            default:
                return false;
        }
    }

    @Override // org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
    public boolean isOpen() {
        switch (this._state.get()) {
            case CLOSED:
                return false;
            default:
                return true;
        }
    }

    public void checkFlush() throws IOException {
        State s = this._state.get();
        switch (s) {
            case OSHUTTING:
            case OSHUT:
            case CLOSED:
                throw new IOException(s.toString());
            default:
                return;
        }
    }

    public void checkFill() throws IOException {
        State s = this._state.get();
        switch (s) {
            case ISHUTTING:
            case ISHUT:
            case CLOSED:
                throw new IOException(s.toString());
            case OSHUTTING:
            case OSHUT:
            default:
                return;
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public long getCreatedTimeStamp() {
        return this._created;
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public Connection getConnection() {
        return this._connection;
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public void setConnection(Connection connection) {
        this._connection = connection;
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public boolean isOptimizedForDirectBuffers() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void reset() {
        this._state.set(State.OPEN);
        this._writeFlusher.onClose();
        this._fillInterest.onClose();
    }

    @Override // org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
    public void onOpen() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onOpen {}", this);
        }
        if (this._state.get() != State.OPEN) {
            throw new IllegalStateException();
        }
    }

    @Override // org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
    public void onClose() {
        onClose();
        this._writeFlusher.onClose();
        this._fillInterest.onClose();
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public void fillInterested(Callback callback) {
        notIdle();
        this._fillInterest.register(callback);
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public boolean tryFillInterested(Callback callback) {
        notIdle();
        return this._fillInterest.tryRegister(callback);
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public boolean isFillInterested() {
        return this._fillInterest.isInterested();
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public void write(Callback callback, ByteBuffer... buffers) throws IllegalStateException {
        this._writeFlusher.write(callback, buffers);
    }

    public FillInterest getFillInterest() {
        return this._fillInterest;
    }

    public WriteFlusher getWriteFlusher() {
        return this._writeFlusher;
    }

    @Override // org.eclipse.jetty.p023io.IdleTimeout
    protected void onIdleExpired(TimeoutException timeout) {
        Connection connection = this._connection;
        if (connection == null || connection.onIdleExpired()) {
            boolean outputShutdown = isOutputShutdown();
            boolean inputShutdown = isInputShutdown();
            boolean fillFailed = this._fillInterest.onFail(timeout);
            boolean writeFailed = this._writeFlusher.onFail(timeout);
            if (!isOpen() || ((!outputShutdown && !inputShutdown) || fillFailed || writeFailed)) {
                LOG.debug("Ignored idle endpoint {}", this);
            } else {
                close();
            }
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public void upgrade(Connection newConnection) {
        ByteBuffer buffer;
        Connection oldConnection = getConnection();
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} upgrading from {} to {}", this, oldConnection, newConnection);
        }
        if (oldConnection instanceof Connection.UpgradeFrom) {
            buffer = ((Connection.UpgradeFrom) oldConnection).onUpgradeFrom();
        } else {
            buffer = null;
        }
        oldConnection.onClose();
        oldConnection.getEndPoint().setConnection(newConnection);
        if (BufferUtil.hasContent(buffer)) {
            if (newConnection instanceof Connection.UpgradeTo) {
                ((Connection.UpgradeTo) newConnection).onUpgradeTo(buffer);
            } else {
                throw new IllegalStateException("Cannot upgrade: " + newConnection + " does not implement " + Connection.UpgradeTo.class.getName());
            }
        }
        newConnection.onOpen();
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("%s->%s", toEndPointString(), toConnectionString());
    }

    public String toEndPointString() {
        Class<?> c = getClass();
        String name = c.getSimpleName();
        while (name.length() == 0 && c.getSuperclass() != null) {
            c = c.getSuperclass();
            name = c.getSimpleName();
        }
        return String.format("%s@%h{l=%s,r=%s,%s,fill=%s,flush=%s,to=%d/%d}", name, this, getLocalAddress(), getRemoteAddress(), this._state.get(), this._fillInterest.toStateString(), this._writeFlusher.toStateString(), Long.valueOf(getIdleFor()), Long.valueOf(getIdleTimeout()));
    }

    public String toConnectionString() {
        Connection connection = getConnection();
        if (connection == null) {
            return "<null>";
        }
        if (connection instanceof AbstractConnection) {
            return ((AbstractConnection) connection).toConnectionString();
        }
        return String.format("%s@%x", connection.getClass().getSimpleName(), Integer.valueOf(connection.hashCode()));
    }
}
