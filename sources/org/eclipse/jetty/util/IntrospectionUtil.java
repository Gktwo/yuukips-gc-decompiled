package org.eclipse.jetty.util;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/IntrospectionUtil.class */
public class IntrospectionUtil {
    public static boolean isJavaBeanCompliantSetter(Method method) {
        return method != null && method.getReturnType() == Void.TYPE && method.getName().startsWith("set") && method.getParameterCount() == 1;
    }

    public static Method findMethod(Class<?> clazz, String methodName, Class<?>[] args, boolean checkInheritance, boolean strictArgs) throws NoSuchMethodException {
        if (clazz == null) {
            throw new NoSuchMethodException("No class");
        } else if (methodName == null || methodName.trim().equals("")) {
            throw new NoSuchMethodException("No method name");
        } else {
            Method method = null;
            Method[] methods = clazz.getDeclaredMethods();
            for (int i = 0; i < methods.length && method == null; i++) {
                if (methods[i].getName().equals(methodName)) {
                    if (checkParams(methods[i].getParameterTypes(), args == null ? new Class[0] : args, strictArgs)) {
                        method = methods[i];
                    }
                }
            }
            if (method != null) {
                return method;
            }
            if (checkInheritance) {
                return findInheritedMethod(clazz.getPackage(), clazz.getSuperclass(), methodName, args, strictArgs);
            }
            throw new NoSuchMethodException("No such method " + methodName + " on class " + clazz.getName());
        }
    }

    public static Field findField(Class<?> clazz, String targetName, Class<?> targetType, boolean checkInheritance, boolean strictType) throws NoSuchFieldException {
        if (clazz == null) {
            throw new NoSuchFieldException("No class");
        } else if (targetName == null) {
            throw new NoSuchFieldException("No field name");
        } else {
            try {
                Field field = clazz.getDeclaredField(targetName);
                if (strictType) {
                    if (field.getType().equals(targetType)) {
                        return field;
                    }
                } else if (field.getType().isAssignableFrom(targetType)) {
                    return field;
                }
                if (checkInheritance) {
                    return findInheritedField(clazz.getPackage(), clazz.getSuperclass(), targetName, targetType, strictType);
                }
                throw new NoSuchFieldException("No field with name " + targetName + " in class " + clazz.getName() + " of type " + targetType);
            } catch (NoSuchFieldException e) {
                return findInheritedField(clazz.getPackage(), clazz.getSuperclass(), targetName, targetType, strictType);
            }
        }
    }

    public static boolean isInheritable(Package pack, Member member) {
        if (pack == null || member == null) {
            return false;
        }
        int modifiers = member.getModifiers();
        if (!Modifier.isPublic(modifiers) && !Modifier.isProtected(modifiers)) {
            return !Modifier.isPrivate(modifiers) && pack.equals(member.getDeclaringClass().getPackage());
        }
        return true;
    }

    public static boolean checkParams(Class<?>[] formalParams, Class<?>[] actualParams, boolean strict) {
        if (formalParams == null) {
            return actualParams == null;
        }
        if (actualParams == null || formalParams.length != actualParams.length) {
            return false;
        }
        if (formalParams.length == 0) {
            return true;
        }
        int j = 0;
        if (strict) {
            while (j < formalParams.length && formalParams[j].equals(actualParams[j])) {
                j++;
            }
        } else {
            while (j < formalParams.length && formalParams[j].isAssignableFrom(actualParams[j])) {
                j++;
            }
        }
        return j == formalParams.length;
    }

    public static boolean isSameSignature(Method methodA, Method methodB) {
        if (methodA == null || methodB == null) {
            return false;
        }
        return methodA.getName().equals(methodB.getName()) && Arrays.asList(methodA.getParameterTypes()).containsAll(Arrays.asList(methodB.getParameterTypes()));
    }

    public static boolean isTypeCompatible(Class<?> formalType, Class<?> actualType, boolean strict) {
        if (formalType == null) {
            return actualType == null;
        }
        if (actualType == null) {
            return false;
        }
        if (strict) {
            return formalType.equals(actualType);
        }
        return formalType.isAssignableFrom(actualType);
    }

    public static boolean containsSameMethodSignature(Method method, Class<?> c, boolean checkPackage) {
        if (checkPackage && !c.getPackage().equals(method.getDeclaringClass().getPackage())) {
            return false;
        }
        boolean samesig = false;
        Method[] methods = c.getDeclaredMethods();
        for (int i = 0; i < methods.length && !samesig; i++) {
            if (isSameSignature(method, methods[i])) {
                samesig = true;
            }
        }
        return samesig;
    }

    public static boolean containsSameFieldName(Field field, Class<?> c, boolean checkPackage) {
        if (checkPackage && !c.getPackage().equals(field.getDeclaringClass().getPackage())) {
            return false;
        }
        boolean sameName = false;
        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length && !sameName; i++) {
            if (fields[i].getName().equals(field.getName())) {
                sameName = true;
            }
        }
        return sameName;
    }

    protected static Method findInheritedMethod(Package pack, Class<?> clazz, String methodName, Class<?>[] args, boolean strictArgs) throws NoSuchMethodException {
        if (clazz == null) {
            throw new NoSuchMethodException("No class");
        } else if (methodName == null) {
            throw new NoSuchMethodException("No method name");
        } else {
            Method method = null;
            Method[] methods = clazz.getDeclaredMethods();
            for (int i = 0; i < methods.length && method == null; i++) {
                if (methods[i].getName().equals(methodName) && isInheritable(pack, methods[i]) && checkParams(methods[i].getParameterTypes(), args, strictArgs)) {
                    method = methods[i];
                }
            }
            if (method != null) {
                return method;
            }
            return findInheritedMethod(clazz.getPackage(), clazz.getSuperclass(), methodName, args, strictArgs);
        }
    }

    protected static Field findInheritedField(Package pack, Class<?> clazz, String fieldName, Class<?> fieldType, boolean strictType) throws NoSuchFieldException {
        if (clazz == null) {
            throw new NoSuchFieldException("No class");
        } else if (fieldName == null) {
            throw new NoSuchFieldException("No field name");
        } else {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                if (!isInheritable(pack, field) || !isTypeCompatible(fieldType, field.getType(), strictType)) {
                    return findInheritedField(clazz.getPackage(), clazz.getSuperclass(), fieldName, fieldType, strictType);
                }
                return field;
            } catch (NoSuchFieldException e) {
                return findInheritedField(clazz.getPackage(), clazz.getSuperclass(), fieldName, fieldType, strictType);
            }
        }
    }
}
