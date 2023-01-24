package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators;
import p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortBigList.class */
public abstract class AbstractShortBigList extends AbstractShortCollection implements ShortBigList, ShortStack {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public void add(long index, short k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean add(short k) {
        add(size64(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public short removeShort(long i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public short set(long index, short k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public boolean addAll(long index, Collection<? extends Short> c) {
        ensureIndex(index);
        Iterator<? extends Short> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, (Short) i.next());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Short> c) {
        return addAll(size64(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public ShortBigListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Short> listIterator() {
        return listIterator(0L);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Short> listIterator(long index) {
        ensureIndex(index);
        return new ShortBigListIterators.AbstractIndexBasedBigListIterator(0, index) { // from class: it.unimi.dsi.fastutil.shorts.AbstractShortBigList.1
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator
            protected final short get(long i) {
                return AbstractShortBigList.this.getShort(i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, short k) {
                AbstractShortBigList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, short k) {
                AbstractShortBigList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                AbstractShortBigList.this.removeShort(i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return AbstractShortBigList.this.size64();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortBigList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortBigList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends ShortBigSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final ShortBigList f2887l;

        IndexBasedSpliterator(ShortBigList l, long pos) {
            super(pos);
            this.f2887l = l;
        }

        IndexBasedSpliterator(ShortBigList l, long pos, long maxPos) {
            super(pos, maxPos);
            this.f2887l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final long getMaxPosFromBackingStore() {
            return this.f2887l.size64();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators.AbstractIndexBasedSpliterator
        protected final short get(long i) {
            return this.f2887l.getShort(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(long pos, long maxPos) {
            return new IndexBasedSpliterator(this.f2887l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public IntSpliterator intSpliterator() {
        if (this instanceof RandomAccess) {
            return ShortSpliterators.widen(spliterator());
        }
        return intSpliterator();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean contains(short k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long indexOf(short r4) {
        /*
            r3 = this;
            r0 = r3
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator()
            r5 = r0
        L_0x0005:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0021
            r0 = r5
            short r0 = r0.nextShort()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.indexOf(short):long");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long lastIndexOf(short r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r4
            long r1 = r1.size64()
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator(r1)
            r6 = r0
        L_0x0009:
            r0 = r6
            boolean r0 = r0.hasPrevious()
            if (r0 == 0) goto L_0x0025
            r0 = r6
            short r0 = r0.previousShort()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.lastIndexOf(short):long");
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
                    add((short) 0);
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
    public BigList<Short> subList(long from, long to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new ShortRandomAccessSubList(this, from, to) : new ShortSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public void forEach(ShortConsumer action) {
        if (this instanceof RandomAccess) {
            long max = size64();
            for (char c = 0; c < max; c++) {
                action.accept(getShort(c));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(long r8, long r10) {
        /*
            r7 = this;
            r0 = r7
            r1 = r10
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator(r1)
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
            short r0 = r0.nextShort()
            r0 = r12
            r0.remove()
            goto L_0x0041
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.removeElements(long, long):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: short[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
    /* JADX WARN: Type inference failed for: r1v4, types: [long] */
    /* JADX WARN: Type inference failed for: r2v3, types: [long, short[][]] */
    /* JADX WARN: Type inference failed for: r1v10, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(long r12, short[][] r14, long r15, long r17) {
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
            short r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            r0.add(r1, r2)
            goto L_0x0014
        L_0x0037:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator(r1)
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
            short r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.add(r1)
            goto L_0x003e
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.addElements(long, short[][], long, long):void");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public void addElements(long index, short[][] a) {
        addElements(index, a, 0, BigArrays.length(a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [long, it.unimi.dsi.fastutil.shorts.AbstractShortBigList] */
    /* JADX WARN: Type inference failed for: r12v0, types: [long] */
    /* JADX WARN: Type inference failed for: r17v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v8, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
    /* JADX WARN: Type inference failed for: r1v7, types: [long] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(long r12, short[][] r14, long r15, long r17) {
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
            short r2 = r2.getShort(r3)
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0052
        L_0x0077:
            goto L_0x00a2
        L_0x007a:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator(r1)
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
            short r2 = r2.nextShort()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0081
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.getElements(long, short[][], long, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [long, short[][]] */
    /* JADX WARN: Type inference failed for: r0v8, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(long r12, short[][] r14, long r15, long r17) {
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
            short r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            short r0 = r0.set(r1, r2)
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
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
            r0 = 0
            r20 = r0
        L_0x0082:
            r0 = r20
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00aa
            r0 = r19
            short r0 = r0.nextShort()
            r0 = r19
            r1 = r14
            r2 = r15
            r3 = r20
            r4 = r3; r1 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r20 = r4
            long r2 = r2 + r3
            short r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.set(r1)
            goto L_0x0082
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.setElements(long, short[][], long, long):void");
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
        ShortIterator i = iterator();
        int h = 1;
        char size64 = size64();
        while (true) {
            size64--;
            if (size64 == 0) {
                return h;
            }
            h = (31 * h) + i.nextShort();
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v23, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v26, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
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
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.shorts.ShortBigList
            if (r0 == 0) goto L_0x005e
            r0 = r7
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator()
            r12 = r0
            r0 = r9
            it.unimi.dsi.fastutil.shorts.ShortBigList r0 = (p014it.unimi.dsi.fastutil.shorts.ShortBigList) r0
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator()
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
            short r0 = r0.nextShort()
            r1 = r13
            short r1 = r1.nextShort()
            if (r0 == r1) goto L_0x003f
            r0 = 0
            return r0
        L_0x005c:
            r0 = 1
            return r0
        L_0x005e:
            r0 = r7
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(p014it.unimi.dsi.fastutil.BigList<? extends java.lang.Short> r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = r3
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r4
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.shorts.ShortBigList
            if (r0 == 0) goto L_0x006b
            r0 = r3
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator()
            r5 = r0
            r0 = r4
            it.unimi.dsi.fastutil.shorts.ShortBigList r0 = (p014it.unimi.dsi.fastutil.shorts.ShortBigList) r0
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x001d:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r5
            short r0 = r0.nextShort()
            r8 = r0
            r0 = r6
            short r0 = r0.nextShort()
            r9 = r0
            r0 = r8
            r1 = r9
            int r0 = java.lang.Short.compare(r0, r1)
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
            it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.compareTo(it.unimi.dsi.fastutil.BigList):int");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack
    public void push(short o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack
    public short popShort() {
        if (!isEmpty()) {
            return removeShort(size64() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack
    public short topShort() {
        if (!isEmpty()) {
            return getShort(size64() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack
    public short peekShort(int i) {
        return getShort((size64() - 1) - ((long) i));
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean rem(short k) {
        long index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeShort(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public boolean addAll(long index, ShortCollection c) {
        return addAll(index, (Collection<? extends Short>) c);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean addAll(ShortCollection c) {
        return addAll(size64(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    @Deprecated
    public void add(long index, Short ok) {
        add(index, ok.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    @Deprecated
    public Short set(long index, Short ok) {
        return Short.valueOf(set(index, ok.shortValue()));
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public Short get(long index) {
        return Short.valueOf(getShort(index));
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public long indexOf(Object ok) {
        return indexOf(((Short) ok).shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public long lastIndexOf(Object ok) {
        return lastIndexOf(((Short) ok).shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public Short remove(long index) {
        return Short.valueOf(removeShort(index));
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack
    @Deprecated
    public void push(Short o) {
        push(o.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Short pop() {
        return Short.valueOf(popShort());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Short top() {
        return Short.valueOf(topShort());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Short peek(int i) {
        return Short.valueOf(peekShort(i));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v3, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ShortIterator i = iterator();
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
                s.append(String.valueOf((int) i.nextShort()));
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortBigList$ShortSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortBigList$ShortSubList.class */
    public static class ShortSubList extends AbstractShortBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final ShortBigList f2888l;
        protected final long from;

        /* renamed from: to */
        protected long f2889to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'it.unimi.dsi.fastutil.BigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public /* bridge */ /* synthetic */ BigListIterator<Short> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ void add(long j, Short sh) {
            add(j, sh);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Short set(long j, Short sh) {
            return set(j, sh);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Short remove(long j) {
            return remove(j);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Short get(long j) {
            return get(j);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(BigList<? extends Short> bigList) {
            return compareTo(bigList);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Short peek(int i) {
            return peek(i);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Short top() {
            return top();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Short pop() {
            return pop();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ void push(Short sh) {
            push(sh);
        }

        static {
            $assertionsDisabled = !AbstractShortBigList.class.desiredAssertionStatus();
        }

        public ShortSubList(ShortBigList l, long from, long to) {
            this.f2888l = l;
            this.from = from;
            this.f2889to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f2888l.size64()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f2889to > this.f2888l.size64()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f2889to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean add(short k) {
            this.f2888l.add(this.f2889to, k);
            this.f2889to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void add(long index, short k) {
            ensureIndex(index);
            this.f2888l.add(this.from + index, k);
            this.f2889to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Short> c) {
            ensureIndex(index);
            this.f2889to += (long) c.size();
            return this.f2888l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short getShort(long index) {
            ensureRestrictedIndex(index);
            return this.f2888l.getShort(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short removeShort(long index) {
            ensureRestrictedIndex(index);
            this.f2889to--;
            return this.f2888l.removeShort(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short set(long index, short k) {
            ensureRestrictedIndex(index);
            return this.f2888l.set(this.from + index, k);
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return this.f2889to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void getElements(long from, short[][] a, long offset, long length) {
            ensureIndex(from);
            if (from + length > size64()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size64() + ")");
            }
            this.f2888l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void removeElements(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f2888l.removeElements(this.from + from, this.from + to);
            this.f2889to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void addElements(long index, short[][] a, long offset, long length) {
            ensureIndex(index);
            this.f2888l.addElements(this.from + index, a, offset, length);
            this.f2889to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortBigList$ShortSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortBigList$ShortSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends ShortBigListIterators.AbstractIndexBasedBigListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractShortBigList.class.desiredAssertionStatus();
            }

            RandomAccessIter(long pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator
            protected final short get(long i) {
                return ShortSubList.this.f2888l.getShort(ShortSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, short k) {
                ShortSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, short k) {
                ShortSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                ShortSubList.this.removeShort(i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return ShortSubList.this.f2889to - ShortSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigListIterator, p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
            public void add(short k) {
                add(k);
                if (!$assertionsDisabled && !ShortSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator, java.util.Iterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !ShortSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortBigList$ShortSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortBigList$ShortSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements ShortBigListIterator {
            private ShortBigListIterator parent;

            ParentWrappingIter(ShortBigListIterator parent) {
                this.parent = parent;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.parent.nextIndex() - ShortSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.parent.previousIndex() - ShortSubList.this.from;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.parent.nextIndex() < ShortSubList.this.f2889to;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= ShortSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public short nextShort() {
                if (hasNext()) {
                    return this.parent.nextShort();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
            public short previousShort() {
                if (hasPrevious()) {
                    return this.parent.previousShort();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
            public void add(short k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
            public void set(short k) {
                this.parent.set(k);
            }

            @Override // java.util.Iterator
            public void remove() {
                this.parent.remove();
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [long] */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
            public long back(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                long currentPos = this.parent.previousIndex();
                char c = currentPos - n;
                int i = (c > (ShortSubList.this.from - 1) ? 1 : (c == (ShortSubList.this.from - 1) ? 0 : -1));
                long parentNewPos = c;
                if (i < 0) {
                    parentNewPos = ShortSubList.this.from - 1;
                }
                return this.parent.back((parentNewPos == 1 ? 1 : 0) - currentPos);
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [long] */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
            public long skip(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                long currentPos = this.parent.nextIndex();
                char c = currentPos + n;
                int i = (c > ShortSubList.this.f2889to ? 1 : (c == ShortSubList.this.f2889to ? 0 : -1));
                long parentNewPos = c;
                if (i > 0) {
                    parentNewPos = ShortSubList.this.f2889to;
                }
                return this.parent.skip((parentNewPos == 1 ? 1 : 0) - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator(long index) {
            ensureIndex(index);
            return this.f2888l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f2888l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return this.f2888l instanceof RandomAccess ? new IndexBasedSpliterator(this.f2888l, this.from, this.f2889to) : spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntSpliterator intSpliterator() {
            if (this.f2888l instanceof RandomAccess) {
                return ShortSpliterators.widen(spliterator());
            }
            return intSpliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Short> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new ShortSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean rem(short k) {
            long index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f2889to--;
            this.f2888l.removeShort(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long index, ShortCollection c) {
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long index, ShortBigList l) {
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortBigList$ShortRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortBigList$ShortRandomAccessSubList.class */
    public static class ShortRandomAccessSubList extends ShortSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public ShortRandomAccessSubList(ShortBigList l, long from, long to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.ShortSubList, p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Short> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new ShortRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
