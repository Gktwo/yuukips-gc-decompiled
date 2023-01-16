package dev.morphia.mapping.codec.writer;

import com.mongodb.lang.Nullable;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/writer/ValueState.class */
public abstract class ValueState<T> extends WriteState {
    @Nullable
    public abstract T value();

    /* access modifiers changed from: package-private */
    public ValueState(DocumentWriter writer, WriteState previous) {
        super(writer, previous);
    }

    /* access modifiers changed from: package-private */
    public ValueState() {
    }
}
