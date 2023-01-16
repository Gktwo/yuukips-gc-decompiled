package com.zaxxer.hikari.pool;

import com.zaxxer.hikari.util.FastList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/ProxyFactory.class */
public final class ProxyFactory {
    /* access modifiers changed from: package-private */
    public static ProxyConnection getProxyConnection(PoolEntry poolEntry, Connection connection, FastList<Statement> fastList, ProxyLeakTask proxyLeakTask, long j, boolean z, boolean z2) {
        return new HikariProxyConnection(poolEntry, connection, fastList, proxyLeakTask, j, z, z2);
    }

    /* access modifiers changed from: package-private */
    public static Statement getProxyStatement(ProxyConnection proxyConnection, Statement statement) {
        return new HikariProxyStatement(proxyConnection, statement);
    }

    /* access modifiers changed from: package-private */
    public static CallableStatement getProxyCallableStatement(ProxyConnection proxyConnection, CallableStatement callableStatement) {
        return new HikariProxyCallableStatement(proxyConnection, callableStatement);
    }

    /* access modifiers changed from: package-private */
    public static PreparedStatement getProxyPreparedStatement(ProxyConnection proxyConnection, PreparedStatement preparedStatement) {
        return new HikariProxyPreparedStatement(proxyConnection, preparedStatement);
    }

    /* access modifiers changed from: package-private */
    public static ResultSet getProxyResultSet(ProxyConnection proxyConnection, ProxyStatement proxyStatement, ResultSet resultSet) {
        return new HikariProxyResultSet(proxyConnection, proxyStatement, resultSet);
    }

    private ProxyFactory() {
    }
}
