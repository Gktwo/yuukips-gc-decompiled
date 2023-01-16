package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Deprecated
/* renamed from: edu.umd.cs.findbugs.annotations.ExpectWarning */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/ExpectWarning.class */
public @interface ExpectWarning {
    String value();

    Confidence confidence() default Confidence.LOW;

    int rank() default 20;

    int num() default 1;
}
