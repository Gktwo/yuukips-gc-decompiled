package p014it.unimi.dsi.fastutil.chars;

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

/* renamed from: it.unimi.dsi.fastutil.chars.CharArrayFrontCodedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharArrayFrontCodedBigList.class */
public class CharArrayFrontCodedBigList extends AbstractObjectBigList<char[]> implements Serializable, Cloneable, RandomAccess {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    protected final long f1437n;
    protected final int ratio;
    protected final char[][] array;

    /* renamed from: p */
    protected transient long[][] f1438p;

    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARN: Type inference failed for: r0v53, types: [long] */
    public CharArrayFrontCodedBigList(Iterator<char[]> arrays, int ratio) {
        char c;
        if (ratio < 1) {
            throw new IllegalArgumentException("Illegal ratio (" + ratio + ")");
        }
        char[][] array = CharBigArrays.EMPTY_BIG_ARRAY;
        long[][] p = LongBigArrays.EMPTY_BIG_ARRAY;
        char[][] a = new char[2];
        char c2 = 0;
        char c3 = 0;
        int b = 0;
        while (arrays.hasNext()) {
            a[b] = arrays.next();
            int length = a[b].length;
            if (c3 % ((long) ratio) == 0) {
                p = BigArrays.grow(p, (c3 / ((long) ratio)) + serialVersionUID);
                BigArrays.set(p, c3 / ((long) ratio), (long) c2);
                array = BigArrays.grow(array, c2 + ((long) CharArrayFrontCodedList.count(length)) + ((long) length), (long) c2);
                c = c2 + ((long) CharArrayFrontCodedList.writeInt(array, length, c2));
                BigArrays.copyToBig(a[b], 0, array, (long) c, (long) length);
            } else {
                int minLength = Math.min(a[1 - b].length, length);
                int common = 0;
                while (common < minLength && a[0][common] == a[1][common]) {
                    common++;
                }
                length -= common;
                array = BigArrays.grow(array, c2 + ((long) CharArrayFrontCodedList.count(length)) + ((long) CharArrayFrontCodedList.count(common)) + ((long) length), (long) c2);
                long curSize = c2 + ((long) CharArrayFrontCodedList.writeInt(array, length, c2));
                c = curSize + ((long) CharArrayFrontCodedList.writeInt(array, common, curSize));
                BigArrays.copyToBig(a[b], common, array, (long) c, (long) length);
            }
            c2 = c + ((long) length);
            b = 1 - b;
            c3 += serialVersionUID;
        }
        this.f1437n = c3;
        this.ratio = ratio;
        this.array = BigArrays.trim(array, (long) c2);
        this.f1438p = BigArrays.trim(p, ((c3 + ((long) ratio)) - serialVersionUID) / ((long) ratio));
    }

    public CharArrayFrontCodedBigList(Collection<char[]> c, int ratio) {
        this(c.iterator(), ratio);
    }

