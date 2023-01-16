package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Arrays;
import java.util.Collection;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableMultiset.class */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final ImmutableMultiset<Object> EMPTY = create(ImmutableList.m1438of());
    @VisibleForTesting
    static final double MAX_LOAD_FACTOR = 1.0d;
    @VisibleForTesting
    static final double HASH_FLOODING_FPP = 0.001d;
    @VisibleForTesting
    static final int MAX_HASH_BUCKET_LENGTH = 9;
    private final transient Multisets.ImmutableEntry<E>[] entries;
    private final transient Multisets.ImmutableEntry<E>[] hashTable;
    private final transient int size;
    private final transient int hashCode;
    @LazyInit
    private transient ImmutableSet<E> elementSet;

    /* JADX WARN: Type inference failed for: r0v46, types: [long] */
    /* access modifiers changed from: package-private */
    public static <E> ImmutableMultiset<E> create(Collection<? extends Multiset.Entry<? extends E>> entries) {
        Multisets.ImmutableEntry<E> newEntry;
        int distinct = entries.size();
        Multisets.ImmutableEntry<E>[] entryArray = new Multisets.ImmutableEntry[distinct];
        if (distinct == 0) {
            return new RegularImmutableMultiset(entryArray, null, 0, 0, ImmutableSet.m1396of());
        }
        int tableSize = Hashing.closedTableSize(distinct, 1.0d);
        int mask = tableSize - 1;
        Multisets.ImmutableEntry<E>[] hashTable = new Multisets.ImmutableEntry[tableSize];
        int index = 0;
        int hashCode = 0;
        char c = 0;
        for (Multiset.Entry<? extends E> entry : entries) {
            Object checkNotNull = Preconditions.checkNotNull(entry.getElement());
            int count = entry.getCount();
            int hash = checkNotNull.hashCode();
            int bucket = Hashing.smear(hash) & mask;
            Multisets.ImmutableEntry<E> bucketHead = hashTable[bucket];
            if (bucketHead == null) {
                newEntry = (entry instanceof Multisets.ImmutableEntry) && !(entry instanceof NonTerminalEntry) ? (Multisets.ImmutableEntry) entry : new Multisets.ImmutableEntry<>(checkNotNull, count);
            } else {
                newEntry = new NonTerminalEntry<>(checkNotNull, count, bucketHead);
            }
            hashCode += hash ^ count;
            index++;
            entryArray[index] = newEntry;
            hashTable[bucket] = newEntry;
            c += (long) count;
        }
        if (hashFloodingDetected(hashTable)) {
            return JdkBackedImmutableMultiset.create(ImmutableList.asImmutableList(entryArray));
        }
        return new RegularImmutableMultiset(entryArray, hashTable, Ints.saturatedCast(c), hashCode, null);
    }

    private static boolean hashFloodingDetected(Multisets.ImmutableEntry<?>[] hashTable) {
        for (int i = 0; i < hashTable.length; i++) {
            int bucketLength = 0;
            for (Multisets.ImmutableEntry<?> entry = hashTable[i]; entry != null; entry = entry.nextInBucket()) {
                bucketLength++;
                if (bucketLength > 9) {
                    return true;
                }
            }
        }
        return false;
    }

    private RegularImmutableMultiset(Multisets.ImmutableEntry<E>[] entries, Multisets.ImmutableEntry<E>[] hashTable, int size, int hashCode, ImmutableSet<E> elementSet) {
        this.entries = entries;
        this.hashTable = hashTable;
        this.size = size;
        this.hashCode = hashCode;
        this.elementSet = elementSet;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableMultiset$NonTerminalEntry.class */
    public static final class NonTerminalEntry<E> extends Multisets.ImmutableEntry<E> {
        private final Multisets.ImmutableEntry<E> nextInBucket;

        NonTerminalEntry(E element, int count, Multisets.ImmutableEntry<E> nextInBucket) {
            super(element, count);
            this.nextInBucket = nextInBucket;
        }

        @Override // com.google.common.collect.Multisets.ImmutableEntry
        public Multisets.ImmutableEntry<E> nextInBucket() {
            return this.nextInBucket;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object element) {
        Multisets.ImmutableEntry<E>[] hashTable = this.hashTable;
        if (element == null || hashTable == null) {
            return 0;
        }
        for (Multisets.ImmutableEntry<E> entry = hashTable[Hashing.smearedHash(element) & (hashTable.length - 1)]; entry != null; entry = entry.nextInBucket()) {
            if (Objects.equal(element, entry.getElement())) {
                return entry.getCount();
            }
        }
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> result = this.elementSet;
        if (result != null) {
            return result;
        }
        ImmutableMultiset.ElementSet elementSet = new ImmutableMultiset.ElementSet(Arrays.asList(this.entries), this);
        this.elementSet = elementSet;
        return elementSet;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> getEntry(int index) {
        return this.entries[index];
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection, java.lang.Object, com.google.common.collect.Multiset
    public int hashCode() {
        return this.hashCode;
    }
}
