package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleUnaryOperator;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterators;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleList.class */
public abstract class AbstractDoubleList extends AbstractDoubleCollection implements DoubleList, DoubleStack {
    protected void ensureIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is negative");
        } else if (index > size()) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than list size (" + size() + ")");
        }
    }

    protected void ensureRestrictedIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is negative");
        } else if (index >= size()) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + size() + ")");
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void add(int index, double k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean add(double k) {
        add(size(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public double removeDouble(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public double set(int index, double k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends Double> c) {
        if (c instanceof DoubleCollection) {
            return addAll(index, (DoubleCollection) c);
        }
        ensureIndex(index);
        Iterator<? extends Double> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, ((Double) i.next()).doubleValue());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Double> c) {
        return addAll(size(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
    public ListIterator<Double> listIterator() {
        return listIterator(0);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
    public ListIterator<Double> listIterator(int index) {
        ensureIndex(index);
        return new DoubleIterators.AbstractIndexBasedListIterator(0, index) { // from class: it.unimi.dsi.fastutil.doubles.AbstractDoubleList.1
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator
            protected final double get(int i) {
                return AbstractDoubleList.this.getDouble(i);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedListIterator
            protected final void add(int i, double k) {
                AbstractDoubleList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedListIterator
            protected final void set(int i, double k) {
                AbstractDoubleList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                AbstractDoubleList.this.removeDouble(i);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return AbstractDoubleList.this.size();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends DoubleSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final DoubleList f1542l;

        /* access modifiers changed from: package-private */
        public IndexBasedSpliterator(DoubleList l, int pos) {
            super(pos);
            this.f1542l = l;
        }

        IndexBasedSpliterator(DoubleList l, int pos, int maxPos) {
            super(pos, maxPos);
            this.f1542l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final int getMaxPosFromBackingStore() {
            return this.f1542l.size();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
        protected final double get(int i) {
            return this.f1542l.getDouble(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(int pos, int maxPos) {
            return new IndexBasedSpliterator(this.f1542l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean contains(double k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(double r6) {
        /*
            r5 = this;
            r0 = r5
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator()
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
            int r0 = r0.previousIndex()
            return r0
        L_0x002a:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.indexOf(double):int");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int lastIndexOf(double r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = r5
            int r1 = r1.size()
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator(r1)
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
            int r0 = r0.nextIndex()
            return r0
        L_0x002e:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.lastIndexOf(double):int");
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void size(int size) {
        int i = size();
        if (size > i) {
            while (true) {
                i++;
                if (i < size) {
                    add(0.0d);
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                i--;
                if (i != size) {
                    removeDouble(i);
                } else {
                    return;
                }
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
    public List<Double> subList(int from, int to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new DoubleRandomAccessSubList(this, from, to) : new DoubleSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public void forEach(DoubleConsumer action) {
        if (this instanceof RandomAccess) {
            int max = size();
            for (int i = 0; i < max; i++) {
                action.accept(getDouble(i));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(int r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r5
            r1 = r6
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator(r1)
            r8 = r0
            r0 = r7
            r1 = r6
            int r0 = r0 - r1
            r9 = r0
            r0 = r9
            if (r0 >= 0) goto L_0x003e
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Start index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than end index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x003e:
            r0 = r9
            int r9 = r9 + -1
            if (r0 == 0) goto L_0x0056
            r0 = r8
            double r0 = r0.nextDouble()
            r0 = r8
            r0.remove()
            goto L_0x003e
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.removeElements(int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(int r6, double[] r7, int r8, int r9) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            r2 = r9
            p014it.unimi.dsi.fastutil.doubles.DoubleArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r5
            boolean r0 = r0 instanceof java.util.RandomAccess
            if (r0 == 0) goto L_0x002c
        L_0x0013:
            r0 = r9
            int r9 = r9 + -1
            if (r0 == 0) goto L_0x004b
            r0 = r5
            r1 = r6
            int r6 = r6 + 1
            r2 = r7
            r3 = r8
            int r8 = r8 + 1
            r2 = r2[r3]
            r0.add(r1, r2)
            goto L_0x0013
        L_0x002c:
            r0 = r5
            r1 = r6
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator(r1)
            r10 = r0
        L_0x0033:
            r0 = r9
            int r9 = r9 + -1
            if (r0 == 0) goto L_0x004b
            r0 = r10
            r1 = r7
            r2 = r8
            int r8 = r8 + 1
            r1 = r1[r2]
            r0.add(r1)
            goto L_0x0033
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.addElements(int, double[], int, int):void");
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void addElements(int index, double[] a) {
        addElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(int r7, double[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.doubles.DoubleArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r7
            r1 = r10
            int r0 = r0 + r1
            r1 = r6
            int r1 = r1.size()
            if (r0 <= r1) goto L_0x0046
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "End index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            r4 = r10
            int r3 = r3 + r4
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than list size ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            int r3 = r3.size()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0046:
            r0 = r6
            boolean r0 = r0 instanceof java.util.RandomAccess
            if (r0 == 0) goto L_0x006d
            r0 = r7
            r11 = r0
        L_0x0050:
            r0 = r10
            int r10 = r10 + -1
            if (r0 == 0) goto L_0x006a
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r2 = r6
            r3 = r11
            int r11 = r11 + 1
            double r2 = r2.getDouble(r3)
            r0[r1] = r2
            goto L_0x0050
        L_0x006a:
            goto L_0x008c
        L_0x006d:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator(r1)
            r11 = r0
        L_0x0074:
            r0 = r10
            int r10 = r10 + -1
            if (r0 == 0) goto L_0x008c
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r2 = r11
            double r2 = r2.nextDouble()
            r0[r1] = r2
            goto L_0x0074
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.getElements(int, double[], int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(int r7, double[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.doubles.DoubleArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r7
            r1 = r10
            int r0 = r0 + r1
            r1 = r6
            int r1 = r1.size()
            if (r0 <= r1) goto L_0x0046
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "End index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            r4 = r10
            int r3 = r3 + r4
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than list size ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            int r3 = r3.size()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0046:
            r0 = r6
            boolean r0 = r0 instanceof java.util.RandomAccess
            if (r0 == 0) goto L_0x006f
            r0 = 0
            r11 = r0
        L_0x0050:
            r0 = r11
            r1 = r10
            if (r0 >= r1) goto L_0x006c
            r0 = r6
            r1 = r11
            r2 = r7
            int r1 = r1 + r2
            r2 = r8
            r3 = r11
            r4 = r9
            int r3 = r3 + r4
            r2 = r2[r3]
            double r0 = r0.set(r1, r2)
            int r11 = r11 + 1
            goto L_0x0050
        L_0x006c:
            goto L_0x009b
        L_0x006f:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x0079:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x009b
            r0 = r11
            double r0 = r0.nextDouble()
            r0 = r11
            r1 = r8
            r2 = r9
            r3 = r12
            int r12 = r12 + 1
            int r2 = r2 + r3
            r1 = r1[r2]
            r0.set(r1)
            goto L_0x0079
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.setElements(int, double[], int, int):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        removeElements(0, size());
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        DoubleIterator i = iterator();
        int h = 1;
        int s = size();
        while (true) {
            s--;
            if (s == 0) {
                return h;
            }
            h = (31 * h) + HashCommon.double2int(i.nextDouble());
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // java.util.Collection, java.lang.Object, java.util.List
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = r6
            r1 = r5
            if (r0 != r1) goto L_0x0007
            r0 = 1
            return r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0 instanceof java.util.List
            if (r0 != 0) goto L_0x0010
            r0 = 0
            return r0
        L_0x0010:
            r0 = r6
            java.util.List r0 = (java.util.List) r0
            r7 = r0
            r0 = r5
            int r0 = r0.size()
            r8 = r0
            r0 = r8
            r1 = r7
            int r1 = r1.size()
            if (r0 == r1) goto L_0x0026
            r0 = 0
            return r0
        L_0x0026:
            r0 = r7
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.doubles.DoubleList
            if (r0 == 0) goto L_0x005b
            r0 = r5
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator()
            r9 = r0
            r0 = r7
            it.unimi.dsi.fastutil.doubles.DoubleList r0 = (p014it.unimi.dsi.fastutil.doubles.DoubleList) r0
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator()
            r10 = r0
        L_0x003e:
            r0 = r8
            int r8 = r8 + -1
            if (r0 == 0) goto L_0x0059
            r0 = r9
            double r0 = r0.nextDouble()
            r1 = r10
            double r1 = r1.nextDouble()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003e
            r0 = 0
            return r0
        L_0x0059:
            r0 = 1
            return r0
        L_0x005b:
            r0 = r5
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator()
            r9 = r0
            r0 = r7
            java.util.ListIterator r0 = r0.listIterator()
            r10 = r0
        L_0x0069:
            r0 = r8
            int r8 = r8 + -1
            if (r0 == 0) goto L_0x0086
            r0 = r9
            java.lang.Object r0 = r0.next()
            r1 = r10
            java.lang.Object r1 = r1.next()
            boolean r0 = java.util.Objects.equals(r0, r1)
            if (r0 != 0) goto L_0x0069
            r0 = 0
            return r0
        L_0x0086:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(java.util.List<? extends java.lang.Double> r6) {
        /*
            r5 = this;
            r0 = r6
            r1 = r5
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.doubles.DoubleList
            if (r0 == 0) goto L_0x006b
            r0 = r5
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r6
            it.unimi.dsi.fastutil.doubles.DoubleList r0 = (p014it.unimi.dsi.fastutil.doubles.DoubleList) r0
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator()
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
            it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r6
            java.util.ListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.compareTo(java.util.List):int");
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack
    public void push(double o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack
    public double popDouble() {
        if (!isEmpty()) {
            return removeDouble(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack
    public double topDouble() {
        if (!isEmpty()) {
            return getDouble(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleStack
    public double peekDouble(int i) {
        return getDouble((size() - 1) - i);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean rem(double k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeDouble(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public double[] toDoubleArray() {
        int size = size();
        double[] ret = new double[size];
        getElements(0, ret, 0, size);
        return ret;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public double[] toArray(double[] a) {
        int size = size();
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        getElements(0, a, 0, size);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public boolean addAll(int index, DoubleCollection c) {
        ensureIndex(index);
        DoubleIterator i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, i.nextDouble());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean addAll(DoubleCollection c) {
        return addAll(size(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public final void replaceAll(DoubleUnaryOperator operator) {
        replaceAll((DoubleUnaryOperator) operator);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        DoubleIterator i = iterator();
        int n = size();
        boolean first = true;
        s.append("[");
        while (true) {
            n--;
            if (n != 0) {
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

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleList$DoubleSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleList$DoubleSubList.class */
    public static class DoubleSubList extends AbstractDoubleList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final DoubleList f1540l;
        protected final int from;

        /* renamed from: to */
        protected int f1541to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'java.util.ListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator<Double> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(List<? extends Double> list) {
            return compareTo(list);
        }

        static {
            $assertionsDisabled = !AbstractDoubleList.class.desiredAssertionStatus();
        }

        public DoubleSubList(DoubleList l, int from, int to) {
            this.f1540l = l;
            this.from = from;
            this.f1541to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f1540l.size()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f1541to > this.f1540l.size()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f1541to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean add(double k) {
            this.f1540l.add(this.f1541to, k);
            this.f1541to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void add(int index, double k) {
            ensureIndex(index);
            this.f1540l.add(this.from + index, k);
            this.f1541to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.util.List
        public boolean addAll(int index, Collection<? extends Double> c) {
            ensureIndex(index);
            this.f1541to += c.size();
            return this.f1540l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double getDouble(int index) {
            ensureRestrictedIndex(index);
            return this.f1540l.getDouble(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double removeDouble(int index) {
            ensureRestrictedIndex(index);
            this.f1541to--;
            return this.f1540l.removeDouble(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double set(int index, double k) {
            ensureRestrictedIndex(index);
            return this.f1540l.set(this.from + index, k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1541to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void getElements(int from, double[] a, int offset, int length) {
            ensureIndex(from);
            if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size() + ")");
            }
            this.f1540l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void removeElements(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f1540l.removeElements(this.from + from, this.from + to);
            this.f1541to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void addElements(int index, double[] a, int offset, int length) {
            ensureIndex(index);
            this.f1540l.addElements(this.from + index, a, offset, length);
            this.f1541to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(int index, double[] a, int offset, int length) {
            ensureIndex(index);
            this.f1540l.setElements(this.from + index, a, offset, length);
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleList$DoubleSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleList$DoubleSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends DoubleIterators.AbstractIndexBasedListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractDoubleList.class.desiredAssertionStatus();
            }

            RandomAccessIter(int pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator
            protected final double get(int i) {
                return DoubleSubList.this.f1540l.getDouble(DoubleSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedListIterator
            protected final void add(int i, double k) {
                DoubleSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedListIterator
            protected final void set(int i, double k) {
                DoubleSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                DoubleSubList.this.removeDouble(i);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return DoubleSubList.this.f1541to - DoubleSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
            public void add(double k) {
                add(k);
                if (!$assertionsDisabled && !DoubleSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator, java.util.Iterator, p014it.unimi.dsi.fastutil.doubles.DoubleListIterator, java.util.ListIterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !DoubleSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleList$DoubleSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleList$DoubleSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements DoubleListIterator {
            private DoubleListIterator parent;

            ParentWrappingIter(DoubleListIterator parent) {
                this.parent = parent;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.parent.nextIndex() - DoubleSubList.this.from;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.parent.previousIndex() - DoubleSubList.this.from;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.parent.nextIndex() < DoubleSubList.this.f1541to;
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

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
            public void add(double k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
            public void set(double k) {
                this.parent.set(k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                this.parent.remove();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.previousIndex();
                int parentNewPos = currentPos - n;
                if (parentNewPos < DoubleSubList.this.from - 1) {
                    parentNewPos = DoubleSubList.this.from - 1;
                }
                return this.parent.back(parentNewPos - currentPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.nextIndex();
                int parentNewPos = currentPos + n;
                if (parentNewPos > DoubleSubList.this.f1541to) {
                    parentNewPos = DoubleSubList.this.f1541to;
                }
                return this.parent.skip(parentNewPos - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public ListIterator<Double> listIterator(int index) {
            ensureIndex(index);
            return this.f1540l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f1540l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return this.f1540l instanceof RandomAccess ? new IndexBasedSpliterator(this.f1540l, this.from, this.f1541to) : spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public List<Double> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new DoubleSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean rem(double k) {
            int index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f1541to--;
            this.f1540l.removeDouble(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(int index, DoubleCollection c) {
            ensureIndex(index);
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(int index, DoubleList l) {
            ensureIndex(index);
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleList$DoubleRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleList$DoubleRandomAccessSubList.class */
    public static class DoubleRandomAccessSubList extends DoubleSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public DoubleRandomAccessSubList(DoubleList l, int from, int to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.DoubleSubList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public List<Double> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new DoubleRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
