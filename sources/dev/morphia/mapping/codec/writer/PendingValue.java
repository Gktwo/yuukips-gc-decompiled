package dev.morphia.mapping.codec.writer;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/writer/PendingValue.class */
public class PendingValue extends ValueState<Object> {
    static final PendingValue SLUG = new PendingValue();
    static final String PENDING = "<<|>>";

    PendingValue() {
    }

    public String toString() {
        return PENDING;
    }

    @Override // dev.morphia.mapping.codec.writer.ValueState
    public Object value() {
        return null;
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    protected String state() {
        return "pending value";
    }
}
