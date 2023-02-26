package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.ints.IntBigListIterators;
import p014it.unimi.dsi.fastutil.ints.IntBigSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractIntBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractIntBigList.class */
public abstract class AbstractIntBigList extends AbstractIntCollection implements IntBigList, IntStack {
    protected void ensureIndex(long index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is negative");
        } else if (index > size64()) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than list size (" + size64() + ")");
        }
    }

    protected void ensureRestrictedIndex(long index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is negative");
        } else if (index >= size64()) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + size64() + ")");
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    public void add(long index, int k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean add(int k) {
        add(size64(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    public int removeInt(long i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    public int set(long index, int k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public boolean addAll(long index, Collection<? extends Integer> c) {
        ensureIndex(index);
        Iterator<? extends Integer> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, (Integer) i.next());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Integer> c) {
        return addAll(size64(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    public IntBigListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Integer> listIterator() {
        return listIterator(0L);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Integer> listIterator(long index) {
        ensureIndex(index);
        return new IntBigListIterators.AbstractIndexBasedBigListIterator(0, index) { // from class: it.unimi.dsi.fastutil.ints.AbstractIntBigList.1
            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigIterator
            protected final int get(long i) {
                return AbstractIntBigList.this.getInt(i);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, int k) {
                AbstractIntBigList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, int k) {
                AbstractIntBigList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                AbstractIntBigList.this.removeInt(i);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return AbstractIntBigList.this.size64();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractIntBigList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractIntBigList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends IntBigSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final IntBigList f1979l;

        IndexBasedSpliterator(IntBigList l, long pos) {
            super(pos);
            this.f1979l = l;
        }

        IndexBasedSpliterator(IntBigList l, long pos, long maxPos) {
            super(pos, maxPos);
            this.f1979l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final long getMaxPosFromBackingStore() {
            return this.f1979l.size64();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigSpliterators.AbstractIndexBasedSpliterator
        protected final int get(long i) {
            return this.f1979l.getInt(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.ints.IntBigSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(long pos, long maxPos) {
            return new IndexBasedSpliterator(this.f1979l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean contains(int k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long indexOf(int r4) {
        /*
            r3 = this;
            r0 = r3
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator()
            r5 = r0
        L_0x0005:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0021
            r0 = r5
            int r0 = r0.nextInt()
            r6 = r0
            r0 = r4
            r1 = r6
            if (r0 != r1) goto L_0x0005
            r0 = r5
            long r0 = r0.previousIndex()
            return r0
        L_0x0021:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.AbstractIntBigList.indexOf(int):long");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long lastIndexOf(int r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r4
            long r1 = r1.size64()
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator(r1)
            r6 = r0
        L_0x0009:
            r0 = r6
            boolean r0 = r0.hasPrevious()
            if (r0 == 0) goto L_0x0025
            r0 = r6
            int r0 = r0.previousInt()
            r7 = r0
            r0 = r5
            r1 = r7
            if (r0 != r1) goto L_0x0009
            r0 = r6
            long r0 = r0.nextIndex()
            return r0
        L_0x0025:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.AbstractIntBigList.lastIndexOf(int):long");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r1v3, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.BigList
    public void size(long size) {
        char size64 = size64();
        int i = (size > size64 ? 1 : (size == size64 ? 0 : -1));
        long i2 = size64;
        long i3 = size64;
        if (i > 0) {
            while (true) {
                long i4 = i2 + 1;
                if ((i2 == 1 ? 1 : 0) < size) {
                    add(0);
                    i2 = i4;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                char c = i3 - 1;
                if ((i3 == 1 ? 1 : 0) != size) {
                    remove((long) c);
                    i3 = c;
                } else {
                    return;
                }
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
    public BigList<Integer> subList(long from, long to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new IntRandomAccessSubList(this, from, to) : new IntSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
    public void forEach(IntConsumer action) {
        if (this instanceof RandomAccess) {
            long max = size64();
            for (char c = 0; c < max; c++) {
                action.accept(getInt(c));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(long r8, long r10) {
        /*
            r7 = this;
            r0 = r7
            r1 = r10
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator(r1)
            r12 = r0
            r0 = r10
            r1 = r8
            long r0 = r0 - r1
            r13 = r0
            r0 = r13
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0041
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Start index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r8
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than end index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r10
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0041:
            r0 = r13
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r13 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x005f
            r0 = r12
            int r0 = r0.nextInt()
            r0 = r12
            r0.remove()
            goto L_0x0041
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.AbstractIntBigList.removeElements(long, long):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: int[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARN: Type inference failed for: r1v4, types: [long] */
    /* JADX WARN: Type inference failed for: r2v3, types: [long, int[][]] */
    /* JADX WARN: Type inference failed for: r1v10, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(long r12, int[][] r14, long r15, long r17) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r0.ensureIndex(r1)
            r0 = r14
            r1 = r15
            r2 = r17
            p014it.unimi.dsi.fastutil.BigArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r11
            boolean r0 = r0 instanceof java.util.RandomAccess
            if (r0 == 0) goto L_0x0037
        L_0x0014:
            r0 = r17
            r1 = r0; r0 = r2; 
            r2 = 1
            long r1 = r1 - r2
            r17 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x005f
            r0 = r11
            r1 = r12
            r2 = r1; r1 = r2; 
            r3 = 1
            long r2 = r2 + r3
            r12 = r2
            r2 = r14
            r3 = r15
            r4 = r3; r3 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r15 = r4
            int r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            r0.add(r1, r2)
            goto L_0x0014
        L_0x0037:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
        L_0x003e:
            r0 = r17
            r1 = r0; r0 = r2; 
            r2 = 1
            long r1 = r1 - r2
            r17 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x005f
            r0 = r19
            r1 = r14
            r2 = r15
            r3 = r2; r1 = r2; 
            r4 = 1
            long r3 = r3 + r4
            r15 = r3
            int r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.add(r1)
            goto L_0x003e
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.AbstractIntBigList.addElements(long, int[][], long, long):void");
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    public void addElements(long index, int[][] a) {
        addElements(index, a, 0, BigArrays.length(a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [long, it.unimi.dsi.fastutil.ints.AbstractIntBigList] */
    /* JADX WARN: Type inference failed for: r12v0, types: [long] */
    /* JADX WARN: Type inference failed for: r17v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v8, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARN: Type inference failed for: r1v7, types: [long] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(long r12, int[][] r14, long r15, long r17) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r0.ensureIndex(r1)
            r0 = r14
            r1 = r15
            r2 = r17
            p014it.unimi.dsi.fastutil.BigArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r12
            r1 = r17
            long r0 = r0 + r1
            r1 = r11
            long r1 = r1.size64()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0048
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "End index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r12
            r4 = r17
            long r3 = r3 + r4
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than list size ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r11
            long r3 = r3.size64()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0048:
            r0 = r11
            boolean r0 = r0 instanceof java.util.RandomAccess
            if (r0 == 0) goto L_0x007a
            r0 = r12
            r19 = r0
        L_0x0052:
            r0 = r17
            r1 = r0; r0 = r2; 
            r2 = 1
            long r1 = r1 - r2
            r17 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0077
            r0 = r14
            r1 = r15
            r2 = r1; r1 = r2; 
            r3 = 1
            long r2 = r2 + r3
            r15 = r2
            r2 = r11
            r3 = r19
            r4 = r3; r3 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r19 = r4
            int r2 = r2.getInt(r3)
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0052
        L_0x0077:
            goto L_0x00a2
        L_0x007a:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
        L_0x0081:
            r0 = r17
            r1 = r0; r0 = r2; 
            r2 = 1
            long r1 = r1 - r2
            r17 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00a2
            r0 = r14
            r1 = r15
            r2 = r1; r1 = r2; 
            r3 = 1
            long r2 = r2 + r3
            r15 = r2
            r2 = r19
            int r2 = r2.nextInt()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0081
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.AbstractIntBigList.getElements(long, int[][], long, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [long, int[][]] */
    /* JADX WARN: Type inference failed for: r0v8, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(long r12, int[][] r14, long r15, long r17) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r0.ensureIndex(r1)
            r0 = r14
            r1 = r15
            r2 = r17
            p014it.unimi.dsi.fastutil.BigArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r12
            r1 = r17
            long r0 = r0 + r1
            r1 = r11
            long r1 = r1.size64()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0048
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "End index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r12
            r4 = r17
            long r3 = r3 + r4
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than list size ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r11
            long r3 = r3.size64()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0048:
            r0 = r11
            boolean r0 = r0 instanceof java.util.RandomAccess
            if (r0 == 0) goto L_0x0078
            r0 = 0
            r19 = r0
        L_0x0052:
            r0 = r19
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0075
            r0 = r11
            r1 = r19
            r2 = r12
            long r1 = r1 + r2
            r2 = r14
            r3 = r19
            r4 = r15
            long r3 = r3 + r4
            int r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            int r0 = r0.set(r1, r2)
            r0 = r19
            r1 = 1
            long r0 = r0 + r1
            r19 = r0
            goto L_0x0052
        L_0x0075:
            goto L_0x00aa
        L_0x0078:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
            r0 = 0
            r20 = r0
        L_0x0082:
            r0 = r20
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00aa
            r0 = r19
            int r0 = r0.nextInt()
            r0 = r19
            r1 = r14
            r2 = r15
            r3 = r20
            r4 = r3; r1 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r20 = r4
            long r2 = r2 + r3
            int r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.set(r1)
            goto L_0x0082
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.AbstractIntBigList.setElements(long, int[][], long, long):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        removeElements(0, size64());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
    @Deprecated
    public int size() {
        return (int) Math.min(2147483647L, size64());
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v1, types: [long] */
    @Override // java.util.Collection, java.lang.Object
    public int hashCode() {
        IntIterator i = iterator();
        int h = 1;
        char size64 = size64();
        while (true) {
            size64--;
            if (size64 == 0) {
                return h;
            }
            h = (31 * h) + i.nextInt();
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v23, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v26, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARN: Type inference failed for: r1v11, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // java.util.Collection, java.lang.Object
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = r8
            r1 = r7
            if (r0 != r1) goto L_0x0007
            r0 = 1
            return r0
        L_0x0007:
            r0 = r8
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.BigList
            if (r0 != 0) goto L_0x0010
            r0 = 0
            return r0
        L_0x0010:
            r0 = r8
            it.unimi.dsi.fastutil.BigList r0 = (p014it.unimi.dsi.fastutil.BigList) r0
            r9 = r0
            r0 = r7
            long r0 = r0.size64()
            r10 = r0
            r0 = r10
            r1 = r9
            long r1 = r1.size64()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0027
            r0 = 0
            return r0
        L_0x0027:
            r0 = r9
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.ints.IntBigList
            if (r0 == 0) goto L_0x005e
            r0 = r7
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator()
            r12 = r0
            r0 = r9
            it.unimi.dsi.fastutil.ints.IntBigList r0 = (p014it.unimi.dsi.fastutil.ints.IntBigList) r0
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator()
            r13 = r0
        L_0x003f:
            r0 = r10
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r10 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x005c
            r0 = r12
            int r0 = r0.nextInt()
            r1 = r13
            int r1 = r1.nextInt()
            if (r0 == r1) goto L_0x003f
            r0 = 0
            return r0
        L_0x005c:
            r0 = 1
            return r0
        L_0x005e:
            r0 = r7
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator()
            r12 = r0
            r0 = r9
            it.unimi.dsi.fastutil.BigListIterator r0 = r0.listIterator()
            r13 = r0
        L_0x006c:
            r0 = r10
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r10 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x008c
            r0 = r12
            java.lang.Object r0 = r0.next()
            r1 = r13
            java.lang.Object r1 = r1.next()
            boolean r0 = java.util.Objects.equals(r0, r1)
            if (r0 != 0) goto L_0x006c
            r0 = 0
            return r0
        L_0x008c:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.AbstractIntBigList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(p014it.unimi.dsi.fastutil.BigList<? extends java.lang.Integer> r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = r3
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r4
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.ints.IntBigList
            if (r0 == 0) goto L_0x006b
            r0 = r3
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator()
            r5 = r0
            r0 = r4
            it.unimi.dsi.fastutil.ints.IntBigList r0 = (p014it.unimi.dsi.fastutil.ints.IntBigList) r0
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x001d:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r5
            int r0 = r0.nextInt()
            r8 = r0
            r0 = r6
            int r0 = r0.nextInt()
            r9 = r0
            r0 = r8
            r1 = r9
            int r0 = java.lang.Integer.compare(r0, r1)
            r1 = r0
            r7 = r1
            if (r0 == 0) goto L_0x001d
            r0 = r7
            return r0
        L_0x004f:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x005c
            r0 = -1
            goto L_0x006a
        L_0x005c:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0069
            r0 = 1
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            return r0
        L_0x006b:
            r0 = r3
            it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator()
            r5 = r0
            r0 = r4
            it.unimi.dsi.fastutil.BigListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x0077:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00a6
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00a6
            r0 = r5
            java.lang.Object r0 = r0.next()
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r1 = r6
            java.lang.Object r1 = r1.next()
            int r0 = r0.compareTo(r1)
            r1 = r0
            r7 = r1
            if (r0 == 0) goto L_0x0077
            r0 = r7
            return r0
        L_0x00a6:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00b3
            r0 = -1
            goto L_0x00c1
        L_0x00b3:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00c0
            r0 = 1
            goto L_0x00c1
        L_0x00c0:
            r0 = 0
        L_0x00c1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.AbstractIntBigList.compareTo(it.unimi.dsi.fastutil.BigList):int");
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntStack
    public void push(int o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntStack
    public int popInt() {
        if (!isEmpty()) {
            return removeInt(size64() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntStack
    public int topInt() {
        if (!isEmpty()) {
            return getInt(size64() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntStack
    public int peekInt(int i) {
        return getInt((size64() - 1) - ((long) i));
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean rem(int k) {
        long index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeInt(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    public boolean addAll(long index, IntCollection c) {
        return addAll(index, (Collection<? extends Integer>) c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean addAll(IntCollection c) {
        return addAll(size64(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    @Deprecated
    public void add(long index, Integer ok) {
        add(index, ok.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    @Deprecated
    public Integer set(long index, Integer ok) {
        return Integer.valueOf(set(index, ok.intValue()));
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public Integer get(long index) {
        return Integer.valueOf(getInt(index));
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public long indexOf(Object ok) {
        return indexOf(((Integer) ok).intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public long lastIndexOf(Object ok) {
        return lastIndexOf(((Integer) ok).intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public Integer remove(long index) {
        return Integer.valueOf(removeInt(index));
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntStack
    @Deprecated
    public void push(Integer o) {
        push(o.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Integer pop() {
        return Integer.valueOf(popInt());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Integer top() {
        return Integer.valueOf(topInt());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Integer peek(int i) {
        return Integer.valueOf(peekInt(i));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v3, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        IntIterator i = iterator();
        char size64 = size64();
        boolean first = true;
        s.append("[");
        while (true) {
            size64--;
            if (size64 != 0) {
                if (first) {
                    first = false;
                } else {
                    s.append(", ");
                }
                s.append(String.valueOf(i.nextInt()));
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractIntBigList$IntSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractIntBigList$IntSubList.class */
    public static class IntSubList extends AbstractIntBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final IntBigList f1980l;
        protected final long from;

        /* renamed from: to */
        protected long f1981to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'it.unimi.dsi.fastutil.BigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public /* bridge */ /* synthetic */ BigListIterator<Integer> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ void add(long j, Integer num) {
            add(j, num);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Integer set(long j, Integer num) {
            return set(j, num);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Integer remove(long j) {
            return remove(j);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Integer get(long j) {
            return get(j);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(BigList<? extends Integer> bigList) {
            return compareTo(bigList);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Integer peek(int i) {
            return peek(i);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Integer top() {
            return top();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Integer pop() {
            return pop();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ void push(Integer num) {
            push(num);
        }

        static {
            $assertionsDisabled = !AbstractIntBigList.class.desiredAssertionStatus();
        }

        public IntSubList(IntBigList l, long from, long to) {
            this.f1980l = l;
            this.from = from;
            this.f1981to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f1980l.size64()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f1981to > this.f1980l.size64()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f1981to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean add(int k) {
            this.f1980l.add(this.f1981to, k);
            this.f1981to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public void add(long index, int k) {
            ensureIndex(index);
            this.f1980l.add(this.from + index, k);
            this.f1981to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Integer> c) {
            ensureIndex(index);
            this.f1981to += (long) c.size();
            return this.f1980l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int getInt(long index) {
            ensureRestrictedIndex(index);
            return this.f1980l.getInt(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public int removeInt(long index) {
            ensureRestrictedIndex(index);
            this.f1981to--;
            return this.f1980l.removeInt(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public int set(long index, int k) {
            ensureRestrictedIndex(index);
            return this.f1980l.set(this.from + index, k);
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return this.f1981to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public void getElements(long from, int[][] a, long offset, long length) {
            ensureIndex(from);
            if (from + length > size64()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size64() + ")");
            }
            this.f1980l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public void removeElements(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f1980l.removeElements(this.from + from, this.from + to);
            this.f1981to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public void addElements(long index, int[][] a, long offset, long length) {
            ensureIndex(index);
            this.f1980l.addElements(this.from + index, a, offset, length);
            this.f1981to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.ints.AbstractIntBigList$IntSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractIntBigList$IntSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends IntBigListIterators.AbstractIndexBasedBigListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractIntBigList.class.desiredAssertionStatus();
            }

            RandomAccessIter(long pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigIterator
            protected final int get(long i) {
                return IntSubList.this.f1980l.getInt(IntSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, int k) {
                IntSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, int k) {
                IntSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                IntSubList.this.removeInt(i);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return IntSubList.this.f1981to - IntSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigListIterator, p014it.unimi.dsi.fastutil.ints.IntBigListIterator
            public void add(int k) {
                add(k);
                if (!$assertionsDisabled && !IntSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterators.AbstractIndexBasedBigIterator, java.util.Iterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !IntSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.ints.AbstractIntBigList$IntSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractIntBigList$IntSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements IntBigListIterator {
            private IntBigListIterator parent;

            ParentWrappingIter(IntBigListIterator parent) {
                this.parent = parent;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.parent.nextIndex() - IntSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.parent.previousIndex() - IntSubList.this.from;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.parent.nextIndex() < IntSubList.this.f1981to;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= IntSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
            public int nextInt() {
                if (hasNext()) {
                    return this.parent.nextInt();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
            public int previousInt() {
                if (hasPrevious()) {
                    return this.parent.previousInt();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterator
            public void add(int k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterator
            public void set(int k) {
                this.parent.set(k);
            }

            @Override // java.util.Iterator
            public void remove() {
                this.parent.remove();
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [long] */
            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterator
            public long back(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                long currentPos = this.parent.previousIndex();
                char c = currentPos - n;
                int i = (c > (IntSubList.this.from - 1) ? 1 : (c == (IntSubList.this.from - 1) ? 0 : -1));
                long parentNewPos = c;
                if (i < 0) {
                    parentNewPos = IntSubList.this.from - 1;
                }
                return this.parent.back((parentNewPos == 1 ? 1 : 0) - currentPos);
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [long] */
            @Override // p014it.unimi.dsi.fastutil.ints.IntBigListIterator
            public long skip(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                long currentPos = this.parent.nextIndex();
                char c = currentPos + n;
                int i = (c > IntSubList.this.f1981to ? 1 : (c == IntSubList.this.f1981to ? 0 : -1));
                long parentNewPos = c;
                if (i > 0) {
                    parentNewPos = IntSubList.this.f1981to;
                }
                return this.parent.skip((parentNewPos == 1 ? 1 : 0) - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Integer> listIterator(long index) {
            ensureIndex(index);
            return this.f1980l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f1980l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return this.f1980l instanceof RandomAccess ? new IndexBasedSpliterator(this.f1980l, this.from, this.f1981to) : spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Integer> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new IntSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean rem(int k) {
            long index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f1981to--;
            this.f1980l.removeInt(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long index, IntCollection c) {
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long index, IntBigList l) {
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractIntBigList$IntRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractIntBigList$IntRandomAccessSubList.class */
    public static class IntRandomAccessSubList extends IntSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public IntRandomAccessSubList(IntBigList l, long from, long to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList.IntSubList, p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Integer> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new IntRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
