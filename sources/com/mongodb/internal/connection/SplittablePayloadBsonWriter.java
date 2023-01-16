package com.mongodb.internal.connection;

import org.bson.BsonBinaryWriter;
import org.bson.BsonWriter;
import org.bson.p022io.BsonOutput;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/SplittablePayloadBsonWriter.class */
public class SplittablePayloadBsonWriter extends LevelCountingBsonWriter {
    private final BsonWriter writer;
    private final BsonOutput bsonOutput;
    private final SplittablePayload payload;
    private int maxSplittableDocumentSize;
    private final MessageSettings settings;
    private final int messageStartPosition;

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public /* bridge */ /* synthetic */ void writeEndArray() {
        writeEndArray();
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public /* bridge */ /* synthetic */ void writeStartArray(String str) {
        writeStartArray(str);
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public /* bridge */ /* synthetic */ void writeStartArray() {
        writeStartArray();
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public /* bridge */ /* synthetic */ void writeStartDocument(String str) {
        writeStartDocument(str);
    }

    public SplittablePayloadBsonWriter(BsonBinaryWriter writer, BsonOutput bsonOutput, MessageSettings settings, SplittablePayload payload, int maxSplittableDocumentSize) {
        this(writer, bsonOutput, 0, settings, payload, maxSplittableDocumentSize);
    }

    public SplittablePayloadBsonWriter(BsonBinaryWriter writer, BsonOutput bsonOutput, int messageStartPosition, MessageSettings settings, SplittablePayload payload) {
        this(writer, bsonOutput, messageStartPosition, settings, payload, settings.getMaxDocumentSize());
    }

    public SplittablePayloadBsonWriter(BsonBinaryWriter writer, BsonOutput bsonOutput, int messageStartPosition, MessageSettings settings, SplittablePayload payload, int maxSplittableDocumentSize) {
        super(writer);
        this.writer = writer;
        this.bsonOutput = bsonOutput;
        this.messageStartPosition = messageStartPosition;
        this.settings = settings;
        this.payload = payload;
        this.maxSplittableDocumentSize = maxSplittableDocumentSize;
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartDocument() {
        writeStartDocument();
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeEndDocument() {
        if (getCurrentLevel() == 0 && this.payload.hasPayload()) {
            BsonWriterHelper.writePayloadArray(this.writer, this.bsonOutput, this.settings, this.messageStartPosition, this.payload, this.maxSplittableDocumentSize);
        }
        writeEndDocument();
    }
}
