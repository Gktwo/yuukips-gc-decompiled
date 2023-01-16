package org.eclipse.jetty.util.thread;

import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import org.eclipse.jetty.util.AtomicBiInteger;
import org.eclipse.jetty.util.ProcessorUtils;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.util.thread.ThreadPoolBudget;

@ManagedObject("A pool for reserved threads")
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ReservedThreadExecutor.class */
public class ReservedThreadExecutor extends AbstractLifeCycle implements TryExecutor, Dumpable {
    private static final Logger LOG = Log.getLogger(ReservedThreadExecutor.class);
    private static final long DEFAULT_IDLE_TIMEOUT = TimeUnit.MINUTES.toNanos(1);
    private static final Runnable STOP = new Runnable() { // from class: org.eclipse.jetty.util.thread.ReservedThreadExecutor.1
        @Override // java.lang.Runnable
        public void run() {
        }

        @Override // java.lang.Object
        public String toString() {
            return "STOP";
        }
    };
    private final Executor _executor;
    private final int _capacity;
    private ThreadPoolBudget.Lease _lease;
    private final Set<ReservedThread> _threads = ConcurrentHashMap.newKeySet();
    private final SynchronousQueue<Runnable> _queue = new SynchronousQueue<>(false);
    private final AtomicBiInteger _count = new AtomicBiInteger();
    private final AtomicLong _lastEmptyTime = new AtomicLong(System.nanoTime());
    private long _idleTimeNanos = DEFAULT_IDLE_TIMEOUT;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ReservedThreadExecutor$State.class */
    public enum State {
        PENDING,
        RESERVED,
        RUNNING,
        IDLE,
        STOPPED
    }

    public ReservedThreadExecutor(Executor executor, int capacity) {
        this._executor = executor;
        this._capacity = reservedThreads(executor, capacity);
        if (LOG.isDebugEnabled()) {
            LOG.debug("{}", this);
        }
    }

    private static int reservedThreads(Executor executor, int capacity) {
        if (capacity >= 0) {
            return capacity;
        }
        int cpus = ProcessorUtils.availableProcessors();
        if (executor instanceof ThreadPool.SizedThreadPool) {
            return Math.max(1, Math.min(cpus, ((ThreadPool.SizedThreadPool) executor).getMaxThreads() / 10));
        }
        return cpus;
    }

    public Executor getExecutor() {
        return this._executor;
    }

    @ManagedAttribute(value = "max number of reserved threads", readonly = true)
    public int getCapacity() {
        return this._capacity;
    }

    @ManagedAttribute(value = "available reserved threads", readonly = true)
    public int getAvailable() {
        return this._count.getLo();
    }

    @ManagedAttribute(value = "pending reserved threads", readonly = true)
    public int getPending() {
        return this._count.getHi();
    }

    @ManagedAttribute(value = "idle timeout in ms", readonly = true)
    public long getIdleTimeoutMs() {
        return TimeUnit.NANOSECONDS.toMillis(this._idleTimeNanos);
    }

