package org.checkerframework.checker.index.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.JavaExpression;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@SubtypeOf({SearchIndexFor.class})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/checkerframework/checker/index/qual/NegativeIndexFor.class */
public @interface NegativeIndexFor {
    @JavaExpression
    String[] value();
}
