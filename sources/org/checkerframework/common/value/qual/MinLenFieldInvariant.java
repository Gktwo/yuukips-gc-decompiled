package org.checkerframework.common.value.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.TYPE})
/* loaded from: grasscutter.jar:org/checkerframework/common/value/qual/MinLenFieldInvariant.class */
public @interface MinLenFieldInvariant {
    int[] minLen();

    String[] field();
}
