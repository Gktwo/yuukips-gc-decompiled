package dev.morphia.mapping.codec.writer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/writer/ArrayState.class */
class ArrayState extends ValueState<List<Object>> {
    private final List<Object> list = new ArrayList();
    private boolean finished = false;
    private ValueState<?> substate;

    /* access modifiers changed from: package-private */
    public ArrayState(DocumentWriter writer, WriteState previous) {
        super(writer, previous);
    }

    public List<Object> getList() {
        return this.list;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", this.finished ? "]" : "");
        this.list.forEach(v -> {
            joiner.add(v instanceof Document ? ((Document) v).toJson() : String.valueOf(v));
        });
        if (this.substate != null) {
            joiner.add(this.substate.toString());
        }
        return joiner.toString();
    }

    @Override // dev.morphia.mapping.codec.writer.ValueState
    public List<Object> value() {
        return this.list;
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    protected String state() {
        return "array";
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    void value(Object value) {
        this.list.add(value);
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    WriteState array() {
        this.substate = new ArrayState(getWriter(), this);
        return this.substate;
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    WriteState document() {
        this.substate = new DocumentState(getWriter(), this);
        return this.substate;
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    void done() {
        if (this.substate != null) {
            this.list.add(this.substate.value());
            this.substate = null;
        }
        done();
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.writer.WriteState
    public void end() {
        this.finished = true;
        if (this.substate != null) {
            this.substate.end();
        }
        end();
    }
}
