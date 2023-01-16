package com.mchange.p006v1.lang;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;

/* renamed from: com.mchange.v1.lang.ClassUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/ClassUtils.class */
public final class ClassUtils {
    static final String[] EMPTY_SA = new String[0];
    static Map primitivesToClasses;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", Boolean.TYPE);
        hashMap.put("int", Integer.TYPE);
        hashMap.put("char", Character.TYPE);
        hashMap.put("short", Short.TYPE);
        hashMap.put("int", Integer.TYPE);
        hashMap.put("long", Long.TYPE);
        hashMap.put("float", Float.TYPE);
        hashMap.put("double", Double.TYPE);
        hashMap.put("void", Void.TYPE);
        primitivesToClasses = Collections.unmodifiableMap(hashMap);
    }

    public static Set publicSupertypesForMethods(Class cls, Method[] methodArr) {
        Set<Class> allAssignableFrom = allAssignableFrom(cls);
        HashSet hashSet = new HashSet();
        for (Class cls2 : allAssignableFrom) {
            if (isPublic(cls2) && hasAllMethodsAsSupertype(cls2, methodArr)) {
                hashSet.add(cls2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static boolean isPublic(Class cls) {
        return (cls.getModifiers() & 1) != 0;
    }

    public static boolean hasAllMethodsAsSupertype(Class cls, Method[] methodArr) {
        return hasAllMethods(cls, methodArr, true);
    }

    public static boolean hasAllMethodsAsSubtype(Class cls, Method[] methodArr) {
        return hasAllMethods(cls, methodArr, false);
    }

    private static boolean hasAllMethods(Class cls, Method[] methodArr, boolean z) {
        for (Method method : methodArr) {
            if (!containsMethod(cls, method, z)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsMethodAsSupertype(Class cls, Method method) {
        return containsMethod(cls, method, true);
    }

    public static boolean containsMethodAsSubtype(Class cls, Method method) {
        return containsMethod(cls, method, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (r0.isAssignableFrom(r0) != false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean containsMethod(java.lang.Class r4, java.lang.reflect.Method r5, boolean r6) {
        /*
            r0 = r4
            r1 = r5
            java.lang.String r1 = r1.getName()     // Catch: NoSuchMethodException -> 0x0045
            r2 = r5
            java.lang.Class[] r2 = r2.getParameterTypes()     // Catch: NoSuchMethodException -> 0x0045
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch: NoSuchMethodException -> 0x0045
            r7 = r0
            r0 = r5
            java.lang.Class r0 = r0.getReturnType()     // Catch: NoSuchMethodException -> 0x0045
            r8 = r0
            r0 = r7
            java.lang.Class r0 = r0.getReturnType()     // Catch: NoSuchMethodException -> 0x0045
            r9 = r0
            r0 = r8
            r1 = r9
            boolean r0 = r0.equals(r1)     // Catch: NoSuchMethodException -> 0x0045
            if (r0 != 0) goto L_0x003f
            r0 = r6
            if (r0 == 0) goto L_0x0031
            r0 = r9
            r1 = r8
            boolean r0 = r0.isAssignableFrom(r1)     // Catch: NoSuchMethodException -> 0x0045
            if (r0 != 0) goto L_0x003f
        L_0x0031:
            r0 = r6
            if (r0 != 0) goto L_0x0043
            r0 = r8
            r1 = r9
            boolean r0 = r0.isAssignableFrom(r1)     // Catch: NoSuchMethodException -> 0x0045
            if (r0 == 0) goto L_0x0043
        L_0x003f:
            r0 = 1
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            return r0
        L_0x0045:
            r8 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p006v1.lang.ClassUtils.containsMethod(java.lang.Class, java.lang.reflect.Method, boolean):boolean");
    }

    public static Set allAssignableFrom(Class cls) {
        HashSet hashSet = new HashSet();
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            hashSet.add(cls2);
        }
        addSuperInterfacesToSet(cls, hashSet);
        return hashSet;
    }

    public static String simpleClassName(Class cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
        }
        String simpleClassName = simpleClassName(cls.getName());
        if (i <= 0) {
            return simpleClassName;
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(simpleClassName);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return stringBuffer.toString();
    }

    private static String simpleClassName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return str;
        }
        String substring = str.substring(lastIndexOf + 1);
        if (substring.indexOf(36) < 0) {
            return substring;
        }
        StringBuffer stringBuffer = new StringBuffer(substring);
        int length = stringBuffer.length();
        for (int i = 0; i < length; i++) {
            if (stringBuffer.charAt(i) == '$') {
                stringBuffer.setCharAt(i, '.');
            }
        }
        return stringBuffer.toString();
    }

    public static boolean isPrimitive(String str) {
        return primitivesToClasses.get(str) != null;
    }

    public static Class classForPrimitive(String str) {
        return (Class) primitivesToClasses.get(str);
    }

    public static Class forName(String str) throws ClassNotFoundException {
        Class<?> classForPrimitive = classForPrimitive(str);
        if (classForPrimitive == null) {
            classForPrimitive = Class.forName(str);
        }
        return classForPrimitive;
    }

    public static Class forName(String str, String[] strArr, String[] strArr2) throws AmbiguousClassNameException, ClassNotFoundException {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return classForSimpleName(str, strArr, strArr2);
        }
    }

    public static Class classForSimpleName(String str, String[] strArr, String[] strArr2) throws AmbiguousClassNameException, ClassNotFoundException {
        Class<?> cls;
        HashSet hashSet = new HashSet();
        Class<?> classForPrimitive = classForPrimitive(str);
        if (classForPrimitive == null) {
            if (strArr == null) {
                strArr = EMPTY_SA;
            }
            if (strArr2 == null) {
                strArr2 = EMPTY_SA;
            }
            int length = strArr2.length;
            for (int i = 0; i < length; i++) {
                String fqcnLastElement = fqcnLastElement(strArr2[i]);
                if (!hashSet.add(fqcnLastElement)) {
                    throw new IllegalArgumentException("Duplicate imported classes: " + fqcnLastElement);
                }
                if (str.equals(fqcnLastElement)) {
                    classForPrimitive = Class.forName(strArr2[i]);
                }
            }
            if (classForPrimitive == null) {
                try {
                    classForPrimitive = Class.forName("java.lang." + str);
                } catch (ClassNotFoundException e) {
                }
                int length2 = strArr.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    try {
                        cls = Class.forName(strArr[i2] + '.' + str);
                    } catch (ClassNotFoundException e2) {
                    }
                    if (classForPrimitive != null) {
                        throw new AmbiguousClassNameException(str, classForPrimitive, cls);
                        break;
                    }
                    classForPrimitive = cls;
                }
            }
        }
        if (classForPrimitive != null) {
            return classForPrimitive;
        }
        throw new ClassNotFoundException("Could not find a class whose unqualified name is \"" + str + "\" with the imports supplied. Import packages are " + Arrays.asList(strArr) + "; class imports are " + Arrays.asList(strArr2));
    }

    public static String resolvableTypeName(Class cls, String[] strArr, String[] strArr2) throws ClassNotFoundException {
        String simpleClassName = simpleClassName(cls);
        try {
            classForSimpleName(simpleClassName, strArr, strArr2);
            return simpleClassName;
        } catch (AmbiguousClassNameException e) {
            return cls.getName();
        }
    }

    public static String fqcnLastElement(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    private static void addSuperInterfacesToSet(Class cls, Set set) {
        Class<?>[] interfaces = cls.getInterfaces();
        int length = interfaces.length;
        for (int i = 0; i < length; i++) {
            set.add(interfaces[i]);
            addSuperInterfacesToSet(interfaces[i], set);
        }
    }

    private ClassUtils() {
    }
}