    public void setIdleTimeout(long idleTime, TimeUnit idleTimeUnit) {
        if (isRunning()) {
            throw new IllegalStateException();
        }
        this._idleTimeNanos = (idleTime <= 0 || idleTimeUnit == null) ? DEFAULT_IDLE_TIMEOUT : idleTimeUnit.toNanos(idleTime);
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._lease = ThreadPoolBudget.leaseFrom(getExecutor(), this, this._capacity);
        this._count.set(0, 0);
        doStart();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (this._lease != null) {
            this._lease.close();
        }
        doStop();
        int size = this._count.getAndSetLo(-1);
        for (int i = 0; i < size; i++) {
            Thread.yield();
            this._queue.offer(STOP);
        }
        this._threads.stream().filter(rec$ -> {
            return ((ReservedThread) rec$).isReserved();
        }).map(t -> {
            return t._thread;
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).forEach((v0) -> {
            v0.interrupt();
        });
        this._threads.clear();
        this._count.getAndSetHi(0);
    }

    @Override // org.eclipse.jetty.util.thread.TryExecutor
    public void execute(Runnable task) throws RejectedExecutionException {
        this._executor.execute(task);
    }

    @Override // org.eclipse.jetty.util.thread.TryExecutor
    public boolean tryExecute(Runnable task) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} tryExecute {}", this, task);
        }
        if (task == null) {
            return false;
        }
        boolean offered = this._queue.offer(task);
        int size = this._count.getLo();
        while (offered && size > 0) {
            size--;
            if (this._count.compareAndSetLo(size, size)) {
                break;
            }
            size = this._count.getLo();
        }
        if (size == 0 && task != STOP) {
            startReservedThread();
        }
        return offered;
    }

    private void startReservedThread() {
        long count;
        int pending;
        int size;
        do {
            count = this._count.get();
            pending = AtomicBiInteger.getHi(count);
            size = AtomicBiInteger.getLo(count);
            if (size >= 0 && pending + size < this._capacity) {
                if (size == 0) {
                    this._lastEmptyTime.set(System.nanoTime());
                }
            } else {
                return;
            }
        } while (!this._count.compareAndSet(count, pending + 1, size));
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} startReservedThread p={}", this, Integer.valueOf(pending + 1));
        }
        try {
            ReservedThread thread = new ReservedThread();
            this._threads.add(thread);
            this._executor.execute(thread);
        } catch (Throwable e) {
            this._count.add(-1, 0);
            LOG.ignore(e);
        }
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, this, new DumpableCollection("threads", (Collection) this._threads.stream().filter(rec$ -> {
            return ((ReservedThread) rec$).isReserved();
        }).collect(Collectors.toList())));
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x{reserved=%d/%d,pending=%d}", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(this._count.getLo()), Integer.valueOf(this._capacity), Integer.valueOf(this._count.getHi()));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ReservedThreadExecutor$ReservedThread.class */
    public class ReservedThread implements Runnable {
        private volatile State _state;
        private volatile Thread _thread;

        private ReservedThread() {
            this._state = State.PENDING;
        }

        /* access modifiers changed from: private */
        public boolean isReserved() {
            return this._state == State.RESERVED;
        }

        private Runnable reservedWait() {
            if (ReservedThreadExecutor.LOG.isDebugEnabled()) {
                ReservedThreadExecutor.LOG.debug("{} waiting {}", this, ReservedThreadExecutor.this);
            }
            while (ReservedThreadExecutor.this._count.getLo() >= 0) {
                try {
                    Runnable task = (Runnable) ReservedThreadExecutor.this._queue.poll(ReservedThreadExecutor.this._idleTimeNanos, TimeUnit.NANOSECONDS);
                    if (ReservedThreadExecutor.LOG.isDebugEnabled()) {
                        ReservedThreadExecutor.LOG.debug("{} task={} {}", this, task, ReservedThreadExecutor.this);
                    }
                    if (task != null) {
                        return task;
                    }
                    int size = ReservedThreadExecutor.this._count.getLo();
                    while (size > 0) {
                        size--;
                        if (ReservedThreadExecutor.this._count.compareAndSetLo(size, size)) {
                            break;
                        }
                        size = ReservedThreadExecutor.this._count.getLo();
                    }
                    this._state = size >= 0 ? State.IDLE : State.STOPPED;
                    return ReservedThreadExecutor.STOP;
                } catch (InterruptedException e) {
                    ReservedThreadExecutor.LOG.ignore(e);
                }
            }
            this._state = State.STOPPED;
            return ReservedThreadExecutor.STOP;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:34:0x011e
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
            // Method dump skipped, instructions count: 438
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.thread.ReservedThreadExecutor.ReservedThread.run():void");
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("%s@%x{%s,thread=%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._state, this._thread);
        }
    }
}
