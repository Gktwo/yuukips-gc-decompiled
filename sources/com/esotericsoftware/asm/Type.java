package com.esotericsoftware.asm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.HttpUrl;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/Type.class */
public class Type {
    public static final int VOID = 0;
    public static final int BOOLEAN = 1;
    public static final int CHAR = 2;
    public static final int BYTE = 3;
    public static final int SHORT = 4;
    public static final int INT = 5;
    public static final int FLOAT = 6;
    public static final int LONG = 7;
    public static final int DOUBLE = 8;
    public static final int ARRAY = 9;
    public static final int OBJECT = 10;
    public static final int METHOD = 11;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

    /* renamed from: a */
    private final int f207a;

    /* renamed from: b */
    private final char[] f208b;

    /* renamed from: c */
    private final int f209c;

    /* renamed from: d */
    private final int f210d;

    private Type(int i, char[] cArr, int i2, int i3) {
        this.f207a = i;
        this.f208b = cArr;
        this.f209c = i2;
        this.f210d = i3;
    }

    public static Type getType(String str) {
        return m1481a(str.toCharArray(), 0);
    }

    public static Type getObjectType(String str) {
        char[] charArray = str.toCharArray();
        return new Type(charArray[0] == '[' ? 9 : 10, charArray, 0, charArray.length);
    }

    public static Type getMethodType(String str) {
        return m1481a(str.toCharArray(), 0);
    }

    public static Type getMethodType(Type type, Type... typeArr) {
        return getType(getMethodDescriptor(type, typeArr));
    }

    public static Type getType(Class cls) {
        return cls.isPrimitive() ? cls == Integer.TYPE ? INT_TYPE : cls == Void.TYPE ? VOID_TYPE : cls == Boolean.TYPE ? BOOLEAN_TYPE : cls == Byte.TYPE ? BYTE_TYPE : cls == Character.TYPE ? CHAR_TYPE : cls == Short.TYPE ? SHORT_TYPE : cls == Double.TYPE ? DOUBLE_TYPE : cls == Float.TYPE ? FLOAT_TYPE : LONG_TYPE : getType(getDescriptor(cls));
    }

    public static Type getType(Constructor constructor) {
        return getType(getConstructorDescriptor(constructor));
    }

    public static Type getType(Method method) {
        return getType(getMethodDescriptor(method));
    }

    public static Type[] getArgumentTypes(String str) {
        char[] charArray = str.toCharArray();
        int i = 1;
        int i2 = 0;
        while (true) {
            i++;
            char c = charArray[i];
            if (c == ')') {
                break;
            } else if (c == 'L') {
                do {
                    i++;
                } while (charArray[i] != ';');
                i2++;
            } else if (c != '[') {
                i2++;
            }
        }
        Type[] typeArr = new Type[i2];
        int i3 = 1;
        int i4 = 0;
        while (charArray[i3] != ')') {
            typeArr[i4] = m1481a(charArray, i3);
            i3 += typeArr[i4].f210d + (typeArr[i4].f207a == 10 ? 2 : 0);
            i4++;
        }
        return typeArr;
    }

    public static Type[] getArgumentTypes(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Type[] typeArr = new Type[parameterTypes.length];
        for (int length = parameterTypes.length - 1; length >= 0; length--) {
            typeArr[length] = getType(parameterTypes[length]);
        }
        return typeArr;
    }

    public static Type getReturnType(String str) {
        return m1481a(str.toCharArray(), str.indexOf(41) + 1);
    }

    public static Type getReturnType(Method method) {
        return getType(method.getReturnType());
    }

    public static int getArgumentsAndReturnSizes(String str) {
        char charAt;
        int i = 1;
        int i2 = 1;
        while (true) {
            i2++;
            char charAt2 = str.charAt(i2);
            if (charAt2 == ')') {
                break;
            } else if (charAt2 == 'L') {
                do {
                    i2++;
                } while (str.charAt(i2) != ';');
                i++;
            } else if (charAt2 == '[') {
                while (true) {
                    charAt = str.charAt(i2);
                    if (charAt != '[') {
                        break;
                    }
                    i2++;
                }
                if (charAt == 'D' || charAt == 'J') {
                    i--;
                }
            } else {
                i = (charAt2 == 'D' || charAt2 == 'J') ? i + 2 : i + 1;
            }
        }
        char charAt3 = str.charAt(i2);
        return (i << 2) | (charAt3 == 'V' ? 0 : (charAt3 == 'D' || charAt3 == 'J') ? 2 : 1);
    }

    /* renamed from: a */
    private static Type m1481a(char[] cArr, int i) {
        switch (cArr[i]) {
            case 'B':
                return BYTE_TYPE;
            case 'C':
                return CHAR_TYPE;
            case 'D':
                return DOUBLE_TYPE;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                return new Type(11, cArr, i, cArr.length - i);
            case 'F':
                return FLOAT_TYPE;
            case 'I':
                return INT_TYPE;
            case 'J':
                return LONG_TYPE;
            case 'L':
                int i2 = 1;
                while (cArr[i + i2] != ';') {
                    i2++;
                }
                return new Type(10, cArr, i + 1, i2 - 1);
            case 'S':
                return SHORT_TYPE;
            case 'V':
                return VOID_TYPE;
            case 'Z':
                return BOOLEAN_TYPE;
            case '[':
                int i3 = 1;
                while (cArr[i + i3] == '[') {
                    i3++;
                }
                if (cArr[i + i3] == 'L') {
                    while (true) {
                        i3++;
                        if (cArr[i + i3] != ';') {
                        }
                    }
                }
                return new Type(9, cArr, i, i3 + 1);
        }
    }

