package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators;
import p014it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleBigList.class */
public abstract class AbstractDoubleBigList extends AbstractDoubleCollection implements DoubleBigList, DoubleStack {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    public void add(long index, double k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean add(double k) {
        add(size64(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    public double removeDouble(long i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    public double set(long index, double k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public boolean addAll(long index, Collection<? extends Double> c) {
        ensureIndex(index);
        Iterator<? extends Double> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, (Double) i.next());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Double> c) {
        return addAll(size64(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleBigListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Double> listIterator() {
        return listIterator(0L);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Double> listIterator(long index) {
        ensureIndex(index);
        return new DoubleBigListIterators.AbstractIndexBasedBigListIterator(0, index) { // from class: it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList.1
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigIterator
            protected final double get(long i) {
                return AbstractDoubleBigList.this.getDouble(i);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, double k) {
                AbstractDoubleBigList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, double k) {
                AbstractDoubleBigList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                AbstractDoubleBigList.this.removeDouble(i);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return AbstractDoubleBigList.this.size64();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleBigList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends DoubleBigSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final DoubleBigList f1539l;

        IndexBasedSpliterator(DoubleBigList l, long pos) {
            super(pos);
            this.f1539l = l;
        }

        IndexBasedSpliterator(DoubleBigList l, long pos, long maxPos) {
            super(pos, maxPos);
            this.f1539l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final long getMaxPosFromBackingStore() {
            return this.f1539l.size64();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators.AbstractIndexBasedSpliterator
        protected final double get(long i) {
            return this.f1539l.getDouble(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(long pos, long maxPos) {
            return new IndexBasedSpliterator(this.f1539l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean contains(double k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long indexOf(double r6) {
        /*
            r5 = this;
            r0 = r5
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x0005:
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x002a
            r0 = r8
            double r0 = r0.nextDouble()
            r9 = r0
            r0 = r6
            long r0 = java.lang.Double.doubleToLongBits(r0)
            r1 = r9
            long r1 = java.lang.Double.doubleToLongBits(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0005
            r0 = r8
            long r0 = r0.previousIndex()
            return r0
        L_0x002a:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList.indexOf(double):long");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long lastIndexOf(double r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = r5
            long r1 = r1.size64()
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator(r1)
            r8 = r0
        L_0x0009:
            r0 = r8
            boolean r0 = r0.hasPrevious()
            if (r0 == 0) goto L_0x002e
            r0 = r8
            double r0 = r0.previousDouble()
            r9 = r0
            r0 = r6
            long r0 = java.lang.Double.doubleToLongBits(r0)
            r1 = r9
            long r1 = java.lang.Double.doubleToLongBits(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0009
            r0 = r8
            long r0 = r0.nextIndex()
            return r0
        L_0x002e:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList.lastIndexOf(double):long");
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
                    add(0.0d);
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
    public BigList<Double> subList(long from, long to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new DoubleRandomAccessSubList(this, from, to) : new DoubleSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public void forEach(DoubleConsumer action) {
        if (this instanceof RandomAccess) {
            long max = size64();
            for (char c = 0; c < max; c++) {
                action.accept(getDouble(c));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(long r8, long r10) {
        /*
            r7 = this;
            r0 = r7
            r1 = r10
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator(r1)
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
            double r0 = r0.nextDouble()
            r0 = r12
            r0.remove()
            goto L_0x0041
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList.removeElements(long, long):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: double[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
    /* JADX WARN: Type inference failed for: r1v4, types: [long] */
    /* JADX WARN: Type inference failed for: r2v3, types: [long, double[][]] */
    /* JADX WARN: Type inference failed for: r1v10, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(long r12, double[][] r14, long r15, long r17) {
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
            double r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            r0.add(r1, r2)
            goto L_0x0014
        L_0x0037:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator(r1)
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
            double r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.add(r1)
            goto L_0x003e
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList.addElements(long, double[][], long, long):void");
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    public void addElements(long index, double[][] a) {
        addElements(index, a, 0, BigArrays.length(a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [long, it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList] */
    /* JADX WARN: Type inference failed for: r12v0, types: [long] */
    /* JADX WARN: Type inference failed for: r17v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v8, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
    /* JADX WARN: Type inference failed for: r1v7, types: [long] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(long r12, double[][] r14, long r15, long r17) {
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
            double r2 = r2.getDouble(r3)
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0052
        L_0x0077:
            goto L_0x00a2
        L_0x007a:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator(r1)
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
            double r2 = r2.nextDouble()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0081
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList.getElements(long, double[][], long, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [long, double[][]] */
    /* JADX WARN: Type inference failed for: r0v8, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(long r12, double[][] r14, long r15, long r17) {
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
            double r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            double r0 = r0.set(r1, r2)
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
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
            r0 = 0
            r20 = r0
        L_0x0082:
            r0 = r20
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00aa
            r0 = r19
            double r0 = r0.nextDouble()
            r0 = r19
            r1 = r14
            r2 = r15
            r3 = r20
            r4 = r3; r1 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r20 = r4
            long r2 = r2 + r3
            double r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.set(r1)
            goto L_0x0082
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList.setElements(long, double[][], long, long):void");
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
        DoubleIterator i = iterator();
        int h = 1;
        char size64 = size64();
        while (true) {
            size64--;
            if (size64 == 0) {
                return h;
            }
            h = (31 * h) + HashCommon.double2int(i.nextDouble());
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v23, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v26, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
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
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.doubles.DoubleBigList
            if (r0 == 0) goto L_0x005f
            r0 = r7
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator()
            r12 = r0
            r0 = r9
            it.unimi.dsi.fastutil.doubles.DoubleBigList r0 = (p014it.unimi.dsi.fastutil.doubles.DoubleBigList) r0
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator()
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
            double r0 = r0.nextDouble()
            r1 = r13
            double r1 = r1.nextDouble()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003f
            r0 = 0
            return r0
        L_0x005d:
            r0 = 1
            return r0
        L_0x005f:
            r0 = r7
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(p014it.unimi.dsi.fastutil.BigList<? extends java.lang.Double> r6) {
        /*
            r5 = this;
            r0 = r6
            r1 = r5
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.doubles.DoubleBigList
            if (r0 == 0) goto L_0x006b
            r0 = r5
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r6
            it.unimi.dsi.fastutil.doubles.DoubleBigList r0 = (p014it.unimi.dsi.fastutil.doubles.DoubleBigList) r0
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x001d:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r7
            double r0 = r0.nextDouble()
            r10 = r0
            r0 = r8
            double r0 = r0.nextDouble()
            r12 = r0
            r0 = r10
            r1 = r12
            int r0 = java.lang.Double.compare(r0, r1)
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
            it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList.compareTo(it.unimi.dsi.fastutil.BigList):int");
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack
    public void push(double o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack
    public double popDouble() {
        if (!isEmpty()) {
            return removeDouble(size64() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack
    public double topDouble() {
        if (!isEmpty()) {
            return getDouble(size64() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack
    public double peekDouble(int i) {
        return getDouble((size64() - 1) - ((long) i));
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean rem(double k) {
        long index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeDouble(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    public boolean addAll(long index, DoubleCollection c) {
        return addAll(index, (Collection<? extends Double>) c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean addAll(DoubleCollection c) {
        return addAll(size64(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    @Deprecated
    public void add(long index, Double ok) {
        add(index, ok.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    @Deprecated
    public Double set(long index, Double ok) {
        return Double.valueOf(set(index, ok.doubleValue()));
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public Double get(long index) {
        return Double.valueOf(getDouble(index));
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public long indexOf(Object ok) {
        return indexOf(((Double) ok).doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public long lastIndexOf(Object ok) {
        return lastIndexOf(((Double) ok).doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
    @Deprecated
    public Double remove(long index) {
        return Double.valueOf(removeDouble(index));
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack
    @Deprecated
    public void push(Double o) {
        push(o.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Double pop() {
        return Double.valueOf(popDouble());
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Double top() {
        return Double.valueOf(topDouble());
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack, p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    public Double peek(int i) {
        return Double.valueOf(peekDouble(i));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v3, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        DoubleIterator i = iterator();
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
                s.append(String.valueOf(i.nextDouble()));
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList$DoubleSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleBigList$DoubleSubList.class */
    public static class DoubleSubList extends AbstractDoubleBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final DoubleBigList f1537l;
        protected final long from;

        /* renamed from: to */
        protected long f1538to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'it.unimi.dsi.fastutil.BigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public /* bridge */ /* synthetic */ BigListIterator<Double> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ void add(long j, Double d) {
            add(j, d);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Double set(long j, Double d) {
            return set(j, d);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Double remove(long j) {
            return remove(j);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public /* bridge */ /* synthetic */ Double get(long j) {
            return get(j);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(BigList<? extends Double> bigList) {
            return compareTo(bigList);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Double peek(int i) {
            return peek(i);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Double top() {
            return top();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ Double pop() {
            return pop();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleStack, p014it.unimi.dsi.fastutil.Stack
        @Deprecated
        public /* bridge */ /* synthetic */ void push(Double d) {
            push(d);
        }

        static {
            $assertionsDisabled = !AbstractDoubleBigList.class.desiredAssertionStatus();
        }

        public DoubleSubList(DoubleBigList l, long from, long to) {
            this.f1537l = l;
            this.from = from;
            this.f1538to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f1537l.size64()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f1538to > this.f1537l.size64()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f1538to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean add(double k) {
            this.f1537l.add(this.f1538to, k);
            this.f1538to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void add(long index, double k) {
            ensureIndex(index);
            this.f1537l.add(this.from + index, k);
            this.f1538to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Double> c) {
            ensureIndex(index);
            this.f1538to += (long) c.size();
            return this.f1537l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double getDouble(long index) {
            ensureRestrictedIndex(index);
            return this.f1537l.getDouble(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double removeDouble(long index) {
            ensureRestrictedIndex(index);
            this.f1538to--;
            return this.f1537l.removeDouble(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double set(long index, double k) {
            ensureRestrictedIndex(index);
            return this.f1537l.set(this.from + index, k);
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return this.f1538to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void getElements(long from, double[][] a, long offset, long length) {
            ensureIndex(from);
            if (from + length > size64()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size64() + ")");
            }
            this.f1537l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void removeElements(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f1537l.removeElements(this.from + from, this.from + to);
            this.f1538to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void addElements(long index, double[][] a, long offset, long length) {
            ensureIndex(index);
            this.f1537l.addElements(this.from + index, a, offset, length);
            this.f1538to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList$DoubleSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleBigList$DoubleSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends DoubleBigListIterators.AbstractIndexBasedBigListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractDoubleBigList.class.desiredAssertionStatus();
            }

            RandomAccessIter(long pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigIterator
            protected final double get(long i) {
                return DoubleSubList.this.f1537l.getDouble(DoubleSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, double k) {
                DoubleSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, double k) {
                DoubleSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                DoubleSubList.this.removeDouble(i);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return DoubleSubList.this.f1538to - DoubleSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigListIterator, p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterator
            public void add(double k) {
                add(k);
                if (!$assertionsDisabled && !DoubleSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterators.AbstractIndexBasedBigIterator, java.util.Iterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !DoubleSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList$DoubleSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleBigList$DoubleSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements DoubleBigListIterator {
            private DoubleBigListIterator parent;

            ParentWrappingIter(DoubleBigListIterator parent) {
                this.parent = parent;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.parent.nextIndex() - DoubleSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.parent.previousIndex() - DoubleSubList.this.from;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.parent.nextIndex() < DoubleSubList.this.f1538to;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= DoubleSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
            public double nextDouble() {
                if (hasNext()) {
                    return this.parent.nextDouble();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
            public double previousDouble() {
                if (hasPrevious()) {
                    return this.parent.previousDouble();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterator
            public void add(double k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterator
            public void set(double k) {
                this.parent.set(k);
            }

            @Override // java.util.Iterator
            public void remove() {
                this.parent.remove();
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [long] */
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterator
            public long back(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                long currentPos = this.parent.previousIndex();
                char c = currentPos - n;
                int i = (c > (DoubleSubList.this.from - 1) ? 1 : (c == (DoubleSubList.this.from - 1) ? 0 : -1));
                long parentNewPos = c;
                if (i < 0) {
                    parentNewPos = DoubleSubList.this.from - 1;
                }
                return this.parent.back((parentNewPos == 1 ? 1 : 0) - currentPos);
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [long] */
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigListIterator
            public long skip(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                long currentPos = this.parent.nextIndex();
                char c = currentPos + n;
                int i = (c > DoubleSubList.this.f1538to ? 1 : (c == DoubleSubList.this.f1538to ? 0 : -1));
                long parentNewPos = c;
                if (i > 0) {
                    parentNewPos = DoubleSubList.this.f1538to;
                }
                return this.parent.skip((parentNewPos == 1 ? 1 : 0) - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Double> listIterator(long index) {
            ensureIndex(index);
            return this.f1537l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f1537l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return this.f1537l instanceof RandomAccess ? new IndexBasedSpliterator(this.f1537l, this.from, this.f1538to) : spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Double> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new DoubleSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean rem(double k) {
            long index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f1538to--;
            this.f1537l.removeDouble(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long index, DoubleCollection c) {
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long index, DoubleBigList l) {
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList$DoubleRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleBigList$DoubleRandomAccessSubList.class */
    public static class DoubleRandomAccessSubList extends DoubleSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public DoubleRandomAccessSubList(DoubleBigList l, long from, long to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList.DoubleSubList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Double> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new DoubleRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
