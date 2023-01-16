package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageLite;

/* loaded from: grasscutter.jar:com/google/protobuf/Extension.class */
public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:com/google/protobuf/Extension$ExtensionType.class */
    public enum ExtensionType {
        IMMUTABLE,
        MUTABLE,
        PROTO1
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Extension$MessageType.class */
    public enum MessageType {
        PROTO1,
        PROTO2
    }

    @Override // com.google.protobuf.ExtensionLite
    public abstract Message getMessageDefaultInstance();

    public abstract Descriptors.FieldDescriptor getDescriptor();

    /* access modifiers changed from: protected */
    public abstract ExtensionType getExtensionType();

    /* access modifiers changed from: protected */
    public abstract Object fromReflectionType(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object singularFromReflectionType(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object toReflectionType(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object singularToReflectionType(Object obj);

    /* access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionLite
    public final boolean isLite() {
        return false;
    }

    public MessageType getMessageType() {
        return MessageType.PROTO2;
    }
}
