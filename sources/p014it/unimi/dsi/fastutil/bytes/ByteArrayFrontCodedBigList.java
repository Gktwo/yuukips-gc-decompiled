package p014it.unimi.dsi.fastutil.bytes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.longs.LongBigArrays;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList;
import p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteArrayFrontCodedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteArrayFrontCodedBigList.class */
public class ByteArrayFrontCodedBigList extends AbstractObjectBigList<byte[]> implements Serializable, Cloneable, RandomAccess {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    protected final long f1210n;
    protected final int ratio;
    protected final byte[][] array;

    /* renamed from: p */
    protected transient long[][] f1211p;

    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARN: Type inference failed for: r0v53, types: [long] */
    public ByteArrayFrontCodedBigList(Iterator<byte[]> arrays, int ratio) {
        char c;
        if (ratio < 1) {
            throw new IllegalArgumentException("Illegal ratio (" + ratio + ")");
        }
        byte[][] array = ByteBigArrays.EMPTY_BIG_ARRAY;
        long[][] p = LongBigArrays.EMPTY_BIG_ARRAY;
        byte[][] a = new byte[2];
        char c2 = 0;
        char c3 = 0;
        int b = 0;
        while (arrays.hasNext()) {
            a[b] = arrays.next();
            int length = a[b].length;
            if (c3 % ((long) ratio) == 0) {
                p = BigArrays.grow(p, (c3 / ((long) ratio)) + serialVersionUID);
                BigArrays.set(p, c3 / ((long) ratio), (long) c2);
                array = BigArrays.grow(array, c2 + ((long) ByteArrayFrontCodedList.count(length)) + ((long) length), (long) c2);
                c = c2 + ((long) ByteArrayFrontCodedList.writeInt(array, length, c2));
                BigArrays.copyToBig(a[b], 0, array, (long) c, (long) length);
            } else {
                int minLength = Math.min(a[1 - b].length, length);
                int common = 0;
                while (common < minLength && a[0][common] == a[1][common]) {
                    common++;
                }
                length -= common;
                array = BigArrays.grow(array, c2 + ((long) ByteArrayFrontCodedList.count(length)) + ((long) ByteArrayFrontCodedList.count(common)) + ((long) length), (long) c2);
                long curSize = c2 + ((long) ByteArrayFrontCodedList.writeInt(array, length, c2));
                c = curSize + ((long) ByteArrayFrontCodedList.writeInt(array, common, curSize));
                BigArrays.copyToBig(a[b], common, array, (long) c, (long) length);
            }
            c2 = c + ((long) length);
            b = 1 - b;
            c3 += serialVersionUID;
        }
        this.f1210n = c3;
        this.ratio = ratio;
        this.array = BigArrays.trim(array, (long) c2);
        this.f1211p = BigArrays.trim(p, ((c3 + ((long) ratio)) - serialVersionUID) / ((long) ratio));
    }

    public ByteArrayFrontCodedBigList(Collection<byte[]> c, int ratio) {
        this(c.iterator(), ratio);
    }

