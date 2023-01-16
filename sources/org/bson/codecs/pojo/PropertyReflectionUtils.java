package org.bson.codecs.pojo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertyReflectionUtils.class */
public final class PropertyReflectionUtils {
    private static final String IS_PREFIX = "is";
    private static final String GET_PREFIX = "get";
    private static final String SET_PREFIX = "set";

    private PropertyReflectionUtils() {
    }

    /* access modifiers changed from: package-private */
    public static boolean isGetter(Method method) {
        if (method.getParameterTypes().length > 0) {
            return false;
        }
        if (method.getName().startsWith("get") && method.getName().length() > "get".length()) {
            return Character.isUpperCase(method.getName().charAt("get".length()));
        }
        if (!method.getName().startsWith("is") || method.getName().length() <= "is".length()) {
            return false;
        }
        return Character.isUpperCase(method.getName().charAt("is".length()));
    }

    static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set") || method.getName().length() <= "set".length() || method.getParameterTypes().length != 1) {
            return false;
        }
        return Character.isUpperCase(method.getName().charAt("set".length()));
    }

    /* access modifiers changed from: package-private */
    public static String toPropertyName(Method method) {
        String name = method.getName();
        char[] chars = name.substring(name.startsWith("is") ? 2 : 3, name.length()).toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }

    /* access modifiers changed from: package-private */
    public static PropertyMethods getPropertyMethods(Class<?> clazz) {
        List<Method> setters = new ArrayList<>();
        List<Method> getters = new ArrayList<>();
        for (Class<?> i : clazz.getInterfaces()) {
            Method[] declaredMethods = i.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isDefault()) {
                    verifyAddMethodToList(method, getters, setters);
                }
            }
        }
        for (Method method2 : clazz.getDeclaredMethods()) {
            verifyAddMethodToList(method2, getters, setters);
        }
        return new PropertyMethods(getters, setters);
    }

    private static void verifyAddMethodToList(Method method, List<Method> getters, List<Method> setters) {
        if (Modifier.isPublic(method.getModifiers()) && !method.isBridge()) {
            if (isGetter(method)) {
                getters.add(method);
            } else if (isSetter(method)) {
                setters.add(method);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertyReflectionUtils$PropertyMethods.class */
    public static class PropertyMethods {
        private final Collection<Method> getterMethods;
        private final Collection<Method> setterMethods;

        PropertyMethods(Collection<Method> getterMethods, Collection<Method> setterMethods) {
            this.getterMethods = getterMethods;
            this.setterMethods = setterMethods;
        }

        /* access modifiers changed from: package-private */
        public Collection<Method> getGetterMethods() {
            return this.getterMethods;
        }

        /* access modifiers changed from: package-private */
        public Collection<Method> getSetterMethods() {
            return this.setterMethods;
        }
    }
}
