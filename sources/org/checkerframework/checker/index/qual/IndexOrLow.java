package org.checkerframework.checker.index.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
/* loaded from: grasscutter.jar:org/checkerframework/checker/index/qual/IndexOrLow.class */
public @interface IndexOrLow {
    String[] value();
}
