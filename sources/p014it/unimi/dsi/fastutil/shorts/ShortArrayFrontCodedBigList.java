package p014it.unimi.dsi.fastutil.shorts;

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

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrayFrontCodedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrayFrontCodedBigList.class */
public class ShortArrayFrontCodedBigList extends AbstractObjectBigList<short[]> implements Serializable, Cloneable, RandomAccess {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    protected final long f3014n;
    protected final int ratio;
    protected final short[][] array;

    /* renamed from: p */
    protected transient long[][] f3015p;

    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARN: Type inference failed for: r0v53, types: [long] */
    public ShortArrayFrontCodedBigList(Iterator<short[]> arrays, int ratio) {
        char c;
        if (ratio < 1) {
            throw new IllegalArgumentException("Illegal ratio (" + ratio + ")");
        }
        short[][] array = ShortBigArrays.EMPTY_BIG_ARRAY;
        long[][] p = LongBigArrays.EMPTY_BIG_ARRAY;
        short[][] a = new short[2];
        char c2 = 0;
        char c3 = 0;
        int b = 0;
        while (arrays.hasNext()) {
            a[b] = arrays.next();
            int length = a[b].length;
            if (c3 % ((long) ratio) == 0) {
                p = BigArrays.grow(p, (c3 / ((long) ratio)) + serialVersionUID);
                BigArrays.set(p, c3 / ((long) ratio), (long) c2);
                array = BigArrays.grow(array, c2 + ((long) ShortArrayFrontCodedList.count(length)) + ((long) length), (long) c2);
                c = c2 + ((long) ShortArrayFrontCodedList.writeInt(array, length, c2));
                BigArrays.copyToBig(a[b], 0, array, (long) c, (long) length);
            } else {
                int minLength = Math.min(a[1 - b].length, length);
                int common = 0;
                while (common < minLength && a[0][common] == a[1][common]) {
                    common++;
                }
                length -= common;
                array = BigArrays.grow(array, c2 + ((long) ShortArrayFrontCodedList.count(length)) + ((long) ShortArrayFrontCodedList.count(common)) + ((long) length), (long) c2);
                long curSize = c2 + ((long) ShortArrayFrontCodedList.writeInt(array, length, c2));
                c = curSize + ((long) ShortArrayFrontCodedList.writeInt(array, common, curSize));
                BigArrays.copyToBig(a[b], common, array, (long) c, (long) length);
            }
            c2 = c + ((long) length);
            b = 1 - b;
            c3 += serialVersionUID;
        }
        this.f3014n = c3;
        this.ratio = ratio;
        this.array = BigArrays.trim(array, (long) c2);
        this.f3015p = BigArrays.trim(p, ((c3 + ((long) ratio)) - serialVersionUID) / ((long) ratio));
    }

    public ShortArrayFrontCodedBigList(Collection<short[]> c, int ratio) {
        this(c.iterator(), ratio);
    }

