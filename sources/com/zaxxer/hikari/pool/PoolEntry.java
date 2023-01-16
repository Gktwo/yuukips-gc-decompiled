package com.zaxxer.hikari.pool;

import com.zaxxer.hikari.util.ClockSource;
import com.zaxxer.hikari.util.ConcurrentBag;
import com.zaxxer.hikari.util.FastList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jline.builtins.TTop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/PoolEntry.class */
public final class PoolEntry implements ConcurrentBag.IConcurrentBagEntry {
    Connection connection;
    long lastBorrowed;
    private volatile int state;
    private volatile boolean evict;
    private volatile ScheduledFuture<?> endOfLife;
    private final HikariPool hikariPool;
    private final boolean isReadOnly;
    private final boolean isAutoCommit;
    private static final Logger LOGGER = LoggerFactory.getLogger(PoolEntry.class);
    static final Comparator<PoolEntry> LASTACCESS_COMPARABLE = new Comparator<PoolEntry>() { // from class: com.zaxxer.hikari.pool.PoolEntry.1
        public int compare(PoolEntry entryOne, PoolEntry entryTwo) {
            return Long.compare(entryOne.lastAccessed, entryTwo.lastAccessed);
        }
    };
    private static final AtomicIntegerFieldUpdater<PoolEntry> stateUpdater = AtomicIntegerFieldUpdater.newUpdater(PoolEntry.class, TTop.STAT_STATE);
    long lastAccessed = ClockSource.INSTANCE.currentTime();
    private final FastList<Statement> openStatements = new FastList<>(Statement.class, 16);

    /* access modifiers changed from: package-private */
    public PoolEntry(Connection connection, PoolBase pool, boolean isReadOnly, boolean isAutoCommit) {
        this.connection = connection;
        this.hikariPool = (HikariPool) pool;
        this.isReadOnly = isReadOnly;
        this.isAutoCommit = isAutoCommit;
    }

    /* access modifiers changed from: package-private */
    public void recycle(long lastAccessed) {
        if (this.connection != null) {
            this.lastAccessed = lastAccessed;
            this.hikariPool.recycle(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void setFutureEol(ScheduledFuture<?> endOfLife) {
        this.endOfLife = endOfLife;
    }

    /* access modifiers changed from: package-private */
    public Connection createProxyConnection(ProxyLeakTask leakTask, long now) {
        return ProxyFactory.getProxyConnection(this, this.connection, this.openStatements, leakTask, now, this.isReadOnly, this.isAutoCommit);
    }

    /* access modifiers changed from: package-private */
    public void resetConnectionState(ProxyConnection proxyConnection, int dirtyBits) throws SQLException {
        this.hikariPool.resetConnectionState(this.connection, proxyConnection, dirtyBits);
    }

    /* access modifiers changed from: package-private */
    public String getPoolName() {
        return this.hikariPool.toString();
    }

    /* access modifiers changed from: package-private */
    public boolean isMarkedEvicted() {
        return this.evict;
    }

    /* access modifiers changed from: package-private */
    public void markEvicted() {
        this.evict = true;
    }

    /* access modifiers changed from: package-private */
    public void evict(String closureReason) {
        this.hikariPool.closeConnection(this, closureReason);
    }

    /* access modifiers changed from: package-private */
    public long getMillisSinceBorrowed() {
        return ClockSource.INSTANCE.elapsedMillis(this.lastBorrowed);
    }

    public String toString() {
        return this.connection + ", accessed " + ClockSource.INSTANCE.elapsedDisplayString(this.lastAccessed, ClockSource.INSTANCE.currentTime()) + " ago, " + stateToString();
    }

    @Override // com.zaxxer.hikari.util.ConcurrentBag.IConcurrentBagEntry
    public int getState() {
        return stateUpdater.get(this);
    }

    @Override // com.zaxxer.hikari.util.ConcurrentBag.IConcurrentBagEntry
    public boolean compareAndSet(int expect, int update) {
        return stateUpdater.compareAndSet(this, expect, update);
    }

    @Override // com.zaxxer.hikari.util.ConcurrentBag.IConcurrentBagEntry
    public void setState(int update) {
        stateUpdater.set(this, update);
    }

    /* access modifiers changed from: package-private */
    public Connection close() {
        ScheduledFuture<?> eol = this.endOfLife;
        if (eol != null && !eol.isDone() && !eol.cancel(false)) {
            LOGGER.warn("{} - maxLifeTime expiration task cancellation unexpectedly returned false for connection {}", getPoolName(), this.connection);
        }
        Connection con = this.connection;
        this.connection = null;
        this.endOfLife = null;
        return con;
    }

    private String stateToString() {
        switch (this.state) {
            case -2:
                return "RESERVED";
            case -1:
                return "REMOVED";
            case 0:
                return "NOT_IN_USE";
            case 1:
                return "IN_USE";
            default:
                return "Invalid";
        }
    }
}
