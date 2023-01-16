package com.mongodb.internal.connection;

import org.bson.BsonBinary;
import org.bson.BsonDbPointer;
import org.bson.BsonReader;
import org.bson.BsonRegularExpression;
import org.bson.BsonTimestamp;
import org.bson.BsonWriter;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/FieldTrackingBsonWriter.class */
public class FieldTrackingBsonWriter extends BsonWriterDecorator {
    private boolean hasWrittenField;
    private boolean topLevelDocumentWritten;

    public FieldTrackingBsonWriter(BsonWriter bsonWriter) {
        super(bsonWriter);
    }

    public boolean hasWrittenField() {
        return this.hasWrittenField;
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartDocument(String name) {
        if (this.topLevelDocumentWritten) {
            this.hasWrittenField = true;
        }
        writeStartDocument(name);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartDocument() {
        if (this.topLevelDocumentWritten) {
            this.hasWrittenField = true;
        }
        this.topLevelDocumentWritten = true;
        writeStartDocument();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartArray(String name) {
        this.hasWrittenField = true;
        writeStartArray(name);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartArray() {
        this.hasWrittenField = true;
        writeStartArray();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeBinaryData(String name, BsonBinary binary) {
        this.hasWrittenField = true;
        writeBinaryData(name, binary);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeBinaryData(BsonBinary binary) {
        this.hasWrittenField = true;
        writeBinaryData(binary);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeBoolean(String name, boolean value) {
        this.hasWrittenField = true;
        writeBoolean(name, value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeBoolean(boolean value) {
        this.hasWrittenField = true;
        writeBoolean(value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDateTime(String name, long value) {
        this.hasWrittenField = true;
        writeDateTime(name, value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDateTime(long value) {
        this.hasWrittenField = true;
        writeDateTime(value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDBPointer(String name, BsonDbPointer value) {
        this.hasWrittenField = true;
        writeDBPointer(name, value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDBPointer(BsonDbPointer value) {
        this.hasWrittenField = true;
        writeDBPointer(value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDouble(String name, double value) {
        this.hasWrittenField = true;
        writeDouble(name, value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDouble(double value) {
        this.hasWrittenField = true;
        writeDouble(value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeInt32(String name, int value) {
        this.hasWrittenField = true;
        writeInt32(name, value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeInt32(int value) {
        this.hasWrittenField = true;
        writeInt32(value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeInt64(String name, long value) {
        writeInt64(name, value);
        this.hasWrittenField = true;
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeInt64(long value) {
        this.hasWrittenField = true;
        writeInt64(value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDecimal128(Decimal128 value) {
        this.hasWrittenField = true;
        writeDecimal128(value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDecimal128(String name, Decimal128 value) {
        this.hasWrittenField = true;
        writeDecimal128(name, value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeJavaScript(String name, String code) {
        this.hasWrittenField = true;
        writeJavaScript(name, code);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeJavaScript(String code) {
        this.hasWrittenField = true;
        writeJavaScript(code);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeJavaScriptWithScope(String name, String code) {
        writeJavaScriptWithScope(name, code);
        this.hasWrittenField = true;
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeJavaScriptWithScope(String code) {
        this.hasWrittenField = true;
        writeJavaScriptWithScope(code);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeMaxKey(String name) {
        this.hasWrittenField = true;
        writeMaxKey(name);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeMaxKey() {
        this.hasWrittenField = true;
        writeMaxKey();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeMinKey(String name) {
        this.hasWrittenField = true;
        writeMinKey(name);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeMinKey() {
        this.hasWrittenField = true;
        writeMinKey();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeNull(String name) {
        this.hasWrittenField = true;
        writeNull(name);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeNull() {
        this.hasWrittenField = true;
        writeNull();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeObjectId(String name, ObjectId objectId) {
        this.hasWrittenField = true;
        writeObjectId(name, objectId);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeObjectId(ObjectId objectId) {
        this.hasWrittenField = true;
        writeObjectId(objectId);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeRegularExpression(String name, BsonRegularExpression regularExpression) {
        this.hasWrittenField = true;
        writeRegularExpression(name, regularExpression);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeRegularExpression(BsonRegularExpression regularExpression) {
        this.hasWrittenField = true;
        writeRegularExpression(regularExpression);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeString(String name, String value) {
        this.hasWrittenField = true;
        writeString(name, value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeString(String value) {
        this.hasWrittenField = true;
        writeString(value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeSymbol(String name, String value) {
        this.hasWrittenField = true;
        writeSymbol(name, value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeSymbol(String value) {
        this.hasWrittenField = true;
        writeSymbol(value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeTimestamp(String name, BsonTimestamp value) {
        this.hasWrittenField = true;
        writeTimestamp(name, value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeTimestamp(BsonTimestamp value) {
        this.hasWrittenField = true;
        writeTimestamp(value);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeUndefined(String name) {
        this.hasWrittenField = true;
        writeUndefined(name);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeUndefined() {
        this.hasWrittenField = true;
        writeUndefined();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void pipe(BsonReader reader) {
        this.hasWrittenField = true;
        pipe(reader);
    }
}