    public int ratio() {
        return this.ratio;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* access modifiers changed from: private */
    public int length(long index) {
        char[][] array = this.array;
        int delta = (int) (index % ((long) this.ratio));
        long pos = BigArrays.get(this.f1438p, index / ((long) this.ratio));
        int length = CharArrayFrontCodedList.readInt(array, pos);
        if (delta == 0) {
            return length;
        }
        char count = pos + ((long) (CharArrayFrontCodedList.count(length) + length));
        int length2 = CharArrayFrontCodedList.readInt(array, count);
        int common = CharArrayFrontCodedList.readInt(array, count + ((long) CharArrayFrontCodedList.count(length2)));
        for (int i = 0; i < delta - 1; i++) {
            count += (long) (CharArrayFrontCodedList.count(length2) + CharArrayFrontCodedList.count(common) + length2);
            length2 = CharArrayFrontCodedList.readInt(array, count);
            common = CharArrayFrontCodedList.readInt(array, count + ((long) CharArrayFrontCodedList.count(length2)));
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
    public int extract(long r10, char[] r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.CharArrayFrontCodedBigList.extract(long, char[], int, int):int");
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public char[] get(long index) {
        return getArray(index);
    }

    public char[] getArray(long index) {
        ensureRestrictedIndex(index);
        int length = length(index);
        char[] a = new char[length];
        extract(index, a, 0, length);
        return a;
    }

    public int get(long index, char[] a, int offset, int length) {
        ensureRestrictedIndex(index);
        CharArrays.ensureOffsetLength(a, offset, length);
        int arrayLength = extract(index, a, offset, length);
        return length >= arrayLength ? arrayLength : length - arrayLength;
    }

    public int get(long index, char[] a) {
        return get(index, a, 0, a.length);
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.f1437n;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public ObjectBigListIterator<char[]> listIterator(final long start) {
        ensureIndex(start);
        return new ObjectBigListIterator<char[]>() { // from class: it.unimi.dsi.fastutil.chars.CharArrayFrontCodedBigList.1

            /* renamed from: s */
            char[] f1439s = CharArrays.EMPTY_ARRAY;

            /* renamed from: i */
            long f1440i;
            long pos;
            boolean inSync;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f1440i = 0;
                this.pos = 0;
                if (start == 0) {
                    return;
                }
                if (start == CharArrayFrontCodedBigList.this.f1437n) {
                    this.f1440i = start;
                    return;
                }
                this.pos = BigArrays.get(CharArrayFrontCodedBigList.this.f1438p, start / ((long) CharArrayFrontCodedBigList.this.ratio));
                int j = (int) (start % ((long) CharArrayFrontCodedBigList.this.ratio));
                this.f1440i = start - ((long) j);
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
                return this.f1440i < CharArrayFrontCodedBigList.this.f1437n;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.f1440i > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.f1440i - CharArrayFrontCodedBigList.serialVersionUID;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.f1440i;
            }

            @Override // java.util.Iterator
            public char[] next() {
                int length;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.f1440i % ((long) CharArrayFrontCodedBigList.this.ratio) == 0) {
                    this.pos = BigArrays.get(CharArrayFrontCodedBigList.this.f1438p, this.f1440i / ((long) CharArrayFrontCodedBigList.this.ratio));
                    length = CharArrayFrontCodedList.readInt(CharArrayFrontCodedBigList.this.array, this.pos);
                    this.f1439s = CharArrays.ensureCapacity(this.f1439s, length, 0);
                    BigArrays.copyFromBig(CharArrayFrontCodedBigList.this.array, this.pos + ((long) CharArrayFrontCodedList.count(length)), this.f1439s, 0, length);
                    this.pos += (long) (length + CharArrayFrontCodedList.count(length));
                    this.inSync = true;
                } else if (this.inSync) {
                    int length2 = CharArrayFrontCodedList.readInt(CharArrayFrontCodedBigList.this.array, this.pos);
                    int common = CharArrayFrontCodedList.readInt(CharArrayFrontCodedBigList.this.array, this.pos + ((long) CharArrayFrontCodedList.count(length2)));
                    this.f1439s = CharArrays.ensureCapacity(this.f1439s, length2 + common, common);
                    BigArrays.copyFromBig(CharArrayFrontCodedBigList.this.array, this.pos + ((long) CharArrayFrontCodedList.count(length2)) + ((long) CharArrayFrontCodedList.count(common)), this.f1439s, common, length2);
                    this.pos += (long) (CharArrayFrontCodedList.count(length2) + CharArrayFrontCodedList.count(common) + length2);
                    length = length2 + common;
                } else {
                    char[] cArr = this.f1439s;
                    int length3 = CharArrayFrontCodedBigList.this.length(this.f1440i);
                    length = length3;
                    this.f1439s = CharArrays.ensureCapacity(cArr, length3, 0);
                    CharArrayFrontCodedBigList.this.extract(this.f1440i, this.f1439s, 0, length);
                }
                this.f1440i += CharArrayFrontCodedBigList.serialVersionUID;
                return CharArrays.copy(this.f1439s, 0, length);
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public char[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                CharArrayFrontCodedBigList charArrayFrontCodedBigList = CharArrayFrontCodedBigList.this;
                long j = this.f1440i - CharArrayFrontCodedBigList.serialVersionUID;
                this.f1440i = j;
                return charArrayFrontCodedBigList.getArray(j);
            }
        };
    }

    @Override // java.lang.Object
    public CharArrayFrontCodedBigList clone() {
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (long i = 0; i < this.f1437n; i += serialVersionUID) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(CharArrayList.wrap(getArray(i)).toString());
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
        long[][] p = LongBigArrays.newBigArray(((this.f1437n + ((long) this.ratio)) - serialVersionUID) / ((long) this.ratio));
        char[][] a = this.array;
        char c2 = 0;
        int skip = this.ratio - 1;
        char c3 = 0;
        long j = 0;
        while (c3 < this.f1437n) {
            int length = CharArrayFrontCodedList.readInt(a, c2 == 1 ? 1 : 0);
            int count = CharArrayFrontCodedList.count(length);
            skip++;
            if (skip == this.ratio) {
                skip = 0;
                j += serialVersionUID;
                BigArrays.set(p, j, (long) c2);
                c = c2;
                i = count;
            } else {
                c = c2 == 1 ? 1 : 0;
                i = count + CharArrayFrontCodedList.count(CharArrayFrontCodedList.readInt(a, c2 + ((long) count)));
            }
            c3 += serialVersionUID;
            c2 = c + ((long) (i + length));
        }
        return p;
    }

    public void dump(DataOutputStream array, DataOutputStream pointers) throws IOException {
        char[][] cArr = this.array;
        for (char[] s : cArr) {
            for (char e : s) {
                array.writeChar(e);
            }
        }
        long[][] jArr = this.f1438p;
        for (long[] s2 : jArr) {
            for (long e2 : s2) {
                pointers.writeLong(e2);
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1438p = rebuildPointerArray();
    }
}
