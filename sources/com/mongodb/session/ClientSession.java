package com.mongodb.session;

import com.mongodb.ClientSessionOptions;
import com.mongodb.ServerAddress;
import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.lang.Nullable;
import java.io.Closeable;
import org.bson.BsonDocument;
import org.bson.BsonTimestamp;

@NotThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/session/ClientSession.class */
public interface ClientSession extends Closeable {
    @Nullable
    ServerAddress getPinnedServerAddress();

    void setPinnedServerAddress(ServerAddress serverAddress);

    @Nullable
    BsonDocument getRecoveryToken();

    void setRecoveryToken(BsonDocument bsonDocument);

    ClientSessionOptions getOptions();

    boolean isCausallyConsistent();

    Object getOriginator();

    ServerSession getServerSession();

    BsonTimestamp getOperationTime();

    void advanceOperationTime(BsonTimestamp bsonTimestamp);

    void advanceClusterTime(BsonDocument bsonDocument);

    BsonDocument getClusterTime();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
