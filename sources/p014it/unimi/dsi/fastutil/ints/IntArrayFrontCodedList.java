package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectList;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;

/* renamed from: it.unimi.dsi.fastutil.ints.IntArrayFrontCodedList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntArrayFrontCodedList.class */
public class IntArrayFrontCodedList extends AbstractObjectList<int[]> implements Serializable, Cloneable, RandomAccess {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    protected final int f2146n;
    protected final int ratio;
    protected final int[][] array;

    /* renamed from: p */
    protected transient long[] f2147p;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0142 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [long] */
    /* JADX WARN: Type inference failed for: r14v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r0v38, types: [long] */
    /* JADX WARN: Type inference failed for: r14v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v50, types: [long] */
    /* JADX WARN: Type inference failed for: r14v6, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IntArrayFrontCodedList(java.util.Iterator<int[]> r9, int r10) {
        /*
        // Method dump skipped, instructions count: 373
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntArrayFrontCodedList.<init>(java.util.Iterator, int):void");
    }

    public IntArrayFrontCodedList(Collection<int[]> c, int ratio) {
        this(c.iterator(), ratio);
    }

    /* access modifiers changed from: package-private */
    public static int readInt(int[][] a, long pos) {
        return BigArrays.get(a, pos);
    }

    /* access modifiers changed from: package-private */
    public static int count(int length) {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public static int writeInt(int[][] a, int length, long pos) {
        BigArrays.set(a, pos, length);
        return 1;
    }

    public int ratio() {
        return this.ratio;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* access modifiers changed from: private */
    public int length(int index) {
        int[][] array = this.array;
        int delta = index % this.ratio;
        long pos = this.f2147p[index / this.ratio];
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
    /* JADX WARN: Type inference failed for: r0v6, types: [int[][], long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int extract(int r10, int[] r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntArrayFrontCodedList.extract(int, int[], int, int):int");
    }

    @Override // java.util.List
    public int[] get(int index) {
        return getArray(index);
    }

    public int[] getArray(int index) {
        ensureRestrictedIndex(index);
        int length = length(index);
        int[] a = new int[length];
        extract(index, a, 0, length);
        return a;
    }

    public int get(int index, int[] a, int offset, int length) {
        ensureRestrictedIndex(index);
        IntArrays.ensureOffsetLength(a, offset, length);
        int arrayLength = extract(index, a, offset, length);
        return length >= arrayLength ? arrayLength : length - arrayLength;
    }

    public int get(int index, int[] a) {
        return get(index, a, 0, a.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2146n;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
    public ObjectListIterator<int[]> listIterator(final int start) {
        ensureIndex(start);
        return new ObjectListIterator<int[]>() { // from class: it.unimi.dsi.fastutil.ints.IntArrayFrontCodedList.1

            /* renamed from: s */
            int[] f2148s = IntArrays.EMPTY_ARRAY;

            /* renamed from: i */
            int f2149i;
            long pos;
            boolean inSync;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f2149i = 0;
                this.pos = 0;
                if (start == 0) {
                    return;
                }
                if (start == IntArrayFrontCodedList.this.f2146n) {
                    this.f2149i = start;
                    return;
                }
                this.pos = IntArrayFrontCodedList.this.f2147p[start / IntArrayFrontCodedList.this.ratio];
                int j = start % IntArrayFrontCodedList.this.ratio;
                this.f2149i = start - j;
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
                return this.f2149i < IntArrayFrontCodedList.this.f2146n;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.f2149i > 0;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f2149i - 1;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f2149i;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public int[] next() {
                int length;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.f2149i % IntArrayFrontCodedList.this.ratio == 0) {
                    this.pos = IntArrayFrontCodedList.this.f2147p[this.f2149i / IntArrayFrontCodedList.this.ratio];
                    length = IntArrayFrontCodedList.readInt(IntArrayFrontCodedList.this.array, this.pos);
                    this.f2148s = IntArrays.ensureCapacity(this.f2148s, length, 0);
                    BigArrays.copyFromBig(IntArrayFrontCodedList.this.array, this.pos + ((long) IntArrayFrontCodedList.count(length)), this.f2148s, 0, length);
                    this.pos += (long) (length + IntArrayFrontCodedList.count(length));
                    this.inSync = true;
                } else if (this.inSync) {
                    int length2 = IntArrayFrontCodedList.readInt(IntArrayFrontCodedList.this.array, this.pos);
                    int common = IntArrayFrontCodedList.readInt(IntArrayFrontCodedList.this.array, this.pos + ((long) IntArrayFrontCodedList.count(length2)));
                    this.f2148s = IntArrays.ensureCapacity(this.f2148s, length2 + common, common);
                    BigArrays.copyFromBig(IntArrayFrontCodedList.this.array, this.pos + ((long) IntArrayFrontCodedList.count(length2)) + ((long) IntArrayFrontCodedList.count(common)), this.f2148s, common, length2);
                    this.pos += (long) (IntArrayFrontCodedList.count(length2) + IntArrayFrontCodedList.count(common) + length2);
                    length = length2 + common;
                } else {
                    int[] iArr = this.f2148s;
                    int length3 = IntArrayFrontCodedList.this.length(this.f2149i);
                    length = length3;
                    this.f2148s = IntArrays.ensureCapacity(iArr, length3, 0);
                    IntArrayFrontCodedList.this.extract(this.f2149i, this.f2148s, 0, length);
                }
                this.f2149i++;
                return IntArrays.copy(this.f2148s, 0, length);
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public int[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                IntArrayFrontCodedList intArrayFrontCodedList = IntArrayFrontCodedList.this;
                int i = this.f2149i - 1;
                this.f2149i = i;
                return intArrayFrontCodedList.getArray(i);
            }
        };
    }

    @Override // java.lang.Object
    public IntArrayFrontCodedList clone() {
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (int i = 0; i < this.f2146n; i++) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(IntArrayList.wrap(getArray(i)).toString());
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
        long[] p = new long[((this.f2146n + this.ratio) - 1) / this.ratio];
        int[][] a = this.array;
        char c2 = 0;
        int i2 = 0;
        int j = 0;
        int skip = this.ratio - 1;
        while (i2 < this.f2146n) {
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
        this.f2147p = rebuildPointerArray();
    }
}
