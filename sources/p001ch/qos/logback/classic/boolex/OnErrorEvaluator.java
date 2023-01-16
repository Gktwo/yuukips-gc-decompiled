package p001ch.qos.logback.classic.boolex;

import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.boolex.EvaluationException;
import p001ch.qos.logback.core.boolex.EventEvaluatorBase;

/* renamed from: ch.qos.logback.classic.boolex.OnErrorEvaluator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/boolex/OnErrorEvaluator.class */
public class OnErrorEvaluator extends EventEvaluatorBase<ILoggingEvent> {
    public boolean evaluate(ILoggingEvent event) throws NullPointerException, EvaluationException {
        return event.getLevel().levelInt >= 40000;
    }
}
