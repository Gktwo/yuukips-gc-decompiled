package com.mchange.p006v1.p007db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.mchange.v1.db.sql.ConnectionBundleImpl */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/ConnectionBundleImpl.class */
public class ConnectionBundleImpl implements ConnectionBundle {
    Connection con;
    Map map = new HashMap();

    public ConnectionBundleImpl(Connection connection) {
        this.con = connection;
    }

    @Override // com.mchange.p006v1.p007db.sql.ConnectionBundle
    public Connection getConnection() {
        return this.con;
    }

    @Override // com.mchange.p006v1.p007db.sql.ConnectionBundle
    public PreparedStatement getStatement(String str) {
        return (PreparedStatement) this.map.get(str);
    }

    @Override // com.mchange.p006v1.p007db.sql.ConnectionBundle
    public void putStatement(String str, PreparedStatement preparedStatement) {
        this.map.put(str, preparedStatement);
    }

    @Override // com.mchange.p006v1.util.ClosableResource
    public void close() throws SQLException {
        this.con.close();
    }

    public void finalize() throws Exception {
        if (!this.con.isClosed()) {
            close();
        }
    }
}
