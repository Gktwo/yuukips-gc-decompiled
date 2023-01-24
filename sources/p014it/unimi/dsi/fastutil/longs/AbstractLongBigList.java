package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.longs.LongBigListIterators;
import p014it.unimi.dsi.fastutil.longs.LongBigSpliterators;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongBigList.class */
public abstract class AbstractLongBigList extends AbstractLongCollection implements LongBigList, LongStack {
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

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public void add(long index, long k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean add(long k) {
        add(size64(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public long removeLong(long i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public long set(long index, long k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public boolean addAll(long index, Collection<? extends Long> c) {
        ensureIndex(index);
        Iterator<? extends Long> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, (Long) i.next());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Long> c) {
        return addAll(size64(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    public LongBigListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Long> listIterator() {
        return listIterator(0L);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Long> listIterator(long index) {
        ensureIndex(index);
        return new LongBigListIterators.AbstractIndexBasedBigListIterator(0, index) { // from class: it.unimi.dsi.fastutil.longs.AbstractLongBigList.1
            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator
            protected final long get(long i) {
                return AbstractLongBigList.this.getLong(i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, long k) {
                AbstractLongBigList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, long k) {
                AbstractLongBigList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                AbstractLongBigList.this.removeLong(i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return AbstractLongBigList.this.size64();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongBigList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongBigList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends LongBigSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final LongBigList f2257l;

        IndexBasedSpliterator(LongBigList l, long pos) {
            super(pos);
            this.f2257l = l;
        }

        IndexBasedSpliterator(LongBigList l, long pos, long maxPos) {
            super(pos, maxPos);
            this.f2257l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final long getMaxPosFromBackingStore() {
            return this.f2257l.size64();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigSpliterators.AbstractIndexBasedSpliterator
        protected final long get(long i) {
            return this.f2257l.getLong(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.longs.LongBigSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(long pos, long maxPos) {
            return new IndexBasedSpliterator(this.f2257l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean contains(long k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long indexOf(long r6) {
        /*
            r5 = this;
            r0 = r5
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x0005:
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0024
            r0 = r8
            long r0 = r0.nextLong()
            r9 = r0
            r0 = r6
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0005
            r0 = r8
            long r0 = r0.previousIndex()
            return r0
        L_0x0024:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.indexOf(long):long");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long lastIndexOf(long r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = r5
            long r1 = r1.size64()
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator(r1)
            r8 = r0
        L_0x0009:
            r0 = r8
            boolean r0 = r0.hasPrevious()
            if (r0 == 0) goto L_0x0028
            r0 = r8
            long r0 = r0.previousLong()
            r9 = r0
            r0 = r6
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0009
            r0 = r8
            long r0 = r0.nextIndex()
            return r0
        L_0x0028:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.lastIndexOf(long):long");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
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
                char c = (i3 == 1 ? 1 : 0) - 1;
                if (i3 != size) {
                    remove((long) c);
                    i3 = c;
                } else {
                    return;
                }
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
    public BigList<Long> subList(long from, long to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new LongRandomAccessSubList(this, from, to) : new LongSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
    public void forEach(LongConsumer action) {
        if (this instanceof RandomAccess) {
            long max = size64();
            for (char c = 0; c < max; c++) {
                action.accept(getLong(c));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(long r8, long r10) {
        /*
            r7 = this;
            r0 = r7
            r1 = r10
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator(r1)
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
            long r0 = r0.nextLong()
            r0 = r12
            r0.remove()
            goto L_0x0041
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.removeElements(long, long):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: long[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
    /* JADX WARN: Type inference failed for: r1v4, types: [long] */
    /* JADX WARN: Type inference failed for: r2v3, types: [long, long[][]] */
    /* JADX WARN: Type inference failed for: r1v10, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(long r12, long[][] r14, long r15, long r17) {
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
            long r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            r0.add(r1, r2)
            goto L_0x0014
        L_0x0037:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator(r1)
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
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.add(r1)
            goto L_0x003e
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.addElements(long, long[][], long, long):void");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public void addElements(long index, long[][] a) {
        addElements(index, a, 0, BigArrays.length(a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [long, it.unimi.dsi.fastutil.longs.AbstractLongBigList] */
    /* JADX WARN: Type inference failed for: r12v0, types: [long] */
    /* JADX WARN: Type inference failed for: r17v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v8, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
    /* JADX WARN: Type inference failed for: r1v7, types: [long] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(long r12, long[][] r14, long r15, long r17) {
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
            long r2 = r2.getLong(r3)
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0052
        L_0x0077:
            goto L_0x00a2
        L_0x007a:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator(r1)
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
            long r2 = r2.nextLong()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0081
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.getElements(long, long[][], long, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [long, long[][]] */
    /* JADX WARN: Type inference failed for: r0v8, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(long r12, long[][] r14, long r15, long r17) {
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
            long r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            long r0 = r0.set(r1, r2)
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
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
            r0 = 0
            r20 = r0
        L_0x0082:
            r0 = r20
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00aa
            r0 = r19
            long r0 = r0.nextLong()
            r0 = r19
            r1 = r14
            r2 = r15
            r3 = r20
            r4 = r3; r1 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r20 = r4
            long r2 = r2 + r3
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.set(r1)
            goto L_0x0082
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.setElements(long, long[][], long, long):void");
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
        LongIterator i = iterator();
        int h = 1;
        char size64 = size64();
        while (true) {
            size64--;
            if (size64 == 0) {
                return h;
            }
            h = (31 * h) + HashCommon.long2int(i.nextLong());
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v23, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v26, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
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
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.longs.LongBigList
            if (r0 == 0) goto L_0x005f
            r0 = r7
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator()
            r12 = r0
            r0 = r9
            it.unimi.dsi.fastutil.longs.LongBigList r0 = (p014it.unimi.dsi.fastutil.longs.LongBigList) r0
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator()
            r13 = r0
        L_0x003f:
            r0 = r10
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r10 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x005d
            r0 = r12
            long r0 = r0.nextLong()
            r1 = r13
            long r1 = r1.nextLong()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003f
            r0 = 0
            return r0
        L_0x005d:
            r0 = 1
            return r0
        L_0x005f:
            r0 = r7
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator()
            r12 = r0
            r0 = r9
            it.unimi.dsi.fastutil.BigListIterator r0 = r0.listIterator()
            r13 = r0
        L_0x006d:
            r0 = r10
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r10 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x008d
            r0 = r12
            java.lang.Object r0 = r0.next()
            r1 = r13
            java.lang.Object r1 = r1.next()
            boolean r0 = java.util.Objects.equals(r0, r1)
            if (r0 != 0) goto L_0x006d
            r0 = 0
            return r0
        L_0x008d:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(p014it.unimi.dsi.fastutil.BigList<? extends java.lang.Long> r6) {
        /*
            r5 = this;
            r0 = r6
            r1 = r5
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.longs.LongBigList
            if (r0 == 0) goto L_0x006b
            r0 = r5
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r6
            it.unimi.dsi.fastutil.longs.LongBigList r0 = (p014it.unimi.dsi.fastutil.longs.LongBigList) r0
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x001d:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r7
            long r0 = r0.nextLong()
            r10 = r0
            r0 = r8
            long r0 = r0.nextLong()
            r12 = r0
            r0 = r10
            r1 = r12
            int r0 = java.lang.Long.compare(r0, r1)
            r1 = r0
            r9 = r1
            if (r0 == 0) goto L_0x001d
            r0 = r9
            return r0
        L_0x004f:
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x005c
            r0 = -1
            goto L_0x006a
        L_0x005c:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0069
            r0 = 1
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            return r0
        L_0x006b:
            r0 = r5
            it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r6
            it.unimi.dsi.fastutil.BigListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x0077:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00a6
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00a6
            r0 = r7
            java.lang.Object r0 = r0.next()
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r1 = r8
            java.lang.Object r1 = r1.next()
            int r0 = r0.compareTo(r1)
            r1 = r0
            r9 = r1
            if (r0 == 0) goto L_0x0077
            r0 = r9
            return r0
        L_0x00a6:
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00b3
            r0 = -1
            goto L_0x00c1
        L_0x00b3:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00c0
            r0 = 1
            goto L_0x00c1
        L_0x00c0:
            r0 = 0
        L_0x00c1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.compareTo(it.unimi.dsi.fastutil.BigList):int");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack
    public void push(long o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack
    public long popLong() {
        if (!isEmpty()) {
            return removeLong(size64() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack
    public long topLong() {
        if (!isEmpty()) {
            return getLong(size64() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack
    public long peekLong(int i) {
        return getLong((size64() - 1) - ((long) i));
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean rem(long k) {
        long index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeLong(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public boolean addAll(long index, LongCollection c) {
        return addAll(index, (Collection<? extends Long>) c);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean addAll(LongCollection c) {
        return addAll(size64(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    @Deprecated
    public void add(long index, Long ok) {
        add(index, ok.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    @Deprecated
    public Long set(long index, Long ok) {
        return Long.valueOf(set(index, ok.longValue()));
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public Long get(long index) {
        return Long.valueOf(getLong(index));
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public long indexOf(Object ok) {
        return indexOf(((Long) ok).longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public long lastIndexOf(Object ok) {
        return lastIndexOf(((Long) ok).longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public Long remove(long index) {
        return Long.valueOf(removeLong(index));
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack
    @Deprecated
    public void push(Long o) {
        push(o.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Long pop() {
        return Long.valueOf(popLong());
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Long top() {
        return Long.valueOf(topLong());
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Long peek(int i) {
        return Long.valueOf(peekLong(i));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v3, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        LongIterator i = iterator();
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
                s.append(String.valueOf(i.nextLong()));
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongBigList$LongSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongBigList$LongSubList.class */
    public static class LongSubList extends AbstractLongBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final LongBigList f2258l;
        protected final long from;

        /* renamed from: to */
        protected long f2259to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'it.unimi.dsi.fastutil.BigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public /* bridge */ /* synthetic */ BigListIterator<Long> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ void add(long j, Long l) {
            add(j, l);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Long set(long j, Long l) {
            return set(j, l);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Long remove(long j) {
            return remove(j);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Long get(long j) {
            return get(j);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(BigList<? extends Long> bigList) {
            return compareTo(bigList);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Long peek(int i) {
            return peek(i);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Long top() {
            return top();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Long pop() {
            return pop();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ void push(Long l) {
            push(l);
        }

        static {
            $assertionsDisabled = !AbstractLongBigList.class.desiredAssertionStatus();
        }

        public LongSubList(LongBigList l, long from, long to) {
            this.f2258l = l;
            this.from = from;
            this.f2259to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f2258l.size64()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f2259to > this.f2258l.size64()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f2259to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean add(long k) {
            this.f2258l.add(this.f2259to, k);
            this.f2259to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public void add(long index, long k) {
            ensureIndex(index);
            this.f2258l.add(this.from + index, k);
            this.f2259to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Long> c) {
            ensureIndex(index);
            this.f2259to += (long) c.size();
            return this.f2258l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long getLong(long index) {
            ensureRestrictedIndex(index);
            return this.f2258l.getLong(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public long removeLong(long index) {
            ensureRestrictedIndex(index);
            this.f2259to--;
            return this.f2258l.removeLong(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public long set(long index, long k) {
            ensureRestrictedIndex(index);
            return this.f2258l.set(this.from + index, k);
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return this.f2259to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public void getElements(long from, long[][] a, long offset, long length) {
            ensureIndex(from);
            if (from + length > size64()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size64() + ")");
            }
            this.f2258l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public void removeElements(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f2258l.removeElements(this.from + from, this.from + to);
            this.f2259to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public void addElements(long index, long[][] a, long offset, long length) {
            ensureIndex(index);
            this.f2258l.addElements(this.from + index, a, offset, length);
            this.f2259to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongBigList$LongSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongBigList$LongSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends LongBigListIterators.AbstractIndexBasedBigListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractLongBigList.class.desiredAssertionStatus();
            }

            RandomAccessIter(long pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator
            protected final long get(long i) {
                return LongSubList.this.f2258l.getLong(LongSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, long k) {
                LongSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, long k) {
                LongSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                LongSubList.this.removeLong(i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return LongSubList.this.f2259to - LongSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigListIterator, p014it.unimi.dsi.fastutil.longs.LongBigListIterator
            public void add(long k) {
                add(k);
                if (!$assertionsDisabled && !LongSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator, java.util.Iterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !LongSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongBigList$LongSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongBigList$LongSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements LongBigListIterator {
            private LongBigListIterator parent;

            ParentWrappingIter(LongBigListIterator parent) {
                this.parent = parent;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.parent.nextIndex() - LongSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.parent.previousIndex() - LongSubList.this.from;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.parent.nextIndex() < LongSubList.this.f2259to;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= LongSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
            public long nextLong() {
                if (hasNext()) {
                    return this.parent.nextLong();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
            public long previousLong() {
                if (hasPrevious()) {
                    return this.parent.previousLong();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterator
            public void add(long k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterator
            public void set(long k) {
                this.parent.set(k);
            }

            @Override // java.util.Iterator
            public void remove() {
                this.parent.remove();
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [long] */
            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterator
            public long back(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                long currentPos = this.parent.previousIndex();
                char c = currentPos - n;
                int i = (c > (LongSubList.this.from - 1) ? 1 : (c == (LongSubList.this.from - 1) ? 0 : -1));
                long parentNewPos = c;
                if (i < 0) {
                    parentNewPos = LongSubList.this.from - 1;
                }
                return this.parent.back((parentNewPos == 1 ? 1 : 0) - currentPos);
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [long] */
            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterator
            public long skip(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                long currentPos = this.parent.nextIndex();
                char c = currentPos + n;
                int i = (c > LongSubList.this.f2259to ? 1 : (c == LongSubList.this.f2259to ? 0 : -1));
                long parentNewPos = c;
                if (i > 0) {
                    parentNewPos = LongSubList.this.f2259to;
                }
                return this.parent.skip((parentNewPos == 1 ? 1 : 0) - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator(long index) {
            ensureIndex(index);
            return this.f2258l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f2258l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return this.f2258l instanceof RandomAccess ? new IndexBasedSpliterator(this.f2258l, this.from, this.f2259to) : spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Long> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new LongSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean rem(long k) {
            long index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f2259to--;
            this.f2258l.removeLong(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long index, LongCollection c) {
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long index, LongBigList l) {
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongBigList$LongRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongBigList$LongRandomAccessSubList.class */
    public static class LongRandomAccessSubList extends LongSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public LongRandomAccessSubList(LongBigList l, long from, long to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.LongSubList, p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Long> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new LongRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
