package com.google.protobuf;

/* loaded from: grasscutter.jar:com/google/protobuf/MessageInfo.class */
interface MessageInfo {
    ProtoSyntax getSyntax();

    boolean isMessageSetWireFormat();

    MessageLite getDefaultInstance();
}