    public int ratio() {
        return this.ratio;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* access modifiers changed from: private */
    public int length(long index) {
        short[][] array = this.array;
        int delta = (int) (index % ((long) this.ratio));
        long pos = BigArrays.get(this.f3015p, index / ((long) this.ratio));
        int length = ShortArrayFrontCodedList.readInt(array, pos);
        if (delta == 0) {
            return length;
        }
        char count = pos + ((long) (ShortArrayFrontCodedList.count(length) + length));
        int length2 = ShortArrayFrontCodedList.readInt(array, count);
        int common = ShortArrayFrontCodedList.readInt(array, count + ((long) ShortArrayFrontCodedList.count(length2)));
        for (int i = 0; i < delta - 1; i++) {
            count += (long) (ShortArrayFrontCodedList.count(length2) + ShortArrayFrontCodedList.count(common) + length2);
            length2 = ShortArrayFrontCodedList.readInt(array, count);
            common = ShortArrayFrontCodedList.readInt(array, count + ((long) ShortArrayFrontCodedList.count(length2)));
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
    public int extract(long r10, short[] r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortArrayFrontCodedBigList.extract(long, short[], int, int):int");
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public short[] get(long index) {
        return getArray(index);
    }

    public short[] getArray(long index) {
        ensureRestrictedIndex(index);
        int length = length(index);
        short[] a = new short[length];
        extract(index, a, 0, length);
        return a;
    }

    public int get(long index, short[] a, int offset, int length) {
        ensureRestrictedIndex(index);
        ShortArrays.ensureOffsetLength(a, offset, length);
        int arrayLength = extract(index, a, offset, length);
        return length >= arrayLength ? arrayLength : length - arrayLength;
    }

    public int get(long index, short[] a) {
        return get(index, a, 0, a.length);
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.f3014n;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public ObjectBigListIterator<short[]> listIterator(final long start) {
        ensureIndex(start);
        return new ObjectBigListIterator<short[]>() { // from class: it.unimi.dsi.fastutil.shorts.ShortArrayFrontCodedBigList.1

            /* renamed from: s */
            short[] f3016s = ShortArrays.EMPTY_ARRAY;

            /* renamed from: i */
            long f3017i;
            long pos;
            boolean inSync;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f3017i = 0;
                this.pos = 0;
                if (start == 0) {
                    return;
                }
                if (start == ShortArrayFrontCodedBigList.this.f3014n) {
                    this.f3017i = start;
                    return;
                }
                this.pos = BigArrays.get(ShortArrayFrontCodedBigList.this.f3015p, start / ((long) ShortArrayFrontCodedBigList.this.ratio));
                int j = (int) (start % ((long) ShortArrayFrontCodedBigList.this.ratio));
                this.f3017i = start - ((long) j);
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
                return this.f3017i < ShortArrayFrontCodedBigList.this.f3014n;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.f3017i > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.f3017i - ShortArrayFrontCodedBigList.serialVersionUID;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.f3017i;
            }

            @Override // java.util.Iterator
            public short[] next() {
                int length;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.f3017i % ((long) ShortArrayFrontCodedBigList.this.ratio) == 0) {
                    this.pos = BigArrays.get(ShortArrayFrontCodedBigList.this.f3015p, this.f3017i / ((long) ShortArrayFrontCodedBigList.this.ratio));
                    length = ShortArrayFrontCodedList.readInt(ShortArrayFrontCodedBigList.this.array, this.pos);
                    this.f3016s = ShortArrays.ensureCapacity(this.f3016s, length, 0);
                    BigArrays.copyFromBig(ShortArrayFrontCodedBigList.this.array, this.pos + ((long) ShortArrayFrontCodedList.count(length)), this.f3016s, 0, length);
                    this.pos += (long) (length + ShortArrayFrontCodedList.count(length));
                    this.inSync = true;
                } else if (this.inSync) {
                    int length2 = ShortArrayFrontCodedList.readInt(ShortArrayFrontCodedBigList.this.array, this.pos);
                    int common = ShortArrayFrontCodedList.readInt(ShortArrayFrontCodedBigList.this.array, this.pos + ((long) ShortArrayFrontCodedList.count(length2)));
                    this.f3016s = ShortArrays.ensureCapacity(this.f3016s, length2 + common, common);
                    BigArrays.copyFromBig(ShortArrayFrontCodedBigList.this.array, this.pos + ((long) ShortArrayFrontCodedList.count(length2)) + ((long) ShortArrayFrontCodedList.count(common)), this.f3016s, common, length2);
                    this.pos += (long) (ShortArrayFrontCodedList.count(length2) + ShortArrayFrontCodedList.count(common) + length2);
                    length = length2 + common;
                } else {
                    short[] sArr = this.f3016s;
                    int length3 = ShortArrayFrontCodedBigList.this.length(this.f3017i);
                    length = length3;
                    this.f3016s = ShortArrays.ensureCapacity(sArr, length3, 0);
                    ShortArrayFrontCodedBigList.this.extract(this.f3017i, this.f3016s, 0, length);
                }
                this.f3017i += ShortArrayFrontCodedBigList.serialVersionUID;
                return ShortArrays.copy(this.f3016s, 0, length);
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public short[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                ShortArrayFrontCodedBigList shortArrayFrontCodedBigList = ShortArrayFrontCodedBigList.this;
                long j = this.f3017i - ShortArrayFrontCodedBigList.serialVersionUID;
                this.f3017i = j;
                return shortArrayFrontCodedBigList.getArray(j);
            }
        };
    }

    @Override // java.lang.Object
    public ShortArrayFrontCodedBigList clone() {
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (long i = 0; i < this.f3014n; i += serialVersionUID) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(ShortArrayList.wrap(getArray(i)).toString());
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
        long[][] p = LongBigArrays.newBigArray(((this.f3014n + ((long) this.ratio)) - serialVersionUID) / ((long) this.ratio));
        short[][] a = this.array;
        char c2 = 0;
        int skip = this.ratio - 1;
        char c3 = 0;
        long j = 0;
        while (c3 < this.f3014n) {
            int length = ShortArrayFrontCodedList.readInt(a, c2 == 1 ? 1 : 0);
            int count = ShortArrayFrontCodedList.count(length);
            skip++;
            if (skip == this.ratio) {
                skip = 0;
                j += serialVersionUID;
                BigArrays.set(p, j, (long) c2);
                c = c2;
                i = count;
            } else {
                c = c2 == 1 ? 1 : 0;
                i = count + ShortArrayFrontCodedList.count(ShortArrayFrontCodedList.readInt(a, c2 + ((long) count)));
            }
            c3 += serialVersionUID;
            c2 = c + ((long) (i + length));
        }
        return p;
    }

    public void dump(DataOutputStream array, DataOutputStream pointers) throws IOException {
        short[][] sArr = this.array;
        for (short[] s : sArr) {
            for (short e : s) {
                array.writeShort(e);
            }
        }
        long[][] jArr = this.f3015p;
        for (long[] s2 : jArr) {
            for (long e2 : s2) {
                pointers.writeLong(e2);
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f3015p = rebuildPointerArray();
    }
}
