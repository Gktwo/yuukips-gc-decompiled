package com.mchange.p009v2.c3p0.management;

import com.mchange.p009v2.c3p0.PooledDataSource;

/* renamed from: com.mchange.v2.c3p0.management.NullManagementCoordinator */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/management/NullManagementCoordinator.class */
public class NullManagementCoordinator implements ManagementCoordinator {
    @Override // com.mchange.p009v2.c3p0.management.ManagementCoordinator
    public void attemptManageC3P0Registry() {
    }

    @Override // com.mchange.p009v2.c3p0.management.ManagementCoordinator
    public void attemptUnmanageC3P0Registry() {
    }

    @Override // com.mchange.p009v2.c3p0.management.ManagementCoordinator
    public void attemptManagePooledDataSource(PooledDataSource pds) {
    }

    @Override // com.mchange.p009v2.c3p0.management.ManagementCoordinator
    public void attemptUnmanagePooledDataSource(PooledDataSource pds) {
    }
}
