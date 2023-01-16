package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritePendingException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Invocable;

/* renamed from: org.eclipse.jetty.io.WriteFlusher */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/WriteFlusher.class */
public abstract class WriteFlusher {
    private static final Logger LOG = Log.getLogger(WriteFlusher.class);
    private static final boolean DEBUG = LOG.isDebugEnabled();
    private static final ByteBuffer[] EMPTY_BUFFERS = {BufferUtil.EMPTY_BUFFER};
    private static final EnumMap<StateType, Set<StateType>> __stateTransitions = new EnumMap<>(StateType.class);
    private static final State __IDLE = new IdleState();
    private static final State __WRITING = new WritingState();
    private static final State __COMPLETING = new CompletingState();
    private final EndPoint _endPoint;
    private final AtomicReference<State> _state = new AtomicReference<>();

    /* renamed from: org.eclipse.jetty.io.WriteFlusher$Listener */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/WriteFlusher$Listener.class */
    public interface Listener {
        void onFlushed(long j) throws IOException;
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.WriteFlusher$StateType */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/WriteFlusher$StateType.class */
    public enum StateType {
        IDLE,
        WRITING,
        PENDING,
        COMPLETING,
        FAILED
    }

    protected abstract void onIncompleteFlush();

    static {
        __stateTransitions.put((EnumMap<StateType, Set<StateType>>) StateType.IDLE, (StateType) EnumSet.of(StateType.WRITING));
        __stateTransitions.put((EnumMap<StateType, Set<StateType>>) StateType.WRITING, (StateType) EnumSet.of(StateType.IDLE, StateType.PENDING, StateType.FAILED));
        __stateTransitions.put((EnumMap<StateType, Set<StateType>>) StateType.PENDING, (StateType) EnumSet.of(StateType.COMPLETING, StateType.IDLE, StateType.FAILED));
        __stateTransitions.put((EnumMap<StateType, Set<StateType>>) StateType.COMPLETING, (StateType) EnumSet.of(StateType.IDLE, StateType.PENDING, StateType.FAILED));
        __stateTransitions.put((EnumMap<StateType, Set<StateType>>) StateType.FAILED, (StateType) EnumSet.noneOf(StateType.class));
    }

    /* access modifiers changed from: protected */
    public WriteFlusher(EndPoint endPoint) {
        this._state.set(__IDLE);
        this._endPoint = endPoint;
    }

    private boolean updateState(State previous, State next) {
        if (!isTransitionAllowed(previous, next)) {
            throw new IllegalStateException();
        }
        boolean updated = this._state.compareAndSet(previous, next);
        if (DEBUG) {
            Logger logger = LOG;
            Object[] objArr = new Object[4];
            objArr[0] = this;
            objArr[1] = previous;
            objArr[2] = updated ? "-->" : "!->";
            objArr[3] = next;
            logger.debug("update {}:{}{}{}", objArr);
        }
        return updated;
    }

