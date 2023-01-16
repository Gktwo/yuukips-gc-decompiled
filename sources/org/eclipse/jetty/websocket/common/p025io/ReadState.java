package org.eclipse.jetty.websocket.common.p025io;

import java.nio.ByteBuffer;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* access modifiers changed from: package-private */
/* renamed from: org.eclipse.jetty.websocket.common.io.ReadState */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/ReadState.class */
public class ReadState {
    private static final Logger LOG = Log.getLogger(ReadState.class);
    private State state = State.READING;
    private ByteBuffer buffer;

    /* access modifiers changed from: package-private */
    /* renamed from: org.eclipse.jetty.websocket.common.io.ReadState$Action */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/ReadState$Action.class */
    public enum Action {
        FILL,
        PARSE,
        DISCARD,
        SUSPEND,
        EOF
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.websocket.common.io.ReadState$State */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/ReadState$State.class */
    public enum State {
        READING,
        SUSPENDING,
        SUSPENDED,
        DISCARDING,
        EOF
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer getBuffer() {
        ByteBuffer byteBuffer;
        synchronized (this) {
            byteBuffer = this.buffer;
        }
        return byteBuffer;
    }

    /* access modifiers changed from: package-private */
    public boolean isReading() {
        boolean z;
        synchronized (this) {
            z = this.state == State.READING;
        }
        return z;
    }

    boolean isSuspended() {
        boolean z;
        synchronized (this) {
            z = this.state == State.SUSPENDED || this.state == State.EOF;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public Action getAction(ByteBuffer buffer) {
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} getAction({})", this, BufferUtil.toDetailString(buffer));
            }
            switch (this.state) {
                case READING:
                    return buffer.hasRemaining() ? Action.PARSE : Action.FILL;
                case SUSPENDING:
                    this.buffer = buffer;
                    this.state = State.SUSPENDED;
                    return Action.SUSPEND;
                case EOF:
                    return Action.EOF;
                case DISCARDING:
                    return buffer.hasRemaining() ? Action.DISCARD : Action.FILL;
                case SUSPENDED:
                default:
                    throw new IllegalStateException(toString(this.state));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void suspending() {
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("suspending {}", this.state);
            }
            switch (this.state) {
                case READING:
                    this.state = State.SUSPENDING;
                    break;
                default:
                    throw new IllegalStateException(toString(this.state));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer resume() {
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("resuming {}", this.state);
            }
            switch (this.state) {
                case SUSPENDING:
                    this.state = State.READING;
                    return null;
                case SUSPENDED:
                    this.state = State.READING;
                    ByteBuffer bb = this.buffer;
                    this.buffer = null;
                    return bb;
                default:
                    throw new IllegalStateException(toString(this.state));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void eof() {
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("eof {}", this.state);
            }
            this.state = State.EOF;
        }
    }

    /* access modifiers changed from: package-private */
    public void discard() {
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("discard {}", this.state);
            }
            switch (this.state) {
                case READING:
                case SUSPENDING:
                case SUSPENDED:
                    this.state = State.DISCARDING;
                    break;
                case EOF:
                case DISCARDING:
                default:
                    throw new IllegalStateException(toString(this.state));
            }
        }
    }

    private String toString(State state) {
        return String.format("%s@%x[%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), state);
    }

    public String toString() {
        String readState;
        synchronized (this) {
            readState = toString(this.state);
        }
        return readState;
    }
}
