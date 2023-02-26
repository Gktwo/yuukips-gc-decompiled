package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.bytes.ByteIterators;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByteList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByteList.class */
public abstract class AbstractByteList extends AbstractByteCollection implements ByteList, ByteStack {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public void add(int index, byte k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean add(byte k) {
        add(size(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public byte removeByte(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public byte set(int index, byte k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends Byte> c) {
        if (c instanceof ByteCollection) {
            return addAll(index, (ByteCollection) c);
        }
        ensureIndex(index);
        Iterator<? extends Byte> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, ((Byte) i.next()).byteValue());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Byte> c) {
        return addAll(size(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    public ByteListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
    public ListIterator<Byte> listIterator() {
        return listIterator(0);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
    public ListIterator<Byte> listIterator(int index) {
        ensureIndex(index);
        return new ByteIterators.AbstractIndexBasedListIterator(0, index) { // from class: it.unimi.dsi.fastutil.bytes.AbstractByteList.1
            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator
            protected final byte get(int i) {
                return AbstractByteList.this.getByte(i);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedListIterator
            protected final void add(int i, byte k) {
                AbstractByteList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedListIterator
            protected final void set(int i, byte k) {
                AbstractByteList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                AbstractByteList.this.removeByte(i);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return AbstractByteList.this.size();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByteList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByteList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends ByteSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final ByteList f1088l;

        /* access modifiers changed from: package-private */
        public IndexBasedSpliterator(ByteList l, int pos) {
            super(pos);
            this.f1088l = l;
        }

        IndexBasedSpliterator(ByteList l, int pos, int maxPos) {
            super(pos, maxPos);
            this.f1088l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final int getMaxPosFromBackingStore() {
            return this.f1088l.size();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
        protected final byte get(int i) {
            return this.f1088l.getByte(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(int pos, int maxPos) {
            return new IndexBasedSpliterator(this.f1088l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean contains(byte k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(byte r4) {
        /*
            r3 = this;
            r0 = r3
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator()
            r5 = r0
        L_0x0005:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0021
            r0 = r5
            byte r0 = r0.nextByte()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.AbstractByteList.indexOf(byte):int");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int lastIndexOf(byte r4) {
        /*
            r3 = this;
            r0 = r3
            r1 = r3
            int r1 = r1.size()
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator(r1)
            r5 = r0
        L_0x0009:
            r0 = r5
            boolean r0 = r0.hasPrevious()
            if (r0 == 0) goto L_0x0025
            r0 = r5
            byte r0 = r0.previousByte()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.AbstractByteList.lastIndexOf(byte):int");
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public void size(int size) {
        int i = size();
        if (size > i) {
            while (true) {
                i++;
                if (i < size) {
                    add((byte) 0);
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                i--;
                if (i != size) {
                    removeByte(i);
                } else {
                    return;
                }
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
    public List<Byte> subList(int from, int to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new ByteRandomAccessSubList(this, from, to) : new ByteSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
    public void forEach(ByteConsumer action) {
        if (this instanceof RandomAccess) {
            int max = size();
            for (int i = 0; i < max; i++) {
                action.accept(getByte(i));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(int r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r5
            r1 = r6
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator(r1)
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
            byte r0 = r0.nextByte()
            r0 = r8
            r0.remove()
            goto L_0x003e
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.AbstractByteList.removeElements(int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(int r6, byte[] r7, int r8, int r9) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            r2 = r9
            p014it.unimi.dsi.fastutil.bytes.ByteArrays.ensureOffsetLength(r0, r1, r2)
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
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.AbstractByteList.addElements(int, byte[], int, int):void");
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public void addElements(int index, byte[] a) {
        addElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(int r7, byte[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.bytes.ByteArrays.ensureOffsetLength(r0, r1, r2)
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
            byte r2 = r2.getByte(r3)
            r0[r1] = r2
            goto L_0x0050
        L_0x006a:
            goto L_0x008c
        L_0x006d:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator(r1)
            r11 = r0
        L_0x0074:
            r0 = r10
            int r10 = r10 + -1
            if (r0 == 0) goto L_0x008c
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r2 = r11
            byte r2 = r2.nextByte()
            r0[r1] = r2
            goto L_0x0074
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.AbstractByteList.getElements(int, byte[], int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(int r7, byte[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.bytes.ByteArrays.ensureOffsetLength(r0, r1, r2)
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
            byte r0 = r0.set(r1, r2)
            int r11 = r11 + 1
            goto L_0x0050
        L_0x006c:
            goto L_0x009b
        L_0x006f:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x0079:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x009b
            r0 = r11
            byte r0 = r0.nextByte()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.AbstractByteList.setElements(int, byte[], int, int):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        removeElements(0, size());
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        ByteIterator i = iterator();
        int h = 1;
        int s = size();
        while (true) {
            s--;
            if (s == 0) {
                return h;
            }
            h = (31 * h) + i.nextByte();
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
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
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.bytes.ByteList
            if (r0 == 0) goto L_0x005a
            r0 = r3
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r5
            it.unimi.dsi.fastutil.bytes.ByteList r0 = (p014it.unimi.dsi.fastutil.bytes.ByteList) r0
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x003e:
            r0 = r6
            int r6 = r6 + -1
            if (r0 == 0) goto L_0x0058
            r0 = r7
            byte r0 = r0.nextByte()
            r1 = r8
            byte r1 = r1.nextByte()
            if (r0 == r1) goto L_0x003e
            r0 = 0
            return r0
        L_0x0058:
            r0 = 1
            return r0
        L_0x005a:
            r0 = r3
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.AbstractByteList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(java.util.List<? extends java.lang.Byte> r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = r3
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r4
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.bytes.ByteList
            if (r0 == 0) goto L_0x006b
            r0 = r3
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator()
            r5 = r0
            r0 = r4
            it.unimi.dsi.fastutil.bytes.ByteList r0 = (p014it.unimi.dsi.fastutil.bytes.ByteList) r0
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x001d:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r5
            byte r0 = r0.nextByte()
            r8 = r0
            r0 = r6
            byte r0 = r0.nextByte()
            r9 = r0
            r0 = r8
            r1 = r9
            int r0 = java.lang.Byte.compare(r0, r1)
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
            it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator()
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.AbstractByteList.compareTo(java.util.List):int");
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteStack
    public void push(byte o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteStack
    public byte popByte() {
        if (!isEmpty()) {
            return removeByte(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteStack
    public byte topByte() {
        if (!isEmpty()) {
            return getByte(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteStack
    public byte peekByte(int i) {
        return getByte((size() - 1) - i);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean rem(byte k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeByte(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public byte[] toByteArray() {
        int size = size();
        byte[] ret = new byte[size];
        getElements(0, ret, 0, size);
        return ret;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public byte[] toArray(byte[] a) {
        int size = size();
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        getElements(0, a, 0, size);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public boolean addAll(int index, ByteCollection c) {
        ensureIndex(index);
        ByteIterator i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, i.nextByte());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean addAll(ByteCollection c) {
        return addAll(size(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ByteIterator i = iterator();
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
                s.append(String.valueOf((int) i.nextByte()));
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByteList$ByteSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByteList$ByteSubList.class */
    public static class ByteSubList extends AbstractByteList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final ByteList f1086l;
        protected final int from;

        /* renamed from: to */
        protected int f1087to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'java.util.ListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator<Byte> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(List<? extends Byte> list) {
            return compareTo(list);
        }

        static {
            $assertionsDisabled = !AbstractByteList.class.desiredAssertionStatus();
        }

        public ByteSubList(ByteList l, int from, int to) {
            this.f1086l = l;
            this.from = from;
            this.f1087to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f1086l.size()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f1087to > this.f1086l.size()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f1087to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean add(byte k) {
            this.f1086l.add(this.f1087to, k);
            this.f1087to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void add(int index, byte k) {
            ensureIndex(index);
            this.f1086l.add(this.from + index, k);
            this.f1087to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, java.util.List
        public boolean addAll(int index, Collection<? extends Byte> c) {
            ensureIndex(index);
            this.f1087to += c.size();
            return this.f1086l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte getByte(int index) {
            ensureRestrictedIndex(index);
            return this.f1086l.getByte(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte removeByte(int index) {
            ensureRestrictedIndex(index);
            this.f1087to--;
            return this.f1086l.removeByte(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte set(int index, byte k) {
            ensureRestrictedIndex(index);
            return this.f1086l.set(this.from + index, k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1087to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void getElements(int from, byte[] a, int offset, int length) {
            ensureIndex(from);
            if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size() + ")");
            }
            this.f1086l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void removeElements(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f1086l.removeElements(this.from + from, this.from + to);
            this.f1087to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void addElements(int index, byte[] a, int offset, int length) {
            ensureIndex(index);
            this.f1086l.addElements(this.from + index, a, offset, length);
            this.f1087to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(int index, byte[] a, int offset, int length) {
            ensureIndex(index);
            this.f1086l.setElements(this.from + index, a, offset, length);
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByteList$ByteSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByteList$ByteSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends ByteIterators.AbstractIndexBasedListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractByteList.class.desiredAssertionStatus();
            }

            RandomAccessIter(int pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator
            protected final byte get(int i) {
                return ByteSubList.this.f1086l.getByte(ByteSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedListIterator
            protected final void add(int i, byte k) {
                ByteSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedListIterator
            protected final void set(int i, byte k) {
                ByteSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                ByteSubList.this.removeByte(i);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return ByteSubList.this.f1087to - ByteSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.bytes.ByteListIterator
            public void add(byte k) {
                add(k);
                if (!$assertionsDisabled && !ByteSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator, java.util.Iterator, p014it.unimi.dsi.fastutil.bytes.ByteListIterator, java.util.ListIterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !ByteSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByteList$ByteSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByteList$ByteSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements ByteListIterator {
            private ByteListIterator parent;

            ParentWrappingIter(ByteListIterator parent) {
                this.parent = parent;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.parent.nextIndex() - ByteSubList.this.from;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.parent.previousIndex() - ByteSubList.this.from;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.parent.nextIndex() < ByteSubList.this.f1087to;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= ByteSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
            public byte nextByte() {
                if (hasNext()) {
                    return this.parent.nextByte();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
            public byte previousByte() {
                if (hasPrevious()) {
                    return this.parent.previousByte();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
            public void add(byte k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
            public void set(byte k) {
                this.parent.set(k);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                this.parent.remove();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.previousIndex();
                int parentNewPos = currentPos - n;
                if (parentNewPos < ByteSubList.this.from - 1) {
                    parentNewPos = ByteSubList.this.from - 1;
                }
                return this.parent.back(parentNewPos - currentPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.nextIndex();
                int parentNewPos = currentPos + n;
                if (parentNewPos > ByteSubList.this.f1087to) {
                    parentNewPos = ByteSubList.this.f1087to;
                }
                return this.parent.skip(parentNewPos - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public ListIterator<Byte> listIterator(int index) {
            ensureIndex(index);
            return this.f1086l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f1086l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return this.f1086l instanceof RandomAccess ? new IndexBasedSpliterator(this.f1086l, this.from, this.f1087to) : spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public List<Byte> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new ByteSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean rem(byte k) {
            int index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f1087to--;
            this.f1086l.removeByte(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(int index, ByteCollection c) {
            ensureIndex(index);
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(int index, ByteList l) {
            ensureIndex(index);
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByteList$ByteRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByteList$ByteRandomAccessSubList.class */
    public static class ByteRandomAccessSubList extends ByteSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public ByteRandomAccessSubList(ByteList l, int from, int to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList.ByteSubList, p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public List<Byte> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new ByteRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
