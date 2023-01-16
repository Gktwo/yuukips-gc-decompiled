package com.mchange.p006v1.p007db.sql;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;

/* renamed from: com.mchange.v1.db.sql.ConnectionEventSupport */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/ConnectionEventSupport.class */
public class ConnectionEventSupport {
    PooledConnection source;
    Set mlisteners = new HashSet();

    public ConnectionEventSupport(PooledConnection pooledConnection) {
        this.source = pooledConnection;
    }

    public synchronized void addConnectionEventListener(ConnectionEventListener connectionEventListener) {
        this.mlisteners.add(connectionEventListener);
    }

    public synchronized void removeConnectionEventListener(ConnectionEventListener connectionEventListener) {
        this.mlisteners.remove(connectionEventListener);
    }

    public synchronized void fireConnectionClosed() {
        ConnectionEvent connectionEvent = new ConnectionEvent(this.source);
        for (ConnectionEventListener connectionEventListener : this.mlisteners) {
            connectionEventListener.connectionClosed(connectionEvent);
        }
    }

    public synchronized void fireConnectionErrorOccurred(SQLException sQLException) {
        ConnectionEvent connectionEvent = new ConnectionEvent(this.source, sQLException);
        for (ConnectionEventListener connectionEventListener : this.mlisteners) {
            connectionEventListener.connectionErrorOccurred(connectionEvent);
        }
    }
}
