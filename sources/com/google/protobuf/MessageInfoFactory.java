package com.google.protobuf;

/* loaded from: grasscutter.jar:com/google/protobuf/MessageInfoFactory.class */
interface MessageInfoFactory {
    boolean isSupported(Class<?> cls);

    MessageInfo messageInfoFor(Class<?> cls);
}
