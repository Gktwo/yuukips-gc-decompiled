package dev.morphia.annotations;

import dev.morphia.mapping.codec.BaseReferenceCodec;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
/* loaded from: grasscutter.jar:dev/morphia/annotations/Handler.class */
public @interface Handler {
    Class<? extends BaseReferenceCodec> value();
}
