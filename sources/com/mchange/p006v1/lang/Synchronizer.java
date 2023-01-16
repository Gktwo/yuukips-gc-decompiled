package com.mchange.p006v1.lang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;

/* renamed from: com.mchange.v1.lang.Synchronizer */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/Synchronizer.class */
public final class Synchronizer {
    public static Object createSynchronizedWrapper(final Object obj) {
        C08751 r0 = new InvocationHandler() { // from class: com.mchange.v1.lang.Synchronizer.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj2, Method method, Object[] objArr) throws Throwable {
                Object invoke;
                synchronized (obj2) {
                    invoke = method.invoke(obj, objArr);
                }
                return invoke;
            }
        };
        Class<?> cls = obj.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(), recurseFindInterfaces(cls), r0);
    }

    private static Class[] recurseFindInterfaces(Class cls) {
        HashSet hashSet = new HashSet();
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                hashSet.add(cls2);
            }
            cls = cls.getSuperclass();
        }
        Class[] clsArr = new Class[hashSet.size()];
        hashSet.toArray(clsArr);
        return clsArr;
    }

    private Synchronizer() {
    }
}
