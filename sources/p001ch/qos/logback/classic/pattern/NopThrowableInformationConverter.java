package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.NopThrowableInformationConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/NopThrowableInformationConverter.class */
public class NopThrowableInformationConverter extends ThrowableHandlingConverter {
    public String convert(ILoggingEvent event) {
        return "";
    }
}
