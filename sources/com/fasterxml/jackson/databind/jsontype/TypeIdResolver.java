package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import java.io.IOException;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jsontype/TypeIdResolver.class */
public interface TypeIdResolver {
    void init(JavaType javaType);

    String idFromValue(Object obj);

    String idFromValueAndType(Object obj, Class<?> cls);

    String idFromBaseType();

    JavaType typeFromId(DatabindContext databindContext, String str) throws IOException;

    String getDescForKnownTypeIds();

    JsonTypeInfo.EnumC0037Id getMechanism();
}
