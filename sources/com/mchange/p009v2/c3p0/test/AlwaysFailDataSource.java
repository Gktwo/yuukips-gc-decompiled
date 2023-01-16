package com.mchange.p009v2.c3p0.test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.AlwaysFailDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/AlwaysFailDataSource.class */
public final class AlwaysFailDataSource implements DataSource {
    private static String MESSAGE = "AlwaysFailDataSource always fails.";

    private static SQLException failure() {
        return new SQLException(MESSAGE);
    }

    @Override // javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        throw failure();
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String user, String password) throws SQLException {
        throw failure();
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() throws SQLException {
        throw failure();
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter pw) throws SQLException {
        throw failure();
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int i) throws SQLException {
        throw failure();
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() throws SQLException {
        throw failure();
    }

    @Override // javax.sql.CommonDataSource
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException(MESSAGE);
    }

    @Override // java.sql.Wrapper
    public <T> T unwrap(Class<T> clz) throws SQLException {
        throw failure();
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> clz) throws SQLException {
        throw failure();
    }
}
