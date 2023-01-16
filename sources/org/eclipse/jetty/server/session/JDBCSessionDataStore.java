package org.eclipse.jetty.server.session;

import dev.morphia.mapping.Mapper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.eclipse.jetty.util.ClassLoadingObjectInputStream;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/JDBCSessionDataStore.class */
public class JDBCSessionDataStore extends AbstractSessionDataStore {
    public static final String NULL_CONTEXT_PATH = "/";
    protected boolean _initialized = false;
    protected DatabaseAdaptor _dbAdaptor;
    protected SessionTableSchema _sessionTableSchema;
    protected boolean _schemaProvided;
    static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    private static final ByteArrayInputStream EMPTY = new ByteArrayInputStream(new byte[0]);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/JDBCSessionDataStore$SessionTableSchema.class */
    public static class SessionTableSchema {
        public static final int MAX_INTERVAL_NOT_SET = -999;
        public static final String INFERRED = "INFERRED";
        protected DatabaseAdaptor _dbAdaptor;
        protected String _schemaName = null;
        protected String _catalogName = null;
        protected String _tableName = "JettySessions";
        protected String _idColumn = "sessionId";
        protected String _contextPathColumn = "contextPath";
        protected String _virtualHostColumn = "virtualHost";
        protected String _lastNodeColumn = "lastNode";
        protected String _accessTimeColumn = "accessTime";
        protected String _lastAccessTimeColumn = "lastAccessTime";
        protected String _createTimeColumn = "createTime";
        protected String _cookieTimeColumn = "cookieTime";
        protected String _lastSavedTimeColumn = "lastSavedTime";
        protected String _expiryTimeColumn = "expiryTime";
        protected String _maxIntervalColumn = "maxInterval";
        protected String _mapColumn = "map";

        protected void setDatabaseAdaptor(DatabaseAdaptor dbadaptor) {
            this._dbAdaptor = dbadaptor;
        }

        public void setCatalogName(String catalogName) {
            if (catalogName == null || !StringUtil.isBlank(catalogName)) {
                this._catalogName = catalogName;
            } else {
                this._catalogName = null;
            }
        }

        public String getCatalogName() {
            return this._catalogName;
        }

        public String getSchemaName() {
            return this._schemaName;
        }

        public void setSchemaName(String schemaName) {
            if (schemaName == null || !StringUtil.isBlank(schemaName)) {
                this._schemaName = schemaName;
            } else {
                this._schemaName = null;
            }
        }

        public String getTableName() {
            return this._tableName;
        }

        public void setTableName(String tableName) {
            checkNotNull(tableName);
            this._tableName = tableName;
        }

        private String getSchemaTableName() {
            return (getSchemaName() != null ? getSchemaName() + Mapper.IGNORED_FIELDNAME : "") + getTableName();
        }

        public String getIdColumn() {
            return this._idColumn;
        }

        public void setIdColumn(String idColumn) {
            checkNotNull(idColumn);
            this._idColumn = idColumn;
        }

        public String getContextPathColumn() {
            return this._contextPathColumn;
        }

        public void setContextPathColumn(String contextPathColumn) {
            checkNotNull(contextPathColumn);
            this._contextPathColumn = contextPathColumn;
        }

        public String getVirtualHostColumn() {
            return this._virtualHostColumn;
        }

        public void setVirtualHostColumn(String virtualHostColumn) {
            checkNotNull(virtualHostColumn);
            this._virtualHostColumn = virtualHostColumn;
        }

        public String getLastNodeColumn() {
            return this._lastNodeColumn;
        }

        public void setLastNodeColumn(String lastNodeColumn) {
            checkNotNull(lastNodeColumn);
            this._lastNodeColumn = lastNodeColumn;
        }

        public String getAccessTimeColumn() {
            return this._accessTimeColumn;
        }

        public void setAccessTimeColumn(String accessTimeColumn) {
            checkNotNull(accessTimeColumn);
            this._accessTimeColumn = accessTimeColumn;
        }

        public String getLastAccessTimeColumn() {
            return this._lastAccessTimeColumn;
        }

        public void setLastAccessTimeColumn(String lastAccessTimeColumn) {
            checkNotNull(lastAccessTimeColumn);
            this._lastAccessTimeColumn = lastAccessTimeColumn;
        }

