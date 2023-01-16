package com.mongodb;

import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.ClientSession;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.internal.MongoClientImpl;
import com.mongodb.client.internal.OperationExecutor;
import com.mongodb.connection.BufferProvider;
import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.internal.connection.Cluster;
import com.mongodb.internal.connection.PowerOfTwoBufferPool;
import com.mongodb.internal.connection.ServerAddressHelper;
import com.mongodb.internal.session.ServerSessionPool;
import com.mongodb.internal.thread.DaemonThreadFactory;
import com.mongodb.lang.Nullable;
import java.io.Closeable;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/MongoClient.class */
public class MongoClient implements Closeable {
    private final ConcurrentMap<String, C0961DB> dbCache;
    private final MongoClientOptions options;
    private final BufferProvider bufferProvider;
    private final ConcurrentLinkedQueue<ServerCursorAndNamespace> orphanedCursors;
    private final ExecutorService cursorCleaningService;
    private final MongoClientImpl delegate;

    public static CodecRegistry getDefaultCodecRegistry() {
        return MongoClientSettings.getDefaultCodecRegistry();
    }

    public MongoClient() {
        this(new ConnectionString("mongodb://127.0.0.1"));
    }

    public MongoClient(String connectionString) {
        this(connectionString.contains("://") ? new ConnectionString(connectionString) : new ConnectionString("mongodb://" + connectionString));
    }

    public MongoClient(ConnectionString connectionString) {
        this(connectionString, (MongoDriverInformation) null);
    }

    public MongoClient(ConnectionString connectionString, @Nullable MongoDriverInformation mongoDriverInformation) {
        this(MongoClientSettings.builder().applyConnectionString(connectionString).build(), mongoDriverInformation);
    }

    public MongoClient(MongoClientSettings settings) {
        this(settings, (MongoDriverInformation) null);
    }

    public MongoClient(MongoClientSettings settings, @Nullable MongoDriverInformation mongoDriverInformation) {
        this(settings, (MongoClientOptions) null, mongoDriverInformation);
    }

    private MongoClient(MongoClientSettings settings, @Nullable MongoClientOptions options, @Nullable MongoDriverInformation mongoDriverInformation) {
        this.dbCache = new ConcurrentHashMap();
        this.bufferProvider = new PowerOfTwoBufferPool();
        this.orphanedCursors = new ConcurrentLinkedQueue<>();
        this.delegate = new MongoClientImpl(settings, wrapMongoDriverInformation(mongoDriverInformation));
        this.options = options != null ? options : MongoClientOptions.builder(settings).build();
        this.cursorCleaningService = this.options.isCursorFinalizerEnabled() ? createCursorCleaningService() : null;
    }

    private static MongoDriverInformation wrapMongoDriverInformation(@Nullable MongoDriverInformation mongoDriverInformation) {
        return (mongoDriverInformation == null ? MongoDriverInformation.builder() : MongoDriverInformation.builder(mongoDriverInformation)).driverName("legacy").build();
    }

    public MongoClient(String host, MongoClientOptions options) {
        this(ServerAddressHelper.createServerAddress(host), options);
    }

    public MongoClient(String host, int port) {
        this(ServerAddressHelper.createServerAddress(host, port));
    }

    public MongoClient(ServerAddress addr) {
        this(addr, MongoClientOptions.builder().build());
    }

    public MongoClient(ServerAddress addr, MongoClientOptions options) {
        this(addr, (MongoCredential) null, options);
    }

    public MongoClient(ServerAddress addr, @Nullable MongoCredential credential, MongoClientOptions options) {
        this(addr, credential, options, (MongoDriverInformation) null);
    }

    public MongoClient(List<ServerAddress> seeds) {
        this(seeds, MongoClientOptions.builder().build());
    }

    public MongoClient(List<ServerAddress> seeds, MongoClientOptions options) {
        this(seeds, (MongoCredential) null, options);
    }

    public MongoClient(List<ServerAddress> seeds, @Nullable MongoCredential credential, MongoClientOptions options) {
        this(seeds, credential, options, (MongoDriverInformation) null);
    }

    public MongoClient(MongoClientURI uri) {
        this(uri, (MongoDriverInformation) null);
    }

    public MongoClient(MongoClientURI uri, @Nullable MongoDriverInformation mongoDriverInformation) {
        this(uri.getOptions().asMongoClientSettings(uri.getProxied().isSrvProtocol() ? null : (List) uri.getProxied().getHosts().stream().map(ServerAddress::new).collect(Collectors.toList()), uri.getProxied().isSrvProtocol() ? uri.getProxied().getHosts().get(0) : null, getClusterConnectionMode(uri.getProxied()), uri.getCredentials()), uri.getOptions(), mongoDriverInformation);
    }

