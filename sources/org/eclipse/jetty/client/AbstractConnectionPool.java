package org.eclipse.jetty.client;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.eclipse.jetty.client.api.Connection;
import org.eclipse.jetty.client.api.Destination;
import org.eclipse.jetty.util.Attachable;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.Pool;
import org.eclipse.jetty.util.Promise;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Sweeper;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/AbstractConnectionPool.class */
public abstract class AbstractConnectionPool extends ContainerLifeCycle implements ConnectionPool, Dumpable, Sweeper.Sweepable {
    private static final Logger LOG = Log.getLogger(AbstractConnectionPool.class);
    private final AtomicInteger pending;
    private final HttpDestination destination;
    private final Callback requester;
    private final Pool<Connection> pool;
    private boolean maximizeConnections;
    private volatile long maxDurationNanos;

    @Deprecated
    protected AbstractConnectionPool(Destination destination, int maxConnections, Callback requester) {
        this((HttpDestination) destination, maxConnections, false, requester);
    }

    protected AbstractConnectionPool(HttpDestination destination, int maxConnections, boolean cache, Callback requester) {
        this(destination, Pool.StrategyType.FIRST, maxConnections, cache, requester);
    }

    /* access modifiers changed from: protected */
    public AbstractConnectionPool(HttpDestination destination, Pool.StrategyType strategy, int maxConnections, boolean cache, Callback requester) {
        this(destination, new Pool(strategy, maxConnections, cache), requester);
    }

    /* access modifiers changed from: protected */
    public AbstractConnectionPool(HttpDestination destination, Pool<Connection> pool, Callback requester) {
        this.pending = new AtomicInteger();
        this.maxDurationNanos = 0;
        this.destination = destination;
        this.requester = requester;
        this.pool = pool;
        pool.setMaxMultiplex(1);
        addBean(pool);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this.pool.close();
    }

