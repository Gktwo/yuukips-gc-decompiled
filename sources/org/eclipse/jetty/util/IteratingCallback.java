package org.eclipse.jetty.util;

import java.io.IOException;
import org.eclipse.jetty.util.thread.Locker;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/IteratingCallback.class */
public abstract class IteratingCallback implements Callback {
    private Locker _locker;
    private State _state;
    private boolean _iterate;

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/IteratingCallback$Action.class */
    public enum Action {
        IDLE,
        SCHEDULED,
        SUCCEEDED
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/IteratingCallback$State.class */
    public enum State {
        IDLE,
        PROCESSING,
        PENDING,
        CALLED,
        SUCCEEDED,
        FAILED,
        CLOSED
    }

    protected abstract Action process() throws Throwable;

    /* access modifiers changed from: protected */
    public IteratingCallback() {
        this._locker = new Locker();
        this._state = State.IDLE;
    }

    /* access modifiers changed from: protected */
    public IteratingCallback(boolean needReset) {
        this._locker = new Locker();
        this._state = needReset ? State.SUCCEEDED : State.IDLE;
    }

    /* access modifiers changed from: protected */
    public void onCompleteSuccess() {
    }

    /* access modifiers changed from: protected */
    public void onCompleteFailure(Throwable cause) {
    }

    public void iterate() {
        boolean process = false;
        Locker.Lock lock = this._locker.lock();
        try {
            switch (this._state) {
                case PENDING:
                case CALLED:
                    if (lock != null) {
                        lock.close();
                        break;
                    }
                    break;
                case IDLE:
                    this._state = State.PROCESSING;
                    process = true;
                    if (lock != null) {
                        lock.close();
                        break;
                    }
                    break;
                case PROCESSING:
                    this._iterate = true;
                    if (lock != null) {
                        lock.close();
                        break;
                    }
                    break;
                case FAILED:
                case SUCCEEDED:
                    if (lock != null) {
                        lock.close();
                        break;
                    }
                    break;
                case CLOSED:
                default:
                    throw new IllegalStateException(toString());
            }
            if (process) {
                processing();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void processing() {
        boolean onCompleteSuccess = false;
        while (true) {
            try {
                Action action = process();
                Locker.Lock lock = this._locker.lock();
                try {
                    switch (this._state) {
                        case PENDING:
                        case IDLE:
                        default:
                            throw new IllegalStateException(String.format("%s[action=%s]", this, action));
                        case CALLED:
                            switch (action) {
                                case SCHEDULED:
                                    this._state = State.PROCESSING;
                                    if (lock == null) {
                                        break;
                                    } else {
                                        lock.close();
                                        break;
                                    }
                                default:
                                    throw new IllegalStateException(String.format("%s[action=%s]", this, action));
                            }
                        case PROCESSING:
                            switch (action) {
                                case IDLE:
                                    if (!this._iterate) {
                                        this._state = State.IDLE;
                                        if (lock != null) {
                                            lock.close();
                                            break;
                                        }
                                    } else {
                                        this._iterate = false;
                                        this._state = State.PROCESSING;
                                        if (lock == null) {
                                            break;
                                        } else {
                                            lock.close();
                                            break;
                                        }
                                    }
                                    break;
                                case SCHEDULED:
                                    this._state = State.PENDING;
                                    if (lock != null) {
                                        lock.close();
                                        break;
                                    }
                                    break;
                                case SUCCEEDED:
                                    this._iterate = false;
                                    this._state = State.SUCCEEDED;
                                    onCompleteSuccess = true;
                                    if (lock != null) {
                                        lock.close();
                                        break;
                                    }
                                    break;
                                default:
                                    throw new IllegalStateException(String.format("%s[action=%s]", this, action));
                            }
                        case FAILED:
                        case SUCCEEDED:
                        case CLOSED:
                            if (lock != null) {
                                lock.close();
                                break;
                            }
                            break;
                    }
                } catch (Throwable th) {
                    if (lock != null) {
                        try {
                            lock.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable x) {
                failed(x);
            }
        }
        if (onCompleteSuccess) {
            onCompleteSuccess();
        }
    }

    @Override // org.eclipse.jetty.util.Callback
    public void succeeded() {
        boolean process = false;
        Locker.Lock lock = this._locker.lock();
        try {
            switch (this._state) {
                case PENDING:
                    this._state = State.PROCESSING;
                    process = true;
                    break;
                case CALLED:
                case IDLE:
                case SUCCEEDED:
                default:
                    throw new IllegalStateException(toString());
                case PROCESSING:
                    this._state = State.CALLED;
                    break;
                case FAILED:
                case CLOSED:
                    break;
            }
            if (lock != null) {
                lock.close();
            }
            if (process) {
                processing();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.util.Callback
    public void failed(Throwable x) {
        boolean failure = false;
        Locker.Lock lock = this._locker.lock();
        try {
            switch (this._state) {
                case PENDING:
                case PROCESSING:
                    this._state = State.FAILED;
                    failure = true;
                    break;
                case CALLED:
                case IDLE:
                case FAILED:
                case SUCCEEDED:
                case CLOSED:
                    break;
                default:
                    throw new IllegalStateException(toString());
            }
            if (lock != null) {
                lock.close();
            }
            if (failure) {
                onCompleteFailure(x);
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void close() {
        String failure = null;
        Locker.Lock lock = this._locker.lock();
        try {
            switch (this._state) {
                case IDLE:
                case FAILED:
                case SUCCEEDED:
                    this._state = State.CLOSED;
                    break;
                case PROCESSING:
                default:
                    failure = String.format("Close %s in state %s", this, this._state);
                    this._state = State.CLOSED;
                    break;
                case CLOSED:
                    break;
            }
            if (lock != null) {
                lock.close();
            }
            if (failure != null) {
                onCompleteFailure(new IOException(failure));
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    boolean isIdle() {
        Locker.Lock lock = this._locker.lock();
        try {
            boolean z = this._state == State.IDLE;
            if (lock != null) {
                lock.close();
            }
            return z;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean isClosed() {
        Locker.Lock lock = this._locker.lock();
        try {
            boolean z = this._state == State.CLOSED;
            if (lock != null) {
                lock.close();
            }
            return z;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean isFailed() {
        Locker.Lock lock = this._locker.lock();
        try {
            boolean z = this._state == State.FAILED;
            if (lock != null) {
                lock.close();
            }
            return z;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean isSucceeded() {
        Locker.Lock lock = this._locker.lock();
        try {
            boolean z = this._state == State.SUCCEEDED;
            if (lock != null) {
                lock.close();
            }
            return z;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean reset() {
        Locker.Lock lock = this._locker.lock();
        try {
            switch (this._state) {
                case IDLE:
                    if (lock != null) {
                        lock.close();
                    }
                    return true;
                case PROCESSING:
                default:
                    if (lock != null) {
                        lock.close();
                    }
                    return false;
                case FAILED:
                case SUCCEEDED:
                    this._iterate = false;
                    this._state = State.IDLE;
                    if (lock != null) {
                        lock.close();
                    }
                    return true;
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String toString() {
        return String.format("%s@%x[%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._state);
    }
}
