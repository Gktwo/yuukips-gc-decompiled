package com.mchange.p009v2.util;

import java.util.Comparator;

/* renamed from: com.mchange.v2.util.ComparatorUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/util/ComparatorUtils.class */
public final class ComparatorUtils {
    public static Comparator reverse(final Comparator comparator) {
        return new Comparator() { // from class: com.mchange.v2.util.ComparatorUtils.1
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                return -comparator.compare(obj, obj2);
            }
        };
    }
}
