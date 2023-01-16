package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@Nonnull(when = When.UNKNOWN)
@TypeQualifierNickname
@Documented
@Retention(RetentionPolicy.CLASS)
/* renamed from: edu.umd.cs.findbugs.annotations.UnknownNullness */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/UnknownNullness.class */
public @interface UnknownNullness {
}
