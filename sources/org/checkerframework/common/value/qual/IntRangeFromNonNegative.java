package org.checkerframework.common.value.qual;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({})
@SubtypeOf({UnknownVal.class})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: grasscutter.jar:org/checkerframework/common/value/qual/IntRangeFromNonNegative.class */
public @interface IntRangeFromNonNegative {
}
