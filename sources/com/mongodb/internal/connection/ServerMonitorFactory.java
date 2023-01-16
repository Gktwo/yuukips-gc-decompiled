package com.mongodb.internal.connection;

import com.mongodb.connection.ServerDescription;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ServerMonitorFactory.class */
public interface ServerMonitorFactory {
    ServerMonitor create(ChangeListener<ServerDescription> changeListener);
}
