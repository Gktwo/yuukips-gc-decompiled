package com.mchange.p009v2.c3p0.filter;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.filter.FilterDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/filter/FilterDataSource.class */
public abstract class FilterDataSource implements DataSource {
    protected DataSource inner;

    public FilterDataSource(DataSource inner) {
        this.inner = inner;
    }

    @Override // javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        return this.inner.getConnection();
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String a, String b) throws SQLException {
        return this.inner.getConnection(a, b);
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
    public void setLogWriter(PrintWriter a) throws SQLException {
        this.inner.setLogWriter(a);
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int a) throws SQLException {
        this.inner.setLoginTimeout(a);
    }
}
