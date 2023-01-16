package org.checkerframework.checker.index.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@SubtypeOf({LowerBoundUnknown.class})
/* loaded from: grasscutter.jar:org/checkerframework/checker/index/qual/GTENegativeOne.class */
public @interface GTENegativeOne {
}
