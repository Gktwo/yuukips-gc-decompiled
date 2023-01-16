package p001ch.qos.logback.core.joran.spi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: ch.qos.logback.core.joran.spi.NoAutoStart */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/NoAutoStart.class */
public @interface NoAutoStart {
}
