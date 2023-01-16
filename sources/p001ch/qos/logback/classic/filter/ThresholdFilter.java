package p001ch.qos.logback.classic.filter;

import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.filter.Filter;
import p001ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.filter.ThresholdFilter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/filter/ThresholdFilter.class */
public class ThresholdFilter extends Filter<ILoggingEvent> {
    Level level;

    public FilterReply decide(ILoggingEvent event) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        if (event.getLevel().isGreaterOrEqual(this.level)) {
            return FilterReply.NEUTRAL;
        }
        return FilterReply.DENY;
    }

    public void setLevel(String level) {
        this.level = Level.toLevel(level);
    }

    @Override // p001ch.qos.logback.core.filter.Filter, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.level != null) {
            start();
        }
    }
}
