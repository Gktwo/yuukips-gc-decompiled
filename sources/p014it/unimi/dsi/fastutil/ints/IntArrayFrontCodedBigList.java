package p014it.unimi.dsi.fastutil.ints;

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

/* renamed from: it.unimi.dsi.fastutil.ints.IntArrayFrontCodedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntArrayFrontCodedBigList.class */
public class IntArrayFrontCodedBigList extends AbstractObjectBigList<int[]> implements Serializable, Cloneable, RandomAccess {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    protected final long f2106n;
    protected final int ratio;
    protected final int[][] array;

    /* renamed from: p */
    protected transient long[][] f2107p;

    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARN: Type inference failed for: r0v53, types: [long] */
    public IntArrayFrontCodedBigList(Iterator<int[]> arrays, int ratio) {
        char c;
        if (ratio < 1) {
            throw new IllegalArgumentException("Illegal ratio (" + ratio + ")");
        }
        int[][] array = IntBigArrays.EMPTY_BIG_ARRAY;
        long[][] p = LongBigArrays.EMPTY_BIG_ARRAY;
        int[][] a = new int[2];
        char c2 = 0;
        char c3 = 0;
        int b = 0;
        while (arrays.hasNext()) {
            a[b] = arrays.next();
            int length = a[b].length;
            if (c3 % ((long) ratio) == 0) {
                p = BigArrays.grow(p, (c3 / ((long) ratio)) + serialVersionUID);
                BigArrays.set(p, c3 / ((long) ratio), (long) c2);
                array = BigArrays.grow(array, c2 + ((long) IntArrayFrontCodedList.count(length)) + ((long) length), (long) c2);
                c = c2 + ((long) IntArrayFrontCodedList.writeInt(array, length, c2));
                BigArrays.copyToBig(a[b], 0, array, (long) c, (long) length);
            } else {
                int minLength = Math.min(a[1 - b].length, length);
                int common = 0;
                while (common < minLength && a[0][common] == a[1][common]) {
                    common++;
                }
                length -= common;
                array = BigArrays.grow(array, c2 + ((long) IntArrayFrontCodedList.count(length)) + ((long) IntArrayFrontCodedList.count(common)) + ((long) length), (long) c2);
                long curSize = c2 + ((long) IntArrayFrontCodedList.writeInt(array, length, c2));
                c = curSize + ((long) IntArrayFrontCodedList.writeInt(array, common, curSize));
                BigArrays.copyToBig(a[b], common, array, (long) c, (long) length);
            }
            c2 = c + ((long) length);
            b = 1 - b;
            c3 += serialVersionUID;
        }
        this.f2106n = c3;
        this.ratio = ratio;
        this.array = BigArrays.trim(array, (long) c2);
        this.f2107p = BigArrays.trim(p, ((c3 + ((long) ratio)) - serialVersionUID) / ((long) ratio));
    }

    public IntArrayFrontCodedBigList(Collection<int[]> c, int ratio) {
        this(c.iterator(), ratio);
    }

