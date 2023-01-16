package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollections;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigLists.class */
public final class BooleanBigLists {
    public static final EmptyBigList EMPTY_BIG_LIST = new EmptyBigList();

    private BooleanBigLists() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p014it.unimi.dsi.fastutil.booleans.BooleanBigList shuffle(p014it.unimi.dsi.fastutil.booleans.BooleanBigList r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = r0.size64()
            r9 = r0
        L_0x0007:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0046
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            boolean r0 = r0.getBoolean(r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            boolean r2 = r2.getBoolean(r3)
            boolean r0 = r0.set(r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            boolean r0 = r0.set(r1, r2)
            goto L_0x0007
        L_0x0046:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigLists.shuffle(it.unimi.dsi.fastutil.booleans.BooleanBigList, java.util.Random):it.unimi.dsi.fastutil.booleans.BooleanBigList");
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigLists$EmptyBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigLists$EmptyBigList.class */
    public static class EmptyBigList extends BooleanCollections.EmptyCollection implements BooleanBigList, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyBigList() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean getBoolean(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean rem(boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean removeBoolean(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void add(long index, boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean set(long index, boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public long indexOf(boolean k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public long lastIndexOf(boolean k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.EmptyCollection, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean addAll(BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(BooleanBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(long i, BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(long i, BooleanBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        @Deprecated
        public void add(long index, Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public boolean add(Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Boolean get(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        @Deprecated
        public Boolean set(long index, Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Boolean remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object k) {
            return -1;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Boolean> listIterator() {
            return BooleanBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.EmptyCollection, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanBigListIterator iterator() {
            return BooleanBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Boolean> listIterator(long i) {
            if (i == 0) {
                return BooleanBigListIterators.EMPTY_BIG_LIST_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.EmptyCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanSpliterator spliterator() {
            return BooleanSpliterators.EMPTY_SPLITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Boolean> subList(long from, long to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void getElements(long from, boolean[][] a, long offset, long length) {
            BigArrays.ensureOffsetLength(a, offset, length);
            if (from != 0) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void addElements(long index, boolean[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void addElements(long index, boolean[][] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public void size(long s) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return 0;
        }

        public int compareTo(BigList<? extends Boolean> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return BooleanBigLists.EMPTY_BIG_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof BigList) && ((BigList) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return BooleanBigLists.EMPTY_BIG_LIST;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigLists$Singleton.class */
    public static class Singleton extends AbstractBooleanBigList implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final boolean element;

        protected Singleton(boolean element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean getBoolean(long i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean rem(boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean removeBoolean(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean contains(boolean k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public long indexOf(boolean k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean[] toBooleanArray() {
            return new boolean[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Boolean> listIterator() {
            return BooleanBigListIterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.BigListIterator<java.lang.Boolean>, it.unimi.dsi.fastutil.booleans.BooleanBigListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p014it.unimi.dsi.fastutil.BigListIterator<java.lang.Boolean> listIterator(long r6) {
            /*
                r5 = this;
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L_0x000c
                r0 = r6
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0014
            L_0x000c:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                r1 = r0
                r1.<init>()
                throw r0
            L_0x0014:
                r0 = r5
                it.unimi.dsi.fastutil.booleans.BooleanBigListIterator r0 = r0.listIterator()
                r8 = r0
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0026
                r0 = r8
                boolean r0 = r0.nextBoolean()
            L_0x0026:
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigLists.Singleton.listIterator(long):it.unimi.dsi.fastutil.booleans.BooleanBigListIterator");
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanSpliterator spliterator() {
            return BooleanSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Boolean> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : BooleanBigLists.EMPTY_BIG_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(BooleanBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(long i, BooleanBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(long i, BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
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

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return 1;
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static BooleanBigList singleton(boolean element) {
        return new Singleton(element);
    }

    public static BooleanBigList singleton(Object element) {
        return new Singleton(((Boolean) element).booleanValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigLists$SynchronizedBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigLists$SynchronizedBigList.class */
    public static class SynchronizedBigList extends BooleanCollections.SynchronizedCollection implements BooleanBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final BooleanBigList list;

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean removeIf(BooleanPredicate booleanPredicate) {
            return removeIf(booleanPredicate);
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

        protected SynchronizedBigList(BooleanBigList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedBigList(BooleanBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean getBoolean(long i) {
            boolean z;
            synchronized (this.sync) {
                z = this.list.getBoolean(i);
            }
            return z;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean set(long i, boolean k) {
            boolean z;
            synchronized (this.sync) {
                z = this.list.set(i, k);
            }
            return z;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void add(long i, boolean k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean removeBoolean(long i) {
            boolean removeBoolean;
            synchronized (this.sync) {
                removeBoolean = this.list.removeBoolean(i);
            }
            return removeBoolean;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public long indexOf(boolean k) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public long lastIndexOf(boolean k) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Boolean> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void getElements(long from, boolean[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void removeElements(long from, long to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void addElements(long index, boolean[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void addElements(long index, boolean[][] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public void size(long size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            long size64;
            synchronized (this.sync) {
                size64 = this.list.size64();
            }
            return size64;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.booleans.BooleanBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanBigListIterator iterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Boolean> listIterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Boolean> listIterator(long i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.booleans.BooleanBigList] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Boolean> subList(long from, long to) {
            BooleanBigList synchronize;
            synchronized (this.sync) {
                synchronize = BooleanBigLists.synchronize(this.list.subList(from, to), this.sync);
            }
            return synchronize;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.list.equals(o);
            }
            return equals;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        public int compareTo(BigList<? extends Boolean> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(long index, BooleanCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(long index, BooleanBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(BooleanBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        @Deprecated
        public void add(long i, Boolean k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Boolean get(long i) {
            Boolean bool;
            synchronized (this.sync) {
                bool = this.list.get(i);
            }
            return bool;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        @Deprecated
        public Boolean set(long index, Boolean k) {
            Boolean bool;
            synchronized (this.sync) {
                bool = this.list.set(index, k);
            }
            return bool;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Boolean remove(long i) {
            Boolean remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }
    }

    public static BooleanBigList synchronize(BooleanBigList l) {
        return new SynchronizedBigList(l);
    }

    public static BooleanBigList synchronize(BooleanBigList l, Object sync) {
        return new SynchronizedBigList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigLists$UnmodifiableBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigLists$UnmodifiableBigList.class */
    public static class UnmodifiableBigList extends BooleanCollections.UnmodifiableCollection implements BooleanBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final BooleanBigList list;

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

        protected UnmodifiableBigList(BooleanBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean getBoolean(long i) {
            return this.list.getBoolean(i);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean set(long i, boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void add(long i, boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean removeBoolean(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public long indexOf(boolean k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public long lastIndexOf(boolean k) {
            return this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void getElements(long from, boolean[][] a, long offset, long length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void addElements(long index, boolean[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void addElements(long index, boolean[][] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public void size(long size) {
            this.list.size(size);
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return this.list.size64();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.booleans.BooleanBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanBigListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.booleans.BooleanBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Boolean> listIterator() {
            return BooleanBigListIterators.unmodifiable(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.booleans.BooleanBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Boolean> listIterator(long i) {
            return BooleanBigListIterators.unmodifiable(this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.booleans.BooleanBigList] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Boolean> subList(long from, long to) {
            return BooleanBigLists.unmodifiable(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.list.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }

        public int compareTo(BigList<? extends Boolean> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(long index, BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(BooleanBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(long index, BooleanBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Boolean get(long i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        @Deprecated
        public void add(long i, Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        @Deprecated
        public Boolean set(long index, Boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Boolean remove(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }
    }

    public static BooleanBigList unmodifiable(BooleanBigList l) {
        return new UnmodifiableBigList(l);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigLists$ListBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigLists$ListBigList.class */
    public static class ListBigList extends AbstractBooleanBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final BooleanList list;

        protected ListBigList(BooleanList list) {
            this.list = list;
        }

        private int intIndex(long index) {
            if (index < 2147483647L) {
                return (int) index;
            }
            throw new IndexOutOfBoundsException("This big list is restricted to 32-bit indices");
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return (long) this.list.size();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public void size(long size) {
            this.list.size(intIndex(size));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanBigListIterator iterator() {
            return BooleanBigListIterators.asBigListIterator(this.list.iterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Boolean> listIterator() {
            return BooleanBigListIterators.asBigListIterator(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.booleans.BooleanListIterator] */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Boolean> listIterator(long index) {
            return BooleanBigListIterators.asBigListIterator(this.list.listIterator(intIndex(index)));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Boolean> c) {
            return this.list.addAll(intIndex(index), c);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.booleans.BooleanList] */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Boolean> subList(long from, long to) {
            return new ListBigList(this.list.subList(intIndex(from), intIndex(to)));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean contains(boolean key) {
            return this.list.contains(key);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean[] toBooleanArray() {
            return this.list.toBooleanArray();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void removeElements(long from, long to) {
            this.list.removeElements(intIndex(from), intIndex(to));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public boolean[] toBooleanArray(boolean[] a) {
            return this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(long index, BooleanCollection c) {
            return this.list.addAll(intIndex(index), c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean addAll(BooleanCollection c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(long index, BooleanBigList c) {
            return this.list.addAll(intIndex(index), (BooleanCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean addAll(BooleanBigList c) {
            return this.list.addAll((BooleanCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean containsAll(BooleanCollection c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean removeAll(BooleanCollection c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean retainAll(BooleanCollection c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public void add(long index, boolean key) {
            this.list.add(intIndex(index), key);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean add(boolean key) {
            return this.list.add(key);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean getBoolean(long index) {
            return this.list.getBoolean(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public long indexOf(boolean k) {
            return (long) this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public long lastIndexOf(boolean k) {
            return (long) this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean removeBoolean(long index) {
            return this.list.removeBoolean(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean set(long index, boolean k) {
            return this.list.set(intIndex(index), k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.Stack, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] a) {
            return (T[]) this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Boolean> c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.list.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }
    }

    public static BooleanBigList asBigList(BooleanList list) {
        return new ListBigList(list);
    }
}
