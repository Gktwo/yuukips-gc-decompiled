package org.eclipse.jetty.websocket.common.p025io;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: org.eclipse.jetty.websocket.common.io.ConnectionState */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/ConnectionState.class */
public class ConnectionState {
    private final AtomicReference<State> state = new AtomicReference<>(State.HANDSHAKING);
    private final AtomicBoolean wasOpened = new AtomicBoolean(false);

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.websocket.common.io.ConnectionState$State */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/ConnectionState$State.class */
    public enum State {
        HANDSHAKING,
        OPENING,
        OPENED,
        CLOSING,
        DISCONNECTED
    }

    public boolean canWriteWebSocketFrames() {
        State current = this.state.get();
        return current == State.OPENING || current == State.OPENED;
    }

    public boolean canReadWebSocketFrames() {
        State current = this.state.get();
        return current == State.OPENED || current == State.CLOSING;
    }

    public boolean wasOpened() {
        return this.wasOpened.get();
    }

    public boolean opening() {
        State current;
        do {
            current = this.state.get();
            switch (current) {
                case HANDSHAKING:
                    break;
                case CLOSING:
                    return false;
                case DISCONNECTED:
                    return false;
                default:
                    throw new IllegalStateException(toString(current));
            }
        } while (!this.state.compareAndSet(current, State.OPENING));
        this.wasOpened.set(true);
        return true;
    }

    public boolean opened() {
        State current;
        do {
            current = this.state.get();
            switch (current) {
                case CLOSING:
                    return false;
                case DISCONNECTED:
                    return false;
                case OPENING:
                    break;
                default:
                    throw new IllegalStateException(toString(current));
            }
        } while (!this.state.compareAndSet(current, State.OPENED));
        return true;
    }

    public boolean closing() {
        State current;
        do {
            current = this.state.get();
            switch (current) {
                case HANDSHAKING:
                case OPENING:
                case OPENED:
                    break;
                case CLOSING:
                    return false;
                case DISCONNECTED:
                    return false;
                default:
                    throw new IllegalStateException(toString(current));
            }
        } while (!this.state.compareAndSet(current, State.CLOSING));
        return true;
    }

    public boolean disconnected() {
        State current;
        do {
            current = this.state.get();
            switch (current) {
                case DISCONNECTED:
                    return false;
            }
        } while (!this.state.compareAndSet(current, State.DISCONNECTED));
        return true;
    }

    private String toString(State state) {
        return String.format("%s@%x[%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), state);
    }

    public String toString() {
        return toString(this.state.get());
    }
}
