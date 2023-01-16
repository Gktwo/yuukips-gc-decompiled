package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleList.class */
public interface DoubleList extends List<Double>, Comparable<List<? extends Double>>, DoubleCollection {
    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    DoubleListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Double> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Double> listIterator(int i);

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
    @Override // java.util.List
    List<Double> subList(int i, int i2);

    void size(int i);

    void getElements(int i, double[] dArr, int i2, int i3);

    void removeElements(int i, int i2);

    void addElements(int i, double[] dArr);

    void addElements(int i, double[] dArr, int i2, int i3);

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    boolean add(double d);

    void add(int i, double d);

    boolean addAll(int i, DoubleCollection doubleCollection);

    double set(int i, double d);

    double getDouble(int i);

    int indexOf(double d);

    int lastIndexOf(double d);

    double removeDouble(int i);

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    default DoubleSpliterator spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractDoubleList.IndexBasedSpliterator(this, 0);
        }
        return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 16720);
    }

    default void setElements(double[] a) {
        setElements(0, a);
    }

    default void setElements(int index, double[] a) {
        setElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(int r7, double[] r8, int r9, int r10) {
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
            p014it.unimi.dsi.fastutil.doubles.DoubleArrays.ensureOffsetLength(r0, r1, r2)
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
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x00ad:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x00cf
            r0 = r11
            double r0 = r0.nextDouble()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleList.setElements(int, double[], int, int):void");
    }

    @Deprecated
    default void add(int index, Double key) {
        add(index, key.doubleValue());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void replaceAll(java.util.function.DoubleUnaryOperator r6) {
        /*
            r5 = this;
            r0 = r5
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator()
            r7 = r0
        L_0x0007:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0025
            r0 = r7
            r1 = r6
            r2 = r7
            double r2 = r2.nextDouble()
            double r1 = r1.applyAsDouble(r2)
            r0.set(r1)
            goto L_0x0007
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleList.replaceAll(java.util.function.DoubleUnaryOperator):void");
    }

    default void replaceAll(DoubleUnaryOperator operator) {
        replaceAll((DoubleUnaryOperator) operator);
    }

    @Override // java.util.List
    @Deprecated
    default void replaceAll(UnaryOperator<Double> operator) {
        DoubleUnaryOperator doubleUnaryOperator;
        Objects.requireNonNull(operator);
        if (operator instanceof DoubleUnaryOperator) {
            doubleUnaryOperator = (DoubleUnaryOperator) operator;
        } else {
            Objects.requireNonNull(operator);
            doubleUnaryOperator = (v1) -> {
                return r1.apply(v1);
            };
        }
        replaceAll(doubleUnaryOperator);
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    default boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.List
    @Deprecated
    default Double get(int index) {
        return Double.valueOf(getDouble(index));
    }

    @Override // java.util.List
    @Deprecated
    default int indexOf(Object o) {
        return indexOf(((Double) o).doubleValue());
    }

    @Override // java.util.List
    @Deprecated
    default int lastIndexOf(Object o) {
        return lastIndexOf(((Double) o).doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    default boolean add(Double k) {
        return add(k.doubleValue());
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    default boolean remove(Object key) {
        return remove(key);
    }

    @Override // java.util.List
    @Deprecated
    default Double remove(int index) {
        return Double.valueOf(removeDouble(index));
    }

    @Deprecated
    default Double set(int index, Double k) {
        return Double.valueOf(set(index, k.doubleValue()));
    }

    default boolean addAll(int index, DoubleList l) {
        return addAll(index, (DoubleCollection) l);
    }

    default boolean addAll(DoubleList l) {
        return addAll(size(), l);
    }

    /* renamed from: of */
    static DoubleList m889of() {
        return DoubleImmutableList.m899of();
    }

    /* renamed from: of */
    static DoubleList m888of(double e) {
        return DoubleLists.singleton(e);
    }

    /* renamed from: of */
    static DoubleList m887of(double e0, double e1) {
        return DoubleImmutableList.m898of(e0, e1);
    }

    /* renamed from: of */
    static DoubleList m886of(double e0, double e1, double e2) {
        return DoubleImmutableList.m898of(e0, e1, e2);
    }

    /* renamed from: of */
    static DoubleList m885of(double... a) {
        switch (a.length) {
            case 0:
                return m889of();
            case 1:
                return m888of(a[0]);
            default:
                return DoubleImmutableList.m898of(a);
        }
    }

    @Override // java.util.List
    @Deprecated
    default void sort(Comparator<? super Double> comparator) {
        sort(DoubleComparators.asDoubleComparator(comparator));
    }

    default void sort(DoubleComparator comparator) {
        double[] elements = toDoubleArray();
        if (comparator == null) {
            DoubleArrays.stableSort(elements);
        } else {
            DoubleArrays.stableSort(elements, comparator);
        }
        setElements(elements);
    }

    @Deprecated
    default void unstableSort(Comparator<? super Double> comparator) {
        unstableSort(DoubleComparators.asDoubleComparator(comparator));
    }

    default void unstableSort(DoubleComparator comparator) {
        double[] elements = toDoubleArray();
        if (comparator == null) {
            DoubleArrays.unstableSort(elements);
        } else {
            DoubleArrays.unstableSort(elements, comparator);
        }
        setElements(elements);
    }
}
