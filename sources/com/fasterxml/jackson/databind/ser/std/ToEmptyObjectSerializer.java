package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.lang.reflect.Type;

@JacksonStdImpl
/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ser/std/ToEmptyObjectSerializer.class */
public class ToEmptyObjectSerializer extends StdSerializer<Object> {
    /* access modifiers changed from: protected */
    public ToEmptyObjectSerializer(Class<?> raw) {
        super(raw, false);
    }

    public ToEmptyObjectSerializer(JavaType type) {
        super(type);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(Object value, JsonGenerator gen, SerializerProvider ctxt) throws IOException {
        gen.writeStartObject(value, 0);
        gen.writeEndObject();
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public void serializeWithType(Object value, JsonGenerator gen, SerializerProvider ctxt, TypeSerializer typeSer) throws IOException {
        typeSer.writeTypeSuffix(gen, typeSer.writeTypePrefix(gen, typeSer.typeId(value, JsonToken.START_OBJECT)));
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public boolean isEmpty(SerializerProvider provider, Object value) {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.jsonschema.SchemaAware
    public JsonNode getSchema(SerializerProvider provider, Type typeHint) throws JsonMappingException {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException {
        visitor.expectObjectFormat(typeHint);
    }
}
