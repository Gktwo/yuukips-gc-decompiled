package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectList;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;

/* renamed from: it.unimi.dsi.fastutil.longs.LongArrayFrontCodedList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrayFrontCodedList.class */
public class LongArrayFrontCodedList extends AbstractObjectList<long[]> implements Serializable, Cloneable, RandomAccess {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    protected final int f2388n;
    protected final int ratio;
    protected final long[][] array;

    /* renamed from: p */
    protected transient long[] f2389p;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0143 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [long] */
    /* JADX WARN: Type inference failed for: r14v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r0v38, types: [long] */
    /* JADX WARN: Type inference failed for: r14v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v51, types: [long] */
    /* JADX WARN: Type inference failed for: r14v6, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LongArrayFrontCodedList(java.util.Iterator<long[]> r9, int r10) {
        /*
        // Method dump skipped, instructions count: 374
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongArrayFrontCodedList.<init>(java.util.Iterator, int):void");
    }

    public LongArrayFrontCodedList(Collection<long[]> c, int ratio) {
        this(c.iterator(), ratio);
    }

    /* access modifiers changed from: package-private */
    public static int readInt(long[][] a, long pos) {
        return (int) BigArrays.get(a, pos);
    }

    /* access modifiers changed from: package-private */
    public static int count(int length) {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public static int writeInt(long[][] a, int length, long pos) {
        BigArrays.set(a, pos, (long) length);
        return 1;
    }

    public int ratio() {
        return this.ratio;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* access modifiers changed from: private */
    public int length(int index) {
        long[][] array = this.array;
        int delta = index % this.ratio;
        long pos = this.f2389p[index / this.ratio];
        int length = readInt(array, pos);
        if (delta == 0) {
            return length;
        }
        char count = pos + ((long) (count(length) + length));
        int length2 = readInt(array, count);
        int common = readInt(array, count + ((long) count(length2)));
        for (int i = 0; i < delta - 1; i++) {
            count += (long) (count(length2) + count(common) + length2);
            length2 = readInt(array, count);
            common = readInt(array, count + ((long) count(length2)));
        }
        return length2 + common;
    }

    public int arrayLength(int index) {
        ensureRestrictedIndex(index);
        return length(index);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: long[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [long[][], long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int extract(int r10, long[] r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongArrayFrontCodedList.extract(int, long[], int, int):int");
    }

    @Override // java.util.List
    public long[] get(int index) {
        return getArray(index);
    }

    public long[] getArray(int index) {
        ensureRestrictedIndex(index);
        int length = length(index);
        long[] a = new long[length];
        extract(index, a, 0, length);
        return a;
    }

    public int get(int index, long[] a, int offset, int length) {
        ensureRestrictedIndex(index);
        LongArrays.ensureOffsetLength(a, offset, length);
        int arrayLength = extract(index, a, offset, length);
        return length >= arrayLength ? arrayLength : length - arrayLength;
    }

    public int get(int index, long[] a) {
        return get(index, a, 0, a.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2388n;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
    public ObjectListIterator<long[]> listIterator(final int start) {
        ensureIndex(start);
        return new ObjectListIterator<long[]>() { // from class: it.unimi.dsi.fastutil.longs.LongArrayFrontCodedList.1

            /* renamed from: s */
            long[] f2390s = LongArrays.EMPTY_ARRAY;

            /* renamed from: i */
            int f2391i;
            long pos;
            boolean inSync;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f2391i = 0;
                this.pos = 0;
                if (start == 0) {
                    return;
                }
                if (start == LongArrayFrontCodedList.this.f2388n) {
                    this.f2391i = start;
                    return;
                }
                this.pos = LongArrayFrontCodedList.this.f2389p[start / LongArrayFrontCodedList.this.ratio];
                int j = start % LongArrayFrontCodedList.this.ratio;
                this.f2391i = start - j;
                while (true) {
                    j--;
                    if (j != 0) {
                        next();
                    } else {
                        return;
                    }
                }
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.f2391i < LongArrayFrontCodedList.this.f2388n;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.f2391i > 0;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f2391i - 1;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f2391i;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public long[] next() {
                int length;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.f2391i % LongArrayFrontCodedList.this.ratio == 0) {
                    this.pos = LongArrayFrontCodedList.this.f2389p[this.f2391i / LongArrayFrontCodedList.this.ratio];
                    length = LongArrayFrontCodedList.readInt(LongArrayFrontCodedList.this.array, this.pos);
                    this.f2390s = LongArrays.ensureCapacity(this.f2390s, length, 0);
                    BigArrays.copyFromBig(LongArrayFrontCodedList.this.array, this.pos + ((long) LongArrayFrontCodedList.count(length)), this.f2390s, 0, length);
                    this.pos += (long) (length + LongArrayFrontCodedList.count(length));
                    this.inSync = true;
                } else if (this.inSync) {
                    int length2 = LongArrayFrontCodedList.readInt(LongArrayFrontCodedList.this.array, this.pos);
                    int common = LongArrayFrontCodedList.readInt(LongArrayFrontCodedList.this.array, this.pos + ((long) LongArrayFrontCodedList.count(length2)));
                    this.f2390s = LongArrays.ensureCapacity(this.f2390s, length2 + common, common);
                    BigArrays.copyFromBig(LongArrayFrontCodedList.this.array, this.pos + ((long) LongArrayFrontCodedList.count(length2)) + ((long) LongArrayFrontCodedList.count(common)), this.f2390s, common, length2);
                    this.pos += (long) (LongArrayFrontCodedList.count(length2) + LongArrayFrontCodedList.count(common) + length2);
                    length = length2 + common;
                } else {
                    long[] jArr = this.f2390s;
                    int length3 = LongArrayFrontCodedList.this.length(this.f2391i);
                    length = length3;
                    this.f2390s = LongArrays.ensureCapacity(jArr, length3, 0);
                    LongArrayFrontCodedList.this.extract(this.f2391i, this.f2390s, 0, length);
                }
                this.f2391i++;
                return LongArrays.copy(this.f2390s, 0, length);
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public long[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                LongArrayFrontCodedList longArrayFrontCodedList = LongArrayFrontCodedList.this;
                int i = this.f2391i - 1;
                this.f2391i = i;
                return longArrayFrontCodedList.getArray(i);
            }
        };
    }

    @Override // java.lang.Object
    public LongArrayFrontCodedList clone() {
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (int i = 0; i < this.f2388n; i++) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(LongArrayList.wrap(getArray(i)).toString());
        }
        s.append("]");
        return s.toString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x007c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v6 */
    protected long[] rebuildPointerArray() {
        int i;
        char c;
        long[] p = new long[((this.f2388n + this.ratio) - 1) / this.ratio];
        long[][] a = this.array;
        char c2 = 0;
        int i2 = 0;
        int j = 0;
        int skip = this.ratio - 1;
        while (i2 < this.f2388n) {
            int length = readInt(a, c2 == 1 ? 1 : 0);
            int count = count(length);
            skip++;
            if (skip == this.ratio) {
                skip = 0;
                j++;
                p[j] = c2 == 1 ? 1 : 0;
                c = c2;
                i = count;
            } else {
                c = c2 == 1 ? 1 : 0;
                i = count + count(readInt(a, c2 + ((long) count)));
            }
            i2++;
            c2 = c + ((long) (i + length));
        }
        return p;
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2389p = rebuildPointerArray();
    }
}
