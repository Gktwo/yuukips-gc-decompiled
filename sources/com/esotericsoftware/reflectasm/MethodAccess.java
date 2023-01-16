package com.esotericsoftware.reflectasm;

import com.esotericsoftware.asm.ClassWriter;
import com.esotericsoftware.asm.Label;
import com.esotericsoftware.asm.MethodVisitor;
import com.esotericsoftware.asm.Type;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import org.jline.console.Printer;
import p001ch.qos.logback.core.CoreConstants;

/* loaded from: grasscutter.jar:com/esotericsoftware/reflectasm/MethodAccess.class */
public abstract class MethodAccess {
    private String[] methodNames;
    private Class[][] parameterTypes;
    private Class[] returnTypes;

    public abstract Object invoke(Object obj, int i, Object... objArr);

    public Object invoke(Object object, String methodName, Class[] paramTypes, Object... args) {
        return invoke(object, getIndex(methodName, paramTypes), args);
    }

    public Object invoke(Object object, String methodName, Object... args) {
        return invoke(object, getIndex(methodName, args == null ? 0 : args.length), args);
    }

    public int getIndex(String methodName) {
        int n = this.methodNames.length;
        for (int i = 0; i < n; i++) {
            if (this.methodNames[i].equals(methodName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Unable to find non-private method: " + methodName);
    }

    public int getIndex(String methodName, Class... paramTypes) {
        int n = this.methodNames.length;
        for (int i = 0; i < n; i++) {
            if (this.methodNames[i].equals(methodName) && Arrays.equals(paramTypes, this.parameterTypes[i])) {
                return i;
            }
        }
        throw new IllegalArgumentException("Unable to find non-private method: " + methodName + " " + Arrays.toString(paramTypes));
    }

    public int getIndex(String methodName, int paramsCount) {
        int n = this.methodNames.length;
        for (int i = 0; i < n; i++) {
            if (this.methodNames[i].equals(methodName) && this.parameterTypes[i].length == paramsCount) {
                return i;
            }
        }
        throw new IllegalArgumentException("Unable to find non-private method: " + methodName + " with " + paramsCount + " params.");
    }

    public String[] getMethodNames() {
        return this.methodNames;
    }

    public Class[][] getParameterTypes() {
        return this.parameterTypes;
    }

    public Class[] getReturnTypes() {
        return this.returnTypes;
    }

    public static MethodAccess get(Class type) {
        Class accessClass;
        int invoke;
        boolean isInterface = type.isInterface();
        if (isInterface || type.getSuperclass() != null || type == Object.class) {
            ArrayList<Method> methods = new ArrayList<>();
            if (!isInterface) {
                for (Class nextClass = type; nextClass != Object.class; nextClass = nextClass.getSuperclass()) {
                    addDeclaredMethodsToList(nextClass, methods);
                }
            } else {
                recursiveAddInterfaceMethodsToList(type, methods);
            }
            int n = methods.size();
            String[] methodNames = new String[n];
            Class[][] parameterTypes = new Class[n];
            Class[] returnTypes = new Class[n];
            for (int i = 0; i < n; i++) {
                Method method = methods.get(i);
                methodNames[i] = method.getName();
                parameterTypes[i] = method.getParameterTypes();
                returnTypes[i] = method.getReturnType();
            }
            String className = type.getName();
            String accessClassName = className + "MethodAccess";
            if (accessClassName.startsWith("java.")) {
                accessClassName = "reflectasm." + accessClassName;
            }
            AccessClassLoader loader = AccessClassLoader.get(type);
            synchronized (loader) {
                accessClass = loader.loadAccessClass(accessClassName);
                if (accessClass == null) {
                    String accessClassNameInternal = accessClassName.replace('.', '/');
                    String classNameInternal = className.replace('.', '/');
                    ClassWriter cw = new ClassWriter(1);
                    cw.visit(196653, 33, accessClassNameInternal, null, "com/esotericsoftware/reflectasm/MethodAccess", null);
                    MethodVisitor mv = cw.visitMethod(1, "<init>", "()V", null, null);
                    mv.visitCode();
                    mv.visitVarInsn(25, 0);
                    mv.visitMethodInsn(183, "com/esotericsoftware/reflectasm/MethodAccess", "<init>", "()V");
                    mv.visitInsn(177);
                    mv.visitMaxs(0, 0);
                    mv.visitEnd();
                    MethodVisitor mv2 = cw.visitMethod(129, "invoke", "(Ljava/lang/Object;I[Ljava/lang/Object;)Ljava/lang/Object;", null, null);
                    mv2.visitCode();
                    if (!methods.isEmpty()) {
                        mv2.visitVarInsn(25, 1);
                        mv2.visitTypeInsn(192, classNameInternal);
                        mv2.visitVarInsn(58, 4);
                        mv2.visitVarInsn(21, 2);
                        Label[] labels = new Label[n];
                        for (int i2 = 0; i2 < n; i2++) {
                            labels[i2] = new Label();
                        }
                        Label defaultLabel = new Label();
                        mv2.visitTableSwitchInsn(0, labels.length - 1, defaultLabel, labels);
                        StringBuilder buffer = new StringBuilder(128);
                        for (int i3 = 0; i3 < n; i3++) {
                            mv2.visitLabel(labels[i3]);
                            if (i3 == 0) {
                                mv2.visitFrame(1, 1, new Object[]{classNameInternal}, 0, null);
                            } else {
                                mv2.visitFrame(3, 0, null, 0, null);
                            }
                            mv2.visitVarInsn(25, 4);
                            buffer.setLength(0);
                            buffer.append('(');
                            Class[] paramTypes = parameterTypes[i3];
                            Class returnType = returnTypes[i3];
                            for (int paramIndex = 0; paramIndex < paramTypes.length; paramIndex++) {
                                mv2.visitVarInsn(25, 3);
                                mv2.visitIntInsn(16, paramIndex);
                                mv2.visitInsn(50);
                                Type paramType = Type.getType(paramTypes[paramIndex]);
                                switch (paramType.getSort()) {
                                    case 1:
                                        mv2.visitTypeInsn(192, "java/lang/Boolean");
                                        mv2.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z");
                                        break;
                                    case 2:
                                        mv2.visitTypeInsn(192, "java/lang/Character");
                                        mv2.visitMethodInsn(182, "java/lang/Character", "charValue", "()C");
                                        break;
                                    case 3:
                                        mv2.visitTypeInsn(192, "java/lang/Byte");
                                        mv2.visitMethodInsn(182, "java/lang/Byte", "byteValue", "()B");
                                        break;
                                    case 4:
                                        mv2.visitTypeInsn(192, "java/lang/Short");
                                        mv2.visitMethodInsn(182, "java/lang/Short", "shortValue", "()S");
                                        break;
                                    case 5:
                                        mv2.visitTypeInsn(192, "java/lang/Integer");
                                        mv2.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I");
                                        break;
                                    case 6:
                                        mv2.visitTypeInsn(192, "java/lang/Float");
                                        mv2.visitMethodInsn(182, "java/lang/Float", "floatValue", "()F");
                                        break;
                                    case 7:
                                        mv2.visitTypeInsn(192, "java/lang/Long");
                                        mv2.visitMethodInsn(182, "java/lang/Long", "longValue", "()J");
                                        break;
                                    case 8:
                                        mv2.visitTypeInsn(192, "java/lang/Double");
                                        mv2.visitMethodInsn(182, "java/lang/Double", "doubleValue", "()D");
                                        break;
                                    case 9:
                                        mv2.visitTypeInsn(192, paramType.getDescriptor());
                                        break;
                                    case 10:
                                        mv2.visitTypeInsn(192, paramType.getInternalName());
                                        break;
                                }
                                buffer.append(paramType.getDescriptor());
                            }
                            buffer.append(')');
                            buffer.append(Type.getDescriptor(returnType));
                            if (isInterface) {
                                invoke = 185;
                            } else if (Modifier.isStatic(methods.get(i3).getModifiers())) {
                                invoke = 184;
                            } else {
                                invoke = 182;
                            }
                            mv2.visitMethodInsn(invoke, classNameInternal, methodNames[i3], buffer.toString());
                            switch (Type.getType(returnType).getSort()) {
                                case 0:
                                    mv2.visitInsn(1);
                                    break;
                                case 1:
                                    mv2.visitMethodInsn(184, "java/lang/Boolean", CoreConstants.VALUE_OF, "(Z)Ljava/lang/Boolean;");
                                    break;
                                case 2:
                                    mv2.visitMethodInsn(184, "java/lang/Character", CoreConstants.VALUE_OF, "(C)Ljava/lang/Character;");
                                    break;
                                case 3:
                                    mv2.visitMethodInsn(184, "java/lang/Byte", CoreConstants.VALUE_OF, "(B)Ljava/lang/Byte;");
                                    break;
                                case 4:
                                    mv2.visitMethodInsn(184, "java/lang/Short", CoreConstants.VALUE_OF, "(S)Ljava/lang/Short;");
                                    break;
                                case 5:
                                    mv2.visitMethodInsn(184, "java/lang/Integer", CoreConstants.VALUE_OF, "(I)Ljava/lang/Integer;");
                                    break;
                                case 6:
                                    mv2.visitMethodInsn(184, "java/lang/Float", CoreConstants.VALUE_OF, "(F)Ljava/lang/Float;");
                                    break;
                                case 7:
                                    mv2.visitMethodInsn(184, "java/lang/Long", CoreConstants.VALUE_OF, "(J)Ljava/lang/Long;");
                                    break;
                                case 8:
                                    mv2.visitMethodInsn(184, "java/lang/Double", CoreConstants.VALUE_OF, "(D)Ljava/lang/Double;");
                                    break;
                            }
                            mv2.visitInsn(176);
                        }
                        mv2.visitLabel(defaultLabel);
                        mv2.visitFrame(3, 0, null, 0, null);
                    }
                    mv2.visitTypeInsn(187, "java/lang/IllegalArgumentException");
                    mv2.visitInsn(89);
                    mv2.visitTypeInsn(187, "java/lang/StringBuilder");
                    mv2.visitInsn(89);
                    mv2.visitLdcInsn("Method not found: ");
                    mv2.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
                    mv2.visitVarInsn(21, 2);
                    mv2.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
                    mv2.visitMethodInsn(182, "java/lang/StringBuilder", Printer.TO_STRING, "()Ljava/lang/String;");
                    mv2.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
                    mv2.visitInsn(191);
                    mv2.visitMaxs(0, 0);
                    mv2.visitEnd();
                    cw.visitEnd();
                    accessClass = loader.defineAccessClass(accessClassName, cw.toByteArray());
                }
            }
            try {
                MethodAccess access = (MethodAccess) accessClass.newInstance();
                access.methodNames = methodNames;
                access.parameterTypes = parameterTypes;
                access.returnTypes = returnTypes;
                return access;
            } catch (Throwable t) {
                throw new RuntimeException("Error constructing method access class: " + accessClassName, t);
            }
        } else {
            throw new IllegalArgumentException("The type must not be an interface, a primitive type, or void.");
        }
    }

    private static void addDeclaredMethodsToList(Class type, ArrayList<Method> methods) {
        Method[] declaredMethods = type.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (!Modifier.isPrivate(method.getModifiers())) {
                methods.add(method);
            }
        }
    }

    private static void recursiveAddInterfaceMethodsToList(Class interfaceType, ArrayList<Method> methods) {
        addDeclaredMethodsToList(interfaceType, methods);
        for (Class nextInterface : interfaceType.getInterfaces()) {
            recursiveAddInterfaceMethodsToList(nextInterface, methods);
        }
    }
}
