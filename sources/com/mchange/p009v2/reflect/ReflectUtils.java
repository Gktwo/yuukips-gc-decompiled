package com.mchange.p009v2.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.mchange.v2.reflect.ReflectUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/reflect/ReflectUtils.class */
public final class ReflectUtils {
    public static final Class[] PROXY_CTOR_ARGS = {InvocationHandler.class};

    public static Constructor findProxyConstructor(ClassLoader classLoader, Class cls) throws NoSuchMethodException {
        return findProxyConstructor(classLoader, new Class[]{cls});
    }

    public static Constructor findProxyConstructor(ClassLoader classLoader, Class[] clsArr) throws NoSuchMethodException {
        return Proxy.getProxyClass(classLoader, clsArr).getConstructor(PROXY_CTOR_ARGS);
    }

    public static boolean isPublic(Member member) {
        return (member.getModifiers() & 1) != 0;
    }

    public static boolean isPublic(Class cls) {
        return (cls.getModifiers() & 1) != 0;
    }

    public static Class findPublicParent(Class cls) {
        do {
            cls = cls.getSuperclass();
            if (cls == null) {
                break;
            }
        } while (!isPublic(cls));
        return cls;
    }

    public static Iterator traverseInterfaces(Class cls) {
        HashSet hashSet = new HashSet();
        if (cls.isInterface()) {
            hashSet.add(cls);
        }
        addParentInterfaces(hashSet, cls);
        return hashSet.iterator();
    }

    private static void addParentInterfaces(Set set, Class cls) {
        Class<?>[] interfaces = cls.getInterfaces();
        int length = interfaces.length;
        for (int i = 0; i < length; i++) {
            set.add(interfaces[i]);
            addParentInterfaces(set, interfaces[i]);
        }
    }

    public static Method findInPublicScope(Method method) {
        if (!isPublic(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (isPublic(declaringClass)) {
            return method;
        }
        Class<?> cls = declaringClass;
        while (true) {
            Class<?> findPublicParent = findPublicParent(cls);
            cls = findPublicParent;
            if (findPublicParent != null) {
                try {
                    return cls.getMethod(method.getName(), method.getParameterTypes());
                } catch (NoSuchMethodException e) {
                }
            } else {
                Iterator traverseInterfaces = traverseInterfaces(declaringClass);
                while (traverseInterfaces.hasNext()) {
                    Class cls2 = (Class) traverseInterfaces.next();
                    if (isPublic(cls2)) {
                        try {
                            return cls2.getMethod(method.getName(), method.getParameterTypes());
                        } catch (NoSuchMethodException e2) {
                        }
                    }
                }
                return null;
            }
        }
    }

    private ReflectUtils() {
    }
}
