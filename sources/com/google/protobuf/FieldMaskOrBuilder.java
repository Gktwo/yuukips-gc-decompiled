package com.google.protobuf;

import java.util.List;

/* loaded from: grasscutter.jar:com/google/protobuf/FieldMaskOrBuilder.class */
public interface FieldMaskOrBuilder extends MessageOrBuilder {
    List<String> getPathsList();

    int getPathsCount();

    String getPaths(int i);

    ByteString getPathsBytes(int i);
}
