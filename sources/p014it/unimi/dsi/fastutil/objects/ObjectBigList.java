package p014it.unimi.dsi.fastutil.objects;

import java.util.Collection;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigList.class */
public interface ObjectBigList<K> extends BigList<K>, ObjectCollection<K>, Comparable<BigList<? extends K>> {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
    ObjectBigListIterator<K> iterator();

    @Override // p014it.unimi.dsi.fastutil.BigList
    ObjectBigListIterator<K> listIterator();

    @Override // p014it.unimi.dsi.fastutil.BigList
    ObjectBigListIterator<K> listIterator(long j);

    @Override // p014it.unimi.dsi.fastutil.BigList
    ObjectBigList<K> subList(long j, long j2);

    void getElements(long j, Object[][] objArr, long j2, long j3);

    void removeElements(long j, long j2);

    void addElements(long j, K[][] kArr);

    void addElements(long j, K[][] kArr, long j2, long j3);

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    default ObjectSpliterator<K> spliterator() {
        return ObjectSpliterators.asSpliterator(iterator(), size64(), ObjectSpliterators.LIST_SPLITERATOR_CHARACTERISTICS);
    }

    default void getElements(long from, Object[] a, int offset, int length) {
        getElements(from, new Object[][]{a}, (long) offset, (long) length);
    }

    default void setElements(K[][] a) {
        setElements(0, a);
    }

    default void setElements(long index, K[][] a) {
        setElements(index, a, 0, BigArrays.length(a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Object[][], long] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(long r12, K[][] r14, long r15, long r17) {
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
            it.unimi.dsi.fastutil.objects.ObjectBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
            r0 = 0
            r20 = r0
        L_0x00b2:
            r0 = r20
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00da
            r0 = r19
            java.lang.Object r0 = r0.next()
            r0 = r19
            r1 = r14
            r2 = r15
            r3 = r20
            r4 = r3; r1 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r20 = r4
            long r2 = r2 + r3
            java.lang.Object r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.set(r1)
            goto L_0x00b2
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigList.setElements(long, java.lang.Object[][], long, long):void");
    }

    default boolean addAll(long index, ObjectBigList<? extends K> l) {
        return addAll(index, (Collection) l);
    }

    default boolean addAll(ObjectBigList<? extends K> l) {
        return addAll(size64(), (ObjectBigList) l);
    }

    default boolean addAll(long index, ObjectList<? extends K> l) {
        return addAll(index, (Collection) l);
    }

    default boolean addAll(ObjectList<? extends K> l) {
        return addAll(size64(), (ObjectList) l);
    }
}
