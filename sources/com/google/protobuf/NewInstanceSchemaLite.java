package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;

/* loaded from: grasscutter.jar:com/google/protobuf/NewInstanceSchemaLite.class */
final class NewInstanceSchemaLite implements NewInstanceSchema {
    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object defaultInstance) {
        return ((GeneratedMessageLite) defaultInstance).dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }
}
