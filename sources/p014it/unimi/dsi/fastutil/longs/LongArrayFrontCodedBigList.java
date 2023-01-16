package p014it.unimi.dsi.fastutil.longs;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList;
import p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator;

/* renamed from: it.unimi.dsi.fastutil.longs.LongArrayFrontCodedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrayFrontCodedBigList.class */
public class LongArrayFrontCodedBigList extends AbstractObjectBigList<long[]> implements Serializable, Cloneable, RandomAccess {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    protected final long f2384n;
    protected final int ratio;
    protected final long[][] array;

    /* renamed from: p */
    protected transient long[][] f2385p;

    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARN: Type inference failed for: r0v54, types: [long] */
    public LongArrayFrontCodedBigList(Iterator<long[]> arrays, int ratio) {
        char c;
        if (ratio < 1) {
            throw new IllegalArgumentException("Illegal ratio (" + ratio + ")");
        }
        long[][] array = LongBigArrays.EMPTY_BIG_ARRAY;
        long[][] p = LongBigArrays.EMPTY_BIG_ARRAY;
        long[][] a = new long[2];
        char c2 = 0;
        char c3 = 0;
        int b = 0;
        while (arrays.hasNext()) {
            a[b] = arrays.next();
            int length = a[b].length;
            if (c3 % ((long) ratio) == 0) {
                p = BigArrays.grow(p, (c3 / ((long) ratio)) + serialVersionUID);
                BigArrays.set(p, c3 / ((long) ratio), (long) c2);
                array = BigArrays.grow(array, c2 + ((long) LongArrayFrontCodedList.count(length)) + ((long) length), (long) c2);
                c = c2 + ((long) LongArrayFrontCodedList.writeInt(array, length, c2));
                BigArrays.copyToBig(a[b], 0, array, (long) c, (long) length);
            } else {
                int minLength = Math.min(a[1 - b].length, length);
                int common = 0;
                while (common < minLength && a[0][common] == a[1][common]) {
                    common++;
                }
                length -= common;
                array = BigArrays.grow(array, c2 + ((long) LongArrayFrontCodedList.count(length)) + ((long) LongArrayFrontCodedList.count(common)) + ((long) length), (long) c2);
                long curSize = c2 + ((long) LongArrayFrontCodedList.writeInt(array, length, c2));
                c = curSize + ((long) LongArrayFrontCodedList.writeInt(array, common, curSize));
                BigArrays.copyToBig(a[b], common, array, (long) c, (long) length);
            }
            c2 = c + ((long) length);
            b = 1 - b;
            c3 += serialVersionUID;
        }
        this.f2384n = c3;
        this.ratio = ratio;
        this.array = BigArrays.trim(array, (long) c2);
        this.f2385p = BigArrays.trim(p, ((c3 + ((long) ratio)) - serialVersionUID) / ((long) ratio));
    }

    public LongArrayFrontCodedBigList(Collection<long[]> c, int ratio) {
        this(c.iterator(), ratio);
    }

