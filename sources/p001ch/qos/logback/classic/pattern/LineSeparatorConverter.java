package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.classic.pattern.LineSeparatorConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/LineSeparatorConverter.class */
public class LineSeparatorConverter extends ClassicConverter {
    public String convert(ILoggingEvent event) {
        return CoreConstants.LINE_SEPARATOR;
    }
}
