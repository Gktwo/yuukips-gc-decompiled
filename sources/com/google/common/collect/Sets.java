package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/Sets.class */
public final class Sets {
    private Sets() {
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$ImprovedAbstractSet.class */
    public static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c) {
            return Sets.removeAllImpl(this, c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c) {
            return retainAll((Collection) Preconditions.checkNotNull(c));
        }
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E anElement, E... otherElements) {
        return ImmutableEnumSet.asImmutable(EnumSet.of((Enum) anElement, (Enum[]) otherElements));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> elements) {
        if (elements instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet) elements;
        }
        if (elements instanceof Collection) {
            Collection<E> collection = (Collection) elements;
            if (collection.isEmpty()) {
                return ImmutableSet.m1396of();
            }
            return ImmutableEnumSet.asImmutable(EnumSet.copyOf(collection));
        }
        Iterator<E> itr = elements.iterator();
        if (!itr.hasNext()) {
            return ImmutableSet.m1396of();
        }
        EnumSet<E> enumSet = EnumSet.of((Enum) itr.next());
        Iterators.addAll(enumSet, itr);
        return ImmutableEnumSet.asImmutable(enumSet);
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$Accumulator.class */
    private static final class Accumulator<E extends Enum<E>> {
        static final Collector<Enum<?>, ?, ImmutableSet<? extends Enum<?>>> TO_IMMUTABLE_ENUM_SET = Collector.of(Accumulator::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, (v0) -> {
            return v0.toImmutableSet();
        }, Collector.Characteristics.UNORDERED);
        private EnumSet<E> set;

        private Accumulator() {
        }

        void add(E e) {
            if (this.set == null) {
                this.set = EnumSet.of((Enum) e);
            } else {
                this.set.add(e);
            }
        }

        Accumulator<E> combine(Accumulator<E> other) {
            if (this.set == null) {
                return other;
            }
            if (other.set == null) {
                return this;
            }
            this.set.addAll(other.set);
            return this;
        }

        ImmutableSet<E> toImmutableSet() {
            return this.set == null ? ImmutableSet.m1396of() : ImmutableEnumSet.asImmutable(this.set);
        }
    }

    public static <E extends Enum<E>> Collector<E, ?, ImmutableSet<E>> toImmutableEnumSet() {
        return (Collector<E, ?, ImmutableSet<E>>) Accumulator.TO_IMMUTABLE_ENUM_SET;
    }

