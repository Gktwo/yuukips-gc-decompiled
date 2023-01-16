package com.mongodb.internal.session;

import com.mongodb.MongoException;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.connection.Cluster;
import com.mongodb.internal.connection.ConcurrentPool;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.NoOpSessionContext;
import com.mongodb.internal.selector.ReadPreferenceServerSelector;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import com.mongodb.selector.ServerSelector;
import com.mongodb.session.ServerSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.bson.BsonArray;
import org.bson.BsonBinary;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWriter;
import org.bson.BsonWriter;
import org.bson.UuidRepresentation;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.UuidCodec;

/* loaded from: grasscutter.jar:com/mongodb/internal/session/ServerSessionPool.class */
public class ServerSessionPool {
    private static final int END_SESSIONS_BATCH_SIZE = 10000;
    private final ConcurrentPool<ServerSessionImpl> serverSessionPool;
    private final Cluster cluster;
    private final Clock clock;
    private volatile boolean closing;
    private volatile boolean closed;
    private final List<BsonDocument> closedSessionIdentifiers;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/session/ServerSessionPool$Clock.class */
    public interface Clock {
        long millis();
    }

    public ServerSessionPool(Cluster cluster) {
        this(cluster, new Clock() { // from class: com.mongodb.internal.session.ServerSessionPool.1
            @Override // com.mongodb.internal.session.ServerSessionPool.Clock
            public long millis() {
                return System.currentTimeMillis();
            }
        });
    }

    public ServerSessionPool(Cluster cluster, Clock clock) {
        this.serverSessionPool = new ConcurrentPool<>(Integer.MAX_VALUE, new ServerSessionItemFactory());
        this.closedSessionIdentifiers = new ArrayList();
        this.cluster = cluster;
        this.clock = clock;
    }

    public ServerSession get() {
        Assertions.isTrue("server session pool is open", !this.closed);
        ServerSessionImpl serverSessionImpl = this.serverSessionPool.get();
        while (true) {
            ServerSessionImpl serverSession = serverSessionImpl;
            if (!shouldPrune(serverSession)) {
                return serverSession;
            }
            this.serverSessionPool.release(serverSession, true);
            serverSessionImpl = this.serverSessionPool.get();
        }
    }

    public void release(ServerSession serverSession) {
        this.serverSessionPool.release((ServerSessionImpl) serverSession);
        this.serverSessionPool.prune();
    }

    public void close() {
        List<BsonDocument> identifiers;
        try {
            this.closing = true;
            this.serverSessionPool.close();
            synchronized (this) {
                identifiers = new ArrayList<>(this.closedSessionIdentifiers);
                this.closedSessionIdentifiers.clear();
            }
            endClosedSessions(identifiers);
            this.closed = true;
        } catch (Throwable th) {
            this.closed = true;
            throw th;
        }
    }

    public int getInUseCount() {
        return this.serverSessionPool.getInUseCount();
    }

    /* access modifiers changed from: private */
    public void closeSession(ServerSessionImpl serverSession) {
        serverSession.close();
        if (this.closing) {
            List<BsonDocument> identifiers = null;
            synchronized (this) {
                this.closedSessionIdentifiers.add(serverSession.getIdentifier());
                if (this.closedSessionIdentifiers.size() == 10000) {
                    identifiers = new ArrayList<>(this.closedSessionIdentifiers);
                    this.closedSessionIdentifiers.clear();
                }
            }
            if (identifiers != null) {
                endClosedSessions(identifiers);
            }
        }
    }

