package com.fasterxml.jackson.databind.jsonFormatVisitors;

import java.util.Set;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jsonFormatVisitors/JsonValueFormatVisitor.class */
public interface JsonValueFormatVisitor {
    void format(JsonValueFormat jsonValueFormat);

    void enumTypes(Set<String> set);

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jsonFormatVisitors/JsonValueFormatVisitor$Base.class */
    public static class Base implements JsonValueFormatVisitor {
        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor
        public void format(JsonValueFormat format) {
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor
        public void enumTypes(Set<String> enums) {
        }
    }
}
