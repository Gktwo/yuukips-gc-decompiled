package p001ch.qos.logback.classic.boolex;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.boolex.EvaluationException;
import p001ch.qos.logback.core.boolex.EventEvaluatorBase;

/* renamed from: ch.qos.logback.classic.boolex.OnMarkerEvaluator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/boolex/OnMarkerEvaluator.class */
public class OnMarkerEvaluator extends EventEvaluatorBase<ILoggingEvent> {
    List<String> markerList = new ArrayList();

    public void addMarker(String markerStr) {
        this.markerList.add(markerStr);
    }

    public boolean evaluate(ILoggingEvent event) throws NullPointerException, EvaluationException {
        Marker eventsMarker = event.getMarker();
        if (eventsMarker == null) {
            return false;
        }
        for (String markerStr : this.markerList) {
            if (eventsMarker.contains(markerStr)) {
                return true;
            }
        }
        return false;
    }
}
