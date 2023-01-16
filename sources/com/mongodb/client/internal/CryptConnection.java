package com.mongodb.client.internal;

import com.mongodb.MongoClientException;
import com.mongodb.MongoNamespace;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcernResult;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.InsertRequest;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.MessageSettings;
import com.mongodb.internal.connection.QueryResult;
import com.mongodb.internal.connection.SplittablePayload;
import com.mongodb.internal.connection.SplittablePayloadBsonWriter;
import com.mongodb.internal.operation.ServerVersionHelper;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.internal.validator.MappedFieldNameValidator;
import com.mongodb.lang.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.BsonBinaryReader;
import org.bson.BsonBinaryWriter;
import org.bson.BsonBinaryWriterSettings;
import org.bson.BsonDocument;
import org.bson.BsonWriter;
import org.bson.BsonWriterSettings;
import org.bson.FieldNameValidator;
import org.bson.RawBsonDocument;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.Codec;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.RawBsonDocumentCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.p022io.BasicOutputBuffer;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/CryptConnection.class */
class CryptConnection implements Connection {
    private static final CodecRegistry REGISTRY = CodecRegistries.fromProviders(new BsonValueCodecProvider());
    private static final int MAX_SPLITTABLE_DOCUMENT_SIZE = 2097152;
    private final Connection wrapped;
    private final Crypt crypt;

    /* access modifiers changed from: package-private */
    public CryptConnection(Connection wrapped, Crypt crypt) {
        this.wrapped = wrapped;
        this.crypt = crypt;
    }

    @Override // com.mongodb.internal.binding.ReferenceCounted
    public int getCount() {
        return this.wrapped.getCount();
    }

    @Override // com.mongodb.internal.connection.Connection, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    public CryptConnection retain() {
        this.wrapped.retain();
        return this;
    }

    @Override // com.mongodb.internal.binding.ReferenceCounted
    public void release() {
        this.wrapped.release();
    }

    @Override // com.mongodb.internal.connection.Connection
    public ConnectionDescription getDescription() {
        return this.wrapped.getDescription();
    }

    @Override // com.mongodb.internal.connection.Connection
    public <T> T command(String database, BsonDocument command, FieldNameValidator commandFieldNameValidator, ReadPreference readPreference, Decoder<T> commandResultDecoder, SessionContext sessionContext, boolean responseExpected, @Nullable SplittablePayload payload, @Nullable FieldNameValidator payloadFieldNameValidator) {
        BsonWriter writer;
        if (ServerVersionHelper.serverIsLessThanVersionFourDotTwo(this.wrapped.getDescription())) {
            throw new MongoClientException("Auto-encryption requires a minimum MongoDB version of 4.2");
        }
        BasicOutputBuffer bsonOutput = new BasicOutputBuffer();
        BsonBinaryWriter bsonBinaryWriter = new BsonBinaryWriter(new BsonWriterSettings(), new BsonBinaryWriterSettings(getDescription().getMaxDocumentSize()), bsonOutput, getFieldNameValidator(payload, commandFieldNameValidator, payloadFieldNameValidator));
        if (payload == null) {
            writer = bsonBinaryWriter;
        } else {
            writer = new SplittablePayloadBsonWriter(bsonBinaryWriter, bsonOutput, createSplittablePayloadMessageSettings(), payload, 2097152);
        }
        getEncoder(command).encode(writer, command, EncoderContext.builder().build());
        return commandResultDecoder.decode(new BsonBinaryReader(this.crypt.decrypt((RawBsonDocument) this.wrapped.command(database, this.crypt.encrypt(database, new RawBsonDocument(bsonOutput.getInternalBuffer(), 0, bsonOutput.getSize())), commandFieldNameValidator, readPreference, new RawBsonDocumentCodec(), sessionContext, responseExpected, null, null)).getByteBuffer().asNIO()), DecoderContext.builder().build());
    }

    @Override // com.mongodb.internal.connection.Connection
    public <T> T command(String database, BsonDocument command, FieldNameValidator fieldNameValidator, ReadPreference readPreference, Decoder<T> commandResultDecoder, SessionContext sessionContext) {
        return (T) command(database, command, fieldNameValidator, readPreference, commandResultDecoder, sessionContext, true, null, null);
    }

    private Codec<BsonDocument> getEncoder(BsonDocument command) {
        return REGISTRY.get(command.getClass());
    }

    private FieldNameValidator getFieldNameValidator(@Nullable SplittablePayload payload, FieldNameValidator commandFieldNameValidator, @Nullable FieldNameValidator payloadFieldNameValidator) {
        if (payload == null) {
            return commandFieldNameValidator;
        }
        Map<String, FieldNameValidator> rootMap = new HashMap<>();
        rootMap.put(payload.getPayloadName(), payloadFieldNameValidator);
        return new MappedFieldNameValidator(commandFieldNameValidator, rootMap);
    }

    private MessageSettings createSplittablePayloadMessageSettings() {
        return MessageSettings.builder().maxBatchCount(getDescription().getMaxBatchCount()).maxMessageSize(getDescription().getMaxMessageSize()).maxDocumentSize(getDescription().getMaxDocumentSize()).build();
    }

    @Override // com.mongodb.internal.connection.Connection
    public WriteConcernResult insert(MongoNamespace namespace, boolean ordered, InsertRequest insertRequest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.connection.Connection
    public WriteConcernResult update(MongoNamespace namespace, boolean ordered, UpdateRequest updateRequest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.connection.Connection
    public WriteConcernResult delete(MongoNamespace namespace, boolean ordered, DeleteRequest deleteRequest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.connection.Connection
    public <T> QueryResult<T> query(MongoNamespace namespace, BsonDocument queryDocument, BsonDocument fields, int skip, int limit, int batchSize, boolean slaveOk, boolean tailableCursor, boolean awaitData, boolean noCursorTimeout, boolean partial, boolean oplogReplay, Decoder<T> resultDecoder) {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.connection.Connection
    public <T> QueryResult<T> getMore(MongoNamespace namespace, long cursorId, int numberToReturn, Decoder<T> resultDecoder) {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.connection.Connection
    public void killCursor(MongoNamespace namespace, List<Long> cursors) {
        throw new UnsupportedOperationException();
    }
}
