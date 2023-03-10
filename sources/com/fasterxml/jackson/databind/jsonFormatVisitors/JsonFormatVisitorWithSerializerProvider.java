package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.SerializerProvider;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWithSerializerProvider.class */
public interface JsonFormatVisitorWithSerializerProvider {
    SerializerProvider getProvider();

    void setProvider(SerializerProvider serializerProvider);
}
