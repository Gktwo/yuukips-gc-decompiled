package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/ResolvableDeserializer.class */
public interface ResolvableDeserializer {
    void resolve(DeserializationContext deserializationContext) throws JsonMappingException;
}
