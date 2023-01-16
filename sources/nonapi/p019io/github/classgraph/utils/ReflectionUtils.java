package nonapi.p019io.github.classgraph.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: nonapi.io.github.classgraph.utils.ReflectionUtils */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/utils/ReflectionUtils.class */
public final class ReflectionUtils {
    private ReflectionUtils() {
    }

    private static Object getFieldVal(Class<?> cls, Object obj, String fieldName, boolean throwException) throws IllegalArgumentException {
        Field field = null;
        for (Class<?> currClass = cls; currClass != null; currClass = currClass.getSuperclass()) {
            try {
                field = currClass.getDeclaredField(fieldName);
                break;
            } catch (ReflectiveOperationException | SecurityException e) {
            }
        }
        if (field != null) {
            try {
                field.setAccessible(true);
            } catch (RuntimeException e2) {
            }
            try {
                return field.get(obj);
            } catch (IllegalAccessException e3) {
                if (!throwException) {
                    return null;
                }
                throw new IllegalArgumentException("Can't read " + (obj == null ? "static " : "") + " field \"" + fieldName + "\": " + e3);
            }
        } else if (!throwException) {
            return null;
        } else {
            throw new IllegalArgumentException((obj == null ? "Static field " : "Field ") + "\"" + fieldName + "\" not found or not accessible");
        }
    }

    public static Object getFieldVal(Object obj, String fieldName, boolean throwException) throws IllegalArgumentException {
        if (obj != null && fieldName != null) {
            return getFieldVal(obj.getClass(), obj, fieldName, throwException);
        }
        if (!throwException) {
            return null;
        }
        throw new NullPointerException();
    }

    public static Object getStaticFieldVal(Class<?> cls, String fieldName, boolean throwException) throws IllegalArgumentException {
        if (cls != null && fieldName != null) {
            return getFieldVal(cls, null, fieldName, throwException);
        }
        if (!throwException) {
            return null;
        }
        throw new NullPointerException();
    }

    private static List<Class<?>> getReverseMethodAttemptOrder(Class<?> cls) {
        List<Class<?>> reverseAttemptOrder = new ArrayList<>();
        Class<?> c = cls;
        while (c != null && c != Object.class) {
            reverseAttemptOrder.add(c);
            c = c.getSuperclass();
        }
        Set<Class<?>> addedIfaces = new HashSet<>();
        LinkedList<Class<?>> ifaceQueue = new LinkedList<>();
        for (Class<?> c2 = cls; c2 != null; c2 = c2.getSuperclass()) {
            if (c2.isInterface() && addedIfaces.add(c2)) {
                ifaceQueue.add(c2);
            }
            Class<?>[] interfaces = c2.getInterfaces();
            for (Class<?> iface : interfaces) {
                if (addedIfaces.add(iface)) {
                    ifaceQueue.add(iface);
                }
            }
        }
        while (!ifaceQueue.isEmpty()) {
            Class<?> iface2 = ifaceQueue.remove();
            reverseAttemptOrder.add(iface2);
            Class<?>[] superIfaces = iface2.getInterfaces();
            if (superIfaces.length > 0) {
                for (Class<?> superIface : superIfaces) {
                    if (addedIfaces.add(superIface)) {
                        ifaceQueue.add(superIface);
                    }
                }
            }
        }
        return reverseAttemptOrder;
    }

    private static Object invokeMethod(Class<?> cls, Object obj, String methodName, boolean oneArg, Class<?> argType, Object param, boolean throwException) throws IllegalArgumentException {
        Method method = null;
        List<Class<?>> reverseAttemptOrder = getReverseMethodAttemptOrder(cls);
        for (int i = reverseAttemptOrder.size() - 1; i >= 0; i--) {
            Class<?> classOrInterface = reverseAttemptOrder.get(i);
            try {
                method = oneArg ? classOrInterface.getDeclaredMethod(methodName, argType) : classOrInterface.getDeclaredMethod(methodName, new Class[0]);
                break;
            } catch (ReflectiveOperationException | SecurityException e) {
            }
        }
        if (method != null) {
            try {
                method.setAccessible(true);
            } catch (RuntimeException e2) {
            }
            try {
                return oneArg ? method.invoke(obj, param) : method.invoke(obj, new Object[0]);
            } catch (IllegalAccessException | SecurityException e3) {
                if (!throwException) {
                    return null;
                }
                throw new IllegalArgumentException("Can't call " + (obj == null ? "static " : "") + "method \"" + methodName + "\": " + e3);
            } catch (InvocationTargetException e4) {
                if (!throwException) {
                    return null;
                }
                throw new IllegalArgumentException("Exception while invoking " + (obj == null ? "static " : "") + "method \"" + methodName + "\"", e4);
            }
        } else if (!throwException) {
            return null;
        } else {
            throw new IllegalArgumentException((obj == null ? "Static method " : "Method ") + "\"" + methodName + "\" not found or not accesible");
        }
    }

    public static Object invokeMethod(Object obj, String methodName, boolean throwException) throws IllegalArgumentException {
        if (obj != null && methodName != null) {
            return invokeMethod(obj.getClass(), obj, methodName, false, null, null, throwException);
        }
        if (!throwException) {
            return null;
        }
        throw new NullPointerException();
    }

    public static Object invokeMethod(Object obj, String methodName, Class<?> argType, Object param, boolean throwException) throws IllegalArgumentException {
        if (obj != null && methodName != null) {
            return invokeMethod(obj.getClass(), obj, methodName, true, argType, param, throwException);
        }
        if (!throwException) {
            return null;
        }
        throw new NullPointerException();
    }

    public static Object invokeStaticMethod(Class<?> cls, String methodName, boolean throwException) throws IllegalArgumentException {
        if (cls != null && methodName != null) {
            return invokeMethod(cls, null, methodName, false, null, null, throwException);
        }
        if (!throwException) {
            return null;
        }
        throw new NullPointerException();
    }

    public static Object invokeStaticMethod(Class<?> cls, String methodName, Class<?> argType, Object param, boolean throwException) throws IllegalArgumentException {
        if (cls != null && methodName != null) {
            return invokeMethod(cls, null, methodName, true, argType, param, throwException);
        }
        if (!throwException) {
            return null;
        }
        throw new NullPointerException();
    }

    public static Class<?> classForNameOrNull(String className) {
        try {
            return Class.forName(className);
        } catch (LinkageError | ReflectiveOperationException e) {
            return null;
        }
    }
}
