package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.sql.filter.FilterDatabaseMetaData;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/* renamed from: com.mchange.v2.c3p0.impl.SetManagedDatabaseMetaData */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/SetManagedDatabaseMetaData.class */
final class SetManagedDatabaseMetaData extends FilterDatabaseMetaData {
    Set activeResultSets;
    Connection returnableProxy;

    /* access modifiers changed from: package-private */
    public SetManagedDatabaseMetaData(DatabaseMetaData inner, Set activeResultSets, Connection returnableProxy) {
        super(inner);
        this.activeResultSets = activeResultSets;
        this.returnableProxy = returnableProxy;
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public Connection getConnection() throws SQLException {
        return this.returnableProxy;
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getProcedures(String a, String b, String c) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getProcedures(a, b, c), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getProcedureColumns(String a, String b, String c, String d) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getProcedureColumns(a, b, c, d), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getTables(String a, String b, String c, String[] d) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getTables(a, b, c, d), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getSchemas() throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getSchemas(), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getCatalogs() throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getCatalogs(), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getTableTypes() throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getTableTypes(), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getColumns(String a, String b, String c, String d) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getColumns(a, b, c, d), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getColumnPrivileges(String a, String b, String c, String d) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getColumnPrivileges(a, b, c, d), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getTablePrivileges(String a, String b, String c) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getTablePrivileges(a, b, c), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getBestRowIdentifier(String a, String b, String c, int d, boolean e) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getBestRowIdentifier(a, b, c, d, e), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getVersionColumns(String a, String b, String c) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getVersionColumns(a, b, c), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getPrimaryKeys(String a, String b, String c) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getPrimaryKeys(a, b, c), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getImportedKeys(String a, String b, String c) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getImportedKeys(a, b, c), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getExportedKeys(String a, String b, String c) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getExportedKeys(a, b, c), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getCrossReference(String a, String b, String c, String d, String e, String f) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getCrossReference(a, b, c, d, e, f), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getTypeInfo() throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getTypeInfo(), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getIndexInfo(String a, String b, String c, boolean d, boolean e) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getIndexInfo(a, b, c, d, e), this.activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterDatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getUDTs(String a, String b, String c, int[] d) throws SQLException {
        return new NullStatementSetManagedResultSet(this.inner.getUDTs(a, b, c, d), this.activeResultSets);
    }
}
