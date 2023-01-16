package dev.morphia.mapping.codec.writer;

import dev.morphia.mapping.Mapper;
import java.time.Instant;
import java.time.LocalDateTime;
import org.bson.BsonBinary;
import org.bson.BsonDbPointer;
import org.bson.BsonMaxKey;
import org.bson.BsonMinKey;
import org.bson.BsonReader;
import org.bson.BsonRegularExpression;
import org.bson.BsonSymbol;
import org.bson.BsonTimestamp;
import org.bson.BsonUndefined;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/writer/DocumentWriter.class */
public class DocumentWriter implements BsonWriter {
    private final RootState root;
    private WriteState state;
    private final Mapper mapper;

    public DocumentWriter(Mapper mapper) {
        this.mapper = mapper;
        this.root = new RootState(this);
        this.state = this.root;
    }

    public DocumentWriter(Mapper mapper, Document seed) {
        this.root = new RootState(this, seed);
        this.mapper = mapper;
        this.state = this.root;
    }

    public DocumentWriter encode(CodecRegistry codecRegistry, Object value, EncoderContext encoderContext) {
        codecRegistry.get(value.getClass()).encode(this, value, encoderContext);
        return this;
    }

    @Override // org.bson.BsonWriter
    public void flush() {
    }

    public Document getDocument() {
        return this.root.getDocument();
    }

    public WriteState state() {
        return this.state;
    }

    @Override // org.bson.BsonWriter
    public void writeBinaryData(BsonBinary binary) {
        this.state.value(binary);
    }

    @Override // org.bson.BsonWriter
    public void writeBinaryData(String name, BsonBinary binary) {
        this.state.name(name).value(binary);
    }

    @Override // org.bson.BsonWriter
    public void writeBoolean(boolean value) {
        this.state.value(Boolean.valueOf(value));
    }

    @Override // org.bson.BsonWriter
    public void writeBoolean(String name, boolean value) {
        this.state.name(name).value(Boolean.valueOf(value));
    }

    @Override // org.bson.BsonWriter
    public void writeDateTime(long value) {
        this.state.value(LocalDateTime.ofInstant(Instant.ofEpochMilli(value), this.mapper.getOptions().getDateStorage().getZone()));
    }

    @Override // org.bson.BsonWriter
    public void writeDateTime(String name, long value) {
        this.state.name(name);
        writeDateTime(value);
    }

    @Override // org.bson.BsonWriter
    public void writeDBPointer(BsonDbPointer value) {
        this.state.value(value);
    }

    @Override // org.bson.BsonWriter
    public void writeDBPointer(String name, BsonDbPointer value) {
        this.state.name(name).value(value);
    }

    @Override // org.bson.BsonWriter
    public void writeDouble(double value) {
        this.state.value(Double.valueOf(value));
    }

    @Override // org.bson.BsonWriter
    public void writeDouble(String name, double value) {
        this.state.name(name).value(Double.valueOf(value));
    }

    @Override // org.bson.BsonWriter
    public void writeEndArray() {
        this.state.end();
    }

    @Override // org.bson.BsonWriter
    public void writeEndDocument() {
        this.state.end();
    }

    @Override // org.bson.BsonWriter
    public void writeInt32(int value) {
        this.state.value(Integer.valueOf(value));
    }

    @Override // org.bson.BsonWriter
    public void writeInt32(String name, int value) {
        this.state.name(name).value(Integer.valueOf(value));
    }

    @Override // org.bson.BsonWriter
    public void writeInt64(long value) {
        this.state.value(Long.valueOf(value));
    }

    @Override // org.bson.BsonWriter
    public void writeInt64(String name, long value) {
        this.state.name(name).value(Long.valueOf(value));
    }

    @Override // org.bson.BsonWriter
    public void writeDecimal128(Decimal128 value) {
        this.state.value(value);
    }

    @Override // org.bson.BsonWriter
    public void writeDecimal128(String name, Decimal128 value) {
        this.state.name(name).value(value);
    }

