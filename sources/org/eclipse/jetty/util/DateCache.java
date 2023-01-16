package org.eclipse.jetty.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kcp.highway.Kcp;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/DateCache.class */
public class DateCache {
    public static final String DEFAULT_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";
    private final String _formatString;
    private final String _tzFormatString;
    private final DateTimeFormatter _tzFormat;
    private final Locale _locale;
    private final ZoneId _zoneId;
    private volatile Tick _tick;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/DateCache$Tick.class */
    public static class Tick {
        final long _seconds;
        final String _string;

        public Tick(long seconds, String string) {
            this._seconds = seconds;
            this._string = string;
        }
    }

    public DateCache() {
        this(DEFAULT_FORMAT);
    }

    public DateCache(String format) {
        this(format, (Locale) null, TimeZone.getDefault());
    }

    public DateCache(String format, Locale l) {
        this(format, l, TimeZone.getDefault());
    }

    public DateCache(String format, Locale l, String tz) {
        this(format, l, TimeZone.getTimeZone(tz));
    }

    public DateCache(String format, Locale l, TimeZone tz) {
        this._formatString = format;
        this._locale = l;
        int zIndex = this._formatString.indexOf("ZZZ");
        if (zIndex >= 0) {
            String ss1 = this._formatString.substring(0, zIndex);
            String ss2 = this._formatString.substring(zIndex + 3);
            int tzOffset = tz.getRawOffset();
            StringBuilder sb = new StringBuilder(this._formatString.length() + 10);
            sb.append(ss1);
            sb.append("'");
            if (tzOffset >= 0) {
                sb.append('+');
            } else {
                tzOffset = -tzOffset;
                sb.append('-');
            }
            int raw = tzOffset / Kcp.IKCP_RTO_MAX;
            int hr = raw / 60;
            int min = raw % 60;
            if (hr < 10) {
                sb.append('0');
            }
            sb.append(hr);
            if (min < 10) {
                sb.append('0');
            }
            sb.append(min);
            sb.append('\'');
            sb.append(ss2);
            this._tzFormatString = sb.toString();
        } else {
            this._tzFormatString = this._formatString;
        }
        if (this._locale != null) {
            this._tzFormat = DateTimeFormatter.ofPattern(this._tzFormatString, this._locale);
        } else {
            this._tzFormat = DateTimeFormatter.ofPattern(this._tzFormatString);
        }
        this._zoneId = tz.toZoneId();
        this._tzFormat.withZone(this._zoneId);
        this._tick = null;
    }

    public TimeZone getTimeZone() {
        return TimeZone.getTimeZone(this._zoneId);
    }

    public String format(Date inDate) {
        long seconds = inDate.getTime() / 1000;
        Tick tick = this._tick;
        if (tick == null || seconds != tick._seconds) {
            return ZonedDateTime.ofInstant(inDate.toInstant(), this._zoneId).format(this._tzFormat);
        }
        return tick._string;
    }

    public String format(long inDate) {
        long seconds = inDate / 1000;
        Tick tick = this._tick;
        if (tick == null || seconds != tick._seconds) {
            return ZonedDateTime.ofInstant(Instant.ofEpochMilli(inDate), this._zoneId).format(this._tzFormat);
        }
        return tick._string;
    }

    public String formatNow(long now) {
        long seconds = now / 1000;
        Tick tick = this._tick;
        if (tick == null || tick._seconds != seconds) {
            return formatTick(now)._string;
        }
        return tick._string;
    }

    public String now() {
        return formatNow(System.currentTimeMillis());
    }

    public Tick tick() {
        return formatTick(System.currentTimeMillis());
    }

    protected Tick formatTick(long now) {
        long seconds = now / 1000;
        Tick tick = this._tick;
        if (tick == null || tick._seconds != seconds) {
            this._tick = new Tick(seconds, ZonedDateTime.ofInstant(Instant.ofEpochMilli(now), this._zoneId).format(this._tzFormat));
            tick = this._tick;
        }
        return tick;
    }

    public String getFormatString() {
        return this._formatString;
    }
}
