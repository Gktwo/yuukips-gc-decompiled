package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.bytes.AbstractByteList;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteList.class */
public interface ByteList extends List<Byte>, Comparable<List<? extends Byte>>, ByteCollection {
    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    ByteListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Byte> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Byte> listIterator(int i);

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
    @Override // java.util.List
    List<Byte> subList(int i, int i2);

    void size(int i);

    void getElements(int i, byte[] bArr, int i2, int i3);

    void removeElements(int i, int i2);

    void addElements(int i, byte[] bArr);

    void addElements(int i, byte[] bArr, int i2, int i3);

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    boolean add(byte b);

    void add(int i, byte b);

    boolean addAll(int i, ByteCollection byteCollection);

    byte set(int i, byte b);

    byte getByte(int i);

    int indexOf(byte b);

    int lastIndexOf(byte b);

    byte removeByte(int i);

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    default ByteSpliterator spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractByteList.IndexBasedSpliterator(this, 0);
        }
        return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 16720);
    }

    default void setElements(byte[] a) {
        setElements(0, a);
    }

    default void setElements(int index, byte[] a) {
        setElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(int r7, byte[] r8, int r9, int r10) {
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
            p014it.unimi.dsi.fastutil.bytes.ByteArrays.ensureOffsetLength(r0, r1, r2)
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
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x00ad:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x00cf
            r0 = r11
            byte r0 = r0.nextByte()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteList.setElements(int, byte[], int, int):void");
    }

    @Deprecated
    default void add(int index, Byte key) {
        add(index, key.byteValue());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void replaceAll(p014it.unimi.dsi.fastutil.bytes.ByteUnaryOperator r5) {
        /*
            r4 = this;
            r0 = r4
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0025
            r0 = r6
            r1 = r5
            r2 = r6
            byte r2 = r2.nextByte()
            byte r1 = r1.apply(r2)
            r0.set(r1)
            goto L_0x0007
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteList.replaceAll(it.unimi.dsi.fastutil.bytes.ByteUnaryOperator):void");
    }

    default void replaceAll(IntUnaryOperator operator) {
        replaceAll(operator instanceof ByteUnaryOperator ? (ByteUnaryOperator) operator : x -> {
            return SafeMath.safeIntToByte(operator.applyAsInt(x));
        });
    }

    @Override // java.util.List
    @Deprecated
    default void replaceAll(UnaryOperator<Byte> operator) {
        ByteUnaryOperator byteUnaryOperator;
        Objects.requireNonNull(operator);
        if (operator instanceof ByteUnaryOperator) {
            byteUnaryOperator = (ByteUnaryOperator) operator;
        } else {
            Objects.requireNonNull(operator);
            byteUnaryOperator = (v1) -> {
                return r1.apply(v1);
            };
        }
        replaceAll(byteUnaryOperator);
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    default boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.List
    @Deprecated
    default Byte get(int index) {
        return Byte.valueOf(getByte(index));
    }

    @Override // java.util.List
    @Deprecated
    default int indexOf(Object o) {
        return indexOf(((Byte) o).byteValue());
    }

    @Override // java.util.List
    @Deprecated
    default int lastIndexOf(Object o) {
        return lastIndexOf(((Byte) o).byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    default boolean add(Byte k) {
        return add(k.byteValue());
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    default boolean remove(Object key) {
        return remove(key);
    }

    @Override // java.util.List
    @Deprecated
    default Byte remove(int index) {
        return Byte.valueOf(removeByte(index));
    }

    @Deprecated
    default Byte set(int index, Byte k) {
        return Byte.valueOf(set(index, k.byteValue()));
    }

    default boolean addAll(int index, ByteList l) {
        return addAll(index, (ByteCollection) l);
    }

    default boolean addAll(ByteList l) {
        return addAll(size(), l);
    }

    /* renamed from: of */
    static ByteList m1059of() {
        return ByteImmutableList.m1069of();
    }

    /* renamed from: of */
    static ByteList m1058of(byte e) {
        return ByteLists.singleton(e);
    }

    /* renamed from: of */
    static ByteList m1057of(byte e0, byte e1) {
        return ByteImmutableList.m1068of(e0, e1);
    }

    /* renamed from: of */
    static ByteList m1056of(byte e0, byte e1, byte e2) {
        return ByteImmutableList.m1068of(e0, e1, e2);
    }

    /* renamed from: of */
    static ByteList m1055of(byte... a) {
        switch (a.length) {
            case 0:
                return m1059of();
            case 1:
                return m1058of(a[0]);
            default:
                return ByteImmutableList.m1068of(a);
        }
    }

    @Override // java.util.List
    @Deprecated
    default void sort(Comparator<? super Byte> comparator) {
        sort(ByteComparators.asByteComparator(comparator));
    }

    default void sort(ByteComparator comparator) {
        if (comparator == null) {
            unstableSort(comparator);
            return;
        }
        byte[] elements = toByteArray();
        ByteArrays.stableSort(elements, comparator);
        setElements(elements);
    }

    @Deprecated
    default void unstableSort(Comparator<? super Byte> comparator) {
        unstableSort(ByteComparators.asByteComparator(comparator));
    }

    default void unstableSort(ByteComparator comparator) {
        byte[] elements = toByteArray();
        if (comparator == null) {
            ByteArrays.unstableSort(elements);
        } else {
            ByteArrays.unstableSort(elements, comparator);
        }
        setElements(elements);
    }
}
