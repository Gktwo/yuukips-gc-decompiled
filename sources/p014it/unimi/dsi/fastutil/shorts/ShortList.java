package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortList;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortList.class */
public interface ShortList extends List<Short>, Comparable<List<? extends Short>>, ShortCollection {
    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    ShortListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Short> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Short> listIterator(int i);

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
    @Override // java.util.List
    List<Short> subList(int i, int i2);

    void size(int i);

    void getElements(int i, short[] sArr, int i2, int i3);

    void removeElements(int i, int i2);

    void addElements(int i, short[] sArr);

    void addElements(int i, short[] sArr, int i2, int i3);

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    boolean add(short s);

    void add(int i, short s);

    boolean addAll(int i, ShortCollection shortCollection);

    short set(int i, short s);

    short getShort(int i);

    int indexOf(short s);

    int lastIndexOf(short s);

    short removeShort(int i);

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    default ShortSpliterator spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractShortList.IndexBasedSpliterator(this, 0);
        }
        return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 16720);
    }

    default void setElements(short[] a) {
        setElements(0, a);
    }

    default void setElements(int index, short[] a) {
        setElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(int r7, short[] r8, int r9, int r10) {
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
            p014it.unimi.dsi.fastutil.shorts.ShortArrays.ensureOffsetLength(r0, r1, r2)
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
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x00ad:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x00cf
            r0 = r11
            short r0 = r0.nextShort()
            r0 = r11
            r1 = r8
            r2 = r9
            r3 = r12
            int r12 = r12 + 1
            int r2 = r2 + r3
            short r1 = r1[r2]
            r0.set(r1)
            goto L_0x00ad
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortList.setElements(int, short[], int, int):void");
    }

    @Deprecated
    default void add(int index, Short key) {
        add(index, key.shortValue());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void replaceAll(p014it.unimi.dsi.fastutil.shorts.ShortUnaryOperator r5) {
        /*
            r4 = this;
            r0 = r4
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0025
            r0 = r6
            r1 = r5
            r2 = r6
            short r2 = r2.nextShort()
            short r1 = r1.apply(r2)
            r0.set(r1)
            goto L_0x0007
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortList.replaceAll(it.unimi.dsi.fastutil.shorts.ShortUnaryOperator):void");
    }

    default void replaceAll(IntUnaryOperator operator) {
        replaceAll(operator instanceof ShortUnaryOperator ? (ShortUnaryOperator) operator : x -> {
            return SafeMath.safeIntToShort(operator.applyAsInt(x));
        });
    }

    @Override // java.util.List
    @Deprecated
    default void replaceAll(UnaryOperator<Short> operator) {
        ShortUnaryOperator shortUnaryOperator;
        Objects.requireNonNull(operator);
        if (operator instanceof ShortUnaryOperator) {
            shortUnaryOperator = (ShortUnaryOperator) operator;
        } else {
            Objects.requireNonNull(operator);
            shortUnaryOperator = (v1) -> {
                return r1.apply(v1);
            };
        }
        replaceAll(shortUnaryOperator);
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    default boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.List
    @Deprecated
    default Short get(int index) {
        return Short.valueOf(getShort(index));
    }

    @Override // java.util.List
    @Deprecated
    default int indexOf(Object o) {
        return indexOf(((Short) o).shortValue());
    }

    @Override // java.util.List
    @Deprecated
    default int lastIndexOf(Object o) {
        return lastIndexOf(((Short) o).shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    default boolean add(Short k) {
        return add(k.shortValue());
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    default boolean remove(Object key) {
        return remove(key);
    }

    @Override // java.util.List
    @Deprecated
    default Short remove(int index) {
        return Short.valueOf(removeShort(index));
    }

    @Deprecated
    default Short set(int index, Short k) {
        return Short.valueOf(set(index, k.shortValue()));
    }

    default boolean addAll(int index, ShortList l) {
        return addAll(index, (ShortCollection) l);
    }

    default boolean addAll(ShortList l) {
        return addAll(size(), l);
    }

    /* renamed from: of */
    static ShortList m413of() {
        return ShortImmutableList.m423of();
    }

    /* renamed from: of */
    static ShortList m412of(short e) {
        return ShortLists.singleton(e);
    }

    /* renamed from: of */
    static ShortList m411of(short e0, short e1) {
        return ShortImmutableList.m422of(e0, e1);
    }

    /* renamed from: of */
    static ShortList m410of(short e0, short e1, short e2) {
        return ShortImmutableList.m422of(e0, e1, e2);
    }

    /* renamed from: of */
    static ShortList m409of(short... a) {
        switch (a.length) {
            case 0:
                return m413of();
            case 1:
                return m412of(a[0]);
            default:
                return ShortImmutableList.m422of(a);
        }
    }

    @Override // java.util.List
    @Deprecated
    default void sort(Comparator<? super Short> comparator) {
        sort(ShortComparators.asShortComparator(comparator));
    }

    default void sort(ShortComparator comparator) {
        if (comparator == null) {
            unstableSort(comparator);
            return;
        }
        short[] elements = toShortArray();
        ShortArrays.stableSort(elements, comparator);
        setElements(elements);
    }

    @Deprecated
    default void unstableSort(Comparator<? super Short> comparator) {
        unstableSort(ShortComparators.asShortComparator(comparator));
    }

    default void unstableSort(ShortComparator comparator) {
        short[] elements = toShortArray();
        if (comparator == null) {
            ShortArrays.unstableSort(elements);
        } else {
            ShortArrays.unstableSort(elements, comparator);
        }
        setElements(elements);
    }
}
