package org.eclipse.jetty.util.thread.strategy;

import java.util.concurrent.Executor;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ExecutionStrategy;
import org.eclipse.jetty.util.thread.Locker;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/strategy/ExecuteProduceConsume.class */
public class ExecuteProduceConsume implements ExecutionStrategy, Runnable {
    private static final Logger LOG = Log.getLogger(ExecuteProduceConsume.class);
    private final ExecutionStrategy.Producer _producer;
    private final Executor _executor;
    private boolean _execute;
    private boolean _producing;
    private boolean _pending;
    private final Locker _locker = new Locker();
    private final Runnable _runProduce = new RunProduce();
    private boolean _idle = true;

    public ExecuteProduceConsume(ExecutionStrategy.Producer producer, Executor executor) {
        this._producer = producer;
        this._executor = executor;
    }

    @Override // org.eclipse.jetty.util.thread.ExecutionStrategy
    public void produce() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} execute", this);
        }
        boolean produce = false;
        Locker.Lock locked = this._locker.lock();
        try {
            if (!this._idle) {
                this._execute = true;
            } else if (this._producing) {
                throw new IllegalStateException();
            } else {
                this._producing = true;
                produce = true;
                this._idle = false;
            }
            if (locked != null) {
                locked.close();
            }
            if (produce) {
                produceConsume();
            }
        } catch (Throwable th) {
            if (locked != null) {
                try {
                    locked.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.util.thread.ExecutionStrategy
    public void dispatch() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} spawning", this);
        }
        boolean dispatch = false;
        Locker.Lock locked = this._locker.lock();
        try {
            if (this._idle) {
                dispatch = true;
            } else {
                this._execute = true;
            }
            if (locked != null) {
                locked.close();
            }
            if (dispatch) {
                this._executor.execute(this._runProduce);
            }
        } catch (Throwable th) {
            if (locked != null) {
                try {
                    locked.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} run", this);
        }
        boolean produce = false;
        Locker.Lock locked = this._locker.lock();
        try {
            this._pending = false;
            if (!this._idle && !this._producing) {
                this._producing = true;
                produce = true;
            }
            if (locked != null) {
                locked.close();
            }
            if (produce) {
                produceConsume();
            }
        } catch (Throwable th) {
            if (locked != null) {
                try {
                    locked.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0099, code lost:
        r7._idle = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009f, code lost:
        if (r0 == null) goto L_0x01b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a2, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017c, code lost:
        if (r0 == null) goto L_0x01b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x017f, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void produceConsume() {
        /*
        // Method dump skipped, instructions count: 464
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.produceConsume():void");
    }

    public Boolean isIdle() {
        Locker.Lock locked = this._locker.lock();
        try {
            Boolean valueOf = Boolean.valueOf(this._idle);
            if (locked != null) {
                locked.close();
            }
            return valueOf;
        } catch (Throwable th) {
            if (locked != null) {
                try {
                    locked.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EPC ");
        Locker.Lock locked = this._locker.lock();
        try {
            builder.append(this._idle ? "Idle/" : "");
            builder.append(this._producing ? "Prod/" : "");
            builder.append(this._pending ? "Pend/" : "");
            builder.append(this._execute ? "Exec/" : "");
            if (locked != null) {
                locked.close();
            }
            builder.append(this._producer);
            return builder.toString();
        } catch (Throwable th) {
            if (locked != null) {
                try {
                    locked.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/strategy/ExecuteProduceConsume$RunProduce.class */
    private class RunProduce implements Runnable {
        private RunProduce() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExecuteProduceConsume.this.produce();
        }
    }
}