    public int ratio() {
        return this.ratio;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* access modifiers changed from: private */
    public int length(long index) {
        int[][] array = this.array;
        int delta = (int) (index % ((long) this.ratio));
        long pos = BigArrays.get(this.f2107p, index / ((long) this.ratio));
        int length = IntArrayFrontCodedList.readInt(array, pos);
        if (delta == 0) {
            return length;
        }
        char count = pos + ((long) (IntArrayFrontCodedList.count(length) + length));
        int length2 = IntArrayFrontCodedList.readInt(array, count);
        int common = IntArrayFrontCodedList.readInt(array, count + ((long) IntArrayFrontCodedList.count(length2)));
        for (int i = 0; i < delta - 1; i++) {
            count += (long) (IntArrayFrontCodedList.count(length2) + IntArrayFrontCodedList.count(common) + length2);
            length2 = IntArrayFrontCodedList.readInt(array, count);
            common = IntArrayFrontCodedList.readInt(array, count + ((long) IntArrayFrontCodedList.count(length2)));
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
    public int extract(long r10, int[] r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntArrayFrontCodedBigList.extract(long, int[], int, int):int");
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public int[] get(long index) {
        return getArray(index);
    }

    public int[] getArray(long index) {
        ensureRestrictedIndex(index);
        int length = length(index);
        int[] a = new int[length];
        extract(index, a, 0, length);
        return a;
    }

    public int get(long index, int[] a, int offset, int length) {
        ensureRestrictedIndex(index);
        IntArrays.ensureOffsetLength(a, offset, length);
        int arrayLength = extract(index, a, offset, length);
        return length >= arrayLength ? arrayLength : length - arrayLength;
    }

    public int get(long index, int[] a) {
        return get(index, a, 0, a.length);
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.f2106n;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public ObjectBigListIterator<int[]> listIterator(final long start) {
        ensureIndex(start);
        return new ObjectBigListIterator<int[]>() { // from class: it.unimi.dsi.fastutil.ints.IntArrayFrontCodedBigList.1

            /* renamed from: s */
            int[] f2108s = IntArrays.EMPTY_ARRAY;

            /* renamed from: i */
            long f2109i;
            long pos;
            boolean inSync;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f2109i = 0;
                this.pos = 0;
                if (start == 0) {
                    return;
                }
                if (start == IntArrayFrontCodedBigList.this.f2106n) {
                    this.f2109i = start;
                    return;
                }
                this.pos = BigArrays.get(IntArrayFrontCodedBigList.this.f2107p, start / ((long) IntArrayFrontCodedBigList.this.ratio));
                int j = (int) (start % ((long) IntArrayFrontCodedBigList.this.ratio));
                this.f2109i = start - ((long) j);
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
                return this.f2109i < IntArrayFrontCodedBigList.this.f2106n;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.f2109i > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.f2109i - IntArrayFrontCodedBigList.serialVersionUID;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.f2109i;
            }

            @Override // java.util.Iterator
            public int[] next() {
                int length;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.f2109i % ((long) IntArrayFrontCodedBigList.this.ratio) == 0) {
                    this.pos = BigArrays.get(IntArrayFrontCodedBigList.this.f2107p, this.f2109i / ((long) IntArrayFrontCodedBigList.this.ratio));
                    length = IntArrayFrontCodedList.readInt(IntArrayFrontCodedBigList.this.array, this.pos);
                    this.f2108s = IntArrays.ensureCapacity(this.f2108s, length, 0);
                    BigArrays.copyFromBig(IntArrayFrontCodedBigList.this.array, this.pos + ((long) IntArrayFrontCodedList.count(length)), this.f2108s, 0, length);
                    this.pos += (long) (length + IntArrayFrontCodedList.count(length));
                    this.inSync = true;
                } else if (this.inSync) {
                    int length2 = IntArrayFrontCodedList.readInt(IntArrayFrontCodedBigList.this.array, this.pos);
                    int common = IntArrayFrontCodedList.readInt(IntArrayFrontCodedBigList.this.array, this.pos + ((long) IntArrayFrontCodedList.count(length2)));
                    this.f2108s = IntArrays.ensureCapacity(this.f2108s, length2 + common, common);
                    BigArrays.copyFromBig(IntArrayFrontCodedBigList.this.array, this.pos + ((long) IntArrayFrontCodedList.count(length2)) + ((long) IntArrayFrontCodedList.count(common)), this.f2108s, common, length2);
                    this.pos += (long) (IntArrayFrontCodedList.count(length2) + IntArrayFrontCodedList.count(common) + length2);
                    length = length2 + common;
                } else {
                    int[] iArr = this.f2108s;
                    int length3 = IntArrayFrontCodedBigList.this.length(this.f2109i);
                    length = length3;
                    this.f2108s = IntArrays.ensureCapacity(iArr, length3, 0);
                    IntArrayFrontCodedBigList.this.extract(this.f2109i, this.f2108s, 0, length);
                }
                this.f2109i += IntArrayFrontCodedBigList.serialVersionUID;
                return IntArrays.copy(this.f2108s, 0, length);
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public int[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                IntArrayFrontCodedBigList intArrayFrontCodedBigList = IntArrayFrontCodedBigList.this;
                long j = this.f2109i - IntArrayFrontCodedBigList.serialVersionUID;
                this.f2109i = j;
                return intArrayFrontCodedBigList.getArray(j);
            }
        };
    }

    @Override // java.lang.Object
    public IntArrayFrontCodedBigList clone() {
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (long i = 0; i < this.f2106n; i += serialVersionUID) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(IntArrayList.wrap(getArray(i)).toString());
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
        long[][] p = LongBigArrays.newBigArray(((this.f2106n + ((long) this.ratio)) - serialVersionUID) / ((long) this.ratio));
        int[][] a = this.array;
        char c2 = 0;
        int skip = this.ratio - 1;
        char c3 = 0;
        long j = 0;
        while (c3 < this.f2106n) {
            int length = IntArrayFrontCodedList.readInt(a, c2 == 1 ? 1 : 0);
            int count = IntArrayFrontCodedList.count(length);
            skip++;
            if (skip == this.ratio) {
                skip = 0;
                j += serialVersionUID;
                BigArrays.set(p, j, (long) c2);
                c = c2;
                i = count;
            } else {
                c = c2 == 1 ? 1 : 0;
                i = count + IntArrayFrontCodedList.count(IntArrayFrontCodedList.readInt(a, c2 + ((long) count)));
            }
            c3 += serialVersionUID;
            c2 = c + ((long) (i + length));
        }
        return p;
    }

    public void dump(DataOutputStream array, DataOutputStream pointers) throws IOException {
        int[][] iArr = this.array;
        for (int[] s : iArr) {
            for (int e : s) {
                array.writeInt(e);
            }
        }
        long[][] jArr = this.f2107p;
        for (long[] s2 : jArr) {
            for (long e2 : s2) {
                pointers.writeLong(e2);
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2107p = rebuildPointerArray();
    }
}
