package org.eclipse.jetty.util.thread.strategy;

import java.util.concurrent.Executor;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ExecutionStrategy;
import org.eclipse.jetty.util.thread.Invocable;
import org.eclipse.jetty.util.thread.Locker;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/strategy/ProduceExecuteConsume.class */
public class ProduceExecuteConsume implements ExecutionStrategy {
    private static final Logger LOG = Log.getLogger(ProduceExecuteConsume.class);
    private final ExecutionStrategy.Producer _producer;
    private final Executor _executor;
    private final Locker _locker = new Locker();
    private State _state = State.IDLE;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/strategy/ProduceExecuteConsume$State.class */
    public enum State {
        IDLE,
        PRODUCE,
        EXECUTE
    }

    public ProduceExecuteConsume(ExecutionStrategy.Producer producer, Executor executor) {
        this._producer = producer;
        this._executor = executor;
    }

    @Override // org.eclipse.jetty.util.thread.ExecutionStrategy
    public void produce() {
        Locker.Lock locked = this._locker.lock();
        try {
            switch (this._state) {
                case PRODUCE:
                case EXECUTE:
                    this._state = State.EXECUTE;
                    if (locked != null) {
                        locked.close();
                        return;
                    }
                    return;
                case IDLE:
                    this._state = State.PRODUCE;
                    break;
            }
            if (locked != null) {
                locked.close();
            }
            while (true) {
                Runnable task = this._producer.produce();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("{} produced {}", this._producer, task);
                }
                if (task == null) {
                    locked = this._locker.lock();
                    try {
                        switch (this._state) {
                            case IDLE:
                                throw new IllegalStateException();
                            case PRODUCE:
                                this._state = State.IDLE;
                                if (locked != null) {
                                    locked.close();
                                    return;
                                }
                                return;
                            case EXECUTE:
                                this._state = State.PRODUCE;
                                if (locked != null) {
                                    locked.close();
                                } else {
                                    continue;
                                }
                            default:
                                if (locked != null) {
                                    locked.close();
                                    break;
                                }
                                break;
                        }
                    } finally {
                        if (locked != null) {
                            try {
                                locked.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                    }
                }
                if (Invocable.getInvocationType(task) == Invocable.InvocationType.NON_BLOCKING) {
                    task.run();
                } else {
                    this._executor.execute(task);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // org.eclipse.jetty.util.thread.ExecutionStrategy
    public void dispatch() {
        this._executor.execute(() -> {
            produce();
        });
    }
}
