package com.mongodb.internal.connection;

import org.bson.BsonWriter;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/LevelCountingBsonWriter.class */
public abstract class LevelCountingBsonWriter extends BsonWriterDecorator {
    private int level = -1;

    /* access modifiers changed from: package-private */
    public LevelCountingBsonWriter(BsonWriter bsonWriter) {
        super(bsonWriter);
    }

    /* access modifiers changed from: package-private */
    public int getCurrentLevel() {
        return this.level;
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartDocument(String name) {
        this.level++;
        writeStartDocument(name);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartDocument() {
        this.level++;
        writeStartDocument();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeEndDocument() {
        this.level--;
        writeEndDocument();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartArray() {
        this.level++;
        writeStartArray();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartArray(String name) {
        this.level++;
        writeStartArray(name);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeEndArray() {
        this.level--;
        writeEndArray();
    }
}