    private boolean isTransitionAllowed(State currentState, State newState) {
        if (__stateTransitions.get(currentState.getType()).contains(newState.getType())) {
            return true;
        }
        LOG.warn("{}: {} -> {} not allowed", this, currentState, newState);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.WriteFlusher$State */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/WriteFlusher$State.class */
    public static class State {
        private final StateType _type;

        private State(StateType stateType) {
            this._type = stateType;
        }

        public StateType getType() {
            return this._type;
        }

        public String toString() {
            return String.format("%s", this._type);
        }
    }

    /* renamed from: org.eclipse.jetty.io.WriteFlusher$IdleState */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/WriteFlusher$IdleState.class */
    private static class IdleState extends State {
        private IdleState() {
            super(StateType.IDLE);
        }
    }

    /* renamed from: org.eclipse.jetty.io.WriteFlusher$WritingState */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/WriteFlusher$WritingState.class */
    private static class WritingState extends State {
        private WritingState() {
            super(StateType.WRITING);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.WriteFlusher$FailedState */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/WriteFlusher$FailedState.class */
    public static class FailedState extends State {
        private final Throwable _cause;

        private FailedState(Throwable cause) {
            super(StateType.FAILED);
            this._cause = cause;
        }

        public Throwable getCause() {
            return this._cause;
        }
    }

    /* renamed from: org.eclipse.jetty.io.WriteFlusher$CompletingState */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/WriteFlusher$CompletingState.class */
    private static class CompletingState extends State {
        private CompletingState() {
            super(StateType.COMPLETING);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.WriteFlusher$PendingState */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/WriteFlusher$PendingState.class */
    public class PendingState extends State {
        private final Callback _callback;
        private final ByteBuffer[] _buffers;

        private PendingState(ByteBuffer[] buffers, Callback callback) {
            super(StateType.PENDING);
            this._buffers = buffers;
            this._callback = callback;
        }

        public ByteBuffer[] getBuffers() {
            return this._buffers;
        }

        Invocable.InvocationType getCallbackInvocationType() {
            return Invocable.getInvocationType(this._callback);
        }
    }

    public Invocable.InvocationType getCallbackInvocationType() {
        State s = this._state.get();
        if (s instanceof PendingState) {
            return ((PendingState) s).getCallbackInvocationType();
        }
        return Invocable.InvocationType.BLOCKING;
    }

    public void write(Callback callback, ByteBuffer... buffers) throws WritePendingException {
        Objects.requireNonNull(callback);
        if (isFailed()) {
            fail(callback, new Throwable[0]);
            return;
        }
        if (DEBUG) {
            LOG.debug("write: {} {}", this, BufferUtil.toDetailString(buffers));
        }
        if (!updateState(__IDLE, __WRITING)) {
            throw new WritePendingException();
        }
        try {
            ByteBuffer[] buffers2 = flush(buffers);
            if (buffers2 != null) {
                if (DEBUG) {
                    LOG.debug("flushed incomplete", new Object[0]);
                }
                if (updateState(__WRITING, new PendingState(buffers2, callback))) {
                    onIncompleteFlush();
                } else {
                    fail(callback, new Throwable[0]);
                }
            } else {
                if (updateState(__WRITING, __IDLE)) {
                    callback.succeeded();
                } else {
                    fail(callback, new Throwable[0]);
                }
            }
        } catch (Throwable e) {
            if (DEBUG) {
                LOG.debug("write exception", e);
            }
            if (updateState(__WRITING, new FailedState(e))) {
                callback.failed(e);
            } else {
                fail(callback, e);
            }
        }
    }

    private void fail(Callback callback, Throwable... suppressed) {
        Throwable cause;
        while (true) {
            State state = this._state.get();
            switch (state.getType()) {
                case FAILED:
                    cause = ((FailedState) state).getCause();
                    break;
                case IDLE:
                    for (Throwable t : suppressed) {
                        LOG.warn(t);
                    }
                    return;
                default:
                    Throwable illegalStateException = new IllegalStateException();
                    if (this._state.compareAndSet(state, new FailedState(illegalStateException))) {
                        cause = illegalStateException;
                        break;
                    }
            }
        }
        for (Throwable t2 : suppressed) {
            if (t2 != cause) {
                cause.addSuppressed(t2);
            }
        }
        callback.failed(cause);
    }

    public void completeWrite() {
        if (DEBUG) {
            LOG.debug("completeWrite: {}", this);
        }
        State previous = this._state.get();
        if (previous.getType() == StateType.PENDING) {
            PendingState pending = (PendingState) previous;
            if (updateState(pending, __COMPLETING)) {
                Callback callback = pending._callback;
                try {
                    ByteBuffer[] buffers = flush(pending.getBuffers());
                    if (buffers != null) {
                        if (DEBUG) {
                            LOG.debug("flushed incomplete {}", BufferUtil.toDetailString(buffers));
                        }
                        if (buffers != pending.getBuffers()) {
                            pending = new PendingState(buffers, callback);
                        }
                        if (updateState(__COMPLETING, pending)) {
                            onIncompleteFlush();
                        } else {
                            fail(callback, new Throwable[0]);
                        }
                    } else {
                        if (updateState(__COMPLETING, __IDLE)) {
                            callback.succeeded();
                        } else {
                            fail(callback, new Throwable[0]);
                        }
                    }
                } catch (Throwable e) {
                    if (DEBUG) {
                        LOG.debug("completeWrite exception", e);
                    }
                    if (updateState(__COMPLETING, new FailedState(e))) {
                        callback.failed(e);
                    } else {
                        fail(callback, e);
                    }
                }
            }
        }
    }

    protected ByteBuffer[] flush(ByteBuffer[] buffers) throws IOException {
        boolean progress = true;
        while (progress && buffers != null) {
            long before = BufferUtil.remaining(buffers);
            boolean flushed = this._endPoint.flush(buffers);
            long after = BufferUtil.remaining(buffers);
            long written = before - after;
            if (LOG.isDebugEnabled()) {
                LOG.debug("Flushed={} written={} remaining={} {}", Boolean.valueOf(flushed), Long.valueOf(written), Long.valueOf(after), this);
            }
            if (written > 0) {
                Connection connection = this._endPoint.getConnection();
                if (connection instanceof Listener) {
                    ((Listener) connection).onFlushed(written);
                }
            }
            if (flushed) {
                return null;
            }
            progress = written > 0;
            int index = 0;
            while (true) {
                if (index == buffers.length) {
                    buffers = null;
                    index = 0;
                    break;
                } else if (buffers[index].remaining() > 0) {
                    break;
                } else {
                    index++;
                    progress = true;
                }
            }
            if (index > 0) {
                buffers = (ByteBuffer[]) Arrays.copyOfRange(buffers, index, buffers.length);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("!fully flushed {}", this);
        }
        return buffers == null ? EMPTY_BUFFERS : buffers;
    }

    public boolean onFail(Throwable cause) {
        while (true) {
            State current = this._state.get();
            switch (current.getType()) {
                case FAILED:
                case IDLE:
                    if (!DEBUG) {
                        return false;
                    }
                    LOG.debug("ignored: " + this, cause);
                    return false;
                case PENDING:
                    if (DEBUG) {
                        LOG.debug("failed: " + this, cause);
                    }
                    PendingState pending = (PendingState) current;
                    if (!updateState(pending, new FailedState(cause))) {
                        break;
                    } else {
                        pending._callback.failed(cause);
                        return true;
                    }
                case WRITING:
                case COMPLETING:
                    if (DEBUG) {
                        LOG.debug("failed: " + this, cause);
                    }
                    if (!updateState(current, new FailedState(cause))) {
                        break;
                    } else {
                        return true;
                    }
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public void onClose() {
        switch (this._state.get().getType()) {
            case FAILED:
            case IDLE:
                return;
            default:
                onFail(new ClosedChannelException());
                return;
        }
    }

    boolean isFailed() {
        return isState(StateType.FAILED);
    }

    boolean isIdle() {
        return isState(StateType.IDLE);
    }

    public boolean isPending() {
        return isState(StateType.PENDING);
    }

    private boolean isState(StateType type) {
        return this._state.get().getType() == type;
    }

    public String toStateString() {
        switch (this._state.get().getType()) {
            case FAILED:
                return "F";
            case IDLE:
                return "-";
            case PENDING:
                return "P";
            case WRITING:
                return "W";
            case COMPLETING:
                return "C";
            default:
                return "?";
        }
    }

    public String toString() {
        State s = this._state.get();
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = s;
        objArr[2] = s instanceof PendingState ? ((PendingState) s)._callback : null;
        return String.format("WriteFlusher@%x{%s}->%s", objArr);
    }
}
