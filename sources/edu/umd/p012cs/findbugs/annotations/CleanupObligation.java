package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: edu.umd.cs.findbugs.annotations.CleanupObligation */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/CleanupObligation.class */
public @interface CleanupObligation {
}
