package com.mongodb.internal.connection;

import org.bson.BsonBinary;
import org.bson.BsonDbPointer;
import org.bson.BsonReader;
import org.bson.BsonRegularExpression;
import org.bson.BsonTimestamp;
import org.bson.BsonWriter;
import org.bson.assertions.Assertions;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/BsonWriterDecorator.class */
public class BsonWriterDecorator implements BsonWriter {
    private final BsonWriter bsonWriter;

    /* access modifiers changed from: package-private */
    public BsonWriterDecorator(BsonWriter bsonWriter) {
        this.bsonWriter = (BsonWriter) Assertions.notNull("bsonWriter", bsonWriter);
    }

    BsonWriter getBsonWriter() {
        return this.bsonWriter;
    }

    @Override // org.bson.BsonWriter
    public void writeStartDocument(String name) {
        this.bsonWriter.writeStartDocument(name);
    }

    @Override // org.bson.BsonWriter
    public void writeStartDocument() {
        this.bsonWriter.writeStartDocument();
    }

    @Override // org.bson.BsonWriter
    public void writeEndDocument() {
        this.bsonWriter.writeEndDocument();
    }

    @Override // org.bson.BsonWriter
    public void writeStartArray(String name) {
        this.bsonWriter.writeStartArray(name);
    }

    @Override // org.bson.BsonWriter
    public void writeStartArray() {
        this.bsonWriter.writeStartArray();
    }

    @Override // org.bson.BsonWriter
    public void writeEndArray() {
        this.bsonWriter.writeEndArray();
    }

    @Override // org.bson.BsonWriter
    public void writeBinaryData(String name, BsonBinary binary) {
        this.bsonWriter.writeBinaryData(name, binary);
    }

    @Override // org.bson.BsonWriter
    public void writeBinaryData(BsonBinary binary) {
        this.bsonWriter.writeBinaryData(binary);
    }

    @Override // org.bson.BsonWriter
    public void writeBoolean(String name, boolean value) {
        this.bsonWriter.writeBoolean(name, value);
    }

    @Override // org.bson.BsonWriter
    public void writeBoolean(boolean value) {
        this.bsonWriter.writeBoolean(value);
    }

    @Override // org.bson.BsonWriter
    public void writeDateTime(String name, long value) {
        this.bsonWriter.writeDateTime(name, value);
    }

    @Override // org.bson.BsonWriter
    public void writeDateTime(long value) {
        this.bsonWriter.writeDateTime(value);
    }

    @Override // org.bson.BsonWriter
    public void writeDBPointer(String name, BsonDbPointer value) {
        this.bsonWriter.writeDBPointer(name, value);
    }

    @Override // org.bson.BsonWriter
    public void writeDBPointer(BsonDbPointer value) {
        this.bsonWriter.writeDBPointer(value);
    }

    @Override // org.bson.BsonWriter
    public void writeDouble(String name, double value) {
        this.bsonWriter.writeDouble(name, value);
    }

    @Override // org.bson.BsonWriter
    public void writeDouble(double value) {
        this.bsonWriter.writeDouble(value);
    }

    @Override // org.bson.BsonWriter
    public void writeInt32(String name, int value) {
        this.bsonWriter.writeInt32(name, value);
    }

    @Override // org.bson.BsonWriter
    public void writeInt32(int value) {
        this.bsonWriter.writeInt32(value);
    }

    @Override // org.bson.BsonWriter
    public void writeInt64(String name, long value) {
        this.bsonWriter.writeInt64(name, value);
    }

    @Override // org.bson.BsonWriter
    public void writeInt64(long value) {
        this.bsonWriter.writeInt64(value);
    }

    @Override // org.bson.BsonWriter
    public void writeDecimal128(Decimal128 value) {
        this.bsonWriter.writeDecimal128(value);
    }

    @Override // org.bson.BsonWriter
    public void writeDecimal128(String name, Decimal128 value) {
        this.bsonWriter.writeDecimal128(name, value);
    }

    @Override // org.bson.BsonWriter
    public void writeJavaScript(String name, String code) {
        this.bsonWriter.writeJavaScript(name, code);
    }

    @Override // org.bson.BsonWriter
    public void writeJavaScript(String code) {
        this.bsonWriter.writeJavaScript(code);
    }

    @Override // org.bson.BsonWriter
    public void writeJavaScriptWithScope(String name, String code) {
        this.bsonWriter.writeJavaScriptWithScope(name, code);
    }

    @Override // org.bson.BsonWriter
    public void writeJavaScriptWithScope(String code) {
        this.bsonWriter.writeJavaScriptWithScope(code);
    }

    @Override // org.bson.BsonWriter
    public void writeMaxKey(String name) {
        this.bsonWriter.writeMaxKey(name);
    }

    @Override // org.bson.BsonWriter
    public void writeMaxKey() {
        this.bsonWriter.writeMaxKey();
    }

    @Override // org.bson.BsonWriter
    public void writeMinKey(String name) {
        this.bsonWriter.writeMinKey(name);
    }

    @Override // org.bson.BsonWriter
    public void writeMinKey() {
        this.bsonWriter.writeMinKey();
    }

    @Override // org.bson.BsonWriter
    public void writeName(String name) {
        this.bsonWriter.writeName(name);
    }

    @Override // org.bson.BsonWriter
    public void writeNull(String name) {
        this.bsonWriter.writeNull(name);
    }

    @Override // org.bson.BsonWriter
    public void writeNull() {
        this.bsonWriter.writeNull();
    }

    @Override // org.bson.BsonWriter
    public void writeObjectId(String name, ObjectId objectId) {
        this.bsonWriter.writeObjectId(name, objectId);
    }

    @Override // org.bson.BsonWriter
    public void writeObjectId(ObjectId objectId) {
        this.bsonWriter.writeObjectId(objectId);
    }

    @Override // org.bson.BsonWriter
    public void writeRegularExpression(String name, BsonRegularExpression regularExpression) {
        this.bsonWriter.writeRegularExpression(name, regularExpression);
    }

    @Override // org.bson.BsonWriter
    public void writeRegularExpression(BsonRegularExpression regularExpression) {
        this.bsonWriter.writeRegularExpression(regularExpression);
    }

    @Override // org.bson.BsonWriter
    public void writeString(String name, String value) {
        this.bsonWriter.writeString(name, value);
    }

    @Override // org.bson.BsonWriter
    public void writeString(String value) {
        this.bsonWriter.writeString(value);
    }

    @Override // org.bson.BsonWriter
    public void writeSymbol(String name, String value) {
        this.bsonWriter.writeSymbol(name, value);
    }

    @Override // org.bson.BsonWriter
    public void writeSymbol(String value) {
        this.bsonWriter.writeSymbol(value);
    }

    @Override // org.bson.BsonWriter
    public void writeTimestamp(String name, BsonTimestamp value) {
        this.bsonWriter.writeTimestamp(name, value);
    }

    @Override // org.bson.BsonWriter
    public void writeTimestamp(BsonTimestamp value) {
        this.bsonWriter.writeTimestamp(value);
    }

    @Override // org.bson.BsonWriter
    public void writeUndefined(String name) {
        this.bsonWriter.writeUndefined(name);
    }

    @Override // org.bson.BsonWriter
    public void writeUndefined() {
        this.bsonWriter.writeUndefined();
    }

    @Override // org.bson.BsonWriter
    public void pipe(BsonReader reader) {
        this.bsonWriter.pipe(reader);
    }

    @Override // org.bson.BsonWriter
    public void flush() {
        this.bsonWriter.flush();
    }
}
