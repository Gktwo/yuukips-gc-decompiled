package com.mongodb.internal.connection;

import com.mongodb.connection.ClusterId;
import com.mongodb.connection.ServerSettings;
import com.mongodb.internal.dns.DefaultDnsResolver;
import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultDnsSrvRecordMonitorFactory.class */
public class DefaultDnsSrvRecordMonitorFactory implements DnsSrvRecordMonitorFactory {
    private static final long DEFAULT_RESCAN_FREQUENCY_MILLIS = 60000;
    private final ClusterId clusterId;
    private final long noRecordsRescanFrequency;

    public DefaultDnsSrvRecordMonitorFactory(ClusterId clusterId, ServerSettings serverSettings) {
        this.clusterId = clusterId;
        this.noRecordsRescanFrequency = serverSettings.getHeartbeatFrequency(TimeUnit.MILLISECONDS);
    }

    @Override // com.mongodb.internal.connection.DnsSrvRecordMonitorFactory
    public DnsSrvRecordMonitor create(String hostName, DnsSrvRecordInitializer dnsSrvRecordInitializer) {
        return new DefaultDnsSrvRecordMonitor(hostName, 60000, this.noRecordsRescanFrequency, dnsSrvRecordInitializer, this.clusterId, new DefaultDnsResolver());
    }
}
