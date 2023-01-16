package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatList;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatList.class */
public interface FloatList extends List<Float>, Comparable<List<? extends Float>>, FloatCollection {
    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    FloatListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Float> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Float> listIterator(int i);

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
    @Override // java.util.List
    List<Float> subList(int i, int i2);

    void size(int i);

    void getElements(int i, float[] fArr, int i2, int i3);

    void removeElements(int i, int i2);

    void addElements(int i, float[] fArr);

    void addElements(int i, float[] fArr, int i2, int i3);

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    boolean add(float f);

    void add(int i, float f);

    boolean addAll(int i, FloatCollection floatCollection);

    float set(int i, float f);

    float getFloat(int i);

    int indexOf(float f);

    int lastIndexOf(float f);

    float removeFloat(int i);

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    default FloatSpliterator spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractFloatList.IndexBasedSpliterator(this, 0);
        }
        return FloatSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 16720);
    }

    default void setElements(float[] a) {
        setElements(0, a);
    }

    default void setElements(int index, float[] a) {
        setElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(int r7, float[] r8, int r9, int r10) {
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
            p014it.unimi.dsi.fastutil.floats.FloatArrays.ensureOffsetLength(r0, r1, r2)
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
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x00ad:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x00cf
            r0 = r11
            float r0 = r0.nextFloat()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatList.setElements(int, float[], int, int):void");
    }

    @Deprecated
    default void add(int index, Float key) {
        add(index, key.floatValue());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void replaceAll(p014it.unimi.dsi.fastutil.floats.FloatUnaryOperator r5) {
        /*
            r4 = this;
            r0 = r4
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0025
            r0 = r6
            r1 = r5
            r2 = r6
            float r2 = r2.nextFloat()
            float r1 = r1.apply(r2)
            r0.set(r1)
            goto L_0x0007
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatList.replaceAll(it.unimi.dsi.fastutil.floats.FloatUnaryOperator):void");
    }

    default void replaceAll(DoubleUnaryOperator operator) {
        replaceAll(operator instanceof FloatUnaryOperator ? (FloatUnaryOperator) operator : x -> {
            return SafeMath.safeDoubleToFloat(operator.applyAsDouble((double) x));
        });
    }

    @Override // java.util.List
    @Deprecated
    default void replaceAll(UnaryOperator<Float> operator) {
        FloatUnaryOperator floatUnaryOperator;
        Objects.requireNonNull(operator);
        if (operator instanceof FloatUnaryOperator) {
            floatUnaryOperator = (FloatUnaryOperator) operator;
        } else {
            Objects.requireNonNull(operator);
            floatUnaryOperator = (v1) -> {
                return r1.apply(v1);
            };
        }
        replaceAll(floatUnaryOperator);
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    default boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.List
    @Deprecated
    default Float get(int index) {
        return Float.valueOf(getFloat(index));
    }

    @Override // java.util.List
    @Deprecated
    default int indexOf(Object o) {
        return indexOf(((Float) o).floatValue());
    }

    @Override // java.util.List
    @Deprecated
    default int lastIndexOf(Object o) {
        return lastIndexOf(((Float) o).floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    default boolean add(Float k) {
        return add(k.floatValue());
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    default boolean remove(Object key) {
        return remove(key);
    }

    @Override // java.util.List
    @Deprecated
    default Float remove(int index) {
        return Float.valueOf(removeFloat(index));
    }

    @Deprecated
    default Float set(int index, Float k) {
        return Float.valueOf(set(index, k.floatValue()));
    }

    default boolean addAll(int index, FloatList l) {
        return addAll(index, (FloatCollection) l);
    }

    default boolean addAll(FloatList l) {
        return addAll(size(), l);
    }

    /* renamed from: of */
    static FloatList m805of() {
        return FloatImmutableList.m815of();
    }

    /* renamed from: of */
    static FloatList m804of(float e) {
        return FloatLists.singleton(e);
    }

    /* renamed from: of */
    static FloatList m803of(float e0, float e1) {
        return FloatImmutableList.m814of(e0, e1);
    }

    /* renamed from: of */
    static FloatList m802of(float e0, float e1, float e2) {
        return FloatImmutableList.m814of(e0, e1, e2);
    }

    /* renamed from: of */
    static FloatList m801of(float... a) {
        switch (a.length) {
            case 0:
                return m805of();
            case 1:
                return m804of(a[0]);
            default:
                return FloatImmutableList.m814of(a);
        }
    }

    @Override // java.util.List
    @Deprecated
    default void sort(Comparator<? super Float> comparator) {
        sort(FloatComparators.asFloatComparator(comparator));
    }

    default void sort(FloatComparator comparator) {
        float[] elements = toFloatArray();
        if (comparator == null) {
            FloatArrays.stableSort(elements);
        } else {
            FloatArrays.stableSort(elements, comparator);
        }
        setElements(elements);
    }

    @Deprecated
    default void unstableSort(Comparator<? super Float> comparator) {
        unstableSort(FloatComparators.asFloatComparator(comparator));
    }

    default void unstableSort(FloatComparator comparator) {
        float[] elements = toFloatArray();
        if (comparator == null) {
            FloatArrays.unstableSort(elements);
        } else {
            FloatArrays.unstableSort(elements, comparator);
        }
        setElements(elements);
    }
}
