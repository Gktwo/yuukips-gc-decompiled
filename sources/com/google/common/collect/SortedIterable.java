package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/SortedIterable.class */
public interface SortedIterable<T> extends Iterable<T> {
    Comparator<? super T> comparator();

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    Iterator<T> iterator();
}
