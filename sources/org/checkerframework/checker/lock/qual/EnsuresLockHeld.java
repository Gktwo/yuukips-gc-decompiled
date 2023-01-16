package org.checkerframework.checker.lock.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.InheritedAnnotation;
import org.checkerframework.framework.qual.PostconditionAnnotation;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@PostconditionAnnotation(qualifier = LockHeld.class)
@InheritedAnnotation
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/checkerframework/checker/lock/qual/EnsuresLockHeld.class */
public @interface EnsuresLockHeld {
    String[] value();
}
