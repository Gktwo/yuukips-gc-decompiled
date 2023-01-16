package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.longs.AbstractLongList;

/* renamed from: it.unimi.dsi.fastutil.longs.LongList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongList.class */
public interface LongList extends List<Long>, Comparable<List<? extends Long>>, LongCollection {
    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    LongListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Long> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Long> listIterator(int i);

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
    @Override // java.util.List
    List<Long> subList(int i, int i2);

    void size(int i);

    void getElements(int i, long[] jArr, int i2, int i3);

    void removeElements(int i, int i2);

    void addElements(int i, long[] jArr);

    void addElements(int i, long[] jArr, int i2, int i3);

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    boolean add(long j);

    void add(int i, long j);

    boolean addAll(int i, LongCollection longCollection);

    long set(int i, long j);

    long getLong(int i);

    int indexOf(long j);

    int lastIndexOf(long j);

    long removeLong(int i);

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    default LongSpliterator spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractLongList.IndexBasedSpliterator(this, 0);
        }
        return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 16720);
    }

    default void setElements(long[] a) {
        setElements(0, a);
    }

    default void setElements(int index, long[] a) {
        setElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(int r7, long[] r8, int r9, int r10) {
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
            p014it.unimi.dsi.fastutil.longs.LongArrays.ensureOffsetLength(r0, r1, r2)
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
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x00ad:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x00cf
            r0 = r11
            long r0 = r0.nextLong()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongList.setElements(int, long[], int, int):void");
    }

    @Deprecated
    default void add(int index, Long key) {
        add(index, key.longValue());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void replaceAll(java.util.function.LongUnaryOperator r6) {
        /*
            r5 = this;
            r0 = r5
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator()
            r7 = r0
        L_0x0007:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0025
            r0 = r7
            r1 = r6
            r2 = r7
            long r2 = r2.nextLong()
            long r1 = r1.applyAsLong(r2)
            r0.set(r1)
            goto L_0x0007
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongList.replaceAll(java.util.function.LongUnaryOperator):void");
    }

    default void replaceAll(LongUnaryOperator operator) {
        replaceAll((LongUnaryOperator) operator);
    }

    @Override // java.util.List
    @Deprecated
    default void replaceAll(UnaryOperator<Long> operator) {
        LongUnaryOperator longUnaryOperator;
        Objects.requireNonNull(operator);
        if (operator instanceof LongUnaryOperator) {
            longUnaryOperator = (LongUnaryOperator) operator;
        } else {
            Objects.requireNonNull(operator);
            longUnaryOperator = (v1) -> {
                return r1.apply(v1);
            };
        }
        replaceAll(longUnaryOperator);
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    default boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.List
    @Deprecated
    default Long get(int index) {
        return Long.valueOf(getLong(index));
    }

    @Override // java.util.List
    @Deprecated
    default int indexOf(Object o) {
        return indexOf(((Long) o).longValue());
    }

    @Override // java.util.List
    @Deprecated
    default int lastIndexOf(Object o) {
        return lastIndexOf(((Long) o).longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    default boolean add(Long k) {
        return add(k.longValue());
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    default boolean remove(Object key) {
        return remove(key);
    }

    @Override // java.util.List
    @Deprecated
    default Long remove(int index) {
        return Long.valueOf(removeLong(index));
    }

    @Deprecated
    default Long set(int index, Long k) {
        return Long.valueOf(set(index, k.longValue()));
    }

    default boolean addAll(int index, LongList l) {
        return addAll(index, (LongCollection) l);
    }

    default boolean addAll(LongList l) {
        return addAll(size(), l);
    }

    /* renamed from: of */
    static LongList m638of() {
        return LongImmutableList.m648of();
    }

    /* renamed from: of */
    static LongList m637of(long e) {
        return LongLists.singleton(e);
    }

    /* renamed from: of */
    static LongList m636of(long e0, long e1) {
        return LongImmutableList.m647of(e0, e1);
    }

    /* renamed from: of */
    static LongList m635of(long e0, long e1, long e2) {
        return LongImmutableList.m647of(e0, e1, e2);
    }

    /* renamed from: of */
    static LongList m634of(long... a) {
        switch (a.length) {
            case 0:
                return m638of();
            case 1:
                return m637of(a[0]);
            default:
                return LongImmutableList.m647of(a);
        }
    }

    @Override // java.util.List
    @Deprecated
    default void sort(Comparator<? super Long> comparator) {
        sort(LongComparators.asLongComparator(comparator));
    }

    default void sort(LongComparator comparator) {
        if (comparator == null) {
            unstableSort(comparator);
            return;
        }
        long[] elements = toLongArray();
        LongArrays.stableSort(elements, comparator);
        setElements(elements);
    }

    @Deprecated
    default void unstableSort(Comparator<? super Long> comparator) {
        unstableSort(LongComparators.asLongComparator(comparator));
    }

    default void unstableSort(LongComparator comparator) {
        long[] elements = toLongArray();
        if (comparator == null) {
            LongArrays.unstableSort(elements);
        } else {
            LongArrays.unstableSort(elements, comparator);
        }
        setElements(elements);
    }
}