        public String getCreateTimeColumn() {
            return this._createTimeColumn;
        }

        public void setCreateTimeColumn(String createTimeColumn) {
            checkNotNull(createTimeColumn);
            this._createTimeColumn = createTimeColumn;
        }

        public String getCookieTimeColumn() {
            return this._cookieTimeColumn;
        }

        public void setCookieTimeColumn(String cookieTimeColumn) {
            checkNotNull(cookieTimeColumn);
            this._cookieTimeColumn = cookieTimeColumn;
        }

        public String getLastSavedTimeColumn() {
            return this._lastSavedTimeColumn;
        }

        public void setLastSavedTimeColumn(String lastSavedTimeColumn) {
            checkNotNull(lastSavedTimeColumn);
            this._lastSavedTimeColumn = lastSavedTimeColumn;
        }

        public String getExpiryTimeColumn() {
            return this._expiryTimeColumn;
        }

        public void setExpiryTimeColumn(String expiryTimeColumn) {
            checkNotNull(expiryTimeColumn);
            this._expiryTimeColumn = expiryTimeColumn;
        }

        public String getMaxIntervalColumn() {
            return this._maxIntervalColumn;
        }

        public void setMaxIntervalColumn(String maxIntervalColumn) {
            checkNotNull(maxIntervalColumn);
            this._maxIntervalColumn = maxIntervalColumn;
        }

        public String getMapColumn() {
            return this._mapColumn;
        }

        public void setMapColumn(String mapColumn) {
            checkNotNull(mapColumn);
            this._mapColumn = mapColumn;
        }

        public String getCreateStatementAsString() {
            if (this._dbAdaptor == null) {
                throw new IllegalStateException("No DBAdaptor");
            }
            String blobType = this._dbAdaptor.getBlobType();
            String longType = this._dbAdaptor.getLongType();
            String stringType = this._dbAdaptor.getStringType();
            return "create table " + this._tableName + " (" + this._idColumn + " " + stringType + "(120), " + this._contextPathColumn + " " + stringType + "(60), " + this._virtualHostColumn + " " + stringType + "(60), " + this._lastNodeColumn + " " + stringType + "(60), " + this._accessTimeColumn + " " + longType + ", " + this._lastAccessTimeColumn + " " + longType + ", " + this._createTimeColumn + " " + longType + ", " + this._cookieTimeColumn + " " + longType + ", " + this._lastSavedTimeColumn + " " + longType + ", " + this._expiryTimeColumn + " " + longType + ", " + this._maxIntervalColumn + " " + longType + ", " + this._mapColumn + " " + blobType + ", primary key(" + this._idColumn + ", " + this._contextPathColumn + "," + this._virtualHostColumn + "))";
        }

        public String getCreateIndexOverExpiryStatementAsString(String indexName) {
            return "create index " + indexName + " on " + getSchemaTableName() + " (" + getExpiryTimeColumn() + ")";
        }

        public String getCreateIndexOverSessionStatementAsString(String indexName) {
            return "create index " + indexName + " on " + getSchemaTableName() + " (" + getIdColumn() + ", " + getContextPathColumn() + ")";
        }

        public String getAlterTableForMaxIntervalAsString() {
            if (this._dbAdaptor == null) {
                throw new IllegalStateException("No DBAdaptor");
            }
            String stem = "alter table " + getSchemaTableName() + " add " + getMaxIntervalColumn() + " " + this._dbAdaptor.getLongType();
            if (this._dbAdaptor.getDBName().contains("oracle")) {
                return stem + " default " + MAX_INTERVAL_NOT_SET + " not null";
            }
            return stem + " not null default " + MAX_INTERVAL_NOT_SET;
        }

        private void checkNotNull(String s) {
            if (s == null) {
                throw new IllegalArgumentException(s);
            }
        }

