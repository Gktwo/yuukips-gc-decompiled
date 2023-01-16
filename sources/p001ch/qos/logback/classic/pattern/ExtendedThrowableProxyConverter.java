package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.classic.spi.StackTraceElementProxy;
import p001ch.qos.logback.classic.spi.ThrowableProxyUtil;

/* renamed from: ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/ExtendedThrowableProxyConverter.class */
public class ExtendedThrowableProxyConverter extends ThrowableProxyConverter {
    @Override // p001ch.qos.logback.classic.pattern.ThrowableProxyConverter
    protected void extraData(StringBuilder builder, StackTraceElementProxy step) {
        ThrowableProxyUtil.subjoinPackagingData(builder, step);
    }

    protected void prepareLoggingEvent(ILoggingEvent event) {
    }
}
