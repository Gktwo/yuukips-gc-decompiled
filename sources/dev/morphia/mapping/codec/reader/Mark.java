package dev.morphia.mapping.codec.reader;

import org.bson.BsonReaderMark;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/reader/Mark.class */
public class Mark implements BsonReaderMark {
    private final DocumentReader reader;
    private final ReaderState readerState;

    /* access modifiers changed from: package-private */
    public Mark(DocumentReader reader, ReaderState readerState) {
        this.reader = reader;
        this.readerState = readerState;
    }

    @Override // org.bson.BsonReaderMark
    public void reset() {
        this.reader.reset(this.readerState);
    }
}
