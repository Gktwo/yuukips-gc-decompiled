package com.esotericsoftware.reflectasm;

import com.esotericsoftware.asm.ClassWriter;
import com.esotericsoftware.asm.Label;
import com.esotericsoftware.asm.MethodVisitor;
import com.esotericsoftware.asm.Type;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.jline.console.Printer;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* loaded from: grasscutter.jar:com/esotericsoftware/reflectasm/FieldAccess.class */
public abstract class FieldAccess {
    private String[] fieldNames;
    private Class[] fieldTypes;
    private Field[] fields;

    public abstract void set(Object obj, int i, Object obj2);

    public abstract void setBoolean(Object obj, int i, boolean z);

    public abstract void setByte(Object obj, int i, byte b);

    public abstract void setShort(Object obj, int i, short s);

    public abstract void setInt(Object obj, int i, int i2);

    public abstract void setLong(Object obj, int i, long j);

    public abstract void setDouble(Object obj, int i, double d);

    public abstract void setFloat(Object obj, int i, float f);

    public abstract void setChar(Object obj, int i, char c);

    public abstract Object get(Object obj, int i);

    public abstract String getString(Object obj, int i);

    public abstract char getChar(Object obj, int i);

    public abstract boolean getBoolean(Object obj, int i);

    public abstract byte getByte(Object obj, int i);

    public abstract short getShort(Object obj, int i);

    public abstract int getInt(Object obj, int i);

    public abstract long getLong(Object obj, int i);

    public abstract double getDouble(Object obj, int i);

    public abstract float getFloat(Object obj, int i);

