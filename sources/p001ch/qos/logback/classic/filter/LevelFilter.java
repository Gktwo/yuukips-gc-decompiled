package p001ch.qos.logback.classic.filter;

import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.filter.AbstractMatcherFilter;
import p001ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.filter.LevelFilter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/filter/LevelFilter.class */
public class LevelFilter extends AbstractMatcherFilter<ILoggingEvent> {
    Level level;

    public FilterReply decide(ILoggingEvent event) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        if (event.getLevel().equals(this.level)) {
            return this.onMatch;
        }
        return this.onMismatch;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override // p001ch.qos.logback.core.filter.Filter, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.level != null) {
            start();
        }
    }
}