    private static ClusterConnectionMode getClusterConnectionMode(ConnectionString connectionString) {
        return ClusterSettings.builder().applyConnectionString(connectionString).build().getMode();
    }

    public MongoClient(ServerAddress addr, @Nullable MongoCredential credential, MongoClientOptions options, @Nullable MongoDriverInformation mongoDriverInformation) {
        this(options.asMongoClientSettings(Collections.singletonList(addr), null, ClusterConnectionMode.SINGLE, credential), options, mongoDriverInformation);
    }

    public MongoClient(List<ServerAddress> seeds, @Nullable MongoCredential credential, MongoClientOptions options, @Nullable MongoDriverInformation mongoDriverInformation) {
        this(options.asMongoClientSettings(seeds, null, ClusterConnectionMode.MULTIPLE, credential), options, mongoDriverInformation);
    }

    public MongoClientOptions getMongoClientOptions() {
        return this.options;
    }

    @Nullable
    public MongoCredential getCredential() {
        return this.delegate.getSettings().getCredential();
    }

    public MongoIterable<String> listDatabaseNames() {
        return this.delegate.listDatabaseNames();
    }

    public MongoIterable<String> listDatabaseNames(ClientSession clientSession) {
        return this.delegate.listDatabaseNames(clientSession);
    }

    public ListDatabasesIterable<Document> listDatabases() {
        return this.delegate.listDatabases();
    }

    public <T> ListDatabasesIterable<T> listDatabases(Class<T> clazz) {
        return this.delegate.listDatabases(clazz);
    }

    public ListDatabasesIterable<Document> listDatabases(ClientSession clientSession) {
        return this.delegate.listDatabases(clientSession);
    }

    public <T> ListDatabasesIterable<T> listDatabases(ClientSession clientSession, Class<T> clazz) {
        return this.delegate.listDatabases(clientSession, clazz);
    }

    public MongoDatabase getDatabase(String databaseName) {
        return this.delegate.getDatabase(databaseName);
    }

    public ClientSession startSession() {
        return this.delegate.startSession();
    }

    public ClientSession startSession(ClientSessionOptions options) {
        return this.delegate.startSession(options);
    }

    public ChangeStreamIterable<Document> watch() {
        return this.delegate.watch();
    }

    public <TResult> ChangeStreamIterable<TResult> watch(Class<TResult> resultClass) {
        return this.delegate.watch(resultClass);
    }

    public ChangeStreamIterable<Document> watch(List<? extends Bson> pipeline) {
        return this.delegate.watch(pipeline);
    }

    public <TResult> ChangeStreamIterable<TResult> watch(List<? extends Bson> pipeline, Class<TResult> resultClass) {
        return this.delegate.watch(pipeline, resultClass);
    }

    public ChangeStreamIterable<Document> watch(ClientSession clientSession) {
        return this.delegate.watch(clientSession);
    }

