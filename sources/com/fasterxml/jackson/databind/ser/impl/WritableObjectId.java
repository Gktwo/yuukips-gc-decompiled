package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ser/impl/WritableObjectId.class */
public final class WritableObjectId {
    public final ObjectIdGenerator<?> generator;

    /* renamed from: id */
    public Object f237id;
    protected boolean idWritten = false;

    public WritableObjectId(ObjectIdGenerator<?> generator) {
        this.generator = generator;
    }

    public boolean writeAsId(JsonGenerator gen, SerializerProvider provider, ObjectIdWriter w) throws IOException {
        if (this.f237id == null) {
            return false;
        }
        if (!this.idWritten && !w.alwaysAsId) {
            return false;
        }
        if (gen.canWriteObjectId()) {
            gen.writeObjectRef(String.valueOf(this.f237id));
            return true;
        }
        w.serializer.serialize(this.f237id, gen, provider);
        return true;
    }

    public Object generateId(Object forPojo) {
        if (this.f237id == null) {
            this.f237id = this.generator.generateId(forPojo);
        }
        return this.f237id;
    }

    public void writeAsField(JsonGenerator gen, SerializerProvider provider, ObjectIdWriter w) throws IOException {
        this.idWritten = true;
        if (gen.canWriteObjectId()) {
            gen.writeObjectId(this.f237id == null ? null : String.valueOf(this.f237id));
            return;
        }
        SerializableString name = w.propertyName;
        if (name != null) {
            gen.writeFieldName(name);
            w.serializer.serialize(this.f237id, gen, provider);
        }
    }
}
