package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectList;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrayFrontCodedList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrayFrontCodedList.class */
public class ShortArrayFrontCodedList extends AbstractObjectList<short[]> implements Serializable, Cloneable, RandomAccess {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    protected final int f3018n;
    protected final int ratio;
    protected final short[][] array;

    /* renamed from: p */
    protected transient long[] f3019p;

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
    public ShortArrayFrontCodedList(java.util.Iterator<short[]> r9, int r10) {
        /*
        // Method dump skipped, instructions count: 373
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortArrayFrontCodedList.<init>(java.util.Iterator, int):void");
    }

    public ShortArrayFrontCodedList(Collection<short[]> c, int ratio) {
        this(c.iterator(), ratio);
    }

    /* access modifiers changed from: package-private */
    public static int readInt(short[][] a, long pos) {
        short s0 = BigArrays.get(a, pos);
        return s0 >= 0 ? s0 : (s0 << 16) | (BigArrays.get(a, pos + serialVersionUID) & 65535);
    }

    /* access modifiers changed from: package-private */
    public static int count(int length) {
        return length < 32768 ? 1 : 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public static int writeInt(short[][] a, int length, long pos) {
        if (length < 32768) {
            BigArrays.set(a, pos, (short) length);
            return 1;
        }
        long pos2 = pos + serialVersionUID;
        BigArrays.set((short[][]) pos, pos, (short) ((-(length >>> 16)) - 1));
        BigArrays.set(a, pos2, (short) (length & 65535));
        return 2;
    }

    public int ratio() {
        return this.ratio;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* access modifiers changed from: private */
    public int length(int index) {
        short[][] array = this.array;
        int delta = index % this.ratio;
        long pos = this.f3019p[index / this.ratio];
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
    /* JADX WARN: Type inference failed for: r0v6, types: [long, short[][]] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int extract(int r10, short[] r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortArrayFrontCodedList.extract(int, short[], int, int):int");
    }

    @Override // java.util.List
    public short[] get(int index) {
        return getArray(index);
    }

    public short[] getArray(int index) {
        ensureRestrictedIndex(index);
        int length = length(index);
        short[] a = new short[length];
        extract(index, a, 0, length);
        return a;
    }

    public int get(int index, short[] a, int offset, int length) {
        ensureRestrictedIndex(index);
        ShortArrays.ensureOffsetLength(a, offset, length);
        int arrayLength = extract(index, a, offset, length);
        return length >= arrayLength ? arrayLength : length - arrayLength;
    }

    public int get(int index, short[] a) {
        return get(index, a, 0, a.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3018n;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
    public ObjectListIterator<short[]> listIterator(final int start) {
        ensureIndex(start);
        return new ObjectListIterator<short[]>() { // from class: it.unimi.dsi.fastutil.shorts.ShortArrayFrontCodedList.1

            /* renamed from: s */
            short[] f3020s = ShortArrays.EMPTY_ARRAY;

            /* renamed from: i */
            int f3021i;
            long pos;
            boolean inSync;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f3021i = 0;
                this.pos = 0;
                if (start == 0) {
                    return;
                }
                if (start == ShortArrayFrontCodedList.this.f3018n) {
                    this.f3021i = start;
                    return;
                }
                this.pos = ShortArrayFrontCodedList.this.f3019p[start / ShortArrayFrontCodedList.this.ratio];
                int j = start % ShortArrayFrontCodedList.this.ratio;
                this.f3021i = start - j;
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
                return this.f3021i < ShortArrayFrontCodedList.this.f3018n;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.f3021i > 0;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f3021i - 1;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f3021i;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public short[] next() {
                int length;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.f3021i % ShortArrayFrontCodedList.this.ratio == 0) {
                    this.pos = ShortArrayFrontCodedList.this.f3019p[this.f3021i / ShortArrayFrontCodedList.this.ratio];
                    length = ShortArrayFrontCodedList.readInt(ShortArrayFrontCodedList.this.array, this.pos);
                    this.f3020s = ShortArrays.ensureCapacity(this.f3020s, length, 0);
                    BigArrays.copyFromBig(ShortArrayFrontCodedList.this.array, this.pos + ((long) ShortArrayFrontCodedList.count(length)), this.f3020s, 0, length);
                    this.pos += (long) (length + ShortArrayFrontCodedList.count(length));
                    this.inSync = true;
                } else if (this.inSync) {
                    int length2 = ShortArrayFrontCodedList.readInt(ShortArrayFrontCodedList.this.array, this.pos);
                    int common = ShortArrayFrontCodedList.readInt(ShortArrayFrontCodedList.this.array, this.pos + ((long) ShortArrayFrontCodedList.count(length2)));
                    this.f3020s = ShortArrays.ensureCapacity(this.f3020s, length2 + common, common);
                    BigArrays.copyFromBig(ShortArrayFrontCodedList.this.array, this.pos + ((long) ShortArrayFrontCodedList.count(length2)) + ((long) ShortArrayFrontCodedList.count(common)), this.f3020s, common, length2);
                    this.pos += (long) (ShortArrayFrontCodedList.count(length2) + ShortArrayFrontCodedList.count(common) + length2);
                    length = length2 + common;
                } else {
                    short[] sArr = this.f3020s;
                    int length3 = ShortArrayFrontCodedList.this.length(this.f3021i);
                    length = length3;
                    this.f3020s = ShortArrays.ensureCapacity(sArr, length3, 0);
                    ShortArrayFrontCodedList.this.extract(this.f3021i, this.f3020s, 0, length);
                }
                this.f3021i++;
                return ShortArrays.copy(this.f3020s, 0, length);
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public short[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                ShortArrayFrontCodedList shortArrayFrontCodedList = ShortArrayFrontCodedList.this;
                int i = this.f3021i - 1;
                this.f3021i = i;
                return shortArrayFrontCodedList.getArray(i);
            }
        };
    }

    @Override // java.lang.Object
    public ShortArrayFrontCodedList clone() {
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (int i = 0; i < this.f3018n; i++) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(ShortArrayList.wrap(getArray(i)).toString());
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
        long[] p = new long[((this.f3018n + this.ratio) - 1) / this.ratio];
        short[][] a = this.array;
        char c2 = 0;
        int i2 = 0;
        int j = 0;
        int skip = this.ratio - 1;
        while (i2 < this.f3018n) {
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
        this.f3019p = rebuildPointerArray();
    }
}
