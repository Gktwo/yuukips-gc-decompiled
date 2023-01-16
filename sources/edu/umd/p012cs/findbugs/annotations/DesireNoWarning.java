package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Deprecated
/* renamed from: edu.umd.cs.findbugs.annotations.DesireNoWarning */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/DesireNoWarning.class */
public @interface DesireNoWarning {
    String value();

    @Deprecated
    Priority priority() default Priority.LOW;

    Confidence confidence() default Confidence.LOW;

    int num() default 0;
}
