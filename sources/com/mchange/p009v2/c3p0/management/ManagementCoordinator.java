package com.mchange.p009v2.c3p0.management;

import com.mchange.p009v2.c3p0.PooledDataSource;

/* renamed from: com.mchange.v2.c3p0.management.ManagementCoordinator */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/management/ManagementCoordinator.class */
public interface ManagementCoordinator {
    void attemptManageC3P0Registry();

    void attemptUnmanageC3P0Registry();

    void attemptManagePooledDataSource(PooledDataSource pooledDataSource);

    void attemptUnmanagePooledDataSource(PooledDataSource pooledDataSource);
}
