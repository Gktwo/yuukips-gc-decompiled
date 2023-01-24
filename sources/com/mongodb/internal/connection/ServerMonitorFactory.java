package com.mongodb.internal.connection;

import com.mongodb.connection.ServerDescription;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ServerMonitorFactory.class */
interface ServerMonitorFactory {
    ServerMonitor create(ChangeListener<ServerDescription> changeListener);
}
