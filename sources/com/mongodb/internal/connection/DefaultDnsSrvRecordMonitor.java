package com.mongodb.internal.connection;

import com.mongodb.ServerAddress;
import com.mongodb.connection.ClusterId;
import com.mongodb.connection.ClusterType;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.dns.DnsResolver;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultDnsSrvRecordMonitor.class */
class DefaultDnsSrvRecordMonitor implements DnsSrvRecordMonitor {
    private static final Logger LOGGER = Loggers.getLogger("cluster");
    private final String hostName;
    private final long rescanFrequencyMillis;
    private final long noRecordsRescanFrequencyMillis;
    private final DnsSrvRecordInitializer dnsSrvRecordInitializer;
    private final DnsResolver dnsResolver;
    private final Thread monitorThread;
    private volatile boolean isClosed;

    /* access modifiers changed from: package-private */
    public DefaultDnsSrvRecordMonitor(String hostName, long rescanFrequencyMillis, long noRecordsRescanFrequencyMillis, DnsSrvRecordInitializer dnsSrvRecordInitializer, ClusterId clusterId, DnsResolver dnsResolver) {
        this.hostName = hostName;
        this.rescanFrequencyMillis = rescanFrequencyMillis;
        this.noRecordsRescanFrequencyMillis = noRecordsRescanFrequencyMillis;
        this.dnsSrvRecordInitializer = dnsSrvRecordInitializer;
        this.dnsResolver = dnsResolver;
        this.monitorThread = new Thread(new DnsSrvRecordMonitorRunnable(), "cluster-" + clusterId + "-srv-" + hostName);
        this.monitorThread.setDaemon(true);
    }

    @Override // com.mongodb.internal.connection.DnsSrvRecordMonitor
    public void start() {
        this.monitorThread.start();
    }

    @Override // com.mongodb.internal.connection.DnsSrvRecordMonitor
    public void close() {
        this.isClosed = true;
        this.monitorThread.interrupt();
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultDnsSrvRecordMonitor$DnsSrvRecordMonitorRunnable.class */
    private class DnsSrvRecordMonitorRunnable implements Runnable {
        private Set<ServerAddress> currentHosts;
        private ClusterType clusterType;

        private DnsSrvRecordMonitorRunnable() {
            this.currentHosts = Collections.emptySet();
            this.clusterType = ClusterType.UNKNOWN;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x0058
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                r0 = r6
                com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.this
                boolean r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$100(r0)
                if (r0 != 0) goto L_0x00db
                r0 = r6
                boolean r0 = r0.shouldContinueMonitoring()
                if (r0 == 0) goto L_0x00db
                r0 = r6
                com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.this     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                com.mongodb.internal.dns.DnsResolver r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$300(r0)     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                r1 = r6
                com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor r1 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.this     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                java.lang.String r1 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$200(r1)     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                java.util.List r0 = r0.resolveHostFromSrvRecords(r1)     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                r7 = r0
                r0 = r6
                r1 = r7
                java.util.Set r0 = r0.createServerAddressSet(r1)     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                r8 = r0
                r0 = r6
                com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.this     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                boolean r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$100(r0)     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                if (r0 == 0) goto L_0x0036
                return
            L_0x0036:
                r0 = r8
                r1 = r6
                java.util.Set<com.mongodb.ServerAddress> r1 = r1.currentHosts     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                boolean r0 = r0.equals(r1)     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                if (r0 != 0) goto L_0x0064
                r0 = r6
                com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.this     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f, RuntimeException -> 0x0058
                com.mongodb.internal.connection.DnsSrvRecordInitializer r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$400(r0)     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f, RuntimeException -> 0x0058
                r1 = r8
                r0.initialize(r1)     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f, RuntimeException -> 0x0058
                r0 = r6
                r1 = r8
                r0.currentHosts = r1     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f, RuntimeException -> 0x0058
                goto L_0x0064
            L_0x0058:
                r9 = move-exception
                com.mongodb.diagnostics.logging.Logger r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$500()     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
                java.lang.String r1 = "Exception in monitor thread during notification of DNS resolution state change"
                r2 = r9
                r0.warn(r1, r2)     // Catch: MongoException -> 0x0067, RuntimeException -> 0x008f
            L_0x0064:
                goto L_0x00bd
            L_0x0067:
                r7 = move-exception
                r0 = r6
                java.util.Set<com.mongodb.ServerAddress> r0 = r0.currentHosts
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0081
                r0 = r6
                com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.this
                com.mongodb.internal.connection.DnsSrvRecordInitializer r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$400(r0)
                r1 = r7
                r0.initialize(r1)
            L_0x0081:
                com.mongodb.diagnostics.logging.Logger r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$500()
                java.lang.String r1 = "Exception while resolving SRV records"
                r2 = r7
                r0.info(r1, r2)
                goto L_0x00bd
            L_0x008f:
                r7 = move-exception
                r0 = r6
                java.util.Set<com.mongodb.ServerAddress> r0 = r0.currentHosts
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x00b2
                r0 = r6
                com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.this
                com.mongodb.internal.connection.DnsSrvRecordInitializer r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$400(r0)
                com.mongodb.MongoInternalException r1 = new com.mongodb.MongoInternalException
                r2 = r1
                java.lang.String r3 = "Unexpected runtime exception"
                r4 = r7
                r2.<init>(r3, r4)
                r0.initialize(r1)
            L_0x00b2:
                com.mongodb.diagnostics.logging.Logger r0 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$500()
                java.lang.String r1 = "Unexpected runtime exception while resolving SRV record"
                r2 = r7
                r0.info(r1, r2)
            L_0x00bd:
                r0 = r6
                long r0 = r0.getRescanFrequencyMillis()     // Catch: InterruptedException -> 0x00c7
                java.lang.Thread.sleep(r0)     // Catch: InterruptedException -> 0x00c7
                goto L_0x00c8
            L_0x00c7:
                r7 = move-exception
            L_0x00c8:
                r0 = r6
                r1 = r6
                com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor r1 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.this
                com.mongodb.internal.connection.DnsSrvRecordInitializer r1 = com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.access$400(r1)
                com.mongodb.connection.ClusterType r1 = r1.getClusterType()
                r0.clusterType = r1
                goto L_0x0000
            L_0x00db:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.DefaultDnsSrvRecordMonitor.DnsSrvRecordMonitorRunnable.run():void");
        }

        private boolean shouldContinueMonitoring() {
            return this.clusterType == ClusterType.UNKNOWN || this.clusterType == ClusterType.SHARDED;
        }

        private long getRescanFrequencyMillis() {
            return this.currentHosts.isEmpty() ? DefaultDnsSrvRecordMonitor.this.noRecordsRescanFrequencyMillis : DefaultDnsSrvRecordMonitor.this.rescanFrequencyMillis;
        }

        private Set<ServerAddress> createServerAddressSet(List<String> resolvedHostNames) {
            Set<ServerAddress> hosts = new HashSet<>(resolvedHostNames.size());
            for (String host : resolvedHostNames) {
                hosts.add(ServerAddressHelper.createServerAddress(host));
            }
            return hosts;
        }
    }
}
