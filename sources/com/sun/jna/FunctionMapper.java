package com.sun.jna;

import java.lang.reflect.Method;

/* loaded from: grasscutter.jar:com/sun/jna/FunctionMapper.class */
public interface FunctionMapper {
    String getFunctionName(NativeLibrary nativeLibrary, Method method);
}
