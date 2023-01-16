package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collector;

@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSet.class */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    static final int SPLITERATOR_CHARACTERISTICS = 1297;
    @RetainedWith
    @LazyInit
    private transient ImmutableList<E> asList;
    static final int MAX_TABLE_SIZE = 1073741824;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    private static final int CUTOFF = 751619276;
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_RUN_MULTIPLIER = 13;

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    public static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return CollectCollectors.toImmutableSet();
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m1396of() {
        return RegularImmutableSet.EMPTY;
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m1395of(E element) {
        return new SingletonImmutableSet(element);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m1394of(E e1, E e2) {
        return construct(2, e1, e2);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m1393of(E e1, E e2, E e3) {
        return construct(3, e1, e2, e3);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m1392of(E e1, E e2, E e3, E e4) {
        return construct(4, e1, e2, e3, e4);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m1391of(E e1, E e2, E e3, E e4, E e5) {
        return construct(5, e1, e2, e3, e4, e5);
    }

    @SafeVarargs
    /* renamed from: of */
    public static <E> ImmutableSet<E> m1390of(E e1, E e2, E e3, E e4, E e5, E e6, E... others) {
        Preconditions.checkArgument(others.length <= 2147483641, "the total number of elements must fit in an int");
        Object[] elements = new Object[6 + others.length];
        elements[0] = e1;
        elements[1] = e2;
        elements[2] = e3;
        elements[3] = e4;
        elements[4] = e5;
        elements[5] = e6;
        System.arraycopy(others, 0, elements, 6, others.length);
        return construct(elements.length, elements);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: com.google.common.collect.ImmutableSet$RegularSetBuilderImpl */
    /* JADX WARN: Multi-variable type inference failed */
    private static <E> ImmutableSet<E> construct(int n, Object... elements) {
        switch (n) {
            case 0:
                return m1396of();
            case 1:
                return m1395of(elements[0]);
            default:
                RegularSetBuilderImpl regularSetBuilderImpl = new RegularSetBuilderImpl(4);
                for (int i = 0; i < n; i++) {
                    regularSetBuilderImpl = regularSetBuilderImpl.add(Preconditions.checkNotNull(elements[i]));
                }
                return regularSetBuilderImpl.review().build();
        }
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> elements) {
        if ((elements instanceof ImmutableSet) && !(elements instanceof SortedSet)) {
            ImmutableSet<E> set = (ImmutableSet) elements;
            if (!set.isPartialView()) {
                return set;
            }
        } else if (elements instanceof EnumSet) {
            return copyOfEnumSet((EnumSet) elements);
        }
        Object[] array = elements.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return copyOf((Collection) elements);
        }
        return copyOf(elements.iterator());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.google.common.collect.ImmutableSet$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> elements) {
        if (!elements.hasNext()) {
            return m1396of();
        }
        Object next = elements.next();
        if (!elements.hasNext()) {
            return m1395of(next);
        }
        return new Builder().add((Builder) next).addAll((Iterator) elements).build();
    }

    public static <E> ImmutableSet<E> copyOf(E[] elements) {
        switch (elements.length) {
            case 0:
                return m1396of();
            case 1:
                return m1395of((Object) elements[0]);
            default:
                return construct(elements.length, (Object[]) elements.clone());
        }
    }

    private static ImmutableSet copyOfEnumSet(EnumSet enumSet) {
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(enumSet));
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ImmutableSet) || !isHashCodeFast() || !((ImmutableSet) object).isHashCodeFast() || hashCode() == object.hashCode()) {
            return Sets.equalsImpl(this, object);
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> result = this.asList;
        if (result != null) {
            return result;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    ImmutableList<E> createAsList() {
        return new RegularImmutableAsList(this, toArray());
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSet$Indexed.class */
    public static abstract class Indexed<E> extends ImmutableSet<E> {
        abstract E get(int i);

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<E> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return CollectSpliterators.indexed(size(), 1297, this::get);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            Preconditions.checkNotNull(consumer);
            int n = size();
            for (int i = 0; i < n; i++) {
                consumer.accept(get(i));
            }
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] dst, int offset) {
            return asList().copyIntoArray(dst, offset);
        }

        @Override // com.google.common.collect.ImmutableSet
        ImmutableList<E> createAsList() {
            return new ImmutableAsList<E>() { // from class: com.google.common.collect.ImmutableSet.Indexed.1
                @Override // java.util.List
                public E get(int index) {
                    return (E) Indexed.this.get(index);
                }

                /* access modifiers changed from: package-private */
                @Override // com.google.common.collect.ImmutableAsList
                public Indexed<E> delegateCollection() {
                    return Indexed.this;
                }
            };
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSet$SerializedForm.class */
    private static class SerializedForm implements Serializable {
        final Object[] elements;
        private static final long serialVersionUID = 0;

        SerializedForm(Object[] elements) {
            this.elements = elements;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int expectedSize) {
        CollectPreconditions.checkNonnegative(expectedSize, "expectedSize");
        return new Builder<>(expectedSize);
    }

    static Object[] rebuildHashTable(int newTableSize, Object[] elements, int n) {
        int index;
        Object[] hashTable = new Object[newTableSize];
        int mask = hashTable.length - 1;
        for (int i = 0; i < n; i++) {
            Object e = elements[i];
            int j = Hashing.smear(e.hashCode());
            while (true) {
                index = j & mask;
                if (hashTable[index] == null) {
                    break;
                }
                j++;
            }
            hashTable[index] = e;
        }
        return hashTable;
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSet$Builder.class */
    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        private SetBuilderImpl<E> impl;
        boolean forceCopy;

        public Builder() {
            this(4);
        }

        Builder(int capacity) {
            this.impl = new RegularSetBuilderImpl(capacity);
        }

        /* access modifiers changed from: package-private */
        public Builder(boolean subclass) {
            this.impl = null;
        }

        @VisibleForTesting
        void forceJdk() {
            this.impl = new JdkBackedSetBuilderImpl(this.impl);
        }

        final void copyIfNecessary() {
            if (this.forceCopy) {
                copy();
                this.forceCopy = false;
            }
        }

        void copy() {
            this.impl = this.impl.copy();
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E element) {
            Preconditions.checkNotNull(element);
            copyIfNecessary();
            this.impl = this.impl.add(element);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... elements) {
            add((Object[]) elements);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> elements) {
            addAll((Iterable) elements);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> elements) {
            addAll((Iterator) elements);
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder<E> combine(Builder<E> other) {
            copyIfNecessary();
            this.impl = this.impl.combine(other.impl);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSet<E> build() {
            this.forceCopy = true;
            this.impl = this.impl.review();
            return this.impl.build();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSet$SetBuilderImpl.class */
    public static abstract class SetBuilderImpl<E> {
        E[] dedupedElements;
        int distinct;

        abstract SetBuilderImpl<E> add(E e);

        abstract SetBuilderImpl<E> copy();

        abstract ImmutableSet<E> build();

        SetBuilderImpl(int expectedCapacity) {
            this.dedupedElements = (E[]) new Object[expectedCapacity];
            this.distinct = 0;
        }

        SetBuilderImpl(SetBuilderImpl<E> toCopy) {
            this.dedupedElements = (E[]) Arrays.copyOf(toCopy.dedupedElements, toCopy.dedupedElements.length);
            this.distinct = toCopy.distinct;
        }

        private void ensureCapacity(int minCapacity) {
            if (minCapacity > this.dedupedElements.length) {
                this.dedupedElements = (E[]) Arrays.copyOf(this.dedupedElements, ImmutableCollection.Builder.expandedCapacity(this.dedupedElements.length, minCapacity));
            }
        }

        final void addDedupedElement(E e) {
            ensureCapacity(this.distinct + 1);
            E[] eArr = this.dedupedElements;
            int i = this.distinct;
            this.distinct = i + 1;
            eArr[i] = e;
        }

        final SetBuilderImpl<E> combine(SetBuilderImpl<E> other) {
            SetBuilderImpl<E> result = this;
            for (int i = 0; i < other.distinct; i++) {
                result = result.add(other.dedupedElements[i]);
            }
            return result;
        }

        SetBuilderImpl<E> review() {
            return this;
        }
    }

    @VisibleForTesting
    static int chooseTableSize(int setSize) {
        int setSize2 = Math.max(setSize, 2);
        if (setSize2 < CUTOFF) {
            int highestOneBit = Integer.highestOneBit(setSize2 - 1);
            while (true) {
                int tableSize = highestOneBit << 1;
                if (((double) tableSize) * DESIRED_LOAD_FACTOR >= ((double) setSize2)) {
                    return tableSize;
                }
                highestOneBit = tableSize;
            }
        } else {
            Preconditions.checkArgument(setSize2 < 1073741824, "collection too large");
            return 1073741824;
        }
    }

    static boolean hashFloodingDetected(Object[] hashTable) {
        int maxRunBeforeFallback = maxRunBeforeFallback(hashTable.length);
        int endOfStartRun = 0;
        while (endOfStartRun < hashTable.length && hashTable[endOfStartRun] != null) {
            endOfStartRun++;
            if (endOfStartRun > maxRunBeforeFallback) {
                return true;
            }
        }
        int startOfEndRun = hashTable.length - 1;
        while (startOfEndRun > endOfStartRun && hashTable[startOfEndRun] != null) {
            if (endOfStartRun + ((hashTable.length - 1) - startOfEndRun) > maxRunBeforeFallback) {
                return true;
            }
            startOfEndRun--;
        }
        int testBlockSize = maxRunBeforeFallback / 2;
        int i = endOfStartRun;
        int i2 = 1;
        while (true) {
            int i3 = i + i2;
            if (i3 + testBlockSize > startOfEndRun) {
                return false;
            }
            for (int j = 0; j < testBlockSize; j++) {
                if (hashTable[i3 + j] == null) {
                    break;
                }
            }
            return true;
            i = i3;
            i2 = testBlockSize;
        }
    }

    /* access modifiers changed from: private */
    public static int maxRunBeforeFallback(int tableSize) {
        return 13 * IntMath.log2(tableSize, RoundingMode.UNNECESSARY);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSet$RegularSetBuilderImpl.class */
    public static final class RegularSetBuilderImpl<E> extends SetBuilderImpl<E> {
        private Object[] hashTable;
        private int maxRunBeforeFallback;
        private int expandTableThreshold;
        private int hashCode;

        RegularSetBuilderImpl(int expectedCapacity) {
            super(expectedCapacity);
            int tableSize = ImmutableSet.chooseTableSize(expectedCapacity);
            this.hashTable = new Object[tableSize];
            this.maxRunBeforeFallback = ImmutableSet.maxRunBeforeFallback(tableSize);
            this.expandTableThreshold = (int) (ImmutableSet.DESIRED_LOAD_FACTOR * ((double) tableSize));
        }

        RegularSetBuilderImpl(RegularSetBuilderImpl<E> toCopy) {
            super(toCopy);
            this.hashTable = Arrays.copyOf(toCopy.hashTable, toCopy.hashTable.length);
            this.maxRunBeforeFallback = toCopy.maxRunBeforeFallback;
            this.expandTableThreshold = toCopy.expandTableThreshold;
            this.hashCode = toCopy.hashCode;
        }

        void ensureTableCapacity(int minCapacity) {
            if (minCapacity > this.expandTableThreshold && this.hashTable.length < 1073741824) {
                int newTableSize = this.hashTable.length * 2;
                this.hashTable = ImmutableSet.rebuildHashTable(newTableSize, this.dedupedElements, this.distinct);
                this.maxRunBeforeFallback = ImmutableSet.maxRunBeforeFallback(newTableSize);
                this.expandTableThreshold = (int) (ImmutableSet.DESIRED_LOAD_FACTOR * ((double) newTableSize));
            }
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> add(E e) {
            Preconditions.checkNotNull(e);
            int eHash = e.hashCode();
            int i0 = Hashing.smear(eHash);
            int mask = this.hashTable.length - 1;
            for (int i = i0; i - i0 < this.maxRunBeforeFallback; i++) {
                int index = i & mask;
                Object tableEntry = this.hashTable[index];
                if (tableEntry == null) {
                    addDedupedElement(e);
                    this.hashTable[index] = e;
                    this.hashCode += eHash;
                    ensureTableCapacity(this.distinct);
                    return this;
                } else if (tableEntry.equals(e)) {
                    return this;
                }
            }
            return new JdkBackedSetBuilderImpl(this).add(e);
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> copy() {
            return new RegularSetBuilderImpl(this);
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> review() {
            int targetTableSize = ImmutableSet.chooseTableSize(this.distinct);
            if (targetTableSize * 2 < this.hashTable.length) {
                this.hashTable = ImmutableSet.rebuildHashTable(targetTableSize, this.dedupedElements, this.distinct);
            }
            return ImmutableSet.hashFloodingDetected(this.hashTable) ? new JdkBackedSetBuilderImpl(this) : this;
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        ImmutableSet<E> build() {
            switch (this.distinct) {
                case 0:
                    return ImmutableSet.m1396of();
                case 1:
                    return ImmutableSet.m1395of(this.dedupedElements[0]);
                default:
                    return new RegularImmutableSet(this.distinct == this.dedupedElements.length ? this.dedupedElements : Arrays.copyOf(this.dedupedElements, this.distinct), this.hashCode, this.hashTable, this.hashTable.length - 1);
            }
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSet$JdkBackedSetBuilderImpl.class */
    private static final class JdkBackedSetBuilderImpl<E> extends SetBuilderImpl<E> {
        private final Set<Object> delegate = Sets.newHashSetWithExpectedSize(this.distinct);

        JdkBackedSetBuilderImpl(SetBuilderImpl<E> toCopy) {
            super(toCopy);
            for (int i = 0; i < this.distinct; i++) {
                this.delegate.add(this.dedupedElements[i]);
            }
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> add(E e) {
            Preconditions.checkNotNull(e);
            if (this.delegate.add(e)) {
                addDedupedElement(e);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        SetBuilderImpl<E> copy() {
            return new JdkBackedSetBuilderImpl(this);
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        ImmutableSet<E> build() {
            switch (this.distinct) {
                case 0:
                    return ImmutableSet.m1396of();
                case 1:
                    return ImmutableSet.m1395of(this.dedupedElements[0]);
                default:
                    return new JdkBackedImmutableSet(this.delegate, ImmutableList.asImmutableList(this.dedupedElements, this.distinct));
            }
        }
    }
}
