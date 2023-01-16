package p001ch.qos.logback.classic.turbo;

import org.slf4j.MDC;
import org.slf4j.Marker;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.turbo.MDCFilter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/turbo/MDCFilter.class */
public class MDCFilter extends MatchingFilter {
    String MDCKey;
    String value;

    @Override // p001ch.qos.logback.classic.turbo.TurboFilter
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        if (this.MDCKey == null) {
            return FilterReply.NEUTRAL;
        }
        if (this.value.equals(MDC.get(this.MDCKey))) {
            return this.onMatch;
        }
        return this.onMismatch;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setMDCKey(String MDCKey) {
        this.MDCKey = MDCKey;
    }
}