    private void endClosedSessions(List<BsonDocument> identifiers) {
        if (!identifiers.isEmpty()) {
            final List<ServerDescription> primaryPreferred = new ReadPreferenceServerSelector(ReadPreference.primaryPreferred()).select(this.cluster.getCurrentDescription());
            if (!primaryPreferred.isEmpty()) {
                Connection connection = null;
                try {
                    connection = this.cluster.selectServer(new ServerSelector() { // from class: com.mongodb.internal.session.ServerSessionPool.2
                        @Override // com.mongodb.selector.ServerSelector
                        public List<ServerDescription> select(ClusterDescription clusterDescription) {
                            for (ServerDescription cur : clusterDescription.getServerDescriptions()) {
                                if (cur.getAddress().equals(((ServerDescription) primaryPreferred.get(0)).getAddress())) {
                                    return Collections.singletonList(cur);
                                }
                            }
                            return Collections.emptyList();
                        }
                    }).getServer().getConnection();
                    connection.command("admin", new BsonDocument("endSessions", new BsonArray(identifiers)), new NoOpFieldNameValidator(), ReadPreference.primaryPreferred(), new BsonDocumentCodec(), NoOpSessionContext.INSTANCE);
                    if (connection != null) {
                        connection.release();
                    }
                } catch (MongoException e) {
                    if (connection != null) {
                        connection.release();
                    }
                } catch (Throwable th) {
                    if (connection != null) {
                        connection.release();
                    }
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldPrune(ServerSessionImpl serverSession) {
        Integer logicalSessionTimeoutMinutes = this.cluster.getCurrentDescription().getLogicalSessionTimeoutMinutes();
        if (logicalSessionTimeoutMinutes == null) {
            return false;
        }
        return serverSession.isMarkedDirty() || this.clock.millis() - serverSession.getLastUsedAtMillis() > TimeUnit.MINUTES.toMillis((long) (logicalSessionTimeoutMinutes.intValue() - 1));
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/session/ServerSessionPool$ServerSessionImpl.class */
    public final class ServerSessionImpl implements ServerSession {
        private final BsonDocument identifier;
        private volatile long lastUsedAtMillis;
        private volatile boolean closed;
        private long transactionNumber = 0;
        private volatile boolean dirty = false;

        ServerSessionImpl(BsonBinary identifier) {
            this.lastUsedAtMillis = ServerSessionPool.this.clock.millis();
            this.identifier = new BsonDocument("id", identifier);
        }

        void close() {
            this.closed = true;
        }

        long getLastUsedAtMillis() {
            return this.lastUsedAtMillis;
        }

        @Override // com.mongodb.session.ServerSession
        public long getTransactionNumber() {
            return this.transactionNumber;
        }

        @Override // com.mongodb.session.ServerSession
        public BsonDocument getIdentifier() {
            this.lastUsedAtMillis = ServerSessionPool.this.clock.millis();
            return this.identifier;
        }

        @Override // com.mongodb.session.ServerSession
        public long advanceTransactionNumber() {
            this.transactionNumber++;
            return this.transactionNumber;
        }

        @Override // com.mongodb.session.ServerSession
        public boolean isClosed() {
            return this.closed;
        }

        @Override // com.mongodb.session.ServerSession
        public void markDirty() {
            this.dirty = true;
        }

        @Override // com.mongodb.session.ServerSession
        public boolean isMarkedDirty() {
            return this.dirty;
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/session/ServerSessionPool$ServerSessionItemFactory.class */
    private final class ServerSessionItemFactory implements ConcurrentPool.ItemFactory<ServerSessionImpl> {
        private ServerSessionItemFactory() {
        }

        @Override // com.mongodb.internal.connection.ConcurrentPool.ItemFactory
        public ServerSessionImpl create(boolean initialize) {
            return new ServerSessionImpl(createNewServerSessionIdentifier());
        }

        public void close(ServerSessionImpl serverSession) {
            ServerSessionPool.this.closeSession(serverSession);
        }

        public ConcurrentPool.Prune shouldPrune(ServerSessionImpl serverSession) {
            return ServerSessionPool.this.shouldPrune(serverSession) ? ConcurrentPool.Prune.YES : ConcurrentPool.Prune.STOP;
        }

        private BsonBinary createNewServerSessionIdentifier() {
            UuidCodec uuidCodec = new UuidCodec(UuidRepresentation.STANDARD);
            BsonDocument holder = new BsonDocument();
            BsonDocumentWriter bsonDocumentWriter = new BsonDocumentWriter(holder);
            bsonDocumentWriter.writeStartDocument();
            bsonDocumentWriter.writeName("id");
            uuidCodec.encode((BsonWriter) bsonDocumentWriter, UUID.randomUUID(), EncoderContext.builder().build());
            bsonDocumentWriter.writeEndDocument();
            return holder.getBinary("id");
        }
    }
}
