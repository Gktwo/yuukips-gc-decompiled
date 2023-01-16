package org.eclipse.jetty.util;

import java.util.concurrent.atomic.AtomicReference;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/CompletableCallback.class */
public abstract class CompletableCallback implements Callback {
    private final AtomicReference<State> state = new AtomicReference<>(State.IDLE);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/CompletableCallback$State.class */
    private enum State {
        IDLE,
        SUCCEEDED,
        FAILED,
        COMPLETED
    }

    public abstract void resume();

    public abstract void abort(Throwable th);

    @Override // org.eclipse.jetty.util.Callback
    public void succeeded() {
        while (true) {
            State current = this.state.get();
            switch (current) {
                case IDLE:
                    if (!this.state.compareAndSet(current, State.SUCCEEDED)) {
                        break;
                    } else {
                        return;
                    }
                case COMPLETED:
                    if (!this.state.compareAndSet(current, State.SUCCEEDED)) {
                        break;
                    } else {
                        resume();
                        return;
                    }
                case FAILED:
                    return;
                default:
                    throw new IllegalStateException(current.toString());
            }
        }
    }

    @Override // org.eclipse.jetty.util.Callback
    public void failed(Throwable x) {
        State current;
        do {
            current = this.state.get();
            switch (current) {
                case IDLE:
                case COMPLETED:
                    break;
                case FAILED:
                    return;
                default:
                    throw new IllegalStateException(current.toString());
            }
        } while (!this.state.compareAndSet(current, State.FAILED));
        abort(x);
    }

    public boolean tryComplete() {
        State current;
        do {
            current = this.state.get();
            switch (current) {
                case IDLE:
                    break;
                case COMPLETED:
                default:
                    throw new IllegalStateException(current.toString());
                case FAILED:
                case SUCCEEDED:
                    return false;
            }
        } while (!this.state.compareAndSet(current, State.COMPLETED));
        return true;
    }
}
