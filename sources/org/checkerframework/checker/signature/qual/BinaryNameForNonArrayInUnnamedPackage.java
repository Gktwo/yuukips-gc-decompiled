package org.checkerframework.checker.signature.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.ImplicitFor;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@ImplicitFor(stringPatterns = {"^[A-Za-z_][A-Za-z_0-9]*(\\$[A-Za-z_0-9]+)*$"})
@SubtypeOf({BinaryNameForNonArray.class, BinaryNameInUnnamedPackage.class, InternalFormForNonArray.class})
/* loaded from: grasscutter.jar:org/checkerframework/checker/signature/qual/BinaryNameForNonArrayInUnnamedPackage.class */
public @interface BinaryNameForNonArrayInUnnamedPackage {
}
