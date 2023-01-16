package org.eclipse.jetty.util.thread.strategy;

import java.util.concurrent.Executor;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ExecutionStrategy;
import org.eclipse.jetty.util.thread.Locker;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/strategy/ProduceConsume.class */
public class ProduceConsume implements ExecutionStrategy, Runnable {
    private static final Logger LOG = Log.getLogger(ExecuteProduceConsume.class);
    private final ExecutionStrategy.Producer _producer;
    private final Executor _executor;
    private final Locker _locker = new Locker();
    private State _state = State.IDLE;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/strategy/ProduceConsume$State.class */
    public enum State {
        IDLE,
        PRODUCE,
        EXECUTE
    }

    public ProduceConsume(ExecutionStrategy.Producer producer, Executor executor) {
        this._producer = producer;
        this._executor = executor;
    }

    @Override // org.eclipse.jetty.util.thread.ExecutionStrategy
    public void produce() {
        Locker.Lock lock = this._locker.lock();
        try {
            switch (this._state) {
                case PRODUCE:
                case EXECUTE:
                    this._state = State.EXECUTE;
                    if (lock != null) {
                        lock.close();
                        return;
                    }
                    return;
                case IDLE:
                    this._state = State.PRODUCE;
                    break;
            }
            if (lock != null) {
                lock.close();
            }
            while (true) {
                Runnable task = this._producer.produce();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("{} produced {}", this._producer, task);
                }
                if (task == null) {
                    lock = this._locker.lock();
                    try {
                        switch (this._state) {
                            case IDLE:
                                throw new IllegalStateException();
                            case PRODUCE:
                                this._state = State.IDLE;
                                if (lock != null) {
                                    lock.close();
                                    return;
                                }
                                return;
                            case EXECUTE:
                                this._state = State.PRODUCE;
                                if (lock != null) {
                                    lock.close();
                                } else {
                                    continue;
                                }
                            default:
                                if (lock != null) {
                                    lock.close();
                                    break;
                                }
                                break;
                        }
                    } finally {
                        if (lock != null) {
                            try {
                                lock.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                    }
                }
                task.run();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // org.eclipse.jetty.util.thread.ExecutionStrategy
    public void dispatch() {
        this._executor.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        produce();
    }
}
