package p014it.unimi.dsi.fastutil.ints;

import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;

/* renamed from: it.unimi.dsi.fastutil.ints.IntBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBigList.class */
public interface IntBigList extends BigList<Integer>, IntCollection, Comparable<BigList<? extends Integer>> {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    IntBigListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.BigList
    BigListIterator<Integer> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.BigList
    BigListIterator<Integer> listIterator(long j);

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.BigList
    BigList<Integer> subList(long j, long j2);

    void getElements(long j, int[][] iArr, long j2, long j3);

    void removeElements(long j, long j2);

    void addElements(long j, int[][] iArr);

    void addElements(long j, int[][] iArr, long j2, long j3);

    void add(long j, int i);

    boolean addAll(long j, IntCollection intCollection);

    int getInt(long j);

    int removeInt(long j);

    int set(long j, int i);

    long indexOf(int i);

    long lastIndexOf(int i);

    @Deprecated
    void add(long j, Integer num);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    Integer get(long j);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    long indexOf(Object obj);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    long lastIndexOf(Object obj);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    Integer remove(long j);

    @Deprecated
    Integer set(long j, Integer num);

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    default IntSpliterator spliterator() {
        return IntSpliterators.asSpliterator(iterator(), size64(), 16720);
    }

    default void getElements(long from, int[] a, int offset, int length) {
        getElements(from, new int[][]{a}, (long) offset, (long) length);
    }

    default void setElements(int[][] a) {
        setElements(0, a);
    }

    default void setElements(long index, int[][] a) {
        setElements(index, a, 0, BigArrays.length(a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [int[][], long] */
    /* JADX WARN: Type inference failed for: r0v9, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(long r12, int[][] r14, long r15, long r17) {
        /*
            r11 = this;
            r0 = r12
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0026
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r12
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is negative"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0026:
            r0 = r12
            r1 = r11
            long r1 = r1.size64()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x005f
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r12
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than list size ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r11
            long r3 = r3.size64()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x005f:
            r0 = r14
            r1 = r15
            r2 = r17
            p014it.unimi.dsi.fastutil.BigArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r12
            r1 = r17
            long r0 = r0 + r1
            r1 = r11
            long r1 = r1.size64()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a6
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "End index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r12
            r4 = r17
            long r3 = r3 + r4
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than list size ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r11
            long r3 = r3.size64()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x00a6:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
            r0 = 0
            r20 = r0
        L_0x00b2:
            r0 = r20
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00da
            r0 = r19
            int r0 = r0.nextInt()
            r0 = r19
            r1 = r14
            r2 = r15
            r3 = r20
            r4 = r3; r1 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r20 = r4
            long r2 = r2 + r3
            int r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.set(r1)
            goto L_0x00b2
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntBigList.setElements(long, int[][], long, long):void");
    }

    default boolean addAll(long index, IntBigList l) {
        return addAll(index, (IntCollection) l);
    }

    default boolean addAll(IntBigList l) {
        return addAll(size64(), l);
    }

    default boolean addAll(long index, IntList l) {
        return addAll(index, (IntCollection) l);
    }

    default boolean addAll(IntList l) {
        return addAll(size64(), l);
    }
}
