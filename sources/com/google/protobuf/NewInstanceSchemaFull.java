package com.google.protobuf;

import com.google.protobuf.GeneratedMessageV3;

/* loaded from: grasscutter.jar:com/google/protobuf/NewInstanceSchemaFull.class */
final class NewInstanceSchemaFull implements NewInstanceSchema {
    NewInstanceSchemaFull() {
    }

    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object defaultInstance) {
        return ((GeneratedMessageV3) defaultInstance).newInstance(GeneratedMessageV3.UnusedPrivateParameter.INSTANCE);
    }
}
