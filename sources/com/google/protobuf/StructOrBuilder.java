package com.google.protobuf;

import java.util.Map;

/* loaded from: grasscutter.jar:com/google/protobuf/StructOrBuilder.class */
public interface StructOrBuilder extends MessageOrBuilder {
    int getFieldsCount();

    boolean containsFields(String str);

    @Deprecated
    Map<String, Value> getFields();

    Map<String, Value> getFieldsMap();

    Value getFieldsOrDefault(String str, Value value);

    Value getFieldsOrThrow(String str);
}
