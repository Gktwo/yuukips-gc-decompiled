package org.quartz;

import java.io.Serializable;
import org.quartz.utils.Key;

/* loaded from: grasscutter.jar:org/quartz/Matcher.class */
public interface Matcher<T extends Key<?>> extends Serializable {
    boolean isMatch(T t);

    @Override // java.lang.Object
    int hashCode();

    @Override // java.lang.Object
    boolean equals(Object obj);
}
