package org.eclipse.jetty.util;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/FutureCallback.class */
public class FutureCallback implements Future<Void>, Callback {
    private static final Throwable COMPLETED = new ConstantThrowable();
    public static final FutureCallback SUCCEEDED = new FutureCallback(true);
    private final AtomicBoolean _done = new AtomicBoolean(false);
    private final CountDownLatch _latch = new CountDownLatch(1);
    private Throwable _cause;

    public FutureCallback() {
    }

    public FutureCallback(boolean completed) {
        if (completed) {
            this._cause = COMPLETED;
            this._done.set(true);
            this._latch.countDown();
        }
    }

    public FutureCallback(Throwable failed) {
        this._cause = failed;
        this._done.set(true);
        this._latch.countDown();
    }

    @Override // org.eclipse.jetty.util.Callback
    public void succeeded() {
        if (this._done.compareAndSet(false, true)) {
            this._cause = COMPLETED;
            this._latch.countDown();
        }
    }

    @Override // org.eclipse.jetty.util.Callback
    public void failed(Throwable cause) {
        if (this._done.compareAndSet(false, true)) {
            this._cause = cause;
            this._latch.countDown();
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        if (!this._done.compareAndSet(false, true)) {
            return false;
        }
        this._cause = new CancellationException();
        this._latch.countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        if (!this._done.get()) {
            return false;
        }
        try {
            this._latch.await();
            return this._cause instanceof CancellationException;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this._done.get() && this._latch.getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public Void get() throws InterruptedException, ExecutionException {
        this._latch.await();
        if (this._cause == COMPLETED) {
            return null;
        }
        if (this._cause instanceof CancellationException) {
            throw ((CancellationException) new CancellationException().initCause(this._cause));
        }
        throw new ExecutionException(this._cause);
    }

    @Override // java.util.concurrent.Future
    public Void get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (!this._latch.await(timeout, unit)) {
            throw new TimeoutException();
        } else if (this._cause == COMPLETED) {
            return null;
        } else {
            if (this._cause instanceof TimeoutException) {
                throw ((TimeoutException) this._cause);
            } else if (this._cause instanceof CancellationException) {
                throw ((CancellationException) new CancellationException().initCause(this._cause));
            } else {
                throw new ExecutionException(this._cause);
            }
        }
    }

    public static void rethrow(ExecutionException e) throws IOException {
        Throwable cause = e.getCause();
        if (cause instanceof IOException) {
            throw ((IOException) cause);
        } else if (cause instanceof Error) {
            throw ((Error) cause);
        } else if (cause instanceof RuntimeException) {
            throw ((RuntimeException) cause);
        } else {
            throw new RuntimeException(cause);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this._done.get());
        objArr[2] = Boolean.valueOf(this._cause == COMPLETED);
        return String.format("FutureCallback@%x{%b,%b}", objArr);
    }
}
