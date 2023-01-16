package dev.morphia.mapping.codec.reader;

import java.util.List;
import java.util.stream.Collectors;
import org.bson.BsonType;
import org.bson.Document;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/reader/DocumentState.class */
public class DocumentState extends ReaderState {
    public static final String NAME = "DOCUMENT";
    private final Document document;
    private DocumentEndState endState;

    /* access modifiers changed from: package-private */
    public DocumentState(DocumentReader reader, Document document) {
        super(reader);
        this.document = document;
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public void skipValue() {
        reader().state(this.endState != null ? this.endState.nextState() : nextState());
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public BsonType getCurrentBsonType() {
        return BsonType.DOCUMENT;
    }

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    String getStateName() {
        return NAME;
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public void startDocument() {
        if (this.endState == null) {
            ReaderState docState = null;
            for (ReaderState state : (List) this.document.entrySet().stream().flatMap(e -> {
                return List.of(new NameState(reader(), (String) e.getKey()), valueState(e.getValue())).stream();
            }).collect(Collectors.toList())) {
                if (docState != null) {
                    docState.next(state);
                } else {
                    next(state);
                }
                docState = state;
            }
            this.endState = new DocumentEndState(reader());
            if (docState != null) {
                docState.next(this.endState);
            } else {
                next(this.endState);
            }
        }
        advance();
    }
}
