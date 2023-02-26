package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.shorts.ShortIterators;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortList.class */
public abstract class AbstractShortList extends AbstractShortCollection implements ShortList, ShortStack {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public void add(int index, short k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean add(short k) {
        add(size(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public short removeShort(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public short set(int index, short k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends Short> c) {
        if (c instanceof ShortCollection) {
            return addAll(index, (ShortCollection) c);
        }
        ensureIndex(index);
        Iterator<? extends Short> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, ((Short) i.next()).shortValue());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Short> c) {
        return addAll(size(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public ShortListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
    public ListIterator<Short> listIterator() {
        return listIterator(0);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
    public ListIterator<Short> listIterator(int index) {
        ensureIndex(index);
        return new ShortIterators.AbstractIndexBasedListIterator(0, index) { // from class: it.unimi.dsi.fastutil.shorts.AbstractShortList.1
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator
            protected final short get(int i) {
                return AbstractShortList.this.getShort(i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedListIterator
            protected final void add(int i, short k) {
                AbstractShortList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedListIterator
            protected final void set(int i, short k) {
                AbstractShortList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                AbstractShortList.this.removeShort(i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return AbstractShortList.this.size();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends ShortSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final ShortList f2854l;

        /* access modifiers changed from: package-private */
        public IndexBasedSpliterator(ShortList l, int pos) {
            super(pos);
            this.f2854l = l;
        }

        IndexBasedSpliterator(ShortList l, int pos, int maxPos) {
            super(pos, maxPos);
            this.f2854l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final int getMaxPosFromBackingStore() {
            return this.f2854l.size();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
        protected final short get(int i) {
            return this.f2854l.getShort(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(int pos, int maxPos) {
            return new IndexBasedSpliterator(this.f2854l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean contains(short k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(short r4) {
        /*
            r3 = this;
            r0 = r3
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator()
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
            int r0 = r0.previousIndex()
            return r0
        L_0x0021:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortList.indexOf(short):int");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int lastIndexOf(short r4) {
        /*
            r3 = this;
            r0 = r3
            r1 = r3
            int r1 = r1.size()
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator(r1)
            r5 = r0
        L_0x0009:
            r0 = r5
            boolean r0 = r0.hasPrevious()
            if (r0 == 0) goto L_0x0025
            r0 = r5
            short r0 = r0.previousShort()
            r6 = r0
            r0 = r4
            r1 = r6
            if (r0 != r1) goto L_0x0009
            r0 = r5
            int r0 = r0.nextIndex()
            return r0
        L_0x0025:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortList.lastIndexOf(short):int");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public void size(int size) {
        int i = size();
        if (size > i) {
            while (true) {
                i++;
                if (i < size) {
                    add((short) 0);
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                i--;
                if (i != size) {
                    removeShort(i);
                } else {
                    return;
                }
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
    public List<Short> subList(int from, int to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new ShortRandomAccessSubList(this, from, to) : new ShortSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public void forEach(ShortConsumer action) {
        if (this instanceof RandomAccess) {
            int max = size();
            for (int i = 0; i < max; i++) {
                action.accept(getShort(i));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(int r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r5
            r1 = r6
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator(r1)
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
            short r0 = r0.nextShort()
            r0 = r8
            r0.remove()
            goto L_0x003e
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortList.removeElements(int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(int r6, short[] r7, int r8, int r9) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            r2 = r9
            p014it.unimi.dsi.fastutil.shorts.ShortArrays.ensureOffsetLength(r0, r1, r2)
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
            short r2 = r2[r3]
            r0.add(r1, r2)
            goto L_0x0013
        L_0x002c:
            r0 = r5
            r1 = r6
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator(r1)
            r10 = r0
        L_0x0033:
            r0 = r9
            int r9 = r9 + -1
            if (r0 == 0) goto L_0x004b
            r0 = r10
            r1 = r7
            r2 = r8
            int r8 = r8 + 1
            short r1 = r1[r2]
            r0.add(r1)
            goto L_0x0033
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortList.addElements(int, short[], int, int):void");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public void addElements(int index, short[] a) {
        addElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(int r7, short[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.shorts.ShortArrays.ensureOffsetLength(r0, r1, r2)
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
            short r2 = r2.getShort(r3)
            r0[r1] = r2
            goto L_0x0050
        L_0x006a:
            goto L_0x008c
        L_0x006d:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator(r1)
            r11 = r0
        L_0x0074:
            r0 = r10
            int r10 = r10 + -1
            if (r0 == 0) goto L_0x008c
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r2 = r11
            short r2 = r2.nextShort()
            r0[r1] = r2
            goto L_0x0074
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortList.getElements(int, short[], int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(int r7, short[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.shorts.ShortArrays.ensureOffsetLength(r0, r1, r2)
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
            short r2 = r2[r3]
            short r0 = r0.set(r1, r2)
            int r11 = r11 + 1
            goto L_0x0050
        L_0x006c:
            goto L_0x009b
        L_0x006f:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x0079:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x009b
            r0 = r11
            short r0 = r0.nextShort()
            r0 = r11
            r1 = r8
            r2 = r9
            r3 = r12
            int r12 = r12 + 1
            int r2 = r2 + r3
            short r1 = r1[r2]
            r0.set(r1)
            goto L_0x0079
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortList.setElements(int, short[], int, int):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        removeElements(0, size());
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        ShortIterator i = iterator();
        int h = 1;
        int s = size();
        while (true) {
            s--;
            if (s == 0) {
                return h;
            }
            h = (31 * h) + i.nextShort();
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // java.util.Collection, java.lang.Object, java.util.List
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = r3
            if (r0 != r1) goto L_0x0007
            r0 = 1
            return r0
        L_0x0007:
            r0 = r4
            boolean r0 = r0 instanceof java.util.List
            if (r0 != 0) goto L_0x0010
            r0 = 0
            return r0
        L_0x0010:
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            r5 = r0
            r0 = r3
            int r0 = r0.size()
            r6 = r0
            r0 = r6
            r1 = r5
            int r1 = r1.size()
            if (r0 == r1) goto L_0x0026
            r0 = 0
            return r0
        L_0x0026:
            r0 = r5
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.shorts.ShortList
            if (r0 == 0) goto L_0x005a
            r0 = r3
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r5
            it.unimi.dsi.fastutil.shorts.ShortList r0 = (p014it.unimi.dsi.fastutil.shorts.ShortList) r0
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x003e:
            r0 = r6
            int r6 = r6 + -1
            if (r0 == 0) goto L_0x0058
            r0 = r7
            short r0 = r0.nextShort()
            r1 = r8
            short r1 = r1.nextShort()
            if (r0 == r1) goto L_0x003e
            r0 = 0
            return r0
        L_0x0058:
            r0 = 1
            return r0
        L_0x005a:
            r0 = r3
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r5
            java.util.ListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x0068:
            r0 = r6
            int r6 = r6 + -1
            if (r0 == 0) goto L_0x0085
            r0 = r7
            java.lang.Object r0 = r0.next()
            r1 = r8
            java.lang.Object r1 = r1.next()
            boolean r0 = java.util.Objects.equals(r0, r1)
            if (r0 != 0) goto L_0x0068
            r0 = 0
            return r0
        L_0x0085:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(java.util.List<? extends java.lang.Short> r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = r3
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r4
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.shorts.ShortList
            if (r0 == 0) goto L_0x006b
            r0 = r3
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator()
            r5 = r0
            r0 = r4
            it.unimi.dsi.fastutil.shorts.ShortList r0 = (p014it.unimi.dsi.fastutil.shorts.ShortList) r0
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator()
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
            it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator()
            r5 = r0
            r0 = r4
            java.util.ListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.AbstractShortList.compareTo(java.util.List):int");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack
    public void push(short o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack
    public short popShort() {
        if (!isEmpty()) {
            return removeShort(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack
    public short topShort() {
        if (!isEmpty()) {
            return getShort(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortStack
    public short peekShort(int i) {
        return getShort((size() - 1) - i);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean rem(short k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeShort(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public short[] toShortArray() {
        int size = size();
        short[] ret = new short[size];
        getElements(0, ret, 0, size);
        return ret;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public short[] toArray(short[] a) {
        int size = size();
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        getElements(0, a, 0, size);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public boolean addAll(int index, ShortCollection c) {
        ensureIndex(index);
        ShortIterator i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, i.nextShort());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean addAll(ShortCollection c) {
        return addAll(size(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ShortIterator i = iterator();
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
                s.append(String.valueOf((int) i.nextShort()));
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortList$ShortSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortList$ShortSubList.class */
    public static class ShortSubList extends AbstractShortList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final ShortList f2855l;
        protected final int from;

        /* renamed from: to */
        protected int f2856to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'java.util.ListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator<Short> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(List<? extends Short> list) {
            return compareTo(list);
        }

        static {
            $assertionsDisabled = !AbstractShortList.class.desiredAssertionStatus();
        }

        public ShortSubList(ShortList l, int from, int to) {
            this.f2855l = l;
            this.from = from;
            this.f2856to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f2855l.size()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f2856to > this.f2855l.size()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f2856to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean add(short k) {
            this.f2855l.add(this.f2856to, k);
            this.f2856to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void add(int index, short k) {
            ensureIndex(index);
            this.f2855l.add(this.from + index, k);
            this.f2856to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.util.List
        public boolean addAll(int index, Collection<? extends Short> c) {
            ensureIndex(index);
            this.f2856to += c.size();
            return this.f2855l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short getShort(int index) {
            ensureRestrictedIndex(index);
            return this.f2855l.getShort(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public short removeShort(int index) {
            ensureRestrictedIndex(index);
            this.f2856to--;
            return this.f2855l.removeShort(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public short set(int index, short k) {
            ensureRestrictedIndex(index);
            return this.f2855l.set(this.from + index, k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f2856to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void getElements(int from, short[] a, int offset, int length) {
            ensureIndex(from);
            if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size() + ")");
            }
            this.f2855l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void removeElements(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f2855l.removeElements(this.from + from, this.from + to);
            this.f2856to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void addElements(int index, short[] a, int offset, int length) {
            ensureIndex(index);
            this.f2855l.addElements(this.from + index, a, offset, length);
            this.f2856to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(int index, short[] a, int offset, int length) {
            ensureIndex(index);
            this.f2855l.setElements(this.from + index, a, offset, length);
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortList$ShortSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortList$ShortSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends ShortIterators.AbstractIndexBasedListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractShortList.class.desiredAssertionStatus();
            }

            RandomAccessIter(int pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator
            protected final short get(int i) {
                return ShortSubList.this.f2855l.getShort(ShortSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedListIterator
            protected final void add(int i, short k) {
                ShortSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedListIterator
            protected final void set(int i, short k) {
                ShortSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                ShortSubList.this.removeShort(i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return ShortSubList.this.f2856to - ShortSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.shorts.ShortListIterator
            public void add(short k) {
                add(k);
                if (!$assertionsDisabled && !ShortSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator, java.util.Iterator, p014it.unimi.dsi.fastutil.shorts.ShortListIterator, java.util.ListIterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !ShortSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortList$ShortSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortList$ShortSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements ShortListIterator {
            private ShortListIterator parent;

            ParentWrappingIter(ShortListIterator parent) {
                this.parent = parent;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.parent.nextIndex() - ShortSubList.this.from;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.parent.previousIndex() - ShortSubList.this.from;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.parent.nextIndex() < ShortSubList.this.f2856to;
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

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
            public void add(short k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
            public void set(short k) {
                this.parent.set(k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                this.parent.remove();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.previousIndex();
                int parentNewPos = currentPos - n;
                if (parentNewPos < ShortSubList.this.from - 1) {
                    parentNewPos = ShortSubList.this.from - 1;
                }
                return this.parent.back(parentNewPos - currentPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.nextIndex();
                int parentNewPos = currentPos + n;
                if (parentNewPos > ShortSubList.this.f2856to) {
                    parentNewPos = ShortSubList.this.f2856to;
                }
                return this.parent.skip(parentNewPos - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public ListIterator<Short> listIterator(int index) {
            ensureIndex(index);
            return this.f2855l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f2855l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return this.f2855l instanceof RandomAccess ? new IndexBasedSpliterator(this.f2855l, this.from, this.f2856to) : spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public List<Short> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new ShortSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean rem(short k) {
            int index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f2856to--;
            this.f2855l.removeShort(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(int index, ShortCollection c) {
            ensureIndex(index);
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(int index, ShortList l) {
            ensureIndex(index);
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShortList$ShortRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShortList$ShortRandomAccessSubList.class */
    public static class ShortRandomAccessSubList extends ShortSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public ShortRandomAccessSubList(ShortList l, int from, int to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList.ShortSubList, p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public List<Short> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new ShortRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
