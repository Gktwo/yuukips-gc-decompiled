package p001ch.qos.logback.classic.boolex;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.boolex.IEvaluator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/boolex/IEvaluator.class */
public interface IEvaluator {
    boolean doEvaluate(ILoggingEvent iLoggingEvent);
}
