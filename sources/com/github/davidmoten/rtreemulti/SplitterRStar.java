package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.guavamini.annotations.VisibleForTesting;
import com.github.davidmoten.rtreemulti.geometry.HasGeometry;
import com.github.davidmoten.rtreemulti.geometry.ListPair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/SplitterRStar.class */
public final class SplitterRStar implements Splitter {
    private final Comparator<ListPair<?>> comparator = new Comparator<ListPair<?>>() { // from class: com.github.davidmoten.rtreemulti.SplitterRStar.1
        public int compare(ListPair<?> p1, ListPair<?> p2) {
            int value = Double.compare(SplitterRStar.overlap(p1), SplitterRStar.overlap(p2));
            if (value == 0) {
                return Double.compare(p1.volumeSum(), p2.volumeSum());
            }
            return value;
        }
    };
    public static final SplitterRStar INSTANCE = new SplitterRStar();
    private static final boolean[] BOOLEANS = {false, true};

    private SplitterRStar() {
    }

    /* JADX WARN: Type inference failed for: r0v23, types: [double] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.github.davidmoten.rtreemulti.Splitter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.github.davidmoten.rtreemulti.geometry.HasGeometry> com.github.davidmoten.rtreemulti.geometry.ListPair<T> split(java.util.List<T> r6, int r7) {
        /*
            r5 = this;
            r0 = r6
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            com.github.davidmoten.guavamini.Preconditions.checkArgument(r0)
            r0 = 0
            r8 = r0
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r9 = r0
            r0 = 0
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x001e:
            r0 = r12
            r1 = r6
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.github.davidmoten.rtreemulti.geometry.HasGeometry r1 = (com.github.davidmoten.rtreemulti.geometry.HasGeometry) r1
            com.github.davidmoten.rtreemulti.geometry.Geometry r1 = r1.geometry()
            int r1 = r1.dimensions()
            if (r0 >= r1) goto L_0x009a
            boolean[] r0 = com.github.davidmoten.rtreemulti.SplitterRStar.BOOLEANS
            r13 = r0
            r0 = r13
            int r0 = r0.length
            r14 = r0
            r0 = 0
            r15 = r0
        L_0x0044:
            r0 = r15
            r1 = r14
            if (r0 >= r1) goto L_0x0094
            r0 = r13
            r1 = r15
            r0 = r0[r1]
            r16 = r0
            r0 = r11
            if (r0 != 0) goto L_0x0061
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            r11 = r0
        L_0x0061:
            r0 = r11
            r1 = r12
            r2 = r16
            java.util.Comparator r1 = comparator(r1, r2)
            java.util.Collections.sort(r0, r1)
            r0 = r7
            r1 = r11
            java.util.List r0 = getPairs(r0, r1)
            r17 = r0
            r0 = r17
            double r0 = marginValueSum(r0)
            r18 = r0
            r0 = r18
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x008e
            r0 = r18
            r9 = r0
            r0 = r17
            r8 = r0
            r0 = 0
            r11 = r0
        L_0x008e:
            int r15 = r15 + 1
            goto L_0x0044
        L_0x0094:
            int r12 = r12 + 1
            goto L_0x001e
        L_0x009a:
            r0 = r8
            r1 = r5
            java.util.Comparator<com.github.davidmoten.rtreemulti.geometry.ListPair<?>> r1 = r1.comparator
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            com.github.davidmoten.rtreemulti.geometry.ListPair r0 = (com.github.davidmoten.rtreemulti.geometry.ListPair) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.davidmoten.rtreemulti.SplitterRStar.split(java.util.List, int):com.github.davidmoten.rtreemulti.geometry.ListPair");
    }

    private static Comparator<HasGeometry> comparator(int dimension, boolean upper) {
        if (upper) {
            return a, b -> {
                return Double.compare(a.geometry().mbr().max(dimension), b.geometry().mbr().max(dimension));
            };
        }
        return a, b -> {
            return Double.compare(a.geometry().mbr().min(dimension), b.geometry().mbr().min(dimension));
        };
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [double] */
    private static <T extends HasGeometry> double marginValueSum(List<ListPair<T>> list) {
        char c = 0;
        for (ListPair<T> p : list) {
            c += p.marginSum();
        }
        return c;
    }

    @VisibleForTesting
    static <T extends HasGeometry> List<ListPair<T>> getPairs(int minSize, List<T> list) {
        List<ListPair<T>> pairs = new ArrayList<>((list.size() - (2 * minSize)) + 1);
        for (int i = minSize; i < (list.size() - minSize) + 1; i++) {
            pairs.add(new ListPair<>(list.subList(0, i), list.subList(i, list.size())));
        }
        return pairs;
    }

    /* access modifiers changed from: private */
    public static double overlap(ListPair<? extends HasGeometry> pair) {
        return pair.group1().geometry().mbr().intersectionVolume(pair.group2().geometry().mbr());
    }
}
