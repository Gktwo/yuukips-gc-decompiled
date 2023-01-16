package dev.morphia.mapping.codec.reader;

import org.bson.BsonType;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/reader/DocumentEndState.class */
class DocumentEndState extends ReaderState {
    public static final String NAME = "END_DOCUMENT";

    /* access modifiers changed from: package-private */
    public DocumentEndState(DocumentReader reader) {
        super(reader);
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public void endDocument() {
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
