package p014it.unimi.dsi.fastutil.booleans;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollections;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanLists.class */
public final class BooleanLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private BooleanLists() {
    }

    public static BooleanList shuffle(BooleanList l, Random random) {
        int i = l.size();
        while (true) {
            i--;
            if (i == 0) {
                return l;
            }
            int p = random.nextInt(i + 1);
            boolean t = l.getBoolean(i);
            l.set(i, l.getBoolean(p));
            l.set(p, t);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanLists$EmptyList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanLists$EmptyList.class */
    public static class EmptyList extends BooleanCollections.EmptyCollection implements BooleanList, RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean getBoolean(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean rem(boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean removeBoolean(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void add(int index, boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean set(int index, boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public int indexOf(boolean k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public int lastIndexOf(boolean k) {
            return -1;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Boolean> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void replaceAll(BooleanUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(BooleanList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(int i, BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(int i, BooleanList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public void add(int index, Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public Boolean get(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public boolean add(Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public Boolean set(int index, Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public Boolean remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public int indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public int lastIndexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void sort(BooleanComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void unstableSort(BooleanComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Boolean> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public void unstableSort(Comparator<? super Boolean> comparator) {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public ListIterator<Boolean> listIterator() {
            return BooleanIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.EmptyCollection, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanListIterator iterator() {
            return BooleanIterators.EMPTY_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public ListIterator<Boolean> listIterator(int i) {
            if (i == 0) {
                return BooleanIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public List<Boolean> subList(int from, int to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void getElements(int from, boolean[] a, int offset, int length) {
            if (from != 0 || length != 0 || offset < 0 || offset > a.length) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void addElements(int index, boolean[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void addElements(int index, boolean[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(boolean[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(int index, boolean[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(int index, boolean[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void size(int s) {
            throw new UnsupportedOperationException();
        }

        public int compareTo(List<? extends Boolean> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return BooleanLists.EMPTY_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof List) && ((List) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return BooleanLists.EMPTY_LIST;
        }
    }

    public static BooleanList emptyList() {
        return EMPTY_LIST;
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanLists$Singleton.class */
    public static class Singleton extends AbstractBooleanList implements RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final boolean element;

        protected Singleton(boolean element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean getBoolean(int i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean rem(boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean removeBoolean(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean contains(boolean k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public int indexOf(boolean k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean[] toBooleanArray() {
            return new boolean[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public ListIterator<Boolean> listIterator() {
            return BooleanIterators.singleton(this.element);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanListIterator iterator() {
            return listIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanSpliterator spliterator() {
            return BooleanSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ListIterator<java.lang.Boolean>, it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ListIterator<java.lang.Boolean> listIterator(int r4) {
            /*
                r3 = this;
                r0 = r4
                r1 = 1
                if (r0 > r1) goto L_0x0009
                r0 = r4
                if (r0 >= 0) goto L_0x0011
            L_0x0009:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                r1 = r0
                r1.<init>()
                throw r0
            L_0x0011:
                r0 = r3
                it.unimi.dsi.fastutil.booleans.BooleanListIterator r0 = r0.listIterator()
                r5 = r0
                r0 = r4
                r1 = 1
                if (r0 != r1) goto L_0x0022
                r0 = r5
                boolean r0 = r0.nextBoolean()
            L_0x0022:
                r0 = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanLists.Singleton.listIterator(int):it.unimi.dsi.fastutil.booleans.BooleanListIterator");
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public List<Boolean> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : BooleanLists.EMPTY_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        @Deprecated
        public void forEach(Consumer<? super Boolean> action) {
            action.accept(Boolean.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.util.List
        public boolean addAll(int i, Collection<? extends Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Boolean> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Boolean> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void replaceAll(BooleanUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        public void forEach(BooleanConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(BooleanList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(int i, BooleanList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(int i, BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean addAll(BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean removeAll(BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean retainAll(BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Boolean.valueOf(this.element)};
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void sort(BooleanComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void unstableSort(BooleanComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Boolean> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public void unstableSort(Comparator<? super Boolean> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void getElements(int from, boolean[] a, int offset, int length) {
            if (offset < 0) {
                throw new ArrayIndexOutOfBoundsException("Offset (" + offset + ") is negative");
            } else if (offset + length > a.length) {
                throw new ArrayIndexOutOfBoundsException("End index (" + (offset + length) + ") is greater than array length (" + a.length + ")");
            } else if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + (from + length) + ") is greater than list size (" + size() + ")");
            } else if (length > 0) {
                a[offset] = this.element;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void addElements(int index, boolean[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void addElements(int index, boolean[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(boolean[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(int index, boolean[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(int index, boolean[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static BooleanList singleton(boolean element) {
        return new Singleton(element);
    }

    public static BooleanList singleton(Object element) {
        return new Singleton(((Boolean) element).booleanValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanLists$SynchronizedList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanLists$SynchronizedList.class */
    public static class SynchronizedList extends BooleanCollections.SynchronizedCollection implements BooleanList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final BooleanList list;

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Boolean> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        public /* bridge */ /* synthetic */ void forEach(BooleanConsumer booleanConsumer) {
            forEach(booleanConsumer);
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream<Boolean> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream<Boolean> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public /* bridge */ /* synthetic */ BooleanSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Boolean bool) {
            return add(bool);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean retainAll(BooleanCollection booleanCollection) {
            return retainAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean removeAll(BooleanCollection booleanCollection) {
            return removeAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean containsAll(BooleanCollection booleanCollection) {
            return containsAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean addAll(BooleanCollection booleanCollection) {
            return addAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean[] toArray(boolean[] zArr) {
            return toArray(zArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean[] toBooleanArray(boolean[] zArr) {
            return toBooleanArray(zArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean[] toBooleanArray() {
            return toBooleanArray();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean rem(boolean z) {
            return rem(z);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean contains(boolean z) {
            return contains(z);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean add(boolean z) {
            return add(z);
        }

        protected SynchronizedList(BooleanList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedList(BooleanList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean getBoolean(int i) {
            boolean z;
            synchronized (this.sync) {
                z = this.list.getBoolean(i);
            }
            return z;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean set(int i, boolean k) {
            boolean z;
            synchronized (this.sync) {
                z = this.list.set(i, k);
            }
            return z;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void add(int i, boolean k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean removeBoolean(int i) {
            boolean removeBoolean;
            synchronized (this.sync) {
                removeBoolean = this.list.removeBoolean(i);
            }
            return removeBoolean;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public int indexOf(boolean k) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public int lastIndexOf(boolean k) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean removeIf(BooleanPredicate filter) {
            boolean removeIf;
            synchronized (this.sync) {
                removeIf = this.list.removeIf(filter);
            }
            return removeIf;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void replaceAll(BooleanUnaryOperator operator) {
            synchronized (this.sync) {
                this.list.replaceAll(operator);
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Boolean> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void getElements(int from, boolean[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void removeElements(int from, int to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void addElements(int index, boolean[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void addElements(int index, boolean[] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(boolean[] a) {
            synchronized (this.sync) {
                this.list.setElements(a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(int index, boolean[] a) {
            synchronized (this.sync) {
                this.list.setElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(int index, boolean[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.setElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void size(int size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public ListIterator<Boolean> listIterator() {
            return this.list.listIterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public ListIterator<Boolean> listIterator(int i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.booleans.BooleanList] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public List<Boolean> subList(int from, int to) {
            SynchronizedList synchronizedList;
            synchronized (this.sync) {
                synchronizedList = new SynchronizedList(this.list.subList(from, to), this.sync);
            }
            return synchronizedList;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.collection.equals(o);
            }
            return equals;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.collection.hashCode();
            }
            return hashCode;
        }

        public int compareTo(List<? extends Boolean> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(int index, BooleanCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(int index, BooleanList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(BooleanList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public Boolean get(int i) {
            Boolean bool;
            synchronized (this.sync) {
                bool = this.list.get(i);
            }
            return bool;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public void add(int i, Boolean k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public Boolean set(int index, Boolean k) {
            Boolean bool;
            synchronized (this.sync) {
                bool = this.list.set(index, k);
            }
            return bool;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public Boolean remove(int i) {
            Boolean remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void sort(BooleanComparator comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void unstableSort(BooleanComparator comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Boolean> comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public void unstableSort(Comparator<? super Boolean> comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanLists$SynchronizedRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanLists$SynchronizedRandomAccessList.class */
    public static class SynchronizedRandomAccessList extends SynchronizedList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected SynchronizedRandomAccessList(BooleanList l, Object sync) {
            super(l, sync);
        }

        protected SynchronizedRandomAccessList(BooleanList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.booleans.BooleanList] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanLists.SynchronizedList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public List<Boolean> subList(int from, int to) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.sync) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(from, to), this.sync);
            }
            return synchronizedRandomAccessList;
        }
    }

    public static BooleanList synchronize(BooleanList l) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l) : new SynchronizedList(l);
    }

    public static BooleanList synchronize(BooleanList l, Object sync) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l, sync) : new SynchronizedList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanLists$UnmodifiableList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanLists$UnmodifiableList.class */
    public static class UnmodifiableList extends BooleanCollections.UnmodifiableCollection implements BooleanList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final BooleanList list;

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean retainAll(BooleanCollection booleanCollection) {
            return retainAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean removeAll(BooleanCollection booleanCollection) {
            return removeAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean addAll(BooleanCollection booleanCollection) {
            return addAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean containsAll(BooleanCollection booleanCollection) {
            return containsAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean[] toArray(boolean[] zArr) {
            return toArray(zArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean[] toBooleanArray(boolean[] zArr) {
            return toBooleanArray(zArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean[] toBooleanArray() {
            return toBooleanArray();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Boolean bool) {
            return add(bool);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean removeIf(BooleanPredicate booleanPredicate) {
            return removeIf(booleanPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Boolean> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        public /* bridge */ /* synthetic */ void forEach(BooleanConsumer booleanConsumer) {
            forEach(booleanConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream<Boolean> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream<Boolean> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public /* bridge */ /* synthetic */ BooleanSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean contains(boolean z) {
            return contains(z);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean rem(boolean z) {
            return rem(z);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean add(boolean z) {
            return add(z);
        }

        protected UnmodifiableList(BooleanList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean getBoolean(int i) {
            return this.list.getBoolean(i);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean set(int i, boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void add(int i, boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean removeBoolean(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public int indexOf(boolean k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public int lastIndexOf(boolean k) {
            return this.list.lastIndexOf(k);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Boolean> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void getElements(int from, boolean[] a, int offset, int length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void addElements(int index, boolean[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void addElements(int index, boolean[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(boolean[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(int index, boolean[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void setElements(int index, boolean[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void size(int size) {
            this.list.size(size);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public ListIterator<Boolean> listIterator() {
            return BooleanIterators.unmodifiable((BooleanListIterator) this.list.listIterator());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public ListIterator<Boolean> listIterator(int i) {
            return BooleanIterators.unmodifiable((BooleanListIterator) this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.booleans.BooleanList] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public List<Boolean> subList(int from, int to) {
            return new UnmodifiableList(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        public int compareTo(List<? extends Boolean> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(int index, BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(BooleanList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean addAll(int index, BooleanList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public Boolean get(int i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public void add(int i, Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public Boolean set(int index, Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public Boolean remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void sort(BooleanComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void unstableSort(BooleanComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Boolean> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public void unstableSort(Comparator<? super Boolean> comparator) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanLists$UnmodifiableRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanLists$UnmodifiableRandomAccessList.class */
    public static class UnmodifiableRandomAccessList extends UnmodifiableList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected UnmodifiableRandomAccessList(BooleanList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.booleans.BooleanList] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanLists.UnmodifiableList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public List<Boolean> subList(int from, int to) {
            return new UnmodifiableRandomAccessList(this.list.subList(from, to));
        }
    }

    public static BooleanList unmodifiable(BooleanList l) {
        return l instanceof RandomAccess ? new UnmodifiableRandomAccessList(l) : new UnmodifiableList(l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanLists$ImmutableListBase */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanLists$ImmutableListBase.class */
    public static abstract class ImmutableListBase extends AbstractBooleanList implements BooleanList {
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final void add(int index, boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public final boolean add(boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean addAll(Collection<? extends Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.util.List
        @Deprecated
        public final boolean addAll(int index, Collection<? extends Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final boolean removeBoolean(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public final boolean rem(boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public final boolean removeIf(Predicate<? super Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public final boolean removeIf(BooleanPredicate c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public final void replaceAll(UnaryOperator<Boolean> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final void add(int index, Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public final boolean add(Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public final Boolean remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public final boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final Boolean set(int index, Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public final boolean addAll(BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final boolean addAll(BooleanList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final boolean addAll(int index, BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final boolean addAll(int index, BooleanList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public final boolean removeAll(BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public final boolean retainAll(BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final boolean set(int index, boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final void addElements(int index, boolean[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final void setElements(int index, boolean[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final void sort(BooleanComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final void unstableSort(BooleanComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        @Deprecated
        public final void sort(Comparator<? super Boolean> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        @Deprecated
        public final void unstableSort(Comparator<? super Boolean> comparator) {
            throw new UnsupportedOperationException();
        }
    }
}
