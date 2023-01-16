package p001ch.qos.logback.core.spi;

import java.util.Iterator;
import p001ch.qos.logback.core.Appender;

/* renamed from: ch.qos.logback.core.spi.AppenderAttachable */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/AppenderAttachable.class */
public interface AppenderAttachable<E> {
    void addAppender(Appender<E> appender);

    Iterator<Appender<E>> iteratorForAppenders();

    Appender<E> getAppender(String str);

    boolean isAttached(Appender<E> appender);

    void detachAndStopAllAppenders();

    boolean detachAppender(Appender<E> appender);

    boolean detachAppender(String str);
}
