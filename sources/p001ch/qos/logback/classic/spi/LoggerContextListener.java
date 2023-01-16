package p001ch.qos.logback.classic.spi;

import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.classic.LoggerContext;

/* renamed from: ch.qos.logback.classic.spi.LoggerContextListener */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/LoggerContextListener.class */
public interface LoggerContextListener {
    boolean isResetResistant();

    void onStart(LoggerContext loggerContext);

    void onReset(LoggerContext loggerContext);

    void onStop(LoggerContext loggerContext);

    void onLevelChange(Logger logger, Level level);
}
