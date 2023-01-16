package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/FilteredMultimap.class */
public interface FilteredMultimap<K, V> extends Multimap<K, V> {
    Multimap<K, V> unfiltered();

    Predicate<? super Map.Entry<K, V>> entryPredicate();
}
