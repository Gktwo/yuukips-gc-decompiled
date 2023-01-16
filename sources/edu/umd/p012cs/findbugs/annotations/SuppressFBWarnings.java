package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
/* renamed from: edu.umd.cs.findbugs.annotations.SuppressFBWarnings */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/SuppressFBWarnings.class */
public @interface SuppressFBWarnings {
    String[] value() default {};

    String justification() default "";
}
