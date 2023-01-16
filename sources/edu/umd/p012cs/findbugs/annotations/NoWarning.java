package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Deprecated
/* renamed from: edu.umd.cs.findbugs.annotations.NoWarning */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/NoWarning.class */
public @interface NoWarning {
    String value();

    Confidence confidence() default Confidence.LOW;

    int rank() default 20;

    int num() default 0;
}
