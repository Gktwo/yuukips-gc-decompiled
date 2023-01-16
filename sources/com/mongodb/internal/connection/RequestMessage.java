package com.mongodb.internal.connection;

import com.mongodb.assertions.Assertions;
import com.mongodb.internal.session.SessionContext;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.bson.BsonBinaryWriter;
import org.bson.BsonBinaryWriterSettings;
import org.bson.BsonDocument;
import org.bson.BsonElement;
import org.bson.BsonWriter;
import org.bson.BsonWriterSettings;
import org.bson.FieldNameValidator;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.Codec;
import org.bson.codecs.Encoder;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.p022io.BsonOutput;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/RequestMessage.class */
public abstract class RequestMessage {
    static final int MESSAGE_PROLOGUE_LENGTH = 16;
    private static final int DOCUMENT_HEADROOM = 16384;
    private final String collectionName;
    private final MessageSettings settings;

    /* renamed from: id */
    private final int f456id;
    private final OpCode opCode;
    private EncodingMetadata encodingMetadata;
    static final AtomicInteger REQUEST_ID = new AtomicInteger(1);
    private static final CodecRegistry REGISTRY = CodecRegistries.fromProviders(new BsonValueCodecProvider());

    protected abstract EncodingMetadata encodeMessageBodyWithMetadata(BsonOutput bsonOutput, SessionContext sessionContext);

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/RequestMessage$EncodingMetadata.class */
    static class EncodingMetadata {
        private final int firstDocumentPosition;

        /* access modifiers changed from: package-private */
        public EncodingMetadata(int firstDocumentPosition) {
            this.firstDocumentPosition = firstDocumentPosition;
        }

        public int getFirstDocumentPosition() {
            return this.firstDocumentPosition;
        }
    }

    public static int getCurrentGlobalId() {
        return REQUEST_ID.get();
    }

    /* access modifiers changed from: package-private */
    public RequestMessage(OpCode opCode, MessageSettings settings) {
        this((String) null, opCode, settings);
    }

    /* access modifiers changed from: package-private */
    public RequestMessage(OpCode opCode, int requestId, MessageSettings settings) {
        this(null, opCode, requestId, settings);
    }

    /* access modifiers changed from: package-private */
    public RequestMessage(String collectionName, OpCode opCode, MessageSettings settings) {
        this(collectionName, opCode, REQUEST_ID.getAndIncrement(), settings);
    }

    private RequestMessage(String collectionName, OpCode opCode, int requestId, MessageSettings settings) {
        this.collectionName = collectionName;
        this.settings = settings;
        this.f456id = requestId;
        this.opCode = opCode;
    }

    public int getId() {
        return this.f456id;
    }

    public OpCode getOpCode() {
        return this.opCode;
    }

    public MessageSettings getSettings() {
        return this.settings;
    }

    public void encode(BsonOutput bsonOutput, SessionContext sessionContext) {
        Assertions.notNull("sessionContext", sessionContext);
        int messageStartPosition = bsonOutput.getPosition();
        writeMessagePrologue(bsonOutput);
        EncodingMetadata encodingMetadata = encodeMessageBodyWithMetadata(bsonOutput, sessionContext);
        backpatchMessageLength(messageStartPosition, bsonOutput);
        this.encodingMetadata = encodingMetadata;
    }

    public EncodingMetadata getEncodingMetadata() {
        return this.encodingMetadata;
    }

    protected void writeMessagePrologue(BsonOutput bsonOutput) {
        bsonOutput.writeInt32(0);
        bsonOutput.writeInt32(this.f456id);
        bsonOutput.writeInt32(0);
        bsonOutput.writeInt32(this.opCode.getValue());
    }

    protected void addDocument(BsonDocument document, BsonOutput bsonOutput, FieldNameValidator validator) {
        addDocument(document, getCodec(document), EncoderContext.builder().build(), bsonOutput, validator, this.settings.getMaxDocumentSize() + 16384, null);
    }

    protected void addDocument(BsonDocument document, BsonOutput bsonOutput, FieldNameValidator validator, List<BsonElement> extraElements) {
        addDocument(document, getCodec(document), EncoderContext.builder().build(), bsonOutput, validator, this.settings.getMaxDocumentSize() + 16384, extraElements);
    }

    protected void addCollectibleDocument(BsonDocument document, BsonOutput bsonOutput, FieldNameValidator validator) {
        addDocument(document, getCodec(document), EncoderContext.builder().isEncodingCollectibleDocument(true).build(), bsonOutput, validator, this.settings.getMaxDocumentSize(), null);
    }

    protected void backpatchMessageLength(int startPosition, BsonOutput bsonOutput) {
        int messageLength = bsonOutput.getPosition() - startPosition;
        bsonOutput.writeInt32(bsonOutput.getPosition() - messageLength, messageLength);
    }

    protected String getCollectionName() {
        return this.collectionName;
    }

    Codec<BsonDocument> getCodec(BsonDocument document) {
        return REGISTRY.get(document.getClass());
    }

    private <T> void addDocument(T obj, Encoder<T> encoder, EncoderContext encoderContext, BsonOutput bsonOutput, FieldNameValidator validator, int maxDocumentSize, List<BsonElement> extraElements) {
        BsonWriter bsonWriter;
        BsonBinaryWriter bsonBinaryWriter = new BsonBinaryWriter(new BsonWriterSettings(), new BsonBinaryWriterSettings(maxDocumentSize), bsonOutput, validator);
        if (extraElements == null) {
            bsonWriter = bsonBinaryWriter;
        } else {
            bsonWriter = new ElementExtendingBsonWriter(bsonBinaryWriter, extraElements);
        }
        encoder.encode(bsonWriter, obj, encoderContext);
    }
}
