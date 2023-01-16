package p013io.netty.handler.codec.compression;

import emu.grasscutter.net.packet.PacketOpcodes;
import net.bytebuddy.jar.asm.Opcodes;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.codec.compression.Bzip2DivSufSort */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2DivSufSort.class */
public final class Bzip2DivSufSort {
    private static final int STACK_SIZE = 64;
    private static final int BUCKET_A_SIZE = 256;
    private static final int BUCKET_B_SIZE = 65536;
    private static final int SS_BLOCKSIZE = 1024;
    private static final int INSERTIONSORT_THRESHOLD = 8;
    private static final int[] LOG_2_TABLE = {-1, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};

    /* renamed from: SA */
    private final int[] f998SA;

    /* renamed from: T */
    private final byte[] f999T;

    /* renamed from: n */
    private final int f1000n;

    /* access modifiers changed from: package-private */
    public Bzip2DivSufSort(byte[] block, int[] bwtBlock, int blockLength) {
        this.f999T = block;
        this.f998SA = bwtBlock;
        this.f1000n = blockLength;
    }

    private static void swapElements(int[] array1, int idx1, int[] array2, int idx2) {
        int temp = array1[idx1];
        array1[idx1] = array2[idx2];
        array2[idx2] = temp;
    }

    private int ssCompare(int p1, int p2, int depth) {
        int[] SA = this.f998SA;
        byte[] T = this.f999T;
        int U1n = SA[p1 + 1] + 2;
        int U2n = SA[p2 + 1] + 2;
        int U1 = depth + SA[p1];
        int U2 = depth + SA[p2];
        while (U1 < U1n && U2 < U2n && T[U1] == T[U2]) {
            U1++;
            U2++;
        }
        if (U1 >= U1n) {
            return U2 < U2n ? -1 : 0;
        }
        if (U2 < U2n) {
            return (T[U1] & 255) - (T[U2] & 255);
        }
        return 1;
    }

    private int ssCompareLast(int pa, int p1, int p2, int depth, int size) {
        int[] SA = this.f998SA;
        byte[] T = this.f999T;
        int U1 = depth + SA[p1];
        int U2 = depth + SA[p2];
        int U2n = SA[p2 + 1] + 2;
        while (U1 < size && U2 < U2n && T[U1] == T[U2]) {
            U1++;
            U2++;
        }
        if (U1 < size) {
            if (U2 < U2n) {
                return (T[U1] & 255) - (T[U2] & 255);
            }
            return 1;
        } else if (U2 == U2n) {
            return 1;
        } else {
            int U12 = U1 % size;
            int U1n = SA[pa] + 2;
            while (U12 < U1n && U2 < U2n && T[U12] == T[U2]) {
                U12++;
                U2++;
            }
            if (U12 >= U1n) {
                return U2 < U2n ? -1 : 0;
            }
            if (U2 < U2n) {
                return (T[U12] & 255) - (T[U2] & 255);
            }
            return 1;
        }
    }

    private void ssInsertionSort(int pa, int first, int last, int depth) {
        int r;
        int[] SA = this.f998SA;
        for (int i = last - 2; first <= i; i--) {
            int t = SA[i];
            int j = i + 1;
            do {
                r = ssCompare(pa + t, pa + SA[j], depth);
                if (0 >= r) {
                    break;
                }
                do {
                    SA[j - 1] = SA[j];
                    j++;
                    if (j >= last) {
                        break;
                    }
                } while (SA[j] < 0);
            } while (last > j);
            if (r == 0) {
                SA[j] = SA[j] ^ -1;
            }
            SA[j - 1] = t;
        }
    }

    private void ssFixdown(int td, int pa, int sa, int i, int size) {
        int[] SA = this.f998SA;
        byte[] T = this.f999T;
        int v = SA[sa + i];
        int c = T[td + SA[pa + v]] & 255;
        while (true) {
            int j = (2 * i) + 1;
            if (j >= size) {
                break;
            }
            int j2 = j + 1;
            int k = j;
            int d = T[td + SA[pa + SA[sa + j]]] & 255;
            int e = T[td + SA[pa + SA[sa + j2]]] & 255;
            if (d < e) {
                k = j2;
                d = e;
            }
            if (d <= c) {
                break;
            }
            SA[sa + i] = SA[sa + k];
            i = k;
        }
        SA[sa + i] = v;
    }

    private void ssHeapSort(int td, int pa, int sa, int size) {
        int[] SA = this.f998SA;
        byte[] T = this.f999T;
        int m = size;
        if (size % 2 == 0) {
            m--;
            if ((T[td + SA[pa + SA[sa + (m / 2)]]] & 255) < (T[td + SA[pa + SA[sa + m]]] & 255)) {
                swapElements(SA, sa + m, SA, sa + (m / 2));
            }
        }
        for (int i = (m / 2) - 1; 0 <= i; i--) {
            ssFixdown(td, pa, sa, i, m);
        }
        if (size % 2 == 0) {
            swapElements(SA, sa, SA, sa + m);
            ssFixdown(td, pa, sa, 0, m);
        }
        for (int i2 = m - 1; 0 < i2; i2--) {
            int t = SA[sa];
            SA[sa] = SA[sa + i2];
            ssFixdown(td, pa, sa, 0, i2);
            SA[sa + i2] = t;
        }
    }

    private int ssMedian3(int td, int pa, int v1, int v2, int v3) {
        int[] SA = this.f998SA;
        byte[] T = this.f999T;
        int T_v1 = T[td + SA[pa + SA[v1]]] & 255;
        int T_v2 = T[td + SA[pa + SA[v2]]] & 255;
        int T_v3 = T[td + SA[pa + SA[v3]]] & 255;
        if (T_v1 > T_v2) {
            v1 = v2;
            v2 = v1;
            T_v1 = T_v2;
            T_v2 = T_v1;
        }
        if (T_v2 <= T_v3) {
            return v2;
        }
        if (T_v1 > T_v3) {
            return v1;
        }
        return v3;
    }

    private int ssMedian5(int td, int pa, int v1, int v2, int v3, int v4, int v5) {
        int[] SA = this.f998SA;
        byte[] T = this.f999T;
        int T_v1 = T[td + SA[pa + SA[v1]]] & 255;
        int T_v2 = T[td + SA[pa + SA[v2]]] & 255;
        int T_v3 = T[td + SA[pa + SA[v3]]] & 255;
        int T_v4 = T[td + SA[pa + SA[v4]]] & 255;
        int T_v5 = T[td + SA[pa + SA[v5]]] & 255;
        if (T_v2 > T_v3) {
            v2 = v3;
            v3 = v2;
            T_v2 = T_v3;
            T_v3 = T_v2;
        }
        if (T_v4 > T_v5) {
            v4 = v5;
            v5 = v4;
            T_v4 = T_v5;
            T_v5 = T_v4;
        }
        if (T_v2 > T_v4) {
            v4 = v2;
            T_v4 = T_v2;
            v3 = v5;
            v5 = v3;
            T_v3 = T_v5;
            T_v5 = T_v3;
        }
        if (T_v1 > T_v3) {
            v1 = v3;
            v3 = v1;
            T_v1 = T_v3;
            T_v3 = T_v1;
        }
        if (T_v1 > T_v4) {
            v4 = v1;
            T_v4 = T_v1;
            v3 = v5;
            T_v3 = T_v5;
        }
        if (T_v3 > T_v4) {
            return v4;
        }
        return v3;
    }

    private int ssPivot(int td, int pa, int first, int last) {
        int t = last - first;
        int middle = first + (t / 2);
        if (t > 512) {
            int t2 = t >> 3;
            return ssMedian3(td, pa, ssMedian3(td, pa, first, first + t2, first + (t2 << 1)), ssMedian3(td, pa, middle - t2, middle, middle + t2), ssMedian3(td, pa, (last - 1) - (t2 << 1), (last - 1) - t2, last - 1));
        } else if (t <= 32) {
            return ssMedian3(td, pa, first, middle, last - 1);
        } else {
            int t3 = t >> 2;
            return ssMedian5(td, pa, first, first + t3, middle, (last - 1) - t3, last - 1);
        }
    }

    private static int ssLog(int n) {
        return (n & 65280) != 0 ? 8 + LOG_2_TABLE[(n >> 8) & 255] : LOG_2_TABLE[n & 255];
    }

