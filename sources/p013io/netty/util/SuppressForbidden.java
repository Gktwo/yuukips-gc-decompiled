package p013io.netty.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* renamed from: io.netty.util.SuppressForbidden */
/* loaded from: grasscutter.jar:io/netty/util/SuppressForbidden.class */
public @interface SuppressForbidden {
    String reason();
}
