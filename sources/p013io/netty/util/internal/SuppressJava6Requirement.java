package p013io.netty.util.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* renamed from: io.netty.util.internal.SuppressJava6Requirement */
/* loaded from: grasscutter.jar:io/netty/util/internal/SuppressJava6Requirement.class */
public @interface SuppressJava6Requirement {
    String reason();
}
