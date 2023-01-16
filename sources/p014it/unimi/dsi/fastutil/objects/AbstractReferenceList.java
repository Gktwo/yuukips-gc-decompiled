package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.Stack;
import p014it.unimi.dsi.fastutil.objects.ObjectIterators;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceList.class */
public abstract class AbstractReferenceList<K> extends AbstractReferenceCollection<K> implements ReferenceList<K>, Stack<K> {
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

    @Override // java.util.List
    public void add(int index, K k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(K k) {
        add(size(), k);
        return true;
    }

    @Override // java.util.List
    public K remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public K set(int index, K k) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.AbstractReferenceList<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends K> c) {
        ensureIndex(index);
        Iterator<? extends K> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, i.next());
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends K> c) {
        return addAll(size(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    public ObjectListIterator<K> iterator() {
        return listIterator();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
    public ObjectListIterator<K> listIterator() {
        return listIterator(0);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
    public ObjectListIterator<K> listIterator(int index) {
        ensureIndex(index);
        return new ObjectIterators.AbstractIndexBasedListIterator<K>(0, index) { // from class: it.unimi.dsi.fastutil.objects.AbstractReferenceList.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator
            protected final K get(int i) {
                return (K) AbstractReferenceList.this.get(i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedListIterator
            protected final void add(int i, K k) {
                AbstractReferenceList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedListIterator
            protected final void set(int i, K k) {
                AbstractReferenceList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                AbstractReferenceList.this.remove(i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return AbstractReferenceList.this.size();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator<K> extends ObjectSpliterators.LateBindingSizeIndexBasedSpliterator<K> {

        /* renamed from: l */
        final ReferenceList<K> f2537l;

        /* access modifiers changed from: package-private */
        public IndexBasedSpliterator(ReferenceList<K> l, int pos) {
            super(pos);
            this.f2537l = l;
        }

        IndexBasedSpliterator(ReferenceList<K> l, int pos, int maxPos) {
            super(pos, maxPos);
            this.f2537l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final int getMaxPosFromBackingStore() {
            return this.f2537l.size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
        protected final K get(int i) {
            return this.f2537l.get(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator<K> makeForSplit(int pos, int maxPos) {
            return new IndexBasedSpliterator<>(this.f2537l, pos, maxPos);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object k) {
        return indexOf(k) >= 0;
    }

    @Override // java.util.List
    public int indexOf(Object k) {
        ObjectListIterator<K> i = listIterator();
        while (i.hasNext()) {
            if (k == i.next()) {
                return i.previousIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object k) {
        ObjectListIterator<K> i = listIterator(size());
        while (i.hasPrevious()) {
            if (k == i.previous()) {
                return i.nextIndex();
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
    public void size(int size) {
        int i = size();
        if (size > i) {
            while (true) {
                i++;
                if (i < size) {
                    add(null);
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                i--;
                if (i != size) {
                    remove(i);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
    public ReferenceList<K> subList(int from, int to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new ReferenceRandomAccessSubList(this, from, to) : new ReferenceSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super K> action) {
        if (this instanceof RandomAccess) {
            int max = size();
            for (int i = 0; i < max; i++) {
                action.accept((Object) get(i));
            }
            return;
        }
        forEach(action);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
    public void removeElements(int from, int to) {
        ensureIndex(to);
        ObjectListIterator<K> i = listIterator(from);
        int n = to - from;
        if (n < 0) {
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
        while (true) {
            n--;
            if (n != 0) {
                i.next();
                i.remove();
            } else {
                return;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
    public void addElements(int index, K[] a, int offset, int length) {
        ensureIndex(index);
        ObjectArrays.ensureOffsetLength(a, offset, length);
        if (this instanceof RandomAccess) {
            while (true) {
                length--;
                if (length != 0) {
                    index++;
                    offset++;
                    add(index, a[offset]);
                } else {
                    return;
                }
            }
        } else {
            ObjectListIterator<K> iter = listIterator(index);
            while (true) {
                length--;
                if (length != 0) {
                    offset++;
                    iter.add(a[offset]);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
    public void addElements(int index, K[] a) {
        addElements(index, a, 0, a.length);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
    public void getElements(int from, Object[] a, int offset, int length) {
        ensureIndex(from);
        ObjectArrays.ensureOffsetLength(a, offset, length);
        if (from + length > size()) {
            throw new IndexOutOfBoundsException("End index (" + (from + length) + ") is greater than list size (" + size() + ")");
        } else if (this instanceof RandomAccess) {
            int current = from;
            while (true) {
                length--;
                if (length != 0) {
                    offset++;
                    current++;
                    a[offset] = get(current);
                } else {
                    return;
                }
            }
        } else {
            ObjectListIterator<K> i = listIterator(from);
            while (true) {
                length--;
                if (length != 0) {
                    offset++;
                    a[offset] = i.next();
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
    public void setElements(int index, K[] a, int offset, int length) {
        ensureIndex(index);
        ObjectArrays.ensureOffsetLength(a, offset, length);
        if (index + length > size()) {
            throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + size() + ")");
        } else if (this instanceof RandomAccess) {
            for (int i = 0; i < length; i++) {
                set(i + index, a[i + offset]);
            }
        } else {
            ObjectListIterator<K> iter = listIterator(index);
            int i2 = 0;
            while (i2 < length) {
                iter.next();
                i2++;
                iter.set(a[offset + i2]);
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        removeElements(0, size());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        int size = size();
        Object[] ret = new Object[size];
        getElements(0, ret, 0, size);
        return ret;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] a) {
        int size = size();
        if (a.length < size) {
            a = (T[]) Arrays.copyOf(a, size);
        }
        getElements(0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        ObjectIterator<K> i = iterator();
        int h = 1;
        int s = size();
        while (true) {
            s--;
            if (s == 0) {
                return h;
            }
            h = (31 * h) + System.identityHashCode(i.next());
        }
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof List)) {
            return false;
        }
        List<?> l = (List) o;
        int s = size();
        if (s != l.size()) {
            return false;
        }
        ListIterator<?> i1 = listIterator();
        ListIterator<?> i2 = l.listIterator();
        do {
            s--;
            if (s == 0) {
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
            return remove(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    public K top() {
        if (!isEmpty()) {
            return (K) get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    public K peek(int i) {
        return (K) get((size() - 1) - i);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<K> i = iterator();
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
                K k = i.next();
                if (this == k) {
                    s.append("(this list)");
                } else {
                    s.append(String.valueOf(k));
                }
            } else {
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceList$ReferenceSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceList$ReferenceSubList.class */
    public static class ReferenceSubList<K> extends AbstractReferenceList<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final ReferenceList<K> f2538l;
        protected final int from;

        /* renamed from: to */
        protected int f2539to;
        static final /* synthetic */ boolean $assertionsDisabled;

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return listIterator();
        }

        static {
            $assertionsDisabled = !AbstractReferenceList.class.desiredAssertionStatus();
        }

        public ReferenceSubList(ReferenceList<K> l, int from, int to) {
            this.f2538l = l;
            this.from = from;
            this.f2539to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f2538l.size()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f2539to > this.f2538l.size()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f2539to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(K k) {
            this.f2538l.add(this.f2539to, k);
            this.f2539to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        public void add(int index, K k) {
            ensureIndex(index);
            this.f2538l.add(this.from + index, k);
            this.f2539to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        public boolean addAll(int index, Collection<? extends K> c) {
            ensureIndex(index);
            this.f2539to += c.size();
            return this.f2538l.addAll(this.from + index, c);
        }

        @Override // java.util.List
        public K get(int index) {
            ensureRestrictedIndex(index);
            return this.f2538l.get(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        public K remove(int index) {
            ensureRestrictedIndex(index);
            this.f2539to--;
            return this.f2538l.remove(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        public K set(int index, K k) {
            ensureRestrictedIndex(index);
            return this.f2538l.set(this.from + index, k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f2539to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void getElements(int from, Object[] a, int offset, int length) {
            ensureIndex(from);
            if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size() + ")");
            }
            this.f2538l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void removeElements(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f2538l.removeElements(this.from + from, this.from + to);
            this.f2539to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void addElements(int index, K[] a, int offset, int length) {
            ensureIndex(index);
            this.f2538l.addElements(this.from + index, a, offset, length);
            this.f2539to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(int index, K[] a, int offset, int length) {
            ensureIndex(index);
            this.f2538l.setElements(this.from + index, a, offset, length);
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceList$ReferenceSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceList$ReferenceSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends ObjectIterators.AbstractIndexBasedListIterator<K> {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractReferenceList.class.desiredAssertionStatus();
            }

            RandomAccessIter(int pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator
            protected final K get(int i) {
                return ReferenceSubList.this.f2538l.get(ReferenceSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedListIterator
            protected final void add(int i, K k) {
                ReferenceSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedListIterator
            protected final void set(int i, K k) {
                ReferenceSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                ReferenceSubList.this.remove(i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return ReferenceSubList.this.f2539to - ReferenceSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
            public void add(K k) {
                add(k);
                if (!$assertionsDisabled && !ReferenceSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator, java.util.Iterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !ReferenceSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceList$ReferenceSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceList$ReferenceSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements ObjectListIterator<K> {
            private ObjectListIterator<K> parent;

            ParentWrappingIter(ObjectListIterator<K> parent) {
                this.parent = parent;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.parent.nextIndex() - ReferenceSubList.this.from;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.parent.previousIndex() - ReferenceSubList.this.from;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.parent.nextIndex() < ReferenceSubList.this.f2539to;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= ReferenceSubList.this.from;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public K next() {
                if (hasNext()) {
                    return this.parent.next();
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

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
            public void add(K k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
            public void set(K k) {
                this.parent.set(k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                this.parent.remove();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.previousIndex();
                int parentNewPos = currentPos - n;
                if (parentNewPos < ReferenceSubList.this.from - 1) {
                    parentNewPos = ReferenceSubList.this.from - 1;
                }
                return this.parent.back(parentNewPos - currentPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.nextIndex();
                int parentNewPos = currentPos + n;
                if (parentNewPos > ReferenceSubList.this.f2539to) {
                    parentNewPos = ReferenceSubList.this.f2539to;
                }
                return this.parent.skip(parentNewPos - currentPos);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ObjectListIterator<K> listIterator(int index) {
            ensureIndex(index);
            return this.f2538l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f2538l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return this.f2538l instanceof RandomAccess ? new IndexBasedSpliterator(this.f2538l, this.from, this.f2539to) : spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ReferenceList<K> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new ReferenceSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceList$ReferenceRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceList$ReferenceRandomAccessSubList.class */
    public static class ReferenceRandomAccessSubList<K> extends ReferenceSubList<K> implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public ReferenceRandomAccessSubList(ReferenceList<K> l, int from, int to) {
            super(l, from, to);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList.ReferenceSubList, p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ReferenceList<K> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new ReferenceRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
