package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.function.Consumer;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableAsList.class */
public class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    /* access modifiers changed from: package-private */
    public RegularImmutableAsList(ImmutableCollection<E> delegate, ImmutableList<? extends E> delegateList) {
        this.delegate = delegate;
        this.delegateList = delegateList;
    }

    /* access modifiers changed from: package-private */
    public RegularImmutableAsList(ImmutableCollection<E> delegate, Object[] array) {
        this(delegate, ImmutableList.asImmutableList(array));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableAsList
    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.google.common.collect.UnmodifiableListIterator<? extends E>, com.google.common.collect.UnmodifiableListIterator<E> */
    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<E> listIterator(int index) {
        return (UnmodifiableListIterator<? extends E>) this.delegateList.listIterator(index);
    }

    @Override // com.google.common.collect.ImmutableList, java.lang.Iterable
    @GwtIncompatible
    public void forEach(Consumer<? super E> action) {
        this.delegateList.forEach(action);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int copyIntoArray(Object[] dst, int offset) {
        return this.delegateList.copyIntoArray(dst, offset);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    @Override // java.util.List
    public E get(int index) {
        return (E) this.delegateList.get(index);
    }
}
