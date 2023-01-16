package org.eclipse.jetty.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Locker;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Pool.class */
public class Pool<T> implements AutoCloseable, Dumpable {
    private static final Logger LOGGER = Log.getLogger(Pool.class);
    private final List<Pool<T>.Entry> entries;
    private final int maxEntries;
    private final StrategyType strategyType;
    private final Locker locker;
    private final ThreadLocal<Pool<T>.Entry> cache;
    private final AtomicInteger nextIndex;
    private volatile boolean closed;
    @Deprecated
    private volatile int maxUsage;
    @Deprecated
    private volatile int maxMultiplex;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Pool$StrategyType.class */
    public enum StrategyType {
        FIRST,
        RANDOM,
        THREAD_ID,
        ROUND_ROBIN
    }

    public Pool(StrategyType strategyType, int maxEntries) {
        this(strategyType, maxEntries, false);
    }

    public Pool(StrategyType strategyType, int maxEntries, boolean cache) {
        this.entries = new CopyOnWriteArrayList();
        this.locker = new Locker();
        this.maxUsage = -1;
        this.maxMultiplex = -1;
        this.maxEntries = maxEntries;
        this.strategyType = strategyType;
        this.cache = cache ? new ThreadLocal<>() : null;
        this.nextIndex = strategyType == StrategyType.ROUND_ROBIN ? new AtomicInteger() : null;
    }

    @ManagedAttribute("The number of reserved entries")
    public int getReservedCount() {
        return (int) this.entries.stream().filter((v0) -> {
            return v0.isReserved();
        }).count();
    }

    @ManagedAttribute("The number of idle entries")
    public int getIdleCount() {
        return (int) this.entries.stream().filter((v0) -> {
            return v0.isIdle();
        }).count();
    }

    @ManagedAttribute("The number of in-use entries")
    public int getInUseCount() {
        return (int) this.entries.stream().filter((v0) -> {
            return v0.isInUse();
        }).count();
    }

    @ManagedAttribute("The number of closed entries")
    public int getClosedCount() {
        return (int) this.entries.stream().filter((v0) -> {
            return v0.isClosed();
        }).count();
    }

    @ManagedAttribute("The maximum number of entries")
    public int getMaxEntries() {
        return this.maxEntries;
    }

