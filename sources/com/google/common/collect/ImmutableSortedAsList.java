package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.Comparator;
import java.util.Spliterator;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSortedAsList.class */
final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements SortedIterable<E> {
    /* access modifiers changed from: package-private */
    public ImmutableSortedAsList(ImmutableSortedSet<E> backingSet, ImmutableList<E> backingList) {
        super(backingSet, backingList);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.RegularImmutableAsList, com.google.common.collect.ImmutableAsList
    public ImmutableSortedSet<E> delegateCollection() {
        return (ImmutableSortedSet) delegateCollection();
    }

    @Override // com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return delegateCollection().comparator();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    @GwtIncompatible
    public int indexOf(Object target) {
        int index = delegateCollection().indexOf(target);
        if (index < 0 || !get(index).equals(target)) {
            return -1;
        }
        return index;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    @GwtIncompatible
    public int lastIndexOf(Object target) {
        return indexOf(target);
    }

    @Override // com.google.common.collect.ImmutableAsList, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object target) {
        return indexOf(target) >= 0;
    }

    @Override // com.google.common.collect.ImmutableList
    @GwtIncompatible
    ImmutableList<E> subListUnchecked(int fromIndex, int toIndex) {
        return new RegularImmutableSortedSet(subListUnchecked(fromIndex, toIndex), comparator()).asList();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        int size = size();
        ImmutableList<? extends E> delegateList = delegateList();
        delegateList.getClass();
        return CollectSpliterators.indexed(size, RetcodeOuterClass.Retcode.RET_MAIL_PARA_ERR_VALUE, this::get, comparator());
    }
}
