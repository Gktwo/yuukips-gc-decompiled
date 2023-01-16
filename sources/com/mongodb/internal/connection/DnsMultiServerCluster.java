package com.mongodb.internal.connection;

import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterId;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.connection.ClusterType;
import java.util.Collection;
import java.util.Collections;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DnsMultiServerCluster.class */
public final class DnsMultiServerCluster extends AbstractMultiServerCluster {
    private final DnsSrvRecordMonitor dnsSrvRecordMonitor;
    private volatile MongoException srvResolutionException;

    public DnsMultiServerCluster(ClusterId clusterId, ClusterSettings settings, ClusterableServerFactory serverFactory, DnsSrvRecordMonitorFactory dnsSrvRecordMonitorFactory) {
        super(clusterId, settings, serverFactory);
        Assertions.notNull("srvHost", settings.getSrvHost());
        this.dnsSrvRecordMonitor = dnsSrvRecordMonitorFactory.create(settings.getSrvHost(), new DnsSrvRecordInitializer() { // from class: com.mongodb.internal.connection.DnsMultiServerCluster.1
            private volatile boolean initialized;

            @Override // com.mongodb.internal.connection.DnsSrvRecordInitializer
            public void initialize(Collection<ServerAddress> hosts) {
                DnsMultiServerCluster.this.srvResolutionException = null;
                if (!this.initialized) {
                    this.initialized = true;
                    DnsMultiServerCluster.this.initialize(hosts);
                    return;
                }
                DnsMultiServerCluster.this.onChange(hosts);
            }

            @Override // com.mongodb.internal.connection.DnsSrvRecordInitializer
            public void initialize(MongoException initializationException) {
                if (!this.initialized) {
                    DnsMultiServerCluster.this.srvResolutionException = initializationException;
                    DnsMultiServerCluster.this.initialize(Collections.emptyList());
                }
            }

            @Override // com.mongodb.internal.connection.DnsSrvRecordInitializer
            public ClusterType getClusterType() {
                return DnsMultiServerCluster.this.getClusterType();
            }
        });
        this.dnsSrvRecordMonitor.start();
    }

    @Override // com.mongodb.internal.connection.AbstractMultiServerCluster
    protected MongoException getSrvResolutionException() {
        return this.srvResolutionException;
    }

    @Override // com.mongodb.internal.connection.AbstractMultiServerCluster, com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.dnsSrvRecordMonitor != null) {
            this.dnsSrvRecordMonitor.close();
        }
        close();
    }
}
