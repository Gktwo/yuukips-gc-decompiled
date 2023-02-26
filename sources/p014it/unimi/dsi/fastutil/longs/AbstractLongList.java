package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.LongConsumer;
import java.util.function.LongUnaryOperator;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.longs.LongIterators;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongList.class */
public abstract class AbstractLongList extends AbstractLongCollection implements LongList, LongStack {
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

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public void add(int index, long k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean add(long k) {
        add(size(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public long removeLong(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public long set(int index, long k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends Long> c) {
        if (c instanceof LongCollection) {
            return addAll(index, (LongCollection) c);
        }
        ensureIndex(index);
        Iterator<? extends Long> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, ((Long) i.next()).longValue());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Long> c) {
        return addAll(size(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    public LongListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
    public ListIterator<Long> listIterator() {
        return listIterator(0);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
    public ListIterator<Long> listIterator(int index) {
        ensureIndex(index);
        return new LongIterators.AbstractIndexBasedListIterator(0, index) { // from class: it.unimi.dsi.fastutil.longs.AbstractLongList.1
            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator
            protected final long get(int i) {
                return AbstractLongList.this.getLong(i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedListIterator
            protected final void add(int i, long k) {
                AbstractLongList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedListIterator
            protected final void set(int i, long k) {
                AbstractLongList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                AbstractLongList.this.removeLong(i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return AbstractLongList.this.size();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends LongSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final LongList f2224l;

        /* access modifiers changed from: package-private */
        public IndexBasedSpliterator(LongList l, int pos) {
            super(pos);
            this.f2224l = l;
        }

        IndexBasedSpliterator(LongList l, int pos, int maxPos) {
            super(pos, maxPos);
            this.f2224l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final int getMaxPosFromBackingStore() {
            return this.f2224l.size();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
        protected final long get(int i) {
            return this.f2224l.getLong(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(int pos, int maxPos) {
            return new IndexBasedSpliterator(this.f2224l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean contains(long k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(long r6) {
        /*
            r5 = this;
            r0 = r5
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator()
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
            int r0 = r0.previousIndex()
            return r0
        L_0x0024:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongList.indexOf(long):int");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int lastIndexOf(long r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = r5
            int r1 = r1.size()
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator(r1)
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
            int r0 = r0.nextIndex()
            return r0
        L_0x0028:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongList.lastIndexOf(long):int");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public void size(int size) {
        int i = size();
        if (size > i) {
            while (true) {
                i++;
                if (i < size) {
                    add(0);
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                i--;
                if (i != size) {
                    removeLong(i);
                } else {
                    return;
                }
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
    public List<Long> subList(int from, int to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new LongRandomAccessSubList(this, from, to) : new LongSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
    public void forEach(LongConsumer action) {
        if (this instanceof RandomAccess) {
            int max = size();
            for (int i = 0; i < max; i++) {
                action.accept(getLong(i));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(int r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r5
            r1 = r6
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator(r1)
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
            long r0 = r0.nextLong()
            r0 = r8
            r0.remove()
            goto L_0x003e
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongList.removeElements(int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(int r6, long[] r7, int r8, int r9) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            r2 = r9
            p014it.unimi.dsi.fastutil.longs.LongArrays.ensureOffsetLength(r0, r1, r2)
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
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongList.addElements(int, long[], int, int):void");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public void addElements(int index, long[] a) {
        addElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(int r7, long[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.longs.LongArrays.ensureOffsetLength(r0, r1, r2)
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
            long r2 = r2.getLong(r3)
            r0[r1] = r2
            goto L_0x0050
        L_0x006a:
            goto L_0x008c
        L_0x006d:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator(r1)
            r11 = r0
        L_0x0074:
            r0 = r10
            int r10 = r10 + -1
            if (r0 == 0) goto L_0x008c
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r2 = r11
            long r2 = r2.nextLong()
            r0[r1] = r2
            goto L_0x0074
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongList.getElements(int, long[], int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(int r7, long[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.longs.LongArrays.ensureOffsetLength(r0, r1, r2)
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
            long r0 = r0.set(r1, r2)
            int r11 = r11 + 1
            goto L_0x0050
        L_0x006c:
            goto L_0x009b
        L_0x006f:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x0079:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x009b
            r0 = r11
            long r0 = r0.nextLong()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongList.setElements(int, long[], int, int):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        removeElements(0, size());
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        LongIterator i = iterator();
        int h = 1;
        int s = size();
        while (true) {
            s--;
            if (s == 0) {
                return h;
            }
            h = (31 * h) + HashCommon.long2int(i.nextLong());
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
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
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.longs.LongList
            if (r0 == 0) goto L_0x005b
            r0 = r5
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator()
            r9 = r0
            r0 = r7
            it.unimi.dsi.fastutil.longs.LongList r0 = (p014it.unimi.dsi.fastutil.longs.LongList) r0
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator()
            r10 = r0
        L_0x003e:
            r0 = r8
            int r8 = r8 + -1
            if (r0 == 0) goto L_0x0059
            r0 = r9
            long r0 = r0.nextLong()
            r1 = r10
            long r1 = r1.nextLong()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003e
            r0 = 0
            return r0
        L_0x0059:
            r0 = 1
            return r0
        L_0x005b:
            r0 = r5
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(java.util.List<? extends java.lang.Long> r6) {
        /*
            r5 = this;
            r0 = r6
            r1 = r5
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.longs.LongList
            if (r0 == 0) goto L_0x006b
            r0 = r5
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r6
            it.unimi.dsi.fastutil.longs.LongList r0 = (p014it.unimi.dsi.fastutil.longs.LongList) r0
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator()
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
            it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.AbstractLongList.compareTo(java.util.List):int");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack
    public void push(long o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack
    public long popLong() {
        if (!isEmpty()) {
            return removeLong(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack
    public long topLong() {
        if (!isEmpty()) {
            return getLong(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongStack
    public long peekLong(int i) {
        return getLong((size() - 1) - i);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean rem(long k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeLong(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public long[] toLongArray() {
        int size = size();
        long[] ret = new long[size];
        getElements(0, ret, 0, size);
        return ret;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public long[] toArray(long[] a) {
        int size = size();
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        getElements(0, a, 0, size);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public boolean addAll(int index, LongCollection c) {
        ensureIndex(index);
        LongIterator i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, i.nextLong());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean addAll(LongCollection c) {
        return addAll(size(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public final void replaceAll(LongUnaryOperator operator) {
        replaceAll((LongUnaryOperator) operator);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        LongIterator i = iterator();
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
                s.append(String.valueOf(i.nextLong()));
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongList$LongSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongList$LongSubList.class */
    public static class LongSubList extends AbstractLongList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final LongList f2225l;
        protected final int from;

        /* renamed from: to */
        protected int f2226to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'java.util.ListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator<Long> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(List<? extends Long> list) {
            return compareTo(list);
        }

        static {
            $assertionsDisabled = !AbstractLongList.class.desiredAssertionStatus();
        }

        public LongSubList(LongList l, int from, int to) {
            this.f2225l = l;
            this.from = from;
            this.f2226to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f2225l.size()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f2226to > this.f2225l.size()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f2226to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean add(long k) {
            this.f2225l.add(this.f2226to, k);
            this.f2226to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void add(int index, long k) {
            ensureIndex(index);
            this.f2225l.add(this.from + index, k);
            this.f2226to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.util.List
        public boolean addAll(int index, Collection<? extends Long> c) {
            ensureIndex(index);
            this.f2226to += c.size();
            return this.f2225l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long getLong(int index) {
            ensureRestrictedIndex(index);
            return this.f2225l.getLong(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public long removeLong(int index) {
            ensureRestrictedIndex(index);
            this.f2226to--;
            return this.f2225l.removeLong(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public long set(int index, long k) {
            ensureRestrictedIndex(index);
            return this.f2225l.set(this.from + index, k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f2226to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void getElements(int from, long[] a, int offset, int length) {
            ensureIndex(from);
            if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size() + ")");
            }
            this.f2225l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void removeElements(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f2225l.removeElements(this.from + from, this.from + to);
            this.f2226to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void addElements(int index, long[] a, int offset, int length) {
            ensureIndex(index);
            this.f2225l.addElements(this.from + index, a, offset, length);
            this.f2226to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(int index, long[] a, int offset, int length) {
            ensureIndex(index);
            this.f2225l.setElements(this.from + index, a, offset, length);
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongList$LongSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongList$LongSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends LongIterators.AbstractIndexBasedListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractLongList.class.desiredAssertionStatus();
            }

            RandomAccessIter(int pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator
            protected final long get(int i) {
                return LongSubList.this.f2225l.getLong(LongSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedListIterator
            protected final void add(int i, long k) {
                LongSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedListIterator
            protected final void set(int i, long k) {
                LongSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                LongSubList.this.removeLong(i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return LongSubList.this.f2226to - LongSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.longs.LongListIterator
            public void add(long k) {
                add(k);
                if (!$assertionsDisabled && !LongSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator, java.util.Iterator, p014it.unimi.dsi.fastutil.longs.LongListIterator, java.util.ListIterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !LongSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongList$LongSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongList$LongSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements LongListIterator {
            private LongListIterator parent;

            ParentWrappingIter(LongListIterator parent) {
                this.parent = parent;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.parent.nextIndex() - LongSubList.this.from;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.parent.previousIndex() - LongSubList.this.from;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.parent.nextIndex() < LongSubList.this.f2226to;
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

            @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
            public void add(long k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
            public void set(long k) {
                this.parent.set(k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                this.parent.remove();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.previousIndex();
                int parentNewPos = currentPos - n;
                if (parentNewPos < LongSubList.this.from - 1) {
                    parentNewPos = LongSubList.this.from - 1;
                }
                return this.parent.back(parentNewPos - currentPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.nextIndex();
                int parentNewPos = currentPos + n;
                if (parentNewPos > LongSubList.this.f2226to) {
                    parentNewPos = LongSubList.this.f2226to;
                }
                return this.parent.skip(parentNewPos - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public ListIterator<Long> listIterator(int index) {
            ensureIndex(index);
            return this.f2225l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f2225l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return this.f2225l instanceof RandomAccess ? new IndexBasedSpliterator(this.f2225l, this.from, this.f2226to) : spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public List<Long> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new LongSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean rem(long k) {
            int index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f2226to--;
            this.f2225l.removeLong(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(int index, LongCollection c) {
            ensureIndex(index);
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(int index, LongList l) {
            ensureIndex(index);
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongList$LongRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongList$LongRandomAccessSubList.class */
    public static class LongRandomAccessSubList extends LongSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public LongRandomAccessSubList(LongList l, int from, int to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList.LongSubList, p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public List<Long> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new LongRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
