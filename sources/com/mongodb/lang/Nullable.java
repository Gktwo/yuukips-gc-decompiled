package com.mongodb.lang;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Nonnull(when = When.MAYBE)
@TypeQualifierNickname
@Retention(RetentionPolicy.RUNTIME)
@Documented
/* loaded from: grasscutter.jar:com/mongodb/lang/Nullable.class */
public @interface Nullable {
}
