package com.google.common.reflect;

import com.google.common.annotations.Beta;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import org.jline.console.Printer;

@Beta
/* loaded from: grasscutter.jar:com/google/common/reflect/AbstractInvocationHandler.class */
public abstract class AbstractInvocationHandler implements InvocationHandler {
    private static final Object[] NO_ARGS = new Object[0];

    protected abstract Object handleInvocation(Object obj, Method method, Object[] objArr) throws Throwable;

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args == null) {
            args = NO_ARGS;
        }
        if (args.length == 0 && method.getName().equals("hashCode")) {
            return Integer.valueOf(hashCode());
        }
        if (args.length == 1 && method.getName().equals("equals") && method.getParameterTypes()[0] == Object.class) {
            Object arg = args[0];
            if (arg == null) {
                return false;
            }
            if (proxy == arg) {
                return true;
            }
            return Boolean.valueOf(isProxyOfSameInterfaces(arg, proxy.getClass()) && equals(Proxy.getInvocationHandler(arg)));
        } else if (args.length != 0 || !method.getName().equals(Printer.TO_STRING)) {
            return handleInvocation(proxy, method, args);
        } else {
            return toString();
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return equals(obj);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return toString();
    }

    private static boolean isProxyOfSameInterfaces(Object arg, Class<?> proxyClass) {
        return proxyClass.isInstance(arg) || (Proxy.isProxyClass(arg.getClass()) && Arrays.equals(arg.getClass().getInterfaces(), proxyClass.getInterfaces()));
    }
}
