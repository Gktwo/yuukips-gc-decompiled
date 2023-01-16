package org.checkerframework.checker.regex.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf({UnknownRegex.class})
/* loaded from: grasscutter.jar:org/checkerframework/checker/regex/qual/Regex.class */
public @interface Regex {
    int value() default 0;
}
