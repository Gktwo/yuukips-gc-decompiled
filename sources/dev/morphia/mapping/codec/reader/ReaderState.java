package dev.morphia.mapping.codec.reader;

import com.mongodb.DBRef;
import com.mongodb.lang.Nullable;
import dev.morphia.sofia.Sofia;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.bson.BsonBinary;
import org.bson.BsonType;
import org.bson.Document;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/reader/ReaderState.class */
public abstract class ReaderState {
    private final DocumentReader reader;
    private ReaderState nextState;

    /* access modifiers changed from: package-private */
    public abstract BsonType getCurrentBsonType();

    abstract String getStateName();

    /* access modifiers changed from: package-private */
    public ReaderState(DocumentReader reader) {
        this.reader = reader;
    }

    @Nullable
    public ReaderState nextState() {
        return this.nextState;
    }

    public DocumentReader reader() {
        return this.reader;
    }

    public String toString() {
        return getStateName();
    }

    /* access modifiers changed from: protected */
    public ReaderState valueState(Object value) {
        Object unwind = unwind(value);
        if (unwind instanceof Document) {
            return new DocumentState(this.reader, (Document) unwind);
        }
        if (unwind instanceof List) {
            return new ArrayState(this.reader, (List) unwind);
        }
        return new ValueState(this.reader, unwind);
    }

    /* access modifiers changed from: package-private */
    public void advance() {
        this.reader.state(this.nextState);
    }

    /* access modifiers changed from: package-private */
    public void endArray() {
        throw new IllegalStateException(Sofia.invalidReaderState("endArray", ArrayState.NAME, getStateName(), new Locale[0]));
    }

    /* access modifiers changed from: package-private */
    public void endDocument() {
        throw new IllegalStateException(Sofia.invalidReaderState("endDocument", DocumentState.NAME, getStateName(), new Locale[0]));
    }

    /* access modifiers changed from: package-private */
    public String name() {
        throw new IllegalStateException(Sofia.invalidReaderState("readName", NameState.NAME, getStateName(), new Locale[0]));
    }

    /* access modifiers changed from: package-private */
    public void next(ReaderState next) {
        ReaderState old = this.nextState;
        this.nextState = next;
        if (this.nextState != null) {
            this.nextState.nextState = old;
        }
    }

    /* access modifiers changed from: package-private */
    public void skipName() {
        throw new IllegalStateException(Sofia.invalidReaderState("skipName", NameState.NAME, getStateName(), new Locale[0]));
    }

    /* access modifiers changed from: package-private */
    public void skipValue() {
        throw new IllegalStateException(Sofia.invalidReaderState("skipValue", ValueState.NAME, getStateName(), new Locale[0]));
    }

    /* access modifiers changed from: package-private */
    public void startArray() {
        throw new IllegalStateException(Sofia.invalidReaderState("startArray", ArrayState.NAME, getStateName(), new Locale[0]));
    }

    /* access modifiers changed from: package-private */
    public void startDocument() {
        throw new IllegalStateException(Sofia.invalidReaderState("startDocument", DocumentState.NAME, getStateName(), new Locale[0]));
    }

    private Object unwind(Object value) {
        Object unwind = value;
        if (value instanceof DBRef) {
            DBRef dbRef = (DBRef) value;
            Document document = new Document("$ref", dbRef.getCollectionName()).append("$id", dbRef.getId());
            if (dbRef.getDatabaseName() != null) {
                document.append("$db", dbRef.getDatabaseName());
            }
            unwind = document;
        } else if (value instanceof UUID) {
            unwind = new BsonBinary((UUID) value);
        }
        return unwind;
    }

    /* access modifiers changed from: package-private */
    public <T> T value() {
        throw new IllegalStateException(Sofia.invalidReaderState("read value", ValueState.NAME, getStateName(), new Locale[0]));
    }
}
