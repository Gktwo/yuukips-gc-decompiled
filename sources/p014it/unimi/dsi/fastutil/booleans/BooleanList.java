package p014it.unimi.dsi.fastutil.booleans;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanList.class */
public interface BooleanList extends List<Boolean>, Comparable<List<? extends Boolean>>, BooleanCollection {
    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    BooleanListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Boolean> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Boolean> listIterator(int i);

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
    @Override // java.util.List
    List<Boolean> subList(int i, int i2);

    void size(int i);

    void getElements(int i, boolean[] zArr, int i2, int i3);

    void removeElements(int i, int i2);

    void addElements(int i, boolean[] zArr);

    void addElements(int i, boolean[] zArr, int i2, int i3);

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    boolean add(boolean z);

    void add(int i, boolean z);

    boolean addAll(int i, BooleanCollection booleanCollection);

    boolean set(int i, boolean z);

    boolean getBoolean(int i);

    int indexOf(boolean z);

    int lastIndexOf(boolean z);

    boolean removeBoolean(int i);

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    default BooleanSpliterator spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractBooleanList.IndexBasedSpliterator(this, 0);
        }
        return BooleanSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 16720);
    }

    default void setElements(boolean[] a) {
        setElements(0, a);
    }

    default void setElements(int index, boolean[] a) {
        setElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(int r7, boolean[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r7
            if (r0 >= 0) goto L_0x0024
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is negative"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0024:
            r0 = r7
            r1 = r6
            int r1 = r1.size()
            if (r0 <= r1) goto L_0x005c
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than list size ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            int r3 = r3.size()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x005c:
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.booleans.BooleanArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r7
            r1 = r10
            int r0 = r0 + r1
            r1 = r6
            int r1 = r1.size()
            if (r0 <= r1) goto L_0x00a1
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "End index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            r4 = r10
            int r3 = r3 + r4
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than list size ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            int r3 = r3.size()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x00a1:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x00ad:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x00cf
            r0 = r11
            boolean r0 = r0.nextBoolean()
            r0 = r11
            r1 = r8
            r2 = r9
            r3 = r12
            int r12 = r12 + 1
            int r2 = r2 + r3
            r1 = r1[r2]
            r0.set(r1)
            goto L_0x00ad
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanList.setElements(int, boolean[], int, int):void");
    }

    @Deprecated
    default void add(int index, Boolean key) {
        add(index, key.booleanValue());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void replaceAll(p014it.unimi.dsi.fastutil.booleans.BooleanUnaryOperator r5) {
        /*
            r4 = this;
            r0 = r4
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0025
            r0 = r6
            r1 = r5
            r2 = r6
            boolean r2 = r2.nextBoolean()
            boolean r1 = r1.apply(r2)
            r0.set(r1)
            goto L_0x0007
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanList.replaceAll(it.unimi.dsi.fastutil.booleans.BooleanUnaryOperator):void");
    }

    @Override // java.util.List
    @Deprecated
    default void replaceAll(UnaryOperator<Boolean> operator) {
        BooleanUnaryOperator booleanUnaryOperator;
        Objects.requireNonNull(operator);
        if (operator instanceof BooleanUnaryOperator) {
            booleanUnaryOperator = (BooleanUnaryOperator) operator;
        } else {
            Objects.requireNonNull(operator);
            booleanUnaryOperator = (v1) -> {
                return r1.apply(v1);
            };
        }
        replaceAll(booleanUnaryOperator);
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    default boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.List
    @Deprecated
    default Boolean get(int index) {
        return Boolean.valueOf(getBoolean(index));
    }

    @Override // java.util.List
    @Deprecated
    default int indexOf(Object o) {
        return indexOf(((Boolean) o).booleanValue());
    }

    @Override // java.util.List
    @Deprecated
    default int lastIndexOf(Object o) {
        return lastIndexOf(((Boolean) o).booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    default boolean add(Boolean k) {
        return add(k.booleanValue());
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    default boolean remove(Object key) {
        return remove(key);
    }

    @Override // java.util.List
    @Deprecated
    default Boolean remove(int index) {
        return Boolean.valueOf(removeBoolean(index));
    }

    @Deprecated
    default Boolean set(int index, Boolean k) {
        return Boolean.valueOf(set(index, k.booleanValue()));
    }

    default boolean addAll(int index, BooleanList l) {
        return addAll(index, (BooleanCollection) l);
    }

    default boolean addAll(BooleanList l) {
        return addAll(size(), l);
    }

    /* renamed from: of */
    static BooleanList m1142of() {
        return BooleanImmutableList.m1147of();
    }

    /* renamed from: of */
    static BooleanList m1141of(boolean e) {
        return BooleanLists.singleton(e);
    }

    /* renamed from: of */
    static BooleanList m1140of(boolean e0, boolean e1) {
        return BooleanImmutableList.m1146of(e0, e1);
    }

    /* renamed from: of */
    static BooleanList m1139of(boolean e0, boolean e1, boolean e2) {
        return BooleanImmutableList.m1146of(e0, e1, e2);
    }

    /* renamed from: of */
    static BooleanList m1138of(boolean... a) {
        switch (a.length) {
            case 0:
                return m1142of();
            case 1:
                return m1141of(a[0]);
            default:
                return BooleanImmutableList.m1146of(a);
        }
    }

    @Override // java.util.List
    @Deprecated
    default void sort(Comparator<? super Boolean> comparator) {
        sort(BooleanComparators.asBooleanComparator(comparator));
    }

    default void sort(BooleanComparator comparator) {
        if (comparator == null) {
            unstableSort(comparator);
            return;
        }
        boolean[] elements = toBooleanArray();
        BooleanArrays.stableSort(elements, comparator);
        setElements(elements);
    }

    @Deprecated
    default void unstableSort(Comparator<? super Boolean> comparator) {
        unstableSort(BooleanComparators.asBooleanComparator(comparator));
    }

    default void unstableSort(BooleanComparator comparator) {
        boolean[] elements = toBooleanArray();
        if (comparator == null) {
            BooleanArrays.unstableSort(elements);
        } else {
            BooleanArrays.unstableSort(elements, comparator);
        }
        setElements(elements);
    }
}
