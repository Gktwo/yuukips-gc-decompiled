package dev.morphia.mapping.codec.reader;

import org.bson.BsonType;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/reader/ArrayEndState.class */
class ArrayEndState extends ReaderState {
    private static final String NAME = "END_ARRAY";

    /* access modifiers changed from: package-private */
    public ArrayEndState(DocumentReader reader) {
        super(reader);
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public void endArray() {
        advance();
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public BsonType getCurrentBsonType() {
        return BsonType.END_OF_DOCUMENT;
    }

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    String getStateName() {
        return NAME;
    }
}
