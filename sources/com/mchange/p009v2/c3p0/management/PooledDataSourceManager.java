package com.mchange.p009v2.c3p0.management;

import com.mchange.p009v2.c3p0.PooledDataSource;
import java.sql.SQLException;
import java.util.Collection;

/* renamed from: com.mchange.v2.c3p0.management.PooledDataSourceManager */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/management/PooledDataSourceManager.class */
public class PooledDataSourceManager implements PooledDataSourceManagerMBean {
    PooledDataSource pds;

    public PooledDataSourceManager(PooledDataSource pds) {
        this.pds = pds;
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public String getIdentityToken() {
        return this.pds.getIdentityToken();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public String getDataSourceName() {
        return this.pds.getDataSourceName();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public void setDataSourceName(String dataSourceName) {
        this.pds.setDataSourceName(dataSourceName);
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumConnectionsDefaultUser() throws SQLException {
        return this.pds.getNumConnectionsDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumIdleConnectionsDefaultUser() throws SQLException {
        return this.pds.getNumIdleConnectionsDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumBusyConnectionsDefaultUser() throws SQLException {
        return this.pds.getNumBusyConnectionsDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumUnclosedOrphanedConnectionsDefaultUser() throws SQLException {
        return this.pds.getNumUnclosedOrphanedConnectionsDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public float getEffectivePropertyCycleDefaultUser() throws SQLException {
        return this.pds.getEffectivePropertyCycleDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getThreadPoolSize() throws SQLException {
        return this.pds.getThreadPoolSize();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getThreadPoolNumActiveThreads() throws SQLException {
        return this.pds.getThreadPoolNumActiveThreads();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getThreadPoolNumIdleThreads() throws SQLException {
        return this.pds.getThreadPoolNumIdleThreads();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getThreadPoolNumTasksPending() throws SQLException {
        return this.pds.getThreadPoolNumTasksPending();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public String sampleThreadPoolStackTraces() throws SQLException {
        return this.pds.sampleThreadPoolStackTraces();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public String sampleThreadPoolStatus() throws SQLException {
        return this.pds.sampleThreadPoolStatus();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public void softResetDefaultUser() throws SQLException {
        this.pds.softResetDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumConnections(String username, String password) throws SQLException {
        return this.pds.getNumConnections(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumIdleConnections(String username, String password) throws SQLException {
        return this.pds.getNumIdleConnections(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumBusyConnections(String username, String password) throws SQLException {
        return this.pds.getNumBusyConnections(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumUnclosedOrphanedConnections(String username, String password) throws SQLException {
        return this.pds.getNumUnclosedOrphanedConnections(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public float getEffectivePropertyCycle(String username, String password) throws SQLException {
        return this.pds.getEffectivePropertyCycle(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public void softReset(String username, String password) throws SQLException {
        this.pds.softReset(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumBusyConnectionsAllUsers() throws SQLException {
        return this.pds.getNumBusyConnectionsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumIdleConnectionsAllUsers() throws SQLException {
        return this.pds.getNumIdleConnectionsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumConnectionsAllUsers() throws SQLException {
        return this.pds.getNumConnectionsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumUnclosedOrphanedConnectionsAllUsers() throws SQLException {
        return this.pds.getNumUnclosedOrphanedConnectionsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public void softResetAllUsers() throws SQLException {
        this.pds.softResetAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public int getNumUserPools() throws SQLException {
        return this.pds.getNumUserPools();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public Collection getAllUsers() throws SQLException {
        return this.pds.getAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public void hardReset() throws SQLException {
        this.pds.hardReset();
    }

    @Override // com.mchange.p009v2.c3p0.management.PooledDataSourceManagerMBean
    public void close() throws SQLException {
        this.pds.close();
    }
}
