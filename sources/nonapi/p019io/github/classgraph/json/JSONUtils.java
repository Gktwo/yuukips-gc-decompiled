package nonapi.p019io.github.classgraph.json;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: nonapi.io.github.classgraph.json.JSONUtils */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/JSONUtils.class */
public final class JSONUtils {
    static final String ID_KEY = "__ID";
    static final String ID_PREFIX = "[#";
    static final String ID_SUFFIX = "]";
    private static final String[] JSON_CHAR_REPLACEMENTS = new String[256];
    private static MethodHandle isAccessibleMethodHandle;
    private static Method isAccessibleMethod;
    private static MethodHandle trySetAccessibleMethodHandle;
    private static Method trySetAccessibleMethod;
    private static final String[] INDENT_LEVELS;

    static {
        isAccessibleMethodHandle = null;
        isAccessibleMethod = null;
        trySetAccessibleMethodHandle = null;
        trySetAccessibleMethod = null;
        int c = 0;
        while (c < 256) {
            if (c == 32) {
                c = 127;
            }
            int nibble1 = c >> 4;
            char hexDigit1 = nibble1 <= 9 ? (char) (48 + nibble1) : (char) ((65 + nibble1) - 10);
            int nibble0 = c & 15;
            JSON_CHAR_REPLACEMENTS[c] = "\\u00" + Character.toString(hexDigit1) + Character.toString((char) (nibble0 <= 9 ? 48 + nibble0 : (65 + nibble0) - 10));
            c++;
        }
        JSON_CHAR_REPLACEMENTS[34] = "\\\"";
        JSON_CHAR_REPLACEMENTS[92] = "\\\\";
        JSON_CHAR_REPLACEMENTS[10] = "\\n";
        JSON_CHAR_REPLACEMENTS[13] = "\\r";
        JSON_CHAR_REPLACEMENTS[9] = "\\t";
        JSON_CHAR_REPLACEMENTS[8] = "\\b";
        JSON_CHAR_REPLACEMENTS[12] = "\\f";
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            isAccessibleMethodHandle = lookup.findVirtual(AccessibleObject.class, "isAccessible", MethodType.methodType(Boolean.TYPE));
        } catch (IllegalAccessException | NoSuchMethodException e) {
        }
        try {
            isAccessibleMethod = AccessibleObject.class.getDeclaredMethod("isAccessible", Object.class);
        } catch (NoSuchMethodException | SecurityException e2) {
        }
        try {
            trySetAccessibleMethodHandle = lookup.findVirtual(AccessibleObject.class, "trySetAccessible", MethodType.methodType(Boolean.TYPE));
        } catch (IllegalAccessException | NoSuchMethodException e3) {
        }
        try {
            trySetAccessibleMethod = AccessibleObject.class.getDeclaredMethod("trySetAccessible", new Class[0]);
        } catch (NoSuchMethodException | SecurityException e4) {
        }
        INDENT_LEVELS = new String[17];
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < INDENT_LEVELS.length; i++) {
            INDENT_LEVELS[i] = buf.toString();
            buf.append(' ');
        }
    }

    private JSONUtils() {
    }

    /* access modifiers changed from: package-private */
    public static void escapeJSONString(String unsafeStr, StringBuilder buf) {
        if (unsafeStr != null) {
            boolean needsEscaping = false;
            int n = unsafeStr.length();
            for (int i = 0; i < n; i++) {
                char c = unsafeStr.charAt(i);
                if (c > 255 || JSON_CHAR_REPLACEMENTS[c] != null) {
                    needsEscaping = true;
                    break;
                }
            }
            if (!needsEscaping) {
                buf.append(unsafeStr);
                return;
            }
            int n2 = unsafeStr.length();
            for (int i2 = 0; i2 < n2; i2++) {
                char c2 = unsafeStr.charAt(i2);
                if (c2 > 255) {
                    buf.append("\\u");
                    int nibble3 = (c2 & 61440) >> 12;
                    buf.append(nibble3 <= 9 ? (char) (48 + nibble3) : (char) ((65 + nibble3) - 10));
                    int nibble2 = (c2 & 3840) >> 8;
                    buf.append(nibble2 <= 9 ? (char) (48 + nibble2) : (char) ((65 + nibble2) - 10));
                    int nibble1 = (c2 & 240) >> 4;
                    buf.append(nibble1 <= 9 ? (char) (48 + nibble1) : (char) ((65 + nibble1) - 10));
                    int nibble0 = c2 & 15;
                    buf.append(nibble0 <= 9 ? (char) (48 + nibble0) : (char) ((65 + nibble0) - 10));
                } else {
                    String replacement = JSON_CHAR_REPLACEMENTS[c2];
                    if (replacement == null) {
                        buf.append(c2);
                    } else {
                        buf.append(replacement);
                    }
                }
            }
        }
    }

    public static String escapeJSONString(String unsafeStr) {
        StringBuilder buf = new StringBuilder(unsafeStr.length() * 2);
        escapeJSONString(unsafeStr, buf);
        return buf.toString();
    }

    /* access modifiers changed from: package-private */
    public static void indent(int depth, int indentWidth, StringBuilder buf) {
        int maxIndent = INDENT_LEVELS.length - 1;
        int d = depth * indentWidth;
        while (d > 0) {
            int n = Math.min(d, maxIndent);
            buf.append(INDENT_LEVELS[n]);
            d -= n;
        }
    }

    /* access modifiers changed from: package-private */
    public static Object getFieldValue(Object containingObj, Field field) throws IllegalArgumentException, IllegalAccessException {
        Class<?> fieldType = field.getType();
        if (fieldType == Integer.TYPE) {
            return Integer.valueOf(field.getInt(containingObj));
        }
        if (fieldType == Long.TYPE) {
            return Long.valueOf(field.getLong(containingObj));
        }
        if (fieldType == Short.TYPE) {
            return Short.valueOf(field.getShort(containingObj));
        }
        if (fieldType == Double.TYPE) {
            return Double.valueOf(field.getDouble(containingObj));
        }
        if (fieldType == Float.TYPE) {
            return Float.valueOf(field.getFloat(containingObj));
        }
        if (fieldType == Boolean.TYPE) {
            return Boolean.valueOf(field.getBoolean(containingObj));
        }
        if (fieldType == Byte.TYPE) {
            return Byte.valueOf(field.getByte(containingObj));
        }
        if (fieldType == Character.TYPE) {
            return Character.valueOf(field.getChar(containingObj));
        }
        if (fieldType == Class.class) {
            return field.get(containingObj);
        }
        return field.get(containingObj);
    }

    /* access modifiers changed from: package-private */
    public static boolean isBasicValueType(Class<?> cls) {
        return cls == String.class || cls == Integer.class || cls == Integer.TYPE || cls == Long.class || cls == Long.TYPE || cls == Short.class || cls == Short.TYPE || cls == Float.class || cls == Float.TYPE || cls == Double.class || cls == Double.TYPE || cls == Byte.class || cls == Byte.TYPE || cls == Character.class || cls == Character.TYPE || cls == Boolean.class || cls == Boolean.TYPE || cls.isEnum() || cls == Class.class;
    }

    /* access modifiers changed from: package-private */
    public static boolean isBasicValueType(Type type) {
        if (type instanceof Class) {
            return isBasicValueType((Class<?>) ((Class) type));
        }
        if (type instanceof ParameterizedType) {
            return isBasicValueType(((ParameterizedType) type).getRawType());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public static boolean isBasicValueType(Object obj) {
        return obj == null || (obj instanceof String) || (obj instanceof Integer) || (obj instanceof Boolean) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short) || (obj instanceof Byte) || (obj instanceof Character) || obj.getClass().isEnum() || (obj instanceof Class);
    }

    /* access modifiers changed from: package-private */
    public static boolean isCollectionOrArray(Object obj) {
        Class<?> cls = obj.getClass();
        return Collection.class.isAssignableFrom(cls) || cls.isArray();
    }

    /* access modifiers changed from: package-private */
    public static Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        throw new IllegalArgumentException("Illegal type: " + type);
    }

    /* access modifiers changed from: package-private */
    public static boolean isAccessibleOrMakeAccessible(final AccessibleObject fieldOrConstructor) {
        final AtomicBoolean accessible = new AtomicBoolean(false);
        if (!accessible.get()) {
            if (isAccessibleMethodHandle != null) {
                try {
                    accessible.set(((Boolean) isAccessibleMethodHandle.invoke(fieldOrConstructor)).booleanValue());
                } catch (Throwable th) {
                }
            } else if (isAccessibleMethod != null) {
                try {
                    accessible.set(((Boolean) isAccessibleMethod.invoke(fieldOrConstructor, new Object[0])).booleanValue());
                } catch (Throwable th2) {
                }
            }
        }
        if (!accessible.get()) {
            if (trySetAccessibleMethodHandle != null) {
                try {
                    accessible.set(((Boolean) trySetAccessibleMethodHandle.invoke(fieldOrConstructor)).booleanValue());
                } catch (Throwable th3) {
                }
            } else if (trySetAccessibleMethod != null) {
                try {
                    accessible.set(((Boolean) trySetAccessibleMethod.invoke(fieldOrConstructor, new Object[0])).booleanValue());
                } catch (Throwable th4) {
                }
            }
            if (!accessible.get()) {
                try {
                    fieldOrConstructor.setAccessible(true);
                    accessible.set(true);
                } catch (Throwable th5) {
                }
            }
            if (!accessible.get()) {
                AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: nonapi.io.github.classgraph.json.JSONUtils.1
                    @Override // java.security.PrivilegedAction
                    public Void run() {
                        if (JSONUtils.trySetAccessibleMethodHandle != null) {
                            try {
                                accessible.set(((Boolean) JSONUtils.trySetAccessibleMethodHandle.invoke(fieldOrConstructor)).booleanValue());
                            } catch (Throwable th6) {
                            }
                        } else if (JSONUtils.trySetAccessibleMethod != null) {
                            try {
                                accessible.set(((Boolean) JSONUtils.trySetAccessibleMethod.invoke(fieldOrConstructor, new Object[0])).booleanValue());
                            } catch (Throwable th7) {
                            }
                        }
                        if (accessible.get()) {
                            return null;
                        }
                        try {
                            fieldOrConstructor.setAccessible(true);
                            accessible.set(true);
                            return null;
                        } catch (Throwable th8) {
                            return null;
                        }
                    }
                });
            }
        }
        return accessible.get();
    }

    /* access modifiers changed from: package-private */
    public static boolean fieldIsSerializable(Field field, boolean onlySerializePublicFields) {
        int modifiers = field.getModifiers();
        if ((!onlySerializePublicFields || Modifier.isPublic(modifiers)) && !Modifier.isTransient(modifiers) && !Modifier.isFinal(modifiers) && (modifiers & 4096) == 0) {
            return isAccessibleOrMakeAccessible(field);
        }
        return false;
    }
}
