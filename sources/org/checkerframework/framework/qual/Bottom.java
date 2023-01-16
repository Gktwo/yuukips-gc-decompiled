package org.checkerframework.framework.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@TargetLocations({TypeUseLocation.EXPLICIT_LOWER_BOUND, TypeUseLocation.EXPLICIT_UPPER_BOUND})
@SubtypeOf({})
/* loaded from: grasscutter.jar:org/checkerframework/framework/qual/Bottom.class */
public @interface Bottom {
}