    public int ratio() {
        return this.ratio;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* access modifiers changed from: private */
    public int length(long index) {
        byte[][] array = this.array;
        int delta = (int) (index % ((long) this.ratio));
        long pos = BigArrays.get(this.f1211p, index / ((long) this.ratio));
        int length = ByteArrayFrontCodedList.readInt(array, pos);
        if (delta == 0) {
            return length;
        }
        char count = pos + ((long) (ByteArrayFrontCodedList.count(length) + length));
        int length2 = ByteArrayFrontCodedList.readInt(array, count);
        int common = ByteArrayFrontCodedList.readInt(array, count + ((long) ByteArrayFrontCodedList.count(length2)));
        for (int i = 0; i < delta - 1; i++) {
            count += (long) (ByteArrayFrontCodedList.count(length2) + ByteArrayFrontCodedList.count(common) + length2);
            length2 = ByteArrayFrontCodedList.readInt(array, count);
            common = ByteArrayFrontCodedList.readInt(array, count + ((long) ByteArrayFrontCodedList.count(length2)));
        }
        return length2 + common;
    }

    public int arrayLength(long index) {
        ensureRestrictedIndex(index);
        return length(index);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v24, types: [long] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int extract(long r10, byte[] r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteArrayFrontCodedBigList.extract(long, byte[], int, int):int");
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public byte[] get(long index) {
        return getArray(index);
    }

    public byte[] getArray(long index) {
        ensureRestrictedIndex(index);
        int length = length(index);
        byte[] a = new byte[length];
        extract(index, a, 0, length);
        return a;
    }

    public int get(long index, byte[] a, int offset, int length) {
        ensureRestrictedIndex(index);
        ByteArrays.ensureOffsetLength(a, offset, length);
        int arrayLength = extract(index, a, offset, length);
        return length >= arrayLength ? arrayLength : length - arrayLength;
    }

    public int get(long index, byte[] a) {
        return get(index, a, 0, a.length);
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.f1210n;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public ObjectBigListIterator<byte[]> listIterator(final long start) {
        ensureIndex(start);
        return new ObjectBigListIterator<byte[]>() { // from class: it.unimi.dsi.fastutil.bytes.ByteArrayFrontCodedBigList.1

            /* renamed from: s */
            byte[] f1212s = ByteArrays.EMPTY_ARRAY;

            /* renamed from: i */
            long f1213i;
            long pos;
            boolean inSync;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f1213i = 0;
                this.pos = 0;
                if (start == 0) {
                    return;
                }
                if (start == ByteArrayFrontCodedBigList.this.f1210n) {
                    this.f1213i = start;
                    return;
                }
                this.pos = BigArrays.get(ByteArrayFrontCodedBigList.this.f1211p, start / ((long) ByteArrayFrontCodedBigList.this.ratio));
                int j = (int) (start % ((long) ByteArrayFrontCodedBigList.this.ratio));
                this.f1213i = start - ((long) j);
                while (true) {
                    j--;
                    if (j != 0) {
                        next();
                    } else {
                        return;
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f1213i < ByteArrayFrontCodedBigList.this.f1210n;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.f1213i > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.f1213i - ByteArrayFrontCodedBigList.serialVersionUID;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.f1213i;
            }

            @Override // java.util.Iterator
            public byte[] next() {
                int length;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.f1213i % ((long) ByteArrayFrontCodedBigList.this.ratio) == 0) {
                    this.pos = BigArrays.get(ByteArrayFrontCodedBigList.this.f1211p, this.f1213i / ((long) ByteArrayFrontCodedBigList.this.ratio));
                    length = ByteArrayFrontCodedList.readInt(ByteArrayFrontCodedBigList.this.array, this.pos);
                    this.f1212s = ByteArrays.ensureCapacity(this.f1212s, length, 0);
                    BigArrays.copyFromBig(ByteArrayFrontCodedBigList.this.array, this.pos + ((long) ByteArrayFrontCodedList.count(length)), this.f1212s, 0, length);
                    this.pos += (long) (length + ByteArrayFrontCodedList.count(length));
                    this.inSync = true;
                } else if (this.inSync) {
                    int length2 = ByteArrayFrontCodedList.readInt(ByteArrayFrontCodedBigList.this.array, this.pos);
                    int common = ByteArrayFrontCodedList.readInt(ByteArrayFrontCodedBigList.this.array, this.pos + ((long) ByteArrayFrontCodedList.count(length2)));
                    this.f1212s = ByteArrays.ensureCapacity(this.f1212s, length2 + common, common);
                    BigArrays.copyFromBig(ByteArrayFrontCodedBigList.this.array, this.pos + ((long) ByteArrayFrontCodedList.count(length2)) + ((long) ByteArrayFrontCodedList.count(common)), this.f1212s, common, length2);
                    this.pos += (long) (ByteArrayFrontCodedList.count(length2) + ByteArrayFrontCodedList.count(common) + length2);
                    length = length2 + common;
                } else {
                    byte[] bArr = this.f1212s;
                    int length3 = ByteArrayFrontCodedBigList.this.length(this.f1213i);
                    length = length3;
                    this.f1212s = ByteArrays.ensureCapacity(bArr, length3, 0);
                    ByteArrayFrontCodedBigList.this.extract(this.f1213i, this.f1212s, 0, length);
                }
                this.f1213i += ByteArrayFrontCodedBigList.serialVersionUID;
                return ByteArrays.copy(this.f1212s, 0, length);
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public byte[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                ByteArrayFrontCodedBigList byteArrayFrontCodedBigList = ByteArrayFrontCodedBigList.this;
                long j = this.f1213i - ByteArrayFrontCodedBigList.serialVersionUID;
                this.f1213i = j;
                return byteArrayFrontCodedBigList.getArray(j);
            }
        };
    }

    @Override // java.lang.Object
    public ByteArrayFrontCodedBigList clone() {
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (long i = 0; i < this.f1210n; i += serialVersionUID) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(ByteArrayList.wrap(getArray(i)).toString());
        }
        s.append("]");
        return s.toString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0084 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    /* JADX WARN: Type inference failed for: r14v5 */
    protected long[][] rebuildPointerArray() {
        int i;
        char c;
        long[][] p = LongBigArrays.newBigArray(((this.f1210n + ((long) this.ratio)) - serialVersionUID) / ((long) this.ratio));
        byte[][] a = this.array;
        char c2 = 0;
        int skip = this.ratio - 1;
        char c3 = 0;
        long j = 0;
        while (c3 < this.f1210n) {
            int length = ByteArrayFrontCodedList.readInt(a, c2 == 1 ? 1 : 0);
            int count = ByteArrayFrontCodedList.count(length);
            skip++;
            if (skip == this.ratio) {
                skip = 0;
                j += serialVersionUID;
                BigArrays.set(p, j, (long) c2);
                c = c2;
                i = count;
            } else {
                c = c2 == 1 ? 1 : 0;
                i = count + ByteArrayFrontCodedList.count(ByteArrayFrontCodedList.readInt(a, c2 + ((long) count)));
            }
            c3 += serialVersionUID;
            c2 = c + ((long) (i + length));
        }
        return p;
    }

    public void dump(DataOutputStream array, DataOutputStream pointers) throws IOException {
        byte[][] bArr = this.array;
        for (byte[] s : bArr) {
            for (byte e : s) {
                array.writeByte(e);
            }
        }
        long[][] jArr = this.f1211p;
        for (long[] s2 : jArr) {
            for (long e2 : s2) {
                pointers.writeLong(e2);
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1211p = rebuildPointerArray();
    }
}
