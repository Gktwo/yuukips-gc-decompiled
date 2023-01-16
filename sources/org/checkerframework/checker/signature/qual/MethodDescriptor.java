package org.checkerframework.checker.signature.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@SubtypeOf({SignatureUnknown.class})
/* loaded from: grasscutter.jar:org/checkerframework/checker/signature/qual/MethodDescriptor.class */
public @interface MethodDescriptor {
}
