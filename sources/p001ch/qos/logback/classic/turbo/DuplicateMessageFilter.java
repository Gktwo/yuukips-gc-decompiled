package p001ch.qos.logback.classic.turbo;

import org.slf4j.Marker;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.turbo.DuplicateMessageFilter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/turbo/DuplicateMessageFilter.class */
public class DuplicateMessageFilter extends TurboFilter {
    public static final int DEFAULT_CACHE_SIZE = 100;
    public static final int DEFAULT_ALLOWED_REPETITIONS = 5;
    public int allowedRepetitions = 5;
    public int cacheSize = 100;
    private LRUMessageCache msgCache;

    @Override // p001ch.qos.logback.classic.turbo.TurboFilter, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.msgCache = new LRUMessageCache(this.cacheSize);
        start();
    }

    @Override // p001ch.qos.logback.classic.turbo.TurboFilter, p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.msgCache.clear();
        this.msgCache = null;
        stop();
    }

    @Override // p001ch.qos.logback.classic.turbo.TurboFilter
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        if (this.msgCache.getMessageCountAndThenIncrement(format) <= this.allowedRepetitions) {
            return FilterReply.NEUTRAL;
        }
        return FilterReply.DENY;
    }

    public int getAllowedRepetitions() {
        return this.allowedRepetitions;
    }

    public void setAllowedRepetitions(int allowedRepetitions) {
        this.allowedRepetitions = allowedRepetitions;
    }

    public int getCacheSize() {
        return this.cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }
}
