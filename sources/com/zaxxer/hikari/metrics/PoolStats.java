package com.zaxxer.hikari.metrics;

import com.zaxxer.hikari.util.ClockSource;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/metrics/PoolStats.class */
public abstract class PoolStats {
    private final long timeoutMs;
    protected volatile int totalConnections;
    protected volatile int idleConnections;
    protected volatile int activeConnections;
    protected volatile int pendingThreads;
    private final AtomicLong reloadAt = new AtomicLong();
    private final ClockSource clock = ClockSource.INSTANCE;

    protected abstract void update();

    public PoolStats(long timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    public int getTotalConnections() {
        if (shouldLoad()) {
            update();
        }
        return this.totalConnections;
    }

    public int getIdleConnections() {
        if (shouldLoad()) {
            update();
        }
        return this.idleConnections;
    }

    public int getActiveConnections() {
        if (shouldLoad()) {
            update();
        }
        return this.activeConnections;
    }

    public int getPendingThreads() {
        if (shouldLoad()) {
            update();
        }
        return this.pendingThreads;
    }

    private boolean shouldLoad() {
        long now;
        long reloadTime;
        do {
            now = this.clock.currentTime();
            reloadTime = this.reloadAt.get();
            if (reloadTime > now) {
                return false;
            }
        } while (!this.reloadAt.compareAndSet(reloadTime, this.clock.plusMillis(now, this.timeoutMs)));
        return true;
    }
}
