package org.jline.utils;

import java.util.Map;
import java.util.stream.Stream;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/Colors.class */
public class Colors {
    public static final int[] DEFAULT_COLORS_256 = {0, 8388608, 32768, 8421376, 128, 8388736, 32896, 12632256, 8421504, 16711680, 65280, 16776960, 255, 16711935, 65535, 16777215, 0, 95, 135, 175, 215, 255, 24320, 24415, 24455, 24495, 24535, 24575, 34560, 34655, 34695, 34735, 34775, 34815, 44800, 44895, 44935, 44975, 45015, 45055, 55040, 55135, 55175, 55215, 55255, 55295, 65280, 65375, 65415, 65455, 65495, 65535, 6225920, 6226015, 6226055, 6226095, 6226135, 6226175, 6250240, 6250335, 6250375, 6250415, 6250455, 6250495, 6260480, 6260575, 6260615, 6260655, 6260695, 6260735, 6270720, 6270815, 6270855, 6270895, 6270935, 6270975, 6280960, 6281055, 6281095, 6281135, 6281175, 6281215, 6291200, 6291295, 6291335, 6291375, 6291415, 6291455, 8847360, 8847455, 8847495, 8847535, 8847575, 8847615, 8871680, 8871775, 8871815, 8871855, 8871895, 8871935, 8881920, 8882015, 8882055, 8882095, 8882135, 8882175, 8892160, 8892255, 8892295, 8892335, 8892375, 8892415, 8902400, 8902495, 8902535, 8902575, 8902615, 8902655, 8912640, 8912735, 8912775, 8912815, 8912855, 8912895, 11468800, 11468895, 11468935, 11468975, 11469015, 11469055, 11493120, 11493215, 11493255, 11493295, 11493335, 11493375, 11503360, 11503455, 11503495, 11503535, 11503575, 11503615, 11513600, 11513695, 11513735, 11513775, 11513815, 11513855, 11523840, 11523935, 11523975, 11524015, 11524055, 11524095, 11534080, 11534175, 11534215, 11534255, 11534295, 11534335, 14090240, 14090335, 14090375, 14090415, 14090455, 14090495, 14114560, 14114655, 14114695, 14114735, 14114775, 14114815, 14124800, 14124895, 14124935, 14124975, 14125015, 14125055, 14135040, 14135135, 14135175, 14135215, 14135255, 14135295, 14145280, 14145375, 14145415, 14145455, 14145495, 14145535, 14155520, 14155615, 14155655, 14155695, 14155735, 14155775, 16711680, 16711775, 16711815, 16711855, 16711895, 16711935, 16736000, 16736095, 16736135, 16736175, 16736215, 16736255, 16746240, 16746335, 16746375, 16746415, 16746455, 16746495, 16756480, 16756575, 16756615, 16756655, 16756695, 16756735, 16766720, 16766815, 16766855, 16766895, 16766935, 16766975, 16776960, 16777055, 16777095, 16777135, 16777175, 16777215, 526344, 1184274, 1842204, 2500134, 3158064, 3815994, 4473924, 5131854, 5789784, 6447714, 7105644, 7763574, 8421504, 9079434, 9737364, 10395294, 11053224, 11711154, 12369084, 13027014, 13684944, 14342874, 15000804, 15658734};
    public static final int[] DEFAULT_COLORS_88 = {0, 8388608, 32768, 8421376, 128, 8388736, 32896, 12632256, 8421504, 16711680, 65280, 16776960, 255, 16711935, 65535, 16777215, 0, 139, 205, 255, 35584, 35723, 35789, 35839, 52480, 52619, 52685, 52735, 65280, 65419, 65485, 65535, 9109504, 9109643, 9109709, 9109759, 9145088, 9145227, 9145293, 9145343, 9161984, 9162123, 9162189, 9162239, 9174784, 9174923, 9174989, 9175039, 13434880, 13435019, 13435085, 13435135, 13470464, 13470603, 13470669, 13470719, 13487360, 13487499, 13487565, 13487615, 13500160, 13500299, 13500365, 13500415, 16711680, 16711819, 16711885, 16711935, 16747264, 16747403, 16747469, 16747519, 16764160, 16764299, 16764365, 16764415, 16776960, 16777099, 16777165, 16777215, 3026478, 6052956, 7566195, 9145227, 10658466, 12171705, 13684944, 15198183};
    public static final double[] D50 = {96.4219970703125d, 100.0d, 82.52100372314453d};
    public static final double[] D65 = {95.047d, 100.0d, 108.883d};
    public static final double[] averageSurrounding = {1.0d, 0.69d, 1.0d};
    public static final double[] dimSurrounding = {0.9d, 0.59d, 0.9d};
    public static final double[] darkSurrounding = {0.8d, 0.525d, 0.8d};
    public static final double[] sRGB_encoding_environment = m25vc(D50, 64.0d, 12.8d, dimSurrounding);
    public static final double[] sRGB_typical_environment = m25vc(D50, 200.0d, 40.0d, averageSurrounding);
    public static final double[] AdobeRGB_environment = m25vc(D65, 160.0d, 32.0d, averageSurrounding);
    private static int[] COLORS_256 = DEFAULT_COLORS_256;
    private static Map<String, Integer> COLOR_NAMES;

