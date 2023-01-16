package com.mongodb.internal.connection;

import java.util.List;
import org.bson.BsonBinaryWriter;
import org.bson.BsonElement;
import org.bson.BsonReader;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ElementExtendingBsonWriter.class */
public class ElementExtendingBsonWriter extends LevelCountingBsonWriter {
    private final BsonBinaryWriter writer;
    private final List<BsonElement> extraElements;

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
    public /* bridge */ /* synthetic */ void writeStartDocument() {
        writeStartDocument();
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public /* bridge */ /* synthetic */ void writeStartDocument(String str) {
        writeStartDocument(str);
    }

    public ElementExtendingBsonWriter(BsonBinaryWriter writer, List<BsonElement> extraElements) {
        super(writer);
        this.writer = writer;
        this.extraElements = extraElements;
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeEndDocument() {
        if (getCurrentLevel() == 0) {
            BsonWriterHelper.writeElements(this.writer, this.extraElements);
        }
        writeEndDocument();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void pipe(BsonReader reader) {
        if (getCurrentLevel() == -1) {
            this.writer.pipe(reader, this.extraElements);
        } else {
            this.writer.pipe(reader);
        }
    }
}