    public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> iterable, Class<E> elementType) {
        EnumSet<E> set = EnumSet.noneOf(elementType);
        Iterables.addAll(set, iterable);
        return set;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> newHashSet(E... elements) {
        HashSet<E> set = newHashSetWithExpectedSize(elements.length);
        Collections.addAll(set, elements);
        return set;
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new HashSet<>(Collections2.cast(elements));
        }
        return newHashSet(elements.iterator());
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> elements) {
        HashSet<E> set = newHashSet();
        Iterators.addAll(set, elements);
        return set;
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int expectedSize) {
        return new HashSet<>(Maps.capacity(expectedSize));
    }

    public static <E> Set<E> newConcurrentHashSet() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> elements) {
        Set<E> set = newConcurrentHashSet();
        Iterables.addAll(set, elements);
        return set;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new LinkedHashSet<>(Collections2.cast(elements));
        }
        LinkedHashSet<E> set = newLinkedHashSet();
        Iterables.addAll(set, elements);
        return set;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int expectedSize) {
        return new LinkedHashSet<>(Maps.capacity(expectedSize));
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet<>();
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> elements) {
        TreeSet<E> set = newTreeSet();
        Iterables.addAll(set, elements);
        return set;
    }

    public static <E> TreeSet<E> newTreeSet(Comparator<? super E> comparator) {
        return new TreeSet<>((Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(Maps.newIdentityHashMap());
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet<>();
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> elements) {
        Collection<? extends E> elementsCollection;
        if (elements instanceof Collection) {
            elementsCollection = Collections2.cast(elements);
        } else {
            elementsCollection = Lists.newArrayList(elements);
        }
        return new CopyOnWriteArraySet<>(elementsCollection);
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        Preconditions.checkArgument(!collection.isEmpty(), "collection is empty; use the other version of this method");
        return makeComplementByHand(collection, collection.iterator().next().getDeclaringClass());
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection, Class<E> type) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        return makeComplementByHand(collection, type);
    }

    private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> collection, Class<E> type) {
        EnumSet<E> result = EnumSet.allOf(type);
        result.removeAll(collection);
        return result;
    }

    @Deprecated
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$SetView.class */
    public static abstract class SetView<E> extends AbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public abstract UnmodifiableIterator<E> iterator();

        private SetView() {
        }

        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf((Collection) this);
        }

        @CanIgnoreReturnValue
        public <S extends Set<E>> S copyInto(S set) {
            set.addAll(this);
            return set;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean addAll(Collection<? extends E> newElements) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean removeAll(Collection<?> oldElements) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean removeIf(Predicate<? super E> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean retainAll(Collection<?> elementsToKeep) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }
    }

    public static <E> SetView<E> union(final Set<? extends E> set1, final Set<? extends E> set2) {
        Preconditions.checkNotNull(set1, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() { // from class: com.google.common.collect.Sets.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int size = set1.size();
                for (Object obj : set2) {
                    if (!set1.contains(obj)) {
                        size++;
                    }
                }
                return size;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return set1.isEmpty() && set2.isEmpty();
            }

            @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() { // from class: com.google.common.collect.Sets.1.1
                    final Iterator<? extends E> itr1;
                    final Iterator<? extends E> itr2;

                    {
                        this.itr1 = set1.iterator();
                        this.itr2 = set2.iterator();
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: java.util.Set */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v10, types: [E, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r0v18, types: [E, java.lang.Object] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    @Override // com.google.common.collect.AbstractIterator
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    protected E computeNext() {
                        /*
                            r3 = this;
                            r0 = r3
                            java.util.Iterator<? extends E> r0 = r0.itr1
                            boolean r0 = r0.hasNext()
                            if (r0 == 0) goto L_0x0016
                            r0 = r3
                            java.util.Iterator<? extends E> r0 = r0.itr1
                            java.lang.Object r0 = r0.next()
                            return r0
                        L_0x0016:
                            r0 = r3
                            java.util.Iterator<? extends E> r0 = r0.itr2
                            boolean r0 = r0.hasNext()
                            if (r0 == 0) goto L_0x0041
                            r0 = r3
                            java.util.Iterator<? extends E> r0 = r0.itr2
                            java.lang.Object r0 = r0.next()
                            r4 = r0
                            r0 = r3
                            com.google.common.collect.Sets$1 r0 = com.google.common.collect.Sets.C03371.this
                            java.util.Set r0 = r5
                            r1 = r4
                            boolean r0 = r0.contains(r1)
                            if (r0 != 0) goto L_0x003e
                            r0 = r4
                            return r0
                        L_0x003e:
                            goto L_0x0016
                        L_0x0041:
                            r0 = r3
                            java.lang.Object r0 = r0.endOfData()
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.C03371.C03381.computeNext():java.lang.Object");
                    }
                };
            }

            @Override // java.util.Collection
            public Stream<E> stream() {
                Stream stream = set1.stream();
                Stream stream2 = set2.stream();
                Set set = set1;
                return Stream.concat(stream, stream2.filter(e -> {
                    return !set.contains(e);
                }));
            }

            @Override // java.util.Collection
            public Stream<E> parallelStream() {
                return (Stream) stream().parallel();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object object) {
                return set1.contains(object) || set2.contains(object);
            }

            @Override // com.google.common.collect.Sets.SetView
            public <S extends Set<E>> S copyInto(S set) {
                set.addAll(set1);
                set.addAll(set2);
                return set;
            }

            @Override // com.google.common.collect.Sets.SetView
            public ImmutableSet<E> immutableCopy() {
                return new ImmutableSet.Builder().addAll((Iterable) set1).addAll((Iterable) set2).build();
            }
        };
    }

    public static <E> SetView<E> intersection(final Set<E> set1, final Set<?> set2) {
        Preconditions.checkNotNull(set1, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() { // from class: com.google.common.collect.Sets.2
            @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() { // from class: com.google.common.collect.Sets.2.1
                    final Iterator<E> itr;

                    {
                        this.itr = set1.iterator();
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: java.util.Set */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v7, types: [E, java.lang.Object] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    @Override // com.google.common.collect.AbstractIterator
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    protected E computeNext() {
                        /*
                            r3 = this;
                        L_0x0000:
                            r0 = r3
                            java.util.Iterator<E> r0 = r0.itr
                            boolean r0 = r0.hasNext()
                            if (r0 == 0) goto L_0x002b
                            r0 = r3
                            java.util.Iterator<E> r0 = r0.itr
                            java.lang.Object r0 = r0.next()
                            r4 = r0
                            r0 = r3
                            com.google.common.collect.Sets$2 r0 = com.google.common.collect.Sets.C03392.this
                            java.util.Set r0 = r6
                            r1 = r4
                            boolean r0 = r0.contains(r1)
                            if (r0 == 0) goto L_0x0028
                            r0 = r4
                            return r0
                        L_0x0028:
                            goto L_0x0000
                        L_0x002b:
                            r0 = r3
                            java.lang.Object r0 = r0.endOfData()
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.C03392.C03401.computeNext():java.lang.Object");
                    }
                };
            }

            @Override // java.util.Collection
            public Stream<E> stream() {
                Stream stream = set1.stream();
                Set set = set2;
                set.getClass();
                return stream.filter(this::contains);
            }

            @Override // java.util.Collection
            public Stream<E> parallelStream() {
                Stream parallelStream = set1.parallelStream();
                Set set = set2;
                set.getClass();
                return parallelStream.filter(this::contains);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int size = 0;
                for (Object obj : set1) {
                    if (set2.contains(obj)) {
                        size++;
                    }
                }
                return size;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return Collections.disjoint(set2, set1);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object object) {
                return set1.contains(object) && set2.contains(object);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean containsAll(Collection<?> collection) {
                return set1.containsAll(collection) && set2.containsAll(collection);
            }
        };
    }

    public static <E> SetView<E> difference(final Set<E> set1, final Set<?> set2) {
        Preconditions.checkNotNull(set1, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() { // from class: com.google.common.collect.Sets.3
            @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() { // from class: com.google.common.collect.Sets.3.1
                    final Iterator<E> itr;

                    {
                        this.itr = set1.iterator();
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: java.util.Set */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v7, types: [E, java.lang.Object] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    @Override // com.google.common.collect.AbstractIterator
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    protected E computeNext() {
                        /*
                            r3 = this;
                        L_0x0000:
                            r0 = r3
                            java.util.Iterator<E> r0 = r0.itr
                            boolean r0 = r0.hasNext()
                            if (r0 == 0) goto L_0x002b
                            r0 = r3
                            java.util.Iterator<E> r0 = r0.itr
                            java.lang.Object r0 = r0.next()
                            r4 = r0
                            r0 = r3
                            com.google.common.collect.Sets$3 r0 = com.google.common.collect.Sets.C03413.this
                            java.util.Set r0 = r6
                            r1 = r4
                            boolean r0 = r0.contains(r1)
                            if (r0 != 0) goto L_0x0028
                            r0 = r4
                            return r0
                        L_0x0028:
                            goto L_0x0000
                        L_0x002b:
                            r0 = r3
                            java.lang.Object r0 = r0.endOfData()
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.C03413.C03421.computeNext():java.lang.Object");
                    }
                };
            }

            @Override // java.util.Collection
            public Stream<E> stream() {
                Stream stream = set1.stream();
                Set set = set2;
                return stream.filter(e -> {
                    return !set.contains(e);
                });
            }

            @Override // java.util.Collection
            public Stream<E> parallelStream() {
                Stream parallelStream = set1.parallelStream();
                Set set = set2;
                return parallelStream.filter(e -> {
                    return !set.contains(e);
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int size = 0;
                for (Object obj : set1) {
                    if (!set2.contains(obj)) {
                        size++;
                    }
                }
                return size;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return set2.containsAll(set1);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object element) {
                return set1.contains(element) && !set2.contains(element);
            }
        };
    }

    public static <E> SetView<E> symmetricDifference(final Set<? extends E> set1, final Set<? extends E> set2) {
        Preconditions.checkNotNull(set1, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() { // from class: com.google.common.collect.Sets.4
            @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<E> iterator() {
                final Iterator it = set1.iterator();
                final Iterator it2 = set2.iterator();
                return new AbstractIterator<E>() { // from class: com.google.common.collect.Sets.4.1
                    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: java.util.Set */
                    /* JADX DEBUG: Multi-variable search result rejected for r0v21, resolved type: java.util.Set */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v10, types: [E, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r0v18, types: [E, java.lang.Object] */
                    /* JADX WARNING: Unknown variable types count: 2 */
                    @Override // com.google.common.collect.AbstractIterator
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public E computeNext() {
                        /*
                            r3 = this;
                        L_0x0000:
                            r0 = r3
                            java.util.Iterator r0 = r0
                            boolean r0 = r0.hasNext()
                            if (r0 == 0) goto L_0x002b
                            r0 = r3
                            java.util.Iterator r0 = r0
                            java.lang.Object r0 = r0.next()
                            r4 = r0
                            r0 = r3
                            com.google.common.collect.Sets$4 r0 = com.google.common.collect.Sets.C03434.this
                            java.util.Set r0 = r6
                            r1 = r4
                            boolean r0 = r0.contains(r1)
                            if (r0 != 0) goto L_0x0028
                            r0 = r4
                            return r0
                        L_0x0028:
                            goto L_0x0000
                        L_0x002b:
                            r0 = r3
                            java.util.Iterator r0 = r0
                            boolean r0 = r0.hasNext()
                            if (r0 == 0) goto L_0x0056
                            r0 = r3
                            java.util.Iterator r0 = r0
                            java.lang.Object r0 = r0.next()
                            r4 = r0
                            r0 = r3
                            com.google.common.collect.Sets$4 r0 = com.google.common.collect.Sets.C03434.this
                            java.util.Set r0 = r5
                            r1 = r4
                            boolean r0 = r0.contains(r1)
                            if (r0 != 0) goto L_0x0053
                            r0 = r4
                            return r0
                        L_0x0053:
                            goto L_0x002b
                        L_0x0056:
                            r0 = r3
                            java.lang.Object r0 = r0.endOfData()
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.C03434.C03441.computeNext():java.lang.Object");
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int size = 0;
                for (Object obj : set1) {
                    if (!set2.contains(obj)) {
                        size++;
                    }
                }
                for (Object obj2 : set2) {
                    if (!set1.contains(obj2)) {
                        size++;
                    }
                }
                return size;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return set1.equals(set2);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object element) {
                return set1.contains(element) ^ set2.contains(element);
            }
        };
    }

    public static <E> Set<E> filter(Set<E> unfiltered, com.google.common.base.Predicate<? super E> predicate) {
        if (unfiltered instanceof SortedSet) {
            return filter((SortedSet) unfiltered, (com.google.common.base.Predicate) predicate);
        }
        if (!(unfiltered instanceof FilteredSet)) {
            return new FilteredSet((Set) Preconditions.checkNotNull(unfiltered), (com.google.common.base.Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet<E> filtered = (FilteredSet) unfiltered;
        return new FilteredSet((Set) filtered.unfiltered, Predicates.and(filtered.predicate, predicate));
    }

    public static <E> SortedSet<E> filter(SortedSet<E> unfiltered, com.google.common.base.Predicate<? super E> predicate) {
        if (!(unfiltered instanceof FilteredSet)) {
            return new FilteredSortedSet((SortedSet) Preconditions.checkNotNull(unfiltered), (com.google.common.base.Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet<E> filtered = (FilteredSet) unfiltered;
        return new FilteredSortedSet((SortedSet) filtered.unfiltered, Predicates.and(filtered.predicate, predicate));
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> filter(NavigableSet<E> unfiltered, com.google.common.base.Predicate<? super E> predicate) {
        if (!(unfiltered instanceof FilteredSet)) {
            return new FilteredNavigableSet((NavigableSet) Preconditions.checkNotNull(unfiltered), (com.google.common.base.Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet<E> filtered = (FilteredSet) unfiltered;
        return new FilteredNavigableSet((NavigableSet) filtered.unfiltered, Predicates.and(filtered.predicate, predicate));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$FilteredSet.class */
    public static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
        FilteredSet(Set<E> unfiltered, com.google.common.base.Predicate<? super E> predicate) {
            super(unfiltered, predicate);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public boolean equals(Object object) {
            return Sets.equalsImpl(this, object);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$FilteredSortedSet.class */
    public static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
        FilteredSortedSet(SortedSet<E> unfiltered, com.google.common.base.Predicate<? super E> predicate) {
            super(unfiltered, predicate);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.unfiltered).comparator();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E fromElement, E toElement) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).subSet(fromElement, toElement), this.predicate);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E toElement) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).headSet(toElement), this.predicate);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E fromElement) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).tailSet(fromElement), this.predicate);
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) Iterators.find(this.unfiltered.iterator(), this.predicate);
        }

        @Override // java.util.SortedSet
        public E last() {
            SortedSet<E> sortedUnfiltered = (SortedSet) this.unfiltered;
            while (true) {
                E element = sortedUnfiltered.last();
                if (this.predicate.apply(element)) {
                    return element;
                }
                sortedUnfiltered = sortedUnfiltered.headSet(element);
            }
        }
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$FilteredNavigableSet.class */
    public static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
        FilteredNavigableSet(NavigableSet<E> unfiltered, com.google.common.base.Predicate<? super E> predicate) {
            super(unfiltered, predicate);
        }

        NavigableSet<E> unfiltered() {
            return (NavigableSet) this.unfiltered;
        }

        @Override // java.util.NavigableSet
        public E lower(E e) {
            return (E) Iterators.find(unfiltered().headSet(e, false).descendingIterator(), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        public E floor(E e) {
            return (E) Iterators.find(unfiltered().headSet(e, true).descendingIterator(), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            return (E) Iterables.find(unfiltered().tailSet(e, true), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            return (E) Iterables.find(unfiltered().tailSet(e, false), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) Iterables.removeFirstMatching(unfiltered(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) Iterables.removeFirstMatching(unfiltered().descendingSet(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return Sets.filter((NavigableSet) unfiltered().descendingSet(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.filter(unfiltered().descendingIterator(), this.predicate);
        }

        @Override // com.google.common.collect.Sets.FilteredSortedSet, java.util.SortedSet
        public E last() {
            return (E) Iterators.find(unfiltered().descendingIterator(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
            return Sets.filter((NavigableSet) unfiltered().subSet(fromElement, fromInclusive, toElement, toInclusive), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            return Sets.filter((NavigableSet) unfiltered().headSet(toElement, inclusive), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            return Sets.filter((NavigableSet) unfiltered().tailSet(fromElement, inclusive), this.predicate);
        }
    }

    public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> sets) {
        return CartesianSet.create(sets);
    }

    @SafeVarargs
    public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... sets) {
        return cartesianProduct(Arrays.asList(sets));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$CartesianSet.class */
    public static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {
        private final transient ImmutableList<ImmutableSet<E>> axes;
        private final transient CartesianList<E> delegate;

        static <E> Set<List<E>> create(List<? extends Set<? extends E>> sets) {
            ImmutableList.Builder<ImmutableSet<E>> axesBuilder = new ImmutableList.Builder<>(sets.size());
            for (Set<? extends E> set : sets) {
                ImmutableSet<E> copy = ImmutableSet.copyOf((Collection) set);
                if (copy.isEmpty()) {
                    return ImmutableSet.m1396of();
                }
                axesBuilder.add((ImmutableList.Builder<ImmutableSet<E>>) copy);
            }
            final ImmutableList<ImmutableSet<E>> axes = axesBuilder.build();
            return new CartesianSet(axes, new CartesianList(new ImmutableList<List<E>>() { // from class: com.google.common.collect.Sets.CartesianSet.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return axes.size();
                }

                @Override // java.util.List
                public List<E> get(int index) {
                    return ((ImmutableSet) axes.get(index)).asList();
                }

                @Override // com.google.common.collect.ImmutableCollection
                boolean isPartialView() {
                    return true;
                }
            }));
        }

        private CartesianSet(ImmutableList<ImmutableSet<E>> axes, CartesianList<E> delegate) {
            this.axes = axes;
            this.delegate = delegate;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<List<E>> delegate() {
            return this.delegate;
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public boolean equals(Object object) {
            if (object instanceof CartesianSet) {
                return this.axes.equals(((CartesianSet) object).axes);
            }
            return equals(object);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public int hashCode() {
            int adjust = size() - 1;
            for (int i = 0; i < this.axes.size(); i++) {
                adjust = ((adjust * 31) ^ -1) ^ -1;
            }
            int hash = 1;
            UnmodifiableIterator<ImmutableSet<E>> it = this.axes.iterator();
            while (it.hasNext()) {
                Set<E> axis = it.next();
                hash = (((31 * hash) + ((size() / axis.size()) * axis.hashCode())) ^ -1) ^ -1;
            }
            return ((hash + adjust) ^ -1) ^ -1;
        }
    }

    @GwtCompatible(serializable = false)
    public static <E> Set<Set<E>> powerSet(Set<E> set) {
        return new PowerSet(set);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$SubSet.class */
    public static final class SubSet<E> extends AbstractSet<E> {
        private final ImmutableMap<E, Integer> inputSet;
        private final int mask;

        SubSet(ImmutableMap<E, Integer> inputSet, int mask) {
            this.inputSet = inputSet;
            this.mask = mask;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<E> iterator() {
            return new UnmodifiableIterator<E>() { // from class: com.google.common.collect.Sets.SubSet.1
                final ImmutableList<E> elements;
                int remainingSetBits;

                {
                    this.elements = SubSet.this.inputSet.keySet().asList();
                    this.remainingSetBits = SubSet.this.mask;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.remainingSetBits != 0;
                }

                @Override // java.util.Iterator
                public E next() {
                    int index = Integer.numberOfTrailingZeros(this.remainingSetBits);
                    if (index == 32) {
                        throw new NoSuchElementException();
                    }
                    this.remainingSetBits &= (1 << index) ^ -1;
                    return this.elements.get(index);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Integer.bitCount(this.mask);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            Integer index = this.inputSet.get(o);
            return (index == null || (this.mask & (1 << index.intValue())) == 0) ? false : true;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$PowerSet.class */
    public static final class PowerSet<E> extends AbstractSet<Set<E>> {
        final ImmutableMap<E, Integer> inputSet;

        PowerSet(Set<E> input) {
            Preconditions.checkArgument(input.size() <= 30, "Too many elements to create power set: %s > 30", input.size());
            this.inputSet = Maps.indexMap(input);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.inputSet.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Set<E>> iterator() {
            return new AbstractIndexedListIterator<Set<E>>(size()) { // from class: com.google.common.collect.Sets.PowerSet.1
                /* access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIndexedListIterator
                public Set<E> get(int setBits) {
                    return new SubSet(PowerSet.this.inputSet, setBits);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.inputSet.keySet().containsAll((Set) obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set, java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof PowerSet) {
                return this.inputSet.equals(((PowerSet) obj).inputSet);
            }
            return equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set, java.lang.Object
        public int hashCode() {
            return this.inputSet.keySet().hashCode() << (this.inputSet.size() - 1);
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return "powerSet(" + this.inputSet + ")";
        }
    }

    @Beta
    public static <E> Set<Set<E>> combinations(Set<E> set, final int size) {
        final ImmutableMap<E, Integer> index = Maps.indexMap(set);
        CollectPreconditions.checkNonnegative(size, "size");
        Preconditions.checkArgument(size <= index.size(), "size (%s) must be <= set.size() (%s)", size, index.size());
        if (size == 0) {
            return ImmutableSet.m1395of(ImmutableSet.m1396of());
        }
        if (size == index.size()) {
            return ImmutableSet.m1395of(index.keySet());
        }
        return new AbstractSet<Set<E>>() { // from class: com.google.common.collect.Sets.5
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object o) {
                if (!(o instanceof Set)) {
                    return false;
                }
                Set<?> s = (Set) o;
                return s.size() == size && index.keySet().containsAll(s);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Set<E>> iterator() {
                return new AbstractIterator<Set<E>>() { // from class: com.google.common.collect.Sets.5.1
                    final BitSet bits;

                    {
                        this.bits = new BitSet(index.size());
                    }

                    /* access modifiers changed from: protected */
                    @Override // com.google.common.collect.AbstractIterator
                    public Set<E> computeNext() {
                        if (this.bits.isEmpty()) {
                            this.bits.set(0, size);
                        } else {
                            int firstSetBit = this.bits.nextSetBit(0);
                            int bitToFlip = this.bits.nextClearBit(firstSetBit);
                            if (bitToFlip == index.size()) {
                                return (Set) endOfData();
                            }
                            this.bits.set(0, (bitToFlip - firstSetBit) - 1);
                            this.bits.clear((bitToFlip - firstSetBit) - 1, bitToFlip);
                            this.bits.set(bitToFlip);
                        }
                        final BitSet copy = (BitSet) this.bits.clone();
                        return new AbstractSet<E>() { // from class: com.google.common.collect.Sets.5.1.1
                            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                            public boolean contains(Object o) {
                                Integer i = (Integer) index.get(o);
                                return i != null && copy.get(i.intValue());
                            }

                            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
                            public Iterator<E> iterator() {
                                return new AbstractIterator<E>() { // from class: com.google.common.collect.Sets.5.1.1.1

                                    /* renamed from: i */
                                    int f285i = -1;

                                    @Override // com.google.common.collect.AbstractIterator
                                    protected E computeNext() {
                                        this.f285i = copy.nextSetBit(this.f285i + 1);
                                        if (this.f285i == -1) {
                                            return endOfData();
                                        }
                                        return index.keySet().asList().get(this.f285i);
                                    }
                                };
                            }

                            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                            public int size() {
                                return size;
                            }
                        };
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return IntMath.binomial(index.size(), size);
            }

            @Override // java.util.AbstractCollection, java.lang.Object
            public String toString() {
                return "Sets.combinations(" + index.keySet() + ", " + size + ")";
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static int hashCodeImpl(Set<?> s) {
        int hashCode = 0;
        Iterator<?> it = s.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            hashCode = ((hashCode + (o != null ? o.hashCode() : 0)) ^ -1) ^ -1;
        }
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public static boolean equalsImpl(Set<?> s, Object object) {
        if (s == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set<?> o = (Set) object;
        try {
            if (s.size() == o.size()) {
                if (s.containsAll(o)) {
                    return true;
                }
            }
            return false;
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> set) {
        if ((set instanceof ImmutableCollection) || (set instanceof UnmodifiableNavigableSet)) {
            return set;
        }
        return new UnmodifiableNavigableSet(set);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$UnmodifiableNavigableSet.class */
    public static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {
        private final NavigableSet<E> delegate;
        private final SortedSet<E> unmodifiableDelegate;
        private transient UnmodifiableNavigableSet<E> descendingSet;
        private static final long serialVersionUID = 0;

        UnmodifiableNavigableSet(NavigableSet<E> delegate) {
            this.delegate = (NavigableSet) Preconditions.checkNotNull(delegate);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(delegate);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.delegate.stream();
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.delegate.parallelStream();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> action) {
            this.delegate.forEach(action);
        }

        @Override // java.util.NavigableSet
        public E lower(E e) {
            return this.delegate.lower(e);
        }

        @Override // java.util.NavigableSet
        public E floor(E e) {
            return this.delegate.floor(e);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            return this.delegate.ceiling(e);
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            return this.delegate.higher(e);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> result = this.descendingSet;
            if (result == null) {
                UnmodifiableNavigableSet<E> unmodifiableNavigableSet = new UnmodifiableNavigableSet<>(this.delegate.descendingSet());
                this.descendingSet = unmodifiableNavigableSet;
                result = unmodifiableNavigableSet;
                result.descendingSet = this;
            }
            return result;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
            return Sets.unmodifiableNavigableSet(this.delegate.subSet(fromElement, fromInclusive, toElement, toInclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            return Sets.unmodifiableNavigableSet(this.delegate.headSet(toElement, inclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            return Sets.unmodifiableNavigableSet(this.delegate.tailSet(fromElement, inclusive));
        }
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> navigableSet) {
        return Synchronized.navigableSet(navigableSet);
    }

    /* access modifiers changed from: package-private */
    public static boolean removeAllImpl(Set<?> set, Iterator<?> iterator) {
        boolean changed = false;
        while (iterator.hasNext()) {
            changed |= set.remove(iterator.next());
        }
        return changed;
    }

    /* access modifiers changed from: package-private */
    public static boolean removeAllImpl(Set<?> set, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return removeAllImpl(set, collection.iterator());
        }
        return Iterators.removeAll(set.iterator(), collection);
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/Sets$DescendingSet.class */
    static class DescendingSet<E> extends ForwardingNavigableSet<E> {
        private final NavigableSet<E> forward;

        /* access modifiers changed from: package-private */
        public DescendingSet(NavigableSet<E> forward) {
            this.forward = forward;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public NavigableSet<E> delegate() {
            return this.forward;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E lower(E e) {
            return this.forward.higher(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E floor(E e) {
            return this.forward.ceiling(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E ceiling(E e) {
            return this.forward.floor(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E higher(E e) {
            return this.forward.lower(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E pollFirst() {
            return this.forward.pollLast();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E pollLast() {
            return this.forward.pollFirst();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return this.forward;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return this.forward.iterator();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
            return this.forward.subSet(toElement, toInclusive, fromElement, fromInclusive).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> subSet(E fromElement, E toElement) {
            return standardSubSet(fromElement, toElement);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            return this.forward.tailSet(toElement, inclusive).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> headSet(E toElement) {
            return standardHeadSet(toElement);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            return this.forward.headSet(fromElement, inclusive).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> tailSet(E fromElement) {
            return standardTailSet(fromElement);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> forwardComparator = this.forward.comparator();
            if (forwardComparator == null) {
                return Ordering.natural().reverse();
            }
            return reverse(forwardComparator);
        }

        private static <T> Ordering<T> reverse(Comparator<T> forward) {
            return Ordering.from(forward).reverse();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public E first() {
            return this.forward.last();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public E last() {
            return this.forward.first();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.forward.descendingIterator();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] array) {
            return (T[]) standardToArray(array);
        }

        @Override // com.google.common.collect.ForwardingObject, java.lang.Object
        public String toString() {
            return standardToString();
        }
    }

    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>> NavigableSet<K> subSet(NavigableSet<K> set, Range<K> range) {
        if (set.comparator() != null && set.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            Preconditions.checkArgument(set.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            return set.subSet(range.lowerEndpoint(), range.lowerBoundType() == BoundType.CLOSED, range.upperEndpoint(), range.upperBoundType() == BoundType.CLOSED);
        } else if (range.hasLowerBound()) {
            return set.tailSet(range.lowerEndpoint(), range.lowerBoundType() == BoundType.CLOSED);
        } else if (!range.hasUpperBound()) {
            return (NavigableSet) Preconditions.checkNotNull(set);
        } else {
            return set.headSet(range.upperEndpoint(), range.upperBoundType() == BoundType.CLOSED);
        }
    }
}
