package dev.morphia.mapping.codec.reader;

import org.bson.BsonType;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/reader/ArrayEndState.class */
class ArrayEndState extends ReaderState {
    private static final String NAME = "END_ARRAY";

    /* access modifiers changed from: package-private */
    public ArrayEndState(DocumentReader reader) {
        super(reader);
    }

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    void endArray() {
        advance();
    }

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    BsonType getCurrentBsonType() {
        return BsonType.END_OF_DOCUMENT;
    }

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    String getStateName() {
        return NAME;
    }
}
