package p001ch.qos.logback.core.sift;

import p001ch.qos.logback.core.Appender;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.joran.spi.JoranException;

/* renamed from: ch.qos.logback.core.sift.AppenderFactory */
/* loaded from: grasscutter.jar:ch/qos/logback/core/sift/AppenderFactory.class */
public interface AppenderFactory<E> {
    Appender<E> buildAppender(Context context, String str) throws JoranException;
}
