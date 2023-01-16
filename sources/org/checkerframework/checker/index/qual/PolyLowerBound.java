package org.checkerframework.checker.index.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.PolymorphicQualifier;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@PolymorphicQualifier(LowerBoundUnknown.class)
/* loaded from: grasscutter.jar:org/checkerframework/checker/index/qual/PolyLowerBound.class */
public @interface PolyLowerBound {
}
