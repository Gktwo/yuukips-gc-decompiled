package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;

/* loaded from: grasscutter.jar:com/google/protobuf/ExtensionLite.class */
public abstract class ExtensionLite<ContainingType extends MessageLite, Type> {
    public abstract int getNumber();

    public abstract WireFormat.FieldType getLiteType();

    public abstract boolean isRepeated();

    public abstract Type getDefaultValue();

    public abstract MessageLite getMessageDefaultInstance();

    /* access modifiers changed from: package-private */
    public boolean isLite() {
        return true;
    }
}