    private int ssSubstringPartition(int pa, int first, int last, int depth) {
        int[] SA = this.f998SA;
        int a = first - 1;
        int b = last;
        while (true) {
            a++;
            if (a >= b || SA[pa + SA[a]] + depth < SA[pa + SA[a] + 1] + 1) {
                while (true) {
                    b--;
                    if (a >= b || SA[pa + SA[b]] + depth >= SA[pa + SA[b] + 1] + 1) {
                        break;
                    }
                }
                if (b <= a) {
                    break;
                }
                SA[b] = SA[a];
                SA[a] = SA[b] ^ -1;
            } else {
                SA[a] = SA[a] ^ -1;
            }
        }
        if (first < a) {
            SA[first] = SA[first] ^ -1;
        }
        return a;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.codec.compression.Bzip2DivSufSort$StackEntry */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2DivSufSort$StackEntry.class */
    public static class StackEntry {

        /* renamed from: a */
        final int f1001a;

        /* renamed from: b */
        final int f1002b;

        /* renamed from: c */
        final int f1003c;

        /* renamed from: d */
        final int f1004d;

        StackEntry(int a, int b, int c, int d) {
            this.f1001a = a;
            this.f1002b = b;
            this.f1003c = c;
            this.f1004d = d;
        }
    }

    private void ssMultiKeyIntroSort(int pa, int first, int last, int depth) {
        int[] SA = this.f998SA;
        byte[] T = this.f999T;
        StackEntry[] stack = new StackEntry[64];
        int x = 0;
        int ssize = 0;
        int limit = ssLog(last - first);
        while (true) {
            if (last - first <= 8) {
                if (1 < last - first) {
                    ssInsertionSort(pa, first, last, depth);
                }
                if (ssize != 0) {
                    ssize--;
                    StackEntry entry = stack[ssize];
                    first = entry.f1001a;
                    last = entry.f1002b;
                    depth = entry.f1003c;
                    limit = entry.f1004d;
                } else {
                    return;
                }
            } else {
                limit--;
                if (limit == 0) {
                    ssHeapSort(depth, pa, first, last - first);
                }
                if (limit < 0) {
                    int a = first + 1;
                    int v = T[depth + SA[pa + SA[first]]] & 255;
                    while (a < last) {
                        int i = T[depth + SA[pa + SA[a]]] & 255;
                        x = i;
                        if (i != v) {
                            if (1 < a - first) {
                                break;
                            }
                            v = x;
                            first = a;
                        }
                        a++;
                    }
                    if ((T[(depth + SA[pa + SA[first]]) - 1] & 255) < v) {
                        first = ssSubstringPartition(pa, first, a, depth);
                    }
                    if (a - first <= last - a) {
                        if (1 < a - first) {
                            ssize++;
                            stack[ssize] = new StackEntry(a, last, depth, -1);
                            last = a;
                            depth++;
                            limit = ssLog(a - first);
                        } else {
                            first = a;
                            limit = -1;
                        }
                    } else if (1 < last - a) {
                        ssize++;
                        stack[ssize] = new StackEntry(first, a, depth + 1, ssLog(a - first));
                        first = a;
                        limit = -1;
                    } else {
                        last = a;
                        depth++;
                        limit = ssLog(a - first);
                    }
                } else {
                    int a2 = ssPivot(depth, pa, first, last);
                    int v2 = T[depth + SA[pa + SA[a2]]] & 255;
                    swapElements(SA, first, SA, a2);
                    int b = first + 1;
                    while (b < last) {
                        int i2 = T[depth + SA[pa + SA[b]]] & 255;
                        x = i2;
                        if (i2 != v2) {
                            break;
                        }
                        b++;
                    }
                    int a3 = b;
                    if (b < last && x < v2) {
                        while (true) {
                            b++;
                            if (b >= last) {
                                break;
                            }
                            int i3 = T[depth + SA[pa + SA[b]]] & 255;
                            x = i3;
                            if (i3 > v2) {
                                break;
                            } else if (x == v2) {
                                swapElements(SA, b, SA, a3);
                                a3++;
                            }
                        }
                    }
                    int c = last - 1;
                    while (b < c) {
                        int i4 = T[depth + SA[pa + SA[c]]] & 255;
                        x = i4;
                        if (i4 != v2) {
                            break;
                        }
                        c--;
                    }
                    int d = c;
                    if (b < c && x > v2) {
                        while (true) {
                            c--;
                            if (b >= c) {
                                break;
                            }
                            int i5 = T[depth + SA[pa + SA[c]]] & 255;
                            x = i5;
                            if (i5 < v2) {
                                break;
                            } else if (x == v2) {
                                swapElements(SA, c, SA, d);
                                d--;
                            }
                        }
                    }
                    while (b < c) {
                        swapElements(SA, b, SA, c);
                        while (true) {
                            b++;
                            if (b >= c) {
                                break;
                            }
                            int i6 = T[depth + SA[pa + SA[b]]] & 255;
                            x = i6;
                            if (i6 > v2) {
                                break;
                            } else if (x == v2) {
                                swapElements(SA, b, SA, a3);
                                a3++;
                            }
                        }
                        while (true) {
                            c--;
                            if (b < c) {
                                int i7 = T[depth + SA[pa + SA[c]]] & 255;
                                x = i7;
                                if (i7 >= v2) {
                                    if (x == v2) {
                                        swapElements(SA, c, SA, d);
                                        d--;
                                    }
                                }
                            }
                        }
                    }
                    if (a3 <= d) {
                        int c2 = b - 1;
                        int i8 = a3 - first;
                        int s = i8;
                        int t = b - a3;
                        if (i8 > t) {
                            s = t;
                        }
                        int e = first;
                        int f = b - s;
                        while (0 < s) {
                            swapElements(SA, e, SA, f);
                            s--;
                            e++;
                            f++;
                        }
                        int i9 = d - c2;
                        int s2 = i9;
                        int t2 = (last - d) - 1;
                        if (i9 > t2) {
                            s2 = t2;
                        }
                        int e2 = b;
                        int f2 = last - s2;
                        while (0 < s2) {
                            swapElements(SA, e2, SA, f2);
                            s2--;
                            e2++;
                            f2++;
                        }
                        int a4 = first + (b - a3);
                        int c3 = last - (d - c2);
                        int b2 = v2 <= (T[(depth + SA[pa + SA[a4]]) - 1] & 255) ? a4 : ssSubstringPartition(pa, a4, c3, depth);
                        if (a4 - first <= last - c3) {
                            if (last - c3 <= c3 - b2) {
                                int ssize2 = ssize + 1;
                                stack[ssize] = new StackEntry(b2, c3, depth + 1, ssLog(c3 - b2));
                                ssize = ssize2 + 1;
                                stack[ssize2] = new StackEntry(c3, last, depth, limit);
                                last = a4;
                            } else if (a4 - first <= c3 - b2) {
                                int ssize3 = ssize + 1;
                                stack[ssize] = new StackEntry(c3, last, depth, limit);
                                ssize = ssize3 + 1;
                                stack[ssize3] = new StackEntry(b2, c3, depth + 1, ssLog(c3 - b2));
                                last = a4;
                            } else {
                                int ssize4 = ssize + 1;
                                stack[ssize] = new StackEntry(c3, last, depth, limit);
                                ssize = ssize4 + 1;
                                stack[ssize4] = new StackEntry(first, a4, depth, limit);
                                first = b2;
                                last = c3;
                                depth++;
                                limit = ssLog(c3 - b2);
                            }
                        } else if (a4 - first <= c3 - b2) {
                            int ssize5 = ssize + 1;
                            stack[ssize] = new StackEntry(b2, c3, depth + 1, ssLog(c3 - b2));
                            ssize = ssize5 + 1;
                            stack[ssize5] = new StackEntry(first, a4, depth, limit);
                            first = c3;
                        } else if (last - c3 <= c3 - b2) {
                            int ssize6 = ssize + 1;
                            stack[ssize] = new StackEntry(first, a4, depth, limit);
                            ssize = ssize6 + 1;
                            stack[ssize6] = new StackEntry(b2, c3, depth + 1, ssLog(c3 - b2));
                            first = c3;
                        } else {
                            int ssize7 = ssize + 1;
                            stack[ssize] = new StackEntry(first, a4, depth, limit);
                            ssize = ssize7 + 1;
                            stack[ssize7] = new StackEntry(c3, last, depth, limit);
                            first = b2;
                            last = c3;
                            depth++;
                            limit = ssLog(c3 - b2);
                        }
                    } else {
                        limit++;
                        if ((T[(depth + SA[pa + SA[first]]) - 1] & 255) < v2) {
                            first = ssSubstringPartition(pa, first, last, depth);
                            limit = ssLog(last - first);
                        }
                        depth++;
                    }
                }
            }
        }
    }

    private static void ssBlockSwap(int[] array1, int first1, int[] array2, int first2, int size) {
        int i = size;
        int a = first1;
        int b = first2;
        while (0 < i) {
            swapElements(array1, a, array2, b);
            i--;
            a++;
            b++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a5, code lost:
        if (r18 >= r0) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a8, code lost:
        r17 = r17 + 1;
        r0[r17] = r9[r18];
        r18 = r18 + 1;
        r9[r18] = r0[r17];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c3, code lost:
        r0[r17] = r9[r18];
        r9[r18] = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00d2, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x013c, code lost:
        if (r18 >= r0) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x013f, code lost:
        r17 = r17 + 1;
        r0[r17] = r9[r18];
        r18 = r18 + 1;
        r9[r18] = r0[r17];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x015a, code lost:
        r0[r17] = r9[r18];
        r9[r18] = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0169, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ssMergeForward(int r8, int[] r9, int r10, int r11, int r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 373
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.Bzip2DivSufSort.ssMergeForward(int, int[], int, int, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x016d, code lost:
        if (r10 >= r20) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0170, code lost:
        r19 = r19 - 1;
        r0[r19] = r9[r20];
        r20 = r20 - 1;
        r9[r20] = r0[r19];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x018b, code lost:
        r0[r19] = r9[r20];
        r9[r20] = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x019a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0269, code lost:
        if (r10 >= r20) goto L_0x0287;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x026c, code lost:
        r19 = r19 - 1;
        r0[r19] = r9[r20];
        r20 = r20 - 1;
        r9[r20] = r0[r19];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0287, code lost:
        r0[r19] = r9[r20];
        r9[r20] = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0296, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ssMergeBackward(int r8, int[] r9, int r10, int r11, int r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 737
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.Bzip2DivSufSort.ssMergeBackward(int, int[], int, int, int, int, int):void");
    }

    private static int getIDX(int a) {
        return 0 <= a ? a : a ^ -1;
    }

    private void ssMergeCheckEqual(int pa, int depth, int a) {
        int[] SA = this.f998SA;
        if (0 <= SA[a] && ssCompare(pa + getIDX(SA[a - 1]), pa + SA[a], depth) == 0) {
            SA[a] = SA[a] ^ -1;
        }
    }

    private void ssMerge(int pa, int first, int middle, int last, int[] buf, int bufoffset, int bufsize, int depth) {
        int[] SA = this.f998SA;
        StackEntry[] stack = new StackEntry[64];
        int check = 0;
        int ssize = 0;
        while (true) {
            if (last - middle <= bufsize) {
                if (first < middle && middle < last) {
                    ssMergeBackward(pa, buf, bufoffset, first, middle, last, depth);
                }
                if ((check & 1) != 0) {
                    ssMergeCheckEqual(pa, depth, first);
                }
                if ((check & 2) != 0) {
                    ssMergeCheckEqual(pa, depth, last);
                }
                if (ssize != 0) {
                    ssize--;
                    StackEntry entry = stack[ssize];
                    first = entry.f1001a;
                    middle = entry.f1002b;
                    last = entry.f1003c;
                    check = entry.f1004d;
                } else {
                    return;
                }
            } else if (middle - first <= bufsize) {
                if (first < middle) {
                    ssMergeForward(pa, buf, bufoffset, first, middle, last, depth);
                }
                if ((check & 1) != 0) {
                    ssMergeCheckEqual(pa, depth, first);
                }
                if ((check & 2) != 0) {
                    ssMergeCheckEqual(pa, depth, last);
                }
                if (ssize != 0) {
                    ssize--;
                    StackEntry entry2 = stack[ssize];
                    first = entry2.f1001a;
                    middle = entry2.f1002b;
                    last = entry2.f1003c;
                    check = entry2.f1004d;
                } else {
                    return;
                }
            } else {
                int m = 0;
                int len = Math.min(middle - first, last - middle);
                int i = len;
                while (true) {
                    int half = i >> 1;
                    if (0 >= len) {
                        break;
                    }
                    if (ssCompare(pa + getIDX(SA[middle + m + half]), pa + getIDX(SA[((middle - m) - half) - 1]), depth) < 0) {
                        m += half + 1;
                        half -= (len & 1) ^ 1;
                    }
                    len = half;
                    i = half;
                }
                if (0 < m) {
                    ssBlockSwap(SA, middle - m, SA, middle, m);
                    int j = middle;
                    int i2 = middle;
                    int next = 0;
                    if (middle + m < last) {
                        if (SA[middle + m] < 0) {
                            while (SA[i2 - 1] < 0) {
                                i2--;
                            }
                            SA[middle + m] = SA[middle + m] ^ -1;
                        }
                        j = middle;
                        while (SA[j] < 0) {
                            j++;
                        }
                        next = 1;
                    }
                    if (i2 - first <= last - j) {
                        ssize++;
                        stack[ssize] = new StackEntry(j, middle + m, last, (check & 2) | (next & 1));
                        middle -= m;
                        last = i2;
                        check &= 1;
                    } else {
                        if (i2 == middle && middle == j) {
                            next <<= 1;
                        }
                        ssize++;
                        stack[ssize] = new StackEntry(first, middle - m, i2, (check & 1) | (next & 2));
                        first = j;
                        middle += m;
                        check = (check & 2) | (next & 1);
                    }
                } else {
                    if ((check & 1) != 0) {
                        ssMergeCheckEqual(pa, depth, first);
                    }
                    ssMergeCheckEqual(pa, depth, middle);
                    if ((check & 2) != 0) {
                        ssMergeCheckEqual(pa, depth, last);
                    }
                    if (ssize != 0) {
                        ssize--;
                        StackEntry entry3 = stack[ssize];
                        first = entry3.f1001a;
                        middle = entry3.f1002b;
                        last = entry3.f1003c;
                        check = entry3.f1004d;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void subStringSort(int pa, int first, int last, int[] buf, int bufoffset, int bufsize, int depth, boolean lastsuffix, int size) {
        int[] SA = this.f998SA;
        if (lastsuffix) {
            first++;
        }
        int a = first;
        int i = 0;
        while (a + 1024 < last) {
            ssMultiKeyIntroSort(pa, a, a + 1024, depth);
            int[] curbuf = SA;
            int curbufoffset = a + 1024;
            int curbufsize = last - (a + 1024);
            if (curbufsize <= bufsize) {
                curbufsize = bufsize;
                curbuf = buf;
                curbufoffset = bufoffset;
            }
            int b = a;
            int k = 1024;
            for (int j = i; (j & 1) != 0; j >>>= 1) {
                ssMerge(pa, b - k, b, b + k, curbuf, curbufoffset, curbufsize, depth);
                b -= k;
                k <<= 1;
            }
            a += 1024;
            i++;
        }
        ssMultiKeyIntroSort(pa, a, last, depth);
        int k2 = 1024;
        while (i != 0) {
            if ((i & 1) != 0) {
                ssMerge(pa, a - k2, a, last, buf, bufoffset, bufsize, depth);
                a -= k2;
            }
            k2 <<= 1;
            i >>= 1;
        }
        if (lastsuffix) {
            int a2 = first;
            int i2 = SA[first - 1];
            int r = 1;
            while (a2 < last) {
                if (SA[a2] >= 0) {
                    int ssCompareLast = ssCompareLast(pa, pa + i2, pa + SA[a2], depth, size);
                    r = ssCompareLast;
                    if (0 >= ssCompareLast) {
                        break;
                    }
                }
                SA[a2 - 1] = SA[a2];
                a2++;
            }
            if (r == 0) {
                SA[a2] = SA[a2] ^ -1;
            }
            SA[a2 - 1] = i2;
        }
    }

    private int trGetC(int isa, int isaD, int isaN, int p) {
        return isaD + p < isaN ? this.f998SA[isaD + p] : this.f998SA[isa + (((isaD - isa) + p) % (isaN - isa))];
    }

    private void trFixdown(int isa, int isaD, int isaN, int sa, int i, int size) {
        int[] SA = this.f998SA;
        int v = SA[sa + i];
        int c = trGetC(isa, isaD, isaN, v);
        while (true) {
            int j = (2 * i) + 1;
            if (j >= size) {
                break;
            }
            int j2 = j + 1;
            int k = j;
            int d = trGetC(isa, isaD, isaN, SA[sa + k]);
            int e = trGetC(isa, isaD, isaN, SA[sa + j2]);
            if (d < e) {
                k = j2;
                d = e;
            }
            if (d <= c) {
                break;
            }
            SA[sa + i] = SA[sa + k];
            i = k;
        }
        SA[sa + i] = v;
    }

    private void trHeapSort(int isa, int isaD, int isaN, int sa, int size) {
        int[] SA = this.f998SA;
        int m = size;
        if (size % 2 == 0) {
            m--;
            if (trGetC(isa, isaD, isaN, SA[sa + (m / 2)]) < trGetC(isa, isaD, isaN, SA[sa + m])) {
                swapElements(SA, sa + m, SA, sa + (m / 2));
            }
        }
        for (int i = (m / 2) - 1; 0 <= i; i--) {
            trFixdown(isa, isaD, isaN, sa, i, m);
        }
        if (size % 2 == 0) {
            swapElements(SA, sa, SA, sa + m);
            trFixdown(isa, isaD, isaN, sa, 0, m);
        }
        for (int i2 = m - 1; 0 < i2; i2--) {
            int t = SA[sa];
            SA[sa] = SA[sa + i2];
            trFixdown(isa, isaD, isaN, sa, 0, i2);
            SA[sa + i2] = t;
        }
    }

    private void trInsertionSort(int isa, int isaD, int isaN, int first, int last) {
        int r;
        int[] SA = this.f998SA;
        for (int a = first + 1; a < last; a++) {
            int t = SA[a];
            int b = a - 1;
            do {
                r = trGetC(isa, isaD, isaN, t) - trGetC(isa, isaD, isaN, SA[b]);
                if (0 <= r) {
                    break;
                }
                do {
                    SA[b + 1] = SA[b];
                    b--;
                    if (first > b) {
                        break;
                    }
                } while (SA[b] < 0);
            } while (b >= first);
            if (r == 0) {
                SA[b] = SA[b] ^ -1;
            }
            SA[b + 1] = t;
        }
    }

    private static int trLog(int n) {
        return (n & Opcodes.V_PREVIEW) != 0 ? (n & -16777216) != 0 ? 24 + LOG_2_TABLE[(n >> 24) & 255] : LOG_2_TABLE[(n >> 16) & PacketOpcodes.EnterScenePeerNotify] : (n & 65280) != 0 ? 8 + LOG_2_TABLE[(n >> 8) & 255] : LOG_2_TABLE[n & 255];
    }

    private int trMedian3(int isa, int isaD, int isaN, int v1, int v2, int v3) {
        int[] SA = this.f998SA;
        int SA_v1 = trGetC(isa, isaD, isaN, SA[v1]);
        int SA_v2 = trGetC(isa, isaD, isaN, SA[v2]);
        int SA_v3 = trGetC(isa, isaD, isaN, SA[v3]);
        if (SA_v1 > SA_v2) {
            v1 = v2;
            v2 = v1;
            SA_v1 = SA_v2;
            SA_v2 = SA_v1;
        }
        if (SA_v2 <= SA_v3) {
            return v2;
        }
        if (SA_v1 > SA_v3) {
            return v1;
        }
        return v3;
    }

    private int trMedian5(int isa, int isaD, int isaN, int v1, int v2, int v3, int v4, int v5) {
        int[] SA = this.f998SA;
        int SA_v1 = trGetC(isa, isaD, isaN, SA[v1]);
        int SA_v2 = trGetC(isa, isaD, isaN, SA[v2]);
        int SA_v3 = trGetC(isa, isaD, isaN, SA[v3]);
        int SA_v4 = trGetC(isa, isaD, isaN, SA[v4]);
        int SA_v5 = trGetC(isa, isaD, isaN, SA[v5]);
        if (SA_v2 > SA_v3) {
            v2 = v3;
            v3 = v2;
            SA_v2 = SA_v3;
            SA_v3 = SA_v2;
        }
        if (SA_v4 > SA_v5) {
            v4 = v5;
            v5 = v4;
            SA_v4 = SA_v5;
            SA_v5 = SA_v4;
        }
        if (SA_v2 > SA_v4) {
            v4 = v2;
            SA_v4 = SA_v2;
            v3 = v5;
            v5 = v3;
            SA_v3 = SA_v5;
            SA_v5 = SA_v3;
        }
        if (SA_v1 > SA_v3) {
            v1 = v3;
            v3 = v1;
            SA_v1 = SA_v3;
            SA_v3 = SA_v1;
        }
        if (SA_v1 > SA_v4) {
            v4 = v1;
            SA_v4 = SA_v1;
            v3 = v5;
            SA_v3 = SA_v5;
        }
        if (SA_v3 > SA_v4) {
            return v4;
        }
        return v3;
    }

    private int trPivot(int isa, int isaD, int isaN, int first, int last) {
        int t = last - first;
        int middle = first + (t / 2);
        if (t > 512) {
            int t2 = t >> 3;
            return trMedian3(isa, isaD, isaN, trMedian3(isa, isaD, isaN, first, first + t2, first + (t2 << 1)), trMedian3(isa, isaD, isaN, middle - t2, middle, middle + t2), trMedian3(isa, isaD, isaN, (last - 1) - (t2 << 1), (last - 1) - t2, last - 1));
        } else if (t <= 32) {
            return trMedian3(isa, isaD, isaN, first, middle, last - 1);
        } else {
            int t3 = t >> 2;
            return trMedian5(isa, isaD, isaN, first, first + t3, middle, (last - 1) - t3, last - 1);
        }
    }

    private void lsUpdateGroup(int isa, int first, int last) {
        int[] SA = this.f998SA;
        int a = first;
        while (a < last) {
            if (0 <= SA[a]) {
                do {
                    SA[isa + SA[a]] = a;
                    a++;
                    if (a >= last) {
                        break;
                    }
                } while (0 <= SA[a]);
                SA[a] = a - a;
                if (last <= a) {
                    return;
                }
            }
            int b = a;
            do {
                SA[a] = SA[a] ^ -1;
                a++;
            } while (SA[a] < 0);
            do {
                SA[isa + SA[b]] = a;
                b++;
            } while (b <= a);
            a++;
        }
    }

    private void lsIntroSort(int isa, int isaD, int isaN, int first, int last) {
        int b;
        int[] SA = this.f998SA;
        StackEntry[] stack = new StackEntry[64];
        int x = 0;
        int ssize = 0;
        int limit = trLog(last - first);
        while (true) {
            if (last - first <= 8) {
                if (1 < last - first) {
                    trInsertionSort(isa, isaD, isaN, first, last);
                    lsUpdateGroup(isa, first, last);
                } else if (last - first == 1) {
                    SA[first] = -1;
                }
                if (ssize != 0) {
                    ssize--;
                    StackEntry entry = stack[ssize];
                    first = entry.f1001a;
                    last = entry.f1002b;
                    limit = entry.f1003c;
                } else {
                    return;
                }
            } else {
                limit--;
                if (limit == 0) {
                    trHeapSort(isa, isaD, isaN, first, last - first);
                    for (int a = last - 1; first < a; a = b) {
                        x = trGetC(isa, isaD, isaN, SA[a]);
                        b = a - 1;
                        while (first <= b && trGetC(isa, isaD, isaN, SA[b]) == x) {
                            SA[b] = SA[b] ^ -1;
                            b--;
                        }
                    }
                    lsUpdateGroup(isa, first, last);
                    if (ssize != 0) {
                        ssize--;
                        StackEntry entry2 = stack[ssize];
                        first = entry2.f1001a;
                        last = entry2.f1002b;
                        limit = entry2.f1003c;
                    } else {
                        return;
                    }
                } else {
                    swapElements(SA, first, SA, trPivot(isa, isaD, isaN, first, last));
                    int v = trGetC(isa, isaD, isaN, SA[first]);
                    int b2 = first + 1;
                    while (b2 < last) {
                        int trGetC = trGetC(isa, isaD, isaN, SA[b2]);
                        x = trGetC;
                        if (trGetC != v) {
                            break;
                        }
                        b2++;
                    }
                    int a2 = b2;
                    if (b2 < last && x < v) {
                        while (true) {
                            b2++;
                            if (b2 >= last) {
                                break;
                            }
                            int trGetC2 = trGetC(isa, isaD, isaN, SA[b2]);
                            x = trGetC2;
                            if (trGetC2 > v) {
                                break;
                            } else if (x == v) {
                                swapElements(SA, b2, SA, a2);
                                a2++;
                            }
                        }
                    }
                    int c = last - 1;
                    while (b2 < c) {
                        int trGetC3 = trGetC(isa, isaD, isaN, SA[c]);
                        x = trGetC3;
                        if (trGetC3 != v) {
                            break;
                        }
                        c--;
                    }
                    int d = c;
                    if (b2 < c && x > v) {
                        while (true) {
                            c--;
                            if (b2 >= c) {
                                break;
                            }
                            int trGetC4 = trGetC(isa, isaD, isaN, SA[c]);
                            x = trGetC4;
                            if (trGetC4 < v) {
                                break;
                            } else if (x == v) {
                                swapElements(SA, c, SA, d);
                                d--;
                            }
                        }
                    }
                    while (b2 < c) {
                        swapElements(SA, b2, SA, c);
                        while (true) {
                            b2++;
                            if (b2 >= c) {
                                break;
                            }
                            int trGetC5 = trGetC(isa, isaD, isaN, SA[b2]);
                            x = trGetC5;
                            if (trGetC5 > v) {
                                break;
                            } else if (x == v) {
                                swapElements(SA, b2, SA, a2);
                                a2++;
                            }
                        }
                        while (true) {
                            c--;
                            if (b2 < c) {
                                int trGetC6 = trGetC(isa, isaD, isaN, SA[c]);
                                x = trGetC6;
                                if (trGetC6 >= v) {
                                    if (x == v) {
                                        swapElements(SA, c, SA, d);
                                        d--;
                                    }
                                }
                            }
                        }
                    }
                    if (a2 <= d) {
                        int c2 = b2 - 1;
                        int i = a2 - first;
                        int s = i;
                        int t = b2 - a2;
                        if (i > t) {
                            s = t;
                        }
                        int e = first;
                        int f = b2 - s;
                        while (0 < s) {
                            swapElements(SA, e, SA, f);
                            s--;
                            e++;
                            f++;
                        }
                        int i2 = d - c2;
                        int s2 = i2;
                        int t2 = (last - d) - 1;
                        if (i2 > t2) {
                            s2 = t2;
                        }
                        int e2 = b2;
                        int f2 = last - s2;
                        while (0 < s2) {
                            swapElements(SA, e2, SA, f2);
                            s2--;
                            e2++;
                            f2++;
                        }
                        int a3 = first + (b2 - a2);
                        int b3 = last - (d - c2);
                        int v2 = a3 - 1;
                        for (int c3 = first; c3 < a3; c3++) {
                            SA[isa + SA[c3]] = v2;
                        }
                        if (b3 < last) {
                            int v3 = b3 - 1;
                            for (int c4 = a3; c4 < b3; c4++) {
                                SA[isa + SA[c4]] = v3;
                            }
                        }
                        if (b3 - a3 == 1) {
                            SA[a3] = -1;
                        }
                        if (a3 - first <= last - b3) {
                            if (first < a3) {
                                ssize++;
                                stack[ssize] = new StackEntry(b3, last, limit, 0);
                                last = a3;
                            } else {
                                first = b3;
                            }
                        } else if (b3 < last) {
                            ssize++;
                            stack[ssize] = new StackEntry(first, a3, limit, 0);
                            first = b3;
                        } else {
                            last = a3;
                        }
                    } else if (ssize != 0) {
                        ssize--;
                        StackEntry entry3 = stack[ssize];
                        first = entry3.f1001a;
                        last = entry3.f1002b;
                        limit = entry3.f1003c;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void lsSort(int isa, int n, int depth) {
        int[] SA = this.f998SA;
        int i = isa;
        int i2 = depth;
        while (true) {
            int isaD = i + i2;
            if ((-n) < SA[0]) {
                int first = 0;
                int skip = 0;
                do {
                    int t = SA[first];
                    if (t < 0) {
                        first -= t;
                        skip += t;
                    } else {
                        if (skip != 0) {
                            SA[first + skip] = skip;
                            skip = 0;
                        }
                        int last = SA[isa + t] + 1;
                        lsIntroSort(isa, isaD, isa + n, first, last);
                        first = last;
                    }
                } while (first < n);
                if (skip != 0) {
                    SA[first + skip] = skip;
                }
                if (n < isaD - isa) {
                    int first2 = 0;
                    do {
                        int t2 = SA[first2];
                        if (t2 < 0) {
                            first2 -= t2;
                        } else {
                            int last2 = SA[isa + t2] + 1;
                            for (int i3 = first2; i3 < last2; i3++) {
                                SA[isa + SA[i3]] = i3;
                            }
                            first2 = last2;
                        }
                    } while (first2 < n);
                    return;
                }
                i = isaD;
                i2 = isaD - isa;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.codec.compression.Bzip2DivSufSort$PartitionResult */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2DivSufSort$PartitionResult.class */
    public static class PartitionResult {
        final int first;
        final int last;

        PartitionResult(int first, int last) {
            this.first = first;
            this.last = last;
        }
    }

    private PartitionResult trPartition(int isa, int isaD, int isaN, int first, int last, int v) {
        int x;
        int x2;
        int x3;
        int[] SA = this.f998SA;
        int x4 = 0;
        int b = first;
        while (b < last) {
            int trGetC = trGetC(isa, isaD, isaN, SA[b]);
            x4 = trGetC;
            if (trGetC != v) {
                break;
            }
            b++;
        }
        int a = b;
        if (b < last && x4 < v) {
            while (true) {
                b++;
                if (b >= last) {
                    break;
                }
                int trGetC2 = trGetC(isa, isaD, isaN, SA[b]);
                x4 = trGetC2;
                if (trGetC2 > v) {
                    break;
                } else if (x4 == v) {
                    swapElements(SA, b, SA, a);
                    a++;
                }
            }
        }
        int c = last - 1;
        while (b < c) {
            int trGetC3 = trGetC(isa, isaD, isaN, SA[c]);
            x4 = trGetC3;
            if (trGetC3 != v) {
                break;
            }
            c--;
        }
        int d = c;
        if (b < c && x4 > v) {
            while (true) {
                c--;
                if (b >= c || (x3 = trGetC(isa, isaD, isaN, SA[c])) < v) {
                    break;
                } else if (x3 == v) {
                    swapElements(SA, c, SA, d);
                    d--;
                }
            }
        }
        while (b < c) {
            swapElements(SA, b, SA, c);
            while (true) {
                b++;
                if (b >= c || (x2 = trGetC(isa, isaD, isaN, SA[b])) > v) {
                    break;
                } else if (x2 == v) {
                    swapElements(SA, b, SA, a);
                    a++;
                }
            }
            while (true) {
                c--;
                if (b < c && (x = trGetC(isa, isaD, isaN, SA[c])) >= v) {
                    if (x == v) {
                        swapElements(SA, c, SA, d);
                        d--;
                    }
                }
            }
        }
        if (a <= d) {
            int c2 = b - 1;
            int i = a - first;
            int s = i;
            int t = b - a;
            if (i > t) {
                s = t;
            }
            int e = first;
            int f = b - s;
            while (0 < s) {
                swapElements(SA, e, SA, f);
                s--;
                e++;
                f++;
            }
            int i2 = d - c2;
            int s2 = i2;
            int t2 = (last - d) - 1;
            if (i2 > t2) {
                s2 = t2;
            }
            int e2 = b;
            int f2 = last - s2;
            while (0 < s2) {
                swapElements(SA, e2, SA, f2);
                s2--;
                e2++;
                f2++;
            }
            first += b - a;
            last -= d - c2;
        }
        return new PartitionResult(first, last);
    }

    private void trCopy(int isa, int isaN, int first, int a, int b, int last, int depth) {
        int[] SA = this.f998SA;
        int v = b - 1;
        int d = a - 1;
        for (int c = first; c <= d; c++) {
            int i = SA[c] - depth;
            int s = i;
            if (i < 0) {
                s += isaN - isa;
            }
            if (SA[isa + s] == v) {
                d++;
                SA[d] = s;
                SA[isa + s] = d;
            }
        }
        int c2 = last - 1;
        int e = d + 1;
        int d2 = b;
        while (e < d2) {
            int i2 = SA[c2] - depth;
            int s2 = i2;
            if (i2 < 0) {
                s2 += isaN - isa;
            }
            if (SA[isa + s2] == v) {
                d2--;
                SA[d2] = s2;
                SA[isa + s2] = d2;
            }
            c2--;
        }
    }

    private void trIntroSort(int isa, int isaD, int isaN, int first, int last, TRBudget budget, int size) {
        int b;
        int[] SA = this.f998SA;
        StackEntry[] stack = new StackEntry[64];
        int x = 0;
        int ssize = 0;
        int limit = trLog(last - first);
        while (true) {
            if (limit < 0) {
                if (limit == -1) {
                    if (!budget.update(size, last - first)) {
                        break;
                    }
                    PartitionResult result = trPartition(isa, isaD - 1, isaN, first, last, last - 1);
                    int a = result.first;
                    int b2 = result.last;
                    if (first < a || b2 < last) {
                        if (a < last) {
                            int v = a - 1;
                            for (int c = first; c < a; c++) {
                                SA[isa + SA[c]] = v;
                            }
                        }
                        if (b2 < last) {
                            int v2 = b2 - 1;
                            for (int c2 = a; c2 < b2; c2++) {
                                SA[isa + SA[c2]] = v2;
                            }
                        }
                        int ssize2 = ssize + 1;
                        stack[ssize] = new StackEntry(0, a, b2, 0);
                        ssize = ssize2 + 1;
                        stack[ssize2] = new StackEntry(isaD - 1, first, last, -2);
                        if (a - first <= last - b2) {
                            if (1 < a - first) {
                                ssize++;
                                stack[ssize] = new StackEntry(isaD, b2, last, trLog(last - b2));
                                last = a;
                                limit = trLog(a - first);
                            } else if (1 < last - b2) {
                                first = b2;
                                limit = trLog(last - b2);
                            } else if (ssize != 0) {
                                ssize--;
                                StackEntry entry = stack[ssize];
                                isaD = entry.f1001a;
                                first = entry.f1002b;
                                last = entry.f1003c;
                                limit = entry.f1004d;
                            } else {
                                return;
                            }
                        } else if (1 < last - b2) {
                            ssize++;
                            stack[ssize] = new StackEntry(isaD, first, a, trLog(a - first));
                            first = b2;
                            limit = trLog(last - b2);
                        } else if (1 < a - first) {
                            last = a;
                            limit = trLog(a - first);
                        } else if (ssize != 0) {
                            ssize--;
                            StackEntry entry2 = stack[ssize];
                            isaD = entry2.f1001a;
                            first = entry2.f1002b;
                            last = entry2.f1003c;
                            limit = entry2.f1004d;
                        } else {
                            return;
                        }
                    } else {
                        for (int c3 = first; c3 < last; c3++) {
                            SA[isa + SA[c3]] = c3;
                        }
                        if (ssize != 0) {
                            ssize--;
                            StackEntry entry3 = stack[ssize];
                            isaD = entry3.f1001a;
                            first = entry3.f1002b;
                            last = entry3.f1003c;
                            limit = entry3.f1004d;
                        } else {
                            return;
                        }
                    }
                } else if (limit == -2) {
                    int ssize3 = ssize - 1;
                    trCopy(isa, isaN, first, stack[ssize3].f1002b, stack[ssize3].f1003c, last, isaD - isa);
                    if (ssize3 != 0) {
                        ssize = ssize3 - 1;
                        StackEntry entry4 = stack[ssize];
                        isaD = entry4.f1001a;
                        first = entry4.f1002b;
                        last = entry4.f1003c;
                        limit = entry4.f1004d;
                    } else {
                        return;
                    }
                } else {
                    if (0 <= SA[first]) {
                        int a2 = first;
                        do {
                            SA[isa + SA[a2]] = a2;
                            a2++;
                            if (a2 >= last) {
                                break;
                            }
                        } while (0 <= SA[a2]);
                        first = a2;
                    }
                    if (first < last) {
                        int a3 = first;
                        do {
                            SA[a3] = SA[a3] ^ -1;
                            a3++;
                        } while (SA[a3] < 0);
                        int next = SA[isa + SA[a3]] != SA[isaD + SA[a3]] ? trLog((a3 - first) + 1) : -1;
                        int a4 = a3 + 1;
                        if (a4 < last) {
                            int v3 = a4 - 1;
                            for (int b3 = first; b3 < a4; b3++) {
                                SA[isa + SA[b3]] = v3;
                            }
                        }
                        if (a4 - first <= last - a4) {
                            ssize++;
                            stack[ssize] = new StackEntry(isaD, a4, last, -3);
                            isaD++;
                            last = a4;
                            limit = next;
                        } else if (1 < last - a4) {
                            ssize++;
                            stack[ssize] = new StackEntry(isaD + 1, first, a4, next);
                            first = a4;
                            limit = -3;
                        } else {
                            isaD++;
                            last = a4;
                            limit = next;
                        }
                    } else if (ssize != 0) {
                        ssize--;
                        StackEntry entry5 = stack[ssize];
                        isaD = entry5.f1001a;
                        first = entry5.f1002b;
                        last = entry5.f1003c;
                        limit = entry5.f1004d;
                    } else {
                        return;
                    }
                }
            } else if (last - first > 8) {
                limit--;
                if (limit != 0) {
                    swapElements(SA, first, SA, trPivot(isa, isaD, isaN, first, last));
                    int v4 = trGetC(isa, isaD, isaN, SA[first]);
                    int b4 = first + 1;
                    while (b4 < last) {
                        int trGetC = trGetC(isa, isaD, isaN, SA[b4]);
                        x = trGetC;
                        if (trGetC != v4) {
                            break;
                        }
                        b4++;
                    }
                    int a5 = b4;
                    if (b4 < last && x < v4) {
                        while (true) {
                            b4++;
                            if (b4 >= last) {
                                break;
                            }
                            int trGetC2 = trGetC(isa, isaD, isaN, SA[b4]);
                            x = trGetC2;
                            if (trGetC2 > v4) {
                                break;
                            } else if (x == v4) {
                                swapElements(SA, b4, SA, a5);
                                a5++;
                            }
                        }
                    }
                    int c4 = last - 1;
                    while (b4 < c4) {
                        int trGetC3 = trGetC(isa, isaD, isaN, SA[c4]);
                        x = trGetC3;
                        if (trGetC3 != v4) {
                            break;
                        }
                        c4--;
                    }
                    int d = c4;
                    if (b4 < c4 && x > v4) {
                        while (true) {
                            c4--;
                            if (b4 >= c4) {
                                break;
                            }
                            int trGetC4 = trGetC(isa, isaD, isaN, SA[c4]);
                            x = trGetC4;
                            if (trGetC4 < v4) {
                                break;
                            } else if (x == v4) {
                                swapElements(SA, c4, SA, d);
                                d--;
                            }
                        }
                    }
                    while (b4 < c4) {
                        swapElements(SA, b4, SA, c4);
                        while (true) {
                            b4++;
                            if (b4 >= c4) {
                                break;
                            }
                            int trGetC5 = trGetC(isa, isaD, isaN, SA[b4]);
                            x = trGetC5;
                            if (trGetC5 > v4) {
                                break;
                            } else if (x == v4) {
                                swapElements(SA, b4, SA, a5);
                                a5++;
                            }
                        }
                        while (true) {
                            c4--;
                            if (b4 < c4) {
                                int trGetC6 = trGetC(isa, isaD, isaN, SA[c4]);
                                x = trGetC6;
                                if (trGetC6 >= v4) {
                                    if (x == v4) {
                                        swapElements(SA, c4, SA, d);
                                        d--;
                                    }
                                }
                            }
                        }
                    }
                    if (a5 <= d) {
                        int c5 = b4 - 1;
                        int i = a5 - first;
                        int s = i;
                        int t = b4 - a5;
                        if (i > t) {
                            s = t;
                        }
                        int e = first;
                        int f = b4 - s;
                        while (0 < s) {
                            swapElements(SA, e, SA, f);
                            s--;
                            e++;
                            f++;
                        }
                        int i2 = d - c5;
                        int s2 = i2;
                        int t2 = (last - d) - 1;
                        if (i2 > t2) {
                            s2 = t2;
                        }
                        int e2 = b4;
                        int f2 = last - s2;
                        while (0 < s2) {
                            swapElements(SA, e2, SA, f2);
                            s2--;
                            e2++;
                            f2++;
                        }
                        int a6 = first + (b4 - a5);
                        int b5 = last - (d - c5);
                        int next2 = SA[isa + SA[a6]] != v4 ? trLog(b5 - a6) : -1;
                        int v5 = a6 - 1;
                        for (int c6 = first; c6 < a6; c6++) {
                            SA[isa + SA[c6]] = v5;
                        }
                        if (b5 < last) {
                            int v6 = b5 - 1;
                            for (int c7 = a6; c7 < b5; c7++) {
                                SA[isa + SA[c7]] = v6;
                            }
                        }
                        if (a6 - first <= last - b5) {
                            if (last - b5 <= b5 - a6) {
                                if (1 < a6 - first) {
                                    int ssize4 = ssize + 1;
                                    stack[ssize] = new StackEntry(isaD + 1, a6, b5, next2);
                                    ssize = ssize4 + 1;
                                    stack[ssize4] = new StackEntry(isaD, b5, last, limit);
                                    last = a6;
                                } else if (1 < last - b5) {
                                    ssize++;
                                    stack[ssize] = new StackEntry(isaD + 1, a6, b5, next2);
                                    first = b5;
                                } else if (1 < b5 - a6) {
                                    isaD++;
                                    first = a6;
                                    last = b5;
                                    limit = next2;
                                } else if (ssize != 0) {
                                    ssize--;
                                    StackEntry entry6 = stack[ssize];
                                    isaD = entry6.f1001a;
                                    first = entry6.f1002b;
                                    last = entry6.f1003c;
                                    limit = entry6.f1004d;
                                } else {
                                    return;
                                }
                            } else if (a6 - first <= b5 - a6) {
                                if (1 < a6 - first) {
                                    int ssize5 = ssize + 1;
                                    stack[ssize] = new StackEntry(isaD, b5, last, limit);
                                    ssize = ssize5 + 1;
                                    stack[ssize5] = new StackEntry(isaD + 1, a6, b5, next2);
                                    last = a6;
                                } else if (1 < b5 - a6) {
                                    ssize++;
                                    stack[ssize] = new StackEntry(isaD, b5, last, limit);
                                    isaD++;
                                    first = a6;
                                    last = b5;
                                    limit = next2;
                                } else {
                                    first = b5;
                                }
                            } else if (1 < b5 - a6) {
                                int ssize6 = ssize + 1;
                                stack[ssize] = new StackEntry(isaD, b5, last, limit);
                                ssize = ssize6 + 1;
                                stack[ssize6] = new StackEntry(isaD, first, a6, limit);
                                isaD++;
                                first = a6;
                                last = b5;
                                limit = next2;
                            } else {
                                ssize++;
                                stack[ssize] = new StackEntry(isaD, b5, last, limit);
                                last = a6;
                            }
                        } else if (a6 - first <= b5 - a6) {
                            if (1 < last - b5) {
                                int ssize7 = ssize + 1;
                                stack[ssize] = new StackEntry(isaD + 1, a6, b5, next2);
                                ssize = ssize7 + 1;
                                stack[ssize7] = new StackEntry(isaD, first, a6, limit);
                                first = b5;
                            } else if (1 < a6 - first) {
                                ssize++;
                                stack[ssize] = new StackEntry(isaD + 1, a6, b5, next2);
                                last = a6;
                            } else if (1 < b5 - a6) {
                                isaD++;
                                first = a6;
                                last = b5;
                                limit = next2;
                            } else {
                                ssize++;
                                stack[ssize] = new StackEntry(isaD, first, last, limit);
                            }
                        } else if (last - b5 <= b5 - a6) {
                            if (1 < last - b5) {
                                int ssize8 = ssize + 1;
                                stack[ssize] = new StackEntry(isaD, first, a6, limit);
                                ssize = ssize8 + 1;
                                stack[ssize8] = new StackEntry(isaD + 1, a6, b5, next2);
                                first = b5;
                            } else if (1 < b5 - a6) {
                                ssize++;
                                stack[ssize] = new StackEntry(isaD, first, a6, limit);
                                isaD++;
                                first = a6;
                                last = b5;
                                limit = next2;
                            } else {
                                last = a6;
                            }
                        } else if (1 < b5 - a6) {
                            int ssize9 = ssize + 1;
                            stack[ssize] = new StackEntry(isaD, first, a6, limit);
                            ssize = ssize9 + 1;
                            stack[ssize9] = new StackEntry(isaD, b5, last, limit);
                            isaD++;
                            first = a6;
                            last = b5;
                            limit = next2;
                        } else {
                            ssize++;
                            stack[ssize] = new StackEntry(isaD, first, a6, limit);
                            first = b5;
                        }
                    } else if (!budget.update(size, last - first)) {
                        break;
                    } else {
                        limit++;
                        isaD++;
                    }
                } else if (!budget.update(size, last - first)) {
                    break;
                } else {
                    trHeapSort(isa, isaD, isaN, first, last - first);
                    for (int a7 = last - 1; first < a7; a7 = b) {
                        x = trGetC(isa, isaD, isaN, SA[a7]);
                        b = a7 - 1;
                        while (first <= b && trGetC(isa, isaD, isaN, SA[b]) == x) {
                            SA[b] = SA[b] ^ -1;
                            b--;
                        }
                    }
                    limit = -3;
                }
            } else if (!budget.update(size, last - first)) {
                break;
            } else {
                trInsertionSort(isa, isaD, isaN, first, last);
                limit = -3;
            }
        }
        for (int s3 = 0; s3 < ssize; s3++) {
            if (stack[s3].f1004d == -3) {
                lsUpdateGroup(isa, stack[s3].f1002b, stack[s3].f1003c);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.codec.compression.Bzip2DivSufSort$TRBudget */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2DivSufSort$TRBudget.class */
    public static class TRBudget {
        int budget;
        int chance;

        TRBudget(int budget, int chance) {
            this.budget = budget;
            this.chance = chance;
        }

        boolean update(int size, int n) {
            this.budget -= n;
            if (this.budget > 0) {
                return true;
            }
            int i = this.chance - 1;
            this.chance = i;
            if (i == 0) {
                return false;
            }
            this.budget += size;
            return true;
        }
    }

    private void trSort(int isa, int n, int depth) {
        int[] SA = this.f998SA;
        int first = 0;
        if ((-n) < SA[0]) {
            TRBudget budget = new TRBudget(n, ((trLog(n) * 2) / 3) + 1);
            do {
                int t = SA[first];
                if (t < 0) {
                    first -= t;
                } else {
                    int last = SA[isa + t] + 1;
                    if (1 < last - first) {
                        trIntroSort(isa, isa + depth, isa + n, first, last, budget, n);
                        if (budget.chance == 0) {
                            if (0 < first) {
                                SA[0] = -first;
                            }
                            lsSort(isa, n, depth);
                            return;
                        }
                    }
                    first = last;
                }
            } while (first < n);
        }
    }

    private static int BUCKET_B(int c0, int c1) {
        return (c1 << 8) | c0;
    }

    private static int BUCKET_BSTAR(int c0, int c1) {
        return (c0 << 8) | c1;
    }

    private int sortTypeBstar(int[] bucketA, int[] bucketB) {
        int ti;
        int ti1;
        int ti2;
        int ti12;
        byte[] T = this.f999T;
        int[] SA = this.f998SA;
        int n = this.f1000n;
        int[] tempbuf = new int[256];
        int i = 1;
        int flag = 1;
        while (true) {
            if (i >= n) {
                break;
            } else if (T[i - 1] == T[i]) {
                i++;
            } else if ((T[i - 1] & 255) > (T[i] & 255)) {
                flag = 0;
            }
        }
        int i2 = n - 1;
        int m = n;
        int ti3 = T[i2] & 255;
        int t0 = T[0] & 255;
        if (ti3 < t0 || (T[i2] == T[0] && flag != 0)) {
            if (flag == 0) {
                int BUCKET_BSTAR = BUCKET_BSTAR(ti3, t0);
                bucketB[BUCKET_BSTAR] = bucketB[BUCKET_BSTAR] + 1;
                m--;
                SA[m] = i2;
            } else {
                int BUCKET_B = BUCKET_B(ti3, t0);
                bucketB[BUCKET_B] = bucketB[BUCKET_B] + 1;
            }
            while (true) {
                i2--;
                if (0 > i2 || (ti2 = T[i2] & 255) > (ti12 = T[i2 + 1] & 255)) {
                    break;
                }
                int BUCKET_B2 = BUCKET_B(ti2, ti12);
                bucketB[BUCKET_B2] = bucketB[BUCKET_B2] + 1;
            }
        }
        while (0 <= i2) {
            do {
                int i3 = T[i2] & 255;
                bucketA[i3] = bucketA[i3] + 1;
                i2--;
                if (0 > i2) {
                    break;
                }
            } while ((T[i2] & 255) >= (T[i2 + 1] & 255));
            if (0 <= i2) {
                int BUCKET_BSTAR2 = BUCKET_BSTAR(T[i2] & 255, T[i2 + 1] & 255);
                bucketB[BUCKET_BSTAR2] = bucketB[BUCKET_BSTAR2] + 1;
                m--;
                SA[m] = i2;
                while (true) {
                    i2--;
                    if (0 <= i2 && (ti = T[i2] & 255) <= (ti1 = T[i2 + 1] & 255)) {
                        int BUCKET_B3 = BUCKET_B(ti, ti1);
                        bucketB[BUCKET_B3] = bucketB[BUCKET_B3] + 1;
                    }
                }
            }
        }
        int m2 = n - m;
        if (m2 == 0) {
            for (int i4 = 0; i4 < n; i4++) {
                SA[i4] = i4;
            }
            return 0;
        }
        int i5 = -1;
        int j = 0;
        for (int c0 = 0; c0 < 256; c0++) {
            bucketA[c0] = i5 + j;
            i5 = i5 + bucketA[c0] + bucketB[BUCKET_B(c0, c0)];
            for (int c1 = c0 + 1; c1 < 256; c1++) {
                j += bucketB[BUCKET_BSTAR(c0, c1)];
                bucketB[(c0 << 8) | c1] = j;
                i5 += bucketB[BUCKET_B(c0, c1)];
            }
        }
        int PAb = n - m2;
        for (int i6 = m2 - 2; 0 <= i6; i6--) {
            int t = SA[PAb + i6];
            int BUCKET_BSTAR3 = BUCKET_BSTAR(T[t] & 255, T[t + 1] & 255);
            int i7 = bucketB[BUCKET_BSTAR3] - 1;
            bucketB[BUCKET_BSTAR3] = i7;
            SA[i7] = i6;
        }
        int t2 = SA[(PAb + m2) - 1];
        int BUCKET_BSTAR4 = BUCKET_BSTAR(T[t2] & 255, T[t2 + 1] & 255);
        int i8 = bucketB[BUCKET_BSTAR4] - 1;
        bucketB[BUCKET_BSTAR4] = i8;
        SA[i8] = m2 - 1;
        int[] buf = SA;
        int bufoffset = m2;
        int bufsize = n - (2 * m2);
        if (bufsize <= 256) {
            buf = tempbuf;
            bufoffset = 0;
            bufsize = 256;
        }
        int c02 = 255;
        int j2 = m2;
        while (0 < j2) {
            for (int c12 = 255; c02 < c12; c12--) {
                int i9 = bucketB[BUCKET_BSTAR(c02, c12)];
                if (1 < j2 - i9) {
                    subStringSort(PAb, i9, j2, buf, bufoffset, bufsize, 2, SA[i9] == m2 - 1, n);
                }
                j2 = i9;
            }
            c02--;
        }
        int i10 = m2 - 1;
        while (0 <= i10) {
            if (0 <= SA[i10]) {
                do {
                    SA[m2 + SA[i10]] = i10;
                    i10--;
                    if (0 > i10) {
                        break;
                    }
                } while (0 <= SA[i10]);
                SA[i10 + 1] = i10 - i10;
                if (i10 <= 0) {
                    break;
                }
            }
            do {
                int i11 = SA[i10] ^ -1;
                SA[i10] = i11;
                SA[m2 + i11] = i10;
                i10--;
            } while (SA[i10] < 0);
            SA[m2 + SA[i10]] = i10;
            i10--;
        }
        trSort(m2, m2, 1);
        int i12 = n - 1;
        int j3 = m2;
        if ((T[i12] & 255) < (T[0] & 255) || (T[i12] == T[0] && flag != 0)) {
            if (flag == 0) {
                j3--;
                SA[SA[m2 + j3]] = i12;
            }
            while (true) {
                i12--;
                if (0 > i12 || (T[i12] & 255) > (T[i12 + 1] & 255)) {
                    break;
                }
            }
        }
        while (0 <= i12) {
            while (true) {
                i12--;
                if (0 > i12 || (T[i12] & 255) < (T[i12 + 1] & 255)) {
                    break;
                }
            }
            if (0 <= i12) {
                j3--;
                SA[SA[m2 + j3]] = i12;
                while (true) {
                    i12--;
                    if (0 <= i12 && (T[i12] & 255) <= (T[i12 + 1] & 255)) {
                    }
                }
            }
        }
        int i13 = n - 1;
        int k = m2 - 1;
        for (int c03 = 255; 0 <= c03; c03--) {
            for (int c13 = 255; c03 < c13; c13--) {
                int t3 = i13 - bucketB[BUCKET_B(c03, c13)];
                bucketB[BUCKET_B(c03, c13)] = i13 + 1;
                i13 = t3;
                int j4 = bucketB[BUCKET_BSTAR(c03, c13)];
                while (j4 <= k) {
                    SA[i13] = SA[k];
                    i13--;
                    k--;
                }
            }
            int t4 = i13 - bucketB[BUCKET_B(c03, c03)];
            bucketB[BUCKET_B(c03, c03)] = i13 + 1;
            if (c03 < 255) {
                bucketB[BUCKET_BSTAR(c03, c03 + 1)] = t4 + 1;
            }
            i13 = bucketA[c03];
        }
        return m2;
    }

    /* JADX INFO: Multiple debug info for r1v33 int: [D('s1' int), D('s' int)] */
    private int constructBWT(int[] bucketA, int[] bucketB) {
        byte[] T = this.f999T;
        int[] SA = this.f998SA;
        int n = this.f1000n;
        int t = 0;
        int c2 = 0;
        int orig = -1;
        for (int c1 = 254; 0 <= c1; c1--) {
            int i = bucketB[BUCKET_BSTAR(c1, c1 + 1)];
            t = 0;
            c2 = -1;
            for (int j = bucketA[c1 + 1]; i <= j; j--) {
                int s = SA[j];
                if (0 <= s) {
                    int s2 = s - 1;
                    if (s2 < 0) {
                        s2 = n - 1;
                    }
                    int c0 = (T[s2] == 1 ? 1 : 0) & 255;
                    if (c0 <= c1) {
                        SA[j] = s ^ -1;
                        if (0 < s2 && ((T[s2 - 1] == 1 ? 1 : 0) & 255) > c0) {
                            s2 ^= -1;
                        }
                        if (c2 == c0) {
                            t--;
                            SA[t] = s2;
                        } else {
                            if (0 <= c2) {
                                bucketB[BUCKET_B(c2, c1)] = t;
                            }
                            c2 = c0;
                            int i2 = bucketB[BUCKET_B(c0, c1)] - 1;
                            t = i2;
                            SA[i2] = s2;
                        }
                    }
                } else {
                    SA[j] = s ^ -1;
                }
            }
        }
        for (int i3 = 0; i3 < n; i3++) {
            int s3 = SA[i3];
            int s1 = s3;
            if (0 <= s3) {
                int s4 = s3 - 1;
                if (s4 < 0) {
                    s4 = n - 1;
                }
                int c02 = (T[s4] == 1 ? 1 : 0) & 255;
                if (c02 >= ((T[s4 + 1] == 1 ? 1 : 0) & 255)) {
                    if (0 < s4 && ((T[s4 - 1] == 1 ? 1 : 0) & 255) < c02) {
                        s4 ^= -1;
                    }
                    if (c02 == c2) {
                        t++;
                        SA[t] = s4;
                    } else {
                        if (c2 != -1) {
                            bucketA[c2] = t;
                        }
                        c2 = c02;
                        int i4 = bucketA[c02] + 1;
                        t = i4;
                        SA[i4] = s4;
                    }
                }
            } else {
                s1 ^= -1;
            }
            if (s1 == 0) {
                SA[i3] = T[n - 1] == 1 ? 1 : 0;
                orig = i3;
            } else {
                SA[i3] = T[s1 - 1] == 1 ? 1 : 0;
            }
        }
        return orig;
    }

    public int bwt() {
        int[] SA = this.f998SA;
        byte[] T = this.f999T;
        int n = this.f1000n;
        int[] bucketA = new int[256];
        int[] bucketB = new int[65536];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            SA[0] = T[0] == 1 ? 1 : 0;
            return 0;
        } else if (0 < sortTypeBstar(bucketA, bucketB)) {
            return constructBWT(bucketA, bucketB);
        } else {
            return 0;
        }
    }
}
