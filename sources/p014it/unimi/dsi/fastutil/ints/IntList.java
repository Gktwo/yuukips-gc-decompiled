package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.ints.AbstractIntList;

/* renamed from: it.unimi.dsi.fastutil.ints.IntList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntList.class */
public interface IntList extends List<Integer>, Comparable<List<? extends Integer>>, IntCollection {
    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    IntListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Integer> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Integer> listIterator(int i);

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntList' to match base method */
    @Override // java.util.List
    List<Integer> subList(int i, int i2);

    void size(int i);

    void getElements(int i, int[] iArr, int i2, int i3);

    void removeElements(int i, int i2);

    void addElements(int i, int[] iArr);

    void addElements(int i, int[] iArr, int i2, int i3);

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    boolean add(int i);

    void add(int i, int i2);

    boolean addAll(int i, IntCollection intCollection);

    int set(int i, int i2);

    int getInt(int i);

    int indexOf(int i);

    int lastIndexOf(int i);

    int removeInt(int i);

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    default IntSpliterator spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractIntList.IndexBasedSpliterator(this, 0);
        }
        return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 16720);
    }

    default void setElements(int[] a) {
        setElements(0, a);
    }

    default void setElements(int index, int[] a) {
        setElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.ints.IntListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(int r7, int[] r8, int r9, int r10) {
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
            p014it.unimi.dsi.fastutil.ints.IntArrays.ensureOffsetLength(r0, r1, r2)
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
            it.unimi.dsi.fastutil.ints.IntListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x00ad:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x00cf
            r0 = r11
            int r0 = r0.nextInt()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntList.setElements(int, int[], int, int):void");
    }

    @Deprecated
    default void add(int index, Integer key) {
        add(index, key.intValue());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.ints.IntListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void replaceAll(java.util.function.IntUnaryOperator r5) {
        /*
            r4 = this;
            r0 = r4
            it.unimi.dsi.fastutil.ints.IntListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0025
            r0 = r6
            r1 = r5
            r2 = r6
            int r2 = r2.nextInt()
            int r1 = r1.applyAsInt(r2)
            r0.set(r1)
            goto L_0x0007
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntList.replaceAll(java.util.function.IntUnaryOperator):void");
    }

    default void replaceAll(IntUnaryOperator operator) {
        replaceAll((IntUnaryOperator) operator);
    }

    @Override // java.util.List
    @Deprecated
    default void replaceAll(UnaryOperator<Integer> operator) {
        IntUnaryOperator intUnaryOperator;
        Objects.requireNonNull(operator);
        if (operator instanceof IntUnaryOperator) {
            intUnaryOperator = (IntUnaryOperator) operator;
        } else {
            Objects.requireNonNull(operator);
            intUnaryOperator = (v1) -> {
                return r1.apply(v1);
            };
        }
        replaceAll(intUnaryOperator);
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    default boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.List
    @Deprecated
    default Integer get(int index) {
        return Integer.valueOf(getInt(index));
    }

    @Override // java.util.List
    @Deprecated
    default int indexOf(Object o) {
        return indexOf(((Integer) o).intValue());
    }

    @Override // java.util.List
    @Deprecated
    default int lastIndexOf(Object o) {
        return lastIndexOf(((Integer) o).intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    default boolean add(Integer k) {
        return add(k.intValue());
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    default boolean remove(Object key) {
        return remove(key);
    }

    @Override // java.util.List
    @Deprecated
    default Integer remove(int index) {
        return Integer.valueOf(removeInt(index));
    }

    @Deprecated
    default Integer set(int index, Integer k) {
        return Integer.valueOf(set(index, k.intValue()));
    }

    default boolean addAll(int index, IntList l) {
        return addAll(index, (IntCollection) l);
    }

    default boolean addAll(IntList l) {
        return addAll(size(), l);
    }

    /* renamed from: of */
    static IntList m721of() {
        return IntImmutableList.m733of();
    }

    /* renamed from: of */
    static IntList m720of(int e) {
        return IntLists.singleton(e);
    }

    /* renamed from: of */
    static IntList m719of(int e0, int e1) {
        return IntImmutableList.m732of(e0, e1);
    }

    /* renamed from: of */
    static IntList m718of(int e0, int e1, int e2) {
        return IntImmutableList.m732of(e0, e1, e2);
    }

    /* renamed from: of */
    static IntList m717of(int... a) {
        switch (a.length) {
            case 0:
                return m721of();
            case 1:
                return m720of(a[0]);
            default:
                return IntImmutableList.m732of(a);
        }
    }

    @Override // java.util.List
    @Deprecated
    default void sort(Comparator<? super Integer> comparator) {
        sort(IntComparators.asIntComparator(comparator));
    }

    default void sort(IntComparator comparator) {
        if (comparator == null) {
            unstableSort(comparator);
            return;
        }
        int[] elements = toIntArray();
        IntArrays.stableSort(elements, comparator);
        setElements(elements);
    }

    @Deprecated
    default void unstableSort(Comparator<? super Integer> comparator) {
        unstableSort(IntComparators.asIntComparator(comparator));
    }

    default void unstableSort(IntComparator comparator) {
        int[] elements = toIntArray();
        if (comparator == null) {
            IntArrays.unstableSort(elements);
        } else {
            IntArrays.unstableSort(elements, comparator);
        }
        setElements(elements);
    }
}
