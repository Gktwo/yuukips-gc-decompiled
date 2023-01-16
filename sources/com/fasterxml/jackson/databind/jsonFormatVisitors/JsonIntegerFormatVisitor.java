package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jsonFormatVisitors/JsonIntegerFormatVisitor.class */
public interface JsonIntegerFormatVisitor extends JsonValueFormatVisitor {
    void numberType(JsonParser.NumberType numberType);

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jsonFormatVisitors/JsonIntegerFormatVisitor$Base.class */
    public static class Base extends JsonValueFormatVisitor.Base implements JsonIntegerFormatVisitor {
        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor
        public void numberType(JsonParser.NumberType type) {
        }
    }
}
