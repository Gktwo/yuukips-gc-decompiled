package org.quartz.impl.jdbcjobstore;

import java.sql.Connection;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/Semaphore.class */
public interface Semaphore {
    boolean obtainLock(Connection connection, String str) throws LockException;

    void releaseLock(String str) throws LockException;

    boolean requiresConnection();
}
