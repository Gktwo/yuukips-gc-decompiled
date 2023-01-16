package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Deprecated
/* renamed from: edu.umd.cs.findbugs.annotations.DesireWarning */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/DesireWarning.class */
public @interface DesireWarning {
    String value();

    Confidence confidence() default Confidence.LOW;

    int rank() default 20;

    int num() default 1;
}