    public int getIndex(String fieldName) {
        int n = this.fieldNames.length;
        for (int i = 0; i < n; i++) {
            if (this.fieldNames[i].equals(fieldName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Unable to find non-private field: " + fieldName);
    }

    public int getIndex(Field field) {
        int n = this.fields.length;
        for (int i = 0; i < n; i++) {
            if (this.fields[i].equals(field)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Unable to find non-private field: " + field);
    }

    public void set(Object instance, String fieldName, Object value) {
        set(instance, getIndex(fieldName), value);
    }

    public Object get(Object instance, String fieldName) {
        return get(instance, getIndex(fieldName));
    }

    public String[] getFieldNames() {
        return this.fieldNames;
    }

    public Class[] getFieldTypes() {
        return this.fieldTypes;
    }

    public int getFieldCount() {
        return this.fieldTypes.length;
    }

    public Field[] getFields() {
        return this.fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public static FieldAccess get(Class type) {
        Class accessClass;
        if (type.getSuperclass() == null) {
            throw new IllegalArgumentException("The type must not be the Object class, an interface, a primitive type, or void.");
        }
        ArrayList<Field> fields = new ArrayList<>();
        for (Class nextClass = type; nextClass != Object.class; nextClass = nextClass.getSuperclass()) {
            Field[] declaredFields = nextClass.getDeclaredFields();
            for (Field field : declaredFields) {
                int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isPrivate(modifiers)) {
                    fields.add(field);
                }
            }
        }
        String[] fieldNames = new String[fields.size()];
        Class[] fieldTypes = new Class[fields.size()];
        int n = fieldNames.length;
        for (int i = 0; i < n; i++) {
            fieldNames[i] = fields.get(i).getName();
            fieldTypes[i] = fields.get(i).getType();
        }
        String className = type.getName();
        String accessClassName = className + "FieldAccess";
        if (accessClassName.startsWith("java.")) {
            accessClassName = "reflectasm." + accessClassName;
        }
        AccessClassLoader loader = AccessClassLoader.get(type);
        synchronized (loader) {
            accessClass = loader.loadAccessClass(accessClassName);
            if (accessClass == null) {
                String accessClassNameInternal = accessClassName.replace('.', '/');
                String classNameInternal = className.replace('.', '/');
                ClassWriter cw = new ClassWriter(0);
                cw.visit(196653, 33, accessClassNameInternal, null, "com/esotericsoftware/reflectasm/FieldAccess", null);
                insertConstructor(cw);
                insertGetObject(cw, classNameInternal, fields);
                insertSetObject(cw, classNameInternal, fields);
                insertGetPrimitive(cw, classNameInternal, fields, Type.BOOLEAN_TYPE);
                insertSetPrimitive(cw, classNameInternal, fields, Type.BOOLEAN_TYPE);
                insertGetPrimitive(cw, classNameInternal, fields, Type.BYTE_TYPE);
                insertSetPrimitive(cw, classNameInternal, fields, Type.BYTE_TYPE);
                insertGetPrimitive(cw, classNameInternal, fields, Type.SHORT_TYPE);
                insertSetPrimitive(cw, classNameInternal, fields, Type.SHORT_TYPE);
                insertGetPrimitive(cw, classNameInternal, fields, Type.INT_TYPE);
                insertSetPrimitive(cw, classNameInternal, fields, Type.INT_TYPE);
                insertGetPrimitive(cw, classNameInternal, fields, Type.LONG_TYPE);
                insertSetPrimitive(cw, classNameInternal, fields, Type.LONG_TYPE);
                insertGetPrimitive(cw, classNameInternal, fields, Type.DOUBLE_TYPE);
                insertSetPrimitive(cw, classNameInternal, fields, Type.DOUBLE_TYPE);
                insertGetPrimitive(cw, classNameInternal, fields, Type.FLOAT_TYPE);
                insertSetPrimitive(cw, classNameInternal, fields, Type.FLOAT_TYPE);
                insertGetPrimitive(cw, classNameInternal, fields, Type.CHAR_TYPE);
                insertSetPrimitive(cw, classNameInternal, fields, Type.CHAR_TYPE);
                insertGetString(cw, classNameInternal, fields);
                cw.visitEnd();
                accessClass = loader.defineAccessClass(accessClassName, cw.toByteArray());
            }
        }
        try {
            FieldAccess access = (FieldAccess) accessClass.newInstance();
            access.fieldNames = fieldNames;
            access.fieldTypes = fieldTypes;
            access.fields = (Field[]) fields.toArray(new Field[fields.size()]);
            return access;
        } catch (Throwable t) {
            throw new RuntimeException("Error constructing field access class: " + accessClassName, t);
        }
    }

    private static void insertConstructor(ClassWriter cw) {
        MethodVisitor mv = cw.visitMethod(1, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(183, "com/esotericsoftware/reflectasm/FieldAccess", "<init>", "()V");
        mv.visitInsn(177);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
    }

    private static void insertSetObject(ClassWriter cw, String classNameInternal, ArrayList<Field> fields) {
        int maxStack = 6;
        MethodVisitor mv = cw.visitMethod(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
        mv.visitCode();
        mv.visitVarInsn(21, 2);
        if (!fields.isEmpty()) {
            maxStack = 6 - 1;
            Label[] labels = new Label[fields.size()];
            int n = labels.length;
            for (int i = 0; i < n; i++) {
                labels[i] = new Label();
            }
            Label defaultLabel = new Label();
            mv.visitTableSwitchInsn(0, labels.length - 1, defaultLabel, labels);
            int n2 = labels.length;
            for (int i2 = 0; i2 < n2; i2++) {
                Field field = fields.get(i2);
                Type fieldType = Type.getType(field.getType());
                mv.visitLabel(labels[i2]);
                mv.visitFrame(3, 0, null, 0, null);
                mv.visitVarInsn(25, 1);
                mv.visitTypeInsn(192, classNameInternal);
                mv.visitVarInsn(25, 3);
                switch (fieldType.getSort()) {
                    case 1:
                        mv.visitTypeInsn(192, "java/lang/Boolean");
                        mv.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z");
                        break;
                    case 2:
                        mv.visitTypeInsn(192, "java/lang/Character");
                        mv.visitMethodInsn(182, "java/lang/Character", "charValue", "()C");
                        break;
                    case 3:
                        mv.visitTypeInsn(192, "java/lang/Byte");
                        mv.visitMethodInsn(182, "java/lang/Byte", "byteValue", "()B");
                        break;
                    case 4:
                        mv.visitTypeInsn(192, "java/lang/Short");
                        mv.visitMethodInsn(182, "java/lang/Short", "shortValue", "()S");
                        break;
                    case 5:
                        mv.visitTypeInsn(192, "java/lang/Integer");
                        mv.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I");
                        break;
                    case 6:
                        mv.visitTypeInsn(192, "java/lang/Float");
                        mv.visitMethodInsn(182, "java/lang/Float", "floatValue", "()F");
                        break;
                    case 7:
                        mv.visitTypeInsn(192, "java/lang/Long");
                        mv.visitMethodInsn(182, "java/lang/Long", "longValue", "()J");
                        break;
                    case 8:
                        mv.visitTypeInsn(192, "java/lang/Double");
                        mv.visitMethodInsn(182, "java/lang/Double", "doubleValue", "()D");
                        break;
                    case 9:
                        mv.visitTypeInsn(192, fieldType.getDescriptor());
                        break;
                    case 10:
                        mv.visitTypeInsn(192, fieldType.getInternalName());
                        break;
                }
                mv.visitFieldInsn(181, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), fieldType.getDescriptor());
                mv.visitInsn(177);
            }
            mv.visitLabel(defaultLabel);
            mv.visitFrame(3, 0, null, 0, null);
        }
        MethodVisitor mv2 = insertThrowExceptionForFieldNotFound(mv);
        mv2.visitMaxs(maxStack, 4);
        mv2.visitEnd();
    }

    private static void insertGetObject(ClassWriter cw, String classNameInternal, ArrayList<Field> fields) {
        int maxStack = 6;
        MethodVisitor mv = cw.visitMethod(1, BeanUtil.PREFIX_GETTER_GET, "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
        mv.visitCode();
        mv.visitVarInsn(21, 2);
        if (!fields.isEmpty()) {
            maxStack = 6 - 1;
            Label[] labels = new Label[fields.size()];
            int n = labels.length;
            for (int i = 0; i < n; i++) {
                labels[i] = new Label();
            }
            Label defaultLabel = new Label();
            mv.visitTableSwitchInsn(0, labels.length - 1, defaultLabel, labels);
            int n2 = labels.length;
            for (int i2 = 0; i2 < n2; i2++) {
                Field field = fields.get(i2);
                mv.visitLabel(labels[i2]);
                mv.visitFrame(3, 0, null, 0, null);
                mv.visitVarInsn(25, 1);
                mv.visitTypeInsn(192, classNameInternal);
                mv.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), Type.getDescriptor(field.getType()));
                switch (Type.getType(field.getType()).getSort()) {
                    case 1:
                        mv.visitMethodInsn(184, "java/lang/Boolean", CoreConstants.VALUE_OF, "(Z)Ljava/lang/Boolean;");
                        break;
                    case 2:
                        mv.visitMethodInsn(184, "java/lang/Character", CoreConstants.VALUE_OF, "(C)Ljava/lang/Character;");
                        break;
                    case 3:
                        mv.visitMethodInsn(184, "java/lang/Byte", CoreConstants.VALUE_OF, "(B)Ljava/lang/Byte;");
                        break;
                    case 4:
                        mv.visitMethodInsn(184, "java/lang/Short", CoreConstants.VALUE_OF, "(S)Ljava/lang/Short;");
                        break;
                    case 5:
                        mv.visitMethodInsn(184, "java/lang/Integer", CoreConstants.VALUE_OF, "(I)Ljava/lang/Integer;");
                        break;
                    case 6:
                        mv.visitMethodInsn(184, "java/lang/Float", CoreConstants.VALUE_OF, "(F)Ljava/lang/Float;");
                        break;
                    case 7:
                        mv.visitMethodInsn(184, "java/lang/Long", CoreConstants.VALUE_OF, "(J)Ljava/lang/Long;");
                        break;
                    case 8:
                        mv.visitMethodInsn(184, "java/lang/Double", CoreConstants.VALUE_OF, "(D)Ljava/lang/Double;");
                        break;
                }
                mv.visitInsn(176);
            }
            mv.visitLabel(defaultLabel);
            mv.visitFrame(3, 0, null, 0, null);
        }
        insertThrowExceptionForFieldNotFound(mv);
        mv.visitMaxs(maxStack, 3);
        mv.visitEnd();
    }

    private static void insertGetString(ClassWriter cw, String classNameInternal, ArrayList<Field> fields) {
        int maxStack = 6;
        MethodVisitor mv = cw.visitMethod(1, "getString", "(Ljava/lang/Object;I)Ljava/lang/String;", null, null);
        mv.visitCode();
        mv.visitVarInsn(21, 2);
        if (!fields.isEmpty()) {
            maxStack = 6 - 1;
            Label[] labels = new Label[fields.size()];
            Label labelForInvalidTypes = new Label();
            boolean hasAnyBadTypeLabel = false;
            int n = labels.length;
            for (int i = 0; i < n; i++) {
                if (fields.get(i).getType().equals(String.class)) {
                    labels[i] = new Label();
                } else {
                    labels[i] = labelForInvalidTypes;
                    hasAnyBadTypeLabel = true;
                }
            }
            Label defaultLabel = new Label();
            mv.visitTableSwitchInsn(0, labels.length - 1, defaultLabel, labels);
            int n2 = labels.length;
            for (int i2 = 0; i2 < n2; i2++) {
                if (!labels[i2].equals(labelForInvalidTypes)) {
                    Field field = fields.get(i2);
                    mv.visitLabel(labels[i2]);
                    mv.visitFrame(3, 0, null, 0, null);
                    mv.visitVarInsn(25, 1);
                    mv.visitTypeInsn(192, classNameInternal);
                    mv.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), "Ljava/lang/String;");
                    mv.visitInsn(176);
                }
            }
            if (hasAnyBadTypeLabel) {
                mv.visitLabel(labelForInvalidTypes);
                mv.visitFrame(3, 0, null, 0, null);
                insertThrowExceptionForFieldType(mv, "String");
            }
            mv.visitLabel(defaultLabel);
            mv.visitFrame(3, 0, null, 0, null);
        }
        insertThrowExceptionForFieldNotFound(mv);
        mv.visitMaxs(maxStack, 3);
        mv.visitEnd();
    }

    private static void insertSetPrimitive(ClassWriter cw, String classNameInternal, ArrayList<Field> fields, Type primitiveType) {
        int loadValueInstruction;
        String setterMethodName;
        int maxStack = 6;
        int maxLocals = 4;
        String typeNameInternal = primitiveType.getDescriptor();
        switch (primitiveType.getSort()) {
            case 1:
                setterMethodName = "setBoolean";
                loadValueInstruction = 21;
                break;
            case 2:
                setterMethodName = "setChar";
                loadValueInstruction = 21;
                break;
            case 3:
                setterMethodName = "setByte";
                loadValueInstruction = 21;
                break;
            case 4:
                setterMethodName = "setShort";
                loadValueInstruction = 21;
                break;
            case 5:
                setterMethodName = "setInt";
                loadValueInstruction = 21;
                break;
            case 6:
                setterMethodName = "setFloat";
                loadValueInstruction = 23;
                break;
            case 7:
                setterMethodName = "setLong";
                loadValueInstruction = 22;
                maxLocals = 4 + 1;
                break;
            case 8:
                setterMethodName = "setDouble";
                loadValueInstruction = 24;
                maxLocals = 4 + 1;
                break;
            default:
                setterMethodName = "set";
                loadValueInstruction = 25;
                break;
        }
        MethodVisitor mv = cw.visitMethod(1, setterMethodName, "(Ljava/lang/Object;I" + typeNameInternal + ")V", null, null);
        mv.visitCode();
        mv.visitVarInsn(21, 2);
        if (!fields.isEmpty()) {
            maxStack = 6 - 1;
            Label[] labels = new Label[fields.size()];
            Label labelForInvalidTypes = new Label();
            boolean hasAnyBadTypeLabel = false;
            int n = labels.length;
            for (int i = 0; i < n; i++) {
                if (Type.getType(fields.get(i).getType()).equals(primitiveType)) {
                    labels[i] = new Label();
                } else {
                    labels[i] = labelForInvalidTypes;
                    hasAnyBadTypeLabel = true;
                }
            }
            Label defaultLabel = new Label();
            mv.visitTableSwitchInsn(0, labels.length - 1, defaultLabel, labels);
            int n2 = labels.length;
            for (int i2 = 0; i2 < n2; i2++) {
                if (!labels[i2].equals(labelForInvalidTypes)) {
                    Field field = fields.get(i2);
                    mv.visitLabel(labels[i2]);
                    mv.visitFrame(3, 0, null, 0, null);
                    mv.visitVarInsn(25, 1);
                    mv.visitTypeInsn(192, classNameInternal);
                    mv.visitVarInsn(loadValueInstruction, 3);
                    mv.visitFieldInsn(181, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), typeNameInternal);
                    mv.visitInsn(177);
                }
            }
            if (hasAnyBadTypeLabel) {
                mv.visitLabel(labelForInvalidTypes);
                mv.visitFrame(3, 0, null, 0, null);
                insertThrowExceptionForFieldType(mv, primitiveType.getClassName());
            }
            mv.visitLabel(defaultLabel);
            mv.visitFrame(3, 0, null, 0, null);
        }
        MethodVisitor mv2 = insertThrowExceptionForFieldNotFound(mv);
        mv2.visitMaxs(maxStack, maxLocals);
        mv2.visitEnd();
    }

    private static void insertGetPrimitive(ClassWriter cw, String classNameInternal, ArrayList<Field> fields, Type primitiveType) {
        int returnValueInstruction;
        String getterMethodName;
        int maxStack = 6;
        String typeNameInternal = primitiveType.getDescriptor();
        switch (primitiveType.getSort()) {
            case 1:
                getterMethodName = "getBoolean";
                returnValueInstruction = 172;
                break;
            case 2:
                getterMethodName = "getChar";
                returnValueInstruction = 172;
                break;
            case 3:
                getterMethodName = "getByte";
                returnValueInstruction = 172;
                break;
            case 4:
                getterMethodName = "getShort";
                returnValueInstruction = 172;
                break;
            case 5:
                getterMethodName = "getInt";
                returnValueInstruction = 172;
                break;
            case 6:
                getterMethodName = "getFloat";
                returnValueInstruction = 174;
                break;
            case 7:
                getterMethodName = "getLong";
                returnValueInstruction = 173;
                break;
            case 8:
                getterMethodName = "getDouble";
                returnValueInstruction = 175;
                break;
            default:
                getterMethodName = BeanUtil.PREFIX_GETTER_GET;
                returnValueInstruction = 176;
                break;
        }
        MethodVisitor mv = cw.visitMethod(1, getterMethodName, "(Ljava/lang/Object;I)" + typeNameInternal, null, null);
        mv.visitCode();
        mv.visitVarInsn(21, 2);
        if (!fields.isEmpty()) {
            maxStack = 6 - 1;
            Label[] labels = new Label[fields.size()];
            Label labelForInvalidTypes = new Label();
            boolean hasAnyBadTypeLabel = false;
            int n = labels.length;
            for (int i = 0; i < n; i++) {
                if (Type.getType(fields.get(i).getType()).equals(primitiveType)) {
                    labels[i] = new Label();
                } else {
                    labels[i] = labelForInvalidTypes;
                    hasAnyBadTypeLabel = true;
                }
            }
            Label defaultLabel = new Label();
            mv.visitTableSwitchInsn(0, labels.length - 1, defaultLabel, labels);
            int n2 = labels.length;
            for (int i2 = 0; i2 < n2; i2++) {
                Field field = fields.get(i2);
                if (!labels[i2].equals(labelForInvalidTypes)) {
                    mv.visitLabel(labels[i2]);
                    mv.visitFrame(3, 0, null, 0, null);
                    mv.visitVarInsn(25, 1);
                    mv.visitTypeInsn(192, classNameInternal);
                    mv.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), typeNameInternal);
                    mv.visitInsn(returnValueInstruction);
                }
            }
            if (hasAnyBadTypeLabel) {
                mv.visitLabel(labelForInvalidTypes);
                mv.visitFrame(3, 0, null, 0, null);
                insertThrowExceptionForFieldType(mv, primitiveType.getClassName());
            }
            mv.visitLabel(defaultLabel);
            mv.visitFrame(3, 0, null, 0, null);
        }
        MethodVisitor mv2 = insertThrowExceptionForFieldNotFound(mv);
        mv2.visitMaxs(maxStack, 3);
        mv2.visitEnd();
    }

