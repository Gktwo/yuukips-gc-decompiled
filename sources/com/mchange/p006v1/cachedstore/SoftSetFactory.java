package com.mchange.p006v1.cachedstore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

/* renamed from: com.mchange.v1.cachedstore.SoftSetFactory */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/SoftSetFactory.class */
public final class SoftSetFactory {
    public static Set createSynchronousCleanupSoftSet() {
        final ManualCleanupSoftSet manualCleanupSoftSet = new ManualCleanupSoftSet();
        return (Set) Proxy.newProxyInstance(SoftSetFactory.class.getClassLoader(), new Class[]{Set.class}, new InvocationHandler() { // from class: com.mchange.v1.cachedstore.SoftSetFactory.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                manualCleanupSoftSet.vacuum();
                return method.invoke(manualCleanupSoftSet, objArr);
            }
        });
    }

    private SoftSetFactory() {
    }
}