    @ManagedAttribute("The default maximum multiplex count of entries")
    @Deprecated
    public int getMaxMultiplex() {
        if (this.maxMultiplex == -1) {
            return 1;
        }
        return this.maxMultiplex;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int getMaxMultiplex(T pooled) {
        return getMaxMultiplex();
    }

    @Deprecated
    public final void setMaxMultiplex(int maxMultiplex) {
        if (maxMultiplex < 1) {
            throw new IllegalArgumentException("Max multiplex must be >= 1");
        }
        Locker.Lock l = this.locker.lock();
        try {
            if (!this.closed) {
                Stream<Pool<T>.Entry> stream = this.entries.stream();
                Objects.requireNonNull(MonoEntry.class);
                if (stream.anyMatch((v1) -> {
                    return r1.isInstance(v1);
                })) {
                    throw new IllegalStateException("Pool entries do not support multiplexing");
                }
                this.maxMultiplex = maxMultiplex;
                if (l != null) {
                    l.close();
                }
            } else if (l != null) {
                l.close();
            }
        } catch (Throwable th) {
            if (l != null) {
                try {
                    l.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @ManagedAttribute("The default maximum usage count of entries")
    @Deprecated
    public int getMaxUsageCount() {
        return this.maxUsage;
    }

    @Deprecated
    protected int getMaxUsageCount(T pooled) {
        return getMaxUsageCount();
    }

    @Deprecated
    public final void setMaxUsageCount(int maxUsageCount) {
        if (maxUsageCount == 0) {
            throw new IllegalArgumentException("Max usage count must be != 0");
        }
        Locker.Lock l = this.locker.lock();
        try {
            if (!this.closed) {
                Stream<Pool<T>.Entry> stream = this.entries.stream();
                Objects.requireNonNull(MonoEntry.class);
                if (stream.anyMatch((v1) -> {
                    return r1.isInstance(v1);
                })) {
                    throw new IllegalStateException("Pool entries do not support max usage");
                }
                this.maxUsage = maxUsageCount;
                List<Closeable> copy = (List) this.entries.stream().filter(entry -> {
                    return entry.isIdleAndOverUsed() && remove(entry) && (entry.pooled instanceof Closeable);
                }).map(entry -> {
                    return (Closeable) entry.pooled;
                }).collect(Collectors.toList());
                if (l != null) {
                    l.close();
                }
                copy.forEach(C5747IO::close);
            } else if (l != null) {
                l.close();
            }
        } catch (Throwable th) {
            if (l != null) {
                try {
                    l.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Deprecated
    public Pool<T>.Entry reserve(int allotment) {
        Locker.Lock l = this.locker.lock();
        try {
            if (this.closed) {
                if (l != null) {
                    l.close();
                }
                return null;
            } else if (this.maxEntries - this.entries.size() <= 0) {
                if (l != null) {
                    l.close();
                }
                return null;
            } else if (allotment < 0 || getReservedCount() * getMaxMultiplex() < allotment) {
                Pool<T>.Entry entry = newEntry();
                this.entries.add(entry);
                if (l != null) {
                    l.close();
                }
                return entry;
            } else {
                if (l != null) {
                    l.close();
                }
                return null;
            }
        } catch (Throwable th) {
            if (l != null) {
                try {
                    l.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public Pool<T>.Entry reserve() {
        Locker.Lock l = this.locker.lock();
        try {
            if (this.closed) {
                if (l != null) {
                    l.close();
                }
                return null;
            } else if (this.entries.size() >= this.maxEntries) {
                if (l != null) {
                    l.close();
                }
                return null;
            } else {
                Pool<T>.Entry entry = newEntry();
                this.entries.add(entry);
                if (l != null) {
                    l.close();
                }
                return entry;
            }
        } catch (Throwable th) {
            if (l != null) {
                try {
                    l.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private Pool<T>.Entry newEntry() {
        if (this.maxMultiplex >= 0 || this.maxUsage >= 0) {
            return new MultiEntry();
        }
        return new MonoEntry();
    }

    @Deprecated
    public Pool<T>.Entry acquireAt(int idx) {
        if (this.closed) {
            return null;
        }
        try {
            Pool<T>.Entry entry = this.entries.get(idx);
            if (entry.tryAcquire()) {
                return entry;
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Pool<T>.Entry acquire() {
        Pool<T>.Entry entry;
        if (this.closed) {
            return null;
        }
        int size = this.entries.size();
        if (size == 0) {
            return null;
        }
        if (this.cache != null && (entry = this.cache.get()) != null && entry.tryAcquire()) {
            return entry;
        }
        int index = startIndex(size);
        int tries = size;
        while (true) {
            tries--;
            if (tries <= 0) {
                return null;
            }
            try {
                Pool<T>.Entry entry2 = this.entries.get(index);
                if (entry2 != null && entry2.tryAcquire()) {
                    return entry2;
                }
            } catch (IndexOutOfBoundsException e) {
                LOGGER.ignore(e);
                size = this.entries.size();
                if (size == 0) {
                    return null;
                }
            }
            index = (index + 1) % size;
        }
    }

    private int startIndex(int size) {
        switch (this.strategyType) {
            case FIRST:
                return 0;
            case RANDOM:
                return ThreadLocalRandom.current().nextInt(size);
            case ROUND_ROBIN:
                return this.nextIndex.getAndUpdate(c -> {
                    return Math.max(0, c + 1);
                }) % size;
            case THREAD_ID:
                return (int) (Thread.currentThread().getId() % ((long) size));
            default:
                throw new IllegalArgumentException("Unknown strategy type: " + this.strategyType);
        }
    }

    /* JADX INFO: finally extract failed */
    public Pool<T>.Entry acquire(Function<Pool<T>.Entry, T> creator) {
        Pool<T>.Entry entry = acquire();
        if (entry != null) {
            return entry;
        }
        Pool<T>.Entry entry2 = reserve();
        if (entry2 == null) {
            return null;
        }
        try {
            T value = creator.apply(entry2);
            if (value == null) {
                remove(entry2);
                return null;
            } else if (entry2.enable(value, true)) {
                return entry2;
            } else {
                return null;
            }
        } catch (Throwable th) {
            remove(entry2);
            throw th;
        }
    }

    public boolean release(Pool<T>.Entry entry) {
        if (this.closed) {
            return false;
        }
        boolean released = entry.tryRelease();
        if (released && this.cache != null) {
            this.cache.set(entry);
        }
        return released;
    }

    public boolean remove(Pool<T>.Entry entry) {
        if (this.closed) {
            return false;
        }
        if (entry.tryRemove()) {
            boolean removed = this.entries.remove(entry);
            if (!removed && LOGGER.isDebugEnabled()) {
                LOGGER.debug("Attempt to remove an object from the pool that does not exist: {}", entry);
            }
            return removed;
        } else if (!LOGGER.isDebugEnabled()) {
            return false;
        } else {
            LOGGER.debug("Attempt to remove an object from the pool that is still in use: {}", entry);
            return false;
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Locker.Lock l = this.locker.lock();
        try {
            this.closed = true;
            List<Pool<T>.Entry> copy = new ArrayList<>(this.entries);
            this.entries.clear();
            if (l != null) {
                l.close();
            }
            for (Pool<T>.Entry entry : copy) {
                if (entry.tryRemove()) {
                    if (((Entry) entry).pooled instanceof Closeable) {
                        C5747IO.close((Closeable) ((Entry) entry).pooled);
                    }
                } else if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Pooled object still in use: {}", entry);
                }
            }
        } catch (Throwable th) {
            if (l != null) {
                try {
                    l.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public int size() {
        return this.entries.size();
    }

    public Collection<Pool<T>.Entry> values() {
        return Collections.unmodifiableCollection(this.entries);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, this, new DumpableCollection("entries", this.entries));
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("%s@%x[inUse=%d,size=%d,capacity=%d,closed=%b]", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getInUseCount()), Integer.valueOf(size()), Integer.valueOf(getMaxEntries()), Boolean.valueOf(isClosed()));
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Pool$Entry.class */
    public abstract class Entry {
        private T pooled;

        abstract boolean tryEnable(boolean z);

        abstract boolean tryAcquire();

        abstract boolean tryRelease();

        abstract boolean tryRemove();

        public abstract boolean isClosed();

        public abstract boolean isReserved();

        public abstract boolean isIdle();

        public abstract boolean isInUse();

        public Entry() {
        }

        public boolean enable(T pooled, boolean acquire) {
            Objects.requireNonNull(pooled);
            if (isReserved()) {
                this.pooled = pooled;
                if (tryEnable(acquire)) {
                    return true;
                }
                this.pooled = null;
                if (isClosed()) {
                    return false;
                }
                throw new IllegalStateException("Entry already enabled: " + this);
            } else if (isClosed()) {
                return false;
            } else {
                throw new IllegalStateException("Entry already enabled: " + this);
            }
        }

        public T getPooled() {
            return this.pooled;
        }

        public boolean release() {
            return Pool.this.release(this);
        }

        public boolean remove() {
            return Pool.this.remove(this);
        }

        @Deprecated
        public boolean isOverUsed() {
            return false;
        }

        boolean isIdleAndOverUsed() {
            return false;
        }

        int getUsageCount() {
            return 0;
        }

        void setUsageCount(int usageCount) {
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Pool$MonoEntry.class */
    public class MonoEntry extends Pool<T>.Entry {
        private final AtomicInteger state;

        private MonoEntry() {
            super();
            this.state = new AtomicInteger(Integer.MIN_VALUE);
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        protected boolean tryEnable(boolean acquire) {
            return this.state.compareAndSet(Integer.MIN_VALUE, acquire ? 1 : 0);
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        boolean tryAcquire() {
            int s;
            do {
                s = this.state.get();
                if (s != 0) {
                    return false;
                }
            } while (!this.state.compareAndSet(s, 1));
            return true;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        boolean tryRelease() {
            int s;
            do {
                s = this.state.get();
                if (s < 0) {
                    return false;
                }
                if (s == 0) {
                    throw new IllegalStateException("Cannot release an already released entry");
                }
            } while (!this.state.compareAndSet(s, 0));
            return true;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        boolean tryRemove() {
            this.state.set(-1);
            return true;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        public boolean isClosed() {
            return this.state.get() < 0;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        public boolean isReserved() {
            return this.state.get() == Integer.MIN_VALUE;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        public boolean isIdle() {
            return this.state.get() == 0;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        public boolean isInUse() {
            return this.state.get() == 1;
        }

        public String toString() {
            String s;
            switch (this.state.get()) {
                case Integer.MIN_VALUE:
                    s = "PENDING";
                    break;
                case -1:
                    s = "CLOSED";
                    break;
                case 0:
                    s = "IDLE";
                    break;
                default:
                    s = "ACTIVE";
                    break;
            }
            return String.format("%s@%x{%s,pooled=%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), s, getPooled());
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Pool$MultiEntry.class */
    public class MultiEntry extends Pool<T>.Entry {
        private final AtomicBiInteger state = new AtomicBiInteger(Integer.MIN_VALUE, 0);

        MultiEntry() {
            super();
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        void setUsageCount(int usageCount) {
            this.state.getAndSetHi(usageCount);
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        protected boolean tryEnable(boolean acquire) {
            int usage = acquire ? 1 : 0;
            return this.state.compareAndSet(Integer.MIN_VALUE, usage, 0, usage);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: org.eclipse.jetty.util.Pool */
        /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: org.eclipse.jetty.util.Pool */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.eclipse.jetty.util.Pool.Entry
        boolean tryAcquire() {
            long encoded;
            int usageCount;
            int multiplexCount;
            do {
                encoded = this.state.get();
                usageCount = AtomicBiInteger.getHi(encoded);
                multiplexCount = AtomicBiInteger.getLo(encoded);
                if (usageCount < 0) {
                    return false;
                }
                Object pooled = getPooled();
                int maxUsageCount = Pool.this.getMaxUsageCount(pooled);
                int maxMultiplexed = Pool.this.getMaxMultiplex(pooled);
                if (maxMultiplexed > 0 && multiplexCount >= maxMultiplexed) {
                    return false;
                }
                if (maxUsageCount > 0 && usageCount >= maxUsageCount) {
                    return false;
                }
            } while (!this.state.compareAndSet(encoded, usageCount == Integer.MAX_VALUE ? Integer.MAX_VALUE : usageCount + 1, multiplexCount + 1));
            return true;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        boolean tryRelease() {
            long encoded;
            int usageCount;
            int newMultiplexCount;
            do {
                encoded = this.state.get();
                usageCount = AtomicBiInteger.getHi(encoded);
                if (usageCount < 0) {
                    return false;
                }
                newMultiplexCount = AtomicBiInteger.getLo(encoded) - 1;
                if (newMultiplexCount < 0) {
                    throw new IllegalStateException("Cannot release an already released entry");
                }
            } while (!this.state.compareAndSet(encoded, usageCount, newMultiplexCount));
            int currentMaxUsageCount = Pool.this.maxUsage;
            return !(currentMaxUsageCount > 0 && usageCount >= currentMaxUsageCount) || newMultiplexCount != 0;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        boolean tryRemove() {
            int usageCount;
            int multiplexCount;
            int newMultiplexCount;
            do {
                long encoded = this.state.get();
                usageCount = AtomicBiInteger.getHi(encoded);
                multiplexCount = AtomicBiInteger.getLo(encoded);
                newMultiplexCount = Math.max(multiplexCount - 1, 0);
            } while (!this.state.compareAndSet(usageCount, -1, multiplexCount, newMultiplexCount));
            return newMultiplexCount == 0;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        public boolean isClosed() {
            return this.state.getHi() < 0;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        public boolean isReserved() {
            return this.state.getHi() == Integer.MIN_VALUE;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        public boolean isIdle() {
            long encoded = this.state.get();
            return AtomicBiInteger.getHi(encoded) >= 0 && AtomicBiInteger.getLo(encoded) == 0;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        public boolean isInUse() {
            long encoded = this.state.get();
            return AtomicBiInteger.getHi(encoded) >= 0 && AtomicBiInteger.getLo(encoded) > 0;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        public boolean isOverUsed() {
            int maxUsageCount = Pool.this.getMaxUsageCount();
            return maxUsageCount > 0 && this.state.getHi() >= maxUsageCount;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        boolean isIdleAndOverUsed() {
            int maxUsageCount = Pool.this.getMaxUsageCount();
            long encoded = this.state.get();
            return maxUsageCount > 0 && AtomicBiInteger.getHi(encoded) >= maxUsageCount && AtomicBiInteger.getLo(encoded) == 0;
        }

        @Override // org.eclipse.jetty.util.Pool.Entry
        int getUsageCount() {
            return Math.max(this.state.getHi(), 0);
        }

        public String toString() {
            String state;
            long encoded = this.state.get();
            int usageCount = AtomicBiInteger.getHi(encoded);
            int multiplexCount = AtomicBiInteger.getLo(encoded);
            if (usageCount < 0) {
                state = usageCount == Integer.MIN_VALUE ? "PENDING" : "CLOSED";
            } else {
                state = multiplexCount == 0 ? "IDLE" : "ACTIVE";
            }
            return String.format("%s@%x{%s,usage=%d,multiplex=%d,pooled=%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), state, Integer.valueOf(Math.max(usageCount, 0)), Integer.valueOf(Math.max(multiplexCount, 0)), getPooled());
        }
    }
}
