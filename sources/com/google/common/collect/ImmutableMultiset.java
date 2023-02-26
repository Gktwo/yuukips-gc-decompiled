package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultiset.class */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {
    @LazyInit
    private transient ImmutableList<E> asList;
    @LazyInit
    private transient ImmutableSet<Multiset.Entry<E>> entrySet;

    @Override // com.google.common.collect.Multiset
    public abstract ImmutableSet<E> elementSet();

    abstract Multiset.Entry<E> getEntry(int i);

    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        return toImmutableMultiset(Function.identity(), e -> {
            return 1;
        });
    }

    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> elementFunction, ToIntFunction<? super T> countFunction) {
        Preconditions.checkNotNull(elementFunction);
        Preconditions.checkNotNull(countFunction);
        return Collector.of(LinkedHashMultiset::create, multiset, t -> {
            multiset.add(Preconditions.checkNotNull(elementFunction.apply(t)), countFunction.applyAsInt(t));
        }, multiset1, multiset2 -> {
            multiset1.addAll(multiset2);
            return multiset1;
        }, multiset -> {
            return copyFromEntries(multiset.entrySet());
        }, new Collector.Characteristics[0]);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m1407of() {
        return (ImmutableMultiset<E>) RegularImmutableMultiset.EMPTY;
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m1406of(E element) {
        return copyFromElements(element);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m1405of(E e1, E e2) {
        return copyFromElements(e1, e2);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m1404of(E e1, E e2, E e3) {
        return copyFromElements(e1, e2, e3);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m1403of(E e1, E e2, E e3, E e4) {
        return copyFromElements(e1, e2, e3, e4);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m1402of(E e1, E e2, E e3, E e4, E e5) {
        return copyFromElements(e1, e2, e3, e4, e5);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m1401of(E e1, E e2, E e3, E e4, E e5, E e6, E... others) {
        return new Builder().add((Builder) e1).add((Builder<E>) e2).add((Builder<E>) e3).add((Builder<E>) e4).add((Builder<E>) e5).add((Builder<E>) e6).add((Object[]) others).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] elements) {
        return copyFromElements(elements);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> elements) {
        Multiset<? extends E> multiset;
        if (elements instanceof ImmutableMultiset) {
            ImmutableMultiset<E> result = (ImmutableMultiset) elements;
            if (!result.isPartialView()) {
                return result;
            }
        }
        if (elements instanceof Multiset) {
            multiset = Multisets.cast(elements);
        } else {
            multiset = LinkedHashMultiset.create(elements);
        }
        return copyFromEntries(multiset.entrySet());
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> elements) {
        Multiset<E> multiset = LinkedHashMultiset.create();
        Iterators.addAll(multiset, elements);
        return copyFromEntries(multiset.entrySet());
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... elements) {
        Multiset<E> multiset = LinkedHashMultiset.create();
        Collections.addAll(multiset, elements);
        return copyFromEntries(multiset.entrySet());
    }

    /* access modifiers changed from: package-private */
    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> entries) {
        if (entries.isEmpty()) {
            return m1407of();
        }
        return RegularImmutableMultiset.create(entries);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        final Iterator<Multiset.Entry<E>> entryIterator = entrySet().iterator();
        return new UnmodifiableIterator<E>() { // from class: com.google.common.collect.ImmutableMultiset.1
            int remaining;
            E element;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.remaining > 0 || entryIterator.hasNext();
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.remaining <= 0) {
                    Multiset.Entry<E> entry = (Multiset.Entry) entryIterator.next();
                    this.element = entry.getElement();
                    this.remaining = entry.getCount();
                }
                this.remaining--;
                return this.element;
            }
        };
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> result = this.asList;
        if (result != null) {
            return result;
        }
        ImmutableList<E> asList = asList();
        this.asList = asList;
        return asList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object object) {
        return count(object) > 0;
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int add(E element, int occurrences) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int remove(Object element, int occurrences) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int setCount(E element, int count) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean setCount(E element, int oldCount, int newCount) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int copyIntoArray(Object[] dst, int offset) {
        UnmodifiableIterator<Multiset.Entry<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            Multiset.Entry<E> entry = it.next();
            Arrays.fill(dst, offset, offset + entry.getCount(), entry.getElement());
            offset += entry.getCount();
        }
        return offset;
    }

    @Override // java.util.Collection, java.lang.Object, com.google.common.collect.Multiset
    public boolean equals(Object object) {
        return Multisets.equalsImpl(this, object);
    }

    @Override // java.util.Collection, java.lang.Object, com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    @Override // java.util.AbstractCollection, java.lang.Object, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        ImmutableSet<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    private ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.m1396of() : new EntrySet();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultiset$EntrySet.class */
    public final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.IndexedImmutableSet
        public Multiset.Entry<E> get(int index) {
            return ImmutableMultiset.this.getEntry(index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry<?> entry = (Multiset.Entry) o;
            return entry.getCount() > 0 && ImmutableMultiset.this.count(entry.getElement()) == entry.getCount();
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultiset$EntrySetSerializedForm.class */
    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> multiset) {
            this.multiset = multiset;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultiset$Builder.class */
    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        final Multiset<E> contents;

        public Builder() {
            this(LinkedHashMultiset.create());
        }

        /* access modifiers changed from: package-private */
        public Builder(Multiset<E> contents) {
            this.contents = contents;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.collect.Multiset<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E element) {
            this.contents.add(Preconditions.checkNotNull(element));
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... elements) {
            add((Object[]) elements);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.collect.Multiset<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<E> addCopies(E element, int occurrences) {
            this.contents.add(Preconditions.checkNotNull(element), occurrences);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.collect.Multiset<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<E> setCount(E element, int count) {
            this.contents.setCount(Preconditions.checkNotNull(element), count);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> elements) {
            if (elements instanceof Multiset) {
                Multisets.cast(elements).forEachEntry(e, n -> {
                    this.contents.add(Preconditions.checkNotNull(e), n);
                });
            } else {
                addAll((Iterable) elements);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> elements) {
            addAll((Iterator) elements);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableMultiset<E> build() {
            return ImmutableMultiset.copyOf(this.contents);
        }

        @VisibleForTesting
        ImmutableMultiset<E> buildJdkBacked() {
            if (this.contents.isEmpty()) {
                return ImmutableMultiset.m1407of();
            }
            return JdkBackedImmutableMultiset.create(this.contents.entrySet());
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultiset$ElementSet.class */
    static final class ElementSet<E> extends ImmutableSet.Indexed<E> {
        private final List<Multiset.Entry<E>> entries;
        private final Multiset<E> delegate;

        /* access modifiers changed from: package-private */
        public ElementSet(List<Multiset.Entry<E>> entries, Multiset<E> delegate) {
            this.entries = entries;
            this.delegate = delegate;
        }

        @Override // com.google.common.collect.ImmutableSet.Indexed
        E get(int index) {
            return this.entries.get(index).getElement();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object object) {
            return this.delegate.contains(object);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.entries.size();
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultiset$SerializedForm.class */
    static final class SerializedForm implements Serializable {
        final Object[] elements;
        final int[] counts;
        private static final long serialVersionUID = 0;

        SerializedForm(Multiset<?> multiset) {
            int distinct = multiset.entrySet().size();
            this.elements = new Object[distinct];
            this.counts = new int[distinct];
            int i = 0;
            for (Multiset.Entry<?> entry : multiset.entrySet()) {
                this.elements[i] = entry.getElement();
                this.counts[i] = entry.getCount();
                i++;
            }
        }

        Object readResolve() {
            LinkedHashMultiset<Object> multiset = LinkedHashMultiset.create(this.elements.length);
            for (int i = 0; i < this.elements.length; i++) {
                multiset.add(this.elements[i], this.counts[i]);
            }
            return ImmutableMultiset.copyOf(multiset);
        }
    }
}
