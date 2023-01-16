package dev.morphia.experimental;

import com.mongodb.ClientSessionOptions;
import com.mongodb.ServerAddress;
import com.mongodb.TransactionOptions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.TransactionBody;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import com.mongodb.session.ServerSession;
import dev.morphia.DatastoreImpl;
import dev.morphia.mapping.Mapper;
import dev.morphia.query.QueryFactory;
import org.bson.BsonDocument;
import org.bson.BsonTimestamp;

/* loaded from: grasscutter.jar:dev/morphia/experimental/BaseMorphiaSession.class */
public abstract class BaseMorphiaSession extends DatastoreImpl implements MorphiaSession {
    private final ClientSession session;

    /* access modifiers changed from: package-private */
    public BaseMorphiaSession(ClientSession session, MongoClient mongoClient, MongoDatabase database, Mapper mapper, QueryFactory queryFactory) {
        super(database, mongoClient, mapper, queryFactory);
        this.session = session;
    }

    @Override // com.mongodb.client.ClientSession, com.mongodb.session.ClientSession
    @Nullable
    public ServerAddress getPinnedServerAddress() {
        return this.session.getPinnedServerAddress();
    }

    @Override // com.mongodb.client.ClientSession, com.mongodb.session.ClientSession
    public void setPinnedServerAddress(@Nullable ServerAddress address) {
        this.session.setPinnedServerAddress(address);
    }

    @Override // com.mongodb.client.ClientSession
    public boolean hasActiveTransaction() {
        return this.session.hasActiveTransaction();
    }

    @Override // com.mongodb.client.ClientSession
    public boolean notifyMessageSent() {
        return this.session.notifyMessageSent();
    }

    @Override // com.mongodb.client.ClientSession
    public TransactionOptions getTransactionOptions() {
        return this.session.getTransactionOptions();
    }

    @Override // com.mongodb.client.ClientSession
    public void startTransaction() {
        this.session.startTransaction();
    }

    @Override // com.mongodb.client.ClientSession
    public void startTransaction(TransactionOptions transactionOptions) {
        this.session.startTransaction(transactionOptions);
    }

    @Override // com.mongodb.client.ClientSession
    public void commitTransaction() {
        this.session.commitTransaction();
    }

    @Override // com.mongodb.client.ClientSession
    public void abortTransaction() {
        this.session.abortTransaction();
    }

    @Override // com.mongodb.client.ClientSession
    public <T> T withTransaction(TransactionBody<T> transactionBody) {
        return (T) this.session.withTransaction(transactionBody);
    }

    @Override // com.mongodb.client.ClientSession
    public <T> T withTransaction(TransactionBody<T> transactionBody, TransactionOptions options) {
        return (T) this.session.withTransaction(transactionBody, options);
    }

    @Override // com.mongodb.session.ClientSession
    @Nullable
    public BsonDocument getRecoveryToken() {
        return this.session.getRecoveryToken();
    }

    @Override // com.mongodb.session.ClientSession
    public void setRecoveryToken(BsonDocument recoveryToken) {
        this.session.setRecoveryToken(recoveryToken);
    }

    @Override // com.mongodb.session.ClientSession
    public ClientSessionOptions getOptions() {
        return this.session.getOptions();
    }

    @Override // com.mongodb.session.ClientSession
    public boolean isCausallyConsistent() {
        return this.session.isCausallyConsistent();
    }

    @Override // com.mongodb.session.ClientSession
    public Object getOriginator() {
        return this.session.getOriginator();
    }

    @Override // com.mongodb.session.ClientSession
    public ServerSession getServerSession() {
        return this.session.getServerSession();
    }

    @Override // com.mongodb.session.ClientSession
    public BsonTimestamp getOperationTime() {
        return this.session.getOperationTime();
    }

    @Override // com.mongodb.session.ClientSession
    public void advanceOperationTime(BsonTimestamp operationTime) {
        this.session.advanceOperationTime(operationTime);
    }

    @Override // com.mongodb.session.ClientSession
    public void advanceClusterTime(BsonDocument clusterTime) {
        this.session.advanceClusterTime(clusterTime);
    }

    @Override // com.mongodb.session.ClientSession
    public BsonDocument getClusterTime() {
        return this.session.getClusterTime();
    }

    @Override // com.mongodb.session.ClientSession, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.session.close();
    }

    @Override // dev.morphia.Datastore
    @NonNull
    public ClientSession getSession() {
        return this.session;
    }
}
