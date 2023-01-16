package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterators;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBooleanList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBooleanList.class */
public abstract class AbstractBooleanList extends AbstractBooleanCollection implements BooleanList, BooleanStack {
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

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void add(int index, boolean k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean add(boolean k) {
        add(size(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public boolean removeBoolean(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public boolean set(int index, boolean k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends Boolean> c) {
        if (c instanceof BooleanCollection) {
            return addAll(index, (BooleanCollection) c);
        }
        ensureIndex(index);
        Iterator<? extends Boolean> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, ((Boolean) i.next()).booleanValue());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Boolean> c) {
        return addAll(size(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public BooleanListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
    public ListIterator<Boolean> listIterator() {
        return listIterator(0);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
    public ListIterator<Boolean> listIterator(int index) {
        ensureIndex(index);
        return new BooleanIterators.AbstractIndexBasedListIterator(0, index) { // from class: it.unimi.dsi.fastutil.booleans.AbstractBooleanList.1
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator
            protected final boolean get(int i) {
                return AbstractBooleanList.this.getBoolean(i);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedListIterator
            protected final void add(int i, boolean k) {
                AbstractBooleanList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedListIterator
            protected final void set(int i, boolean k) {
                AbstractBooleanList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                AbstractBooleanList.this.removeBoolean(i);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return AbstractBooleanList.this.size();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBooleanList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBooleanList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends BooleanSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final BooleanList f1045l;

        /* access modifiers changed from: package-private */
        public IndexBasedSpliterator(BooleanList l, int pos) {
            super(pos);
            this.f1045l = l;
        }

        IndexBasedSpliterator(BooleanList l, int pos, int maxPos) {
            super(pos, maxPos);
            this.f1045l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final int getMaxPosFromBackingStore() {
            return this.f1045l.size();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
        protected final boolean get(int i) {
            return this.f1045l.getBoolean(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(int pos, int maxPos) {
            return new IndexBasedSpliterator(this.f1045l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean contains(boolean k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(boolean r4) {
        /*
            r3 = this;
            r0 = r3
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator()
            r5 = r0
        L_0x0005:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0021
            r0 = r5
            boolean r0 = r0.nextBoolean()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.indexOf(boolean):int");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int lastIndexOf(boolean r4) {
        /*
            r3 = this;
            r0 = r3
            r1 = r3
            int r1 = r1.size()
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator(r1)
            r5 = r0
        L_0x0009:
            r0 = r5
            boolean r0 = r0.hasPrevious()
            if (r0 == 0) goto L_0x0025
            r0 = r5
            boolean r0 = r0.previousBoolean()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.lastIndexOf(boolean):int");
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void size(int size) {
        int i = size();
        if (size > i) {
            while (true) {
                i++;
                if (i < size) {
                    add(false);
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                i--;
                if (i != size) {
                    removeBoolean(i);
                } else {
                    return;
                }
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
    public List<Boolean> subList(int from, int to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new BooleanRandomAccessSubList(this, from, to) : new BooleanSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterable
    public void forEach(BooleanConsumer action) {
        if (this instanceof RandomAccess) {
            int max = size();
            for (int i = 0; i < max; i++) {
                action.accept(getBoolean(i));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(int r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r5
            r1 = r6
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator(r1)
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
            boolean r0 = r0.nextBoolean()
            r0 = r8
            r0.remove()
            goto L_0x003e
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.removeElements(int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(int r6, boolean[] r7, int r8, int r9) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            r2 = r9
            p014it.unimi.dsi.fastutil.booleans.BooleanArrays.ensureOffsetLength(r0, r1, r2)
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
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.addElements(int, boolean[], int, int):void");
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void addElements(int index, boolean[] a) {
        addElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(int r7, boolean[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.booleans.BooleanArrays.ensureOffsetLength(r0, r1, r2)
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
            boolean r2 = r2.getBoolean(r3)
            r0[r1] = r2
            goto L_0x0050
        L_0x006a:
            goto L_0x008c
        L_0x006d:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator(r1)
            r11 = r0
        L_0x0074:
            r0 = r10
            int r10 = r10 + -1
            if (r0 == 0) goto L_0x008c
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r2 = r11
            boolean r2 = r2.nextBoolean()
            r0[r1] = r2
            goto L_0x0074
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.getElements(int, boolean[], int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(int r7, boolean[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.booleans.BooleanArrays.ensureOffsetLength(r0, r1, r2)
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
            boolean r0 = r0.set(r1, r2)
            int r11 = r11 + 1
            goto L_0x0050
        L_0x006c:
            goto L_0x009b
        L_0x006f:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x0079:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x009b
            r0 = r11
            boolean r0 = r0.nextBoolean()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.setElements(int, boolean[], int, int):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        removeElements(0, size());
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        BooleanIterator i = iterator();
        int h = 1;
        int s = size();
        while (true) {
            s--;
            if (s == 0) {
                return h;
            }
            h = (31 * h) + (i.nextBoolean() ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
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
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.booleans.BooleanList
            if (r0 == 0) goto L_0x005a
            r0 = r3
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r5
            it.unimi.dsi.fastutil.booleans.BooleanList r0 = (p014it.unimi.dsi.fastutil.booleans.BooleanList) r0
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x003e:
            r0 = r6
            int r6 = r6 + -1
            if (r0 == 0) goto L_0x0058
            r0 = r7
            boolean r0 = r0.nextBoolean()
            r1 = r8
            boolean r1 = r1.nextBoolean()
            if (r0 == r1) goto L_0x003e
            r0 = 0
            return r0
        L_0x0058:
            r0 = 1
            return r0
        L_0x005a:
            r0 = r3
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(java.util.List<? extends java.lang.Boolean> r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = r3
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r4
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.booleans.BooleanList
            if (r0 == 0) goto L_0x006b
            r0 = r3
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator()
            r5 = r0
            r0 = r4
            it.unimi.dsi.fastutil.booleans.BooleanList r0 = (p014it.unimi.dsi.fastutil.booleans.BooleanList) r0
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x001d:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r5
            boolean r0 = r0.nextBoolean()
            r8 = r0
            r0 = r6
            boolean r0 = r0.nextBoolean()
            r9 = r0
            r0 = r8
            r1 = r9
            int r0 = java.lang.Boolean.compare(r0, r1)
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
            it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.compareTo(java.util.List):int");
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanStack
    public void push(boolean o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanStack
    public boolean popBoolean() {
        if (!isEmpty()) {
            return removeBoolean(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanStack
    public boolean topBoolean() {
        if (!isEmpty()) {
            return getBoolean(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanStack
    public boolean peekBoolean(int i) {
        return getBoolean((size() - 1) - i);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean rem(boolean k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeBoolean(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean[] toBooleanArray() {
        int size = size();
        boolean[] ret = new boolean[size];
        getElements(0, ret, 0, size);
        return ret;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean[] toArray(boolean[] a) {
        int size = size();
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        getElements(0, a, 0, size);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public boolean addAll(int index, BooleanCollection c) {
        ensureIndex(index);
        BooleanIterator i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, i.nextBoolean());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean addAll(BooleanCollection c) {
        return addAll(size(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        BooleanIterator i = iterator();
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
                s.append(String.valueOf(i.nextBoolean()));
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBooleanList$BooleanSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBooleanList$BooleanSubList.class */
    public static class BooleanSubList extends AbstractBooleanList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final BooleanList f1043l;
        protected final int from;

        /* renamed from: to */
        protected int f1044to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'java.util.ListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator<Boolean> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(List<? extends Boolean> list) {
            return compareTo(list);
        }

        static {
            $assertionsDisabled = !AbstractBooleanList.class.desiredAssertionStatus();
        }

        public BooleanSubList(BooleanList l, int from, int to) {
            this.f1043l = l;
            this.from = from;
            this.f1044to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f1043l.size()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f1044to > this.f1043l.size()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f1044to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean add(boolean k) {
            this.f1043l.add(this.f1044to, k);
            this.f1044to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void add(int index, boolean k) {
            ensureIndex(index);
            this.f1043l.add(this.from + index, k);
            this.f1044to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.util.List
        public boolean addAll(int index, Collection<? extends Boolean> c) {
            ensureIndex(index);
            this.f1044to += c.size();
            return this.f1043l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean getBoolean(int index) {
            ensureRestrictedIndex(index);
            return this.f1043l.getBoolean(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean removeBoolean(int index) {
            ensureRestrictedIndex(index);
            this.f1044to--;
            return this.f1043l.removeBoolean(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean set(int index, boolean k) {
            ensureRestrictedIndex(index);
            return this.f1043l.set(this.from + index, k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1044to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void getElements(int from, boolean[] a, int offset, int length) {
            ensureIndex(from);
            if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size() + ")");
            }
            this.f1043l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void removeElements(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f1043l.removeElements(this.from + from, this.from + to);
            this.f1044to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void addElements(int index, boolean[] a, int offset, int length) {
            ensureIndex(index);
            this.f1043l.addElements(this.from + index, a, offset, length);
            this.f1044to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(int index, boolean[] a, int offset, int length) {
            ensureIndex(index);
            this.f1043l.setElements(this.from + index, a, offset, length);
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBooleanList$BooleanSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBooleanList$BooleanSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends BooleanIterators.AbstractIndexBasedListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractBooleanList.class.desiredAssertionStatus();
            }

            RandomAccessIter(int pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator
            protected final boolean get(int i) {
                return BooleanSubList.this.f1043l.getBoolean(BooleanSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedListIterator
            protected final void add(int i, boolean k) {
                BooleanSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedListIterator
            protected final void set(int i, boolean k) {
                BooleanSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                BooleanSubList.this.removeBoolean(i);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return BooleanSubList.this.f1044to - BooleanSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
            public void add(boolean k) {
                add(k);
                if (!$assertionsDisabled && !BooleanSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator, java.util.Iterator, p014it.unimi.dsi.fastutil.booleans.BooleanListIterator, java.util.ListIterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !BooleanSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBooleanList$BooleanSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBooleanList$BooleanSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements BooleanListIterator {
            private BooleanListIterator parent;

            ParentWrappingIter(BooleanListIterator parent) {
                this.parent = parent;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.parent.nextIndex() - BooleanSubList.this.from;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.parent.previousIndex() - BooleanSubList.this.from;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.parent.nextIndex() < BooleanSubList.this.f1044to;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= BooleanSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            public boolean nextBoolean() {
                if (hasNext()) {
                    return this.parent.nextBoolean();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
            public boolean previousBoolean() {
                if (hasPrevious()) {
                    return this.parent.previousBoolean();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
            public void add(boolean k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
            public void set(boolean k) {
                this.parent.set(k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                this.parent.remove();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.previousIndex();
                int parentNewPos = currentPos - n;
                if (parentNewPos < BooleanSubList.this.from - 1) {
                    parentNewPos = BooleanSubList.this.from - 1;
                }
                return this.parent.back(parentNewPos - currentPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.nextIndex();
                int parentNewPos = currentPos + n;
                if (parentNewPos > BooleanSubList.this.f1044to) {
                    parentNewPos = BooleanSubList.this.f1044to;
                }
                return this.parent.skip(parentNewPos - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public ListIterator<Boolean> listIterator(int index) {
            ensureIndex(index);
            return this.f1043l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f1043l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanSpliterator spliterator() {
            return this.f1043l instanceof RandomAccess ? new IndexBasedSpliterator(this.f1043l, this.from, this.f1044to) : spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public List<Boolean> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new BooleanSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean rem(boolean k) {
            int index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f1044to--;
            this.f1043l.removeBoolean(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(int index, BooleanCollection c) {
            ensureIndex(index);
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(int index, BooleanList l) {
            ensureIndex(index);
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBooleanList$BooleanRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBooleanList$BooleanRandomAccessSubList.class */
    public static class BooleanRandomAccessSubList extends BooleanSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public BooleanRandomAccessSubList(BooleanList l, int from, int to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.BooleanSubList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public List<Boolean> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new BooleanRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
