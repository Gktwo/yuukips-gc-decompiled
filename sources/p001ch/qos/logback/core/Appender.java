package p001ch.qos.logback.core;

import p001ch.qos.logback.core.spi.ContextAware;
import p001ch.qos.logback.core.spi.FilterAttachable;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.Appender */
/* loaded from: grasscutter.jar:ch/qos/logback/core/Appender.class */
public interface Appender<E> extends LifeCycle, ContextAware, FilterAttachable<E> {
    String getName();

    void doAppend(E e) throws LogbackException;

    void setName(String str);
}
