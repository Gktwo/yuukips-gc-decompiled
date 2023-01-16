package com.zaxxer.hikari.util;

import com.zaxxer.hikari.util.ConcurrentBag.IConcurrentBagEntry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/util/ConcurrentBag.class */
public class ConcurrentBag<T extends IConcurrentBagEntry> implements AutoCloseable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrentBag.class);
    private static final ClockSource CLOCK = ClockSource.INSTANCE;
    private final ThreadLocal<List<Object>> threadList;
    private final IBagStateListener listener;
    private volatile boolean closed;
    private final boolean weakThreadLocals = useWeakThreadLocals();
    private final SynchronousQueue<T> handoffQueue = new SynchronousQueue<>(true);
    private final AtomicInteger waiters = new AtomicInteger();
    private final CopyOnWriteArrayList<T> sharedList = new CopyOnWriteArrayList<>();

    /* loaded from: grasscutter.jar:com/zaxxer/hikari/util/ConcurrentBag$IBagStateListener.class */
    public interface IBagStateListener {
        Future<Boolean> addBagItem(int i);
    }

    /* loaded from: grasscutter.jar:com/zaxxer/hikari/util/ConcurrentBag$IConcurrentBagEntry.class */
    public interface IConcurrentBagEntry {
        public static final int STATE_NOT_IN_USE = 0;
        public static final int STATE_IN_USE = 1;
        public static final int STATE_REMOVED = -1;
        public static final int STATE_RESERVED = -2;

        boolean compareAndSet(int i, int i2);

        void setState(int i);

        int getState();
    }

    public ConcurrentBag(IBagStateListener listener) {
        this.listener = listener;
        if (this.weakThreadLocals) {
            this.threadList = new ThreadLocal<>();
        } else {
            this.threadList = new ThreadLocal<List<Object>>() { // from class: com.zaxxer.hikari.util.ConcurrentBag.1
                /* access modifiers changed from: protected */
                @Override // java.lang.ThreadLocal
                public List<Object> initialValue() {
                    return new FastList(IConcurrentBagEntry.class, 16);
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r0v26, types: [long] */
    /* JADX WARN: Type inference failed for: r0v42, types: [long] */
    public T borrow(long timeout, TimeUnit timeUnit) throws InterruptedException {
        List<Object> list = this.threadList.get();
        if (this.weakThreadLocals && list == null) {
            list = new ArrayList(16);
            this.threadList.set(list);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            Object entry = list.remove(i);
            T bagEntry = this.weakThreadLocals ? (T) ((IConcurrentBagEntry) ((WeakReference) entry).get()) : (T) ((IConcurrentBagEntry) entry);
            if (bagEntry != null && bagEntry.compareAndSet(0, 1)) {
                return bagEntry;
            }
        }
        int waiting = this.waiters.incrementAndGet();
        try {
            Iterator<T> it = this.sharedList.iterator();
            while (it.hasNext()) {
                T bagEntry2 = it.next();
                if (bagEntry2.compareAndSet(0, 1)) {
                    if (waiting > 1) {
                        this.listener.addBagItem(waiting - 1);
                    }
                    return bagEntry2;
                }
            }
            this.listener.addBagItem(waiting);
            char nanos = timeUnit.toNanos(timeout);
            do {
                long start = CLOCK.currentTime();
                T bagEntry3 = this.handoffQueue.poll(nanos, TimeUnit.NANOSECONDS);
                if (bagEntry3 == null || bagEntry3.compareAndSet(0, 1)) {
                    this.waiters.decrementAndGet();
                    return bagEntry3;
                }
                nanos -= CLOCK.elapsedNanos(start);
            } while (nanos > AbstractComponentTracker.LINGERING_TIMEOUT);
            this.waiters.decrementAndGet();
            return null;
        } finally {
            this.waiters.decrementAndGet();
        }
    }

    public void requite(T bagEntry) {
        bagEntry.setState(0);
        int i = 0;
        while (this.waiters.get() > 0) {
            if (bagEntry.getState() == 0 && !this.handoffQueue.offer(bagEntry)) {
                if ((i & 255) == 255) {
                    LockSupport.parkNanos(TimeUnit.MICROSECONDS.toNanos(10));
                } else {
                    Thread.yield();
                }
                i++;
            } else {
                return;
            }
        }
        List<Object> threadLocalList = this.threadList.get();
        if (threadLocalList != null) {
            threadLocalList.add(this.weakThreadLocals ? new WeakReference(bagEntry) : bagEntry);
        }
    }

    public void add(T bagEntry) {
        if (this.closed) {
            LOGGER.info("ConcurrentBag has been closed, ignoring add()");
            throw new IllegalStateException("ConcurrentBag has been closed, ignoring add()");
        }
        this.sharedList.add(bagEntry);
        while (this.waiters.get() > 0 && !this.handoffQueue.offer(bagEntry)) {
            Thread.yield();
        }
    }

    public boolean remove(T bagEntry) {
        if (bagEntry.compareAndSet(1, -1) || bagEntry.compareAndSet(-2, -1) || this.closed) {
            boolean removed = this.sharedList.remove(bagEntry);
            if (!removed && !this.closed) {
                LOGGER.warn("Attempt to remove an object from the bag that does not exist: {}", bagEntry);
            }
            return removed;
        }
        LOGGER.warn("Attempt to remove an object from the bag that was not borrowed or reserved: {}", bagEntry);
        return false;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    public List<T> values(int state) {
        ArrayList<T> list = new ArrayList<>(this.sharedList.size());
        Iterator<T> it = this.sharedList.iterator();
        while (it.hasNext()) {
            T entry = it.next();
            if (entry.getState() == state) {
                list.add(entry);
            }
        }
        return list;
    }

    public List<T> values() {
        return (List) this.sharedList.clone();
    }

    public boolean reserve(T bagEntry) {
        return bagEntry.compareAndSet(0, -2);
    }

    public void unreserve(T bagEntry) {
        if (bagEntry.compareAndSet(-2, 0)) {
            while (this.waiters.get() > 0 && !this.handoffQueue.offer(bagEntry)) {
                Thread.yield();
            }
            return;
        }
        LOGGER.warn("Attempt to relinquish an object to the bag that was not reserved: {}", bagEntry);
    }

    public int getWaitingThreadCount() {
        return this.waiters.get();
    }

    public int getCount(int state) {
        int count = 0;
        Iterator<T> it = this.sharedList.iterator();
        while (it.hasNext()) {
            if (it.next().getState() == state) {
                count++;
            }
        }
        return count;
    }

    public int size() {
        return this.sharedList.size();
    }

    public void dumpState() {
        Iterator<T> it = this.sharedList.iterator();
        while (it.hasNext()) {
            LOGGER.info(it.next().toString());
        }
    }

    private boolean useWeakThreadLocals() {
        try {
            if (System.getProperty("com.zaxxer.hikari.useWeakReferences") != null) {
                return Boolean.getBoolean("com.zaxxer.hikari.useWeakReferences");
            }
            return getClass().getClassLoader() != ClassLoader.getSystemClassLoader();
        } catch (SecurityException e) {
            return true;
        }
    }
}
