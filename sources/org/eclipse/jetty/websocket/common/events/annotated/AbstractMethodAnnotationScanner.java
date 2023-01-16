package org.eclipse.jetty.websocket.common.events.annotated;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import org.eclipse.jetty.websocket.api.InvalidWebSocketException;
import org.eclipse.jetty.websocket.common.events.ParamList;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/annotated/AbstractMethodAnnotationScanner.class */
public abstract class AbstractMethodAnnotationScanner<T> {
    public abstract void onMethodAnnotation(T t, Class<?> cls, Method method, Annotation annotation);

    protected void assertIsPublicNonStatic(Method method) {
        int mods = method.getModifiers();
        if (!Modifier.isPublic(mods)) {
            throw new InvalidWebSocketException("Invalid declaration of " + method + System.lineSeparator() + "Method modifier must be public");
        } else if (Modifier.isStatic(mods)) {
            throw new InvalidWebSocketException("Invalid declaration of " + method + System.lineSeparator() + "Method modifier may not be static");
        }
    }

    protected void assertIsReturn(Method method, Class<?> type) {
        if (!type.equals(method.getReturnType())) {
            StringBuilder err = new StringBuilder();
            err.append("Invalid declaration of ");
            err.append(method);
            err.append(System.lineSeparator());
            err.append("Return type must be ").append(type);
            throw new InvalidWebSocketException(err.toString());
        }
    }

    protected void assertIsVoidReturn(Method method) {
        assertIsReturn(method, Void.TYPE);
    }

    protected void assertUnset(CallableMethod callable, Class<? extends Annotation> annoClass, Method method) {
        if (callable != null) {
            StringBuilder err = new StringBuilder();
            err.append("Duplicate @").append(annoClass.getSimpleName()).append(" declaration on ");
            err.append(method);
            err.append(System.lineSeparator());
            err.append("@").append(annoClass.getSimpleName()).append(" previously declared at ");
            err.append(callable.getMethod());
            throw new InvalidWebSocketException(err.toString());
        }
    }

    protected void assertValidSignature(Method method, Class<? extends Annotation> annoClass, ParamList validParams) {
        assertIsPublicNonStatic(method);
        assertIsReturn(method, Void.TYPE);
        boolean valid = false;
        Class<?>[] actual = method.getParameterTypes();
        Iterator<Class<?>[]> it = validParams.iterator();
        while (true) {
            if (it.hasNext()) {
                if (isSameParameters(actual, it.next())) {
                    valid = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!valid) {
            throw InvalidSignatureException.build(method, annoClass, validParams);
        }
    }

    public boolean isAnnotation(Annotation annotation, Class<? extends Annotation> annotationClass) {
        return annotation.annotationType().equals(annotationClass);
    }

    public boolean isSameParameters(Class<?>[] actual, Class<?>[] params) {
        if (actual.length != params.length) {
            return false;
        }
        int len = params.length;
        for (int i = 0; i < len; i++) {
            if (!actual[i].equals(params[i])) {
                return false;
            }
        }
        return true;
    }

    protected boolean isSignatureMatch(Method method, ParamList validParams) {
        assertIsPublicNonStatic(method);
        assertIsReturn(method, Void.TYPE);
        Class<?>[] actual = method.getParameterTypes();
        Iterator<Class<?>[]> it = validParams.iterator();
        while (it.hasNext()) {
            if (isSameParameters(actual, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<? extends java.lang.annotation.Annotation> */
    /* JADX WARN: Multi-variable type inference failed */
    protected boolean isTypeAnnotated(Class<?> pojo, Class<? extends Annotation> expectedAnnotation) {
        return pojo.getAnnotation(expectedAnnotation) != null;
    }

    public void scanMethodAnnotations(T metadata, Class<?> pojo) {
        Class<?> clazz = pojo;
        while (clazz != null && Object.class.isAssignableFrom(clazz)) {
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method : declaredMethods) {
                Annotation[] annotations = method.getAnnotations();
                if (annotations != null && annotations.length > 0) {
                    for (Annotation annotation : annotations) {
                        onMethodAnnotation(metadata, clazz, method, annotation);
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
    }
}
