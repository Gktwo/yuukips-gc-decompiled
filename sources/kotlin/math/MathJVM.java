package kotlin.math;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\"\n��\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b7\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\b\u001a\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0019\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010#\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010%\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010&\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0019\u0010'\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\b\u001a\u0019\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\b\u001a\u0011\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0018\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0007\u001a\u0018\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0007\u001a\u0011\u0010,\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010,\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010-\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0019\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\b\u001a\u0019\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\b\u001a\u0019\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\b\u001a\u0019\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\b\u001a\u0019\u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\b\u001a\u0019\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\b\u001a\u0019\u00101\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\b\u001a\u0019\u00101\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\b\u001a\u0011\u00102\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00102\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00104\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00105\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00106\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00106\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00107\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u00108\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u00108\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0015\u00109\u001a\u00020\u0001*\u00020\u00012\u0006\u0010:\u001a\u00020\u0001H\b\u001a\u0015\u00109\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\b\u001a\r\u0010;\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010;\u001a\u00020\u0006*\u00020\u0006H\b\u001a\u0015\u0010<\u001a\u00020\u0001*\u00020\u00012\u0006\u0010=\u001a\u00020\u0001H\b\u001a\u0015\u0010<\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u0006H\b\u001a\r\u0010>\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010>\u001a\u00020\u0006*\u00020\u0006H\b\u001a\u0015\u0010?\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0015\u0010?\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\b\u001a\u0015\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0015\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\b\u001a\f\u0010@\u001a\u00020\t*\u00020\u0001H\u0007\u001a\f\u0010@\u001a\u00020\t*\u00020\u0006H\u0007\u001a\f\u0010A\u001a\u00020\f*\u00020\u0001H\u0007\u001a\f\u0010A\u001a\u00020\f*\u00020\u0006H\u0007\u001a\u0015\u0010B\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\b\u001a\u0015\u0010B\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\tH\b\u001a\u0015\u0010B\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\b\u001a\u0015\u0010B\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\b\"\u001f\u0010��\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010��\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0007\u001a\u0004\b\u0004\u0010\b\"\u001f\u0010��\u001a\u00020\t*\u00020\t8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u000b\"\u001f\u0010��\u001a\u00020\f*\u00020\f8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u001f\u0010\u000f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"\u001f\u0010\u000f\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\f8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\"\u001f\u0010\u0013\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\b¨\u0006C"}, m373d2 = {"absoluteValue", "", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "getSign$annotations", "getSign", "(J)I", "ulp", "getUlp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, m368xs = "kotlin/math/MathKt")
/* renamed from: kotlin.math.MathKt__MathJVMKt */
/* loaded from: grasscutter.jar:kotlin/math/MathKt__MathJVMKt.class */
class MathJVM extends MathH {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double d) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(double d) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(double d) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float f) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(float f) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(float f) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int i) {
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(int i) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long j) {
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(long j) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sin(double x) {
        return Math.sin(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cos(double x) {
        return Math.cos(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tan(double x) {
        return Math.tan(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double asin(double x) {
        return Math.asin(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double acos(double x) {
        return Math.acos(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan(double x) {
        return Math.atan(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan2(double y, double x) {
        return Math.atan2(y, x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sinh(double x) {
        return Math.sinh(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cosh(double x) {
        return Math.cosh(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tanh(double x) {
        return Math.tanh(x);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: double */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [double] */
    @SinceKotlin(version = "1.2")
    public static final double asinh(double x) {
        if (x >= Constants.taylor_n_bound) {
            if (x <= Constants.upper_taylor_n_bound) {
                return Math.log(x + Math.sqrt((x * x) + ((double) 1)));
            }
            if (x > Constants.upper_taylor_2_bound) {
                return Math.log(x) + Constants.LN2;
            }
            return Math.log((x * ((double) 2)) + (((double) 1) / (x * ((double) 2))));
        } else if (x <= (-Constants.taylor_n_bound)) {
            return -MathKt.asinh(-x);
        } else {
            char c = x;
            if (Math.abs(x) >= Constants.taylor_2_bound) {
                c -= ((x * x) * x) / ((double) 6);
            }
            return c;
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [double] */
    /* JADX WARN: Type inference failed for: r0v17, types: [double] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.2")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final double acosh(double r7) {
        /*
            r0 = r7
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x000d
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x0066
        L_0x000d:
            r0 = r7
            double r1 = kotlin.math.Constants.upper_taylor_2_bound
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0020
            r0 = r7
            double r0 = java.lang.Math.log(r0)
            double r1 = kotlin.math.Constants.LN2
            double r0 = r0 + r1
            goto L_0x0066
        L_0x0020:
            r0 = r7
            r1 = 1
            double r1 = (double) r1
            double r0 = r0 - r1
            double r1 = kotlin.math.Constants.taylor_n_bound
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x003c
            r0 = r7
            r1 = r7
            r2 = r7
            double r1 = r1 * r2
            r2 = 1
            double r2 = (double) r2
            double r1 = r1 - r2
            double r1 = java.lang.Math.sqrt(r1)
            double r0 = r0 + r1
            double r0 = java.lang.Math.log(r0)
            goto L_0x0066
        L_0x003c:
            r0 = r7
            r1 = 1
            double r1 = (double) r1
            double r0 = r0 - r1
            double r0 = java.lang.Math.sqrt(r0)
            r9 = r0
            r0 = r9
            r11 = r0
            r0 = r9
            double r1 = kotlin.math.Constants.taylor_2_bound
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x005d
            r0 = r11
            r1 = r9
            r2 = r9
            double r1 = r1 * r2
            r2 = r9
            double r1 = r1 * r2
            r2 = 12
            double r2 = (double) r2
            double r1 = r1 / r2
            double r0 = r0 - r1
            r11 = r0
        L_0x005d:
            r0 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = java.lang.Math.sqrt(r0)
            r1 = r11
            double r0 = r0 * r1
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.math.MathJVM.acosh(double):double");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: double */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [double] */
    @SinceKotlin(version = "1.2")
    public static final double atanh(double x) {
        if (Math.abs(x) >= Constants.taylor_n_bound) {
            return Math.log((((double) 1) + x) / (((double) 1) - x)) / ((double) 2);
        }
        char c = x;
        if (Math.abs(x) > Constants.taylor_2_bound) {
            c += ((x * x) * x) / ((double) 3);
        }
        return c;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double hypot(double x, double y) {
        return Math.hypot(x, y);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sqrt(double x) {
        return Math.sqrt(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double exp(double x) {
        return Math.exp(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double expm1(double x) {
        return Math.expm1(x);
    }

    @SinceKotlin(version = "1.2")
    public static final double log(double x, double base) {
        if (base <= 0.0d) {
            return Double.NaN;
        }
        if (base == 1.0d) {
            return Double.NaN;
        }
        return Math.log(x) / Math.log(base);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: ln */
    private static final double m354ln(double x) {
        return Math.log(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double log10(double x) {
        return Math.log10(x);
    }

    @SinceKotlin(version = "1.2")
    public static final double log2(double x) {
        return Math.log(x) / Constants.LN2;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln1p(double x) {
        return Math.log1p(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ceil(double x) {
        return Math.ceil(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double floor(double x) {
        return Math.floor(x);
    }

    @SinceKotlin(version = "1.2")
    public static final double truncate(double x) {
        return (Double.isNaN(x) || Double.isInfinite(x)) ? x : x > 0.0d ? Math.floor(x) : Math.ceil(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double round(double x) {
        return Math.rint(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double abs(double x) {
        return Math.abs(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sign(double x) {
        return Math.signum(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double min(double a, double b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double max(double a, double b) {
        return Math.max(a, b);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double $this$pow, double x) {
        return Math.pow($this$pow, x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double $this$pow, int n) {
        return Math.pow($this$pow, (double) n);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double IEEErem(double $this$IEEErem, double divisor) {
        return Math.IEEEremainder($this$IEEErem, divisor);
    }

    private static final double getAbsoluteValue(double $this$absoluteValue) {
        return Math.abs($this$absoluteValue);
    }

    private static final double getSign(double $this$sign) {
        return Math.signum($this$sign);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double $this$withSign, double sign) {
        return Math.copySign($this$withSign, sign);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double $this$withSign, int sign) {
        return Math.copySign($this$withSign, (double) sign);
    }

    private static final double getUlp(double $this$ulp) {
        return Math.ulp($this$ulp);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextUp(double $this$nextUp) {
        return Math.nextUp($this$nextUp);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextDown(double $this$nextDown) {
        return Math.nextAfter($this$nextDown, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextTowards(double $this$nextTowards, double to) {
        return Math.nextAfter($this$nextTowards, to);
    }

    @SinceKotlin(version = "1.2")
    public static final int roundToInt(double $this$roundToInt) {
        if (Double.isNaN($this$roundToInt)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if ($this$roundToInt > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        } else {
            if ($this$roundToInt < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round($this$roundToInt);
        }
    }

    @SinceKotlin(version = "1.2")
    public static final long roundToLong(double $this$roundToLong) {
        if (!Double.isNaN($this$roundToLong)) {
            return Math.round($this$roundToLong);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sin(float x) {
        return (float) Math.sin((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cos(float x) {
        return (float) Math.cos((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tan(float x) {
        return (float) Math.tan((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asin(float x) {
        return (float) Math.asin((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acos(float x) {
        return (float) Math.acos((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan(float x) {
        return (float) Math.atan((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan2(float y, float x) {
        return (float) Math.atan2((double) y, (double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sinh(float x) {
        return (float) Math.sinh((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cosh(float x) {
        return (float) Math.cosh((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tanh(float x) {
        return (float) Math.tanh((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asinh(float x) {
        return (float) MathKt.asinh((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acosh(float x) {
        return (float) MathKt.acosh((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atanh(float x) {
        return (float) MathKt.atanh((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float hypot(float x, float y) {
        return (float) Math.hypot((double) x, (double) y);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sqrt(float x) {
        return (float) Math.sqrt((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float exp(float x) {
        return (float) Math.exp((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float expm1(float x) {
        return (float) Math.expm1((double) x);
    }

    @SinceKotlin(version = "1.2")
    public static final float log(float x, float base) {
        if (base <= 0.0f) {
            return Float.NaN;
        }
        if (base == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log((double) x) / Math.log((double) base));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: ln */
    private static final float m353ln(float x) {
        return (float) Math.log((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float log10(float x) {
        return (float) Math.log10((double) x);
    }

    @SinceKotlin(version = "1.2")
    public static final float log2(float x) {
        return (float) (Math.log((double) x) / Constants.LN2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln1p(float x) {
        return (float) Math.log1p((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ceil(float x) {
        return (float) Math.ceil((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float floor(float x) {
        return (float) Math.floor((double) x);
    }

    @SinceKotlin(version = "1.2")
    public static final float truncate(float x) {
        return (Float.isNaN(x) || Float.isInfinite(x)) ? x : x > 0.0f ? (float) Math.floor((double) x) : (float) Math.ceil((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float round(float x) {
        return (float) Math.rint((double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float abs(float x) {
        return Math.abs(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sign(float x) {
        return Math.signum(x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float min(float a, float b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float max(float a, float b) {
        return Math.max(a, b);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float $this$pow, float x) {
        return (float) Math.pow((double) $this$pow, (double) x);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float $this$pow, int n) {
        return (float) Math.pow((double) $this$pow, (double) n);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float IEEErem(float $this$IEEErem, float divisor) {
        return (float) Math.IEEEremainder((double) $this$IEEErem, (double) divisor);
    }

    private static final float getAbsoluteValue(float $this$absoluteValue) {
        return Math.abs($this$absoluteValue);
    }

    private static final float getSign(float $this$sign) {
        return Math.signum($this$sign);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float $this$withSign, float sign) {
        return Math.copySign($this$withSign, sign);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float $this$withSign, int sign) {
        return Math.copySign($this$withSign, (float) sign);
    }

    private static final float getUlp(float $this$ulp) {
        return Math.ulp($this$ulp);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextUp(float $this$nextUp) {
        return Math.nextUp($this$nextUp);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextDown(float $this$nextDown) {
        return Math.nextAfter($this$nextDown, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextTowards(float $this$nextTowards, float to) {
        return Math.nextAfter($this$nextTowards, (double) to);
    }

    @SinceKotlin(version = "1.2")
    public static final int roundToInt(float $this$roundToInt) {
        if (!Float.isNaN($this$roundToInt)) {
            return Math.round($this$roundToInt);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @SinceKotlin(version = "1.2")
    public static final long roundToLong(float $this$roundToLong) {
        return MathKt.roundToLong((double) $this$roundToLong);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int abs(int n) {
        return Math.abs(n);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int min(int a, int b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int max(int a, int b) {
        return Math.max(a, b);
    }

    private static final int getAbsoluteValue(int $this$absoluteValue) {
        return Math.abs($this$absoluteValue);
    }

    public static final int getSign(int $this$sign) {
        if ($this$sign < 0) {
            return -1;
        }
        return $this$sign > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long abs(long n) {
        return Math.abs(n);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long min(long a, long b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long max(long a, long b) {
        return Math.max(a, b);
    }

    private static final long getAbsoluteValue(long $this$absoluteValue) {
        return Math.abs($this$absoluteValue);
    }

    public static final int getSign(long $this$sign) {
        if ($this$sign < 0) {
            return -1;
        }
        return $this$sign > 0 ? 1 : 0;
    }
}