    @Override // org.bson.BsonWriter
    public void writeJavaScript(String code) {
        this.state.value(code);
    }

    @Override // org.bson.BsonWriter
    public void writeMaxKey(String name) {
        writeName(name);
        writeMaxKey();
    }

    @Override // org.bson.BsonWriter
    public void writeJavaScript(String name, String code) {
        this.state.name(name).value(code);
    }

    @Override // org.bson.BsonWriter
    public void writeMinKey(String name) {
        writeName(name);
        writeMinKey();
    }

    @Override // org.bson.BsonWriter
    public void writeJavaScriptWithScope(String code) {
        this.state.value(code);
    }

    @Override // org.bson.BsonWriter
    public void writeJavaScriptWithScope(String name, String code) {
        this.state.name(name).value(code);
    }

    @Override // org.bson.BsonWriter
    public void writeMaxKey() {
        this.state.value(new BsonMaxKey());
    }

    @Override // org.bson.BsonWriter
    public void writeMinKey() {
        this.state.value(new BsonMinKey());
    }

    @Override // org.bson.BsonWriter
    public void writeName(String name) {
        this.state.name(name);
    }

    @Override // org.bson.BsonWriter
    public void writeNull() {
        this.state.value(null);
    }

    @Override // org.bson.BsonWriter
    public void writeNull(String name) {
        writeName(name);
        this.state.value(null);
    }

    @Override // org.bson.BsonWriter
    public void writeObjectId(ObjectId objectId) {
        this.state.value(objectId);
    }

    @Override // org.bson.BsonWriter
    public void writeStartArray(String name) {
        writeName(name);
        writeStartArray();
    }

    @Override // org.bson.BsonWriter
    public void writeObjectId(String name, ObjectId objectId) {
        this.state.name(name).value(objectId);
    }

    @Override // org.bson.BsonWriter
    public void writeRegularExpression(BsonRegularExpression regularExpression) {
        this.state.value(regularExpression);
    }

    @Override // org.bson.BsonWriter
    public void writeRegularExpression(String name, BsonRegularExpression regularExpression) {
        this.state.name(name).value(regularExpression);
    }

    @Override // org.bson.BsonWriter
    public void writeStartArray() {
        this.state.array();
    }

    @Override // org.bson.BsonWriter
    public void writeStartDocument() {
        this.state.document();
    }

    @Override // org.bson.BsonWriter
    public void writeSymbol(String name, String value) {
        writeName(name);
        writeSymbol(value);
    }

    @Override // org.bson.BsonWriter
    public void writeStartDocument(String name) {
        this.state.name(name).document();
    }

    @Override // org.bson.BsonWriter
    public void writeString(String value) {
        this.state.value(value);
    }

    @Override // org.bson.BsonWriter
    public void writeString(String name, String value) {
        this.state.name(name).value(value);
    }

    @Override // org.bson.BsonWriter
    public void writeUndefined(String name) {
        writeName(name);
        writeUndefined();
    }

    @Override // org.bson.BsonWriter
    public void pipe(BsonReader reader) {
        throw new UnsupportedOperationException("org.bson.io.TestingDocumentWriter.pipe has not yet been implemented.");
    }

    @Override // org.bson.BsonWriter
    public void writeSymbol(String value) {
        this.state.value(new BsonSymbol(value));
    }

    @Override // org.bson.BsonWriter
    public void writeTimestamp(BsonTimestamp value) {
        this.state.value(value);
    }

    @Override // org.bson.BsonWriter
    public void writeTimestamp(String name, BsonTimestamp value) {
        writeName(name);
        this.state.value(value);
    }

    @Override // org.bson.BsonWriter
    public void writeUndefined() {
        this.state.value(new BsonUndefined());
    }

    public String toString() {
        return this.root.toString();
    }

    /* access modifiers changed from: package-private */
    public void state(WriteState state) {
        this.state = state;
    }
}
