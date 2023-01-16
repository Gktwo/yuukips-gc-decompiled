package com.mongodb.internal.connection;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DnsSrvRecordMonitorFactory.class */
public interface DnsSrvRecordMonitorFactory {
    DnsSrvRecordMonitor create(String str, DnsSrvRecordInitializer dnsSrvRecordInitializer);
}
