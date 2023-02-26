package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.floats.FloatIterators;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloatList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloatList.class */
public abstract class AbstractFloatList extends AbstractFloatCollection implements FloatList, FloatStack {
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

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public void add(int index, float k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean add(float k) {
        add(size(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public float removeFloat(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public float set(int index, float k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends Float> c) {
        if (c instanceof FloatCollection) {
            return addAll(index, (FloatCollection) c);
        }
        ensureIndex(index);
        Iterator<? extends Float> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, ((Float) i.next()).floatValue());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Float> c) {
        return addAll(size(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
    public ListIterator<Float> listIterator() {
        return listIterator(0);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
    public ListIterator<Float> listIterator(int index) {
        ensureIndex(index);
        return new FloatIterators.AbstractIndexBasedListIterator(0, index) { // from class: it.unimi.dsi.fastutil.floats.AbstractFloatList.1
            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator
            protected final float get(int i) {
                return AbstractFloatList.this.getFloat(i);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedListIterator
            protected final void add(int i, float k) {
                AbstractFloatList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedListIterator
            protected final void set(int i, float k) {
                AbstractFloatList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                AbstractFloatList.this.removeFloat(i);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return AbstractFloatList.this.size();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloatList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloatList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends FloatSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final FloatList f1763l;

        /* access modifiers changed from: package-private */
        public IndexBasedSpliterator(FloatList l, int pos) {
            super(pos);
            this.f1763l = l;
        }

        IndexBasedSpliterator(FloatList l, int pos, int maxPos) {
            super(pos, maxPos);
            this.f1763l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final int getMaxPosFromBackingStore() {
            return this.f1763l.size();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
        protected final float get(int i) {
            return this.f1763l.getFloat(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(int pos, int maxPos) {
            return new IndexBasedSpliterator(this.f1763l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean contains(float k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(float r4) {
        /*
            r3 = this;
            r0 = r3
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator()
            r5 = r0
        L_0x0005:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0027
            r0 = r5
            float r0 = r0.nextFloat()
            r6 = r0
            r0 = r4
            int r0 = java.lang.Float.floatToIntBits(r0)
            r1 = r6
            int r1 = java.lang.Float.floatToIntBits(r1)
            if (r0 != r1) goto L_0x0005
            r0 = r5
            int r0 = r0.previousIndex()
            return r0
        L_0x0027:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.AbstractFloatList.indexOf(float):int");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int lastIndexOf(float r4) {
        /*
            r3 = this;
            r0 = r3
            r1 = r3
            int r1 = r1.size()
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator(r1)
            r5 = r0
        L_0x0009:
            r0 = r5
            boolean r0 = r0.hasPrevious()
            if (r0 == 0) goto L_0x002b
            r0 = r5
            float r0 = r0.previousFloat()
            r6 = r0
            r0 = r4
            int r0 = java.lang.Float.floatToIntBits(r0)
            r1 = r6
            int r1 = java.lang.Float.floatToIntBits(r1)
            if (r0 != r1) goto L_0x0009
            r0 = r5
            int r0 = r0.nextIndex()
            return r0
        L_0x002b:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.AbstractFloatList.lastIndexOf(float):int");
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public void size(int size) {
        int i = size();
        if (size > i) {
            while (true) {
                i++;
                if (i < size) {
                    add(0.0f);
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                i--;
                if (i != size) {
                    removeFloat(i);
                } else {
                    return;
                }
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
    public List<Float> subList(int from, int to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new FloatRandomAccessSubList(this, from, to) : new FloatSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
    public void forEach(FloatConsumer action) {
        if (this instanceof RandomAccess) {
            int max = size();
            for (int i = 0; i < max; i++) {
                action.accept(getFloat(i));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(int r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r5
            r1 = r6
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator(r1)
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
            float r0 = r0.nextFloat()
            r0 = r8
            r0.remove()
            goto L_0x003e
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.AbstractFloatList.removeElements(int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(int r6, float[] r7, int r8, int r9) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            r2 = r9
            p014it.unimi.dsi.fastutil.floats.FloatArrays.ensureOffsetLength(r0, r1, r2)
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
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.AbstractFloatList.addElements(int, float[], int, int):void");
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public void addElements(int index, float[] a) {
        addElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(int r7, float[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.floats.FloatArrays.ensureOffsetLength(r0, r1, r2)
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
            float r2 = r2.getFloat(r3)
            r0[r1] = r2
            goto L_0x0050
        L_0x006a:
            goto L_0x008c
        L_0x006d:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator(r1)
            r11 = r0
        L_0x0074:
            r0 = r10
            int r10 = r10 + -1
            if (r0 == 0) goto L_0x008c
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r2 = r11
            float r2 = r2.nextFloat()
            r0[r1] = r2
            goto L_0x0074
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.AbstractFloatList.getElements(int, float[], int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(int r7, float[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.floats.FloatArrays.ensureOffsetLength(r0, r1, r2)
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
            float r0 = r0.set(r1, r2)
            int r11 = r11 + 1
            goto L_0x0050
        L_0x006c:
            goto L_0x009b
        L_0x006f:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x0079:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x009b
            r0 = r11
            float r0 = r0.nextFloat()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.AbstractFloatList.setElements(int, float[], int, int):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        removeElements(0, size());
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        FloatIterator i = iterator();
        int h = 1;
        int s = size();
        while (true) {
            s--;
            if (s == 0) {
                return h;
            }
            h = (31 * h) + HashCommon.float2int(i.nextFloat());
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
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
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.floats.FloatList
            if (r0 == 0) goto L_0x005b
            r0 = r3
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r5
            it.unimi.dsi.fastutil.floats.FloatList r0 = (p014it.unimi.dsi.fastutil.floats.FloatList) r0
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x003e:
            r0 = r6
            int r6 = r6 + -1
            if (r0 == 0) goto L_0x0059
            r0 = r7
            float r0 = r0.nextFloat()
            r1 = r8
            float r1 = r1.nextFloat()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003e
            r0 = 0
            return r0
        L_0x0059:
            r0 = 1
            return r0
        L_0x005b:
            r0 = r3
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r5
            java.util.ListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x0069:
            r0 = r6
            int r6 = r6 + -1
            if (r0 == 0) goto L_0x0086
            r0 = r7
            java.lang.Object r0 = r0.next()
            r1 = r8
            java.lang.Object r1 = r1.next()
            boolean r0 = java.util.Objects.equals(r0, r1)
            if (r0 != 0) goto L_0x0069
            r0 = 0
            return r0
        L_0x0086:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.AbstractFloatList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(java.util.List<? extends java.lang.Float> r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = r3
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r4
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.floats.FloatList
            if (r0 == 0) goto L_0x006b
            r0 = r3
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator()
            r5 = r0
            r0 = r4
            it.unimi.dsi.fastutil.floats.FloatList r0 = (p014it.unimi.dsi.fastutil.floats.FloatList) r0
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x001d:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r5
            float r0 = r0.nextFloat()
            r8 = r0
            r0 = r6
            float r0 = r0.nextFloat()
            r9 = r0
            r0 = r8
            r1 = r9
            int r0 = java.lang.Float.compare(r0, r1)
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
            it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.AbstractFloatList.compareTo(java.util.List):int");
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatStack
    public void push(float o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatStack
    public float popFloat() {
        if (!isEmpty()) {
            return removeFloat(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatStack
    public float topFloat() {
        if (!isEmpty()) {
            return getFloat(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatStack
    public float peekFloat(int i) {
        return getFloat((size() - 1) - i);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean rem(float k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeFloat(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public float[] toFloatArray() {
        int size = size();
        float[] ret = new float[size];
        getElements(0, ret, 0, size);
        return ret;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public float[] toArray(float[] a) {
        int size = size();
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        getElements(0, a, 0, size);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public boolean addAll(int index, FloatCollection c) {
        ensureIndex(index);
        FloatIterator i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, i.nextFloat());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean addAll(FloatCollection c) {
        return addAll(size(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        FloatIterator i = iterator();
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
                s.append(String.valueOf(i.nextFloat()));
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloatList$FloatSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloatList$FloatSubList.class */
    public static class FloatSubList extends AbstractFloatList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final FloatList f1761l;
        protected final int from;

        /* renamed from: to */
        protected int f1762to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'java.util.ListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator<Float> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(List<? extends Float> list) {
            return compareTo(list);
        }

        static {
            $assertionsDisabled = !AbstractFloatList.class.desiredAssertionStatus();
        }

        public FloatSubList(FloatList l, int from, int to) {
            this.f1761l = l;
            this.from = from;
            this.f1762to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f1761l.size()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f1762to > this.f1761l.size()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f1762to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean add(float k) {
            this.f1761l.add(this.f1762to, k);
            this.f1762to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void add(int index, float k) {
            ensureIndex(index);
            this.f1761l.add(this.from + index, k);
            this.f1762to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.util.List
        public boolean addAll(int index, Collection<? extends Float> c) {
            ensureIndex(index);
            this.f1762to += c.size();
            return this.f1761l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float getFloat(int index) {
            ensureRestrictedIndex(index);
            return this.f1761l.getFloat(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public float removeFloat(int index) {
            ensureRestrictedIndex(index);
            this.f1762to--;
            return this.f1761l.removeFloat(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public float set(int index, float k) {
            ensureRestrictedIndex(index);
            return this.f1761l.set(this.from + index, k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1762to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void getElements(int from, float[] a, int offset, int length) {
            ensureIndex(from);
            if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size() + ")");
            }
            this.f1761l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void removeElements(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f1761l.removeElements(this.from + from, this.from + to);
            this.f1762to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void addElements(int index, float[] a, int offset, int length) {
            ensureIndex(index);
            this.f1761l.addElements(this.from + index, a, offset, length);
            this.f1762to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(int index, float[] a, int offset, int length) {
            ensureIndex(index);
            this.f1761l.setElements(this.from + index, a, offset, length);
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloatList$FloatSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloatList$FloatSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends FloatIterators.AbstractIndexBasedListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractFloatList.class.desiredAssertionStatus();
            }

            RandomAccessIter(int pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator
            protected final float get(int i) {
                return FloatSubList.this.f1761l.getFloat(FloatSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedListIterator
            protected final void add(int i, float k) {
                FloatSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedListIterator
            protected final void set(int i, float k) {
                FloatSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                FloatSubList.this.removeFloat(i);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return FloatSubList.this.f1762to - FloatSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.floats.FloatListIterator
            public void add(float k) {
                add(k);
                if (!$assertionsDisabled && !FloatSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator, java.util.Iterator, p014it.unimi.dsi.fastutil.floats.FloatListIterator, java.util.ListIterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !FloatSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloatList$FloatSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloatList$FloatSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements FloatListIterator {
            private FloatListIterator parent;

            ParentWrappingIter(FloatListIterator parent) {
                this.parent = parent;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.parent.nextIndex() - FloatSubList.this.from;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.parent.previousIndex() - FloatSubList.this.from;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.parent.nextIndex() < FloatSubList.this.f1762to;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= FloatSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
            public float nextFloat() {
                if (hasNext()) {
                    return this.parent.nextFloat();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
            public float previousFloat() {
                if (hasPrevious()) {
                    return this.parent.previousFloat();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
            public void add(float k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
            public void set(float k) {
                this.parent.set(k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                this.parent.remove();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.previousIndex();
                int parentNewPos = currentPos - n;
                if (parentNewPos < FloatSubList.this.from - 1) {
                    parentNewPos = FloatSubList.this.from - 1;
                }
                return this.parent.back(parentNewPos - currentPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.nextIndex();
                int parentNewPos = currentPos + n;
                if (parentNewPos > FloatSubList.this.f1762to) {
                    parentNewPos = FloatSubList.this.f1762to;
                }
                return this.parent.skip(parentNewPos - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public ListIterator<Float> listIterator(int index) {
            ensureIndex(index);
            return this.f1761l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f1761l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return this.f1761l instanceof RandomAccess ? new IndexBasedSpliterator(this.f1761l, this.from, this.f1762to) : spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public List<Float> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new FloatSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean rem(float k) {
            int index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f1762to--;
            this.f1761l.removeFloat(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(int index, FloatCollection c) {
            ensureIndex(index);
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(int index, FloatList l) {
            ensureIndex(index);
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloatList$FloatRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloatList$FloatRandomAccessSubList.class */
    public static class FloatRandomAccessSubList extends FloatSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public FloatRandomAccessSubList(FloatList l, int from, int to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList.FloatSubList, p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public List<Float> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new FloatRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