    @Override // org.eclipse.jetty.client.ConnectionPool
    public CompletableFuture<Void> preCreateConnections(int connectionCount) {
        Pool<Connection>.Entry entry;
        if (LOG.isDebugEnabled()) {
            LOG.debug("Pre-creating connections {}/{}", Integer.valueOf(connectionCount), Integer.valueOf(getMaxConnectionCount()));
        }
        List<CompletableFuture<?>> futures = new ArrayList<>();
        for (int i = 0; i < connectionCount && (entry = this.pool.reserve()) != null; i++) {
            this.pending.incrementAndGet();
            Promise.Completable<Connection> future = new FutureConnection(entry);
            futures.add(future);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Pre-creating connection {}/{} at {}", Integer.valueOf(futures.size()), Integer.valueOf(getMaxConnectionCount()), entry);
            }
            this.destination.newConnection(future);
        }
        return CompletableFuture.allOf((CompletableFuture[]) futures.toArray(new CompletableFuture[0]));
    }

    @ManagedAttribute("The maximum duration in milliseconds a connection can be used for before it gets closed")
    public long getMaxDuration() {
        return TimeUnit.NANOSECONDS.toMillis(this.maxDurationNanos);
    }

    public void setMaxDuration(long maxDurationInMs) {
        this.maxDurationNanos = TimeUnit.MILLISECONDS.toNanos(maxDurationInMs);
    }

    /* access modifiers changed from: protected */
    public int getMaxMultiplex() {
        return this.pool.getMaxMultiplex();
    }

    /* access modifiers changed from: protected */
    public void setMaxMultiplex(int maxMultiplex) {
        this.pool.setMaxMultiplex(maxMultiplex);
    }

    /* access modifiers changed from: protected */
    public int getMaxUsageCount() {
        return this.pool.getMaxUsageCount();
    }

    /* access modifiers changed from: protected */
    public void setMaxUsageCount(int maxUsageCount) {
        this.pool.setMaxUsageCount(maxUsageCount);
    }

    @ManagedAttribute(value = "The number of active connections", readonly = true)
    public int getActiveConnectionCount() {
        return this.pool.getInUseCount();
    }

    @ManagedAttribute(value = "The number of idle connections", readonly = true)
    public int getIdleConnectionCount() {
        return this.pool.getIdleCount();
    }

    @ManagedAttribute(value = "The max number of connections", readonly = true)
    public int getMaxConnectionCount() {
        return this.pool.getMaxEntries();
    }

    @ManagedAttribute(value = "The number of connections", readonly = true)
    public int getConnectionCount() {
        return this.pool.size();
    }

    @ManagedAttribute(value = "The number of pending connections", readonly = true)
    @Deprecated
    public int getPendingCount() {
        return getPendingConnectionCount();
    }

    @ManagedAttribute(value = "The number of pending connections", readonly = true)
    public int getPendingConnectionCount() {
        return this.pending.get();
    }

    @Override // org.eclipse.jetty.client.ConnectionPool
    public boolean isEmpty() {
        return this.pool.size() == 0;
    }

    @Override // org.eclipse.jetty.client.ConnectionPool
    @ManagedAttribute("Whether this pool is closed")
    public boolean isClosed() {
        return this.pool.isClosed();
    }

    @ManagedAttribute("Whether the pool tries to maximize the number of connections used")
    public boolean isMaximizeConnections() {
        return this.maximizeConnections;
    }

    public void setMaximizeConnections(boolean maximizeConnections) {
        this.maximizeConnections = maximizeConnections;
    }

    @Override // org.eclipse.jetty.client.ConnectionPool
    public Connection acquire() {
        return acquire(true);
    }

    /* access modifiers changed from: protected */
    public Connection acquire(boolean create) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Acquiring create={} on {}", Boolean.valueOf(create), this);
        }
        Connection connection = activate();
        if (connection == null) {
            tryCreate(create);
            connection = activate();
        }
        return connection;
    }

    protected void tryCreate(boolean create) {
        int pending;
        int connectionCount = getConnectionCount();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Try creating connection {}/{} with {} pending", Integer.valueOf(connectionCount), Integer.valueOf(getMaxConnectionCount()), Integer.valueOf(getPendingConnectionCount()));
        }
        int multiplexed = getMaxMultiplex();
        do {
            pending = this.pending.get();
            int supply = pending * multiplexed;
            int demand = this.destination.getQueuedRequestCount() + (create ? 1 : 0);
            boolean tryCreate = isMaximizeConnections() || supply < demand;
            if (LOG.isDebugEnabled()) {
                LOG.debug("Try creating({}) connection, pending/demand/supply: {}/{}/{}, result={}", Boolean.valueOf(create), Integer.valueOf(pending), Integer.valueOf(demand), Integer.valueOf(supply), Boolean.valueOf(tryCreate));
            }
            if (!tryCreate) {
                return;
            }
        } while (!this.pending.compareAndSet(pending, pending + 1));
        Pool<Connection>.Entry entry = this.pool.reserve();
        if (entry == null) {
            this.pending.decrementAndGet();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Not creating connection as pool is full, pending: {}", this.pending);
                return;
            }
            return;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Creating connection {}/{} at {}", Integer.valueOf(connectionCount), Integer.valueOf(getMaxConnectionCount()), entry);
        }
        this.destination.newConnection(new FutureConnection(entry));
    }

    protected void proceed() {
        this.requester.succeeded();
    }

    protected Connection activate() {
        Pool<Connection>.Entry entry;
        Connection connection;
        while (true) {
            entry = this.pool.acquire();
            if (entry == null) {
                return null;
            }
            connection = entry.getPooled();
            long maxDurationNanos = this.maxDurationNanos;
            if (maxDurationNanos <= 0 || !((EntryHolder) ((Attachable) connection).getAttachment()).isExpired(maxDurationNanos)) {
                break;
            }
            boolean canClose = remove(connection);
            if (canClose) {
                C5739IO.close(connection);
            }
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                Object[] objArr = new Object[3];
                objArr[0] = canClose ? " and closed" : "";
                objArr[1] = entry;
                objArr[2] = this.pool;
                logger.debug("Connection removed{} due to expiration {} {}", objArr);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Activated {} {}", entry, this.pool);
        }
        acquired(connection);
        return connection;
    }

    @Override // org.eclipse.jetty.client.ConnectionPool
    public boolean isActive(Connection connection) {
        if (!(connection instanceof Attachable)) {
            throw new IllegalArgumentException("Invalid connection object: " + connection);
        }
        EntryHolder holder = (EntryHolder) ((Attachable) connection).getAttachment();
        return holder != null && !holder.entry.isIdle();
    }

    @Override // org.eclipse.jetty.client.ConnectionPool
    public boolean release(Connection connection) {
        if (!deactivate(connection)) {
            return false;
        }
        released(connection);
        return idle(connection, isClosed());
    }

    protected boolean deactivate(Connection connection) {
        if (!(connection instanceof Attachable)) {
            throw new IllegalArgumentException("Invalid connection object: " + connection);
        }
        EntryHolder holder = (EntryHolder) ((Attachable) connection).getAttachment();
        if (holder == null) {
            return true;
        }
        long maxDurationNanos = this.maxDurationNanos;
        if (maxDurationNanos > 0 && holder.isExpired(maxDurationNanos)) {
            return !remove(connection);
        }
        boolean reusable = this.pool.release(holder.entry);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Released ({}) {} {}", Boolean.valueOf(reusable), holder.entry, this.pool);
        }
        return reusable || !remove(connection);
    }

    @Override // org.eclipse.jetty.client.ConnectionPool
    public boolean remove(Connection connection) {
        if (!(connection instanceof Attachable)) {
            throw new IllegalArgumentException("Invalid connection object: " + connection);
        }
        Attachable attachable = (Attachable) connection;
        EntryHolder holder = (EntryHolder) attachable.getAttachment();
        if (holder == null) {
            return false;
        }
        boolean removed = this.pool.remove(holder.entry);
        if (removed) {
            attachable.setAttachment(null);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Removed ({}) {} {}", Boolean.valueOf(removed), holder.entry, this.pool);
        }
        if (removed) {
            released(connection);
            removed(connection);
        }
        return removed;
    }

    @Deprecated
    protected boolean remove(Connection connection, boolean force) {
        return remove(connection);
    }

    protected void onCreated(Connection connection) {
    }

    protected boolean idle(Connection connection, boolean close) {
        return !close;
    }

    protected void acquired(Connection connection) {
    }

    protected void released(Connection connection) {
    }

    protected void removed(Connection connection) {
    }

    @Deprecated
    public Queue<Connection> getIdleConnections() {
        return (Queue) this.pool.values().stream().filter((v0) -> {
            return v0.isIdle();
        }).filter(entry -> {
            return !entry.isClosed();
        }).map((v0) -> {
            return v0.getPooled();
        }).collect(Collectors.toCollection(ArrayDeque::new));
    }

    @Deprecated
    public Collection<Connection> getActiveConnections() {
        return (Collection) this.pool.values().stream().filter(entry -> {
            return !entry.isIdle();
        }).filter(entry -> {
            return !entry.isClosed();
        }).map((v0) -> {
            return v0.getPooled();
        }).collect(Collectors.toList());
    }

    @Override // org.eclipse.jetty.client.ConnectionPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.pool.close();
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, this, new Object[0]);
    }

    @Override // org.eclipse.jetty.util.thread.Sweeper.Sweepable
    public boolean sweep() {
        this.pool.values().stream().map((v0) -> {
            return v0.getPooled();
        }).filter(connection -> {
            return connection instanceof Sweeper.Sweepable;
        }).forEach(connection -> {
            if (((Sweeper.Sweepable) connection).sweep()) {
                boolean removed = remove(connection);
                Logger logger = LOG;
                Object[] objArr = new Object[5];
                objArr[0] = connection;
                objArr[1] = System.lineSeparator();
                objArr[2] = removed ? "Removed" : "Not removed";
                objArr[3] = System.lineSeparator();
                objArr[4] = dump();
                logger.warn("Connection swept: {}{}{} from active connections{}{}", objArr);
            }
        });
        return false;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x[c=%d/%d/%d,a=%d,i=%d,q=%d]", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getPendingConnectionCount()), Integer.valueOf(getConnectionCount()), Integer.valueOf(getMaxConnectionCount()), Integer.valueOf(getActiveConnectionCount()), Integer.valueOf(getIdleConnectionCount()), Integer.valueOf(this.destination.getQueuedRequestCount()));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/AbstractConnectionPool$FutureConnection.class */
    public class FutureConnection extends Promise.Completable<Connection> {
        private final Pool<Connection>.Entry reserved;

        public FutureConnection(Pool<Connection>.Entry reserved) {
            this.reserved = reserved;
        }

        public void succeeded(Connection connection) {
            if (AbstractConnectionPool.LOG.isDebugEnabled()) {
                AbstractConnectionPool.LOG.debug("Connection creation succeeded {}: {}", this.reserved, connection);
            }
            if (connection instanceof Attachable) {
                ((Attachable) connection).setAttachment(new EntryHolder(this.reserved));
                AbstractConnectionPool.this.onCreated(connection);
                AbstractConnectionPool.this.pending.decrementAndGet();
                this.reserved.enable(connection, false);
                AbstractConnectionPool.this.idle(connection, false);
                complete(null);
                AbstractConnectionPool.this.proceed();
                return;
            }
            failed(new IllegalArgumentException("Invalid connection object: " + connection));
        }

        @Override // org.eclipse.jetty.util.Promise.Completable, org.eclipse.jetty.util.Promise
        public void failed(Throwable x) {
            if (AbstractConnectionPool.LOG.isDebugEnabled()) {
                AbstractConnectionPool.LOG.debug("Connection creation failed {}", this.reserved, x);
            }
            AbstractConnectionPool.this.pending.decrementAndGet();
            this.reserved.remove();
            completeExceptionally(x);
            AbstractConnectionPool.this.requester.failed(x);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/AbstractConnectionPool$EntryHolder.class */
    public static class EntryHolder {
        private final Pool<Connection>.Entry entry;
        private final long creationTimestamp;

        private EntryHolder(Pool<Connection>.Entry entry) {
            this.creationTimestamp = System.nanoTime();
            this.entry = (Pool.Entry) Objects.requireNonNull(entry);
        }

        /* access modifiers changed from: private */
        public boolean isExpired(long timeoutNanos) {
            return System.nanoTime() - this.creationTimestamp >= timeoutNanos;
        }
    }
}
