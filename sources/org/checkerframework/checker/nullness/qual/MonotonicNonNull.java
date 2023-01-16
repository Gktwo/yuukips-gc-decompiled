package org.checkerframework.checker.nullness.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.MonotonicQualifier;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE})
@MonotonicQualifier(NonNull.class)
@Documented
@SubtypeOf({Nullable.class})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/checkerframework/checker/nullness/qual/MonotonicNonNull.class */
public @interface MonotonicNonNull {
}
