package org.eclipse.jetty.util.thread;

import java.io.Closeable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ThreadPool;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ThreadPoolBudget.class */
public class ThreadPoolBudget {
    private static final Logger LOG = Log.getLogger(ThreadPoolBudget.class);
    private static final Lease NOOP_LEASE = new Lease() { // from class: org.eclipse.jetty.util.thread.ThreadPoolBudget.1
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // org.eclipse.jetty.util.thread.ThreadPoolBudget.Lease
        public int getThreads() {
            return 0;
        }
    };
    private final Set<Leased> leases;
    private final AtomicBoolean warned;
    private final ThreadPool.SizedThreadPool pool;
    private final int warnAt;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ThreadPoolBudget$Lease.class */
    public interface Lease extends Closeable {
        int getThreads();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ThreadPoolBudget$Leased.class */
    public class Leased implements Lease {
        private final Object leasee;
        private final int threads;

        private Leased(Object leasee, int threads) {
            this.leasee = leasee;
            this.threads = threads;
        }

        @Override // org.eclipse.jetty.util.thread.ThreadPoolBudget.Lease
        public int getThreads() {
            return this.threads;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            ThreadPoolBudget.this.leases.remove(this);
            ThreadPoolBudget.this.warned.set(false);
        }
    }

    public ThreadPoolBudget(ThreadPool.SizedThreadPool pool) {
        this.leases = new CopyOnWriteArraySet();
        this.warned = new AtomicBoolean();
        this.pool = pool;
        this.warnAt = -1;
    }

    @Deprecated
    public ThreadPoolBudget(ThreadPool.SizedThreadPool pool, int warnAt) {
        this.leases = new CopyOnWriteArraySet();
        this.warned = new AtomicBoolean();
        this.pool = pool;
        this.warnAt = warnAt;
    }

    public ThreadPool.SizedThreadPool getSizedThreadPool() {
        return this.pool;
    }

    @ManagedAttribute("the number of threads leased to components")
    public int getLeasedThreads() {
        return this.leases.stream().mapToInt((v0) -> {
            return v0.getThreads();
        }).sum();
    }

    public void reset() {
        this.leases.clear();
        this.warned.set(false);
    }

    public Lease leaseTo(Object leasee, int threads) {
        Leased lease = new Leased(leasee, threads);
        this.leases.add(lease);
        try {
            check(this.pool.getMaxThreads());
            return lease;
        } catch (IllegalStateException e) {
            lease.close();
            throw e;
        }
    }

    public boolean check(int maxThreads) throws IllegalStateException {
        int required = getLeasedThreads();
        int left = maxThreads - required;
        if (left <= 0) {
            printInfoOnLeases();
            throw new IllegalStateException(String.format("Insufficient configured threads: required=%d < max=%d for %s", Integer.valueOf(required), Integer.valueOf(maxThreads), this.pool));
        } else if (left >= this.warnAt) {
            return true;
        } else {
            if (!this.warned.compareAndSet(false, true)) {
                return false;
            }
            printInfoOnLeases();
            LOG.info("Low configured threads: (max={} - required={})={} < warnAt={} for {}", Integer.valueOf(maxThreads), Integer.valueOf(required), Integer.valueOf(left), Integer.valueOf(this.warnAt), this.pool);
            return false;
        }
    }

    private void printInfoOnLeases() {
        this.leases.forEach(lease -> {
            LOG.info("{} requires {} threads from {}", lease.leasee, Integer.valueOf(lease.getThreads()), this.pool);
        });
    }

    public static Lease leaseFrom(Executor executor, Object leasee, int threads) {
        ThreadPoolBudget budget;
        if (!(executor instanceof ThreadPool.SizedThreadPool) || (budget = ((ThreadPool.SizedThreadPool) executor).getThreadPoolBudget()) == null) {
            return NOOP_LEASE;
        }
        return budget.leaseTo(leasee, threads);
    }
}
