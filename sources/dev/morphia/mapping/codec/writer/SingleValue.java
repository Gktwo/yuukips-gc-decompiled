package dev.morphia.mapping.codec.writer;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/writer/SingleValue.class */
public class SingleValue extends ValueState<Object> {
    private final Object value;

    public SingleValue(DocumentWriter writer, Object value, WriteState previous) {
        super(writer, previous);
        this.value = value;
    }

    public String toString() {
        return this.value.toString();
    }

    @Override // dev.morphia.mapping.codec.writer.ValueState
    public Object value() {
        return this.value;
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    protected String state() {
        return "single";
    }
}
