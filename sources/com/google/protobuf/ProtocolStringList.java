package com.google.protobuf;

import java.util.List;

/* loaded from: grasscutter.jar:com/google/protobuf/ProtocolStringList.class */
public interface ProtocolStringList extends List<String> {
    List<ByteString> asByteStringList();
}
