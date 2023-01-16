package p001ch.qos.logback.core.rolling;

import java.io.File;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.rolling.TriggeringPolicy */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/TriggeringPolicy.class */
public interface TriggeringPolicy<E> extends LifeCycle {
    boolean isTriggeringEvent(File file, E e);
}
