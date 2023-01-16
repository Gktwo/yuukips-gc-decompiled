package com.sun.jna.win32;

import com.sun.jna.FunctionMapper;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import java.lang.reflect.Method;
import net.bytebuddy.utility.JavaConstant;

/* loaded from: grasscutter.jar:com/sun/jna/win32/StdCallFunctionMapper.class */
public class StdCallFunctionMapper implements FunctionMapper {
    protected int getArgumentNativeStackSize(Class<?> cls) {
        if (NativeMapped.class.isAssignableFrom(cls)) {
            cls = NativeMappedConverter.getInstance(cls).nativeType();
        }
        if (cls.isArray()) {
            return Native.POINTER_SIZE;
        }
        try {
            return Native.getNativeSize(cls);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown native stack allocation size for " + cls);
        }
    }

    @Override // com.sun.jna.FunctionMapper
    public String getFunctionName(NativeLibrary library, Method method) {
        String name = method.getName();
        int pop = 0;
        for (Class<?> cls : method.getParameterTypes()) {
            pop += getArgumentNativeStackSize(cls);
        }
        String decorated = name + "@" + pop;
        try {
            name = library.getFunction(decorated, 63).getName();
        } catch (UnsatisfiedLinkError e) {
            try {
                name = library.getFunction(JavaConstant.Dynamic.DEFAULT_NAME + decorated, 63).getName();
            } catch (UnsatisfiedLinkError e2) {
            }
        }
        return name;
    }
}
