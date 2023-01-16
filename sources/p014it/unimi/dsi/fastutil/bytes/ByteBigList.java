package p014it.unimi.dsi.fastutil.bytes;

import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBigList.class */
public interface ByteBigList extends BigList<Byte>, ByteCollection, Comparable<BigList<? extends Byte>> {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    ByteBigListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.BigList
    BigListIterator<Byte> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.BigList
    BigListIterator<Byte> listIterator(long j);

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.BigList
    BigList<Byte> subList(long j, long j2);

    void getElements(long j, byte[][] bArr, long j2, long j3);

    void removeElements(long j, long j2);

    void addElements(long j, byte[][] bArr);

    void addElements(long j, byte[][] bArr, long j2, long j3);

    void add(long j, byte b);

    boolean addAll(long j, ByteCollection byteCollection);

    byte getByte(long j);

    byte removeByte(long j);

    byte set(long j, byte b);

    long indexOf(byte b);

    long lastIndexOf(byte b);

    @Deprecated
    void add(long j, Byte b);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    Byte get(long j);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    long indexOf(Object obj);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    long lastIndexOf(Object obj);

    @Override // p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    Byte remove(long j);

    @Deprecated
    Byte set(long j, Byte b);

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    default ByteSpliterator spliterator() {
        return ByteSpliterators.asSpliterator(iterator(), size64(), 16720);
    }

    default void getElements(long from, byte[] a, int offset, int length) {
        getElements(from, new byte[][]{a}, (long) offset, (long) length);
    }

    default void setElements(byte[][] a) {
        setElements(0, a);
    }

    default void setElements(long index, byte[][] a) {
        setElements(index, a, 0, BigArrays.length(a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [byte[][], long] */
    /* JADX WARN: Type inference failed for: r0v9, types: [it.unimi.dsi.fastutil.bytes.ByteBigListIterator] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(long r12, byte[][] r14, long r15, long r17) {
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
            it.unimi.dsi.fastutil.bytes.ByteBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
            r0 = 0
            r20 = r0
        L_0x00b2:
            r0 = r20
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00da
            r0 = r19
            byte r0 = r0.nextByte()
            r0 = r19
            r1 = r14
            r2 = r15
            r3 = r20
            r4 = r3; r1 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r20 = r4
            long r2 = r2 + r3
            byte r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.set(r1)
            goto L_0x00b2
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteBigList.setElements(long, byte[][], long, long):void");
    }

    default boolean addAll(long index, ByteBigList l) {
        return addAll(index, (ByteCollection) l);
    }

    default boolean addAll(ByteBigList l) {
        return addAll(size64(), l);
    }

    default boolean addAll(long index, ByteList l) {
        return addAll(index, (ByteCollection) l);
    }

    default boolean addAll(ByteList l) {
        return addAll(size64(), l);
    }
}
