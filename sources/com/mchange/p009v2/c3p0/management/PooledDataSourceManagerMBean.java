package com.mchange.p009v2.c3p0.management;

import java.sql.SQLException;
import java.util.Collection;

/* renamed from: com.mchange.v2.c3p0.management.PooledDataSourceManagerMBean */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/management/PooledDataSourceManagerMBean.class */
public interface PooledDataSourceManagerMBean {
    String getIdentityToken();

    String getDataSourceName();

    void setDataSourceName(String str);

    int getNumConnectionsDefaultUser() throws SQLException;

    int getNumIdleConnectionsDefaultUser() throws SQLException;

    int getNumBusyConnectionsDefaultUser() throws SQLException;

    int getNumUnclosedOrphanedConnectionsDefaultUser() throws SQLException;

    float getEffectivePropertyCycleDefaultUser() throws SQLException;

    void softResetDefaultUser() throws SQLException;

    int getNumConnections(String str, String str2) throws SQLException;

    int getNumIdleConnections(String str, String str2) throws SQLException;

    int getNumBusyConnections(String str, String str2) throws SQLException;

    int getNumUnclosedOrphanedConnections(String str, String str2) throws SQLException;

    float getEffectivePropertyCycle(String str, String str2) throws SQLException;

    void softReset(String str, String str2) throws SQLException;

    int getNumBusyConnectionsAllUsers() throws SQLException;

    int getNumIdleConnectionsAllUsers() throws SQLException;

    int getNumConnectionsAllUsers() throws SQLException;

    int getNumUnclosedOrphanedConnectionsAllUsers() throws SQLException;

    int getThreadPoolSize() throws SQLException;

    int getThreadPoolNumActiveThreads() throws SQLException;

    int getThreadPoolNumIdleThreads() throws SQLException;

    int getThreadPoolNumTasksPending() throws SQLException;

    String sampleThreadPoolStackTraces() throws SQLException;

    String sampleThreadPoolStatus() throws SQLException;

    void softResetAllUsers() throws SQLException;

    int getNumUserPools() throws SQLException;

    Collection getAllUsers() throws SQLException;

    void hardReset() throws SQLException;

    void close() throws SQLException;
}
