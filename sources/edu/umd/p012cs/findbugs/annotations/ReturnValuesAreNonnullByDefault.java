package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

@TypeQualifierDefault({ElementType.METHOD})
@Nonnull
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: edu.umd.cs.findbugs.annotations.ReturnValuesAreNonnullByDefault */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/ReturnValuesAreNonnullByDefault.class */
public @interface ReturnValuesAreNonnullByDefault {
}
