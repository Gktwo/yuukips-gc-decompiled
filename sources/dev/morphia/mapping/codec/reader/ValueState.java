package dev.morphia.mapping.codec.reader;

import com.mongodb.lang.Nullable;
import org.bson.BsonType;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/reader/ValueState.class */
public class ValueState extends ReaderState {
    public static final String NAME = "VALUE";
    private final Object value;

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public /* bridge */ /* synthetic */ DocumentReader reader() {
        return reader();
    }

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    @Nullable
    public /* bridge */ /* synthetic */ ReaderState nextState() {
        return nextState();
    }

    /* access modifiers changed from: package-private */
    public ValueState(DocumentReader reader, Object value) {
        super(reader);
        this.value = value;
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public BsonType getCurrentBsonType() {
        return reader().getBsonType(this.value);
    }

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    String getStateName() {
        return NAME;
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public void skipValue() {
        advance();
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public <T> T value() {
        advance();
        return (T) this.value;
    }
}