    public int getSort() {
        return this.f207a;
    }

    public int getDimensions() {
        int i = 1;
        while (this.f208b[this.f209c + i] == '[') {
            i++;
        }
        return i;
    }

    public Type getElementType() {
        return m1481a(this.f208b, this.f209c + getDimensions());
    }

    public String getClassName() {
        switch (this.f207a) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuffer stringBuffer = new StringBuffer(getElementType().getClassName());
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    stringBuffer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                }
                return stringBuffer.toString();
            case 10:
                return new String(this.f208b, this.f209c, this.f210d).replace('/', '.');
            default:
                return null;
        }
    }

    public String getInternalName() {
        return new String(this.f208b, this.f209c, this.f210d);
    }

    public Type[] getArgumentTypes() {
        return getArgumentTypes(getDescriptor());
    }

    public Type getReturnType() {
        return getReturnType(getDescriptor());
    }

    public int getArgumentsAndReturnSizes() {
        return getArgumentsAndReturnSizes(getDescriptor());
    }

    public String getDescriptor() {
        StringBuffer stringBuffer = new StringBuffer();
        m1483a(stringBuffer);
        return stringBuffer.toString();
    }

    public static String getMethodDescriptor(Type type, Type... typeArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        for (Type type2 : typeArr) {
            type2.m1483a(stringBuffer);
        }
        stringBuffer.append(')');
        type.m1483a(stringBuffer);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m1483a(StringBuffer stringBuffer) {
        if (this.f208b == null) {
            stringBuffer.append((char) ((this.f209c & -16777216) >>> 24));
        } else if (this.f207a == 10) {
            stringBuffer.append('L');
            stringBuffer.append(this.f208b, this.f209c, this.f210d);
            stringBuffer.append(';');
        } else {
            stringBuffer.append(this.f208b, this.f209c, this.f210d);
        }
    }

    public static String getInternalName(Class cls) {
        return cls.getName().replace('.', '/');
    }

    public static String getDescriptor(Class cls) {
        StringBuffer stringBuffer = new StringBuffer();
        m1482a(stringBuffer, cls);
        return stringBuffer.toString();
    }

    public static String getConstructorDescriptor(Constructor constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        for (Class<?> cls : parameterTypes) {
            m1482a(stringBuffer, cls);
        }
        return stringBuffer.append(")V").toString();
    }

    public static String getMethodDescriptor(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        for (Class<?> cls : parameterTypes) {
            m1482a(stringBuffer, cls);
        }
        stringBuffer.append(')');
        m1482a(stringBuffer, method.getReturnType());
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m1482a(StringBuffer stringBuffer, Class cls) {
        Class cls2 = cls;
        while (!cls2.isPrimitive()) {
            if (cls2.isArray()) {
                stringBuffer.append('[');
                cls2 = cls2.getComponentType();
            } else {
                stringBuffer.append('L');
                String name = cls2.getName();
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    char charAt = name.charAt(i);
                    stringBuffer.append(charAt == '.' ? '/' : charAt);
                }
                stringBuffer.append(';');
                return;
            }
        }
        stringBuffer.append(cls2 == Integer.TYPE ? 'I' : cls2 == Void.TYPE ? 'V' : cls2 == Boolean.TYPE ? 'Z' : cls2 == Byte.TYPE ? 'B' : cls2 == Character.TYPE ? 'C' : cls2 == Short.TYPE ? 'S' : cls2 == Double.TYPE ? 'D' : cls2 == Float.TYPE ? 'F' : 'J');
    }

    public int getSize() {
        if (this.f208b == null) {
            return this.f209c & 255;
        }
        return 1;
    }

    public int getOpcode(int i) {
        if (i == 46 || i == 79) {
            return i + (this.f208b == null ? (this.f209c & 65280) >> 8 : 4);
        }
        return i + (this.f208b == null ? (this.f209c & 16711680) >> 16 : 4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return false;
        }
        Type type = (Type) obj;
        if (this.f207a != type.f207a) {
            return false;
        }
        if (this.f207a < 9) {
            return true;
        }
        if (this.f210d != type.f210d) {
            return false;
        }
        int i = this.f209c;
        int i2 = type.f209c;
        int i3 = i + this.f210d;
        while (i < i3) {
            if (this.f208b[i] != type.f208b[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public int hashCode() {
        int i = 13 * this.f207a;
        if (this.f207a >= 9) {
            int i2 = this.f209c;
            int i3 = i2 + this.f210d;
            while (i2 < i3) {
                i = 17 * (i + this.f208b[i2]);
                i2++;
            }
        }
        return i;
    }

    public String toString() {
        return getDescriptor();
    }

    static {
        _clinit_();
    }

    static void _clinit_() {
    }
}
