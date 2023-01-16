package org.checkerframework.dataflow.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/checkerframework/dataflow/qual/Pure.class */
public @interface Pure {

    /* loaded from: grasscutter.jar:org/checkerframework/dataflow/qual/Pure$Kind.class */
    public enum Kind {
        SIDE_EFFECT_FREE,
        DETERMINISTIC
    }
}
