package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.ClassOfCallerConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/ClassOfCallerConverter.class */
public class ClassOfCallerConverter extends NamedConverter {
    @Override // p001ch.qos.logback.classic.pattern.NamedConverter
    protected String getFullyQualifiedName(ILoggingEvent event) {
        StackTraceElement[] cda = event.getCallerData();
        if (cda == null || cda.length <= 0) {
            return "?";
        }
        return cda[0].getClassName();
    }
}
