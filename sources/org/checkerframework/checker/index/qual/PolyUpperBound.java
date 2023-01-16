package org.checkerframework.checker.index.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.PolymorphicQualifier;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@PolymorphicQualifier(UpperBoundUnknown.class)
/* loaded from: grasscutter.jar:org/checkerframework/checker/index/qual/PolyUpperBound.class */
public @interface PolyUpperBound {
}