        public String getInsertSessionStatementAsString() {
            return "insert into " + getSchemaTableName() + " (" + getIdColumn() + ", " + getContextPathColumn() + ", " + getVirtualHostColumn() + ", " + getLastNodeColumn() + ", " + getAccessTimeColumn() + ", " + getLastAccessTimeColumn() + ", " + getCreateTimeColumn() + ", " + getCookieTimeColumn() + ", " + getLastSavedTimeColumn() + ", " + getExpiryTimeColumn() + ", " + getMaxIntervalColumn() + ", " + getMapColumn() + ")  values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }

        public PreparedStatement getUpdateSessionStatement(Connection connection, String id, SessionContext context) throws SQLException {
            String s = "update " + getSchemaTableName() + " set " + getLastNodeColumn() + " = ?, " + getAccessTimeColumn() + " = ?, " + getLastAccessTimeColumn() + " = ?, " + getLastSavedTimeColumn() + " = ?, " + getExpiryTimeColumn() + " = ?, " + getMaxIntervalColumn() + " = ?, " + getMapColumn() + " = ? where " + getIdColumn() + " = ? and " + getContextPathColumn() + " = ? and " + getVirtualHostColumn() + " = ?";
            String cp = context.getCanonicalContextPath();
            if (this._dbAdaptor.isEmptyStringNull() && StringUtil.isBlank(cp)) {
                cp = "/";
            }
            PreparedStatement statement = connection.prepareStatement(s);
            statement.setString(8, id);
            statement.setString(9, cp);
            statement.setString(10, context.getVhost());
            return statement;
        }

        public PreparedStatement getExpiredSessionsStatement(Connection connection, String canonicalContextPath, String vhost, long expiry) throws SQLException {
            if (this._dbAdaptor == null) {
                throw new IllegalStateException("No DB adaptor");
            }
            String cp = canonicalContextPath;
            if (this._dbAdaptor.isEmptyStringNull() && StringUtil.isBlank(cp)) {
                cp = "/";
            }
            PreparedStatement statement = connection.prepareStatement("select " + getIdColumn() + ", " + getExpiryTimeColumn() + " from " + getSchemaTableName() + " where " + getContextPathColumn() + " = ? and " + getVirtualHostColumn() + " = ? and " + getExpiryTimeColumn() + " >0 and " + getExpiryTimeColumn() + " <= ?");
            statement.setString(1, cp);
            statement.setString(2, vhost);
            statement.setLong(3, expiry);
            return statement;
        }

        public PreparedStatement getMyExpiredSessionsStatement(Connection connection, SessionContext sessionContext, long expiry) throws SQLException {
            if (this._dbAdaptor == null) {
                throw new IllegalStateException("No DB adaptor");
            }
            String cp = sessionContext.getCanonicalContextPath();
            if (this._dbAdaptor.isEmptyStringNull() && StringUtil.isBlank(cp)) {
                cp = "/";
            }
            PreparedStatement statement = connection.prepareStatement("select " + getIdColumn() + ", " + getExpiryTimeColumn() + " from " + getSchemaTableName() + " where " + getLastNodeColumn() + " = ? and " + getContextPathColumn() + " = ? and " + getVirtualHostColumn() + " = ? and " + getExpiryTimeColumn() + " >0 and " + getExpiryTimeColumn() + " <= ?");
            statement.setString(1, sessionContext.getWorkerName());
            statement.setString(2, cp);
            statement.setString(3, sessionContext.getVhost());
            statement.setLong(4, expiry);
            return statement;
        }

        public PreparedStatement getAllAncientExpiredSessionsStatement(Connection connection) throws SQLException {
            if (this._dbAdaptor != null) {
                return connection.prepareStatement("select " + getIdColumn() + ", " + getContextPathColumn() + ", " + getVirtualHostColumn() + " from " + getSchemaTableName() + " where " + getExpiryTimeColumn() + " >0 and " + getExpiryTimeColumn() + " <= ?");
            }
            throw new IllegalStateException("No DB adaptor");
        }

        public PreparedStatement getCheckSessionExistsStatement(Connection connection, SessionContext context) throws SQLException {
            if (this._dbAdaptor == null) {
                throw new IllegalStateException("No DB adaptor");
            }
            String cp = context.getCanonicalContextPath();
            if (this._dbAdaptor.isEmptyStringNull() && StringUtil.isBlank(cp)) {
                cp = "/";
            }
            PreparedStatement statement = connection.prepareStatement("select " + getIdColumn() + ", " + getExpiryTimeColumn() + " from " + getSchemaTableName() + " where " + getIdColumn() + " = ? and " + getContextPathColumn() + " = ? and " + getVirtualHostColumn() + " = ?");
            statement.setString(2, cp);
            statement.setString(3, context.getVhost());
            return statement;
        }

        public PreparedStatement getLoadStatement(Connection connection, String id, SessionContext contextId) throws SQLException {
            if (this._dbAdaptor == null) {
                throw new IllegalStateException("No DB adaptor");
            }
            String cp = contextId.getCanonicalContextPath();
            if (this._dbAdaptor.isEmptyStringNull() && StringUtil.isBlank(cp)) {
                cp = "/";
            }
            PreparedStatement statement = connection.prepareStatement("select * from " + getSchemaTableName() + " where " + getIdColumn() + " = ? and " + getContextPathColumn() + " = ? and " + getVirtualHostColumn() + " = ?");
            statement.setString(1, id);
            statement.setString(2, cp);
            statement.setString(3, contextId.getVhost());
            return statement;
        }

        public PreparedStatement getUpdateStatement(Connection connection, String id, SessionContext contextId) throws SQLException {
            if (this._dbAdaptor == null) {
                throw new IllegalStateException("No DB adaptor");
            }
            String cp = contextId.getCanonicalContextPath();
            if (this._dbAdaptor.isEmptyStringNull() && StringUtil.isBlank(cp)) {
                cp = "/";
            }
            PreparedStatement statement = connection.prepareStatement("update " + getSchemaTableName() + " set " + getLastNodeColumn() + " = ?, " + getAccessTimeColumn() + " = ?, " + getLastAccessTimeColumn() + " = ?, " + getLastSavedTimeColumn() + " = ?, " + getExpiryTimeColumn() + " = ?, " + getMaxIntervalColumn() + " = ?, " + getMapColumn() + " = ? where " + getIdColumn() + " = ? and " + getContextPathColumn() + " = ? and " + getVirtualHostColumn() + " = ?");
            statement.setString(8, id);
            statement.setString(9, cp);
            statement.setString(10, contextId.getVhost());
            return statement;
        }

        public PreparedStatement getDeleteStatement(Connection connection, String id, SessionContext contextId) throws Exception {
            if (this._dbAdaptor == null) {
                throw new IllegalStateException("No DB adaptor");
            }
            String cp = contextId.getCanonicalContextPath();
            if (this._dbAdaptor.isEmptyStringNull() && StringUtil.isBlank(cp)) {
                cp = "/";
            }
            PreparedStatement statement = connection.prepareStatement("delete from " + getSchemaTableName() + " where " + getIdColumn() + " = ? and " + getContextPathColumn() + " = ? and " + getVirtualHostColumn() + " = ?");
            statement.setString(1, id);
            statement.setString(2, cp);
            statement.setString(3, contextId.getVhost());
            return statement;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x0112
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        public void prepareTables() throws java.sql.SQLException {
            /*
            // Method dump skipped, instructions count: 709
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.JDBCSessionDataStore.SessionTableSchema.prepareTables():void");
        }

        public String toString() {
            return String.format("%s[%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s]", toString(), this._catalogName, this._schemaName, this._tableName, this._idColumn, this._contextPathColumn, this._virtualHostColumn, this._cookieTimeColumn, this._createTimeColumn, this._expiryTimeColumn, this._accessTimeColumn, this._lastAccessTimeColumn, this._lastNodeColumn, this._lastSavedTimeColumn, this._maxIntervalColumn);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._dbAdaptor == null) {
            throw new IllegalStateException("No jdbc config");
        }
        initialize();
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
        this._initialized = false;
        if (!this._schemaProvided) {
            this._sessionTableSchema = null;
        }
    }

    public void initialize() throws Exception {
        if (!this._initialized) {
            this._initialized = true;
            if (this._sessionTableSchema == null) {
                this._sessionTableSchema = new SessionTableSchema();
                addBean((Object) this._sessionTableSchema, true);
            }
            this._dbAdaptor.initialize();
            this._sessionTableSchema.setDatabaseAdaptor(this._dbAdaptor);
            this._sessionTableSchema.prepareTables();
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore
    public SessionData doLoad(String id) throws Exception {
        Connection connection = this._dbAdaptor.getConnection();
        try {
            PreparedStatement statement = this._sessionTableSchema.getLoadStatement(connection, id, this._context);
            ResultSet result = statement.executeQuery();
            try {
                SessionData data = null;
                if (result.next()) {
                    data = newSessionData(id, result.getLong(this._sessionTableSchema.getCreateTimeColumn()), result.getLong(this._sessionTableSchema.getAccessTimeColumn()), result.getLong(this._sessionTableSchema.getLastAccessTimeColumn()), result.getLong(this._sessionTableSchema.getMaxIntervalColumn()));
                    data.setCookieSet(result.getLong(this._sessionTableSchema.getCookieTimeColumn()));
                    data.setLastNode(result.getString(this._sessionTableSchema.getLastNodeColumn()));
                    data.setLastSaved(result.getLong(this._sessionTableSchema.getLastSavedTimeColumn()));
                    data.setExpiry(result.getLong(this._sessionTableSchema.getExpiryTimeColumn()));
                    data.setContextPath(this._context.getCanonicalContextPath());
                    data.setVhost(this._context.getVhost());
                    try {
                        InputStream is = this._dbAdaptor.getBlobInputStream(result, this._sessionTableSchema.getMapColumn());
                        ClassLoadingObjectInputStream ois = new ClassLoadingObjectInputStream(is);
                        try {
                            try {
                                SessionData.deserializeAttributes(data, ois);
                                ois.close();
                                if (is != null) {
                                    is.close();
                                }
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("LOADED session {}", data);
                                }
                            } catch (Throwable th) {
                                try {
                                    ois.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (Exception e) {
                        throw new UnreadableSessionDataException(id, this._context, e);
                    }
                } else if (LOG.isDebugEnabled()) {
                    LOG.debug("No session {}", id);
                }
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                return data;
            } catch (Throwable th5) {
                if (result != null) {
                    try {
                        result.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        } catch (Throwable th7) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                }
            }
            throw th7;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:23:0x0075
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.eclipse.jetty.server.session.SessionDataMap
    public boolean delete(java.lang.String r8) throws java.lang.Exception {
        /*
            r7 = this;
            r0 = r7
            org.eclipse.jetty.server.session.DatabaseAdaptor r0 = r0._dbAdaptor
            java.sql.Connection r0 = r0.getConnection()
            r9 = r0
            r0 = r7
            org.eclipse.jetty.server.session.JDBCSessionDataStore$SessionTableSchema r0 = r0._sessionTableSchema     // Catch: Throwable -> 0x0090
            r1 = r9
            r2 = r8
            r3 = r7
            org.eclipse.jetty.server.session.SessionContext r3 = r3._context     // Catch: Throwable -> 0x0090
            java.sql.PreparedStatement r0 = r0.getDeleteStatement(r1, r2, r3)     // Catch: Throwable -> 0x0090
            r10 = r0
            r0 = r9
            r1 = 1
            r0.setAutoCommit(r1)     // Catch: Throwable -> 0x0090, Throwable -> 0x0075
            r0 = r10
            int r0 = r0.executeUpdate()     // Catch: Throwable -> 0x0090, Throwable -> 0x0075
            r11 = r0
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.JDBCSessionDataStore.LOG     // Catch: Throwable -> 0x0090, Throwable -> 0x0075
            boolean r0 = r0.isDebugEnabled()     // Catch: Throwable -> 0x0090, Throwable -> 0x0075
            if (r0 == 0) goto L_0x0052
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.JDBCSessionDataStore.LOG     // Catch: Throwable -> 0x0090, Throwable -> 0x0075
            java.lang.String r1 = "Deleted Session {}:{}"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: Throwable -> 0x0090, Throwable -> 0x0075
            r3 = r2
            r4 = 0
            r5 = r8
            r3[r4] = r5     // Catch: Throwable -> 0x0090, Throwable -> 0x0075
            r3 = r2
            r4 = 1
            r5 = r11
            if (r5 <= 0) goto L_0x0048
            r5 = 1
            goto L_0x0049
        L_0x0048:
            r5 = 0
        L_0x0049:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: Throwable -> 0x0090, Throwable -> 0x0075
            r3[r4] = r5     // Catch: Throwable -> 0x0090, Throwable -> 0x0075
            r0.debug(r1, r2)     // Catch: Throwable -> 0x0090, Throwable -> 0x0075
        L_0x0052:
            r0 = r11
            if (r0 <= 0) goto L_0x005b
            r0 = 1
            goto L_0x005c
        L_0x005b:
            r0 = 0
        L_0x005c:
            r12 = r0
            r0 = r10
            if (r0 == 0) goto L_0x0068
            r0 = r10
            r0.close()     // Catch: Throwable -> 0x0090
        L_0x0068:
            r0 = r9
            if (r0 == 0) goto L_0x0072
            r0 = r9
            r0.close()
        L_0x0072:
            r0 = r12
            return r0
        L_0x0075:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L_0x008d
            r0 = r10
            r0.close()     // Catch: Throwable -> 0x0084, Throwable -> 0x0090
            goto L_0x008d
        L_0x0084:
            r12 = move-exception
            r0 = r11
            r1 = r12
            r0.addSuppressed(r1)     // Catch: Throwable -> 0x0090
        L_0x008d:
            r0 = r11
            throw r0     // Catch: Throwable -> 0x0090
        L_0x0090:
            r10 = move-exception
            r0 = r9
            if (r0 == 0) goto L_0x00a6
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x009e
            goto L_0x00a6
        L_0x009e:
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)
        L_0x00a6:
            r0 = r10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.JDBCSessionDataStore.delete(java.lang.String):boolean");
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore
    public void doStore(String id, SessionData data, long lastSaveTime) throws Exception {
        if (data != null && id != null) {
            if (lastSaveTime <= 0) {
                doInsert(id, data);
            } else {
                doUpdate(id, data);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x010c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    protected void doInsert(java.lang.String r6, org.eclipse.jetty.server.session.SessionData r7) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 459
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.JDBCSessionDataStore.doInsert(java.lang.String, org.eclipse.jetty.server.session.SessionData):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x00ac
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    protected void doUpdate(java.lang.String r6, org.eclipse.jetty.server.session.SessionData r7) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 389
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.JDBCSessionDataStore.doUpdate(java.lang.String, org.eclipse.jetty.server.session.SessionData):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v120, types: [long] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<java.lang.String> doGetExpired(java.util.Set<java.lang.String> r10) {
        /*
        // Method dump skipped, instructions count: 1016
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.JDBCSessionDataStore.doGetExpired(java.util.Set):java.util.Set");
    }

    public void setDatabaseAdaptor(DatabaseAdaptor dbAdaptor) {
        checkStarted();
        updateBean(this._dbAdaptor, dbAdaptor);
        this._dbAdaptor = dbAdaptor;
    }

    public void setSessionTableSchema(SessionTableSchema schema) {
        checkStarted();
        updateBean(this._sessionTableSchema, schema);
        this._sessionTableSchema = schema;
        this._schemaProvided = true;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    @ManagedAttribute(value = "does this store serialize sessions", readonly = true)
    public boolean isPassivating() {
        return true;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    public boolean exists(String id) throws Exception {
        Connection connection = this._dbAdaptor.getConnection();
        try {
            connection.setAutoCommit(true);
            PreparedStatement checkSessionExists = this._sessionTableSchema.getCheckSessionExistsStatement(connection, this._context);
            checkSessionExists.setString(1, id);
            ResultSet result = checkSessionExists.executeQuery();
            try {
                if (!result.next()) {
                    if (result != null) {
                        result.close();
                    }
                    if (checkSessionExists != null) {
                        checkSessionExists.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                    return false;
                }
                long expiry = result.getLong(this._sessionTableSchema.getExpiryTimeColumn());
                if (expiry <= 0) {
                    if (result != null) {
                        result.close();
                    }
                    if (checkSessionExists != null) {
                        checkSessionExists.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                    return true;
                }
                boolean z = expiry > System.currentTimeMillis();
                if (result != null) {
                    result.close();
                }
                if (checkSessionExists != null) {
                    checkSessionExists.close();
                }
                if (connection != null) {
                    connection.close();
                }
                return z;
            } catch (Throwable th) {
                if (result != null) {
                    try {
                        result.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }
}
