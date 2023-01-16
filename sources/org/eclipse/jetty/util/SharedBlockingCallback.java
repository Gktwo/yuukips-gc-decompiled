package org.eclipse.jetty.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.time.DurationKt;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Invocable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/SharedBlockingCallback.class */
public class SharedBlockingCallback {
    private static final Logger LOG = Log.getLogger(SharedBlockingCallback.class);
    private static final Throwable IDLE = new ConstantThrowable("IDLE");
    private static final Throwable SUCCEEDED = new ConstantThrowable("SUCCEEDED");
    private static final Throwable FAILED = new ConstantThrowable(AbstractLifeCycle.FAILED);
    private final ReentrantLock _lock = new ReentrantLock();
    private final Condition _idle = this._lock.newCondition();
    private final Condition _complete = this._lock.newCondition();
    private Blocker _blocker = new Blocker();

    @Deprecated
    protected long getIdleTimeout() {
        return -1;
    }

    public Blocker acquire() throws IOException {
        long idle = getIdleTimeout();
        this._lock.lock();
        while (this._blocker._state != IDLE) {
            try {
                try {
                    if (idle <= 0 || idle >= DurationKt.MAX_MILLIS) {
                        this._idle.await();
                    } else if (!this._idle.await(idle * 2, TimeUnit.MILLISECONDS)) {
                        throw new IOException(new TimeoutException());
                    }
                } catch (InterruptedException e) {
                    throw new InterruptedIOException();
                }
            } catch (Throwable th) {
                this._lock.unlock();
                throw th;
            }
        }
        this._blocker._state = null;
        Blocker blocker = this._blocker;
        this._lock.unlock();
        return blocker;
    }

    public boolean fail(Throwable cause) {
        Objects.requireNonNull(cause);
        this._lock.lock();
        try {
            if (this._blocker._state != null) {
                return false;
            }
            this._blocker._state = new BlockerFailedException(cause);
            this._complete.signalAll();
            return true;
        } finally {
            this._lock.unlock();
        }
    }

    protected void notComplete(Blocker blocker) {
        LOG.warn("Blocker not complete {}", blocker);
        if (LOG.isDebugEnabled()) {
            LOG.debug(new Throwable());
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/SharedBlockingCallback$Blocker.class */
    public class Blocker implements Callback, Closeable {
        private Throwable _state = SharedBlockingCallback.IDLE;

        protected Blocker() {
        }

        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return Invocable.InvocationType.NON_BLOCKING;
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            SharedBlockingCallback.this._lock.lock();
            try {
                if (this._state == null) {
                    this._state = SharedBlockingCallback.SUCCEEDED;
                    SharedBlockingCallback.this._complete.signalAll();
                } else {
                    SharedBlockingCallback.LOG.warn("Succeeded after {}", this._state.toString());
                    if (SharedBlockingCallback.LOG.isDebugEnabled()) {
                        SharedBlockingCallback.LOG.debug(this._state);
                    }
                }
            } finally {
                SharedBlockingCallback.this._lock.unlock();
            }
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable cause) {
            SharedBlockingCallback.this._lock.lock();
            try {
                if (this._state == null) {
                    if (cause == null) {
                        this._state = SharedBlockingCallback.FAILED;
                    } else if (cause instanceof BlockerTimeoutException) {
                        this._state = new IOException(cause);
                    } else {
                        this._state = cause;
                    }
                    SharedBlockingCallback.this._complete.signalAll();
                } else if (!(this._state instanceof BlockerTimeoutException) && !(this._state instanceof BlockerFailedException)) {
                    SharedBlockingCallback.LOG.warn("Failed after {}: {}", this._state, cause);
                    if (SharedBlockingCallback.LOG.isDebugEnabled()) {
                        SharedBlockingCallback.LOG.debug(this._state);
                        SharedBlockingCallback.LOG.debug(cause);
                    }
                } else if (SharedBlockingCallback.LOG.isDebugEnabled()) {
                    SharedBlockingCallback.LOG.debug("Failed after {}", this._state);
                }
            } finally {
                SharedBlockingCallback.this._lock.unlock();
            }
        }

        public void block() throws IOException {
            long idle = SharedBlockingCallback.this.getIdleTimeout();
            SharedBlockingCallback.this._lock.lock();
            while (this._state == null) {
                try {
                    try {
                        if (idle > 0) {
                            if (!SharedBlockingCallback.this._complete.await(idle + Math.min(idle / 2, 1000L), TimeUnit.MILLISECONDS)) {
                                this._state = new BlockerTimeoutException();
                            }
                        } else {
                            SharedBlockingCallback.this._complete.await();
                        }
                    } catch (InterruptedException e) {
                        this._state = e;
                        throw new InterruptedIOException();
                    }
                } finally {
                    SharedBlockingCallback.this._lock.unlock();
                }
            }
            if (this._state != SharedBlockingCallback.SUCCEEDED) {
                if (this._state == SharedBlockingCallback.IDLE) {
                    throw new IllegalStateException("IDLE");
                } else if (this._state instanceof IOException) {
                    throw ((IOException) this._state);
                } else if (this._state instanceof CancellationException) {
                    throw ((CancellationException) this._state);
                } else if (this._state instanceof RuntimeException) {
                    throw ((RuntimeException) this._state);
                } else if (this._state instanceof Error) {
                    throw ((Error) this._state);
                } else {
                    throw new IOException(this._state);
                }
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            SharedBlockingCallback.this._lock.lock();
            try {
                if (this._state == SharedBlockingCallback.IDLE) {
                    throw new IllegalStateException("IDLE");
                }
                if (this._state == null) {
                    SharedBlockingCallback.this.notComplete(this);
                }
                try {
                    if (this._state == null || this._state == SharedBlockingCallback.SUCCEEDED) {
                        this._state = SharedBlockingCallback.IDLE;
                    } else {
                        SharedBlockingCallback.this._blocker = new Blocker();
                    }
                    SharedBlockingCallback.this._idle.signalAll();
                    SharedBlockingCallback.this._complete.signalAll();
                    SharedBlockingCallback.this._lock.unlock();
                } catch (Throwable th) {
                    SharedBlockingCallback.this._lock.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    if (this._state == null || this._state == SharedBlockingCallback.SUCCEEDED) {
                        this._state = SharedBlockingCallback.IDLE;
                    } else {
                        SharedBlockingCallback.this._blocker = new Blocker();
                    }
                    SharedBlockingCallback.this._idle.signalAll();
                    SharedBlockingCallback.this._complete.signalAll();
                    SharedBlockingCallback.this._lock.unlock();
                    throw th2;
                } catch (Throwable th3) {
                    SharedBlockingCallback.this._lock.unlock();
                    throw th3;
                }
            }
        }

        @Override // java.lang.Object
        public String toString() {
            SharedBlockingCallback.this._lock.lock();
            try {
                return String.format("%s@%x{%s}", Blocker.class.getSimpleName(), Integer.valueOf(hashCode()), this._state);
            } finally {
                SharedBlockingCallback.this._lock.unlock();
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/SharedBlockingCallback$BlockerTimeoutException.class */
    public static class BlockerTimeoutException extends TimeoutException {
        private BlockerTimeoutException() {
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/SharedBlockingCallback$BlockerFailedException.class */
    public static class BlockerFailedException extends Exception {
        public BlockerFailedException(Throwable cause) {
            super(cause);
        }
    }
}
