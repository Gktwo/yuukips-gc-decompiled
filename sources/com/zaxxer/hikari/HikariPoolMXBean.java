package com.zaxxer.hikari;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/HikariPoolMXBean.class */
public interface HikariPoolMXBean {
    int getIdleConnections();

    int getActiveConnections();

    int getTotalConnections();

    int getThreadsAwaitingConnection();

    void softEvictConnections();

    void suspendPool();

    void resumePool();
}