    /* renamed from: L */
    private static final int f3249L = 0;

    /* renamed from: A */
    private static final int f3250A = 1;

    /* renamed from: B */
    private static final int f3251B = 2;

    /* renamed from: X */
    private static final int f3252X = 0;

    /* renamed from: Y */
    private static final int f3253Y = 1;

    /* renamed from: Z */
    private static final int f3254Z = 2;

    /* renamed from: kl */
    private static final double f3255kl = 2.0d;

    /* renamed from: kc */
    private static final double f3256kc = 1.0d;

    /* renamed from: kh */
    private static final double f3257kh = 1.0d;

    /* renamed from: k1 */
    private static final double f3258k1 = 0.045d;

    /* renamed from: k2 */
    private static final double f3259k2 = 0.015d;

    /* renamed from: J */
    public static final int f3260J = 0;

    /* renamed from: Q */
    public static final int f3261Q = 1;

    /* renamed from: C */
    public static final int f3262C = 2;

    /* renamed from: M */
    public static final int f3263M = 3;

    /* renamed from: s */
    public static final int f3264s = 4;

    /* renamed from: H */
    public static final int f3265H = 5;

    /* renamed from: h */
    public static final int f3266h = 6;
    static final int SUR_F = 0;
    static final int SUR_C = 1;
    static final int SUR_N_C = 2;
    static final int VC_X_W = 0;
    static final int VC_Y_W = 1;
    static final int VC_Z_W = 2;
    static final int VC_L_A = 3;
    static final int VC_Y_B = 4;
    static final int VC_F = 5;
    static final int VC_C = 6;
    static final int VC_N_C = 7;
    static final int VC_Z = 8;
    static final int VC_N = 9;
    static final int VC_N_BB = 10;
    static final int VC_N_CB = 11;
    static final int VC_A_W = 12;
    static final int VC_F_L = 13;
    static final int VC_D_RGB_R = 14;
    static final int VC_D_RGB_G = 15;
    static final int VC_D_RGB_B = 16;
    private static final double epsilon = 0.008856451679035631d;
    private static final double kappa = 903.2962962962963d;

    /* WARNING: Classes with same name are omitted:
  
 */
    /* access modifiers changed from: package-private */
    @FunctionalInterface
    /* loaded from: grasscutter.jar:org/jline/utils/Colors$Distance.class */
    public interface Distance {
        double compute(int i, int i2);
    }

    public static void setRgbColors(int[] colors) {
        if (colors == null || colors.length != 256) {
            throw new IllegalArgumentException();
        }
        COLORS_256 = colors;
    }

