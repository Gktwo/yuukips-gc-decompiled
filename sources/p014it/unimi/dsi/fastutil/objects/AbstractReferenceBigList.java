package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.Stack;
import p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators;
import p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceBigList.class */
public abstract class AbstractReferenceBigList<K> extends AbstractReferenceCollection<K> implements ReferenceBigList<K>, Stack<K> {
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

    @Override // p014it.unimi.dsi.fastutil.BigList
    public void add(long index, K k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(K k) {
        add(size64(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public K remove(long i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public K set(long index, K k) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: it.unimi.dsi.fastutil.objects.AbstractReferenceBigList<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.BigList
    public boolean addAll(long index, Collection<? extends K> c) {
        ensureIndex(index);
        Iterator<? extends K> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, i.next());
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends K> c) {
        return addAll(size64(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    public ObjectBigListIterator<K> iterator() {
        return listIterator();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBigList, p014it.unimi.dsi.fastutil.BigList
    public ObjectBigListIterator<K> listIterator() {
        return listIterator(0L);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBigList, p014it.unimi.dsi.fastutil.BigList
    public ObjectBigListIterator<K> listIterator(long index) {
        ensureIndex(index);
        return new ObjectBigListIterators.AbstractIndexBasedBigListIterator<K>(0, index) { // from class: it.unimi.dsi.fastutil.objects.AbstractReferenceBigList.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator
            protected final K get(long i) {
                return AbstractReferenceBigList.this.get(i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, K k) {
                AbstractReferenceBigList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, K k) {
                AbstractReferenceBigList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                AbstractReferenceBigList.this.remove(i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return AbstractReferenceBigList.this.size64();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceBigList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceBigList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator<K> extends ObjectBigSpliterators.LateBindingSizeIndexBasedSpliterator<K> {

        /* renamed from: l */
        final ReferenceBigList<K> f2534l;

        IndexBasedSpliterator(ReferenceBigList<K> l, long pos) {
            super(pos);
            this.f2534l = l;
        }

        IndexBasedSpliterator(ReferenceBigList<K> l, long pos, long maxPos) {
            super(pos, maxPos);
            this.f2534l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final long getMaxPosFromBackingStore() {
            return this.f2534l.size64();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators.AbstractIndexBasedSpliterator
        protected final K get(long i) {
            return this.f2534l.get(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator<K> makeForSplit(long pos, long maxPos) {
            return new IndexBasedSpliterator<>(this.f2534l, pos, maxPos);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object k) {
        return indexOf(k) >= 0;
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public long indexOf(Object k) {
        ObjectBigListIterator<K> i = listIterator();
        while (i.hasNext()) {
            if (k == i.next()) {
                return i.previousIndex();
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public long lastIndexOf(Object k) {
        ObjectBigListIterator<K> i = listIterator(size64());
        while (i.hasPrevious()) {
            if (k == i.previous()) {
                return i.nextIndex();
            }
        }
        return -1;
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
                    add(null);
                    i2 = i4;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                char c = i3 - 1;
                if ((i3 == 1 ? 1 : 0) != size) {
                    remove(c);
                    i3 = c;
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBigList, p014it.unimi.dsi.fastutil.BigList
    public ReferenceBigList<K> subList(long from, long to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new ReferenceRandomAccessSubList(this, from, to) : new ReferenceSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    @Override // java.lang.Iterable
    public void forEach(Consumer<? super K> action) {
        if (this instanceof RandomAccess) {
            long max = size64();
            for (char c = 0; c < max; c++) {
                action.accept(get(c));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBigList
    public void removeElements(long from, long to) {
        ensureIndex(to);
        ObjectBigListIterator<K> i = listIterator(from);
        char c = to - from;
        if (c < 0) {
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
        while (true) {
            c--;
            if (c != 0) {
                i.next();
                i.remove();
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, it.unimi.dsi.fastutil.objects.AbstractReferenceBigList<K>] */
    /* JADX WARN: Type inference failed for: r14v0, types: [long, java.lang.Object[][], K[][]] */
    /* JADX WARN: Type inference failed for: r17v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.objects.ObjectBigListIterator] */
    /* JADX WARN: Type inference failed for: r1v4, types: [long] */
    /* JADX WARN: Type inference failed for: r2v3, types: [long, java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r1v10, types: [long] */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(long r12, K[][] r14, long r15, long r17) {
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
            java.lang.Object r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            r0.add(r1, r2)
            goto L_0x0014
        L_0x0037:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.objects.ObjectBigListIterator r0 = r0.listIterator(r1)
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
            java.lang.Object r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.add(r1)
            goto L_0x003e
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList.addElements(long, java.lang.Object[][], long, long):void");
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBigList
    public void addElements(long index, K[][] a) {
        addElements(index, a, 0, BigArrays.length(a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [long, it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, it.unimi.dsi.fastutil.objects.AbstractReferenceBigList<K>] */
    /* JADX WARN: Type inference failed for: r12v0, types: [long] */
    /* JADX WARN: Type inference failed for: r17v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v7, types: [long] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(long r12, java.lang.Object[][] r14, long r15, long r17) {
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
            java.lang.Object r2 = r2.get(r3)
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0052
        L_0x0077:
            goto L_0x00a2
        L_0x007a:
            r0 = r11
            r1 = r12
            it.unimi.dsi.fastutil.objects.ObjectBigListIterator r0 = r0.listIterator(r1)
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
            java.lang.Object r2 = r2.next()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0081
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList.getElements(long, java.lang.Object[][], long, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, it.unimi.dsi.fastutil.objects.AbstractReferenceBigList<K>] */
    /* JADX WARN: Type inference failed for: r15v0, types: [long, java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r0v8, types: [it.unimi.dsi.fastutil.objects.ObjectBigListIterator] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(long r12, K[][] r14, long r15, long r17) {
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
            java.lang.Object r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            java.lang.Object r0 = r0.set(r1, r2)
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
            it.unimi.dsi.fastutil.objects.ObjectBigListIterator r0 = r0.listIterator(r1)
            r19 = r0
            r0 = 0
            r20 = r0
        L_0x0082:
            r0 = r20
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00aa
            r0 = r19
            java.lang.Object r0 = r0.next()
            r0 = r19
            r1 = r14
            r2 = r15
            r3 = r20
            r4 = r3; r1 = r2; 
            r5 = 1
            long r4 = r4 + r5
            r20 = r4
            long r2 = r2 + r3
            java.lang.Object r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r0.set(r1)
            goto L_0x0082
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList.setElements(long, java.lang.Object[][], long, long):void");
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
        ObjectIterator<K> i = iterator();
        int h = 1;
        char size64 = size64();
        while (true) {
            size64--;
            if (size64 == 0) {
                return h;
            }
            h = (31 * h) + System.identityHashCode(i.next());
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    @Override // java.util.Collection, java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BigList)) {
            return false;
        }
        BigList<?> l = (BigList) o;
        char size64 = size64();
        if (size64 != l.size64()) {
            return false;
        }
        BigListIterator<?> i1 = listIterator();
        BigListIterator<?> i2 = l.listIterator();
        do {
            size64--;
            if (size64 == 0) {
                return true;
            }
        } while (i1.next() == i2.next());
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    public void push(K o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    public K pop() {
        if (!isEmpty()) {
            return remove(size64() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    public K top() {
        if (!isEmpty()) {
            return get(size64() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    public K peek(int i) {
        return get((size64() - 1) - ((long) i));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r1v3, types: [long] */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<K> i = iterator();
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
                K k = i.next();
                if (this == k) {
                    s.append("(this big list)");
                } else {
                    s.append(String.valueOf(k));
                }
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceBigList$ReferenceSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceBigList$ReferenceSubList.class */
    public static class ReferenceSubList<K> extends AbstractReferenceBigList<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final ReferenceBigList<K> f2535l;
        protected final long from;

        /* renamed from: to */
        protected long f2536to;
        static final /* synthetic */ boolean $assertionsDisabled;

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.objects.ReferenceBigList, p014it.unimi.dsi.fastutil.BigList
        public /* bridge */ /* synthetic */ BigListIterator listIterator() {
            return listIterator();
        }

        static {
            $assertionsDisabled = !AbstractReferenceBigList.class.desiredAssertionStatus();
        }

        public ReferenceSubList(ReferenceBigList<K> l, long from, long to) {
            this.f2535l = l;
            this.from = from;
            this.f2536to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f2535l.size64()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f2536to > this.f2535l.size64()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f2536to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, java.util.AbstractCollection, java.util.Collection
        public boolean add(K k) {
            this.f2535l.add(this.f2536to, k);
            this.f2536to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.BigList
        public void add(long index, K k) {
            ensureIndex(index);
            this.f2535l.add(this.from + index, k);
            this.f2536to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends K> c) {
            ensureIndex(index);
            this.f2536to += (long) c.size();
            return this.f2535l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public K get(long index) {
            ensureRestrictedIndex(index);
            return this.f2535l.get(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.BigList
        public K remove(long index) {
            ensureRestrictedIndex(index);
            this.f2536to--;
            return this.f2535l.remove(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.BigList
        public K set(long index, K k) {
            ensureRestrictedIndex(index);
            return this.f2535l.set(this.from + index, k);
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return this.f2536to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.objects.ReferenceBigList
        public void getElements(long from, Object[][] a, long offset, long length) {
            ensureIndex(from);
            if (from + length > size64()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size64() + ")");
            }
            this.f2535l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.objects.ReferenceBigList
        public void removeElements(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f2535l.removeElements(this.from + from, this.from + to);
            this.f2536to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.objects.ReferenceBigList
        public void addElements(long index, K[][] a, long offset, long length) {
            ensureIndex(index);
            this.f2535l.addElements(this.from + index, a, offset, length);
            this.f2536to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceBigList$ReferenceSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceBigList$ReferenceSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends ObjectBigListIterators.AbstractIndexBasedBigListIterator<K> {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractReferenceBigList.class.desiredAssertionStatus();
            }

            RandomAccessIter(long pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator
            protected final K get(long i) {
                return ReferenceSubList.this.f2535l.get(ReferenceSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, K k) {
                ReferenceSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, K k) {
                ReferenceSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                ReferenceSubList.this.remove(i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return ReferenceSubList.this.f2536to - ReferenceSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigListIterator, p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator, p014it.unimi.dsi.fastutil.BigListIterator
            public void add(K k) {
                add(k);
                if (!$assertionsDisabled && !ReferenceSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator, java.util.Iterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !ReferenceSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceBigList$ReferenceSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceBigList$ReferenceSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements ObjectBigListIterator<K> {
            private ObjectBigListIterator<K> parent;

            ParentWrappingIter(ObjectBigListIterator<K> parent) {
                this.parent = parent;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.parent.nextIndex() - ReferenceSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.parent.previousIndex() - ReferenceSubList.this.from;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.parent.nextIndex() < ReferenceSubList.this.f2536to;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= ReferenceSubList.this.from;
            }

            @Override // java.util.Iterator
            public K next() {
                if (hasNext()) {
                    return (K) this.parent.next();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public K previous() {
                if (hasPrevious()) {
                    return this.parent.previous();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator, p014it.unimi.dsi.fastutil.BigListIterator
            public void add(K k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator, p014it.unimi.dsi.fastutil.BigListIterator
            public void set(K k) {
                this.parent.set(k);
            }

            @Override // java.util.Iterator
            public void remove() {
                this.parent.remove();
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [long] */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
            public long back(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                long currentPos = this.parent.previousIndex();
                char c = currentPos - n;
                int i = (c > (ReferenceSubList.this.from - 1) ? 1 : (c == (ReferenceSubList.this.from - 1) ? 0 : -1));
                long parentNewPos = c;
                if (i < 0) {
                    parentNewPos = ReferenceSubList.this.from - 1;
                }
                return this.parent.back((parentNewPos == 1 ? 1 : 0) - currentPos);
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [long] */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
            public long skip(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                long currentPos = this.parent.nextIndex();
                char c = currentPos + n;
                int i = (c > ReferenceSubList.this.f2536to ? 1 : (c == ReferenceSubList.this.f2536to ? 0 : -1));
                long parentNewPos = c;
                if (i > 0) {
                    parentNewPos = ReferenceSubList.this.f2536to;
                }
                return this.parent.skip((parentNewPos == 1 ? 1 : 0) - currentPos);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.objects.ReferenceBigList, p014it.unimi.dsi.fastutil.BigList
        public ObjectBigListIterator<K> listIterator(long index) {
            ensureIndex(index);
            return this.f2535l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f2535l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return this.f2535l instanceof RandomAccess ? new IndexBasedSpliterator(this.f2535l, this.from, this.f2536to) : spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.objects.ReferenceBigList, p014it.unimi.dsi.fastutil.BigList
        public ReferenceBigList<K> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new ReferenceSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceBigList$ReferenceRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceBigList$ReferenceRandomAccessSubList.class */
    public static class ReferenceRandomAccessSubList<K> extends ReferenceSubList<K> implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public ReferenceRandomAccessSubList(ReferenceBigList<K> l, long from, long to) {
            super(l, from, to);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList.ReferenceSubList, p014it.unimi.dsi.fastutil.objects.AbstractReferenceBigList, p014it.unimi.dsi.fastutil.objects.ReferenceBigList, p014it.unimi.dsi.fastutil.BigList
        public ReferenceBigList<K> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new ReferenceRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
