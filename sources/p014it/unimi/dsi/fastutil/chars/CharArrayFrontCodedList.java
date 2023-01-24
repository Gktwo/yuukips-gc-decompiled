package p014it.unimi.dsi.fastutil.chars;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectList;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;

/* renamed from: it.unimi.dsi.fastutil.chars.CharArrayFrontCodedList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharArrayFrontCodedList.class */
public class CharArrayFrontCodedList extends AbstractObjectList<char[]> implements Serializable, Cloneable, RandomAccess {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    protected final int f1477n;
    protected final int ratio;
    protected final char[][] array;

    /* renamed from: p */
    protected transient long[] f1478p;

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
    public CharArrayFrontCodedList(java.util.Iterator<char[]> r9, int r10) {
        /*
        // Method dump skipped, instructions count: 373
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.CharArrayFrontCodedList.<init>(java.util.Iterator, int):void");
    }

    public CharArrayFrontCodedList(Collection<char[]> c, int ratio) {
        this(c.iterator(), ratio);
    }

    /* access modifiers changed from: package-private */
    public static int readInt(char[][] a, long pos) {
        char c0 = BigArrays.get(a, pos);
        return c0 < 32768 ? c0 : ((c0 & 32767) << 16) | BigArrays.get(a, pos + serialVersionUID);
    }

    /* access modifiers changed from: package-private */
    public static int count(int length) {
        return length < 32768 ? 1 : 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public static int writeInt(char[][] a, int length, long pos) {
        if (length < 32768) {
            BigArrays.set(a, pos, (char) length);
            return 1;
        }
        long pos2 = pos + serialVersionUID;
        BigArrays.set((char[][]) pos, pos, (char) ((length >>> 16) | 32768));
        BigArrays.set(a, pos2, (char) (length & 65535));
        return 2;
    }

    public int ratio() {
        return this.ratio;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* access modifiers changed from: private */
    public int length(int index) {
        char[][] array = this.array;
        int delta = index % this.ratio;
        long pos = this.f1478p[index / this.ratio];
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
    /* JADX WARN: Type inference failed for: r0v6, types: [long, char[][]] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int extract(int r10, char[] r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.CharArrayFrontCodedList.extract(int, char[], int, int):int");
    }

    @Override // java.util.List
    public char[] get(int index) {
        return getArray(index);
    }

    public char[] getArray(int index) {
        ensureRestrictedIndex(index);
        int length = length(index);
        char[] a = new char[length];
        extract(index, a, 0, length);
        return a;
    }

    public int get(int index, char[] a, int offset, int length) {
        ensureRestrictedIndex(index);
        CharArrays.ensureOffsetLength(a, offset, length);
        int arrayLength = extract(index, a, offset, length);
        return length >= arrayLength ? arrayLength : length - arrayLength;
    }

    public int get(int index, char[] a) {
        return get(index, a, 0, a.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1477n;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
    public ObjectListIterator<char[]> listIterator(final int start) {
        ensureIndex(start);
        return new ObjectListIterator<char[]>() { // from class: it.unimi.dsi.fastutil.chars.CharArrayFrontCodedList.1

            /* renamed from: s */
            char[] f1479s = CharArrays.EMPTY_ARRAY;

            /* renamed from: i */
            int f1480i;
            long pos;
            boolean inSync;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f1480i = 0;
                this.pos = 0;
                if (start == 0) {
                    return;
                }
                if (start == CharArrayFrontCodedList.this.f1477n) {
                    this.f1480i = start;
                    return;
                }
                this.pos = CharArrayFrontCodedList.this.f1478p[start / CharArrayFrontCodedList.this.ratio];
                int j = start % CharArrayFrontCodedList.this.ratio;
                this.f1480i = start - j;
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
                return this.f1480i < CharArrayFrontCodedList.this.f1477n;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.f1480i > 0;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f1480i - 1;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f1480i;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public char[] next() {
                int length;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.f1480i % CharArrayFrontCodedList.this.ratio == 0) {
                    this.pos = CharArrayFrontCodedList.this.f1478p[this.f1480i / CharArrayFrontCodedList.this.ratio];
                    length = CharArrayFrontCodedList.readInt(CharArrayFrontCodedList.this.array, this.pos);
                    this.f1479s = CharArrays.ensureCapacity(this.f1479s, length, 0);
                    BigArrays.copyFromBig(CharArrayFrontCodedList.this.array, this.pos + ((long) CharArrayFrontCodedList.count(length)), this.f1479s, 0, length);
                    this.pos += (long) (length + CharArrayFrontCodedList.count(length));
                    this.inSync = true;
                } else if (this.inSync) {
                    int length2 = CharArrayFrontCodedList.readInt(CharArrayFrontCodedList.this.array, this.pos);
                    int common = CharArrayFrontCodedList.readInt(CharArrayFrontCodedList.this.array, this.pos + ((long) CharArrayFrontCodedList.count(length2)));
                    this.f1479s = CharArrays.ensureCapacity(this.f1479s, length2 + common, common);
                    BigArrays.copyFromBig(CharArrayFrontCodedList.this.array, this.pos + ((long) CharArrayFrontCodedList.count(length2)) + ((long) CharArrayFrontCodedList.count(common)), this.f1479s, common, length2);
                    this.pos += (long) (CharArrayFrontCodedList.count(length2) + CharArrayFrontCodedList.count(common) + length2);
                    length = length2 + common;
                } else {
                    char[] cArr = this.f1479s;
                    int length3 = CharArrayFrontCodedList.this.length(this.f1480i);
                    length = length3;
                    this.f1479s = CharArrays.ensureCapacity(cArr, length3, 0);
                    CharArrayFrontCodedList.this.extract(this.f1480i, this.f1479s, 0, length);
                }
                this.f1480i++;
                return CharArrays.copy(this.f1479s, 0, length);
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public char[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                CharArrayFrontCodedList charArrayFrontCodedList = CharArrayFrontCodedList.this;
                int i = this.f1480i - 1;
                this.f1480i = i;
                return charArrayFrontCodedList.getArray(i);
            }
        };
    }

    @Override // java.lang.Object
    public CharArrayFrontCodedList clone() {
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (int i = 0; i < this.f1477n; i++) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(CharArrayList.wrap(getArray(i)).toString());
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
        long[] p = new long[((this.f1477n + this.ratio) - 1) / this.ratio];
        char[][] a = this.array;
        char c2 = 0;
        int i2 = 0;
        int j = 0;
        int skip = this.ratio - 1;
        while (i2 < this.f1477n) {
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
        this.f1478p = rebuildPointerArray();
    }
}
