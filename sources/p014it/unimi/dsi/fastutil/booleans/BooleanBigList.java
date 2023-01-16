package p014it.unimi.dsi.fastutil.booleans;

import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigList.class */
public interface BooleanBigList extends BigList<Boolean>, BooleanCollection, Comparable<BigList<? extends Boolean>> {
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    BooleanBigListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.BigList
    BigListIterator<Boolean> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.BigList
    BigListIterator<Boolean> listIterator(long j);

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.BigList
    BigList<Boolean> subList(long j, long j2);

    void getElements(long j, boolean[][] zArr, long j2, long j3);

    void removeElements(long j, long j2);

    void addElements(long j, boolean[][] zArr);

    void addElements(long j, boolean[][] zArr, long j2, long j3);

    void add(long j, boolean z);

    boolean addAll(long j, BooleanCollection booleanCollection);

    boolean getBoolean(long j);

    boolean removeBoolean(long j);

    boolean set(long j, boolean z);

    long indexOf(boolean z);

    long lastIndexOf(boolean z);

    @Deprecated
    void add(long j, Boolean bool);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    Boolean get(long j);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    long indexOf(Object obj);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    long lastIndexOf(Object obj);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    Boolean remove(long j);

    @Deprecated
    Boolean set(long j, Boolean bool);

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    default BooleanSpliterator spliterator() {
        return BooleanSpliterators.asSpliterator(iterator(), size64(), 16720);
    }

    default void getElements(long from, boolean[] a, int offset, int length) {
        getElements(from, new boolean[][]{a}, (long) offset, (long) length);
    }

    default void setElements(boolean[][] a) {
        setElements(0, a);
    }

    default void setElements(long index, boolean[][] a) {
        setElements(index, a, 0, BigArrays.length(a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [long, boolean[][]] */
    /* JADX WARN: Type inference failed for: r0v9, types: [it.unimi.dsi.fastutil.booleans.BooleanBigListIterator] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(long r12, boolean[][] r14, long r15, long r17) {
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
            it.unimi.dsi.fastutil.booleans.BooleanBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
            r0 = 0
            r20 = r0
        L_0x00b2:
            r0 = r20
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00da
            r0 = r19
            boolean r0 = r0.nextBoolean()
            r0 = r19
            r1 = r14
            r2 = r15
            r3 = r20
            r4 = r3; r1 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r20 = r4
            long r2 = r2 + r3
            boolean r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.set(r1)
            goto L_0x00b2
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigList.setElements(long, boolean[][], long, long):void");
    }

    default boolean addAll(long index, BooleanBigList l) {
        return addAll(index, (BooleanCollection) l);
    }

    default boolean addAll(BooleanBigList l) {
        return addAll(size64(), l);
    }

    default boolean addAll(long index, BooleanList l) {
        return addAll(index, (BooleanCollection) l);
    }

    default boolean addAll(BooleanList l) {
        return addAll(size64(), l);
    }
}
