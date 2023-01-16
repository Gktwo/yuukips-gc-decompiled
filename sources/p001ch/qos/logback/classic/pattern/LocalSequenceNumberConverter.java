package p001ch.qos.logback.classic.pattern;

import java.util.concurrent.atomic.AtomicLong;
import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.LocalSequenceNumberConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/LocalSequenceNumberConverter.class */
public class LocalSequenceNumberConverter extends ClassicConverter {
    AtomicLong sequenceNumber = new AtomicLong(System.currentTimeMillis());

    public String convert(ILoggingEvent event) {
        return Long.toString(this.sequenceNumber.getAndIncrement());
    }
}
