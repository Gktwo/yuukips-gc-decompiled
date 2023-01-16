package dev.morphia.mapping.codec.writer;

import com.mongodb.lang.Nullable;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/writer/NameState.class */
public class NameState extends WriteState {
    private final String name;
    private ValueState value = PendingValue.SLUG;

    /* access modifiers changed from: package-private */
    public NameState(DocumentWriter writer, String name, WriteState previous) {
        super(writer, previous);
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        return String.format("%s: %s", this.name, this.value);
    }

    @Nullable
    public Object value() {
        return this.value.value();
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    protected String state() {
        return "name";
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    WriteState array() {
        this.value = new ArrayState(getWriter(), this);
        return this.value;
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    WriteState document() {
        this.value = new DocumentState(getWriter(), this);
        return this.value;
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    void done() {
        end();
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    void value(Object value) {
        this.value = new SingleValue(getWriter(), value, this);
        this.value.end();
    }
}
