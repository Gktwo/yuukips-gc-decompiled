package org.checkerframework.checker.signature.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@SubtypeOf({SourceNameForNonInner.class, BinaryNameForNonArray.class})
/* loaded from: grasscutter.jar:org/checkerframework/checker/signature/qual/SourceNameForNonArrayNonInner.class */
public @interface SourceNameForNonArrayNonInner {
}
