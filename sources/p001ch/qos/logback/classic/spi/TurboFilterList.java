package p001ch.qos.logback.classic.spi;

import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Marker;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.classic.turbo.TurboFilter;
import p001ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.spi.TurboFilterList */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/TurboFilterList.class */
public final class TurboFilterList extends CopyOnWriteArrayList<TurboFilter> {
    private static final long serialVersionUID = 1;

    public FilterReply getTurboFilterChainDecision(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        if (size() == 1) {
            try {
                return get(0).decide(marker, logger, level, format, params, t);
            } catch (IndexOutOfBoundsException e) {
                return FilterReply.NEUTRAL;
            }
        } else {
            for (Object obj : toArray()) {
                FilterReply r = ((TurboFilter) obj).decide(marker, logger, level, format, params, t);
                if (r == FilterReply.DENY || r == FilterReply.ACCEPT) {
                    return r;
                }
            }
            return FilterReply.NEUTRAL;
        }
    }
}
