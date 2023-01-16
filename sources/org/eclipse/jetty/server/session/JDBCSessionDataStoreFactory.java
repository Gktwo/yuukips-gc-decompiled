package org.eclipse.jetty.server.session;

import org.eclipse.jetty.server.session.JDBCSessionDataStore;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/JDBCSessionDataStoreFactory.class */
public class JDBCSessionDataStoreFactory extends AbstractSessionDataStoreFactory {
    DatabaseAdaptor _adaptor;
    JDBCSessionDataStore.SessionTableSchema _schema;

    @Override // org.eclipse.jetty.server.session.SessionDataStoreFactory
    public SessionDataStore getSessionDataStore(SessionHandler handler) {
        JDBCSessionDataStore ds = new JDBCSessionDataStore();
        ds.setDatabaseAdaptor(this._adaptor);
        ds.setSessionTableSchema(this._schema);
        ds.setGracePeriodSec(getGracePeriodSec());
        ds.setSavePeriodSec(getSavePeriodSec());
        return ds;
    }

    public void setDatabaseAdaptor(DatabaseAdaptor adaptor) {
        this._adaptor = adaptor;
    }

    public void setSessionTableSchema(JDBCSessionDataStore.SessionTableSchema schema) {
        this._schema = schema;
    }
}