    public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, Class<TResult> resultClass) {
        return this.delegate.watch(clientSession, resultClass);
    }

    public ChangeStreamIterable<Document> watch(ClientSession clientSession, List<? extends Bson> pipeline) {
        return this.delegate.watch(clientSession, pipeline);
    }

    public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, List<? extends Bson> pipeline, Class<TResult> resultClass) {
        return this.delegate.watch(clientSession, pipeline, resultClass);
    }

    public ClusterDescription getClusterDescription() {
        return this.delegate.getClusterDescription();
    }

    public WriteConcern getWriteConcern() {
        return this.options.getWriteConcern();
    }

    public ReadConcern getReadConcern() {
        return this.options.getReadConcern();
    }

    public ReadPreference getReadPreference() {
        return this.options.getReadPreference();
    }

    @Deprecated
    public C0961DB getDB(String dbName) {
        C0961DB db = this.dbCache.get(dbName);
        if (db != null) {
            return db;
        }
        C0961DB db2 = new C0961DB(this, dbName, getOperationExecutor());
        C0961DB temp = this.dbCache.putIfAbsent(dbName, db2);
        if (temp != null) {
            return temp;
        }
        return db2;
    }

    public void dropDatabase(String dbName) {
        getDB(dbName).dropDatabase();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
        if (this.cursorCleaningService != null) {
            this.cursorCleaningService.shutdownNow();
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return "MongoClient{options=" + this.options + '}';
    }

    Cluster getCluster() {
        return this.delegate.getCluster();
    }

    /* access modifiers changed from: package-private */
    public CodecRegistry getCodecRegistry() {
        return this.delegate.getCodecRegistry();
    }

    ServerSessionPool getServerSessionPool() {
        return this.delegate.getServerSessionPool();
    }

    /* access modifiers changed from: package-private */
    public BufferProvider getBufferProvider() {
        return this.bufferProvider;
    }

    @Nullable
    ExecutorService getCursorCleaningService() {
        return this.cursorCleaningService;
    }

    /* access modifiers changed from: package-private */
    public void addOrphanedCursor(ServerCursor serverCursor, MongoNamespace namespace) {
        this.orphanedCursors.add(new ServerCursorAndNamespace(serverCursor, namespace));
    }

    OperationExecutor getOperationExecutor() {
        return this.delegate.getOperationExecutor();
    }

    MongoClientImpl getDelegate() {
        return this.delegate;
    }

    private ExecutorService createCursorCleaningService() {
        ScheduledExecutorService newTimer = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory("CleanCursors"));
        newTimer.scheduleAtFixedRate(this::cleanCursors, 1, 1, TimeUnit.SECONDS);
        return newTimer;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0056
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void cleanCursors() {
        /*
            r5 = this;
        L_0x0000:
            r0 = r5
            java.util.concurrent.ConcurrentLinkedQueue<com.mongodb.MongoClient$ServerCursorAndNamespace> r0 = r0.orphanedCursors
            java.lang.Object r0 = r0.poll()
            com.mongodb.MongoClient$ServerCursorAndNamespace r0 = (com.mongodb.MongoClient.ServerCursorAndNamespace) r0
            r1 = r0
            r6 = r1
            if (r0 == 0) goto L_0x008d
            com.mongodb.internal.binding.SingleServerBinding r0 = new com.mongodb.internal.binding.SingleServerBinding
            r1 = r0
            r2 = r5
            com.mongodb.client.internal.MongoClientImpl r2 = r2.delegate
            com.mongodb.internal.connection.Cluster r2 = r2.getCluster()
            r3 = r6
            com.mongodb.ServerCursor r3 = com.mongodb.MongoClient.ServerCursorAndNamespace.access$000(r3)
            com.mongodb.ServerAddress r3 = r3.getAddress()
            r1.<init>(r2, r3)
            r7 = r0
            r0 = r7
            com.mongodb.internal.binding.ConnectionSource r0 = r0.getReadConnectionSource()     // Catch: all -> 0x007f
            r8 = r0
            r0 = r8
            com.mongodb.internal.connection.Connection r0 = r0.getConnection()     // Catch: all -> 0x006b, all -> 0x007f
            r9 = r0
            r0 = r9
            r1 = r6
            com.mongodb.MongoNamespace r1 = com.mongodb.MongoClient.ServerCursorAndNamespace.access$100(r1)     // Catch: all -> 0x0056, all -> 0x006b, all -> 0x007f
            r2 = r6
            com.mongodb.ServerCursor r2 = com.mongodb.MongoClient.ServerCursorAndNamespace.access$000(r2)     // Catch: all -> 0x0056, all -> 0x006b, all -> 0x007f
            long r2 = r2.getId()     // Catch: all -> 0x0056, all -> 0x006b, all -> 0x007f
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: all -> 0x0056, all -> 0x006b, all -> 0x007f
            java.util.List r2 = java.util.Collections.singletonList(r2)     // Catch: all -> 0x0056, all -> 0x006b, all -> 0x007f
            r0.killCursor(r1, r2)     // Catch: all -> 0x0056, all -> 0x006b, all -> 0x007f
            r0 = r9
            r0.release()     // Catch: all -> 0x006b, all -> 0x007f
            goto L_0x0062
        L_0x0056:
            r10 = move-exception
            r0 = r9
            r0.release()     // Catch: all -> 0x006b, all -> 0x007f
            r0 = r10
            throw r0     // Catch: all -> 0x006b, all -> 0x007f
        L_0x0062:
            r0 = r8
            r0.release()     // Catch: all -> 0x007f
            goto L_0x0076
        L_0x006b:
            r11 = move-exception
            r0 = r8
            r0.release()     // Catch: all -> 0x007f
            r0 = r11
            throw r0     // Catch: all -> 0x007f
        L_0x0076:
            r0 = r7
            r0.release()
            goto L_0x008a
        L_0x007f:
            r12 = move-exception
            r0 = r7
            r0.release()
            r0 = r12
            throw r0
        L_0x008a:
            goto L_0x0000
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.MongoClient.cleanCursors():void");
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/MongoClient$ServerCursorAndNamespace.class */
    public static class ServerCursorAndNamespace {
        private final ServerCursor serverCursor;
        private final MongoNamespace namespace;

        ServerCursorAndNamespace(ServerCursor serverCursor, MongoNamespace namespace) {
            this.serverCursor = serverCursor;
            this.namespace = namespace;
        }
    }
}
