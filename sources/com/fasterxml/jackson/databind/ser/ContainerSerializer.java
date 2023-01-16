package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ser/ContainerSerializer.class */
public abstract class ContainerSerializer<T> extends StdSerializer<T> {
    public abstract JavaType getContentType();

    public abstract JsonSerializer<?> getContentSerializer();

    public abstract boolean hasSingleElement(T t);

    protected abstract ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer typeSerializer);

    /* access modifiers changed from: protected */
    public ContainerSerializer(Class<T> t) {
        super(t);
    }

    /* access modifiers changed from: protected */
    public ContainerSerializer(JavaType fullType) {
        super(fullType);
    }

    /* access modifiers changed from: protected */
    public ContainerSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
    }

    /* access modifiers changed from: protected */
    public ContainerSerializer(ContainerSerializer<?> src) {
        super(src._handledType, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.fasterxml.jackson.databind.ser.ContainerSerializer<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public ContainerSerializer<?> withValueTypeSerializer(TypeSerializer vts) {
        return vts == null ? this : _withValueTypeSerializer(vts);
    }

    @Deprecated
    protected boolean hasContentTypeAnnotation(SerializerProvider provider, BeanProperty property) {
        return false;
    }
}
