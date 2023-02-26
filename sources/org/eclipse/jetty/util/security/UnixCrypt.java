package org.eclipse.jetty.util.security;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/security/UnixCrypt.class */
public class UnixCrypt {

    /* renamed from: IP */
    private static final byte[] f3132IP = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};
    private static final byte[] ExpandTr = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
    private static final byte[] PC1 = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
    private static final byte[] Rotates = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
    private static final byte[] PC2 = {9, 18, 14, 17, 11, 24, 1, 5, 22, 25, 3, 28, 15, 6, 21, 10, 35, 38, 23, 19, 12, 4, 26, 8, 43, 54, 16, 7, 27, 20, 13, 2, 0, 0, 41, 52, 31, 37, 47, 55, 0, 0, 30, 40, 51, 45, 33, 48, 0, 0, 44, 49, 39, 56, 34, 53, 0, 0, 46, 42, 50, 36, 29, 32};

    /* renamed from: S */
    private static final byte[][] f3133S = {new byte[]{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}, new byte[]{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}, new byte[]{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}, new byte[]{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}, new byte[]{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}, new byte[]{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}, new byte[]{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}, new byte[]{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};
    private static final byte[] P32Tr = {16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};
    private static final byte[] CIFP = {1, 2, 3, 4, 17, 18, 19, 20, 5, 6, 7, 8, 21, 22, 23, 24, 9, 10, 11, 12, 25, 26, 27, 28, 13, 14, 15, 16, 29, 30, 31, 32, 33, 34, 35, 36, 49, 50, 51, 52, 37, 38, 39, 40, 53, 54, 55, 56, 41, 42, 43, 44, 57, 58, 59, 60, 45, 46, 47, 48, 61, 62, 63, 64};
    private static final byte[] ITOA64 = {46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] A64TOI = new byte[128];
    private static final long[][] PC1ROT = new long[16][16][];
    private static final long[][][] PC2ROT = new long[2][16][16][][];
    private static final long[][] IE3264 = new long[8][16][];
    private static final long[][] SPE = new long[8][64][];
    private static final long[][] CF6464 = new long[16][16][];

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:117:0x166a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:120:0x16b2 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [long[][][][], long[][]] */
    /* JADX WARN: Type inference failed for: r0v23, types: [long[][][][][][], long[][][]] */
    /* JADX WARN: Type inference failed for: r0v25, types: [long[][][][], long[][]] */
    /* JADX WARN: Type inference failed for: r0v27, types: [long[][][][], long[][]] */
    /* JADX WARN: Type inference failed for: r0v29, types: [long[][][][], long[][]] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v90, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r11v3, types: [int] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [int] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARNING: Unknown variable types count: 2 */
    static {
        /*
        // Method dump skipped, instructions count: 6101
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.security.UnixCrypt.m9854clinit():void");
    }

    private UnixCrypt() {
    }

    private static int to_six_bit(int num) {
        return ((num << 26) & -67108864) | ((num << 12) & 16515072) | ((num >> 2) & 64512) | ((num >> 16) & 252);
    }

    private static long to_six_bit(long num) {
        return ((num << 26) & -288230371923853312L) | ((num << 12) & 70931694147600384L) | ((num >> 2) & 277076930264064L) | ((num >> 16) & 1082331758844L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r0v18, types: [long] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long perm6464(long r5, long[][] r7) {
        /*
            r0 = 0
            r8 = r0
            r0 = 8
            r10 = r0
        L_0x0006:
            int r10 = r10 + -1
            r0 = r10
            if (r0 < 0) goto L_0x0045
            r0 = 255(0xff, double:1.26E-321)
            r1 = r5
            long r0 = r0 & r1
            int r0 = (int) r0
            r11 = r0
            r0 = r5
            r1 = 8
            long r0 = r0 >> r1
            r5 = r0
            r0 = r7
            r1 = r10
            r2 = 1
            int r1 = r1 << r2
            r0 = r0[r1]
            r1 = r11
            r2 = 15
            r1 = r1 & r2
            r0 = r0[r1]
            r12 = r0
            r0 = r8
            r1 = r12
            long r0 = r0 | r1
            r8 = r0
            r0 = r7
            r1 = r10
            r2 = 1
            int r1 = r1 << r2
            r2 = 1
            int r1 = r1 + r2
            r0 = r0[r1]
            r1 = r11
            r2 = 4
            int r1 = r1 >> r2
            r0 = r0[r1]
            r12 = r0
            r0 = r8
            r1 = r12
            long r0 = r0 | r1
            r8 = r0
            goto L_0x0006
        L_0x0045:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.security.UnixCrypt.perm6464(long, long[][]):long");
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    private static long perm3264(int c, long[][] p) {
        char c2 = 0;
        int i = 4;
        while (true) {
            i--;
            if (i < 0) {
                return c2;
            }
            int t = 255 & c;
            c >>= 8;
            c2 = c2 | p[i << 1][t & 15] | p[(i << 1) + 1][t >> 4];
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    private static long[] des_setkey(long keyword) {
        boolean perm6464 = perm6464(keyword, PC1ROT);
        long[] KS = new long[16];
        KS[0] = (perm6464 ? 1 : 0) & -217020518463700993L;
        int i = 1;
        boolean z = perm6464;
        while (i < 16) {
            long K = z ? 1 : 0;
            long K2 = z ? 1 : 0;
            long K3 = z ? 1 : 0;
            KS[i] = K;
            boolean perm64642 = perm6464(z ? 1 : 0, PC2ROT[Rotates[i] - 1]);
            KS[i] = (perm64642 ? 1 : 0) & -217020518463700993L;
            i++;
            z = perm64642;
        }
        return KS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v4, types: [long] */
    /* JADX WARN: Type inference failed for: r17v4, types: [long] */
    /* JADX WARN: Type inference failed for: r0v37, types: [long] */
    /* JADX WARN: Type inference failed for: r0v39, types: [long] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r0v53, types: [long] */
    /* JADX WARN: Type inference failed for: r0v67, types: [long] */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long des_cipher(long r10, int r12, int r13, long[] r14) {
        /*
        // Method dump skipped, instructions count: 581
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.security.UnixCrypt.des_cipher(long, int, int, long[]):long");
    }

    private static void init_perm(long[][] perm, byte[] p, int chars_out) {
        for (int k = 0; k < chars_out * 8; k++) {
            int l = p[k] - 1;
            if (l >= 0) {
                int i = l >> 2;
                int l2 = 1 << (l & 3);
                for (int j = 0; j < 16; j++) {
                    int s = (k & 7) + ((7 - (k >> 3)) << 3);
                    if ((j & l2) != 0) {
                        long[] jArr = perm[i];
                        jArr[j] = jArr[j] | (1 << s);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String crypt(java.lang.String r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.security.UnixCrypt.crypt(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void main(String[] arg) {
        if (arg.length != 2) {
            System.err.println("Usage - java org.eclipse.util.UnixCrypt <key> <salt>");
            System.exit(1);
        }
        System.err.println("Crypt=" + crypt(arg[0], arg[1]));
    }
}
