package p001ch.qos.logback.core.rolling;

import p001ch.qos.logback.core.rolling.helper.ArchiveRemover;
import p001ch.qos.logback.core.spi.ContextAware;

/* renamed from: ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicy */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/TimeBasedFileNamingAndTriggeringPolicy.class */
public interface TimeBasedFileNamingAndTriggeringPolicy<E> extends TriggeringPolicy<E>, ContextAware {
    void setTimeBasedRollingPolicy(TimeBasedRollingPolicy<E> timeBasedRollingPolicy);

    String getElapsedPeriodsFileName();

    String getCurrentPeriodsFileNameWithoutCompressionSuffix();

    ArchiveRemover getArchiveRemover();

    long getCurrentTime();

    void setCurrentTime(long j);
}
