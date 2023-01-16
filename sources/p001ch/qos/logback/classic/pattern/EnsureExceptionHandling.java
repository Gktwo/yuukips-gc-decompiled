package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.pattern.Converter;
import p001ch.qos.logback.core.pattern.ConverterUtil;
import p001ch.qos.logback.core.pattern.PostCompileProcessor;

/* renamed from: ch.qos.logback.classic.pattern.EnsureExceptionHandling */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/EnsureExceptionHandling.class */
public class EnsureExceptionHandling implements PostCompileProcessor<ILoggingEvent> {
    @Override // p001ch.qos.logback.core.pattern.PostCompileProcessor
    public void process(Context context, Converter<ILoggingEvent> head) {
        Converter<ILoggingEvent> exConverter;
        if (head == null) {
            throw new IllegalArgumentException("cannot process empty chain");
        } else if (!chainHandlesThrowable(head)) {
            Converter<ILoggingEvent> tail = ConverterUtil.findTail(head);
            if (((LoggerContext) context).isPackagingDataEnabled()) {
                exConverter = new ExtendedThrowableProxyConverter();
            } else {
                exConverter = new ThrowableProxyConverter();
            }
            tail.setNext(exConverter);
        }
    }

    public boolean chainHandlesThrowable(Converter<ILoggingEvent> head) {
        for (Converter<ILoggingEvent> c = head; c != null; c = c.getNext()) {
            if (c instanceof ThrowableHandlingConverter) {
                return true;
            }
        }
        return false;
    }
}
