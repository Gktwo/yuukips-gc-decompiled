package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;

@Beta
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableRangeSet.class */
public final class ImmutableRangeSet<C extends Comparable> extends AbstractRangeSet<C> implements Serializable {
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.m1438of());
    private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.m1437of(Range.all()));
    private final transient ImmutableList<Range<C>> ranges;
    @LazyInit
    private transient ImmutableRangeSet<C> complement;

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return equals(obj);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return enclosesAll(rangeSet);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(comparable);
    }

    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return CollectCollectors.toImmutableRangeSet();
    }

    /* renamed from: of */
    public static <C extends Comparable> ImmutableRangeSet<C> m1398of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static <C extends Comparable> ImmutableRangeSet<C> m1397of(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return m1398of();
        }
        if (range.equals(Range.all())) {
            return all();
        }
        return new ImmutableRangeSet<>(ImmutableList.m1437of(range));
    }

    static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> rangeSet) {
        Preconditions.checkNotNull(rangeSet);
        if (rangeSet.isEmpty()) {
            return m1398of();
        }
        if (rangeSet.encloses(Range.all())) {
            return all();
        }
        if (rangeSet instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) rangeSet;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) rangeSet.asRanges()));
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> ranges) {
        return new Builder().addAll(ranges).build();
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> ranges) {
        return copyOf(TreeRangeSet.create(ranges));
    }

    ImmutableRangeSet(ImmutableList<Range<C>> ranges) {
        this.ranges = ranges;
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> ranges, ImmutableRangeSet<C> complement) {
        this.ranges = ranges;
        this.complement = complement;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> otherRange) {
        int ceilingIndex = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), otherRange.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (ceilingIndex >= this.ranges.size() || !this.ranges.get(ceilingIndex).isConnected(otherRange) || this.ranges.get(ceilingIndex).intersection(otherRange).isEmpty()) {
            return ceilingIndex > 0 && this.ranges.get(ceilingIndex - 1).isConnected(otherRange) && !this.ranges.get(ceilingIndex - 1).intersection(otherRange).isEmpty();
        }
        return true;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> otherRange) {
        int index = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), otherRange.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return index != -1 && this.ranges.get(index).encloses(otherRange);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public Range<C> rangeContaining(C value) {
        int index = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(value), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (index == -1) {
            return null;
        }
        Range<C> range = this.ranges.get(index);
        if (range.contains(value)) {
            return range;
        }
        return null;
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        if (!this.ranges.isEmpty()) {
            return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(this.ranges.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void addAll(RangeSet<C> other) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    @Deprecated
    public void addAll(Iterable<Range<C>> other) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void removeAll(RangeSet<C> other) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    @Deprecated
    public void removeAll(Iterable<Range<C>> other) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.m1396of();
        }
        return new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.m1396of();
        }
        return new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableRangeSet$ComplementRanges.class */
    public final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedBelow;
        private final boolean positiveBoundedAbove;
        private final int size;

        ComplementRanges() {
            this.positiveBoundedBelow = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedAbove = ((Range) Iterables.getLast(ImmutableRangeSet.this.ranges)).hasUpperBound();
            int size = ImmutableRangeSet.this.ranges.size() - 1;
            size = this.positiveBoundedBelow ? size + 1 : size;
            this.size = this.positiveBoundedAbove ? size + 1 : size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }

        @Override // java.util.List
        public Range<C> get(int index) {
            Cut<C> upperBound;
            Preconditions.checkElementIndex(index, this.size);
            Cut<C> lowerBound = this.positiveBoundedBelow ? index == 0 ? Cut.belowAll() : ((Range) ImmutableRangeSet.this.ranges.get(index - 1)).upperBound : ((Range) ImmutableRangeSet.this.ranges.get(index)).upperBound;
            if (!this.positiveBoundedAbove || index != this.size - 1) {
                upperBound = ((Range) ImmutableRangeSet.this.ranges.get(index + (this.positiveBoundedBelow ? 0 : 1))).lowerBound;
            } else {
                upperBound = Cut.aboveAll();
            }
            return Range.create(lowerBound, upperBound);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> result = this.complement;
        if (result != null) {
            return result;
        }
        if (this.ranges.isEmpty()) {
            ImmutableRangeSet<C> all = all();
            this.complement = all;
            return all;
        } else if (this.ranges.size() != 1 || !this.ranges.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> result2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
            this.complement = result2;
            return result2;
        } else {
            ImmutableRangeSet<C> of = m1398of();
            this.complement = of;
            return of;
        }
    }

    public ImmutableRangeSet<C> union(RangeSet<C> other) {
        return unionOf(Iterables.concat(asRanges(), other.asRanges()));
    }

    public ImmutableRangeSet<C> intersection(RangeSet<C> other) {
        RangeSet<C> copy = TreeRangeSet.create(this);
        copy.removeAll(other.complement());
        return copyOf(copy);
    }

    public ImmutableRangeSet<C> difference(RangeSet<C> other) {
        RangeSet<C> copy = TreeRangeSet.create(this);
        copy.removeAll(other);
        return copyOf(copy);
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> range) {
        final int fromIndex;
        int toIndex;
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.m1438of();
        }
        if (range.encloses(span())) {
            return this.ranges;
        }
        if (range.hasLowerBound()) {
            fromIndex = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        } else {
            fromIndex = 0;
        }
        if (range.hasUpperBound()) {
            toIndex = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        } else {
            toIndex = this.ranges.size();
        }
        final int length = toIndex - fromIndex;
        if (length == 0) {
            return ImmutableList.m1438of();
        }
        return new ImmutableList<Range<C>>() { // from class: com.google.common.collect.ImmutableRangeSet.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return length;
            }

            @Override // java.util.List
            public Range<C> get(int index) {
                Preconditions.checkElementIndex(index, length);
                return (index == 0 || index == length - 1) ? ((Range) ImmutableRangeSet.this.ranges.get(index + fromIndex)).intersection(range) : (Range) ImmutableRangeSet.this.ranges.get(index + fromIndex);
            }

            @Override // com.google.common.collect.ImmutableCollection
            boolean isPartialView() {
                return true;
            }
        };
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return m1398of();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> domain) {
        Preconditions.checkNotNull(domain);
        if (isEmpty()) {
            return ImmutableSortedSet.m1358of();
        }
        Range<C> span = span().canonical(domain);
        if (!span.hasLowerBound()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (!span.hasUpperBound()) {
            try {
                domain.maxValue();
            } catch (NoSuchElementException e) {
                throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
            }
        }
        return new AsSet(domain);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableRangeSet$AsSet.class */
    public final class AsSet extends ImmutableSortedSet<C> {
        private final DiscreteDomain<C> domain;
        private transient Integer size;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableRangeSet$AsSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
            return tailSetImpl((AsSet) ((Comparable) obj), z);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.ImmutableRangeSet$AsSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
            return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableRangeSet$AsSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
            return headSetImpl((AsSet) ((Comparable) obj), z);
        }

        AsSet(DiscreteDomain<C> domain) {
            super(Ordering.natural());
            this.domain = domain;
        }

        /* JADX WARN: Type inference failed for: r0v18, types: [long] */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer result = this.size;
            if (result == null) {
                char c = 0;
                UnmodifiableIterator it = ImmutableRangeSet.this.ranges.iterator();
                while (it.hasNext()) {
                    c += (long) ContiguousSet.create((Range) it.next(), this.domain).size();
                    if (c >= 2147483647L) {
                        break;
                    }
                }
                Integer valueOf = Integer.valueOf(Ints.saturatedCast(c));
                this.size = valueOf;
                result = valueOf;
            }
            return result.intValue();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<C> iterator() {
            return new AbstractIterator<C>() { // from class: com.google.common.collect.ImmutableRangeSet.AsSet.1
                final Iterator<Range<C>> rangeItr;
                Iterator<C> elemItr = Iterators.emptyIterator();

                {
                    this.rangeItr = ImmutableRangeSet.this.ranges.iterator();
                }

                /* access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                public C computeNext() {
                    while (!this.elemItr.hasNext()) {
                        if (!this.rangeItr.hasNext()) {
                            return (C) ((Comparable) endOfData());
                        }
                        this.elemItr = ContiguousSet.create((Range) this.rangeItr.next(), AsSet.this.domain).iterator();
                    }
                    return (C) ((Comparable) this.elemItr.next());
                }
            };
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        @GwtIncompatible("NavigableSet")
        public UnmodifiableIterator<C> descendingIterator() {
            return new AbstractIterator<C>() { // from class: com.google.common.collect.ImmutableRangeSet.AsSet.2
                final Iterator<Range<C>> rangeItr;
                Iterator<C> elemItr = Iterators.emptyIterator();

                {
                    this.rangeItr = ImmutableRangeSet.this.ranges.reverse().iterator();
                }

                /* access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                public C computeNext() {
                    while (!this.elemItr.hasNext()) {
                        if (!this.rangeItr.hasNext()) {
                            return (C) ((Comparable) endOfData());
                        }
                        this.elemItr = ContiguousSet.create((Range) this.rangeItr.next(), AsSet.this.domain).descendingIterator();
                    }
                    return (C) ((Comparable) this.elemItr.next());
                }
            };
        }

        ImmutableSortedSet<C> subSet(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet((Range) range).asSet((DiscreteDomain<C>) this.domain);
        }

        ImmutableSortedSet<C> headSetImpl(C toElement, boolean inclusive) {
            return subSet(Range.upTo(toElement, BoundType.forBoolean(inclusive)));
        }

        ImmutableSortedSet<C> subSetImpl(C fromElement, boolean fromInclusive, C toElement, boolean toInclusive) {
            if (fromInclusive || toInclusive || Range.compareOrThrow(fromElement, toElement) != 0) {
                return subSet(Range.range(fromElement, BoundType.forBoolean(fromInclusive), toElement, BoundType.forBoolean(toInclusive)));
            }
            return ImmutableSortedSet.m1358of();
        }

        ImmutableSortedSet<C> tailSetImpl(C fromElement, boolean inclusive) {
            return subSet(Range.downTo(fromElement, BoundType.forBoolean(inclusive)));
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (o == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) o);
            } catch (ClassCastException e) {
                return false;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.google.common.collect.Range */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v22, types: [long] */
        @Override // com.google.common.collect.ImmutableSortedSet
        int indexOf(Object target) {
            if (!contains(target)) {
                return -1;
            }
            Comparable comparable = (Comparable) target;
            char c = 0;
            UnmodifiableIterator it = ImmutableRangeSet.this.ranges.iterator();
            while (it.hasNext()) {
                Range range = (Range) it.next();
                if (range.contains(comparable)) {
                    return Ints.saturatedCast(c + ((long) ContiguousSet.create(range, this.domain).indexOf(comparable)));
                }
                c += (long) ContiguousSet.create(range, this.domain).size();
            }
            throw new AssertionError("impossible");
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.ranges, this.domain);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableRangeSet$AsSetSerializedForm.class */
    private static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;
        private final DiscreteDomain<C> domain;

        AsSetSerializedForm(ImmutableList<Range<C>> ranges, DiscreteDomain<C> domain) {
            this.ranges = ranges;
            this.domain = domain;
        }

        Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    public static <C extends Comparable<?>> Builder<C> builder() {
        return new Builder<>();
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableRangeSet$Builder.class */
    public static class Builder<C extends Comparable<?>> {
        private final List<Range<C>> ranges = Lists.newArrayList();

        @CanIgnoreReturnValue
        public Builder<C> add(Range<C> range) {
            Preconditions.checkArgument(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.ranges.add(range);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<C> addAll(RangeSet<C> ranges) {
            return addAll(ranges.asRanges());
        }

        @CanIgnoreReturnValue
        public Builder<C> addAll(Iterable<Range<C>> ranges) {
            for (Range<C> range : ranges) {
                add(range);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<C> combine(Builder<C> builder) {
            addAll(builder.ranges);
            return this;
        }

        public ImmutableRangeSet<C> build() {
            ImmutableList.Builder<Range<C>> mergedRangesBuilder = new ImmutableList.Builder<>(this.ranges.size());
            Collections.sort(this.ranges, Range.rangeLexOrdering());
            PeekingIterator<Range<C>> peekingItr = Iterators.peekingIterator(this.ranges.iterator());
            while (peekingItr.hasNext()) {
                Range<C> range = peekingItr.next();
                while (peekingItr.hasNext()) {
                    Range<C> nextRange = peekingItr.peek();
                    if (range.isConnected(nextRange)) {
                        Preconditions.checkArgument(range.intersection(nextRange).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range, nextRange);
                        range = range.span(peekingItr.next());
                    }
                }
                mergedRangesBuilder.add((ImmutableList.Builder<Range<C>>) range);
            }
            ImmutableList<Range<C>> mergedRanges = mergedRangesBuilder.build();
            if (mergedRanges.isEmpty()) {
                return ImmutableRangeSet.m1398of();
            }
            if (mergedRanges.size() != 1 || !((Range) Iterables.getOnlyElement(mergedRanges)).equals(Range.all())) {
                return new ImmutableRangeSet<>(mergedRanges);
            }
            return ImmutableRangeSet.all();
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableRangeSet$SerializedForm.class */
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        SerializedForm(ImmutableList<Range<C>> ranges) {
            this.ranges = ranges;
        }

        Object readResolve() {
            if (this.ranges.isEmpty()) {
                return ImmutableRangeSet.m1398of();
            }
            if (this.ranges.equals(ImmutableList.m1437of(Range.all()))) {
                return ImmutableRangeSet.all();
            }
            return new ImmutableRangeSet(this.ranges);
        }
    }

    Object writeReplace() {
        return new SerializedForm(this.ranges);
    }
}
