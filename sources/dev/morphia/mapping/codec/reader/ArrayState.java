package dev.morphia.mapping.codec.reader;

import java.util.List;
import java.util.stream.Collectors;
import org.bson.BsonType;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/reader/ArrayState.class */
public class ArrayState extends ReaderState {
    public static final String NAME = "ARRAY";
    private final List<?> values;
    private ArrayEndState endState;

    /* access modifiers changed from: package-private */
    public ArrayState(DocumentReader reader, List<?> values) {
        super(reader);
        this.values = values;
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public void skipValue() {
        reader().state(this.endState != null ? this.endState.nextState() : nextState());
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public BsonType getCurrentBsonType() {
        return BsonType.ARRAY;
    }

    @Override // dev.morphia.mapping.codec.reader.ReaderState
    String getStateName() {
        return NAME;
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.reader.ReaderState
    public void startArray() {
        if (this.endState == null) {
            ReaderState docState = null;
            for (ReaderState state : (List) this.values.stream().map(this::valueState).collect(Collectors.toList())) {
                if (docState != null) {
                    docState.next(state);
                } else {
                    next(state);
                }
                docState = state;
            }
            this.endState = new ArrayEndState(reader());
            if (docState != null) {
                docState.next(this.endState);
            } else {
                next(this.endState);
            }
        }
        advance();
    }
}
