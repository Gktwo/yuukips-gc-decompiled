package com.zaxxer.hikari.util;

import java.util.concurrent.TimeUnit;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p001ch.qos.logback.core.rolling.helper.DateTokenConverter;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/util/ClockSource.class */
public interface ClockSource {
    public static final ClockSource INSTANCE = Factory.create();
    public static final TimeUnit[] TIMEUNITS_DESCENDING = {TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES, TimeUnit.SECONDS, TimeUnit.MILLISECONDS, TimeUnit.MICROSECONDS, TimeUnit.NANOSECONDS};
    public static final String[] TIMEUNIT_DISPLAY_VALUES = {"ns", "µs", "ms", "s", ANSIConstants.ESC_END, "h", DateTokenConverter.CONVERTER_KEY};

    long currentTime();

    long toMillis(long j);

    long toNanos(long j);

    long elapsedMillis(long j);

    long elapsedMillis(long j, long j2);

    long elapsedNanos(long j);

    long elapsedNanos(long j, long j2);

    long plusMillis(long j, long j2);

    TimeUnit getSourceTimeUnit();

    String elapsedDisplayString(long j, long j2);

    /* loaded from: grasscutter.jar:com/zaxxer/hikari/util/ClockSource$Factory.class */
    public static class Factory {
        /* access modifiers changed from: private */
        public static ClockSource create() {
            if ("Mac OS X".equals(System.getProperty("os.name"))) {
                return new MillisecondClockSource();
            }
            return new NanosecondClockSource();
        }
    }

    /* loaded from: grasscutter.jar:com/zaxxer/hikari/util/ClockSource$MillisecondClockSource.class */
    public static final class MillisecondClockSource extends NanosecondClockSource {
        @Override // com.zaxxer.hikari.util.ClockSource.NanosecondClockSource, com.zaxxer.hikari.util.ClockSource
        public long currentTime() {
            return System.currentTimeMillis();
        }

        @Override // com.zaxxer.hikari.util.ClockSource.NanosecondClockSource, com.zaxxer.hikari.util.ClockSource
        public long elapsedMillis(long startTime) {
            return System.currentTimeMillis() - startTime;
        }

        @Override // com.zaxxer.hikari.util.ClockSource.NanosecondClockSource, com.zaxxer.hikari.util.ClockSource
        public long elapsedMillis(long startTime, long endTime) {
            return endTime - startTime;
        }

        @Override // com.zaxxer.hikari.util.ClockSource.NanosecondClockSource, com.zaxxer.hikari.util.ClockSource
        public long elapsedNanos(long startTime) {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis() - startTime);
        }

        @Override // com.zaxxer.hikari.util.ClockSource.NanosecondClockSource, com.zaxxer.hikari.util.ClockSource
        public long elapsedNanos(long startTime, long endTime) {
            return TimeUnit.MILLISECONDS.toNanos(endTime - startTime);
        }

        @Override // com.zaxxer.hikari.util.ClockSource.NanosecondClockSource, com.zaxxer.hikari.util.ClockSource
        public long toMillis(long time) {
            return time;
        }

        @Override // com.zaxxer.hikari.util.ClockSource.NanosecondClockSource, com.zaxxer.hikari.util.ClockSource
        public long toNanos(long time) {
            return TimeUnit.MILLISECONDS.toNanos(time);
        }

        @Override // com.zaxxer.hikari.util.ClockSource.NanosecondClockSource, com.zaxxer.hikari.util.ClockSource
        public long plusMillis(long time, long millis) {
            return time + millis;
        }

        @Override // com.zaxxer.hikari.util.ClockSource.NanosecondClockSource, com.zaxxer.hikari.util.ClockSource
        public TimeUnit getSourceTimeUnit() {
            return TimeUnit.MILLISECONDS;
        }
    }

    /* loaded from: grasscutter.jar:com/zaxxer/hikari/util/ClockSource$NanosecondClockSource.class */
    public static class NanosecondClockSource implements ClockSource {
        @Override // com.zaxxer.hikari.util.ClockSource
        public long currentTime() {
            return System.nanoTime();
        }

        @Override // com.zaxxer.hikari.util.ClockSource
        public long toMillis(long time) {
            return TimeUnit.NANOSECONDS.toMillis(time);
        }

        @Override // com.zaxxer.hikari.util.ClockSource
        public long toNanos(long time) {
            return time;
        }

        @Override // com.zaxxer.hikari.util.ClockSource
        public long elapsedMillis(long startTime) {
            return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
        }

        @Override // com.zaxxer.hikari.util.ClockSource
        public long elapsedMillis(long startTime, long endTime) {
            return TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        }

        @Override // com.zaxxer.hikari.util.ClockSource
        public long elapsedNanos(long startTime) {
            return System.nanoTime() - startTime;
        }

        @Override // com.zaxxer.hikari.util.ClockSource
        public long elapsedNanos(long startTime, long endTime) {
            return endTime - startTime;
        }

        @Override // com.zaxxer.hikari.util.ClockSource
        public long plusMillis(long time, long millis) {
            return time + TimeUnit.MILLISECONDS.toNanos(millis);
        }

        @Override // com.zaxxer.hikari.util.ClockSource
        public TimeUnit getSourceTimeUnit() {
            return TimeUnit.NANOSECONDS;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [long] */
        /* JADX WARN: Type inference failed for: r0v22, types: [long] */
        @Override // com.zaxxer.hikari.util.ClockSource
        public String elapsedDisplayString(long startTime, long endTime) {
            long elapsedNanos = elapsedNanos(startTime, endTime);
            StringBuilder sb = new StringBuilder(elapsedNanos < 0 ? "-" : "");
            char abs = Math.abs(elapsedNanos);
            TimeUnit[] timeUnitArr = TIMEUNITS_DESCENDING;
            for (TimeUnit unit : timeUnitArr) {
                long converted = unit.convert(abs, TimeUnit.NANOSECONDS);
                if (converted > 0) {
                    sb.append(converted).append(TIMEUNIT_DISPLAY_VALUES[unit.ordinal()]);
                    abs -= TimeUnit.NANOSECONDS.convert(converted, unit);
                }
            }
            return sb.toString();
        }
    }
}
