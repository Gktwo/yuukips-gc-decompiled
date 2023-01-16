package org.eclipse.jetty.util.thread.strategy;

import java.io.Closeable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.LongAdder;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ExecutionStrategy;
import org.eclipse.jetty.util.thread.Invocable;
import org.eclipse.jetty.util.thread.TryExecutor;

@ManagedObject("eat what you kill execution strategy")
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/strategy/EatWhatYouKill.class */
public class EatWhatYouKill extends ContainerLifeCycle implements ExecutionStrategy, Runnable {
    private static final Logger LOG = Log.getLogger(EatWhatYouKill.class);
    private final ExecutionStrategy.Producer _producer;
    private final Executor _executor;
    private final TryExecutor _tryExecutor;
    private boolean _pending;
    private final LongAdder _pcMode = new LongAdder();
    private final LongAdder _picMode = new LongAdder();
    private final LongAdder _pecMode = new LongAdder();
    private final LongAdder _epcMode = new LongAdder();
    private State _state = State.IDLE;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/strategy/EatWhatYouKill$Mode.class */
    public enum Mode {
        PRODUCE_CONSUME,
        PRODUCE_INVOKE_CONSUME,
        PRODUCE_EXECUTE_CONSUME,
        EXECUTE_PRODUCE_CONSUME
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/strategy/EatWhatYouKill$State.class */
    public enum State {
        IDLE,
        PRODUCING,
        REPRODUCING
    }

