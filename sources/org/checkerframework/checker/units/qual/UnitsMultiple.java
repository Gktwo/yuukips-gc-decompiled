package org.checkerframework.checker.units.qual;

import java.lang.annotation.Annotation;

/* loaded from: grasscutter.jar:org/checkerframework/checker/units/qual/UnitsMultiple.class */
public @interface UnitsMultiple {
    Class<? extends Annotation> quantity();

    Prefix prefix() default Prefix.one;
}
