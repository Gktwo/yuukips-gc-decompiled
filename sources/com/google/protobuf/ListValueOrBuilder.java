package com.google.protobuf;

import java.util.List;

/* loaded from: grasscutter.jar:com/google/protobuf/ListValueOrBuilder.class */
public interface ListValueOrBuilder extends MessageOrBuilder {
    List<Value> getValuesList();

    Value getValues(int i);

    int getValuesCount();

    List<? extends ValueOrBuilder> getValuesOrBuilderList();

    ValueOrBuilder getValuesOrBuilder(int i);
}
