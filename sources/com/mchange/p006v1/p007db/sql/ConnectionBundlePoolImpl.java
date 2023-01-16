package com.mchange.p006v1.p007db.sql;

import com.mchange.p006v1.util.AbstractResourcePool;
import com.mchange.p006v1.util.BrokenObjectException;
import com.mchange.p006v1.util.UnexpectedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* renamed from: com.mchange.v1.db.sql.ConnectionBundlePoolImpl */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/ConnectionBundlePoolImpl.class */
public abstract class ConnectionBundlePoolImpl extends AbstractResourcePool implements ConnectionBundlePool {
    String jdbcUrl;
    String username;
    String pwd;

    protected abstract void setConnectionOptions(Connection connection) throws SQLException;

    public ConnectionBundlePoolImpl(String str, String str2, String str3, int i, int i2, int i3) throws SQLException {
        super(i, i2, i3);
        init(str, str2, str3);
    }

    /* access modifiers changed from: protected */
    public ConnectionBundlePoolImpl(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    protected void init(String str, String str2, String str3) throws SQLException {
        this.jdbcUrl = str;
        this.username = str2;
        this.pwd = str3;
        try {
            init();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException(e2, "Unexpected exception while initializing ConnectionBundlePool");
        }
    }

    @Override // com.mchange.p006v1.p007db.sql.ConnectionBundlePool
    public ConnectionBundle checkoutBundle() throws SQLException, BrokenObjectException, InterruptedException {
        try {
            return (ConnectionBundle) checkoutResource();
        } catch (BrokenObjectException e) {
            throw e;
        } catch (InterruptedException e2) {
            throw e2;
        } catch (SQLException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException(e4, "Unexpected exception while checking out ConnectionBundle");
        }
    }

    @Override // com.mchange.p006v1.p007db.sql.ConnectionBundlePool
    public void checkinBundle(ConnectionBundle connectionBundle) throws BrokenObjectException {
        checkinResource(connectionBundle);
    }

    @Override // com.mchange.p006v1.util.AbstractResourcePool, com.mchange.p006v1.p007db.sql.ConnectionBundlePool, com.mchange.p006v1.util.ClosableResource
    public void close() throws SQLException {
        try {
            close();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException(e2, "Unexpected exception while closing pool.");
        }
    }

    @Override // com.mchange.p006v1.util.AbstractResourcePool
    protected Object acquireResource() throws Exception {
        Connection connection = DriverManager.getConnection(this.jdbcUrl, this.username, this.pwd);
        setConnectionOptions(connection);
        return new ConnectionBundleImpl(connection);
    }

    @Override // com.mchange.p006v1.util.AbstractResourcePool
    protected void refurbishResource(Object obj) throws BrokenObjectException {
        boolean z;
        try {
            Connection connection = ((ConnectionBundle) obj).getConnection();
            connection.rollback();
            z = connection.isClosed();
            setConnectionOptions(connection);
        } catch (SQLException e) {
            z = true;
        }
        if (z) {
            throw new BrokenObjectException(obj);
        }
    }

    @Override // com.mchange.p006v1.util.AbstractResourcePool
    protected void destroyResource(Object obj) throws Exception {
        ((ConnectionBundle) obj).close();
    }
}
