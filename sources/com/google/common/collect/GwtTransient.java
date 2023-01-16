package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@GwtCompatible
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:com/google/common/collect/GwtTransient.class */
@interface GwtTransient {
}
