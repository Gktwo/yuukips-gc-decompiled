package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ser/std/EnumSetSerializer.class */
public class EnumSetSerializer extends AsArraySerializerBase<EnumSet<? extends Enum<?>>> {
    public EnumSetSerializer(JavaType elemType) {
        super((Class<?>) EnumSet.class, elemType, true, (TypeSerializer) null, (JsonSerializer<Object>) null);
    }

    public EnumSetSerializer(EnumSetSerializer src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> valueSerializer, Boolean unwrapSingle) {
        super(src, property, vts, valueSerializer, unwrapSingle);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public EnumSetSerializer _withValueTypeSerializer(TypeSerializer vts) {
        return this;
    }

    /* Return type fixed from 'com.fasterxml.jackson.databind.ser.std.EnumSetSerializer' to match base method */
    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public AsArraySerializerBase<EnumSet<? extends Enum<?>>> withResolved(BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer, Boolean unwrapSingle) {
        return new EnumSetSerializer(this, property, vts, elementSerializer, unwrapSingle);
    }

    public boolean isEmpty(SerializerProvider prov, EnumSet<? extends Enum<?>> value) {
        return value.isEmpty();
    }

    public boolean hasSingleElement(EnumSet<? extends Enum<?>> value) {
        return value.size() == 1;
    }

    public final void serialize(EnumSet<? extends Enum<?>> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        int len = value.size();
        if (len != 1 || ((this._unwrapSingle != null || !provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this._unwrapSingle != Boolean.TRUE)) {
            gen.writeStartArray(value, len);
            serializeContents(value, gen, provider);
            gen.writeEndArray();
            return;
        }
        serializeContents(value, gen, provider);
    }

    public void serializeContents(EnumSet<? extends Enum<?>> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        JsonSerializer<Object> enumSer = this._elementSerializer;
        Iterator it = value.iterator();
        while (it.hasNext()) {
            Enum<?> en = (Enum) it.next();
            if (enumSer == null) {
                enumSer = provider.findContentValueSerializer(en.getDeclaringClass(), this._property);
            }
            enumSer.serialize(en, gen, provider);
        }
    }
}