    public int ratio() {
        return this.ratio;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* access modifiers changed from: private */
    public int length(long index) {
        long[][] array = this.array;
        int delta = (int) (index % ((long) this.ratio));
        long pos = BigArrays.get(this.f2385p, index / ((long) this.ratio));
        int length = LongArrayFrontCodedList.readInt(array, pos);
        if (delta == 0) {
            return length;
        }
        char count = pos + ((long) (LongArrayFrontCodedList.count(length) + length));
        int length2 = LongArrayFrontCodedList.readInt(array, count);
        int common = LongArrayFrontCodedList.readInt(array, count + ((long) LongArrayFrontCodedList.count(length2)));
        for (int i = 0; i < delta - 1; i++) {
            count += (long) (LongArrayFrontCodedList.count(length2) + LongArrayFrontCodedList.count(common) + length2);
            length2 = LongArrayFrontCodedList.readInt(array, count);
            common = LongArrayFrontCodedList.readInt(array, count + ((long) LongArrayFrontCodedList.count(length2)));
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
    public int extract(long r10, long[] r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongArrayFrontCodedBigList.extract(long, long[], int, int):int");
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public long[] get(long index) {
        return getArray(index);
    }

    public long[] getArray(long index) {
        ensureRestrictedIndex(index);
        int length = length(index);
        long[] a = new long[length];
        extract(index, a, 0, length);
        return a;
    }

    public int get(long index, long[] a, int offset, int length) {
        ensureRestrictedIndex(index);
        LongArrays.ensureOffsetLength(a, offset, length);
        int arrayLength = extract(index, a, offset, length);
        return length >= arrayLength ? arrayLength : length - arrayLength;
    }

    public int get(long index, long[] a) {
        return get(index, a, 0, a.length);
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.f2384n;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public ObjectBigListIterator<long[]> listIterator(final long start) {
        ensureIndex(start);
        return new ObjectBigListIterator<long[]>() { // from class: it.unimi.dsi.fastutil.longs.LongArrayFrontCodedBigList.1

            /* renamed from: s */
            long[] f2386s = LongArrays.EMPTY_ARRAY;

            /* renamed from: i */
            long f2387i;
            long pos;
            boolean inSync;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f2387i = 0;
                this.pos = 0;
                if (start == 0) {
                    return;
                }
                if (start == LongArrayFrontCodedBigList.this.f2384n) {
                    this.f2387i = start;
                    return;
                }
                this.pos = BigArrays.get(LongArrayFrontCodedBigList.this.f2385p, start / ((long) LongArrayFrontCodedBigList.this.ratio));
                int j = (int) (start % ((long) LongArrayFrontCodedBigList.this.ratio));
                this.f2387i = start - ((long) j);
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
                return this.f2387i < LongArrayFrontCodedBigList.this.f2384n;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.f2387i > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.f2387i - LongArrayFrontCodedBigList.serialVersionUID;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.f2387i;
            }

            @Override // java.util.Iterator
            public long[] next() {
                int length;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.f2387i % ((long) LongArrayFrontCodedBigList.this.ratio) == 0) {
                    this.pos = BigArrays.get(LongArrayFrontCodedBigList.this.f2385p, this.f2387i / ((long) LongArrayFrontCodedBigList.this.ratio));
                    length = LongArrayFrontCodedList.readInt(LongArrayFrontCodedBigList.this.array, this.pos);
                    this.f2386s = LongArrays.ensureCapacity(this.f2386s, length, 0);
                    BigArrays.copyFromBig(LongArrayFrontCodedBigList.this.array, this.pos + ((long) LongArrayFrontCodedList.count(length)), this.f2386s, 0, length);
                    this.pos += (long) (length + LongArrayFrontCodedList.count(length));
                    this.inSync = true;
                } else if (this.inSync) {
                    int length2 = LongArrayFrontCodedList.readInt(LongArrayFrontCodedBigList.this.array, this.pos);
                    int common = LongArrayFrontCodedList.readInt(LongArrayFrontCodedBigList.this.array, this.pos + ((long) LongArrayFrontCodedList.count(length2)));
                    this.f2386s = LongArrays.ensureCapacity(this.f2386s, length2 + common, common);
                    BigArrays.copyFromBig(LongArrayFrontCodedBigList.this.array, this.pos + ((long) LongArrayFrontCodedList.count(length2)) + ((long) LongArrayFrontCodedList.count(common)), this.f2386s, common, length2);
                    this.pos += (long) (LongArrayFrontCodedList.count(length2) + LongArrayFrontCodedList.count(common) + length2);
                    length = length2 + common;
                } else {
                    long[] jArr = this.f2386s;
                    int length3 = LongArrayFrontCodedBigList.this.length(this.f2387i);
                    length = length3;
                    this.f2386s = LongArrays.ensureCapacity(jArr, length3, 0);
                    LongArrayFrontCodedBigList.this.extract(this.f2387i, this.f2386s, 0, length);
                }
                this.f2387i += LongArrayFrontCodedBigList.serialVersionUID;
                return LongArrays.copy(this.f2386s, 0, length);
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public long[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                LongArrayFrontCodedBigList longArrayFrontCodedBigList = LongArrayFrontCodedBigList.this;
                long j = this.f2387i - LongArrayFrontCodedBigList.serialVersionUID;
                this.f2387i = j;
                return longArrayFrontCodedBigList.getArray(j);
            }
        };
    }

    @Override // java.lang.Object
    public LongArrayFrontCodedBigList clone() {
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (long i = 0; i < this.f2384n; i += serialVersionUID) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(LongArrayList.wrap(getArray(i)).toString());
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
        long[][] p = LongBigArrays.newBigArray(((this.f2384n + ((long) this.ratio)) - serialVersionUID) / ((long) this.ratio));
        long[][] a = this.array;
        char c2 = 0;
        int skip = this.ratio - 1;
        char c3 = 0;
        long j = 0;
        while (c3 < this.f2384n) {
            int length = LongArrayFrontCodedList.readInt(a, c2 == 1 ? 1 : 0);
            int count = LongArrayFrontCodedList.count(length);
            skip++;
            if (skip == this.ratio) {
                skip = 0;
                j += serialVersionUID;
                BigArrays.set(p, j, (long) c2);
                c = c2;
                i = count;
            } else {
                c = c2 == 1 ? 1 : 0;
                i = count + LongArrayFrontCodedList.count(LongArrayFrontCodedList.readInt(a, c2 + ((long) count)));
            }
            c3 += serialVersionUID;
            c2 = c + ((long) (i + length));
        }
        return p;
    }

    public void dump(DataOutputStream array, DataOutputStream pointers) throws IOException {
        long[][] jArr = this.array;
        for (long[] s : jArr) {
            for (long e : s) {
                array.writeLong(e);
            }
        }
        long[][] jArr2 = this.f2385p;
        for (long[] s2 : jArr2) {
            for (long e2 : s2) {
                pointers.writeLong(e2);
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2385p = rebuildPointerArray();
    }
}
