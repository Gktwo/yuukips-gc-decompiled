package com.mchange.p009v2.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: com.mchange.v2.reflect.ForwardingInvocationHandler */
/* loaded from: grasscutter.jar:com/mchange/v2/reflect/ForwardingInvocationHandler.class */
public class ForwardingInvocationHandler implements InvocationHandler {
    Object inner;

    public ForwardingInvocationHandler(Object obj) {
        this.inner = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        return method.invoke(this.inner, objArr);
    }
}
