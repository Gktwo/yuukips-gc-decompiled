package com.zaxxer.hikari.pool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/ProxyPreparedStatement.class */
public abstract class ProxyPreparedStatement extends ProxyStatement implements PreparedStatement {
    /* access modifiers changed from: protected */
    public ProxyPreparedStatement(ProxyConnection connection, PreparedStatement statement) {
        super(connection, statement);
    }

    @Override // java.sql.PreparedStatement
    public boolean execute() throws SQLException {
        this.connection.markCommitStateDirty();
        return ((PreparedStatement) this.delegate).execute();
    }

    @Override // java.sql.PreparedStatement
    public ResultSet executeQuery() throws SQLException {
        this.connection.markCommitStateDirty();
        return ProxyFactory.getProxyResultSet(this.connection, this, ((PreparedStatement) this.delegate).executeQuery());
    }

    @Override // java.sql.PreparedStatement
    public int executeUpdate() throws SQLException {
        this.connection.markCommitStateDirty();
        return ((PreparedStatement) this.delegate).executeUpdate();
    }
}
