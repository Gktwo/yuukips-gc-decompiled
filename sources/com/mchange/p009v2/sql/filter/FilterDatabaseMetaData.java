package com.mchange.p009v2.sql.filter;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;

/* renamed from: com.mchange.v2.sql.filter.FilterDatabaseMetaData */
/* loaded from: grasscutter.jar:com/mchange/v2/sql/filter/FilterDatabaseMetaData.class */
public abstract class FilterDatabaseMetaData implements DatabaseMetaData {
    protected DatabaseMetaData inner;

    private void __setInner(DatabaseMetaData databaseMetaData) {
        this.inner = databaseMetaData;
    }

    public FilterDatabaseMetaData(DatabaseMetaData databaseMetaData) {
        __setInner(databaseMetaData);
    }

    public FilterDatabaseMetaData() {
    }

    public void setInner(DatabaseMetaData databaseMetaData) {
        __setInner(databaseMetaData);
    }

    public DatabaseMetaData getInner() {
        return this.inner;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
        return this.inner.autoCommitFailureClosesAllResultSets();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getCatalogs() throws SQLException {
        return this.inner.getCatalogs();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean allProceduresAreCallable() throws SQLException {
        return this.inner.allProceduresAreCallable();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean allTablesAreSelectable() throws SQLException {
        return this.inner.allTablesAreSelectable();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
        return this.inner.dataDefinitionCausesTransactionCommit();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
        return this.inner.dataDefinitionIgnoredInTransactions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean deletesAreDetected(int i) throws SQLException {
        return this.inner.deletesAreDetected(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
        return this.inner.doesMaxRowSizeIncludeBlobs();
    }

    public boolean generatedKeyAlwaysReturned() throws SQLException {
        return this.inner.generatedKeyAlwaysReturned();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getBestRowIdentifier(String str, String str2, String str3, int i, boolean z) throws SQLException {
        return this.inner.getBestRowIdentifier(str, str2, str3, i, z);
    }

    @Override // java.sql.DatabaseMetaData
    public String getCatalogSeparator() throws SQLException {
        return this.inner.getCatalogSeparator();
    }

    @Override // java.sql.DatabaseMetaData
    public String getCatalogTerm() throws SQLException {
        return this.inner.getCatalogTerm();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getClientInfoProperties() throws SQLException {
        return this.inner.getClientInfoProperties();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getColumnPrivileges(String str, String str2, String str3, String str4) throws SQLException {
        return this.inner.getColumnPrivileges(str, str2, str3, str4);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getColumns(String str, String str2, String str3, String str4) throws SQLException {
        return this.inner.getColumns(str, str2, str3, str4);
    }

    @Override // java.sql.DatabaseMetaData
    public Connection getConnection() throws SQLException {
        return this.inner.getConnection();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getCrossReference(String str, String str2, String str3, String str4, String str5, String str6) throws SQLException {
        return this.inner.getCrossReference(str, str2, str3, str4, str5, str6);
    }

    @Override // java.sql.DatabaseMetaData
    public int getDatabaseMajorVersion() throws SQLException {
        return this.inner.getDatabaseMajorVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public int getDatabaseMinorVersion() throws SQLException {
        return this.inner.getDatabaseMinorVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public String getDatabaseProductName() throws SQLException {
        return this.inner.getDatabaseProductName();
    }

    @Override // java.sql.DatabaseMetaData
    public String getDatabaseProductVersion() throws SQLException {
        return this.inner.getDatabaseProductVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public int getDefaultTransactionIsolation() throws SQLException {
        return this.inner.getDefaultTransactionIsolation();
    }

    @Override // java.sql.DatabaseMetaData
    public int getDriverMajorVersion() {
        return this.inner.getDriverMajorVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public int getDriverMinorVersion() {
        return this.inner.getDriverMinorVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public String getDriverName() throws SQLException {
        return this.inner.getDriverName();
    }

    @Override // java.sql.DatabaseMetaData
    public String getDriverVersion() throws SQLException {
        return this.inner.getDriverVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getExportedKeys(String str, String str2, String str3) throws SQLException {
        return this.inner.getExportedKeys(str, str2, str3);
    }

    @Override // java.sql.DatabaseMetaData
    public String getExtraNameCharacters() throws SQLException {
        return this.inner.getExtraNameCharacters();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getFunctionColumns(String str, String str2, String str3, String str4) throws SQLException {
        return this.inner.getFunctionColumns(str, str2, str3, str4);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getFunctions(String str, String str2, String str3) throws SQLException {
        return this.inner.getFunctions(str, str2, str3);
    }

    @Override // java.sql.DatabaseMetaData
    public String getIdentifierQuoteString() throws SQLException {
        return this.inner.getIdentifierQuoteString();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getImportedKeys(String str, String str2, String str3) throws SQLException {
        return this.inner.getImportedKeys(str, str2, str3);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getIndexInfo(String str, String str2, String str3, boolean z, boolean z2) throws SQLException {
        return this.inner.getIndexInfo(str, str2, str3, z, z2);
    }

    @Override // java.sql.DatabaseMetaData
    public int getJDBCMajorVersion() throws SQLException {
        return this.inner.getJDBCMajorVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public int getJDBCMinorVersion() throws SQLException {
        return this.inner.getJDBCMinorVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxBinaryLiteralLength() throws SQLException {
        return this.inner.getMaxBinaryLiteralLength();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxCatalogNameLength() throws SQLException {
        return this.inner.getMaxCatalogNameLength();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxCharLiteralLength() throws SQLException {
        return this.inner.getMaxCharLiteralLength();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnNameLength() throws SQLException {
        return this.inner.getMaxColumnNameLength();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnsInGroupBy() throws SQLException {
        return this.inner.getMaxColumnsInGroupBy();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnsInIndex() throws SQLException {
        return this.inner.getMaxColumnsInIndex();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnsInOrderBy() throws SQLException {
        return this.inner.getMaxColumnsInOrderBy();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnsInSelect() throws SQLException {
        return this.inner.getMaxColumnsInSelect();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnsInTable() throws SQLException {
        return this.inner.getMaxColumnsInTable();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxConnections() throws SQLException {
        return this.inner.getMaxConnections();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxCursorNameLength() throws SQLException {
        return this.inner.getMaxCursorNameLength();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxIndexLength() throws SQLException {
        return this.inner.getMaxIndexLength();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxProcedureNameLength() throws SQLException {
        return this.inner.getMaxProcedureNameLength();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxRowSize() throws SQLException {
        return this.inner.getMaxRowSize();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxSchemaNameLength() throws SQLException {
        return this.inner.getMaxSchemaNameLength();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxStatementLength() throws SQLException {
        return this.inner.getMaxStatementLength();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxStatements() throws SQLException {
        return this.inner.getMaxStatements();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxTableNameLength() throws SQLException {
        return this.inner.getMaxTableNameLength();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxTablesInSelect() throws SQLException {
        return this.inner.getMaxTablesInSelect();
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxUserNameLength() throws SQLException {
        return this.inner.getMaxUserNameLength();
    }

    @Override // java.sql.DatabaseMetaData
    public String getNumericFunctions() throws SQLException {
        return this.inner.getNumericFunctions();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getPrimaryKeys(String str, String str2, String str3) throws SQLException {
        return this.inner.getPrimaryKeys(str, str2, str3);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getProcedureColumns(String str, String str2, String str3, String str4) throws SQLException {
        return this.inner.getProcedureColumns(str, str2, str3, str4);
    }

    @Override // java.sql.DatabaseMetaData
    public String getProcedureTerm() throws SQLException {
        return this.inner.getProcedureTerm();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getProcedures(String str, String str2, String str3) throws SQLException {
        return this.inner.getProcedures(str, str2, str3);
    }

    public ResultSet getPseudoColumns(String str, String str2, String str3, String str4) throws SQLException {
        return this.inner.getPseudoColumns(str, str2, str3, str4);
    }

    @Override // java.sql.DatabaseMetaData
    public int getResultSetHoldability() throws SQLException {
        return this.inner.getResultSetHoldability();
    }

    @Override // java.sql.DatabaseMetaData
    public RowIdLifetime getRowIdLifetime() throws SQLException {
        return this.inner.getRowIdLifetime();
    }

    @Override // java.sql.DatabaseMetaData
    public String getSQLKeywords() throws SQLException {
        return this.inner.getSQLKeywords();
    }

    @Override // java.sql.DatabaseMetaData
    public int getSQLStateType() throws SQLException {
        return this.inner.getSQLStateType();
    }

    @Override // java.sql.DatabaseMetaData
    public String getSchemaTerm() throws SQLException {
        return this.inner.getSchemaTerm();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getSchemas(String str, String str2) throws SQLException {
        return this.inner.getSchemas(str, str2);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getSchemas() throws SQLException {
        return this.inner.getSchemas();
    }

    @Override // java.sql.DatabaseMetaData
    public String getSearchStringEscape() throws SQLException {
        return this.inner.getSearchStringEscape();
    }

    @Override // java.sql.DatabaseMetaData
    public String getStringFunctions() throws SQLException {
        return this.inner.getStringFunctions();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getSuperTables(String str, String str2, String str3) throws SQLException {
        return this.inner.getSuperTables(str, str2, str3);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getSuperTypes(String str, String str2, String str3) throws SQLException {
        return this.inner.getSuperTypes(str, str2, str3);
    }

    @Override // java.sql.DatabaseMetaData
    public String getSystemFunctions() throws SQLException {
        return this.inner.getSystemFunctions();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getTablePrivileges(String str, String str2, String str3) throws SQLException {
        return this.inner.getTablePrivileges(str, str2, str3);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getTableTypes() throws SQLException {
        return this.inner.getTableTypes();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getTables(String str, String str2, String str3, String[] strArr) throws SQLException {
        return this.inner.getTables(str, str2, str3, strArr);
    }

    @Override // java.sql.DatabaseMetaData
    public String getTimeDateFunctions() throws SQLException {
        return this.inner.getTimeDateFunctions();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getTypeInfo() throws SQLException {
        return this.inner.getTypeInfo();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getUDTs(String str, String str2, String str3, int[] iArr) throws SQLException {
        return this.inner.getUDTs(str, str2, str3, iArr);
    }

    @Override // java.sql.DatabaseMetaData
    public String getUserName() throws SQLException {
        return this.inner.getUserName();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getVersionColumns(String str, String str2, String str3) throws SQLException {
        return this.inner.getVersionColumns(str, str2, str3);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean insertsAreDetected(int i) throws SQLException {
        return this.inner.insertsAreDetected(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean isCatalogAtStart() throws SQLException {
        return this.inner.isCatalogAtStart();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean locatorsUpdateCopy() throws SQLException {
        return this.inner.locatorsUpdateCopy();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean nullPlusNonNullIsNull() throws SQLException {
        return this.inner.nullPlusNonNullIsNull();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean nullsAreSortedAtEnd() throws SQLException {
        return this.inner.nullsAreSortedAtEnd();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean nullsAreSortedAtStart() throws SQLException {
        return this.inner.nullsAreSortedAtStart();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean nullsAreSortedHigh() throws SQLException {
        return this.inner.nullsAreSortedHigh();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean nullsAreSortedLow() throws SQLException {
        return this.inner.nullsAreSortedLow();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean othersDeletesAreVisible(int i) throws SQLException {
        return this.inner.othersDeletesAreVisible(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean othersInsertsAreVisible(int i) throws SQLException {
        return this.inner.othersInsertsAreVisible(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean othersUpdatesAreVisible(int i) throws SQLException {
        return this.inner.othersUpdatesAreVisible(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean ownDeletesAreVisible(int i) throws SQLException {
        return this.inner.ownDeletesAreVisible(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean ownInsertsAreVisible(int i) throws SQLException {
        return this.inner.ownInsertsAreVisible(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean ownUpdatesAreVisible(int i) throws SQLException {
        return this.inner.ownUpdatesAreVisible(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesLowerCaseIdentifiers() throws SQLException {
        return this.inner.storesLowerCaseIdentifiers();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
        return this.inner.storesLowerCaseQuotedIdentifiers();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesMixedCaseIdentifiers() throws SQLException {
        return this.inner.storesMixedCaseIdentifiers();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
        return this.inner.storesMixedCaseQuotedIdentifiers();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesUpperCaseIdentifiers() throws SQLException {
        return this.inner.storesUpperCaseIdentifiers();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
        return this.inner.storesUpperCaseQuotedIdentifiers();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsANSI92EntryLevelSQL() throws SQLException {
        return this.inner.supportsANSI92EntryLevelSQL();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsANSI92FullSQL() throws SQLException {
        return this.inner.supportsANSI92FullSQL();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsANSI92IntermediateSQL() throws SQLException {
        return this.inner.supportsANSI92IntermediateSQL();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsAlterTableWithAddColumn() throws SQLException {
        return this.inner.supportsAlterTableWithAddColumn();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsAlterTableWithDropColumn() throws SQLException {
        return this.inner.supportsAlterTableWithDropColumn();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsBatchUpdates() throws SQLException {
        return this.inner.supportsBatchUpdates();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCatalogsInDataManipulation() throws SQLException {
        return this.inner.supportsCatalogsInDataManipulation();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
        return this.inner.supportsCatalogsInIndexDefinitions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
        return this.inner.supportsCatalogsInPrivilegeDefinitions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCatalogsInProcedureCalls() throws SQLException {
        return this.inner.supportsCatalogsInProcedureCalls();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCatalogsInTableDefinitions() throws SQLException {
        return this.inner.supportsCatalogsInTableDefinitions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsColumnAliasing() throws SQLException {
        return this.inner.supportsColumnAliasing();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsConvert(int i, int i2) throws SQLException {
        return this.inner.supportsConvert(i, i2);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsConvert() throws SQLException {
        return this.inner.supportsConvert();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCoreSQLGrammar() throws SQLException {
        return this.inner.supportsCoreSQLGrammar();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCorrelatedSubqueries() throws SQLException {
        return this.inner.supportsCorrelatedSubqueries();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
        return this.inner.supportsDataDefinitionAndDataManipulationTransactions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
        return this.inner.supportsDataManipulationTransactionsOnly();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsDifferentTableCorrelationNames() throws SQLException {
        return this.inner.supportsDifferentTableCorrelationNames();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsExpressionsInOrderBy() throws SQLException {
        return this.inner.supportsExpressionsInOrderBy();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsExtendedSQLGrammar() throws SQLException {
        return this.inner.supportsExtendedSQLGrammar();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsFullOuterJoins() throws SQLException {
        return this.inner.supportsFullOuterJoins();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsGetGeneratedKeys() throws SQLException {
        return this.inner.supportsGetGeneratedKeys();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsGroupBy() throws SQLException {
        return this.inner.supportsGroupBy();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsGroupByBeyondSelect() throws SQLException {
        return this.inner.supportsGroupByBeyondSelect();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsGroupByUnrelated() throws SQLException {
        return this.inner.supportsGroupByUnrelated();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsIntegrityEnhancementFacility() throws SQLException {
        return this.inner.supportsIntegrityEnhancementFacility();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsLikeEscapeClause() throws SQLException {
        return this.inner.supportsLikeEscapeClause();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsLimitedOuterJoins() throws SQLException {
        return this.inner.supportsLimitedOuterJoins();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMinimumSQLGrammar() throws SQLException {
        return this.inner.supportsMinimumSQLGrammar();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMixedCaseIdentifiers() throws SQLException {
        return this.inner.supportsMixedCaseIdentifiers();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
        return this.inner.supportsMixedCaseQuotedIdentifiers();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMultipleOpenResults() throws SQLException {
        return this.inner.supportsMultipleOpenResults();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMultipleResultSets() throws SQLException {
        return this.inner.supportsMultipleResultSets();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMultipleTransactions() throws SQLException {
        return this.inner.supportsMultipleTransactions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsNamedParameters() throws SQLException {
        return this.inner.supportsNamedParameters();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsNonNullableColumns() throws SQLException {
        return this.inner.supportsNonNullableColumns();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
        return this.inner.supportsOpenCursorsAcrossCommit();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
        return this.inner.supportsOpenCursorsAcrossRollback();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
        return this.inner.supportsOpenStatementsAcrossCommit();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
        return this.inner.supportsOpenStatementsAcrossRollback();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOrderByUnrelated() throws SQLException {
        return this.inner.supportsOrderByUnrelated();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOuterJoins() throws SQLException {
        return this.inner.supportsOuterJoins();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsPositionedDelete() throws SQLException {
        return this.inner.supportsPositionedDelete();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsPositionedUpdate() throws SQLException {
        return this.inner.supportsPositionedUpdate();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsResultSetConcurrency(int i, int i2) throws SQLException {
        return this.inner.supportsResultSetConcurrency(i, i2);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsResultSetHoldability(int i) throws SQLException {
        return this.inner.supportsResultSetHoldability(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsResultSetType(int i) throws SQLException {
        return this.inner.supportsResultSetType(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSavepoints() throws SQLException {
        return this.inner.supportsSavepoints();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSchemasInDataManipulation() throws SQLException {
        return this.inner.supportsSchemasInDataManipulation();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSchemasInIndexDefinitions() throws SQLException {
        return this.inner.supportsSchemasInIndexDefinitions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
        return this.inner.supportsSchemasInPrivilegeDefinitions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSchemasInProcedureCalls() throws SQLException {
        return this.inner.supportsSchemasInProcedureCalls();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSchemasInTableDefinitions() throws SQLException {
        return this.inner.supportsSchemasInTableDefinitions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSelectForUpdate() throws SQLException {
        return this.inner.supportsSelectForUpdate();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsStatementPooling() throws SQLException {
        return this.inner.supportsStatementPooling();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
        return this.inner.supportsStoredFunctionsUsingCallSyntax();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsStoredProcedures() throws SQLException {
        return this.inner.supportsStoredProcedures();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSubqueriesInComparisons() throws SQLException {
        return this.inner.supportsSubqueriesInComparisons();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSubqueriesInExists() throws SQLException {
        return this.inner.supportsSubqueriesInExists();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSubqueriesInIns() throws SQLException {
        return this.inner.supportsSubqueriesInIns();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSubqueriesInQuantifieds() throws SQLException {
        return this.inner.supportsSubqueriesInQuantifieds();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsTableCorrelationNames() throws SQLException {
        return this.inner.supportsTableCorrelationNames();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsTransactionIsolationLevel(int i) throws SQLException {
        return this.inner.supportsTransactionIsolationLevel(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsTransactions() throws SQLException {
        return this.inner.supportsTransactions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsUnion() throws SQLException {
        return this.inner.supportsUnion();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsUnionAll() throws SQLException {
        return this.inner.supportsUnionAll();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean updatesAreDetected(int i) throws SQLException {
        return this.inner.updatesAreDetected(i);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean usesLocalFilePerTable() throws SQLException {
        return this.inner.usesLocalFilePerTable();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean usesLocalFiles() throws SQLException {
        return this.inner.usesLocalFiles();
    }

    @Override // java.sql.DatabaseMetaData
    public String getURL() throws SQLException {
        return this.inner.getURL();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean isReadOnly() throws SQLException {
        return this.inner.isReadOnly();
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getAttributes(String str, String str2, String str3, String str4) throws SQLException {
        return this.inner.getAttributes(str, str2, str3, str4);
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
