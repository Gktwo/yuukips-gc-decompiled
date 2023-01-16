package com.mchange.p006v1.p007db.sql;

import com.mchange.p006v1.util.BrokenObjectException;
import java.sql.Connection;
import java.sql.SQLException;

/* renamed from: com.mchange.v1.db.sql.ConnectionBundlePoolBean */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/ConnectionBundlePoolBean.class */
public class ConnectionBundlePoolBean implements ConnectionBundlePool {
    ConnectionBundlePool inner;

    public void init(String str, String str2, String str3, String str4, int i, int i2, int i3) throws SQLException, ClassNotFoundException {
        Class.forName(str);
        init(str2, str3, str4, i, i2, i3);
    }

    public void init(String str, String str2, String str3, int i, int i2, int i3) throws SQLException {
        this.inner = new InnerPool(str, str2, str3, i, i2, i3);
    }

    @Override // com.mchange.p006v1.p007db.sql.ConnectionBundlePool
    public ConnectionBundle checkoutBundle() throws SQLException, InterruptedException, BrokenObjectException {
        return this.inner.checkoutBundle();
    }

    @Override // com.mchange.p006v1.p007db.sql.ConnectionBundlePool
    public void checkinBundle(ConnectionBundle connectionBundle) throws SQLException, BrokenObjectException {
        this.inner.checkinBundle(connectionBundle);
    }

    @Override // com.mchange.p006v1.p007db.sql.ConnectionBundlePool, com.mchange.p006v1.util.ClosableResource
    public void close() throws SQLException {
        this.inner.close();
    }

    protected void setConnectionOptions(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v1.db.sql.ConnectionBundlePoolBean$InnerPool */
    /* loaded from: grasscutter.jar:com/mchange/v1/db/sql/ConnectionBundlePoolBean$InnerPool.class */
    public class InnerPool extends ConnectionBundlePoolImpl {
        InnerPool(String str, String str2, String str3, int i, int i2, int i3) throws SQLException {
            super(i, i2, i3);
            init(str, str2, str3);
        }

        @Override // com.mchange.p006v1.p007db.sql.ConnectionBundlePoolImpl
        protected void setConnectionOptions(Connection connection) throws SQLException {
            ConnectionBundlePoolBean.this.setConnectionOptions(connection);
        }
    }
}
