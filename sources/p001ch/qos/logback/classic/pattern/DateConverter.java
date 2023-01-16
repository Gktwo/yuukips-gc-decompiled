package p001ch.qos.logback.classic.pattern;

import java.util.List;
import java.util.TimeZone;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.util.CachingDateFormatter;

/* renamed from: ch.qos.logback.classic.pattern.DateConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/DateConverter.class */
public class DateConverter extends ClassicConverter {
    long lastTimestamp = -1;
    String timestampStrCache = null;
    CachingDateFormatter cachingDateFormatter = null;

    @Override // p001ch.qos.logback.core.pattern.DynamicConverter, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        String datePattern = getFirstOption();
        if (datePattern == null) {
            datePattern = CoreConstants.ISO8601_PATTERN;
        }
        if (datePattern.equals(CoreConstants.ISO8601_STR)) {
            datePattern = CoreConstants.ISO8601_PATTERN;
        }
        try {
            this.cachingDateFormatter = new CachingDateFormatter(datePattern);
        } catch (IllegalArgumentException e) {
            addWarn("Could not instantiate SimpleDateFormat with pattern " + datePattern, e);
            this.cachingDateFormatter = new CachingDateFormatter(CoreConstants.ISO8601_PATTERN);
        }
        List<String> optionList = getOptionList();
        if (optionList != null && optionList.size() > 1) {
            this.cachingDateFormatter.setTimeZone(TimeZone.getTimeZone(optionList.get(1)));
        }
    }

    public String convert(ILoggingEvent le) {
        return this.cachingDateFormatter.format(le.getTimeStamp());
    }
}