    private static MethodVisitor insertThrowExceptionForFieldNotFound(MethodVisitor mv) {
        mv.visitTypeInsn(187, "java/lang/IllegalArgumentException");
        mv.visitInsn(89);
        mv.visitTypeInsn(187, "java/lang/StringBuilder");
        mv.visitInsn(89);
        mv.visitLdcInsn("Field not found: ");
        mv.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        mv.visitVarInsn(21, 2);
        mv.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        mv.visitMethodInsn(182, "java/lang/StringBuilder", Printer.TO_STRING, "()Ljava/lang/String;");
        mv.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        mv.visitInsn(191);
        return mv;
    }

    private static MethodVisitor insertThrowExceptionForFieldType(MethodVisitor mv, String fieldType) {
        mv.visitTypeInsn(187, "java/lang/IllegalArgumentException");
        mv.visitInsn(89);
        mv.visitTypeInsn(187, "java/lang/StringBuilder");
        mv.visitInsn(89);
        mv.visitLdcInsn("Field not declared as " + fieldType + ": ");
        mv.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        mv.visitVarInsn(21, 2);
        mv.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        mv.visitMethodInsn(182, "java/lang/StringBuilder", Printer.TO_STRING, "()Ljava/lang/String;");
        mv.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        mv.visitInsn(191);
        return mv;
    }
}
