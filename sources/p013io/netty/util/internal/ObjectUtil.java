package p013io.netty.util.internal;

import java.util.Collection;
import java.util.Map;

/* renamed from: io.netty.util.internal.ObjectUtil */
/* loaded from: grasscutter.jar:io/netty/util/internal/ObjectUtil.class */
public final class ObjectUtil {
    private static final float FLOAT_ZERO = 0.0f;
    private static final double DOUBLE_ZERO = 0.0d;
    private static final long LONG_ZERO = 0;
    private static final int INT_ZERO = 0;

    private ObjectUtil() {
    }

    public static <T> T checkNotNull(T arg, String text) {
        if (arg != null) {
            return arg;
        }
        throw new NullPointerException(text);
    }

    public static <T> T[] deepCheckNotNull(String text, T... varargs) {
        if (varargs == null) {
            throw new NullPointerException(text);
        }
        for (T element : varargs) {
            if (element == null) {
                throw new NullPointerException(text);
            }
        }
        return varargs;
    }

    public static <T> T checkNotNullWithIAE(T arg, String paramName) throws IllegalArgumentException {
        if (arg != null) {
            return arg;
        }
        throw new IllegalArgumentException("Param '" + paramName + "' must not be null");
    }

    public static <T> T checkNotNullArrayParam(T value, int index, String name) throws IllegalArgumentException {
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException("Array index " + index + " of parameter '" + name + "' must not be null");
    }

    public static int checkPositive(int i, String name) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(name + " : " + i + " (expected: > 0)");
    }

    public static long checkPositive(long l, String name) {
        if (l > 0) {
            return l;
        }
        throw new IllegalArgumentException(name + " : " + l + " (expected: > 0)");
    }

    public static double checkPositive(double d, String name) {
        if (d > DOUBLE_ZERO) {
            return d;
        }
        throw new IllegalArgumentException(name + " : " + d + " (expected: > 0)");
    }

    public static float checkPositive(float f, String name) {
        if (f > FLOAT_ZERO) {
            return f;
        }
        throw new IllegalArgumentException(name + " : " + f + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i, String name) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(name + " : " + i + " (expected: >= 0)");
    }

    public static long checkPositiveOrZero(long l, String name) {
        if (l >= 0) {
            return l;
        }
        throw new IllegalArgumentException(name + " : " + l + " (expected: >= 0)");
    }

    public static double checkPositiveOrZero(double d, String name) {
        if (d >= DOUBLE_ZERO) {
            return d;
        }
        throw new IllegalArgumentException(name + " : " + d + " (expected: >= 0)");
    }

    public static float checkPositiveOrZero(float f, String name) {
        if (f >= FLOAT_ZERO) {
            return f;
        }
        throw new IllegalArgumentException(name + " : " + f + " (expected: >= 0)");
    }

    public static int checkInRange(int i, int start, int end, String name) {
        if (i >= start && i <= end) {
            return i;
        }
        throw new IllegalArgumentException(name + ": " + i + " (expected: " + start + "-" + end + ")");
    }

    public static long checkInRange(long l, long start, long end, String name) {
        if (l >= start && l <= end) {
            return l;
        }
        throw new IllegalArgumentException(name + ": " + l + " (expected: " + start + "-" + end + ")");
    }

    public static <T> T[] checkNonEmpty(T[] array, String name) {
        if (((Object[]) checkNotNull(array, name)).length != 0) {
            return array;
        }
        throw new IllegalArgumentException("Param '" + name + "' must not be empty");
    }

    public static byte[] checkNonEmpty(byte[] array, String name) {
        if (((byte[]) checkNotNull(array, name)).length != 0) {
            return array;
        }
        throw new IllegalArgumentException("Param '" + name + "' must not be empty");
    }

    public static char[] checkNonEmpty(char[] array, String name) {
        if (((char[]) checkNotNull(array, name)).length != 0) {
            return array;
        }
        throw new IllegalArgumentException("Param '" + name + "' must not be empty");
    }

    public static <T extends Collection<?>> T checkNonEmpty(T collection, String name) {
        if (!((Collection) checkNotNull(collection, name)).isEmpty()) {
            return collection;
        }
        throw new IllegalArgumentException("Param '" + name + "' must not be empty");
    }

    public static String checkNonEmpty(String value, String name) {
        if (!((String) checkNotNull(value, name)).isEmpty()) {
            return value;
        }
        throw new IllegalArgumentException("Param '" + name + "' must not be empty");
    }

    public static <K, V, T extends Map<K, V>> T checkNonEmpty(T value, String name) {
        if (!((Map) checkNotNull(value, name)).isEmpty()) {
            return value;
        }
        throw new IllegalArgumentException("Param '" + name + "' must not be empty");
    }

    public static CharSequence checkNonEmpty(CharSequence value, String name) {
        if (((CharSequence) checkNotNull(value, name)).length() != 0) {
            return value;
        }
        throw new IllegalArgumentException("Param '" + name + "' must not be empty");
    }

    public static String checkNonEmptyAfterTrim(String value, String name) {
        return checkNonEmpty(((String) checkNotNull(value, name)).trim(), name);
    }

    public static int intValue(Integer wrapper, int defaultValue) {
        return wrapper != null ? wrapper.intValue() : defaultValue;
    }

    public static long longValue(Long wrapper, long defaultValue) {
        return wrapper != null ? wrapper.longValue() : defaultValue;
    }
}
