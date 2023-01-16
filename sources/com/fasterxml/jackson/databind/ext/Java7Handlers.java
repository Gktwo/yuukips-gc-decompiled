package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.util.ClassUtil;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ext/Java7Handlers.class */
public abstract class Java7Handlers {
    private static final Java7Handlers IMPL;

    public abstract Class<?> getClassJavaNioFilePath();

    public abstract JsonDeserializer<?> getDeserializerForJavaNioFilePath(Class<?> cls);

    public abstract JsonSerializer<?> getSerializerForJavaNioFilePath(Class<?> cls);

    static {
        Java7Handlers impl = null;
        try {
            impl = (Java7Handlers) ClassUtil.createInstance(Class.forName("com.fasterxml.jackson.databind.ext.Java7HandlersImpl"), false);
        } catch (Throwable th) {
        }
        IMPL = impl;
    }

    public static Java7Handlers instance() {
        return IMPL;
    }
}
