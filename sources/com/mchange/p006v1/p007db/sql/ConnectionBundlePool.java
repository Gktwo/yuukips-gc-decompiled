package com.mchange.p006v1.p007db.sql;

import com.mchange.p006v1.util.BrokenObjectException;
import com.mchange.p006v1.util.ClosableResource;
import java.sql.SQLException;

/* renamed from: com.mchange.v1.db.sql.ConnectionBundlePool */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/ConnectionBundlePool.class */
public interface ConnectionBundlePool extends ClosableResource {
    ConnectionBundle checkoutBundle() throws SQLException, InterruptedException, BrokenObjectException;

    void checkinBundle(ConnectionBundle connectionBundle) throws SQLException, BrokenObjectException;

    @Override // com.mchange.p006v1.util.ClosableResource
    void close() throws SQLException;
}
