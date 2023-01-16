package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.LineOfCallerConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/LineOfCallerConverter.class */
public class LineOfCallerConverter extends ClassicConverter {
    public String convert(ILoggingEvent le) {
        StackTraceElement[] cda = le.getCallerData();
        if (cda == null || cda.length <= 0) {
            return "?";
        }
        return Integer.toString(cda[0].getLineNumber());
    }
}
