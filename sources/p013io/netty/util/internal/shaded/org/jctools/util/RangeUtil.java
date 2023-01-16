package p013io.netty.util.internal.shaded.org.jctools.util;

/* renamed from: io.netty.util.internal.shaded.org.jctools.util.RangeUtil */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/util/RangeUtil.class */
public final class RangeUtil {
    public static long checkPositive(long n, String name) {
        if (n > 0) {
            return n;
        }
        throw new IllegalArgumentException(name + ": " + n + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int n, String name) {
        if (n >= 0) {
            return n;
        }
        throw new IllegalArgumentException(name + ": " + n + " (expected: >= 0)");
    }

    public static int checkLessThan(int n, int expected, String name) {
        if (n < expected) {
            return n;
        }
        throw new IllegalArgumentException(name + ": " + n + " (expected: < " + expected + ')');
    }

    public static int checkLessThanOrEqual(int n, long expected, String name) {
        if (((long) n) <= expected) {
            return n;
        }
        throw new IllegalArgumentException(name + ": " + n + " (expected: <= " + expected + ')');
    }

    public static int checkGreaterThanOrEqual(int n, int expected, String name) {
        if (n >= expected) {
            return n;
        }
        throw new IllegalArgumentException(name + ": " + n + " (expected: >= " + expected + ')');
    }
}
