package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n��\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010��\u001a\u0002H\u0001\"\u000e\b��\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010��\u001a\u0002H\u0001\"\u000e\b��\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010��\u001a\u0002H\u0001\"\u000e\b��\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010��\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\b\u001a!\u0010��\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\b\u001a\u001c\u0010��\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010��\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\b\u001a!\u0010��\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\b\u001a\u001c\u0010��\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010��\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\b\u001a!\u0010��\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\b\u001a\u001c\u0010��\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010��\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\b\u001a!\u0010��\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\b\u001a\u001c\u0010��\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010��\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\b\u001a!\u0010��\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\b\u001a\u001c\u0010��\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010��\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\b\u001a!\u0010��\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\b\u001a\u001c\u0010��\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b��\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b��\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b��\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018"}, m373d2 = {"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, m368xs = "kotlin/comparisons/ComparisonsKt")
/* renamed from: kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt */
/* loaded from: grasscutter.jar:kotlin/comparisons/ComparisonsKt___ComparisonsJvmKt.class */
public class _ComparisonsJvm extends Comparisons {
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte a, byte b) {
        return (byte) Math.max((int) a, (int) b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short a, short b) {
        return (short) Math.max((int) a, (int) b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int a, int b) {
        return Math.max(a, b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long a, long b) {
        return Math.max(a, b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float a, float b) {
        return Math.max(a, b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double a, double b) {
        return Math.max(a, b);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T t2, @NotNull T t3) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(t2, "b");
        Intrinsics.checkNotNullParameter(t3, "c");
        return (T) ComparisonsKt.maxOf(t, ComparisonsKt.maxOf(t2, t3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte a, byte b, byte c) {
        return (byte) Math.max((int) a, Math.max((int) b, (int) c));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short a, short b, short c) {
        return (short) Math.max((int) a, Math.max((int) b, (int) c));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long a, long b, long c) {
        return Math.max(a, Math.max(b, c));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float a, float b, float c) {
        return Math.max(a, Math.max(b, c));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(tArr, "other");
        Comparable max = t;
        for (T t2 : tArr) {
            max = (T) ComparisonsKt.maxOf(max, t2);
        }
        return (T) max;
    }

    @SinceKotlin(version = "1.4")
    public static final byte maxOf(byte a, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte max = a;
        for (byte e : other) {
            max = (byte) Math.max((int) max, (int) e);
        }
        return max;
    }

    @SinceKotlin(version = "1.4")
    public static final short maxOf(short a, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short max = a;
        for (short e : other) {
            max = (short) Math.max((int) max, (int) e);
        }
        return max;
    }

    @SinceKotlin(version = "1.4")
    public static final int maxOf(int a, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int max = a;
        for (int e : other) {
            max = Math.max(max, e);
        }
        return max;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    @SinceKotlin(version = "1.4")
    public static final long maxOf(long a, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        char c = a;
        for (long e : other) {
            c = Math.max((long) c, e);
        }
        return c;
    }

    @SinceKotlin(version = "1.4")
    public static final float maxOf(float a, @NotNull float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        float max = a;
        for (float e : other) {
            max = Math.max(max, e);
        }
        return max;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: double */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [double] */
    @SinceKotlin(version = "1.4")
    public static final double maxOf(double a, @NotNull double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        char c = a;
        for (double e : other) {
            c = Math.max(c, e);
        }
        return c;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(t2, "b");
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte a, byte b) {
        return (byte) Math.min((int) a, (int) b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short a, short b) {
        return (short) Math.min((int) a, (int) b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int a, int b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long a, long b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float a, float b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double a, double b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T t2, @NotNull T t3) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(t2, "b");
        Intrinsics.checkNotNullParameter(t3, "c");
        return (T) ComparisonsKt.minOf(t, ComparisonsKt.minOf(t2, t3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte a, byte b, byte c) {
        return (byte) Math.min((int) a, Math.min((int) b, (int) c));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short a, short b, short c) {
        return (short) Math.min((int) a, Math.min((int) b, (int) c));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long a, long b, long c) {
        return Math.min(a, Math.min(b, c));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float a, float b, float c) {
        return Math.min(a, Math.min(b, c));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(t, "a");
        Intrinsics.checkNotNullParameter(tArr, "other");
        Comparable min = t;
        for (T t2 : tArr) {
            min = (T) ComparisonsKt.minOf(min, t2);
        }
        return (T) min;
    }

    @SinceKotlin(version = "1.4")
    public static final byte minOf(byte a, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte min = a;
        for (byte e : other) {
            min = (byte) Math.min((int) min, (int) e);
        }
        return min;
    }

    @SinceKotlin(version = "1.4")
    public static final short minOf(short a, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short min = a;
        for (short e : other) {
            min = (short) Math.min((int) min, (int) e);
        }
        return min;
    }

    @SinceKotlin(version = "1.4")
    public static final int minOf(int a, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int min = a;
        for (int e : other) {
            min = Math.min(min, e);
        }
        return min;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    @SinceKotlin(version = "1.4")
    public static final long minOf(long a, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        char c = a;
        for (long e : other) {
            c = Math.min((long) c, e);
        }
        return c;
    }

    @SinceKotlin(version = "1.4")
    public static final float minOf(float a, @NotNull float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        float min = a;
        for (float e : other) {
            min = Math.min(min, e);
        }
        return min;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: double */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [double] */
    @SinceKotlin(version = "1.4")
    public static final double minOf(double a, @NotNull double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        char c = a;
        for (double e : other) {
            c = Math.min(c, e);
        }
        return c;
    }
}
