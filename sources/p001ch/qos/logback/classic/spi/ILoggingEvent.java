package p001ch.qos.logback.classic.spi;

import java.util.Map;
import org.slf4j.Marker;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.core.spi.DeferredProcessingAware;

/* renamed from: ch.qos.logback.classic.spi.ILoggingEvent */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/ILoggingEvent.class */
public interface ILoggingEvent extends DeferredProcessingAware {
    String getThreadName();

    Level getLevel();

    String getMessage();

    Object[] getArgumentArray();

    String getFormattedMessage();

    String getLoggerName();

    LoggerContextVO getLoggerContextVO();

    IThrowableProxy getThrowableProxy();

    StackTraceElement[] getCallerData();

    boolean hasCallerData();

    Marker getMarker();

    Map<String, String> getMDCPropertyMap();

    Map<String, String> getMdc();

    long getTimeStamp();

    @Override // p001ch.qos.logback.core.spi.DeferredProcessingAware
    void prepareForDeferredProcessing();
}
