package p001ch.qos.logback.classic.spi;

import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.core.spi.ContextAware;

/* renamed from: ch.qos.logback.classic.spi.LoggerContextAware */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/LoggerContextAware.class */
public interface LoggerContextAware extends ContextAware {
    void setLoggerContext(LoggerContext loggerContext);
}
