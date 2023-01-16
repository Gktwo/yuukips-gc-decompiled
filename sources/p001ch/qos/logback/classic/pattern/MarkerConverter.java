package p001ch.qos.logback.classic.pattern;

import org.slf4j.Marker;
import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.MarkerConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/MarkerConverter.class */
public class MarkerConverter extends ClassicConverter {
    private static String EMPTY = "";

    public String convert(ILoggingEvent le) {
        Marker marker = le.getMarker();
        if (marker == null) {
            return EMPTY;
        }
        return marker.toString();
    }
}
