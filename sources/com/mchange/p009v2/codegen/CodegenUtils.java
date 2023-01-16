package com.mchange.p009v2.codegen;

import com.mchange.p006v1.lang.ClassUtils;
import java.io.File;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: com.mchange.v2.codegen.CodegenUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/CodegenUtils.class */
public final class CodegenUtils {
    public static String getModifierString(int i) {
        StringBuffer stringBuffer = new StringBuffer(32);
        if (Modifier.isPublic(i)) {
            stringBuffer.append("public ");
        }
        if (Modifier.isProtected(i)) {
            stringBuffer.append("protected ");
        }
        if (Modifier.isPrivate(i)) {
            stringBuffer.append("private ");
        }
        if (Modifier.isAbstract(i)) {
            stringBuffer.append("abstract ");
        }
        if (Modifier.isStatic(i)) {
            stringBuffer.append("static ");
        }
        if (Modifier.isFinal(i)) {
            stringBuffer.append("final ");
        }
        if (Modifier.isSynchronized(i)) {
            stringBuffer.append("synchronized ");
        }
        if (Modifier.isTransient(i)) {
            stringBuffer.append("transient ");
        }
        if (Modifier.isVolatile(i)) {
            stringBuffer.append("volatile ");
        }
        if (Modifier.isStrict(i)) {
            stringBuffer.append("strictfp ");
        }
        if (Modifier.isNative(i)) {
            stringBuffer.append("native ");
        }
        if (Modifier.isInterface(i)) {
            stringBuffer.append("interface ");
        }
        return stringBuffer.toString().trim();
    }

    public static Class unarrayClass(Class cls) {
        Class cls2 = cls;
        while (cls2.isArray()) {
            cls2 = cls2.getComponentType();
        }
        return cls2;
    }

    public static boolean inSamePackage(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str2.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf2 < 0) {
            return true;
        }
        if (!str.substring(0, lastIndexOf).equals(str.substring(0, lastIndexOf)) || str2.indexOf(46) >= 0) {
            return false;
        }
        return true;
    }

    public static String fqcnLastElement(String str) {
        return ClassUtils.fqcnLastElement(str);
    }

    public static String methodSignature(Method method) {
        return methodSignature(method, null);
    }

    public static String methodSignature(Method method, String[] strArr) {
        return methodSignature(1, method, strArr);
    }

    public static String methodSignature(int i, Method method, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append(getModifierString(i));
        stringBuffer.append(' ');
        stringBuffer.append(ClassUtils.simpleClassName(method.getReturnType()));
        stringBuffer.append(' ');
        stringBuffer.append(method.getName());
        stringBuffer.append('(');
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(ClassUtils.simpleClassName(parameterTypes[i2]));
            stringBuffer.append(' ');
            stringBuffer.append(strArr == null ? String.valueOf((char) (97 + i2)) : strArr[i2]);
        }
        stringBuffer.append(')');
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        if (exceptionTypes.length > 0) {
            stringBuffer.append(" throws ");
            int length2 = exceptionTypes.length;
            for (int i3 = 0; i3 < length2; i3++) {
                if (i3 != 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(ClassUtils.simpleClassName(exceptionTypes[i3]));
            }
        }
        return stringBuffer.toString();
    }

    public static String methodCall(Method method) {
        return methodCall(method, null);
    }

    public static String methodCall(Method method, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append(method.getName());
        stringBuffer.append('(');
        int length = method.getParameterTypes().length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(strArr == null ? generatedArgumentName(i) : strArr[i]);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public static String reflectiveMethodObjectArray(Method method) {
        return reflectiveMethodObjectArray(method, null);
    }

    public static String reflectiveMethodObjectArray(Method method, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("new Object[] ");
        stringBuffer.append('{');
        int length = method.getParameterTypes().length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(strArr == null ? generatedArgumentName(i) : strArr[i]);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public static String reflectiveMethodParameterTypeArray(Method method) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("new Class[] ");
        stringBuffer.append('{');
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(ClassUtils.simpleClassName(parameterTypes[i]));
            stringBuffer.append(".class");
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public static String generatedArgumentName(int i) {
        return String.valueOf((char) (97 + i));
    }

    public static String simpleClassName(Class cls) {
        return ClassUtils.simpleClassName(cls);
    }

    public static IndentedWriter toIndentedWriter(Writer writer) {
        return writer instanceof IndentedWriter ? (IndentedWriter) writer : new IndentedWriter(writer);
    }

    public static String packageNameToFileSystemDirPath(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int length = stringBuffer.length();
        for (int i = 0; i < length; i++) {
            if (stringBuffer.charAt(i) == '.') {
                stringBuffer.setCharAt(i, File.separatorChar);
            }
        }
        stringBuffer.append(File.separatorChar);
        return stringBuffer.toString();
    }

    private CodegenUtils() {
    }
}
