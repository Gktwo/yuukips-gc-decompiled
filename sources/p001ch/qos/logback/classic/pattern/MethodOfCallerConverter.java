package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.MethodOfCallerConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/MethodOfCallerConverter.class */
public class MethodOfCallerConverter extends ClassicConverter {
    public String convert(ILoggingEvent le) {
        StackTraceElement[] cda = le.getCallerData();
        if (cda == null || cda.length <= 0) {
            return "?";
        }
        return cda[0].getMethodName();
    }
}