    public static int rgbColor(int col) {
        return COLORS_256[col];
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0061
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.lang.Integer rgbColor(java.lang.String r7) {
        /*
            java.util.Map<java.lang.String, java.lang.Integer> r0 = org.jline.utils.Colors.COLOR_NAMES
            if (r0 != 0) goto L_0x00a4
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r1 = r0
            r1.<init>()
            r8 = r0
            java.lang.Class<org.jline.utils.InfoCmp> r0 = org.jline.utils.InfoCmp.class
            java.lang.String r1 = "colors.txt"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)     // Catch: IOException -> 0x009a
            r9 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: Throwable -> 0x0081, IOException -> 0x009a
            r1 = r0
            org.jline.utils.InputStreamReader r2 = new org.jline.utils.InputStreamReader     // Catch: Throwable -> 0x0081, IOException -> 0x009a
            r3 = r2
            r4 = r9
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch: Throwable -> 0x0081, IOException -> 0x009a
            r3.<init>(r4, r5)     // Catch: Throwable -> 0x0081, IOException -> 0x009a
            r1.<init>(r2)     // Catch: Throwable -> 0x0081, IOException -> 0x009a
            r10 = r0
            r0 = r10
            java.util.stream.Stream r0 = r0.lines()     // Catch: Throwable -> 0x0081, IOException -> 0x009a, Throwable -> 0x0061
            java.lang.Integer r1 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.trim();
            }     // Catch: Throwable -> 0x0081, IOException -> 0x009a, Throwable -> 0x0061
            java.util.stream.Stream r0 = r0.map(r1)     // Catch: Throwable -> 0x0081, IOException -> 0x009a, Throwable -> 0x0061
            java.lang.Integer r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$rgbColor$0(v0);
            }     // Catch: Throwable -> 0x0081, IOException -> 0x009a, Throwable -> 0x0061
            java.util.stream.Stream r0 = r0.filter(r1)     // Catch: Throwable -> 0x0081, IOException -> 0x009a, Throwable -> 0x0061
            java.lang.Integer r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$rgbColor$1(v0);
            }     // Catch: Throwable -> 0x0081, IOException -> 0x009a, Throwable -> 0x0061
            java.util.stream.Stream r0 = r0.filter(r1)     // Catch: Throwable -> 0x0081, IOException -> 0x009a, Throwable -> 0x0061
            r1 = r8
            java.lang.Integer r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$rgbColor$2(r1, v1);
            }     // Catch: Throwable -> 0x0081, IOException -> 0x009a, Throwable -> 0x0061
            r0.forEachOrdered(r1)     // Catch: Throwable -> 0x0081, IOException -> 0x009a, Throwable -> 0x0061
            r0 = r8
            org.jline.utils.Colors.COLOR_NAMES = r0     // Catch: Throwable -> 0x0081, IOException -> 0x009a, Throwable -> 0x0061
            r0 = r10
            r0.close()     // Catch: Throwable -> 0x0081, IOException -> 0x009a
            goto L_0x0076
        L_0x0061:
            r11 = move-exception
            r0 = r10
            r0.close()     // Catch: Throwable -> 0x0081, Throwable -> 0x006a, IOException -> 0x009a
            goto L_0x0073
        L_0x006a:
            r12 = move-exception
            r0 = r11
            r1 = r12
            r0.addSuppressed(r1)     // Catch: Throwable -> 0x0081, IOException -> 0x009a
        L_0x0073:
            r0 = r11
            throw r0     // Catch: Throwable -> 0x0081, IOException -> 0x009a
        L_0x0076:
            r0 = r9
            if (r0 == 0) goto L_0x0097
            r0 = r9
            r0.close()     // Catch: IOException -> 0x009a
            goto L_0x0097
        L_0x0081:
            r10 = move-exception
            r0 = r9
            if (r0 == 0) goto L_0x0095
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x008d, IOException -> 0x009a
            goto L_0x0095
        L_0x008d:
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)     // Catch: IOException -> 0x009a
        L_0x0095:
            r0 = r10
            throw r0     // Catch: IOException -> 0x009a
        L_0x0097:
            goto L_0x00a4
        L_0x009a:
            r9 = move-exception
            java.io.IOError r0 = new java.io.IOError
            r1 = r0
            r2 = r9
            r1.<init>(r2)
            throw r0
        L_0x00a4:
            java.util.Map<java.lang.String, java.lang.Integer> r0 = org.jline.utils.Colors.COLOR_NAMES
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.Colors.rgbColor(java.lang.String):java.lang.Integer");
    }

    public static int roundColor(int col, int max) {
        return roundColor(col, max, null);
    }

    public static int roundColor(int col, int max, String dist) {
        if (col >= max) {
            col = roundColor(COLORS_256[col], COLORS_256, max, dist);
        }
        return col;
    }

    public static int roundRgbColor(int r, int g, int b, int max) {
        return roundColor((r << 16) + (g << 8) + b, COLORS_256, max, (String) null);
    }

    static int roundColor(int color, int[] colors, int max, String dist) {
        return roundColor(color, colors, max, getDistance(dist));
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [double] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int roundColor(int r5, int[] r6, int r7, org.jline.utils.Colors.Distance r8) {
        /*
            r0 = 4746794007244308480(0x41dfffffffc00000, double:2.147483647E9)
            r9 = r0
            r0 = 2147483647(0x7fffffff, float:NaN)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x000c:
            r0 = r12
            r1 = r7
            if (r0 >= r1) goto L_0x0035
            r0 = r8
            r1 = r5
            r2 = r6
            r3 = r12
            r2 = r2[r3]
            double r0 = r0.compute(r1, r2)
            r13 = r0
            r0 = r13
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x002f
            r0 = r12
            r11 = r0
            r0 = r13
            r9 = r0
        L_0x002f:
            int r12 = r12 + 1
            goto L_0x000c
        L_0x0035:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.Colors.roundColor(int, int[], int, org.jline.utils.Colors$Distance):int");
    }

    /* access modifiers changed from: package-private */
    public static Distance getDistance(String dist) {
        if (dist == null) {
            dist = System.getProperty("org.jline.utils.colorDistance", "cie76");
        }
        return doGetDistance(dist);
    }

    private static Distance doGetDistance(String dist) {
        if (dist.equals("rgb")) {
            return p1, p2 -> {
                double[] c1 = rgb(p1);
                double[] c2 = rgb(p2);
                double rmean = (c1[0] + c2[0]) / 2.0d;
                return scalar(c1, c2, new double[]{2.0d + rmean, 4.0d, 3.0d - rmean});
            };
        }
        if (dist.matches("rgb\\(([0-9]+(\\.[0-9]+)?),([0-9]+(\\.[0-9]+)?),([0-9]+(\\.[0-9]+)?)\\)")) {
            return p1, p2 -> {
                return scalar(rgb(p1), rgb(p2), getWeights(dist));
            };
        }
        if (dist.equals("lab") || dist.equals("cie76")) {
            return p1, p2 -> {
                return scalar(rgb2cielab(p1), rgb2cielab(p2));
            };
        }
        if (dist.matches("lab\\(([0-9]+(\\.[0-9]+)?),([0-9]+(\\.[0-9]+)?)\\)")) {
            double[] w = getWeights(dist);
            return p1, p2 -> {
                return scalar(rgb2cielab(p1), rgb2cielab(p2), new double[]{w[0], w[1], w[1]});
            };
        } else if (dist.equals("cie94")) {
            return p1, p2 -> {
                return cie94(rgb2cielab(p1), rgb2cielab(p2));
            };
        } else {
            if (dist.equals("cie00") || dist.equals("cie2000")) {
                return p1, p2 -> {
                    return cie00(rgb2cielab(p1), rgb2cielab(p2));
                };
            }
            if (dist.equals("cam02")) {
                return p1, p2 -> {
                    return cam02(p1, p2, sRGB_typical_environment);
                };
            }
            if (dist.equals("camlab")) {
                return p1, p2 -> {
                    return scalar(camlab(p1, sRGB_typical_environment), camlab(p2, sRGB_typical_environment));
                };
            }
            if (dist.matches("camlab\\(([0-9]+(\\.[0-9]+)?),([0-9]+(\\.[0-9]+)?)\\)")) {
                return p1, p2 -> {
                    double[] c1 = camlab(p1, sRGB_typical_environment);
                    double[] c2 = camlab(p2, sRGB_typical_environment);
                    double[] w2 = getWeights(dist);
                    return scalar(c1, c2, new double[]{w2[0], w2[1], w2[1]});
                };
            }
            if (dist.matches("camlch")) {
                return p1, p2 -> {
                    return camlch(camlch(p1, sRGB_typical_environment), camlch(p2, sRGB_typical_environment));
                };
            }
            if (dist.matches("camlch\\(([0-9]+(\\.[0-9]+)?),([0-9]+(\\.[0-9]+)?),([0-9]+(\\.[0-9]+)?)\\)")) {
                return p1, p2 -> {
                    return camlch(camlch(p1, sRGB_typical_environment), camlch(p2, sRGB_typical_environment), getWeights(dist));
                };
            }
            throw new IllegalArgumentException("Unsupported distance function: " + dist);
        }
    }

    private static double[] getWeights(String dist) {
        return Stream.of((Object[]) dist.substring(dist.indexOf(40) + 1, dist.length() - 1).split(",")).mapToDouble(Double::parseDouble).toArray();
    }

    private static double scalar(double[] c1, double[] c2, double[] w) {
        return sqr((c1[0] - c2[0]) * w[0]) + sqr((c1[1] - c2[1]) * w[1]) + sqr((c1[2] - c2[2]) * w[2]);
    }

    private static double scalar(double[] c1, double[] c2) {
        return sqr(c1[0] - c2[0]) + sqr(c1[1] - c2[1]) + sqr(c1[2] - c2[2]);
    }

    private static double cie94(double[] lab1, double[] lab2) {
        double dl = lab1[0] - lab2[0];
        double da = lab1[1] - lab2[1];
        double db = lab1[2] - lab2[2];
        double c1 = Math.sqrt((lab1[1] * lab1[1]) + (lab1[2] * lab1[2]));
        double dc = c1 - Math.sqrt((lab2[1] * lab2[1]) + (lab2[2] * lab2[2]));
        double dh = ((da * da) + (db * db)) - (dc * dc);
        double dh2 = dh < 0.0d ? 0.0d : Math.sqrt(dh);
        double sc = 1.0d + (0.045d * c1);
        double sh = 1.0d + (0.015d * c1);
        double dLKlsl = dl / (2.0d * 1.0d);
        double dCkcsc = dc / (1.0d * sc);
        double dHkhsh = dh2 / (1.0d * sh);
        return (dLKlsl * dLKlsl) + (dCkcsc * dCkcsc) + (dHkhsh * dHkhsh);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r43v0 */
    /* JADX WARN: Type inference failed for: r51v0, types: [double] */
    /* JADX WARN: Type inference failed for: r51v4 */
    /* JADX WARN: Type inference failed for: r0v146, types: [double] */
    /* JADX WARN: Type inference failed for: r43v3 */
    /* JADX WARN: Type inference failed for: r43v4 */
    /* JADX WARN: Type inference failed for: r43v6 */
    /* JADX WARN: Type inference failed for: r43v7 */
    /* JADX WARN: Type inference failed for: r51v6 */
    /* JADX WARN: Type inference failed for: r51v7 */
    /* JADX WARN: Type inference failed for: r51v8 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double cie00(double[] r11, double[] r12) {
        /*
        // Method dump skipped, instructions count: 696
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.Colors.cie00(double[], double[]):double");
    }

    private static double cam02(int p1, int p2, double[] vc) {
        return scalar(jmh2ucs(camlch(p1, vc)), jmh2ucs(camlch(p2, vc)));
    }

    private static double[] jmh2ucs(double[] lch) {
        double sJ = (1.7000000000000002d * lch[0]) / (1.0d + (0.007d * lch[0]));
        double sM = 43.859649122807014d * Math.log(1.0d + (0.0228d * lch[1]));
        return new double[]{sJ, sM * Math.cos(Math.toRadians(lch[2])), sM * Math.sin(Math.toRadians(lch[2]))};
    }

    static double camlch(double[] c1, double[] c2) {
        return camlch(c1, c2, new double[]{1.0d, 1.0d, 1.0d});
    }

    static double camlch(double[] c1, double[] c2, double[] w) {
        double lightnessWeight = w[0] / 100.0d;
        double colorfulnessWeight = w[1] / 120.0d;
        double hueWeight = w[2] / 360.0d;
        double dl = (c1[0] - c2[0]) * lightnessWeight;
        double dc = (c1[1] - c2[1]) * colorfulnessWeight;
        double dh = hueDifference(c1[2], c2[2], 360.0d) * hueWeight;
        return (dl * dl) + (dc * dc) + (dh * dh);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [double] */
    /* JADX WARN: Type inference failed for: r0v11, types: [double] */
    /* JADX WARN: Type inference failed for: r0v13, types: [double] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double hueDifference(double r5, double r7, double r9) {
        /*
            r0 = r7
            r1 = r5
            double r0 = r0 - r1
            r1 = r9
            double r0 = r0 % r1
            r11 = r0
            r0 = r9
            r1 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = r0 / r1
            r13 = r0
            r0 = r11
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x001f
            r0 = r11
            r1 = r9
            double r0 = r0 - r1
            r11 = r0
        L_0x001f:
            r0 = r11
            r1 = r13
            double r1 = -r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x002f
            r0 = r11
            r1 = r9
            double r0 = r0 + r1
            r11 = r0
        L_0x002f:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.Colors.hueDifference(double, double, double):double");
    }

    private static double[] rgb(int color) {
        return new double[]{((double) ((color >> 16) & 255)) / 255.0d, ((double) ((color >> 8) & 255)) / 255.0d, ((double) ((color >> 0) & 255)) / 255.0d};
    }

    static double[] rgb2xyz(int color) {
        return rgb2xyz(rgb(color));
    }

    static double[] rgb2cielab(int color) {
        return rgb2cielab(rgb(color));
    }

    static double[] camlch(int color) {
        return camlch(color, sRGB_typical_environment);
    }

    static double[] camlch(int color, double[] vc) {
        return xyz2camlch(rgb2xyz(color), vc);
    }

    static double[] camlab(int color) {
        return camlab(color, sRGB_typical_environment);
    }

    static double[] camlab(int color, double[] vc) {
        return lch2lab(camlch(color, vc));
    }

    static double[] lch2lab(double[] lch) {
        return new double[]{lch[0], lch[1] * Math.cos(lch[2] * 0.017453292519943295d), lch[1] * Math.sin(lch[2] * 0.017453292519943295d)};
    }

    private static double[] xyz2camlch(double[] xyz, double[] vc) {
        double[] cam = forwardTransform(new double[]{xyz[0] * 100.0d, xyz[1] * 100.0d, xyz[2] * 100.0d}, vc);
        return new double[]{cam[0], cam[3], cam[6]};
    }

    private static double[] forwardTransform(double[] XYZ, double[] vc) {
        double[] RGBPrime_a = forwardResponseCompression(CAT02toHPE(forwardPostAdaptationConeResponse(forwardPreAdaptationConeResponse(XYZ), vc)), vc);
        double J = 100.0d * Math.pow((((((2.0d * RGBPrime_a[0]) + RGBPrime_a[1]) + (RGBPrime_a[2] / 20.0d)) - 0.305d) * vc[10]) / vc[12], vc[8] * vc[6]);
        double a = RGBPrime_a[0] + (((-12.0d * RGBPrime_a[1]) + RGBPrime_a[2]) / 11.0d);
        double b = ((RGBPrime_a[0] + RGBPrime_a[1]) - (2.0d * RGBPrime_a[2])) / 9.0d;
        double h = (Math.toDegrees(Math.atan2(b, a)) + 360.0d) % 360.0d;
        double t = ((((961.5384615384615d * vc[7]) * vc[11]) * (Math.cos(Math.toRadians(h) + 2.0d) + 3.8d)) * Math.sqrt(Math.pow(a, 2.0d) + Math.pow(b, 2.0d))) / ((RGBPrime_a[0] + RGBPrime_a[1]) + (1.05d * RGBPrime_a[2]));
        double Q = (4.0d / vc[6]) * Math.sqrt(J / 100.0d) * (vc[12] + 4.0d) * Math.pow(vc[13], 0.25d);
        double C = Math.signum(t) * Math.pow(Math.abs(t), 0.9d) * Math.sqrt(J / 100.0d) * Math.pow(1.64d - Math.pow(0.29d, vc[9]), 0.73d);
        double M = C * Math.pow(vc[13], 0.25d);
        return new double[]{J, Q, C, M, 100.0d * Math.sqrt(M / Q), calculateH(h), h};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [double] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r0v41, types: [double] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double calculateH(double r11) {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.Colors.calculateH(double):double");
    }

    private static double[] forwardResponseCompression(double[] RGB, double[] vc) {
        double[] result = new double[3];
        for (int channel = 0; channel < RGB.length; channel++) {
            if (RGB[channel] >= 0.0d) {
                double n = Math.pow((vc[13] * RGB[channel]) / 100.0d, 0.42d);
                result[channel] = ((400.0d * n) / (n + 27.13d)) + 0.1d;
            } else {
                double n2 = Math.pow(((-1.0d * vc[13]) * RGB[channel]) / 100.0d, 0.42d);
                result[channel] = ((-400.0d * n2) / (n2 + 27.13d)) + 0.1d;
            }
        }
        return result;
    }

    private static double[] forwardPostAdaptationConeResponse(double[] RGB, double[] vc) {
        return new double[]{vc[14] * RGB[0], vc[15] * RGB[1], vc[16] * RGB[2]};
    }

    public static double[] CAT02toHPE(double[] RGB) {
        return new double[]{(0.7409792d * RGB[0]) + (0.218025d * RGB[1]) + (0.0410058d * RGB[2]), (0.2853532d * RGB[0]) + (0.6242014d * RGB[1]) + (0.0904454d * RGB[2]), ((-0.009628d * RGB[0]) - (0.005698d * RGB[1])) + (1.015326d * RGB[2])};
    }

    private static double[] forwardPreAdaptationConeResponse(double[] XYZ) {
        return new double[]{((0.7328d * XYZ[0]) + (0.4296d * XYZ[1])) - (0.1624d * XYZ[2]), (-0.7036d * XYZ[0]) + (1.6975d * XYZ[1]) + (0.0061d * XYZ[2]), (0.003d * XYZ[0]) + (0.0136d * XYZ[1]) + (0.9834d * XYZ[2])};
    }

    /* renamed from: vc */
    static double[] m25vc(double[] xyz_w, double L_A, double Y_b, double[] surrounding) {
        double[] vc = new double[17];
        vc[0] = xyz_w[0];
        vc[1] = xyz_w[1];
        vc[2] = xyz_w[2];
        vc[3] = L_A;
        vc[4] = Y_b;
        vc[5] = surrounding[0];
        vc[6] = surrounding[1];
        vc[7] = surrounding[2];
        double[] RGB_w = forwardPreAdaptationConeResponse(xyz_w);
        double D = Math.max(0.0d, Math.min(1.0d, vc[5] * (1.0d - (0.2777777777777778d * Math.pow(2.718281828459045d, ((-L_A) - 42.0d) / 92.0d)))));
        double Yw = xyz_w[1];
        double[] RGB_c = {((D * Yw) / RGB_w[0]) + (1.0d - D), ((D * Yw) / RGB_w[1]) + (1.0d - D), ((D * Yw) / RGB_w[2]) + (1.0d - D)};
        double L_Ax5 = 5.0d * L_A;
        double kpow4 = Math.pow(1.0d / (L_Ax5 + 1.0d), 4.0d);
        vc[13] = (0.2d * kpow4 * L_Ax5) + (0.1d * Math.pow(1.0d - kpow4, 2.0d) * Math.pow(L_Ax5, 0.3333333333333333d));
        vc[9] = Y_b / Yw;
        vc[8] = 1.48d + Math.sqrt(vc[9]);
        vc[10] = 0.725d * Math.pow(1.0d / vc[9], 0.2d);
        vc[11] = vc[10];
        double[] RGBPrime_w = CAT02toHPE(new double[]{RGB_c[0] * RGB_w[0], RGB_c[1] * RGB_w[1], RGB_c[2] * RGB_w[2]});
        double[] RGBPrime_aw = new double[3];
        for (int channel = 0; channel < RGBPrime_w.length; channel++) {
            if (RGBPrime_w[channel] >= 0.0d) {
                double n = Math.pow((vc[13] * RGBPrime_w[channel]) / 100.0d, 0.42d);
                RGBPrime_aw[channel] = ((400.0d * n) / (n + 27.13d)) + 0.1d;
            } else {
                double n2 = Math.pow(((-1.0d * vc[13]) * RGBPrime_w[channel]) / 100.0d, 0.42d);
                RGBPrime_aw[channel] = ((-400.0d * n2) / (n2 + 27.13d)) + 0.1d;
            }
        }
        vc[12] = ((((2.0d * RGBPrime_aw[0]) + RGBPrime_aw[1]) + (RGBPrime_aw[2] / 20.0d)) - 0.305d) * vc[10];
        vc[14] = RGB_c[0];
        vc[15] = RGB_c[1];
        vc[16] = RGB_c[2];
        return vc;
    }

    public static double[] rgb2cielab(double[] rgb) {
        return xyz2lab(rgb2xyz(rgb));
    }

    private static double[] rgb2xyz(double[] rgb) {
        double vr = pivotRgb(rgb[0]);
        double vg = pivotRgb(rgb[1]);
        double vb = pivotRgb(rgb[2]);
        return new double[]{(vr * 0.4124564d) + (vg * 0.3575761d) + (vb * 0.1804375d), (vr * 0.2126729d) + (vg * 0.7151522d) + (vb * 0.072175d), (vr * 0.0193339d) + (vg * 0.119192d) + (vb * 0.9503041d)};
    }

    private static double pivotRgb(double n) {
        return n > 0.04045d ? Math.pow((n + 0.055d) / 1.055d, 2.4d) : n / 12.92d;
    }

    private static double[] xyz2lab(double[] xyz) {
        double fx = pivotXyz(xyz[0]);
        double fy = pivotXyz(xyz[1]);
        return new double[]{(116.0d * fy) - 16.0d, 500.0d * (fx - fy), 200.0d * (fy - pivotXyz(xyz[2]))};
    }

    private static double pivotXyz(double n) {
        return n > 0.008856451679035631d ? Math.cbrt(n) : ((903.2962962962963d * n) + 16.0d) / 116.0d;
    }

    private static double sqr(double n) {
        return n * n;
    }
}
