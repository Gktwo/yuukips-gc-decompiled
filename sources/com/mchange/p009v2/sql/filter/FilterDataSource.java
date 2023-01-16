package com.mchange.p009v2.sql.filter;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.sql.filter.FilterDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/sql/filter/FilterDataSource.class */
public abstract class FilterDataSource implements DataSource {
    protected DataSource inner;

    private void __setInner(DataSource dataSource) {
        this.inner = dataSource;
    }

    public FilterDataSource(DataSource dataSource) {
        __setInner(dataSource);
    }

    public FilterDataSource() {
    }

    public void setInner(DataSource dataSource) {
        __setInner(dataSource);
    }

    public DataSource getInner() {
        return this.inner;
    }

    @Override // javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        return this.inner.getConnection();
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String str, String str2) throws SQLException {
        return this.inner.getConnection(str, str2);
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() throws SQLException {
        return this.inner.getLogWriter();
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() throws SQLException {
        return this.inner.getLoginTimeout();
    }

    @Override // javax.sql.CommonDataSource
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return this.inner.getParentLogger();
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter printWriter) throws SQLException {
        this.inner.setLogWriter(printWriter);
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int i) throws SQLException {
        this.inner.setLoginTimeout(i);
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class cls) throws SQLException {
        return this.inner.isWrapperFor(cls);
    }

    @Override // java.sql.Wrapper
    public Object unwrap(Class cls) throws SQLException {
        return this.inner.unwrap(cls);
    }
}
