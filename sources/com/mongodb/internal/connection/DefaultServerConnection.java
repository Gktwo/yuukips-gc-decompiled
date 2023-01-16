package com.mongodb.internal.connection;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcernResult;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerType;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.InsertRequest;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.session.SessionContext;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.FieldNameValidator;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultServerConnection.class */
public class DefaultServerConnection extends AbstractReferenceCounted implements Connection, AsyncConnection {
    private static final Logger LOGGER = Loggers.getLogger("connection");
    private final InternalConnection wrapped;
    private final ProtocolExecutor protocolExecutor;
    private final ClusterConnectionMode clusterConnectionMode;

    @Override // com.mongodb.internal.connection.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted
    public /* bridge */ /* synthetic */ int getCount() {
        return getCount();
    }

    public DefaultServerConnection(InternalConnection wrapped, ProtocolExecutor protocolExecutor, ClusterConnectionMode clusterConnectionMode) {
        this.wrapped = wrapped;
        this.protocolExecutor = protocolExecutor;
        this.clusterConnectionMode = clusterConnectionMode;
    }

    @Override // com.mongodb.internal.connection.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    public DefaultServerConnection retain() {
        retain();
        return this;
    }

    @Override // com.mongodb.internal.connection.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted
    public void release() {
        release();
        if (getCount() == 0) {
            this.wrapped.close();
        }
    }

    @Override // com.mongodb.internal.connection.Connection
    public ConnectionDescription getDescription() {
        Assertions.isTrue("open", getCount() > 0);
        return this.wrapped.getDescription();
    }

    @Override // com.mongodb.internal.connection.Connection
    public WriteConcernResult insert(MongoNamespace namespace, boolean ordered, InsertRequest insertRequest) {
        return (WriteConcernResult) executeProtocol(new InsertProtocol(namespace, ordered, insertRequest));
    }

    @Override // com.mongodb.internal.connection.AsyncConnection
    public void insertAsync(MongoNamespace namespace, boolean ordered, InsertRequest insertRequest, SingleResultCallback<WriteConcernResult> callback) {
        executeProtocolAsync(new InsertProtocol(namespace, ordered, insertRequest), callback);
    }

    @Override // com.mongodb.internal.connection.Connection
    public WriteConcernResult update(MongoNamespace namespace, boolean ordered, UpdateRequest updateRequest) {
        return (WriteConcernResult) executeProtocol(new UpdateProtocol(namespace, ordered, updateRequest));
    }

    @Override // com.mongodb.internal.connection.AsyncConnection
    public void updateAsync(MongoNamespace namespace, boolean ordered, UpdateRequest updateRequest, SingleResultCallback<WriteConcernResult> callback) {
        executeProtocolAsync(new UpdateProtocol(namespace, ordered, updateRequest), callback);
    }

    @Override // com.mongodb.internal.connection.Connection
    public WriteConcernResult delete(MongoNamespace namespace, boolean ordered, DeleteRequest deleteRequest) {
        return (WriteConcernResult) executeProtocol(new DeleteProtocol(namespace, ordered, deleteRequest));
    }

    @Override // com.mongodb.internal.connection.AsyncConnection
    public void deleteAsync(MongoNamespace namespace, boolean ordered, DeleteRequest deleteRequest, SingleResultCallback<WriteConcernResult> callback) {
        executeProtocolAsync(new DeleteProtocol(namespace, ordered, deleteRequest), callback);
    }

    @Override // com.mongodb.internal.connection.Connection
    public <T> T command(String database, BsonDocument command, FieldNameValidator fieldNameValidator, ReadPreference readPreference, Decoder<T> commandResultDecoder, SessionContext sessionContext) {
        return (T) command(database, command, fieldNameValidator, readPreference, commandResultDecoder, sessionContext, true, null, null);
    }

    @Override // com.mongodb.internal.connection.Connection
    public <T> T command(String database, BsonDocument command, FieldNameValidator commandFieldNameValidator, ReadPreference readPreference, Decoder<T> commandResultDecoder, SessionContext sessionContext, boolean responseExpected, SplittablePayload payload, FieldNameValidator payloadFieldNameValidator) {
        return (T) executeProtocol(new CommandProtocolImpl(database, command, commandFieldNameValidator, readPreference, commandResultDecoder, responseExpected, payload, payloadFieldNameValidator, this.clusterConnectionMode), sessionContext);
    }

    @Override // com.mongodb.internal.connection.AsyncConnection
    public <T> void commandAsync(String database, BsonDocument command, FieldNameValidator fieldNameValidator, ReadPreference readPreference, Decoder<T> commandResultDecoder, SessionContext sessionContext, SingleResultCallback<T> callback) {
        commandAsync(database, command, fieldNameValidator, readPreference, commandResultDecoder, sessionContext, true, null, null, callback);
    }

    @Override // com.mongodb.internal.connection.AsyncConnection
    public <T> void commandAsync(String database, BsonDocument command, FieldNameValidator commandFieldNameValidator, ReadPreference readPreference, Decoder<T> commandResultDecoder, SessionContext sessionContext, boolean responseExpected, SplittablePayload payload, FieldNameValidator payloadFieldNameValidator, SingleResultCallback<T> callback) {
        executeProtocolAsync(new CommandProtocolImpl(database, command, commandFieldNameValidator, readPreference, commandResultDecoder, responseExpected, payload, payloadFieldNameValidator, this.clusterConnectionMode), sessionContext, callback);
    }

    @Override // com.mongodb.internal.connection.Connection
    public <T> QueryResult<T> query(MongoNamespace namespace, BsonDocument queryDocument, BsonDocument fields, int skip, int limit, int batchSize, boolean slaveOk, boolean tailableCursor, boolean awaitData, boolean noCursorTimeout, boolean partial, boolean oplogReplay, Decoder<T> resultDecoder) {
        return (QueryResult) executeProtocol(new QueryProtocol(namespace, skip, limit, batchSize, queryDocument, fields, resultDecoder).tailableCursor(tailableCursor).slaveOk(getSlaveOk(slaveOk)).oplogReplay(oplogReplay).noCursorTimeout(noCursorTimeout).awaitData(awaitData).partial(partial));
    }

    @Override // com.mongodb.internal.connection.AsyncConnection
    public <T> void queryAsync(MongoNamespace namespace, BsonDocument queryDocument, BsonDocument fields, int skip, int limit, int batchSize, boolean slaveOk, boolean tailableCursor, boolean awaitData, boolean noCursorTimeout, boolean partial, boolean oplogReplay, Decoder<T> resultDecoder, SingleResultCallback<QueryResult<T>> callback) {
        executeProtocolAsync(new QueryProtocol(namespace, skip, limit, batchSize, queryDocument, fields, resultDecoder).tailableCursor(tailableCursor).slaveOk(getSlaveOk(slaveOk)).oplogReplay(oplogReplay).noCursorTimeout(noCursorTimeout).awaitData(awaitData).partial(partial), callback);
    }

    @Override // com.mongodb.internal.connection.Connection
    public <T> QueryResult<T> getMore(MongoNamespace namespace, long cursorId, int numberToReturn, Decoder<T> resultDecoder) {
        return (QueryResult) executeProtocol(new GetMoreProtocol(namespace, cursorId, numberToReturn, resultDecoder));
    }

    @Override // com.mongodb.internal.connection.AsyncConnection
    public <T> void getMoreAsync(MongoNamespace namespace, long cursorId, int numberToReturn, Decoder<T> resultDecoder, SingleResultCallback<QueryResult<T>> callback) {
        executeProtocolAsync(new GetMoreProtocol(namespace, cursorId, numberToReturn, resultDecoder), callback);
    }

    @Override // com.mongodb.internal.connection.Connection
    public void killCursor(MongoNamespace namespace, List<Long> cursors) {
        executeProtocol(new KillCursorProtocol(namespace, cursors));
    }

    @Override // com.mongodb.internal.connection.AsyncConnection
    public void killCursorAsync(MongoNamespace namespace, List<Long> cursors, SingleResultCallback<Void> callback) {
        executeProtocolAsync(new KillCursorProtocol(namespace, cursors), callback);
    }

    private boolean getSlaveOk(boolean slaveOk) {
        return slaveOk || (this.clusterConnectionMode == ClusterConnectionMode.SINGLE && this.wrapped.getDescription().getServerType() != ServerType.SHARD_ROUTER);
    }

    private <T> T executeProtocol(LegacyProtocol<T> protocol) {
        return (T) this.protocolExecutor.execute(protocol, this.wrapped);
    }

    private <T> T executeProtocol(CommandProtocol<T> protocol, SessionContext sessionContext) {
        return (T) this.protocolExecutor.execute(protocol, this.wrapped, sessionContext);
    }

    private <T> void executeProtocolAsync(LegacyProtocol<T> protocol, SingleResultCallback<T> callback) {
        SingleResultCallback<T> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, LOGGER);
        try {
            this.protocolExecutor.executeAsync(protocol, this.wrapped, errHandlingCallback);
        } catch (Throwable t) {
            errHandlingCallback.onResult(null, t);
        }
    }

    private <T> void executeProtocolAsync(CommandProtocol<T> protocol, SessionContext sessionContext, SingleResultCallback<T> callback) {
        SingleResultCallback<T> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, LOGGER);
        try {
            this.protocolExecutor.executeAsync(protocol, this.wrapped, sessionContext, errHandlingCallback);
        } catch (Throwable t) {
            errHandlingCallback.onResult(null, t);
        }
    }
}
