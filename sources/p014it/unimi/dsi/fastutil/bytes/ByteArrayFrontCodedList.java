package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectList;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteArrayFrontCodedList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteArrayFrontCodedList.class */
public class ByteArrayFrontCodedList extends AbstractObjectList<byte[]> implements Serializable, Cloneable, RandomAccess {
    private static final long serialVersionUID = 1;

    /* renamed from: n */
    protected final int f1214n;
    protected final int ratio;
    protected final byte[][] array;

    /* renamed from: p */
    protected transient long[] f1215p;

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
    public ByteArrayFrontCodedList(java.util.Iterator<byte[]> r9, int r10) {
        /*
        // Method dump skipped, instructions count: 373
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteArrayFrontCodedList.<init>(java.util.Iterator, int):void");
    }

    public ByteArrayFrontCodedList(Collection<byte[]> c, int ratio) {
        this(c.iterator(), ratio);
    }

    /* access modifiers changed from: package-private */
    public static int readInt(byte[][] a, long pos) {
        byte b0 = BigArrays.get(a, pos);
        if (b0 >= 0) {
            return b0;
        }
        byte b1 = BigArrays.get(a, pos + serialVersionUID);
        if (b1 >= 0) {
            return (((-b0) - 1) << 7) | b1;
        }
        byte b2 = BigArrays.get(a, pos + 2);
        if (b2 >= 0) {
            return (((-b0) - 1) << 14) | (((-b1) - 1) << 7) | b2;
        }
        byte b3 = BigArrays.get(a, pos + 3);
        return b3 >= 0 ? (((-b0) - 1) << 21) | (((-b1) - 1) << 14) | (((-b2) - 1) << 7) | b3 : (((-b0) - 1) << 28) | (((-b1) - 1) << 21) | (((-b2) - 1) << 14) | (((-b3) - 1) << 7) | BigArrays.get(a, pos + 4);
    }

    /* access modifiers changed from: package-private */
    public static int count(int length) {
        if (length < 128) {
            return 1;
        }
        if (length < 16384) {
            return 2;
        }
        if (length < 2097152) {
            return 3;
        }
        return length < 268435456 ? 4 : 5;
    }

    /* access modifiers changed from: package-private */
    public static int writeInt(byte[][] a, int length, long pos) {
        int count = count(length);
        BigArrays.set(a, (pos + ((long) count)) - serialVersionUID, (byte) (length & 127));
        int i = count - 1;
        while (true) {
            i--;
            if (i == 0) {
                return count;
            }
            length >>>= 7;
            BigArrays.set(a, pos + ((long) i), (byte) ((-(length & 127)) - 1));
        }
    }

    public int ratio() {
        return this.ratio;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* access modifiers changed from: private */
    public int length(int index) {
        byte[][] array = this.array;
        int delta = index % this.ratio;
        long pos = this.f1215p[index / this.ratio];
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
    /* JADX WARN: Type inference failed for: r0v6, types: [long, byte[][]] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int extract(int r10, byte[] r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteArrayFrontCodedList.extract(int, byte[], int, int):int");
    }

    @Override // java.util.List
    public byte[] get(int index) {
        return getArray(index);
    }

    public byte[] getArray(int index) {
        ensureRestrictedIndex(index);
        int length = length(index);
        byte[] a = new byte[length];
        extract(index, a, 0, length);
        return a;
    }

    public int get(int index, byte[] a, int offset, int length) {
        ensureRestrictedIndex(index);
        ByteArrays.ensureOffsetLength(a, offset, length);
        int arrayLength = extract(index, a, offset, length);
        return length >= arrayLength ? arrayLength : length - arrayLength;
    }

    public int get(int index, byte[] a) {
        return get(index, a, 0, a.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1214n;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
    public ObjectListIterator<byte[]> listIterator(final int start) {
        ensureIndex(start);
        return new ObjectListIterator<byte[]>() { // from class: it.unimi.dsi.fastutil.bytes.ByteArrayFrontCodedList.1

            /* renamed from: s */
            byte[] f1216s = ByteArrays.EMPTY_ARRAY;

            /* renamed from: i */
            int f1217i;
            long pos;
            boolean inSync;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f1217i = 0;
                this.pos = 0;
                if (start == 0) {
                    return;
                }
                if (start == ByteArrayFrontCodedList.this.f1214n) {
                    this.f1217i = start;
                    return;
                }
                this.pos = ByteArrayFrontCodedList.this.f1215p[start / ByteArrayFrontCodedList.this.ratio];
                int j = start % ByteArrayFrontCodedList.this.ratio;
                this.f1217i = start - j;
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
                return this.f1217i < ByteArrayFrontCodedList.this.f1214n;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.f1217i > 0;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f1217i - 1;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f1217i;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public byte[] next() {
                int length;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.f1217i % ByteArrayFrontCodedList.this.ratio == 0) {
                    this.pos = ByteArrayFrontCodedList.this.f1215p[this.f1217i / ByteArrayFrontCodedList.this.ratio];
                    length = ByteArrayFrontCodedList.readInt(ByteArrayFrontCodedList.this.array, this.pos);
                    this.f1216s = ByteArrays.ensureCapacity(this.f1216s, length, 0);
                    BigArrays.copyFromBig(ByteArrayFrontCodedList.this.array, this.pos + ((long) ByteArrayFrontCodedList.count(length)), this.f1216s, 0, length);
                    this.pos += (long) (length + ByteArrayFrontCodedList.count(length));
                    this.inSync = true;
                } else if (this.inSync) {
                    int length2 = ByteArrayFrontCodedList.readInt(ByteArrayFrontCodedList.this.array, this.pos);
                    int common = ByteArrayFrontCodedList.readInt(ByteArrayFrontCodedList.this.array, this.pos + ((long) ByteArrayFrontCodedList.count(length2)));
                    this.f1216s = ByteArrays.ensureCapacity(this.f1216s, length2 + common, common);
                    BigArrays.copyFromBig(ByteArrayFrontCodedList.this.array, this.pos + ((long) ByteArrayFrontCodedList.count(length2)) + ((long) ByteArrayFrontCodedList.count(common)), this.f1216s, common, length2);
                    this.pos += (long) (ByteArrayFrontCodedList.count(length2) + ByteArrayFrontCodedList.count(common) + length2);
                    length = length2 + common;
                } else {
                    byte[] bArr = this.f1216s;
                    int length3 = ByteArrayFrontCodedList.this.length(this.f1217i);
                    length = length3;
                    this.f1216s = ByteArrays.ensureCapacity(bArr, length3, 0);
                    ByteArrayFrontCodedList.this.extract(this.f1217i, this.f1216s, 0, length);
                }
                this.f1217i++;
                return ByteArrays.copy(this.f1216s, 0, length);
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public byte[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                ByteArrayFrontCodedList byteArrayFrontCodedList = ByteArrayFrontCodedList.this;
                int i = this.f1217i - 1;
                this.f1217i = i;
                return byteArrayFrontCodedList.getArray(i);
            }
        };
    }

    @Override // java.lang.Object
    public ByteArrayFrontCodedList clone() {
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (int i = 0; i < this.f1214n; i++) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(ByteArrayList.wrap(getArray(i)).toString());
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
        long[] p = new long[((this.f1214n + this.ratio) - 1) / this.ratio];
        byte[][] a = this.array;
        char c2 = 0;
        int i2 = 0;
        int j = 0;
        int skip = this.ratio - 1;
        while (i2 < this.f1214n) {
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
        this.f1215p = rebuildPointerArray();
    }
}