    public EatWhatYouKill(ExecutionStrategy.Producer producer, Executor executor) {
        this._producer = producer;
        this._executor = executor;
        this._tryExecutor = TryExecutor.asTryExecutor(executor);
        addBean(this._producer);
        addBean(this._tryExecutor);
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} created", this);
        }
    }

    @Override // org.eclipse.jetty.util.thread.ExecutionStrategy
    public void dispatch() {
        boolean execute = false;
        synchronized (this) {
            switch (this._state) {
                case IDLE:
                    if (!this._pending) {
                        this._pending = true;
                        execute = true;
                        break;
                    }
                    break;
                case PRODUCING:
                    this._state = State.REPRODUCING;
                    break;
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} dispatch {}", this, Boolean.valueOf(execute));
        }
        if (execute) {
            this._executor.execute(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        tryProduce(true);
    }

    @Override // org.eclipse.jetty.util.thread.ExecutionStrategy
    public void produce() {
        tryProduce(false);
    }

    private void tryProduce(boolean wasPending) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} tryProduce {}", this, Boolean.valueOf(wasPending));
        }
        synchronized (this) {
            if (wasPending) {
                this._pending = false;
            }
            switch (this._state) {
                case IDLE:
                    this._state = State.PRODUCING;
                    boolean nonBlocking = Invocable.isNonBlockingInvocation();
                    while (isRunning()) {
                        try {
                        } catch (Throwable ex) {
                            LOG.warn(ex);
                        }
                        if (!doProduce(nonBlocking)) {
                            return;
                        }
                    }
                    return;
                case PRODUCING:
                    this._state = State.REPRODUCING;
                    return;
                default:
                    return;
            }
        }
    }

    private boolean doProduce(boolean nonBlocking) {
        Mode mode;
        Runnable task = produceTask();
        if (task == null) {
            synchronized (this) {
                switch (this._state) {
                    case PRODUCING:
                        this._state = State.IDLE;
                        return false;
                    case REPRODUCING:
                        this._state = State.PRODUCING;
                        return true;
                    default:
                        throw new IllegalStateException(toStringLocked());
                }
            }
        } else {
            if (nonBlocking) {
                switch (Invocable.getInvocationType(task)) {
                    case NON_BLOCKING:
                        mode = Mode.PRODUCE_CONSUME;
                        break;
                    case EITHER:
                        mode = Mode.PRODUCE_INVOKE_CONSUME;
                        break;
                    default:
                        mode = Mode.PRODUCE_EXECUTE_CONSUME;
                        break;
                }
            } else {
                switch (Invocable.getInvocationType(task)) {
                    case NON_BLOCKING:
                        mode = Mode.PRODUCE_CONSUME;
                        break;
                    case EITHER:
                        synchronized (this) {
                            if (this._pending) {
                                this._state = State.IDLE;
                                mode = Mode.EXECUTE_PRODUCE_CONSUME;
                            } else if (this._tryExecutor.tryExecute(this)) {
                                this._pending = true;
                                this._state = State.IDLE;
                                mode = Mode.EXECUTE_PRODUCE_CONSUME;
                            } else {
                                mode = Mode.PRODUCE_INVOKE_CONSUME;
                            }
                        }
                        break;
                    case BLOCKING:
                        synchronized (this) {
                            if (this._pending) {
                                this._state = State.IDLE;
                                mode = Mode.EXECUTE_PRODUCE_CONSUME;
                            } else if (this._tryExecutor.tryExecute(this)) {
                                this._pending = true;
                                this._state = State.IDLE;
                                mode = Mode.EXECUTE_PRODUCE_CONSUME;
                            } else {
                                mode = Mode.PRODUCE_EXECUTE_CONSUME;
                            }
                        }
                        break;
                    default:
                        throw new IllegalStateException(toString());
                }
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} m={} t={}/{}", this, mode, task, Invocable.getInvocationType(task));
            }
            switch (mode) {
                case PRODUCE_CONSUME:
                    this._pcMode.increment();
                    runTask(task);
                    return true;
                case PRODUCE_INVOKE_CONSUME:
                    this._picMode.increment();
                    invokeTask(task);
                    return true;
                case PRODUCE_EXECUTE_CONSUME:
                    this._pecMode.increment();
                    execute(task);
                    return true;
                case EXECUTE_PRODUCE_CONSUME:
                    this._epcMode.increment();
                    runTask(task);
                    synchronized (this) {
                        if (this._state != State.IDLE) {
                            return false;
                        }
                        this._state = State.PRODUCING;
                        return true;
                    }
                default:
                    throw new IllegalStateException(toString());
            }
        }
    }

    private void runTask(Runnable task) {
        try {
            task.run();
        } catch (Throwable x) {
            LOG.warn(x);
        }
    }

    private void invokeTask(Runnable task) {
        try {
            Invocable.invokeNonBlocking(task);
        } catch (Throwable x) {
            LOG.warn(x);
        }
    }

    private Runnable produceTask() {
        try {
            return this._producer.produce();
        } catch (Throwable e) {
            LOG.warn(e);
            return null;
        }
    }

    private void execute(Runnable task) {
        try {
            this._executor.execute(task);
        } catch (RejectedExecutionException e) {
            if (isRunning()) {
                LOG.warn(e);
            } else {
                LOG.ignore(e);
            }
            if (task instanceof Closeable) {
                try {
                    ((Closeable) task).close();
                } catch (Throwable ex2) {
                    LOG.ignore(ex2);
                }
            }
        }
    }

    @ManagedAttribute(value = "number of tasks consumed with PC mode", readonly = true)
    public long getPCTasksConsumed() {
        return this._pcMode.longValue();
    }

    @ManagedAttribute(value = "number of tasks executed with PIC mode", readonly = true)
    public long getPICTasksExecuted() {
        return this._picMode.longValue();
    }

    @ManagedAttribute(value = "number of tasks executed with PEC mode", readonly = true)
    public long getPECTasksExecuted() {
        return this._pecMode.longValue();
    }

    @ManagedAttribute(value = "number of tasks consumed with EPC mode", readonly = true)
    public long getEPCTasksConsumed() {
        return this._epcMode.longValue();
    }

    @ManagedAttribute(value = "whether this execution strategy is idle", readonly = true)
    public boolean isIdle() {
        boolean z;
        synchronized (this) {
            z = this._state == State.IDLE;
        }
        return z;
    }

    @ManagedOperation(value = "resets the task counts", impact = "ACTION")
    public void reset() {
        this._pcMode.reset();
        this._epcMode.reset();
        this._pecMode.reset();
        this._picMode.reset();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        String stringLocked;
        synchronized (this) {
            stringLocked = toStringLocked();
        }
        return stringLocked;
    }

    public String toStringLocked() {
        StringBuilder builder = new StringBuilder();
        getString(builder);
        getState(builder);
        return builder.toString();
    }

    private void getString(StringBuilder builder) {
        builder.append(getClass().getSimpleName());
        builder.append('@');
        builder.append(Integer.toHexString(hashCode()));
        builder.append('/');
        builder.append(this._producer);
        builder.append('/');
    }

    private void getState(StringBuilder builder) {
        builder.append(this._state);
        builder.append("/p=");
        builder.append(this._pending);
        builder.append('/');
        builder.append(this._tryExecutor);
        builder.append("[pc=");
        builder.append(getPCTasksConsumed());
        builder.append(",pic=");
        builder.append(getPICTasksExecuted());
        builder.append(",pec=");
        builder.append(getPECTasksExecuted());
        builder.append(",epc=");
        builder.append(getEPCTasksConsumed());
        builder.append("]");
        builder.append("@");
        builder.append(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now()));
    }
}
