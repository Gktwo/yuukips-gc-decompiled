package p001ch.qos.logback.classic.turbo;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.turbo.MarkerFilter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/turbo/MarkerFilter.class */
public class MarkerFilter extends MatchingFilter {
    Marker markerToMatch;

    @Override // p001ch.qos.logback.classic.turbo.TurboFilter, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.markerToMatch != null) {
            start();
        } else {
            addError("The marker property must be set for [" + getName() + "]");
        }
    }

    @Override // p001ch.qos.logback.classic.turbo.TurboFilter
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        if (marker == null) {
            return this.onMismatch;
        }
        if (marker.contains(this.markerToMatch)) {
            return this.onMatch;
        }
        return this.onMismatch;
    }

    public void setMarker(String markerStr) {
        if (markerStr != null) {
            this.markerToMatch = MarkerFactory.getMarker(markerStr);
        }
    }
}
