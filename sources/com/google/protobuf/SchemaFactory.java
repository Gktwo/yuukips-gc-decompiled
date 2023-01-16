package com.google.protobuf;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/SchemaFactory.class */
public interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> cls);
}
