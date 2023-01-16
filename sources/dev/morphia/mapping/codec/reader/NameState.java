package dev.morphia.mapping.codec.reader;

import com.mongodb.lang.Nullable;
import org.bson.BsonType;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/reader/NameState.class */
public class NameState extends ReaderState {
    public static final String NAME = "NAME";
    private final String name;

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
    public NameState(DocumentReader reader, String name) {
        super(reader);
        this.name = name;
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public void skipName() {
        advance();
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public BsonType getCurrentBsonType() {
        ReaderState readerState = nextState();
        if (readerState != null) {
            return readerState.getCurrentBsonType();
        }
        return BsonType.UNDEFINED;
    }

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    String getStateName() {
        return NAME;
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public String name() {
        advance();
        return this.name;
    }
}
